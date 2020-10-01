package widgests;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class BaseMethods {
    public void script_click(String locator){
        Selenide.executeJavaScript("arguments[0].click();", $(locator));
    }
}
