# HTM Maker — Hazard Traceability Matrix Application

A Spring Boot backend for managing **medical device risk analysis** according to **ISO 14971**, built to replace the Excel spreadsheets that most companies still use for their Hazard Traceability Matrix (HTM).

> Built by an engineer who spent years doing risk analysis in the medical device industry — this is the tool I wished I had.

---

## Why this project exists

Risk management under ISO 14971 requires tracing every hazard through hazardous situations, harms, risk evaluations, and risk control measures — before and after mitigation. In practice, nearly every company maintains this traceability in Excel. That approach is error-prone, hard to review, painful to keep consistent across document versions, and offers no access control or audit trail.

HTM Maker is a web application backend that models this process properly: structured risk entities, automatic recalculation of risk values when severity or probability changes, and multi-user collaboration with organizations, projects, and role-based permissions.

While designed around medical device risk analysis, the same principles apply to risk management in any regulated industry.

## Current status

**Work in progress.** The foundation layer is functional; the risk domain layer is designed and under implementation.

| Layer | Status |
|---|---|
| User, organization & project management | ✅ Implemented |
| Authentication & role-based authorization (Spring Security) | ✅ Implemented |
| CSRF protection & CORS configuration for SPA frontend | ✅ Implemented |
| BDD test suite (Cucumber feature files) | ✅ Implemented |
| ISO 14971 risk domain model (Risk, Harm, RCM, risk values pre/post-control) | 🔧 Designed, in progress |

## Tech stack

- **Java / Spring Boot** — REST API
- **Spring Security** — session-based auth, role-based access (Admin/User), CSRF token handling for SPA clients
- **Spring Data JPA** — SQLite for development, PostgreSQL-ready configuration
- **Cucumber (BDD)** — executable specifications as Gherkin feature files
- **Maven** — build and dependency management

## Domain model (risk layer)

The core of ISO 14971 risk analysis, modeled as entities:

```
Risk
├── scenario & hazardous situation
├── Harm (determines severity) — before mitigation
├── Probability of occurrence — before mitigation
├── RiskValue — calculated from severity × probability
├── Risk Control Measures (RCMs) + rationale
├── Harm / probability / RiskValue — after mitigation
└── completion status
```

When a harm or probability changes, the associated risk value must be re-evaluated — the application enforces this consistency instead of relying on spreadsheet discipline.

## API overview

| Area | Base path | Examples |
|---|---|---|
| Users | `/api/user` | create user, query by email/username |
| Organizations | `/api/organization` | create (Admin role required), query |
| User roles | `/api/userRole` | role assignment per project |
| Version | `/version` | application version info |

Authentication endpoints issue CSRF tokens for the frontend (designed for a React SPA on `localhost:3000`).

## Testing — BDD with Cucumber

Behavior is specified in Gherkin feature files and executed against a running Spring context:

```
src/test/resources/features/
├── f_001_version.feature
├── f_002_User.feature
├── f_003_email.feature
├── f_004_Organization.feature
└── f_005_project.feature
```

Run the test suite:

```bash
./mvnw test
```

## Getting started

```bash
git clone https://github.com/AdmWinther/HTM.git
cd HTM
./mvnw spring-boot:run
```

The application starts with an SQLite database by default. A PostgreSQL configuration template is provided in `src/main/resources/application_properties_Hotplate.txt` — copy it to `application.properties` and fill in your connection details (the real `application.properties` is git-ignored to keep credentials out of version control).

## Roadmap

- Complete the risk entity layer (Risk, Harm, RCM persistence and services)
- Risk value calculation engine with configurable severity/probability matrices
- Traceability report export
- React frontend
