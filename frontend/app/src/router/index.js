import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import keycloak from '@/config/keycloak.js'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/AboutView.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('@/views/AdminView.vue'),
      meta: {
        requiresAuth: true,
        roles: ['demo:read:users', 'demo:write:users']
      }
    },
    {
      path: '/user',
      name: 'user',
      component: () => import('@/views/UserView.vue'),
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/forbidden',
      name: 'forbidden',
      component: () => import('@/views/ForbiddenView.vue')
    }
  ],
})

router.beforeEach(async (to) => {
  // no auth required, continue
  if (!to.meta.requiresAuth) {
    return true
  }

  // not authenticated, login
  if (!keycloak.authenticated) {
    await keycloak.login({
      redirectUri: window.location.origin + to.fullPath
    })
    return false
  }

  // role check if any
  const requiredRoles = to.meta.roles

  if (requiredRoles && requiredRoles.length > 0) {
    const hasRole = requiredRoles.every(role => // Use "some" instead of "every" to check if ANY role is present
      keycloak.hasRealmRole(role) || keycloak.hasResourceRole(role)
    )

    if (!hasRole) {
      return '/forbidden' // Forbidden access, redirect
    }
  }

  return true
})

export default router
