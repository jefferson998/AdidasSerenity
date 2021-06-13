package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarProductoAleatorioAdidas;
import userInterface.AdidasUserInterface;
import variablesGlobales.VariablesGlobales;

import java.io.IOException;

public class AdidasAleatorioStepDefinitions {
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }
    @When("^Buscar un producto aleatorio en el buscador$")
    public void buscarUnProductoAleatorioEnElBuscador() {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoAleatorioAdidas.on());
    }

    @Then("^ver un producto aleatorio y validarlo$")
    public void verUnProductoAleatorioYValidarlo() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                WebElementQuestion.the(AdidasUserInterface.LBL_PRODUCTO_ADIDAS),
                WebElementStateMatchers.containsText(VariablesGlobales.nameProductRandom.toUpperCase())));

    }

}
