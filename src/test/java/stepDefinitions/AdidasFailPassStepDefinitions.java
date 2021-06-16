package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import models.Producto;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarProductoEnAdidas;
import userInterface.AdidasUserInterface;
import variablesGlobales.VariablesGlobales;

import java.io.IOException;
import java.util.List;

public class AdidasFailPassStepDefinitions {
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Me encuentro en la pagina de Adidas url (.*)$")
    public void meEncuentroEnLaPaginaDeAdidasUrl(String url) {
        OnStage.theActorCalled("Jefferson").can(BrowseTheWeb.with(
                SeleniumWebDriver.ChromeWebDriver().on(url)));
    }

    @When("^Buscar el producto en el buscador$")
    public void buscarElProductoEnElBuscador(List<Producto> productos) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoEnAdidas.on(
                productos.get(0).getNameProduct()));
    }

    @Then("^ver el producto y validarlo si se encuentra o no$")
    public void verElProductoYValidarloSiSeEncuentraONo() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                WebElementQuestion.the(AdidasUserInterface.LBL_PRODUCTO_ADIDAS),
                WebElementStateMatchers.containsText(VariablesGlobales.nameProductRandom.toUpperCase())));
    }
}
