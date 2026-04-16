Sistema de Parqueo Público

Aplicación desarrollada en Java para la gestión básica de un parqueo público.  
El sistema permite registrar la entrada y salida de vehículos, calcular el monto a pagar según el tiempo de permanencia y visualizar los vehículos activos y el historial.

Tecnologías utilizadas

- Java
- Swing (JFrame, JTable, formularios)
- Apache Ant
- Persistencia en archivos .txt
- Arquitectura por capas

Funcionalidades

- Registro de ingreso de vehículos
- Registro de salida de vehículos
- Cálculo automático del monto a pagar (₡500 por hora)
- Visualización de vehículos actualmente en el parqueo
- Visualización de historial de registros
- Validación para evitar ingreso duplicado de placas

Arquitectura del sistema

El sistema está implementado utilizando arquitectura por capas:

Presentación → Interfaces gráficas  
Lógica de Negocio → Validaciones y cálculo de cobro  
Acceso a Datos → Manejo de archivos .txt  
Entidades → Clases del modelo de datos

Estructura del proyecto

# Sistema de Parqueo Público

Aplicación desarrollada en Java para la gestión básica de un parqueo público.  
El sistema permite registrar la entrada y salida de vehículos, calcular el monto a pagar según el tiempo de permanencia y visualizar los vehículos activos y el historial.

## Tecnologías utilizadas

- Java
- Swing (JFrame, JTable, formularios)
- Apache Ant
- Persistencia en archivos .txt
- Arquitectura por capas

## Funcionalidades

- Registro de ingreso de vehículos
- Registro de salida de vehículos
- Cálculo automático del monto a pagar (₡500 por hora)
- Visualización de vehículos actualmente en el parqueo
- Visualización de historial de registros
- Validación para evitar ingreso duplicado de placas

## Arquitectura del sistema

El sistema está implementado utilizando arquitectura por capas:

Presentación → Interfaces gráficas  
Lógica de Negocio → Validaciones y cálculo de cobro  
Acceso a Datos → Manejo de archivos .txt  
Entidades → Clases del modelo de datos

Estructura del proyecto

src
├── Entidades
│ Vehiculo.java
│ Registro.java
├── Logica
│ ParqueoService.java
├── Datos
│ RegistroDAO.java
└── Main
Main.java

VentanaPrincipal.java

ModeloTablaRegistro.java

prompts.txt 

CHANGELOG.md 

README.md 
