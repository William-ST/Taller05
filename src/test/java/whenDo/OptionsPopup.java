package whenDo;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class OptionsPopup {
    public static Target deleteOption = Target.the("[delete option]")
            .located(By.xpath("//*[contains(@text, 'Delete')]"));
}
