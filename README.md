# Proyecto: Práctica de Autenticación y Token JWT

Este proyecto es una implementación básica de autenticación en una API REST utilizando **Spring Boot 3** y **JWT (JSON Web Token)** para la gestión de sesiones seguras. Es una aplicación de ejemplo que permite registrar usuarios, iniciar sesión y acceder a recursos protegidos.

---

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3
- Spring Security
- JWT (JSON Web Tokens)
- MySQL
- Lombok

---

## Características
- **Registro de usuarios**: Permite registrar usuarios con nombre de usuario y contraseña.
- **Autenticación basada en JWT**: Los usuarios pueden iniciar sesión para recibir un token JWT.
- **Autorización con JWT**: Los endpoints protegidos requieren un token JWT válido.
- **Acceso a recursos protegidos**: Acceso a la lista de estudiantes solo después de autenticarse.

---

## Endpoints

### Registro de Usuario
**POST** `/register`

Ejemplo de cuerpo de solicitud:
```json
{
  "id": 3,
  "username": "poper",
  "password": "p@123"
}
```

### Inicio de Sesión
**POST** `/login`

Ejemplo de cuerpo de solicitud:
```json
{
  "username": "poper",
  "password": "p@123"
}
```
Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
}
```

### Obtener Lista de Estudiantes
**GET** `/students`

**Requiere Autorización con JWT**: Enviar el token en el encabezado:
```
Authorization: Bearer <token>
```

---

## Configuración de Seguridad
El archivo `SecurityConfig.java` define las reglas de seguridad y configura `UserDetailsService` para cargar usuarios desde la base de datos.

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
}
```

---

## Estructura de Base de Datos
Tabla `users`:
- `id` (INT, PRIMARY KEY)
- `username` (VARCHAR)
- `password` (VARCHAR)

---

## Pasos para Ejecutar el Proyecto

1. Clonar el repositorio desde GitHub.
2. Configurar una base de datos MySQL y actualizar el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_datos
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Ejecutar la aplicación.

---

## Mejoras Futuras
- Implementar encriptación de contraseñas más robusta con BCrypt.
- Agregar roles de usuario para diferentes niveles de acceso.
- Mejorar el manejo de errores para respuestas más claras.

---

Este proyecto es ideal para aprender cómo manejar seguridad en APIs REST. Si te resulta útil, no olvides darle una estrella ⭐ en GitHub.

