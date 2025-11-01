package org.example.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.interfaces.login.LoginUi.*;
import static org.example.utilidades.Constantes.TIEMPO_ESPERA;

public class LoginTask implements Task {
    private String usuario;
    private String clave;
    public LoginTask(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public static LoginTask digitar(String usuario, String clave) {
        return instrumented(LoginTask.class, usuario,clave);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LBL_USUARIO,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(usuario).into(LBL_USUARIO),
                WaitUntil.the(LBL_CLAVE,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(clave).into(LBL_CLAVE),
                WaitUntil.the(BTN_LOGIN,isPresent()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(BTN_LOGIN)
        );
    }
}