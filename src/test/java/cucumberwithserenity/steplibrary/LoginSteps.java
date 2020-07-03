package cucumberwithserenity.steplibrary;

import cucumberwithserenity.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {
    LoginPage loginPage;
    @Step
     public void goToTikiBrowser(){
        loginPage.goToTiki();
    }

    @Step
    public void loginPageStep(String user, String pass){
        loginPage.clickBtnUserLogin();
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.click_Btn_Login();
    }

}
