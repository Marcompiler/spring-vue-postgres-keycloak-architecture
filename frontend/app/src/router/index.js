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
      component: () => import('@/views/AboutView.vue'),
      meta: {
        requiresAuth: true
      }
    },
  ],
})

router.beforeEach(async (to) => {
  // no auth required, continue
  if (!to.meta.requiresAuth) {
    return true
  }

  // already authenticated, no need to log in again
  if (keycloak.authenticated) {
    return true
  }

  // otherwise, redirect to login page
  await keycloak.login({
    redirectUri: window.location.origin + to.fullPath
  })

  return false
})

export default router
