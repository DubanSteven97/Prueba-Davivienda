package org.example.stepdefinitions.pim;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.exepciones.ExepcionGeneral;
import org.example.questions.login.LoginQuestion;
import org.example.questions.pim.CreacionEmpleadoQuestion;
import org.example.tasks.pim.CrearEmpleadoTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class CreacionEmpleado {

    @Given("^El usuario realiza la creación del empleado con nombre (.*) Y apellido (.*)$")
    public void crearEmpleado(String nombre, String apellido){
        theActorInTheSpotlight().attemptsTo(
                CrearEmpleadoTask.crear(nombre,apellido)
        );
    }

    @Then("Se crea el empleado correctamente")
    public void validarCreacionEmpleado(){
        theActorInTheSpotlight().should(
                seeThat(
                        CreacionEmpleadoQuestion.verificarCreacion(),is(true)
                ).orComplainWith(ExepcionGeneral.class,"No se creo el empleado correctamente")
        );
    }
}
