package org.example.interfaces.pim;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmpleadoUi {
    private EmpleadoUi() {
    }

    public static final Target BTN_PIM = Target
            .the("Selecciona modulo PIM")
            .located(By.xpath("//*[text()='PIM']"));

    public static final Target BTN_DIRECTORY = Target
            .the("Selecciona modulo PIM")
            .located(By.xpath("//*[text()='Directory']"));

    public static final Target BTN_AGREGAR = Target
            .the("Agregar empleado")
            .located(By.xpath("(//button[@type='button'])[5]"));

    public static final Target LBL_NOMBRE = Target
            .the("Agregar nombre")
            .located(By.xpath("//input[@name='firstName']"));

    public static final Target LBL_APELLIDO = Target
            .the("Agregar apellido")
            .located(By.xpath("//input[@name='lastName']"));

    public static final Target BTN_CREAR = Target
            .the("Guardar empleado")
            .located(By.xpath("//button[@type='submit']"));
    public static final Target INPUT_FOTO = Target
            .the("Cargar foto")
            .located(By.xpath("(//button[@type='button'])[4]"));
    public static final Target LBL_INFORMACION_PERSONAL = Target
            .the("Cargar foto")
            .located(By.xpath("//h6[text()='Personal Details']"));

    public static final Target LBL_BUSCAR_EMPLEADO = Target
            .the("Cargar foto")
            .located(By.xpath("//div/div[2]/div/div/input"));

    public static final Target BTN_BUSCAR = Target
            .the("Buscar empleado")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target cardEmpleado(String nombre) { return Target
            .the("Card con el empleado buscado")
            .located(By.xpath("//p[text()='"+nombre+"']"));
    }
}
