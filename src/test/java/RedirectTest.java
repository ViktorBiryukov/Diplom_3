import PageObjects.EntrancePage;
import PageObjects.IngredientsPage;
import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class PersonalAreaTest {
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
    @DisplayName("Нажатие кнопки 'Конструктор'. Редирект на главную")
    @Test
    public void clickingButtonConstructor(){
        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();

        StringBuilder email = new StringBuilder(fields);
        email.delete(45,46);
        String fieldsEmail = email.delete(0,25).toString();

        StringBuilder password = new StringBuilder(fields);
        password.delete(0,1);
        String fieldPassword = password.delete(10,46).toString();

        registrationPage.getClickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsEmail,fieldPassword);
        entrancePage.getClickButtonEntrance();
        registrationPage.getClickButtonPersonalArea();
        entrancePage.getClickButtonConstructor();
        ingredients.checkTransitionFillingSection();
    }

    @DisplayName("Нажатие лого 'Stellar burger'. Редирект на главную")
    @Test
    public void clickLogoStellarBurgers(){
        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();

        StringBuilder email = new StringBuilder(fields);
        email.delete(45,46);
        String fieldsEmail = email.delete(0,25).toString();

        StringBuilder password = new StringBuilder(fields);
        password.delete(0,1);
        String fieldPassword = password.delete(10,46).toString();

        registrationPage.getClickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsEmail,fieldPassword);
        entrancePage.getClickButtonEntrance();
        registrationPage.getClickButtonPersonalArea();
        entrancePage.getClickButtonStellarBurgers();
        ingredients.checkTransitionFillingSection();
    }
}
