# **Arquitectura del proyecto**
El presente documento describe la arquitectura del proyecto **ApiTask**, con el objetivo de facilitar su comprensión y correcto uso. Se abordarán aspectos clave como la estandarización de atributos, métodos, funciones, clases, interfaces e implementaciones.

Para acceder a documentación adicional sobre los endpoints, la arquitectura y la guía de uso general, visite: [Documentación](https://github.com/matiasjara987/ApiTask/tree/main/docs).

Saludos cordiales,  
[Matías Jara Dev ](https://github.com/matiasjaradev)

---

## **Introducción**

Este documento describe la arquitectura técnica de la API REST para la gestión de tareas, desarrollada en Java 21 con Spring Boot. Dentro de los temas que se abordan en este documento se encuentran:
-  Estandarización 
- Patrones de diseño
- Estructura de proyecto
- Dependencias utilizadas

---
## **Estandarización** 
 La estandarización se realizo con la finalidad de que el proyecto sea claro, explicativo y evitar el uso de comentarios adicionales. ApiTask sigue una serie de principios claves para su fácil comprensión. A continuación, se enumeran los principios claves para su buen uso.
 ### 1.  **Lenguaje coherente**
  - Todos los nombres se encuentran en el mismo idioma **Inglés** 
  - Ejemplo:
	  - ✅ `userName` , `taskDescription` 
	  - ❌ `nombreUsuario`, `taskDescription`
### 2.  **Nombres descriptivos y claros**
- El nombre refleja con **precisión** su propósito y contenido.
- No se hace uso de abreviaciones confusas o letras sueltas como `x`, `db`, `un`
- Ejemplo:
	  - ✅ `startDate` , `userEmail` 
	  - ❌ `sd`, `um`
 ### 3. **Consistencia en el case**
- Se ha creado la siguiente tabla para explicar la consistencia del nombramiento según el tipo de elemento:

| Elemento   | Estilo             | Ejemplo           |
| ---------- | ------------------ | ----------------- |
| Variables  | `camelCase`        | `userId`          |
| Métodos    | `camelCase`        | `getTasks()`      |
| Clases     | `PascalCase`       | `TaskService`     |
| Constantes | `UPPER_SNAKE_CASE` | `MAX_RETRIES`     |
| Paquetes   | `kebab-case`       | `com.example.api` |
### 4. **Nombres de métodos como acciones**

- Los métodos reflejan acciones, en forma de verbo.
    
    - ✅ `createUser()`, `getAllTasks()`
        
    - ❌ `userCreation()`, `tasksGetter()`
        

### 5. **Prefijos claros para booleanos**

- Para definir booleanos se utilizan prefijos clave como `is`, `has`, `can`, etc., para campos booleanos.
    
    - ✅ `isActive`, `hasPermission`, `canEdit`
        
    - ❌ `active`, `permissionOk`, `editable`
        

### 6. **Nombres de paquetes y carpetas en singular**

- Para evitar ambigüedad:
    
    - ✅ `controller`, `model`, `service`
        
    - ❌ `controllers`, `models`, `services`
 ### Método
 - El Método será definido con camelCase y respetando los puntos presetandos en la sección anterior. Los métodos en las clases de servicio siguen los estándares de **Spring Jpa** con la finalidad de limpiar código. Para mayor información, revisar documentación oficial de [Spring JPA](https://docs.spring.io/spring-data/jpa/reference/jpa.html)

### Clase
- Una Clase sigue los principios presentados con anterioridad, presentan nombres claros con Pascal Case, atributos privados. **Métodos Getter & Setter** utilizan la dependencia de Loombook con el fin de obtener clases limpias y sin código repetitivo. 
### Interface 
- ApiTask sigue el principio de nombres descriptivos y claros para sus interfaces e implementaciones. Además para poder expresar con mayor claridad el contrato o firma de las interfaces heredan la firma de su directorio padre.
- Ejemplo
	- ✅ `UserRepository`, `UserService` 
	- ❌ `Iuser`, `IUserRepository` 
### Implementacion
- Para la implementación de cualquier interface se sigue las siguientes reglas.
1. La implementación estará desacoplada de la firma (contract), se encontrará disponible en su directorio propio `impl/`.
2. La implementación Hereda el nombre de su interface agregando al final `Impl`.
3. En caso de que el contrato contenga dos o más Implementaciones se creará un subdirectorio dentro de `Impl/`. 

---

## **Arquitectura**

- A continuación se presenta aspectos clave en la arquitectura de Apistask, como sus patrones de diseño, estructura de directorios, explicación detallada de cada capa.

### **Patrones de diseño**

#### **1. MVC (Model-View-Controller)**

 El patrón MVC separa la aplicación en tres componentes principales:

- **Model (Modelo):** Representa la lógica de negocio y el acceso a datos. En este proyecto, se implementa con las clases JPA (entidades).
- **View (Vista):** En aplicaciones web como APIs REST, la vista suele ser el JSON retornado al cliente.
- **Controller (Controlador):** Recibe las solicitudes HTTP, las procesa y delega la lógica de negocio a los servicios.

Este patrón favorece la separación de responsabilidades y la mantenibilidad del código.



#### **2. DTO Pattern (Data Transfer Object)**

 El patrón DTO permite enviar y recibir datos de forma controlada entre el cliente y el servidor:

- Previene la exposición directa de las entidades del modelo.
- Controla qué datos son visibles o editables.
- Facilita la validación y transformación de datos.

Se aplica creando clases `DTO` específicas por entidad, adaptadas a cada operación (crear, actualizar, listar, etc.).



#### **3. Dependency Injection (Inyección de dependencias)**

 Este patrón permite desacoplar las clases de sus dependencias. En lugar de crear instancias manualmente, el framework (Spring) se encarga de inyectarlas:

- Mejora el testeo y la reutilización de componentes.
- Promueve el bajo acoplamiento.
- Se aplica mediante anotaciones como `@Autowired`, `@Service`, `@Component`, `@Repository`, etc.



#### **4. AOP (Programación Orientada a Aspectos)**

 La AOP permite separar funcionalidades transversales del flujo principal de la aplicación, como:

- Logging
- Auditoría
- Manejo de excepciones
- Seguridad

Estas tareas se implementan como "aspectos", aplicados antes, después o alrededor de ciertos métodos usando anotaciones como `@Aspect`, `@Before`, `@After`, etc.

---

### **Estructura del proyecto**
 La estructura del proyecto **ApiTask** sigue el principio de **separación de responsabilidades**, lo que permite desacoplar la lógica de negocio, los controladores, modelos, servicios, entre otros componentes. Por esta razón, se organiza en directorios y subdirectorios bien definidos.

A continuación, se presenta un gráfico que ilustra la estructura del proyecto, incluyendo sus carpetas principales, subcarpetas, clases e interfaces relevantes. Al final, se detalla el propósito de cada una de estas carpetas para facilitar su comprensión y mantenimiento.

```text
/	
├── src/
|   └──main/
|	└── config/
|	|    └── ModelMapperConfig.java
|	└── controller/        
|	└── dto/
|	|    └── userdto/
|  	|    |	└── UserChangePasswordDto.java             
|	|    |	└── UserRequestDto.java
|  	|    |	└── UserResponseDto.java             
|  	|    |	└── UserUpdateDto.java
|	|    └── taskdto/
|  	|    	└── TaskRequestDto.java             
|	|    	└── TaskREsponseDto.java             
|	└── exception/         
|	└── model/
|	|    └── User.java
|  	|    └── Task.java             
|	└── repository/
|	|    └── UserRepository.java
|	|    └── TaskRepository.java        
|	└── security/
|	└── service/           
|	|    └── contract/
|	|    |	└── UserService.java
|	|    |	└── TaskService.java
|	|    └── impl/          
|	└── aspect/            
|	└── Application.java  
```
--- 

###  Explicación de directorios

A continuación, se describen los paquetes principales del proyecto `ApiTask`, estructurado bajo principios de desacoplamiento y organización por capas:

---

#### `config/`
- Contiene todas las configuraciones generales necesarias para el correcto funcionamiento del sistema, como beans reutilizables (`ModelMapper`), configuración de seguridad, CORS, etc.

```text
├── config/ → Configuraciones generales (ModelMapper, seguridad, etc.)
````



#### `controller/`

- Define todos los controladores REST encargados de recibir las solicitudes HTTP, validar datos y delegar la lógica de negocio a los servicios.

```text
├── controller/ → Controladores REST (endpoints)
```



#### `dto/`

- Incluye todas las clases DTO (Data Transfer Objects), usadas para enviar y recibir datos desde los endpoints de manera controlada y segura, evitando exponer entidades directamente. Se organiza por dominio.

```text
├── dto/
│   ├── userdto/ → DTOs para operaciones relacionadas a usuarios
│   └── taskdto/ → DTOs para operaciones relacionadas a tareas
```



#### `exception/`

- Contiene las excepciones personalizadas de la aplicación y el manejador global para unificar las respuestas de error.

```text
├── exception/ → Excepciones personalizadas y manejo global
```



#### `model/`

- Define las entidades del dominio que representan las tablas de la base de datos. Utilizan anotaciones JPA para mapear campos y relaciones.

```text
├── model/ → Entidades JPA (User, Task, etc.)
```



#### `repository/`

- Aloja las interfaces que extienden `JpaRepository` u otras interfaces de Spring Data para facilitar el acceso a la base de datos sin escribir consultas SQL manuales.

```text
├── repository/ → Interfaces de acceso a datos (JPA Repositories)
```



#### `service/`

- Contiene la lógica de negocio de la aplicación. Se divide en dos subpaquetes:

* `contract/`: Define las interfaces (contratos) que deben cumplir los servicios.
* `impl/`: Implementaciones concretas de los servicios definidos en `contract`.

```text
├── service/
│   ├── contract/ → Interfaces de lógica de negocio
│   └── impl/     → Implementaciones concretas de lógica de negocio
```



#### `aspect/`

- Contiene los aspectos programados mediante AOP (Aspect-Oriented Programming), para funcionalidades transversales como logging o auditoría, desacopladas de la lógica principal.

```text
├── aspect/ → Aspectos AOP (logging, auditoría, etc.)
```



#### `Application.java`

- Clase principal de arranque del proyecto Spring Boot. Contiene el método `main` y está anotada con `@SpringBootApplication`.

```text
└── Application.java → Clase principal de Spring Boot
```
