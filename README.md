# Foro Hub

Foro Hub es un proyecto desarrollado como parte del Challenge Back End de Alura. Este proyecto consiste en la creación de una API REST utilizando Spring Boot para gestionar los tópicos de un foro. La API permite realizar operaciones CRUD sobre los tópicos y cuenta con funcionalidades adicionales como autenticación, validaciones y persistencia de datos en una base de datos MySQL.

## Características principales

- **Operaciones CRUD**: Crear, leer, actualizar y eliminar tópicos.
- **Validaciones**: Verificación de datos de entrada según reglas de negocio.
- **Autenticación**: Seguridad implementada con Spring Security.
- **Persistencia de datos**: Almacenamiento de datos en una base de datos MySQL.
- **Migraciones de base de datos**: Uso de Flyway para gestionar la estructura de la base de datos.

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Maven**
- **MySQL**
- **Flyway Migration**
- **Spring Security**
- **Lombok**
- **Spring Data JPA**
- **Spring Web**

## Requisitos previos

- Tener instalado:
  - JDK 21
  - MySQL
  - Maven
- Configurar una base de datos MySQL llamada `foro_hub`.
- Configurar las credenciales de acceso a la base de datos en el archivo `application.properties`.

## Configuración inicial

1. Clona este repositorio:

   ```bash
   git clone https://github.com/Ssjeison/ForoHubAlura.git
   ```

2. Accede al directorio del proyecto:

   ```bash
   cd ForoHubAlura
   ```

3. Configura las credenciales de la base de datos en `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=none
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

   spring.flyway.enabled=true
   spring.flyway.locations=classpath:db/migration
   ```

4. Crea la base de datos en MySQL:

   ```sql
   CREATE DATABASE foro_hub;
   ```

5. Ejecuta las migraciones con Flyway al iniciar la aplicación.

## Ejecución del proyecto

1. Abre el proyecto en IntelliJ IDEA.
2. Ejecuta la clase principal `ForoHubAluraApplication`.
3. Accede a la API en `http://localhost:8080`.

## Endpoints de la API

### Tópicos

#### Obtener todos los tópicos

- **GET** `/topicos`

#### Obtener un tópico por ID

- **GET** `/topicos/{id}`

#### Crear un nuevo tópico

- **POST** `/topicos`
- **Body JSON**:
  ```json
  {
    "titulo": "Ejemplo de título",
    "mensaje": "Este es un mensaje de ejemplo",
    "status": "ABIERTO",
    "autor": "Autor Ejemplo",
    "curso": "Curso Ejemplo"
  }
  ```

#### Actualizar un tópico

- **PUT** `/topicos/{id}`
- **Body JSON**:
  ```json
  {
    "titulo": "Título actualizado",
    "mensaje": "Mensaje actualizado",
    "status": "CERRADO",
    "autor": "Autor Actualizado",
    "curso": "Curso Actualizado"
  }
  ```

#### Eliminar un tópico

- **DELETE** `/topicos/{id}`

## Seguridad

La aplicación utiliza Spring Security para la autenticación. Actualmente, todas las rutas están configuradas para permitir acceso sin restricciones, pero esto se puede ajustar en la clase `SecurityConfig`.

## Estructura del proyecto

```
ForoHubAlura
├── src
│   ├── main
│   │   ├── java/com/ssjeison/ForoHubAlura
│   │   │   ├── controller
│   │   │   ├── model
│   │   │   ├── repository
│   │   │   ├── service
│   │   │   ├── security
│   │   │   └── ForoHubAluraApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── db/migration
├── .gitignore
├── pom.xml
└── README.md
```

## Autor

Este proyecto fue desarrollado por [Ssjeison](https://github.com/Ssjeison) como parte del Challenge Back End de Alura.

## Licencia

Este proyecto está bajo la licencia MIT. Puedes ver el archivo [LICENSE](LICENSE) para más detalles.
