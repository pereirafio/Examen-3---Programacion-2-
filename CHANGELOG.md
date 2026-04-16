v1.0
Registro de ingreso de vehículos implementado.

v1.1
Registro de salida de vehículos y cálculo del monto a pagar por hora.

v1.2
Mejoras en la interfaz gráfica, tablas y validaciones de datos.

v1.3
Refactor completo del modelo de datos:
- Mejora en formato de fecha/hora y cálculo de cobro con redondeo de horas.
- Se agregó clase Vehiculo como entidad principal
- Se ajustó Registro para usar composición con Vehiculo
- Se implementó método existeActivo en DAO
- Se corrigió lógica de entrada y salida en ParqueoService