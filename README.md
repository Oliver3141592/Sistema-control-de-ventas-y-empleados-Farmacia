# 💊 Sistema de administración de ventas y de personal

**Equipo:** 5  
**Integrante:** Oliver Gildardo Enriquez Valencia

---

## 📌 ¿Qué hace el sistema?

Este sistema gestiona a tres tipos de usuarios (administrador, cajero, almacenista). Permite registrar, modificar y eliminar usuarios. Además, cajeros y administradores pueden realizar ventas y descontar productos del inventario.

- Tipo de sistema: **Aplicación de escritorio (Desktop App) desarrollada en Java con Swing.**
- Arquitectura: **Proyecto ANT con Maven en NetBeans**
- Base de datos: **MySQL**

---

## 🔌 Librerías y componentes externos

- **PDF:** Se utiliza `iText 5` para la generación de archivos PDF.
- **Validación de correos y contraseñas:** Se usa la librería del **Equipo 16** para validar correos electrónicos y contraseñas, permite mandarles mensajes a dichos correos.  
  👉 https://github.com/olmomomo/Libreria_correoElectronico


- **Captcha visual:** Basado en el componente del **Equipo 2** para seguridad en el login.  
  👉 https://github.com/FanyBr07/ComponenteVisual

---

## 🚀 Funcionalidades principales

| Funcionalidad            | Descripción                                                                                  |
|--------------------------|----------------------------------------------------------------------------------------------|
| 🧠 Login con CAPTCHA    | El sistema solicita validación visual (tipo CAPTCHA) al iniciar sesión.                      |
| 👥 CRUD de usuarios     | Modificación y listado de usuarios.                                                          |
| 📦 CRUD de productos    | Gestión completa de productos con stock.                                                     |
| 🧾 Ventas y detalles    | Se puede realizar venta de productos. Se descuenta del stock y se registra la fecha y total. |
| 📧 Envío de correo      | Se envían correos al registrar nuevos usuarios y al generar reportes de venta (corte de caja)|
| 📄 PDF dinámico         | Generación de archivos PDF al registrar usuarios y para cortes de caja.                      |

---
### 🟢 Inicio de sesión con CAPTCHA
![Login](https://raw.githubusercontent.com/Oliver3141592/Sistema-control-de-ventas-y-empleados-Farmacia/main/capturas/Captura%20de%20pantalla%202025-08-03%20204425.png)

aqui nos pide un usuario que esté registrado en la base de datos de usuarios (se incluye el captcha en el loggin)


### 🟢 Menus disponibles para un acceso 3 (Administrador)
![Login](https://raw.githubusercontent.com/Oliver3141592/Sistema-control-de-ventas-y-empleados-Farmacia/main/capturas/Captura%20de%20pantalla%202025-08-03%20204454.png)

son los menus disponibles para un usuario con el maximo acceso (acceso 3, administrador)

### 🟢 CRUD de Usuarios ( dentro del menú de Administrador)
![Login](https://raw.githubusercontent.com/Oliver3141592/Sistema-control-de-ventas-y-empleados-Farmacia/main/capturas/Captura%20de%20pantalla%202025-08-03%20204555.png)

en este apartado se enlaza con la base de datos en la tabla de usuarios

### 🟢 CRUD de Productos (dentro del menú de Administrador)
![Login](https://raw.githubusercontent.com/Oliver3141592/Sistema-control-de-ventas-y-empleados-Farmacia/main/capturas/Captura%20de%20pantalla%202025-08-03%20204607.png)

en este apartado se enlaza con la base de datos en la tabla de productos


### 🟢 CRUD de Ventas (dentro del menú de Cajero)
![Login](https://raw.githubusercontent.com/Oliver3141592/Sistema-control-de-ventas-y-empleados-Farmacia/main/capturas/Captura%20de%20pantalla%202025-08-03%20204509.png)

en este apartado se enlaza con la base de datos en las tablas venta y detalles de venta





## 🛠️ Dependencias y configuración

**Librerías externas usadas:**
- iText 5
- Librería de validador del equipo 16
- CAPTCHA visual del equipo 2

**Requisitos mínimos:**
- Java 11
- MySQL 8.0
- NetBeans con soporte para proyectos ANT + Maven

**Pasos para ejecutar:**
1. Para ocupar este proyecto se tiene que modificar la clase que conecta con la base de datos, este proyecto está diseñado para conectarse al host con una contraseña especifica
2.- En el caso de mandar mensajes, de igual forma se tiene que modificar para que los mensajes se envíen de la cuenta que se desea como remitente


