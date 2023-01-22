import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class UserRegistrationTest {
    @DisplayName("Регистрация нового пользоватля. Авторизация новым пользователем")
    @Test
    public void testSuccessRegistration(){
        RegistrationPage testsSuccessRegistration = open ("https://stellarburgers.nomoreparties.site",
                RegistrationPage.class);

        testsSuccessRegistration.clickButtonPersonalArea();
        testsSuccessRegistration.clickButtonRegistration();

        testsSuccessRegistration.enterAllDataForRegistration(RandomStringUtils.randomAlphabetic(5)+"@mail.ru",
                RandomStringUtils.randomAlphabetic(7),RandomStringUtils.randomAlphabetic(6));

        testsSuccessRegistration.clickButtonRegistrationOnEntrancePage();
        testsSuccessRegistration.clickButtonEntranceOnMainPage();
    }
    @DisplayName("Попытка регистрации нового пользоватля, пароль менее 6 мисволов")
    @Test
    public void testSuccessRegistrationWithError() {
        RegistrationPage testsSuccessRegistrationWithError = open("https://stellarburgers.nomoreparties.site",
                RegistrationPage.class);

        testsSuccessRegistrationWithError.clickButtonPersonalArea();
        testsSuccessRegistrationWithError.clickButtonRegistration();

        testsSuccessRegistrationWithError.enterAllDataForRegistration(RandomStringUtils.randomAlphabetic(5)+"@mail.ru",
                RandomStringUtils.randomAlphabetic(7),RandomStringUtils.randomAlphabetic(4));

        testsSuccessRegistrationWithError.clickError();
        testsSuccessRegistrationWithError.clickButtonRegistrationOnEntrancePage();

    }
}
