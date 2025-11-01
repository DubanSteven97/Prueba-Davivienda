package org.example.questions.login;

import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.interfaces.login.LoginUi.LBL_DASHBOARD;
import static org.example.utilidades.Constantes.TIEMPO_ESPERA;

public class LoginQuestion implements Question<Boolean> {


    public static LoginQuestion verificarLogin() {
        return new LoginQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LBL_DASHBOARD,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds()
        );
        return LBL_DASHBOARD.isVisibleFor(actor);
    }
}
