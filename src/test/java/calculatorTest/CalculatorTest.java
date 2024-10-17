package calculatorTest;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static org.hamcrest.CoreMatchers.equalTo;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import calculator.action.MainScreen2;

@ExtendWith(SerenityJUnit5Extension.class)
public class CalculatorTest {

    @Managed(driver = "Appium")
    public WebDriver hisMobileDevice;
    @BeforeEach
    public void before(){
        // si ya tenemos un appium server corriendo
        OnStage.setTheStage(new OnlineCast());
    }
    @AfterEach
    public void after(){
        //
    }
    @Test
    public void calculatorAddTest(){
        theActorCalled("jbgroup").attemptsTo(Click.on(MainScreen2.fourButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen2.addButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen2.fiveButton));
        theActorInTheSpotlight().attemptsTo(Click.on(MainScreen2.equalButton));
        // verification
        Question<String> result = Text.of(By.id("com.miui.calculator:id/result"));
        System.out.println("=== === === === HERE:");
        System.out.println(result.toString());
        theActorInTheSpotlight().should(
                seeThat("Verify the result is: ", result,equalTo("9"))
        );
    }
}