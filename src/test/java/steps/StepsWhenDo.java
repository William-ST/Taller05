package steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import whenDo.CreateTaskForm;
import whenDo.ListViewScreen;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class StepsWhenDo {

    @Given("{actor} has access to whendo")
    public void eynarHasAccessToWhendo(Actor actor) {
    }

    @When("{actor} creates a new task")
    public void heCreatesANewTask(Actor actor, Map<String,String> data) {
        actor.attemptsTo(Click.on(ListViewScreen.addTaskButton));
        actor.attemptsTo(SendKeys.of(data.get("title")).into(CreateTaskForm.titleTextBox));
        actor.attemptsTo(SendKeys.of(data.get("note")).into(CreateTaskForm.noteTextBox));
        actor.attemptsTo(Click.on(CreateTaskForm.saveButton));
    }

    @Then("{actor} expected the task {string} should be displayed")
    public void heExpectedTheTaskShouldBeDisplayed(Actor actor, String expectedResult) {
        actor.should(
                seeThat("verify the task  name is:", Text.of(ListViewScreen.taskLabel),equalTo(expectedResult))
        );
    }
}
