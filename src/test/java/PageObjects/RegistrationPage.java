package PageObjects;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    public SelenideElement buttonPersonalArea;

    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    public SelenideElement buttonRegistration;

    @FindBy(how = How.XPATH,using = ".//input[@class = 'text input__textfield text_type_main-default']")
    public SelenideElement fieldName;

    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input[@class='text input__textfield text_type_main-default']")
    public SelenideElement fieldMail;

    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input[@class='text input__textfield text_type_main-default']")
    public SelenideElement fieldPass;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement buttonRegistrationDouble;

    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    public SelenideElement buttonEntrance;

    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement error;

    public void clickButtonPersonalArea(){
        buttonPersonalArea.click();
    }

    public void clickButtonRegistration(){
        buttonRegistration.click();
    }

    public void clickFieldName(){
        fieldName.click();
    }

    public void clickFieldMail(){
        fieldMail.click();
    }

    public void clickFieldPass(){
        fieldPass.click();
    }

    public void clickButtonEntranceOnMainPage(){
        buttonEntrance.click();
    }

    public void clickButtonRegistrationOnEntrancePage(){
        buttonRegistrationDouble.click();
    }

    public void clickError(){
        error.click();
    }

    public void enterValueFieldPass(String pass){
        fieldPass.setValue(pass);
    }

    public void enterValueFieldMail(String mail){
        fieldMail.setValue(mail);
    }

    public void enterValueFieldName(String name){
        fieldName.setValue(name);
    }

    @Step
    public void enterValueFieldEmailStep(String mail) {
        clickFieldMail();
        enterValueFieldMail(mail);
    }

    @Step
    public void enterValueFieldNameStep(String name){
        clickFieldName();
        enterValueFieldName(name);
    }

    @Step
    public void enterValueFieldPasswordStep(String pass){
        clickFieldPass();
        enterValueFieldPass(pass);
    }

    @Step
    public void enterAllDataForRegistration(String mail, String name, String pass){
        enterValueFieldName(name);
        enterValueFieldMail(mail);
        enterValueFieldPass(pass);
    }
}