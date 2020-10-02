package widgets;

import static com.codeborne.selenide.Selenide.$;

public class CareersPage {
    public void getScreenContainer() {
        $(".quicktabs-tabs").screenshot();
    }
}
