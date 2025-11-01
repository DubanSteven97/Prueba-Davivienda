@Login
Feature: CP01 - Validar inicio de sesión

  Background: Validar el inicio de sesion con credenciales validas e invalidas

  @CredencialesValidas
  Scenario: 1 - Validar login con credenciales correctas
    Given El usuario navega al sitio web
    When  Ingresa el usuario admin Y clave admin123
    Then La aplicación muestra el modulo principal de OrangeHRM


