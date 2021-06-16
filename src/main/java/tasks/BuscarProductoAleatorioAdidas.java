package tasks;


import interaction.ClickProductoAleatorio;
import interaction.Esperar;
import interaction.changeToWindow;
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

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdidasUserInterface.BTN_CATEGORY_HOMBRE),
                changeToWindow.on(),
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
}
