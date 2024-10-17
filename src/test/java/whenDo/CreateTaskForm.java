package whenDo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class CreateTaskForm {

    public static Target titleTextBox = Target.the("[title] textbox")
            .located(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public static Target noteTextBox = Target.the("[note] textbox")
            .located(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public static Target saveButton = Target.the("[save] button")
            .located(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
