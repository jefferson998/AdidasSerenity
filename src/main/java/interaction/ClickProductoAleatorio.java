package interaction;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import userInterface.AdidasUserInterface;
import variablesGlobales.VariablesGlobales;

import java.util.List;
import java.util.Random;

public class ClickProductoAleatorio implements Interaction{

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Random random = new Random();
		List<WebElementFacade> listaBotonesProductos = AdidasUserInterface.BTN_PRODUCTO_ALEATORIO_ADIDAS.resolveAllFor(actor);
		List<WebElementFacade> listaNombresProductos = AdidasUserInterface.LBL_PRODUCTO_ALEATORIO_ADIDAS.resolveAllFor(actor);
		int numeroAleatorio = random.nextInt(listaBotonesProductos.size());
		VariablesGlobales.nameProductRandom = listaNombresProductos.get(numeroAleatorio).getTextContent();
		listaBotonesProductos.get(numeroAleatorio).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Performable on() {
		return Instrumented.instanceOf(ClickProductoAleatorio.class).withProperties();
	}
}
