package org.example.tasks.pim;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.interfaces.pim.EmpleadoUi.*;
import static org.example.utilidades.Constantes.TIEMPO_ESPERA;

public class BuscarEmpleadoTask implements Task {
    private String nombre;
    private String aplellido;
    public BuscarEmpleadoTask(String nombre, String aplellido) {
        this.nombre = nombre;
        this.aplellido = aplellido;
    }
    public static BuscarEmpleadoTask buscar(String nombre, String aplellido) {
        return instrumented(BuscarEmpleadoTask.class, nombre,aplellido);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_DIRECTORY,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(BTN_DIRECTORY),
                WaitUntil.the(LBL_BUSCAR_EMPLEADO,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(nombre +" "+ aplellido).into(LBL_BUSCAR_EMPLEADO),
                WaitUntil.the(BTN_BUSCAR,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(BTN_BUSCAR)
        );

    }
}
