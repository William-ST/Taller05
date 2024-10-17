package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;
import whenDo.CreateTaskForm;
import whenDo.DeleteTaskDialog;
import whenDo.ListViewScreen;
import whenDo.OptionsPopup;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class StepsWhenDoDeleteTask {
    @Given("{actor} has access to whendo with {int} task")
    public void eynarHasAccessToWhendoWithCountTask(Actor actor, int startCount) {
        for (int i = 0; i < startCount; i++) {
            actor.attemptsTo(Click.on(ListViewScreen.addTaskButton));
            actor.attemptsTo(SendKeys.of("title"+(i+1)).into(CreateTaskForm.titleTextBox));
            actor.attemptsTo(SendKeys.of("note"+(i+1)).into(CreateTaskForm.noteTextBox));
            actor.attemptsTo(Click.on(CreateTaskForm.saveButton));
        }
    }

    @When("{actor} deletes one task")
    public void heDeletesOneTask(Actor actor) {
        actor.attemptsTo(Click.on(ListViewScreen.firstTaskCheck));
        actor.attemptsTo(Click.on(ListViewScreen.options));
        actor.attemptsTo(Click.on(OptionsPopup.deleteOption));
        actor.attemptsTo(Click.on(DeleteTaskDialog.confirm));
    }

    @Then("{actor} expected the tasks count to be {int}")
    public void heExpectedTheTasksCountToBe(Actor actor, int expectedCount) {
        int endCount = ListViewScreen.taskList.resolveAllFor(actor).size();
        System.out.println("=== === heExpectedTheTasksCountToBe === ===");
        System.out.println("=== endCount: "+endCount);
        System.out.println("=== expectedCount: "+expectedCount);
        actor.should(seeThat("", actor1 -> endCount, equalTo(expectedCount)));

    }

}
