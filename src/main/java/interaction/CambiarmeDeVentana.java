package interaction;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.Iterator;
import java.util.Set;

public class CambiarmeDeVentana implements Interaction {
    private static String defaultWindows;


    @Override
    public <T extends Actor> void performAs(T actor) {
        defaultWindows = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        boolean validacionPantalla = false;
        while (!validacionPantalla) {
            Set<String> lista = BrowseTheWeb.as(actor).getDriver().getWindowHandles();
            if (lista.size() > 1) {
                validacionPantalla = true;
                Iterator<String> I1 = lista.iterator();
                while (I1.hasNext()) {
                    String child_window = I1.next();

                    if (!defaultWindows.equals(child_window)) {
                        BrowseTheWeb.as(actor).getDriver().switchTo().window(child_window);

                    }
                }

            }
        }



    }
    public static Performable on(){
        return Instrumented.instanceOf(CambiarmeDeVentana.class).withProperties();
    }
}
