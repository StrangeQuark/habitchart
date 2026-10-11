# HabitChart Backend

Spring Boot backend for HabitChart. The current backend intentionally stays small: it exposes public health/config endpoints and is ready for future anonymous telemetry, push subscription, or sync APIs.

## Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Actuator
- Maven

## Local Development

```bash
./mvnw spring-boot:run
```

The backend runs on `http://localhost:8080`.

## Endpoints

- `GET /api/habitchart/health`
- `GET /api/habitchart/config`
- `GET /actuator/health`

## Tests

```bash
./mvnw test
```

## Docker

```bash
docker build -t habitchart-backend .
docker run --rm -p 8080:8080 habitchart-backend
```

## License

This project is licensed under the GNU General Public License. See `LICENSE` for details.
