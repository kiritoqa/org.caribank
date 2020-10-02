package widgets;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage clickSearch() {
        $("#edit-submit > .fa").click();
        return this;
    }

    public void enterSearch(String text) {
        $("#edit-keys").val(text).pressEnter();
    }


    public void clickMenu() {
        $("#main-menu-btn").click();
    }
}
