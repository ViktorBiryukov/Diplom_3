import PageObjects.IngredientsPage;
import io.qameta.allure.junit4.DisplayName;
import static org.junit.Assert.*;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    @DisplayName("Test click on filling")
    @Test
    public void testClickOnFilling(){
        IngredientsPage ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        ingredients.checkTransitionFillingSection();
        assertTrue("Неверный раздел",ingredients.checkIsRealFillingSection());

    }
    @DisplayName("Test click on sauce")
    @Test
    public void testClickOnSauce(){
        IngredientsPage ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        ingredients.checkTransitionFillingSection();
        ingredients.checkTransitionSauceSection();
        assertTrue("Неверный раздел",ingredients.checkIsRealSauceSection());
    }
    @DisplayName("Test click on bun")
    @Test
    public void testClickOnBun(){
        IngredientsPage ingredients = open ("https://stellarburgers.nomoreparties.site",
                IngredientsPage.class);
        ingredients.checkTransitionFillingSection();

        ingredients.checkTransitionBunSection();
        assertTrue("Неверный раздел",ingredients.checkIsRealBunSection());
    }
}
