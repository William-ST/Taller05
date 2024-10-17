package steps;

import calculator.action.MainScreen2;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class StepCalculator {
    @Before
    public void beforeCucumber(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Managed(driver = "appium")
    public WebDriver mobile;
    @Given("{actor} is an user in the calculator")
    public void jbgroupIsAnUserInTheCalculator(Actor actor) {
    }

    @When("{actor} want to add {string} + {string}")
    public void heWantToAdd(Actor actor,String number1, String number2) {
        actor.attemptsTo(Click.on(MainScreen2.fourButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen2.addButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen2.fiveButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen2.equalButton));
    }

    @Then("{actor} expected the result should be {string}")
    public void heExpectedTheResultShouldBe(Actor actor,String expectedResult) {
        theActorInTheSpotlight().should(
                seeThat("Verify the result is: ", Text.of(By.id("com.android.calculator2:id/result")),equalTo(expectedResult))
        );
    }

    @ParameterType(".*")
    public Actor actor(String name){
        return OnStage.theActorCalled(name);
    }
}
