# **Arquitectura del proyecto**
El presente documento describe la arquitectura del proyecto **ApiTask**, con el objetivo de facilitar su comprensión y correcto uso. Se abordarán aspectos clave como la estandarización de atributos, métodos, funciones, clases, interfaces e implementaciones.

Para acceder a documentación adicional sobre los endpoints, la arquitectura y la guía de uso general, visite: [Documentación](https://github.com/matiasjara987/ApiTask/tree/main/docs).

Saludos cordiales,  
[Matías Jara Dev ](https://github.com/matiasjara987)

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
	  - ❌ `nombreUsuario`, taskDescription
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
 ### Métodos
 ### Funciones
 ### Clases
 ### Interfaces e implementaciones

---
## **Arquitectura**

### **Patrones de diseño**
- **MVC**
	- 
- **DTO Pattern**
	- 
- **Dependency Injection**
	- 
- **AOP**
	- 
### **Estructura del proyecto**
La estructura del proyecto **ApiTask** sigue el principio de **separación de responsabilidades**, lo que permite desacoplar la lógica de negocio, los controladores, modelos, servicios, entre otros componentes. Por esta razón, se organiza en directorios y subdirectorios bien definidos.

A continuación, se presenta un gráfico que ilustra la estructura del proyecto, incluyendo sus carpetas principales, subcarpetas, clases e interfaces relevantes. Al final, se detalla el propósito de cada una de estas carpetas para facilitar su comprensión y mantenimiento.

```text
/	
├── src/
|   └──main/
|	└── config/            
|	└── controller/        
|	└── dto/               
|	└── exception/         
|	└── model/
|	    └── User.java
|  	    └── Task.java             
|	└── repository/
|	    └── UserRepository.java
|	    └── TaskRepository.java        
|	└── service/           
|	    └── contract/     
|	    └── impl/          
|	└── aspect/            
|	└── Application.java  
```

#### **Explicación de directorios**
```text
/	
├── src/
|   └──main/
|	└── config/            
|	└── controller/        
|	└── dto/               
|	└── exception/         
|	└── model/
|	    └── User.java
|  	    └── Task.java             
|	└── repository/
|	    └── UserRepository.java
|	    └── TaskRepository.java        
|	└── service/           
|	    └── contract/     
|	    └── impl/          
|	└── aspect/            
|	└── Application.java  
```


### Mejorar esto estructura del proyecto 
→ Configuraciones generales (ModelMapper,
	├── controller        → Controladores REST (endpoints)
	├── dto               → Clases DTO (entrada/salida de datos)
	├── exception         → Excepciones personalizadas y manejo global
	├── model             → Entidades JPA (User, Task, etc.)
	├── repository        → Interfaces de acceso a datos (JPA Repositories)
	├── service           → Capa de lógica de negocio
	│   └── interface     → Interfaces lógica de negocio
	│   └── impl          → Implementaciones de lógica de negocio
	├── aspect            → Aspectos AOP (logging, auditoría, etc.)
	└── Application.java  → Clase principal de Spring Boot
