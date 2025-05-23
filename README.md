# ApiTask

**ApiTask** es una API REST desarrollada siguiendo principios de **Clean Code**, **Clean Architecture** y los principios **SOLID**.
Permite a los usuarios registrar tareas, almacenarlas en una base de datos y recuperar esa información posteriormente de forma eficiente y estructurada.

---

## Características
- ✅ Creación de  Tareas
- ✅ Creación de usuarios
- ✅ Relación entre Usuarios y tareas
- ✅ Gestión de roles

---

## Tecnologías 
- **Lenguaje de programación:** `Java`
- **JDK:** `21`
- **Framework principal:** `Springboot`

### Dependencias
- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `h2-database`
- `modelmapper`
- `spring-boot-starter-validation`
- `spring-boot-starter-aop`
- `spring-boot-starter-security`
- `jjwt`
- `spring-boot-starter-test`

---

## Estructura del proyecto
```
 /	
├── src/
|   └──main/
|		└── config/            
|		└── controller/        
|		└── dto/               
|		└── exception/         
|		└── model/             
|		└── repository/        
|		└── service/           
|		|   └── contract/     
|		|   └── impl/          
|		└── aspect/            
|		└── Application.java  
```
## Seguridad

El sistema implementa autenticación basada en **JWT (JSON Web Tokens)** y manejo de roles para proteger los endpoints según el perfil del usuario.

---

## Próximas mejoras 

- 🔄 Paginación y filtros en las tareas
- 📈 Documentación Swagger
- 💾 Soporte para base de datos externa (PostgreSQL/MySQL)

---
### Autor

- [Matías Jara](https://github.com/matiasjara987)

---

### Licencia

Este proyecto esta bajo la licencia MIT. Consulta el archivo [LICENSE](./LICENSE) para mas detalles.
