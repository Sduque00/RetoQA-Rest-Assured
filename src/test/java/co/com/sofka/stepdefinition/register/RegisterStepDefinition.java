package co.com.sofka.stepdefinition.register;

import co.com.sofka.stepdefinition.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterStepDefinition extends SetUp {

    public static final Logger LOGER = Logger.getLogger(RegisterStepDefinition.class);
    private Response response;
    private RequestSpecification resquest;

    @Given("el usuario esta en la pagina de registro con el correo de usuario {string} y la contrasena {string}")
    public void elUsuarioEstaEnLaPaginaDeRegistroConElCorreoDeUsuarioYLaContrasena(String email, String password) {
        try {
            generalSetUp();
            resquest = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body(body(email, password));
        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());

        }
    }

    @When("el usuario hace una peticion de registro")
    public void elUsuarioHaceUnaPeticionDeRegistro() {
        try {
            response = resquest.when()
                    .post(REGISTER_RESOURCE);
        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());

        }

    }

    @Then("el usuario debera ver un id, token y un codigo de respuesta exitoso")
    public void elUsuarioDeberaVerUnIdTokenYUnCodigoDeRespuestaExitoso() {
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("id", notNullValue(), "token", notNullValue());

        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());

        }
    }

    private String body(String email, String password){
        return "{\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";


    }

    }
