import PageObjects.EntrancePage;
import PageObjects.IngredientsPage;
import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RedirectTest {
    public UserSteps userSteps;
    private RegistrationPage registrationPage;
    private EntrancePage entrancePage;
    public UserRegisterResponse userRegisterResponse;
    private IngredientsPage ingredients;

    @Before
    public void setUp(){
        userSteps = new UserSteps();
        userRegisterResponse= new UserRegisterResponse();

        ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        entrancePage = open ("https://stellarburgers.nomoreparties.site",
                EntrancePage.class);
        registrationPage = open ("https://stellarburgers.nomoreparties.site",
                RegistrationPage.class);
        userSteps.createUser();
    }
    @After
    public void tearDown(){
        userSteps.deleteUser();
    }
    @Test
    @DisplayName("Нажатие кнопки 'Конструктор'. Редирект на главную")
    public void clickingButtonConstructor(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        registrationPage.clickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail,fieldPass);
        entrancePage.clickButtonEntrance();
        registrationPage.clickButtonPersonalArea();
        entrancePage.clickButtonConstructor();
        ingredients.clickButtonFilling();
    }

    @Test
    @DisplayName("Нажатие лого 'Stellar burger'. Редирект на главную")
    public void clickLogoStellarBurgers(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        registrationPage.clickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail,fieldPass);
        entrancePage.clickButtonEntrance();
        registrationPage.clickButtonPersonalArea();
        entrancePage.clickLogoStellarBurgers();
        ingredients.clickButtonFilling();
    }
}
