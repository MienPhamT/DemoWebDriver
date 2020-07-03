package cucumberwithserenity.commonpageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WaitFunction extends PageObject {


    public WebElement explicit_visibilityOfElementLocated(By path){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
}
