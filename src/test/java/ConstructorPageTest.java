import PageObjects.IngredientsPage;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.*;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorPageTest {

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void testClickOnFilling(){
        IngredientsPage ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        ingredients.clickButtonFilling();
        assertTrue("Неверный раздел",ingredients.checkFillingSection());

    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void testClickOnSauce(){
        IngredientsPage ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        ingredients.clickButtonFilling();
        ingredients.clickButtonSauce();
        assertTrue("Неверный раздел",ingredients.checkSauceSection());
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Булки'")
    public void testClickOnBun(){
        IngredientsPage ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        ingredients.clickButtonFilling();
        ingredients.clickButtonBun();
        assertTrue("Неверный раздел",ingredients.checkBunSection());
    }
}
