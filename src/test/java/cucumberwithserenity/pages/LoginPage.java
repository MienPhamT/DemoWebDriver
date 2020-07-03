package cucumberwithserenity.pages;

import cucumberwithserenity.commonpageobject.WaitFunction;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends WaitFunction {
    @FindBy(xpath = "//*[@class='Userstyle__NoWrap-sc-6e6am-11 cbYxcp']")
    private static WebElement ACCOUNT_HOVER;
    @FindBy(xpath = "//button[text()='Đăng nhập bằng Facebook']" )
    private static WebElement BTN_LOGINBYFACEBOOK;
    @FindBy(xpath = "//*[text()='Chào Miền Phạm']")
    private static WebElement TXT_CHECK_ACCOUNT_NAME;

    public void goToTiki() {
        // mở trang chủ Tiki
        getDriver().get("https://tiki.vn/?src=header_tiki");

        // kiểm tra xem đã vào đúng trang chủ Tiki hay chưa
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals("False - go to Tiki homepage", actualTitle, "Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
        getDriver().manage().window().maximize(); // mở rộng màn hình

        //bỏ qua quảng cáo
        By adElement = By.xpath("//*[@id='onesignal-popover-cancel-button']");
        explicit_visibilityOfElementLocated(adElement);
        getDriver().findElement(adElement).click();
    }
    public void clickBtnUserLogin() {
        //Hover đến tài khoản
        Actions mouseHover = new Actions(getDriver());
        mouseHover.moveToElement(ACCOUNT_HOVER).perform();

        // CLick button đăng nhập bằng facebook
        BTN_LOGINBYFACEBOOK.click();
    }
    // Tìm kiếm cửa sổ đang chạy.
    public WebDriver findWindow(String win){
        WebDriver popup = null;
        for(String windowHandle: getDriver().getWindowHandles()){
            popup = getDriver().switchTo().window(windowHandle);
            if (popup.getTitle().equals(win))
                break;
        }
        return popup;
    }
    public void enterUsername(String user) {
        waitABit(3000);
        // Kiểm tra xem đã tìm thấy cửa sổ đăng nhập bằng facebook chưa
        String actualTitle = findWindow("Facebook").getTitle();
        Assert.assertEquals("Không tìm thấy cửa sổ đăng nhập bằng facebook",actualTitle, "Facebook");
        //Enter the username
        findWindow("Facebook").findElement(By.xpath("//*[@id='email']")).sendKeys(user);
    }
    public void enterPassword(String pass) {
        By password  = By.xpath("//*[@id='pass']");
        findWindow("Facebook").findElement(password).sendKeys(pass);
    }
    public void click_Btn_Login() {
        findWindow("Facebook").findElement(By.xpath("//*[@id='loginbutton']")).click();
        findWindow("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn").navigate();
        waitABit(5000);
        // Kiểm tra xem đã điều hướng đến trang chủ Tiki của người dùng chưa
        Boolean btn = TXT_CHECK_ACCOUNT_NAME.isDisplayed();
        Assert.assertTrue(btn);

    }
}