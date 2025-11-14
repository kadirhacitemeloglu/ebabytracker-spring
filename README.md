# eBabyTracker – Backend (Spring Boot)

eBabyTracker is a backend service designed to manage baby development and profile data. 
It exposes a RESTful API for creating, updating and querying baby records, and is built with a clean, extensible architecture suitable for evolving into a full production-grade system.

Currently, the project provides a fully functional **Baby** domain with complete CRUD operations, validation and H2 in-memory database integration.

---

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA (Hibernate)**
- **H2 Database (in-memory)**
- **Jakarta Validation (Bean Validation)**
- **Lombok**
- **Maven**

---

## 📂 Project Structure

The project follows a layered architecture to keep responsibilities clear and the codebase maintainable and extensible.

```text
src/main/java/com/kadir/ebabytracker/
│
├── baby
│   ├── controller       # REST controllers (BabyController)
│   ├── service          # Service interfaces (BabyService)
│   ├── serviceImpl      # Service implementations (BabyServiceImpl)
│   ├── repository       # Spring Data JPA repositories (BabyRepository)
│   ├── dto              # Request & Response DTOs (BabyCreateRequest, BabyUpdateRequest, BabyDto)
│   ├── model            # JPA entities (@Entity Baby)
│   └── enum             # Enum types (Gender)
│
└── common
    ├── exception        # Global / domain-specific exceptions (planned)
    └── util             # Shared utilities (planned)
```

This structure is aligned with common patterns used in modern Spring Boot backend services.

---

## 👶 Baby Domain

The **Baby** domain represents baby profiles managed by the system.

### Entity

The `Baby` entity is mapped to the `babies` table and contains:

- `id` (Long, primary key, auto-generated)
- `name` (String)
- `gender` (enum: `MALE`, `FEMALE`, `OTHER`)
- `birthDay` (LocalDate)
- `weight` (Double)
- `height` (Double)
- `notes` (String, optional)

The entity is persisted via Spring Data JPA and Hibernate.

---

## 🧪 REST API – Baby Endpoints

Base path for the Baby API:

```text
/ api/babies
```

### 1. Create Baby

**Endpoint**

```http
POST /api/babies
Content-Type: application/json
```

**Request Body (example)**

```json
{
  "name": "Name",
  "gender": "FEMALE",
  "notes": "First baby",
  "birthDay": "2024-11-11",
  "weight": 9.5,
  "height": 75.0
}
```

**Response**

- `201` / `200` with `BabyDto` as JSON
- `400 Bad Request` on validation errors

---

### 2. Get All Babies

```http
GET /api/babies
```

**Response**

- `200 OK`
- JSON array of `BabyDto` objects

---

### 3. Get Baby by ID

```http
GET /api/babies/{id}
```

**Response**

- `200 OK` with `BabyDto` if found
- `404 Not Found` (planned: via custom exception + global handler)

---

### 4. Update Baby (PUT)

```http
PUT /api/babies/{id}
Content-Type: application/json
```

**Request Body (example – full update)**

```json
{
  "name": "Name Updated",
  "gender": "FEMALE",
  "notes": "Updated notes",
  "birthDay": "2024-11-11",
  "weight": 10.2,
  "height": 76.0
}
```

**Response**

- `200 OK` with updated `BabyDto`

This endpoint is implemented as a **full update (PUT)**: all fields are expected and overwritten.

---

### 5. Delete Baby

```http
DELETE /api/babies/{id}
```

**Response**

- `204 No Content` on successful deletion

---

## 🧱 Validation

Validation is implemented using **Jakarta Bean Validation** annotations on DTOs, combined with `@Valid` in controller methods.

Examples used in `BabyCreateRequest`:

- `@NotBlank` for `name`
- `@NotNull` for `gender`
- `@NotNull` + `@Past` for `birthDay`
- `@Positive` for numeric fields such as `weight` and `height`

Invalid requests produce a `400 Bad Request` response with detailed error messages.

---

## 🗄️ Database (H2 In-Memory)

The application uses **H2 in-memory database** for local development and testing.

- JDBC URL: `jdbc:h2:mem:ebabydb`
- H2 Console: `http://localhost:8080/h2-console`

Tables are created automatically by Hibernate at startup.

---

## ▶️ Running the Application

1. Clone the repository:

```bash
git clone https://github.com/<your-username>/ebabytracker.git
cd ebabytracker
```

2. Build and run with Maven:

```bash
mvn spring-boot:run
```

3. The application will be available at:

```text
http://localhost:8080
```

4. Use an API client (Postman, Insomnia, curl, etc.) to interact with the endpoints under `/api/babies`.

---

## 🧭 Roadmap

Planned enhancements:

- `Parent` (User) entity for application users (parents/guardians)
- Relationship: `Parent` (User) **1 → N** `Baby` (ManyToOne from Baby side)
- Global exception handling with `@ControllerAdvice` and standardized error responses
- Additional domains:
  - `Feeding` (feeding logs)
  - `Vaccination` (vaccination schedule & records)
  - `Growth` (height/weight history)
- Authentication / authorization layer
- Pagination and filtering for list endpoints
- API documentation via Swagger / OpenAPI

---

## 📌 Overview

eBabyTracker aims to provide a solid backend foundation for a baby tracking platform, with a focus on:

- Clean, layered architecture
- Clear separation between API, business logic and persistence
- DTO-based request/response models
- Validation and consistent data handling

The current state already demonstrates a complete, production-style CRUD workflow for the Baby domain and is ready to be extended with additional features and modules.