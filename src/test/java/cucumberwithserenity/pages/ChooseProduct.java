package cucumberwithserenity.pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChooseProduct extends PageObject  {
    @FindBy(xpath = "//span[text()='Điện Thoại - Máy Tính Bảng']")
    private static WebElement BTN_CHOOSE_TYPE_PRODUCT;
    @FindBy(xpath = "//*[@aria-labelledby='heading-category']//following::div[4]")
    private static WebElement BTN_CHOOSE_SUBTYPE_PRODUCT;
    @FindBy(xpath = "//*[@data-impress-list-title='Category | Máy đọc sách']//div[@class='product-item       ']")
    private static WebElement BTN_CHOOSE_PRODUCT;
    @FindBy(xpath = "//*[@data-impress-list-title='Category | Máy đọc sách']//div[@class='product-item       ']")
    private static List<WebElement> BTN_CHOOSE_PRODUCT_LIST;

    public void chooseTypeProduct(){
        BTN_CHOOSE_TYPE_PRODUCT.click();
        waitABit(3000);

        // kiểm tra xem đã điều hướng đến trang Điện thoại- máy tính bảng hay chưa
        Boolean btn = BTN_CHOOSE_SUBTYPE_PRODUCT.isDisplayed();
        Assert.assertTrue(btn);
    }
    public void chooseSubTypeProduct(){
        BTN_CHOOSE_SUBTYPE_PRODUCT.click();
        waitABit(3000);

        //kiểm tra xem đã điều hướng đến trang Máy đọc sách hay chưa
        Boolean btn = BTN_CHOOSE_PRODUCT.isDisplayed();
        Assert.assertTrue(btn);
    }
    public void chooseProduct(){
        BTN_CHOOSE_PRODUCT_LIST.get(5).click();
        waitABit(2000);
    }

}
