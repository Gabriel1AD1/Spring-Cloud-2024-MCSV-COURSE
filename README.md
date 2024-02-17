# Microservicio de Curso

Este microservicio maneja operaciones relacionadas con cursos, incluyendo la creación, actualización, eliminación y recuperación de información de cursos. Utiliza Spring Boot y se comunica con otros microservicios para gestionar la asignación y creación de usuarios.

## Endpoints de la API

### 1. Listar Cursos

**Endpoint:** `GET /`

Devuelve una lista de todos los cursos almacenados en el sistema.
![image](https://github.com/Gabriel1AD1/Spring-Cloud-2024-MCSV-COURSE/assets/119640932/a712f368-596e-4092-be57-18cfa6b6e7af)


### 2. Detalle de Curso

**Endpoint:** `GET /{id}`

Devuelve los detalles de un curso específico según su ID.
![image](https://github.com/Gabriel1AD1/Spring-Cloud-2024-MCSV-COURSE/assets/119640932/4d67870c-5c97-4ca9-9e28-8c0db7dbe550)


### 3. Crear Curso

**Endpoint:** `POST /`

Crea un nuevo curso y lo guarda en el sistema.
![image](https://github.com/Gabriel1AD1/Spring-Cloud-2024-MCSV-COURSE/assets/119640932/08854b87-1378-447f-8488-592735ed5c11)

### 4. Editar Curso

**Endpoint:** `PUT /{id}`

Actualiza la información de un curso existente según su ID.
![image](https://github.com/Gabriel1AD1/Spring-Cloud-2024-MCSV-COURSE/assets/119640932/a29d415c-b099-4d94-8c96-97bcc3b4ca29)


### 5. Eliminar Curso

**Endpoint:** `DELETE /{id}`

Elimina un curso según su ID.

![image](https://github.com/Gabriel1AD1/Spring-Cloud-2024-MCSV-COURSE/assets/119640932/291a0452-cdd6-45c5-8225-4d4106d12a3e)


### 6. Asignar Usuario a Curso

**Endpoint:** `PUT /assign-user/{idCourse}`

Asigna un usuario existente a un curso específico.

### 7. Crear Usuario en Curso

**Endpoint:** `POST /create-user/{idCourse}`

Crea un nuevo usuario y lo asigna a un curso específico.

### 8. Eliminar Usuario de Curso

**Endpoint:** `DELETE /delete-user/{idCourse}`

Elimina un usuario de un curso específico.

## Configuración

### 1. Configuración de la Aplicación

```properties
spring.application.name=microservice-course
server.port=8002
```

## Tecnologías Utilizadas

Este microservicio utiliza diversas tecnologías y frameworks para su implementación:

- **Spring Boot:** Framework de aplicación de Java para crear servicios basados en Spring.
- **Spring Cloud OpenFeign:** Cliente declarativo para realizar llamadas REST en servicios.
- **Spring Web:** Módulo de Spring para el desarrollo de aplicaciones web.
- **Spring Data JPA:** Parte del proyecto Spring Data, proporciona un modelo de programación basado en Spring y Hibernate.
- **Spring Boot DevTools:** Herramientas de desarrollo para mejorar la productividad durante el desarrollo de aplicaciones Spring Boot.

## Referencias Adicionales

Para obtener más información sobre el uso de estas tecnologías, consulta las siguientes secciones de documentación:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html): Guía oficial de Apache Maven.
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/html/): Referencia del plugin Maven para Spring Boot.
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-image): Guía para crear una imagen de contenedor OCI con Spring Boot.
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference): Documentación para el módulo Spring Data JPA.
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.development-tools): Documentación sobre el uso de las herramientas de desarrollo de Spring Boot.
- [OpenFeign](https://spring.io/projects/spring-cloud-openfeign): Documentación oficial para Spring Cloud OpenFeign.
- [Validation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-config-validation): Documentación para la validación en Spring Web.
