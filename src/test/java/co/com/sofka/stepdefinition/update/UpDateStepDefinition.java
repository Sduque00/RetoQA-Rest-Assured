package co.com.sofka.stepdefinition.update;

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

public class UpDateStepDefinition extends SetUp {

    public static final Logger LOGER = Logger.getLogger(UpDateStepDefinition.class);
    private Response response;
    private RequestSpecification resquest;

    @Given("el usuario desea actualizar el nombre por {string} y el trabajo por {string}")
    public void elUsuarioDeseaActualizarElNombrePorYElTrabajoPor(String name, String job) {
        try {
            generalSetUp();
            resquest = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body(body(name, job));
        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());

        }

    }
    @When("el usuario hace una peticion de cambio")
    public void elUsuarioHaceUnaPeticionDeCambio() {
        try {
            response = resquest.when()
                    .put(UPDATE_RESOURCE);
        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());

        }

    }
    @Then("el usuario debera ver los cambios realizados y la fecha de actualizacion")
    public void elUsuarioDeberaVerLosCambiosRealizadosYLaFechaDeActualizacion() {
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("name", notNullValue(), "job", notNullValue(), "updatedAt", notNullValue());

        }catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());

        }

    }

    private String body(String name, String job){
        return "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}";


    }
}
