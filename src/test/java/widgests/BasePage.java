package widgests;

import com.codeborne.selenide.Selenide;

public class BasePage {

    public void open(){
        Selenide.open("https://www.caribank.org/");
    }
}
