package org.example.stepdefinitions.pim;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.exepciones.ExepcionGeneral;
import org.example.questions.pim.BusquedaEmpleadoQuestion;
import org.example.questions.pim.CreacionEmpleadoQuestion;
import org.example.tasks.pim.BuscarEmpleadoTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class BusquedaEmpleado {

    @Given("^El usuario busca el empleado con nombre (.*) Y apellido (.*)$")
    public void buscarEmpleado(String nombre, String apellido){
        theActorInTheSpotlight().attemptsTo(
                BuscarEmpleadoTask.buscar(nombre,apellido)
        );
    }
    @Then("^Se muestra el empleado (.*) creado en la lista$")
    public void validarBusquedaEmpleado(String nombreCompleto){
        theActorInTheSpotlight().should(
                seeThat(
                        BusquedaEmpleadoQuestion.verificarBusqueda(nombreCompleto),is(true)
                ).orComplainWith(ExepcionGeneral.class,"No se lsito el empleado correctamente")
        );
    }

}
