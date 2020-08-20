import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

class GoogleTest {
    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }
    @Test
    @DisplayName("Поиск страницы selenide на Yandex.ru")
    public void searchSelenideInYandex() {
            open("https://yandex.ru");
            $("#text").val("selenide").pressEnter();
            $$(".serp-item").shouldHave(sizeGreaterThan(1));
            $("#search-result").shouldBe(visible).shouldHave(
                    text("Selenide: лаконичные и стабильные UI тесты на Java"),
                    text("selenide.org"));
    }
}
