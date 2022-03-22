Feature: Registro
  como un usuario del sistema
  necesito valdiar las operaciones del registro y disponibilidad al sitio web
  para poder tener seguiridad en el registro y perfil de los usuarios

  Scenario: Registro exitoso
    Given el usuario esta en la pagina de registro con el correo de usuario "eve.holt@reqres.in" y la contrasena "pistol"
    When el usuario hace una peticion de registro
    Then el usuario debera ver un id, token y un codigo de respuesta exitoso
