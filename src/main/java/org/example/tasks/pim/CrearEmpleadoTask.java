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
import static org.example.utilidades.Constantes.RUTA_IMAGEN;
import static org.example.utilidades.Constantes.TIEMPO_ESPERA;

public class CrearEmpleadoTask implements Task {
    private String nombre;
    private String aplellido;
    public CrearEmpleadoTask(String nombre, String aplellido) {
        this.nombre = nombre;
        this.aplellido = aplellido;
    }
    public static CrearEmpleadoTask crear(String nombre, String aplellido) {
        return instrumented(CrearEmpleadoTask.class, nombre,aplellido);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(BTN_PIM,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(BTN_PIM),
                WaitUntil.the(BTN_AGREGAR,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(BTN_AGREGAR),
                WaitUntil.the(LBL_NOMBRE,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(nombre).into(LBL_NOMBRE),
                WaitUntil.the(LBL_APELLIDO,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(aplellido).into(LBL_APELLIDO)
        );

        if (RUTA_IMAGEN != null && !RUTA_IMAGEN.isEmpty()) {
            java.nio.file.Path imagen = Paths.get(RUTA_IMAGEN).toAbsolutePath();
            actor.attemptsTo(
                    WaitUntil.the(INPUT_FOTO, isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                    Upload.theFile(imagen).to(INPUT_FOTO)
            );
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_CREAR,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(BTN_CREAR)
        );
    }
}
