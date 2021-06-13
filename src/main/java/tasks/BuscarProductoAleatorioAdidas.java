package tasks;


import interaction.ClickProductoAleatorio;
import interaction.Esperar;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userInterface.AdidasUserInterface;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarProductoAleatorioAdidas implements Task {
    public static String defaultWindows;
//    private String producto;
//
//    public BuscarProductoAleatorioAdidas(String producto) {
//        this.producto = producto;
//    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdidasUserInterface.BTN_CATEGORY_HOMBRE),
                Switch.toWindow(getNewWindowHandle(actor,defaultWindows)),
                Click.on(AdidasUserInterface.BTN_CLOSE_WINDOW_EMERGENTE),
                WaitUntil.the(AdidasUserInterface.BTN_CATEGORY_TENIS,isVisible())
                        .forNoMoreThan(20).seconds(),
                Click.on(AdidasUserInterface.BTN_CATEGORY_TENIS),
                Esperar.estosSegundos(30),
                ClickProductoAleatorio.on(),
                Esperar.estosSegundos(30)
        );
    }

    public static BuscarProductoAleatorioAdidas on(){
        return Instrumented.instanceOf(BuscarProductoAleatorioAdidas.class).withProperties();
    }

    private static String getNewWindowHandle(Actor actor, String currentWindowHandle){
        for (String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                return windowHandle;
            }
        }
        return null;
    }
}
