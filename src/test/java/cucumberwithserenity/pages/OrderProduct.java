package cucumberwithserenity.pages;

import cucumberwithserenity.commonpageobject.WaitFunction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderProduct extends WaitFunction {
    @FindBy(xpath = "//*[@class='btn btn-add-to-cart']")
    private static WebElement BTN_ADD_TO_CART;
    @FindBy(xpath = "//*[@class='btn-view-cart']")
    private static WebElement BTN_VIEW_CART;
    @FindBy(xpath = "//*[@class='cart__submit']")
    private static WebElement BTN_CART_SUBMIT;
    @FindBy(xpath = "//*[@class='btn saving-address']")
    private static WebElement BTN_CHOOSE_ADDRESS;
    @FindBy(xpath = "//ul[@class='list']//child::li[3]/label")
    private static WebElement BTN_CHOOSE_PAYMENT_WAY;
    @FindBy(xpath = "//img[@src='https://salt.tikicdn.com/assets/img/zalopaygw/VCB.jpg']")
    private static WebElement BTN_CHOOSE_PAYMENT_BANK;

    public void getTwoProduct(){
        // Kiểm tra xem đến trang giao diện chi tiết sản phẩm chưa
        Boolean btn = BTN_ADD_TO_CART.isDisplayed();
        Assert.assertTrue(btn);
        //click chọn mua
        BTN_ADD_TO_CART.click();
        waitABit(2000);
        // Kiểm tra xem có hiển thị alert "xem giổ hàng và thanh toán không"
        Boolean alertDisplay = BTN_VIEW_CART.isDisplayed();
        Assert.assertTrue(alertDisplay);
        //click xem giỏ hàng và thanh toán
        BTN_VIEW_CART.click();

        // kiểm tra xem đã đến trang checkout giỏ hàng chưa
        waitABit(2000);
        String actualLink = getDriver().getCurrentUrl();
        Assert.assertEquals("Chưa chuyển đến trang checkout giỏ hàng", actualLink, "https://tiki.vn/checkout/cart");

        waitABit(2000);
        BTN_CART_SUBMIT.click(); //click tiến hành đặt hàng

        // kiểm tra xem đã đến trang "chọn địa chỉ giao hàng""
        waitABit(2000);
        String actualLinkADD = getDriver().getCurrentUrl();
        Assert.assertEquals("Chưa chuyển đến trang chọn địa chỉ giao hàng", "https://tiki.vn/checkout/shipping", actualLinkADD);
    }
    public void chooseAddress(){
        waitABit(3000);
        BTN_CHOOSE_ADDRESS.click(); //click btn: giao hàng dến địa chỉ này

        // Kiểm tra đã điều hướng đên trang chọn hình thức thanh toán chưa
        waitABit(2000);
        String actualLink = getDriver().getCurrentUrl();
        Assert.assertEquals("Chưa chuyển đến trang chọn địa chỉ giao hàng", actualLink, "https://tiki.vn/checkout/payment");
    }
    public void choosePaymenWay(){
        waitABit(7000);
        BTN_CHOOSE_PAYMENT_WAY.click(); // Click chọn thanh toán bằng ATM nội địa
        waitABit(5000);
        BTN_CHOOSE_PAYMENT_BANK.click(); // click chọn ngân hàng Vietcombank

    }

}
