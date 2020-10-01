package widgests;

import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuPage {



    public int shouldHaveNumberCategories() {
        return $$(".toolbar-menu").size();
    }

    public int aboutUsShouldHaveNumberCategories() {
        return $$(By.xpath("//*[@id=\"block-cdb-main-menu\"]/div/div[2]/div[1]/div/ul/li")).size();
    }

    public void clickCareers() {
        $(By.linkText("Careers")).click();
    }

    public List<String> footrestsHaveListCategories() {
        return $$(By.xpath("//nav/ul/li/a")).texts();
    }

    public int footrestsHaveNumberCategories() {
        return $$(By.xpath("//nav/ul/li/a")).size();
    }
}
