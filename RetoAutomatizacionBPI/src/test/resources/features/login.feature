Feature: Inicio de sesion en sitio
  @CP1-Ingreso
  Scenario: Ingreso BPI
    Given me encuentro en el sitio
    When ingreso las credenciales
    And cierro sesion
    Then me muestra los datos guardados