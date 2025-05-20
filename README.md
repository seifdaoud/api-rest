
<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.3.x-brightgreen" alt="Spring&nbsp;Boot">
  <img src="https://img.shields.io/badge/Java-17-blue"                alt="Java&nbsp;17">
  <img src="https://img.shields.io/github/actions/workflow/status/<TON-USER>/api-rest-best-practices/build.yml?label=CI" alt="CI">
  <img src="https://img.shields.io/badge/License-MIT-yellow"          alt="MIT">
</p>

# ⚡ API RESTful – Best Practices (Spring Boot 3)

Une implémentation **opinionated** d’API Java 17 mettant en avant les bonnes pratiques :  
validation, DTO, mapping, sécurisation, documentation OpenAPI, tests, CI, conteneurisation.

---

## ✨ Fonctionnalités clés

| ✅ | Détail |
|----|--------|
| Validation d’entrées          | `jakarta.validation`, messages personnalisés |
| DTO & Mapper                  | `record` Java 17, mapper manuel (pas de Lombok) |
| Gestion d’erreurs             | `@ControllerAdvice` + format RFC 7807 (`ApiError`) |
| Documentation                 | Swagger UI / OpenAPI 3 auto-générée |
| Sécurité                      | Spring Security (Basic Auth in-memory) |
| Observabilité                 | Actuator (`/health`, `/info`, `/prometheus`) |
| Tests                         | Unitaires (Mockito) & intégration (MockMvc) |
| Couverture                    | Jacoco avec rapport HTML |
| CI/CD                         | GitHub Actions (JDK 17 & 21) |
| Conteneurisation              | `docker-compose` (PostgreSQL) |

---

## 📂 Structure du projet

```
├── src/main/java/com/github/seif/apirest
│   ├── advice/          # GlobalExceptionHandler
│   ├── config/          # CORS, Security, Swagger
│   ├── controller/      # REST controllers
│   ├── dto/             # Record DTOs
│   ├── entity/          # JPA entities
│   ├── error/           # ApiError (RFC 7807)
│   ├── mapper/          # Manual mappers
│   ├── repository/      # Spring Data JPA
│   ├── service/         # Business layer
│   └── ApiRestApplication.java
├── src/test/java/com/github/seif/apirest
│   ├── controller/      # Integration tests (MockMvc)
│   └── service/         # Unit tests (Mockito)
├── src/main/resources
│   └── application.yml  # Config multi-profils
└── docker-compose.yml   # BDD PostgreSQL (optionnel)
```

---

## 🚀 Démarrage rapide

### Profil **dev** (H2 in-memory)

```bash
mvn spring-boot:run
open http://localhost:8080/swagger-ui.html
```

### Profil **prod** (PostgreSQL via Docker)

```bash
docker compose up -d
SPRING_PROFILES_ACTIVE=prod mvn spring-boot:run
```

---

## 🔌 Endpoints principaux

| Méthode | URI                | Description                    |
|---------|--------------------|--------------------------------|
| POST    | /api/users         | Créer un utilisateur           |
| GET     | /api/users/{id}    | Récupérer un utilisateur       |
| GET     | /api/users         | Liste paginée des utilisateurs |
| GET     | /actuator/health   | Liveness probe (public)        |
| GET     | /swagger-ui.html   | Documentation interactive      |

> Auth : Basic (user/password)

---

## 🧪 Tests

```bash
mvn clean verify
# rapport : target/site/jacoco/index.html
```

---

## ⚙️ CI GitHub Actions

Workflow : build sur push/PR, JDK 17 & 21, étapes checkout → setup-java → mvn verify.

---

## 📈 Aller plus loin

* Flyway : versionner le schéma SQL.
* Testcontainers : Postgres jetable pour les IT.
* SonarCloud : quality gate.
* Dockerfile : image autonome (Jib ou Buildpacks).
* JWT : remplacer Basic Auth par JWT.

---

## 🤝 Licence

MIT © 2025 – Seif Daoud
