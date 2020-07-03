package cucumberwithserenity.steplibrary;

import cucumberwithserenity.pages.ChooseProduct;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


public class ChooseProductSteps {
    ChooseProduct chooseProduct;
    @Step
    public void chooseProducts(){
        chooseProduct.chooseTypeProduct();
        chooseProduct.chooseSubTypeProduct();
        chooseProduct.chooseProduct();
    }


}
