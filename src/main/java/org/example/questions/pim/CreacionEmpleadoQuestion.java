package org.example.questions.pim;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.questions.login.LoginQuestion;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.interfaces.pim.EmpleadoUi.LBL_INFORMACION_PERSONAL;
import static org.example.utilidades.Constantes.TIEMPO_ESPERA;

public class CreacionEmpleadoQuestion implements Question<Boolean> {

    public static CreacionEmpleadoQuestion verificarCreacion() {
        return new CreacionEmpleadoQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LBL_INFORMACION_PERSONAL,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds()
        );
        return LBL_INFORMACION_PERSONAL.isVisibleFor(actor);
    }
}
