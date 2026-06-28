# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v1.1.0] - 2026-06-28 - Frontend improvements and backend/sso fixes

### Added

- [`AdminView.vue`](./frontend/app/src/views/AdminView.vue) : **View for admin users**. Containing API calls restricted to admin users.
- [`ForbiddenView.vue`](./frontend/app/src/views/ForbiddenView.vue) : **View for handling denied access**. Used when the user is authenticated but not authorized to access the requested resource.
- [`UserView.vue`](./frontend/app/src/views/UserView.vue) : **View for regular users**. Containing API calls restricted to authenticated users.
- **API answers are now displayed** with a **green** color to indicate **success**, and with a **red** color to indicate **failure**.

### Changed

- [`index.js`](./frontend/app/src/router/index.js) :
  - **Authentication is no more required to access some views**, such as "Home" and "About".
  - The `requiresAuth` meta property is now used to determine **if a route requires authentication**.
  - The `roles` meta property is now used to specify **roles for authenticated users accessing the views** that require authentication.
- [`keycloak.js`](./frontend/app/src/config/keycloak.js) and [`backend.js`](./frontend/app/src/config/backend.js) config files moved to a new frontend directory (`config`).
- Use of `ResponseEntity` instead of `Optional` in the backend controllers to return responses with a more appropriate status code. These are as follows :
  - [`HelloWorldController.java`](./backend/app/src/main/java/com/marcompiler/backend/helloworld/HelloWorldController.java)
  - [`MyUserController.java`](./backend/app/src/main/java/com/marcompiler/backend/users/MyUserController.java)
  - [`PublicController.java`](./backend/app/src/main/java/com/marcompiler/backend/publics/PublicController.java)

### Fixed

- The client role "`demo:write:users`" has been removed from `demo-users` group in the SSO.

## [v1.0.6] - 2026-06-27 - Corrections and dependencies

### Fixed

- [`MyUser.java`](./backend/app/src/main/java/com/marcompiler/backend/users/MyUser.java) : Wrong ID returned in "MyUser.getId" fixed.

### Changed

- The formatting of the **SSO README files** has been **corrected**, and the **"Clients" section** has been **completed**.
- Upgrade dependencies :
  - backend :
    - `Spring`                4.1.0
  - frontend :
    - `@eslint/js`           9.39.4
    - `@vitejs/plugin-vue`    5.2.4
    - `eslint`               9.39.4
    - `eslint-plugin-vue`    10.9.2
    - `globals`              16.5.0
    - `prettier`              3.8.5
    - `vite`                  6.4.3
    - `vue-router`            4.6.4
- Added titles to the changelog versions.

### Security

- **Upgrade dependencies** to address numerous **CVE vulnerabilities** on the **frontend/backend**.

## [v1.0.5] - 2026-03-01 - Spring 4.0 + .gitignore completions + frontend dependencies

### Changed

- `.gitignore` files :
  - **IDE-related elements have been moved from the backend to the project root** so that you can open the project with IntelliJ, Eclipse, Netbeans, VSCodium, etc. directly from the root.
    - For example, I use IntelliJ to run and develop the backend and I use VSCodium for everything else.
  - **Complete** the backend `.gitignore` files in accordance **with [IntelliJ recommendations](https://intellij-support.jetbrains.com/hc/en-us/articles/206544839-How-to-manage-projects-under-Version-Control-Systems)**.
- Upgrade dependencies: `spring-boot-starter-parent` 4.0.3.
  - Major version implies **breaking changes** so check out their [migration guide](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Migration-Guide).
  - **Corresponding adjustements** have been applied in backend.
  - Updated **to keep up with the latest developments**, but also because it **fixes numerous security issues** in previous versions (*since 3.5.7*).
- *A harmless renaming of an iml file...*

### Security

- Upgrade dependencies: `rollup` 4.59.0 by [@dependabot](https://github.com/dependabot) (#5).
- Upgrade dependencies: `minimatch` 3.1.3 by [@dependabot](https://github.com/dependabot) (#6).

### Removed

- Backend `.idea` : removed to avoid confusion regarding opening the project with IntelliJ IDEA only from the backend directory, thus encouraging opening it from the project root.

## [v1.0.4] - 2025-11-16 - Dependencies

### Changed

- Upgrade dependencies: `postgres (database)` 18.
- Upgrade dependencies: `postgres (keycloak)` 18.
- Upgrade dependencies: `keycloak` 26.4.
- Dependencies: `adminer (keycloak)` specified to version 5.

### Security

- Upgrade dependencies: `js-yaml` 4.1.1 by [@dependabot](https://github.com/dependabot) (#4).

## [v1.0.3] - 2025-10-27 - Fixes and dependencies

### Changed

- Downgrade dependencies: Java 21 (*more stable for now...*).
- Changelog: previous "Changed" sections renamed to "Security" (*dependabot only intervenes here for security purposes*).

### Fixed

- Commands "podman-compose" renamed to "podman compose" in READMEs with the detached parameter.

### Security

- Upgrade dependencies: `spring-boot-starter-parent` 3.5.7 (*security update for [CVE-2025-11226](https://www.mend.io/vulnerability-database/CVE-2025-11226) in JPA*).

## [v1.0.2] - 2025-10-23 - Dependencies

### Security

- Upgrade dependencies: `vite` 6.4.1 by [@dependabot](https://github.com/dependabot) (#3).

## [v1.0.1] - 2025-09-11 - Changelog + Dependencies

### Added

- This cute changelog. Say hello.

### Security

- Upgrade dependencies: `vite` 6.3.6 by [@dependabot](https://github.com/dependabot) (#2).

## [v1.0.0] - 2025-09-07 - First stable release

### Added

- First stable state of all elements of the architecture has been added.
- READMEs everywhere with translations EN/FR.
- CODE_OF_CONDUCT.md added.
- CONTRIBUTING(.fr).md added.
- SECURITY(.fr).md added.
- LICENSE added.
- DEV_JOURNEY(.fr).md added.

[v1.1.0]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.6...v1.1.0
[v1.0.6]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.5...v1.0.6
[v1.0.5]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.4...v1.0.5
[v1.0.4]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.3...v1.0.4
[v1.0.3]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.2...v1.0.3
[v1.0.2]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.1...v1.0.2
[v1.0.1]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.0...v1.0.1
[v1.0.0]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/releases/tag/v1.0.0
