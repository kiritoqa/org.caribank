package widgests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage {
    public void resultShouldbe(String text) {
        $("#main-content > .container").shouldHave(exactText(text));
    }
}
