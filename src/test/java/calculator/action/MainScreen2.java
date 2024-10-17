package calculator.action;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class MainScreen2 {

    public static String foo = "";
    public static Target fiveButton = Target.the("[5] button").located(By.id("com.miui.calculator:id/digit_5"));
    public static Target addButton = Target.the("[+] button").located(By.id("com.miui.calculator:id/op_add"));
    public static Target fourButton = Target.the("[4] button").located(By.id("com.miui.calculator:id/digit_4"));
    public static Target equalButton = Target.the("[=] button").located(By.id("com.miui.calculator:id/btn_equal_s"));

}
