package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
    public static WebElement waitBy(WebElement element){
        try {
            new WebDriverWait(Hook.driver, 40).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            System.err.println(element + " não encontrado...");
        }

        return element;
    }
}
