package whenDo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ListViewScreen {
    public static Target addTaskButton = Target.the("[add task] button")
            .located(By.id("com.vrproductiveapps.whendo:id/fab"));

    public static Target taskLabel = Target.the("[name task] label")
            .located(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));

    public static Target taskList = Target.the("[task list]")
            .located(By.id("com.vrproductiveapps.whendo:id/notesList"));

    public static Target options = Target.the("[options]")
            .located(By.xpath("//*[contains(@content-desc, 'options')]"));

    public static Target firstTaskCheck = Target.the("[first task]")
            .located(By.xpath("(//android.widget.ImageButton[@content-desc='Mark Done'])[1]"));

}
