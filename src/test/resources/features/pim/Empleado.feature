@Regresion @PIM
Feature: CP02 - Validar la creación del empleado en OrangeHRM

  Background:
    Given El usuario navega al sitio web
    When  Ingresa el usuario admin Y clave admin123
    Then La aplicación muestra el modulo principal de OrangeHRM


  @CrearEmpleado
  Scenario Outline: 1 - Validar la creación del empleado con credenciales validas
    Given El usuario realiza la creación del empleado con nombre <nombre> Y apellido <apellido>
    Then Se crea el empleado correctamente
    Examples:
      |nombre|apellido|
      |Carlos|Lopez   |

  @BusquedaEmpleado
  Scenario Outline: 2 - Validar la búsqueda del empleado creado
    Given El usuario busca el empleado con nombre <nombre> Y apellido <apellido>
    Then Se muestra el empleado <nombre> creado en la lista
    Examples:
      |nombre|apellido|
      |Carlos|Lopez   |


