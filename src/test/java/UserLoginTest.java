import PageObjects.EntrancePage;
import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class PersonalAreaTest {
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
        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();

        StringBuilder mail = new StringBuilder(fields);
        mail.delete(45,46);
        String fieldsMail = mail.delete(0,25).toString();

        StringBuilder pass = new StringBuilder(fields);
        pass.delete(0,1);
        String fieldPass = pass.delete(10,46).toString();

        entrancePage.getClickButtonEntranceInAccount();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsMail,fieldPass);
        entrancePage.getClickButtonEntrance();
        entrancePage.getClickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка кнопки вход при попытке входа в личный кабинет")
    @Test
    public void testByClickingEntrancePersonalArea(){
        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();
        System.out.println(fields);
        StringBuilder email = new StringBuilder(fields);
        email.delete(45,46);
        String fieldsEmail = email.delete(0,25).toString();

        StringBuilder password = new StringBuilder(fields);
        password.delete(0,1);
        String fieldPassword = password.delete(10,46).toString();

        registrationPage.getClickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsEmail, fieldPassword);
        entrancePage.getClickButtonEntrance();
        entrancePage.getClickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка кнопки Вход на странице 'Регистрации'")
    @Test
    public void testByClickingEntranceOnPageRegistration(){
        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();

        StringBuilder email = new StringBuilder(fields);
        email.delete(45,46);
        String fieldsEmail = email.delete(0,25).toString();

        StringBuilder password = new StringBuilder(fields);
        password.delete(0,1);
        String fieldPassword = password.delete(10,46).toString();

        registrationPage.getClickButtonPersonalArea();
        entrancePage.getClickButtonEntranceRegistrationPage();
        entrancePage.getClickButtonEntranceRegistrationPage();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsEmail,fieldPassword);
        entrancePage.getClickButtonEntrance();
        entrancePage.getClickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка кнопки Вход на страниц востановления пароля") //Тоже
    @Test
    public void testByClickingEntranceOnPageRestartPassword(){

        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();

        StringBuilder email = new StringBuilder(fields);
        email.delete(45,46);
        String fieldsEmail = email.delete(0,25).toString();

        StringBuilder password = new StringBuilder(fields);
        password.delete(0,1);
        String fieldPassword = password.delete(10,46).toString();

        registrationPage.getClickButtonPersonalArea();
        entrancePage.getClickButtonRestorePassword();
        entrancePage.getClickButtonEntranceRegistrationPage();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsEmail,fieldPassword);
        entrancePage.getClickButtonEntrance();
        entrancePage.getClickButtonEntranceInAccount();
        entrancePage.checkIdOrder();
    }

    @DisplayName("Проверка выхода пользователя")
    @Test
    public void testExit(){
        UserSteps userOperations = new UserSteps();
        String fields = userOperations.createUser().values().toString();

        StringBuilder email = new StringBuilder(fields);
        email.delete(45,46);
        String fieldsEmail = email.delete(0,25).toString();

        StringBuilder password = new StringBuilder(fields);
        password.delete(0,1);
        String fieldPassword = password.delete(10,46).toString();

        registrationPage.getClickButtonPersonalArea();
        registrationPage.getClickButtonPersonalArea();
        registrationPage.getClickButtonPersonalArea();
        entrancePage.setClickAndInputValueFieldEmailAndPassword(fieldsEmail, fieldPassword);
        entrancePage.getClickButtonEntrance();
        entrancePage.getClickExit();
        entrancePage.checkUserNotAuthorise();
    }
}
