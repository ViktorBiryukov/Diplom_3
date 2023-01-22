import PageObjects.EntrancePage;
import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class UserLoginTest {
    public UserSteps userStep;
    private RegistrationPage registrationPage;
    private EntrancePage entrancePage;
    public UserRegisterResponse userRegisterResponse;
    @Before
    public void setUp(){
        userStep = new UserSteps();
        userRegisterResponse= new UserRegisterResponse();
        entrancePage = open ("https://stellarburgers.nomoreparties.site",
                EntrancePage.class);
        registrationPage = open ("https://stellarburgers.nomoreparties.site",
                RegistrationPage.class);
        userStep.createUser();

    }
    @After
    public void tearDown(){
        userStep.deleteUser();
    }

    @DisplayName("Проверка авторизации пользователя по кнопке 'Войти в аккаунт'")
    @Test
    public void testByClickingEntranceInAccount(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        entrancePage.clickButtonEntranceInAccount();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail,fieldPass);
        entrancePage.clickButtonEntrance();
        entrancePage.clickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка кнопки вход при попытке входа в личный кабинет")
    @Test
    public void testByClickingEntrancePersonalArea(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();
        System.out.println(fields);
        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        registrationPage.clickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail, fieldPass);
        entrancePage.clickButtonEntrance();
        entrancePage.clickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка кнопки Вход на странице 'Регистрации'")
    @Test
    public void testByClickingEntranceOnPageRegistration(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        registrationPage.clickButtonPersonalArea();
        entrancePage.clickButtonEntranceRegistrationPage();
        entrancePage.clickButtonEntranceRegistrationPage();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail,fieldPass);
        entrancePage.clickButtonEntrance();
        entrancePage.clickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка кнопки Вход на страниц востановления пароля") //Тоже
    @Test
    public void testByClickingEntranceOnPageRestartPassword(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        registrationPage.clickButtonPersonalArea();
        entrancePage.clickButtonRestorePass();
        entrancePage.clickButtonEntranceRegistrationPage();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail,fieldPass);
        entrancePage.clickButtonEntrance();
        entrancePage.clickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка выхода пользователя")
    @Test
    public void testExit(){
        UserSteps userStep = new UserSteps();
        String fields = userStep.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        registrationPage.clickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPass(fieldsMail, fieldPass);
        entrancePage.clickButtonEntrance();
        registrationPage.clickButtonPersonalArea();
        entrancePage.clickExit();
        registrationPage.clickButtonPersonalArea();
        entrancePage.checkUserNotAuthorise();
    }
}
