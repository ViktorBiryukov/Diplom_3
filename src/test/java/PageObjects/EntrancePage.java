package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EntrancePage {

    @FindBy(how = How.XPATH,using = ".//input[@class = 'text input__textfield text_type_main-default']")
    public SelenideElement fieldMail;

    @FindBy(how = How.XPATH, using = ".//input[@type = 'password']")
    public SelenideElement getFieldPass;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement buttonEntrance;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    public SelenideElement buttonEntranceRegistrationPage;

    @FindBy(how = How.LINK_TEXT, using = "Восстановить пароль")
    public SelenideElement buttonRestorePass;

    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    public SelenideElement buttonConstructor;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    public SelenideElement logoStellarBurgers;

    @FindBy(how = How.XPATH, using = ".//li/button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    public SelenideElement buttonExit;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement buttonEntranceDuble;

    @FindBy(how = How.XPATH, using = ".//p[@class='undefined text text_type_main-medium mb-15']")
    public SelenideElement idOrder;

    @FindBy(how = How.TAG_NAME, using = "h2")
    public SelenideElement checkExit;

    @Step
    public void checkUserNotAuthorise(){
        checkExit.shouldBe(Condition.visible);
    }

    @Step
    public void checkIdOrder(){
        idOrder.shouldBe(Condition.visible);
    }

    @Step
    public void clickButtonEntranceInAccount(){
        buttonEntranceDuble.click();
    }

    @Step
    public void clickExit(){
        buttonExit.click();
    }

    @Step
    public void clickFieldMail(){
        fieldMail.click();
    }

    @Step
    public void clickFieldPass(){
        getFieldPass.click();
    }

    @Step
    public void clickButtonEntrance(){
        buttonEntrance.click();
    }

    @Step
    public void clickButtonEntranceRegistrationPage(){
        buttonEntranceRegistrationPage.click();
    }

    @Step
    public void clickButtonRestorePass(){
        buttonRestorePass.click();
    }

    @Step
    public void clickButtonConstructor(){
        buttonConstructor.click();
    }

    @Step
    public void clickLogoStellarBurgers(){
        logoStellarBurgers.click();
    }

    @Step
    public void enterValueMail(String mail){
        fieldMail.setValue(mail);
    }

    @Step
    public void enterValueFieldPass(String pass){
        getFieldPass.setValue(pass);
    }

    @Step
    public void clickAndEnterValueFieldMail(String mail){
        clickFieldMail();
        enterValueMail(mail);
    }

    @Step
    public void clickAndEnterValueFieldPass(String pass){
        clickFieldPass();
        enterValueFieldPass(pass);
    }

    @Step
    public void setClickAndInputValueFieldEmailAndPass(String mail, String pass){
        clickAndEnterValueFieldMail(mail);
        clickAndEnterValueFieldPass(pass);
    }
}