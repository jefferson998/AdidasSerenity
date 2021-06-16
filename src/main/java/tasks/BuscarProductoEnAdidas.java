package tasks;

import interaction.Esperar;
import interaction.changeToWindow;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import userInterface.AdidasUserInterface;
import variablesGlobales.VariablesGlobales;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class BuscarProductoEnAdidas implements Task{
	private String producto;
	public BuscarProductoEnAdidas(String producto) {
		this.producto = producto;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(producto).into(AdidasUserInterface.TXT_BUSCADOR_ADIDAS).thenHit(Keys.ENTER),
				WaitUntil.the(AdidasUserInterface.BTN_PRODUCTO_ADIDAS.of(producto),isVisible()).forNoMoreThan(20).seconds(),
				Click.on(AdidasUserInterface.BTN_PRODUCTO_ADIDAS.of(producto)),
				changeToWindow.on(),
				Click.on(AdidasUserInterface.BTN_CLOSE_WINDOW_EMERGENTE),
				Esperar.estosSegundos(30)
		);
		VariablesGlobales.nameProductRandom = AdidasUserInterface.LBL_PRODUCTO_ADIDAS.resolveFor(actor).getTextContent();
		System.out.println("el producto: "+ AdidasUserInterface.LBL_PRODUCTO_ADIDAS.resolveFor(actor).getTextContent());
	}

	public static BuscarProductoEnAdidas on(String producto) {
		return Instrumented.instanceOf(BuscarProductoEnAdidas.class).withProperties(producto);
	}

}
