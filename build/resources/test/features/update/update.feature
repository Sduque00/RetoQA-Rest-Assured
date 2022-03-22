Feature: Actualizar
    como usuario registrado del sistema
    necesito validar las operaciones de actualizacion al sistema
    para poder tener cambio en el perfil de los usuarios

  Scenario: Actualizacion exitosa
    Given el usuario desea actualizar el nombre por "morpheus" y el trabajo por "zion resident"
    When el usuario hace una peticion de cambio
    Then el usuario debera ver los cambios realizados y la fecha de actualizacion