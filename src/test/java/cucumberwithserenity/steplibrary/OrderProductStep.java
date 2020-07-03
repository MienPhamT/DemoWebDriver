package cucumberwithserenity.steplibrary;

import cucumberwithserenity.pages.OrderProduct;
import net.thucydides.core.annotations.Step;

public class OrderProductStep {
    OrderProduct oder;
    @Step
    public void orderProduct(){
        oder.getTwoProduct();
        oder.chooseAddress();
        oder.choosePaymenWay();
    }

}
