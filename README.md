# Sistema de Gestion de Reservas para Gimnasio

Este proyecto es una aplicacion web para gestionar un gimnasio, permitiendo crear clientes, realizar reservas de clases y consultar todas las reservas existentes.

## Funcionalidades Principales

1. **Crear Cliente**  
   Permite registrar un nuevo cliente en el sistema. Cada cliente tendra un nombre, correo electronico y otros datos basicos.

2. **Realizar Reservas**  
   Los clientes registrados pueden reservar clases, especificando el tipo de clase y la fecha/hora deseada.

3. **Consultar Reservas**  
   Muestra una lista completa de todas las reservas realizadas, incluyendo detalles como el cliente asociado, el tipo de clase y la fecha.

---

## Estructura del Proyecto

### 1. HTML y JSP
- **Crear Cliente:** Formulario para introducir los datos del cliente.  
- **Realizar Reserva:** Pagina para seleccionar el cliente, el tipo de clase y la fecha/hora.  
- **Consultar Reservas:** Tabla para mostrar todas las reservas almacenadas en el sistema.  

### 2. Servlets

- **CrearClienteServlet.java:**  
  Gestiona la creacion de nuevos clientes en la base de datos.

- **ReservarServlet.java:**  
  Permite realizar una nueva reserva, asociandola con un cliente existente.

- **ConsultarServlet.java:**  
  Consulta todas las reservas de la base de datos y las muestra en formato HTML.

### 3. Base de Datos

Se utiliza **MySQL** como base de datos, con las siguientes tablas principales:

- **`clientes`**
  - `id_cliente` (INT, PK): Identificador unico del cliente.
  - `nombre` (VARCHAR): Nombre del cliente.
  - `email` (VARCHAR): Correo electronico del cliente.
  - `telefono` (VARCHAR): Numero de telefono del cliente.

- **`reservas`**
  - `id_reserva` (INT, PK): Identificador unico de la reserva.
  - `id_cliente` (INT, FK): Referencia al cliente que realizo la reserva.
  - `fecha_clase` (DATETIME): Fecha y hora de la clase reservada.
  - `tipo_clase` (VARCHAR): Tipo de clase reservada.

---

## Navegacion en la Aplicacion

### Enlaces principales:

1. **Crear Cliente**  
   URL: `/TrabajoCurso2_RobertoMoralesFumero/CrearClienteServlet`  
   Formulario para registrar nuevos clientes.

2. **Reservar Clase**  
   URL: `/TrabajoCurso2_RobertoMoralesFumero/ReservarServlet`  
   Pagina para realizar una nueva reserva.

3. **Consultar Reservas**  
   URL: `/TrabajoCurso2_RobertoMoralesFumero/ConsultarServlet`  
   Tabla dinamica que muestra todas las reservas almacenadas.

---

## Requisitos del Proyecto

- **Servidor de Aplicaciones:** Apache Tomcat 9+
- **Java:** JDK 11+
- **Base de Datos:** MySQL 8+
- **Dependencias:**
  - JDBC Driver para MySQL

---

## Instalacion y Configuracion

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/RoberVF/TC2---Programacion.git
   
2. **Configurar la base de datos:**
   - Crear la base de datos en MySQL llamada `nombre_de_la_ddbb`
     
3. **Configurar el proyecto en el servidor de GlassFish:**
   - Al crear el proyecto en NetBeans, marcar la opcion de GlassFish
     
4. **Iniciar la aplicacion desde NetBeans:**
   - El boton de `play` en el menu superior

---

## Flujo de Trabajo

1. Registrar un cliente
2. Reservar un clase asignado el nombre del cliente
3. Consultar las reservas actuales

---

## Contexto
Este programa ha sido realizado como Segundo Trabajo de Curso para la asignatura Programacion de Redes, Sistemas y Servicios (43719) de la Universidad de las Palmas de Gran Canaria en la titulacion Ingenieria en Telecomunicaciones.

---

## Licencia
La aplicacion ha sido totalmente realizada por mi, Roberto Morales Fumero, y dejo a total disposicion el uso de esta para cualquier usuario que la requiera.

---

## Autor
**Roberto Morales Fumero**
[LinkedIn](https://www.linkedin.com/in/roberto-morales-fumero-5186891a8/)
     
