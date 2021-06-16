package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Producto;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarProductoEnAdidas;
import userInterface.AdidasUserInterface;
import variablesGlobales.VariablesGlobales;

import java.io.IOException;
import java.util.List;

public class AdidasBackgroundStepDefinitions {
    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }
    @When("^Buscar un producto en el buscador$")
    public void buscarUnProductoEnElBuscador(List<Producto> productos) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoEnAdidas.on(productos.get(0).getNameProduct()));
    }

    @Then("^ver el producto y validarlo$")
    public void verElProductoYValidarlo() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                WebElementQuestion.the(AdidasUserInterface.LBL_PRODUCTO_ADIDAS),
                WebElementStateMatchers.containsText(VariablesGlobales.nameProductRandom.toUpperCase())));
    }
}
