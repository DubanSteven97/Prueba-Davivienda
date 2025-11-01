package org.example.interfaces.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUi {
    private LoginUi() {
    }

    public static final Target LBL_USUARIO = Target
            .the("Campo para ingresar usuario")
            .located(By.xpath("//input[@name='username']"));

    public static final Target LBL_CLAVE = Target
            .the("Campo para ingresar clave")
            .located(By.xpath("//input[@name='password']"));

    public static final Target BTN_LOGIN = Target
            .the("Campo para ingresar usuario")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target LBL_DASHBOARD = Target
            .the("Header del dashboard")
            .located(By.xpath("//span[text()='Dashboard']"));


}
