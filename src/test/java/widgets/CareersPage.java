package widgets;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public class CareersPage {
    public void getScreenContainer() {
         $(".quicktabs-tabs").screenshot();
         screenshot("my_file_name");
    }
}
