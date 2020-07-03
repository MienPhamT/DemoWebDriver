package cucumberwithserenity.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberwithserenity.pages.LoginPage;
import cucumberwithserenity.steplibrary.ChooseProductSteps;
import cucumberwithserenity.steplibrary.LoginSteps;
import cucumberwithserenity.steplibrary.OrderProductStep;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefs {
    @Steps
    LoginSteps loginSteps;
    @Steps
    ChooseProductSteps chooseProductSteps;
    @Steps
    OrderProductStep orderProductStep;

    @Given("go to Tiki")
    public void goToTiki() {
        loginSteps.goToTikiBrowser();
    }

    @When("login Tiki by facebook {string} {string}")
    public void loginTikiByFacebok(String user, String pass) {
        loginSteps.loginPageStep(user, pass);
    }

    @And("choose product")
    public void chooseProduct() {
        chooseProductSteps.chooseProducts();
    }

    @And("order product")
    public void orderProduct() {
        orderProductStep.orderProduct();
    }

}
