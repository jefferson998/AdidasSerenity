package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarProductoEnAdidas;
import userInterface.AdidasUserInterface;

import java.io.IOException;

public class AdidasBuscadorStepDefinitions {

	@Before
	public void before() throws IOException {
		OnStage.setTheStage(new OnlineCast());
	}
	@Given("^Me encuentro en la pagina de Adidas en la url (.*)$")
	public void meEncuentroEnLaPaginaDeAdidasEnLaUrl(String url) {
		OnStage.theActorCalled("Jefferson").can(BrowseTheWeb.with(
				SeleniumWebDriver.ChromeWebDriver().on(url)));
	}


	@When("^Buscar el producto (.*) en el buscador$")
	public void buscarElProductoEnElBuscadorExitosoOFallido(String producto) {
		OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoEnAdidas.on(producto));
	}

	@Then("^ver el producto (.*) y validarlo$")
	public void verElProductoYValidarlo(String producto) {
		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
				WebElementQuestion.the(AdidasUserInterface.LBL_PRODUCTO_ADIDAS),
				WebElementStateMatchers.containsText(producto.toUpperCase())));
	}
}
