package widgets;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage {
    public void resultShouldbe(String text, String result) {
        if (text.equals("Armenia")){
            $("#main-content > .container").shouldHave(exactText(result));}
        else {
            System.out.println("We get some result");
        }
    }
}
