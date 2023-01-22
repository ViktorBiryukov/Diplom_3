import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserSteps {

    public static final String EMAIL_POSTFIX = "@yandex.ru";

    /* метод регистрации нового пользователя
     возвращает мапу с данными: имя, пароль, имэйл
     если регистрация не удалась, возвращает пустую мапу */

    public Map<String, String> createUser() {

        // генерируем имэйл
        String mail = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        // генерируем пароль
        String pass = RandomStringUtils.randomAlphabetic(10);
        // генерируем имя пользователя
        String name = RandomStringUtils.randomAlphabetic(10);

        // создаём и заполняем мапу для передачи параметров в тело запроса
        Map<String, String> inputDataMap = new HashMap<>();
        inputDataMap.put("email", mail);
        inputDataMap.put("password", pass);
        inputDataMap.put("name", name);

        // отправляем запрос на регистрацию пользователя
        UserRegisterResponse response = given()
                .spec(Base.getBaseSpec())
                .and()
                .body(inputDataMap)
                .when()
                .post("auth/register")
                .body()
                .as(UserRegisterResponse.class);

        // возвращаем мапу с данными
        Map<String, String> responseData = new HashMap<>();
        if (response != null) {
            responseData.put("email", response.getUser().getEmail());
            responseData.put("name", response.getUser().getName());
            responseData.put("password", pass);

            // Сохраняем AccessToken и удаляем лишние символы
            // сохраняем refreshToken
            Tokens.setAccessToken(response.getAccessToken().substring(7));
            Tokens.setRefreshToken(response.getRefreshToken());
        }
        return responseData;
    }

    /* удаляем пользователя */
    public void deleteUser() {
        if (Tokens.getAccessToken() == null) {
            return;
        }
        given()
                .spec(Base.getBaseSpec())
                .auth().oauth2(Tokens.getAccessToken())
                .when()
                .delete("auth/user")
                .then()
                .statusCode(202);
    }

}