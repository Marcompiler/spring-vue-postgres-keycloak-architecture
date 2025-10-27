# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v1.0.3] - 2025-10-27

### Changed

- Downgrade dependencies: Java 21 (*more stable for now...*).
- Changelog: previous "Changed" sections renamed to "Security" (*dependabot only intervenes here for security purposes*).

### Fixed

- Commands "podman-compose" renamed to "podman compose" in READMEs with the detached parameter.

### Security

- Upgrade dependencies: `spring-boot-starter-parent` 3.5.7 (*security update for [CVE-2025-11226](https://www.mend.io/vulnerability-database/CVE-2025-11226) in JPA*).

## [v1.0.2] - 2025-10-23

### Security

- Upgrade dependencies: `vite` 6.4.1 by [@dependabot](https://github.com/dependabot) (#3).

## [v1.0.1] - 2025-09-11

### Added

- This cute changelog. Say hello.

### Security

- Upgrade dependencies: `vite` 6.3.6 by [@dependabot](https://github.com/dependabot) (#2).

## [v1.0.0] - 2025-09-07

### Added

- First stable state of all elements of the architecture has been added.
- READMEs everywhere with translations EN/FR.
- CODE_OF_CONDUCT.md added.
- CONTRIBUTING(.fr).md added.
- SECURITY(.fr).md added.
- LICENSE added.
- DEV_JOURNEY(.fr).md added.

[v1.0.3]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.2...v1.0.3
[v1.0.2]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.1...v1.0.2
[v1.0.1]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/compare/v1.0.0...v1.0.1
[v1.0.0]: https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/releases/tag/v1.0.0
