package whenDo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class DeleteTaskDialog {
    public static Target confirm = Target.the("[confirm delete]")
            .located(By.id("android:id/button1"));
}
