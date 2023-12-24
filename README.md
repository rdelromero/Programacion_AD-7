PROGRAMACIÓN

# AD-7. Acceso a Bases de Datos

Realizar una Aplicación de gestión de proyectos, de acuerdo con la siguiente base de Datos:

![imagen](/AD7_Prog-1.png)

La estructura de paquetes del proyecto es:

1. javabeans
1. daos
1. conexion
1. testing
1. principales

#### 1. *CLIENTES*

Consideraciones:
Hacer una clase con main estático GestionClientes con un  menú con las siguientes opciones:
* Alta del Cliente
* Buscar un Cliente
* Mostrar Todos.
* Eliminar un cliente
* Salir

Definir el javabean de Cliente, el interface para CRUD de cliente incluido findAll(), y el Interface de ClienteDaoImpl, para implementar los métodos del Interface, accediendo a bases de datos.

#### 2. *RECURSOS HUMANOS*

Crear los javabean Departamento , Perfil y Empleado, los interface y las clases que implementan el interface.
CONSIDERACIONES:
* La clase Empleado, tendrá los siguientes métodos propios:
  - salarioBruto() : double
  - salarioMensual(int meses) : double
  - literalSexo() : String. H -> Hombre, M -> mujer
  - obtenerEmail() : String. Primera letra del nombre + primer apellido, en minúsculas
  - nombreCompleto(): String. Nombre + “ “ + apellidos
* Métodos de EmpleadoDao, además de los CRUD, y findAll():
  - empleadosByDepartamento(int idDepar): List<Empleado>
  - empleadosBySexo(char sexo): List<Empleado>
  - empleadosByApellido(String subcadena): List<Empleado>
  - salarioTotal(): double
  - salarioTotal(int idDepar): double. Salario Total para un
 
#### 3. *PROYECTOS*

La clase Proyecto tiene los siguientes métodos propios:
* margenPrevisto():double. Importe de venta – coste previsto
* margenReal(): double Importe de venta – gastos reales
* diferenciaGastos(): double. Gasto real – gasto previsto
* diferenciaFinPrevistoReal(): int . Días entre fin previsto y fin real

La clase ProyectoDao, además de CRUD y findAll(), impone los siguientes métodos con acceso de base de datos:
* proyectosByEstado(String estado): List<Proyecto>
* proyectosByCliente(String cif) : List<Proyecto>
* proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado): List<Proyecto>
* importesVentaProyectosTerminados(): double
* margenBrutoProyectosTerminados():double Diferencia suma Importes venta y gastos reales.
* diasATerminoProyectoActivo(String codigoProyecto): int. Cuantos días quedan para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy)

#### 4. *EMPLEADOS EN PROYECTOS*

La clase EmpleadosEnProyectos tiene los siguientes métodos propios:
* costeHorasAsignadas(): double . Horas * precio/hora

La clase EmpleadosEnProyectoDao, impone si quieres  CRUD y findAll() y obligatoriamente impone con acceso de base de datos:
* empleadosByProyecto(String codigoProyecto): List<EmpleadosEnProyecto>
* asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados): int
* horasAsignadasAProyecto(String codigoProyecto): int. Suma de las horas de los empleados asignados al proyecto.
* costeActualDeProyecto(String codigoProyecto): double . horas*coste-hora de cada empleado asignado al proyecto.
* margenActualProyecto(String codigoProyecto): double. Importe_venta del proyecto – costeActual del Proyecto

**Hacer clases de prueba por cada Javabean-Interface-ImplMy8, para probar la funcionalidad.**
