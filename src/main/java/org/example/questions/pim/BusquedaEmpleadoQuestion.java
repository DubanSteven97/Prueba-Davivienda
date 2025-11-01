package org.example.questions.pim;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.example.interfaces.pim.EmpleadoUi;

public class BusquedaEmpleadoQuestion implements Question<Boolean> {

    private final String nombre;

    public BusquedaEmpleadoQuestion(String nombre) {
        this.nombre = nombre;
    }

    public static Question<Boolean> verificarBusqueda(String nombre) {
        return new BusquedaEmpleadoQuestion(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return EmpleadoUi.cardEmpleado(nombre).isVisibleFor(actor);
    }
}
