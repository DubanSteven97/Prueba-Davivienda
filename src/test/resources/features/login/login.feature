@Regresion @Login
Feature: CP01 - Validar inicio de sesión
    Como usuario del sistema OrangeHRM
    Quiero validar el inicio de sesión con credenciales correctas
    Para acceder al módulo principal de la aplicación

  @CredencialesValidas
  Scenario: 1 - Validar login con credenciales correctas
    Given El usuario navega al sitio web
    When  Ingresa el usuario admin Y clave admin123
    Then La aplicación muestra el modulo principal de OrangeHRM


