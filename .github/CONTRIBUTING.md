# How to Contribute

## Disclaimer ⚠️

First of all: **I do not expect any contributions from you**.  
In fact, **I prefer that you focus on your own projects** (_and if they are based on this one, I would be honored_).

However, **this repository is far from perfect**, so **any contribution is always welcome**.  
**I will try to maintain it _as much as I can_**, especially to keep dependency versions reasonably up to date (_with the help of Dependabot_).

## Get Your Own Branch 🌱

**This project is indeed a template**. I tried to make it **consist of only the bare essentials** so that anyone can start their own development from it.

However, **if you believe that an additional layer or feature would really add value** to the template, **you can create a PR** with your addition so that, **if accepted**, it becomes **available as a branch** of this repository for those who want to benefit from it.

In that case, **I will reference your branch in the [root README](../README.md)** so that others can see your version of the template.

Of course, **nothing prevents you from forking this project** so that you keep full control.

**The choice is yours**.

## How to Submit a PR 🛠️

1. **Pull the latest main branch** before creating your own branch.
2. **Create a clear branch name**, e.g., `feature/add-api-auth` or `fix/frontend-navbar`.
3. Make your changes **in small, logical commits**.
4. **Test your changes locally** (backend, frontend, database migrations, etc.).
5. **Submit your PR** to the main repository with a clear description of the changes.
6. If needed, **rebase or squash commits** for a clean history.

## Code Style / Linting 📏

- **Java / Spring**: follow IntelliJ / Spring conventions.
- **Vue.js / JS**: ESLint + Prettier.
- **Docker / YAML**: proper indentation and best practices.
- Always run the **linter/tests** before submitting a PR.

## Testing Your Changes ✅

- Make sure your **backend, frontend, and database** are all working as expected.
- Verify that your additions **do not break existing functionality**.

## Reporting Issues / Feature Requests 🐛💡

Even if you do not plan to contribute code, you can:

- **Open an issue** to report a bug.
- **Propose a new feature** or improvement.
- Use clear titles and descriptions to help maintainers understand the problem or suggestion.

## Security and Sensitive Data 🔒

- **Do NOT commit secrets** (passwords, JWT tokens, API keys, etc.).
- Use `.env[...].example` as a reference and create your own `.env[...]` if needed.
- Report any **security vulnerabilities** to the [issues labeled `security`](https://github.com/Marcompiler/spring-vue-postgres-keycloak-architecture/issues?q=is%3Aissue%20state%3Aopen%20label%3Asecurity).

## Documentation 📝

- Update the **README** or inline comments if your changes affect the architecture, configuration, or usage.
- Provide clear **instructions** if you add new features or endpoints.

## Branch Reference in README 🌿

- If your PR is accepted, your branch may be **referenced in the root README** so others can see it.
- This helps users **choose a branch** according to their needs or preferences.
