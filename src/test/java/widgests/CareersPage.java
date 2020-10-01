package widgests;

import static com.codeborne.selenide.Selenide.$;

public class CareersPage {
    public void getScreenContainer() {
        $(".quicktabs-tabs").screenshot();
    }
}
