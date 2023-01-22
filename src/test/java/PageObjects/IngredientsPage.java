package PageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IngredientsPage {

    @FindBy(how = How.XPATH, using = ".//div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement buttonFilling;

    @FindBy(how = How.XPATH,using = ".//div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement buttonSauce;

    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement buttonBun;

    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    public SelenideElement visibleHeader;

    @Step
    public void clickButtonBun(){
        buttonBun.click();
    }

    @Step
    public boolean checkBunSection(){
        return visibleHeader.getText().contentEquals("Булки");
    }

    @Step
    public void clickButtonSauce(){
        buttonSauce.click();
    }

    @Step
    public boolean checkSauceSection(){
        return visibleHeader.getText().contentEquals("Соусы");
    }

    @Step
    public void clickButtonFilling(){
        buttonFilling.click();
    }

    @Step
    public boolean checkFillingSection(){
        return visibleHeader.getText().contentEquals("Начинки");
    }
}