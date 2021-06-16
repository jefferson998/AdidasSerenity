package stepDefinitions;


import driver.SeleniumWebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
	public void meEncuentroEnLaPaginaDeAdidasEnLaUrlHttpsWwwAdidasCo(String url) {
		OnStage.theActorCalled("Jefferson").can(BrowseTheWeb.with(SeleniumWebDriver.ChromeWebDriver().on(url)));
	}


	@When("^Buscar el producto (.*) en el buscador exitoso o fallido$")
	public void buscarElProductoTenisDFUSIOEnElBuscadorExitosoOFallido(String producto) {
		OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoEnAdidas.on(producto));
	}

	@Then("^ver el producto (.*) y validarlo si es correcto o incorrecto$")
	public void verElProductoTenisDFUSIOYValidarloSiEsCorrectoOIncorrecto(String producto) {
		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
				WebElementQuestion.the(AdidasUserInterface.LBL_PRODUCTO_ADIDAS),
				WebElementStateMatchers.containsText(producto.toUpperCase())));
	}





//	@Given("^Me encuentro en la pagina de Adidas url (.*)$")
//	public void meEncuentroEnLaPaginaDeAdidasUrl(String url) {
//		OnStage.theActorCalled("Jefferson").can(BrowseTheWeb.with(SeleniumWebDriver.ChromeWebDriver().on(url)));
//	}
//
//
//	@When("^Buscar el producto (.*) en el buscador$")
//	public void buscarElProductoEnElBuscador(String producto) {
//		OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoEnAdidas.on(producto));
//	}
//
//	@Then("^ver el producto (.*) y validarlo$")
//	public void verElProductoYValidarlo(String producto) {
//		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
//				WebElementQuestion.the(AdidasUserInterface.LBL_PRODUCTO_ADIDAS),
//				WebElementStateMatchers.containsText(producto.toUpperCase())));
//
//	}


}
