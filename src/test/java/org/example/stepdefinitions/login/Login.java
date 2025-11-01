// java
package org.example.stepdefinitions.login;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.utilidades.Constantes.URL_PAGINA_WEB;
import static org.hamcrest.CoreMatchers.is;

import org.example.exepciones.ExepcionGeneral;
import org.example.questions.login.LoginQuestion;
import org.example.tasks.login.LoginTask;

public class Login {

    private static final String ACTOR_NAME = "Usuario";
    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR_NAME);
    }

    @Given("El usuario navega al sitio web")
    public void abrirPagina(){
        theActorInTheSpotlight().wasAbleTo(
            Open.url(URL_PAGINA_WEB)
        );
    }

    @When("^Ingresa el usuario (.*) Y clave (.*)$")
    public void ingresarCredenciales(String usuario, String clave){
        theActorInTheSpotlight().attemptsTo(
                LoginTask.digitar(usuario,clave)
        );
    }

    @Then("La aplicación muestra el modulo principal de OrangeHRM")
    public void validarIngreso(){
        theActorInTheSpotlight().should(
                seeThat(
                        LoginQuestion.verificarLogin(),is(true)
                ).orComplainWith(ExepcionGeneral.class,"El usuario no pudo ingresar al sistema")
        );
    }
}