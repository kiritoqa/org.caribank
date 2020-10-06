import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import widgets.BasePage;
import widgets.MainPage;
import widgets.ResultPage;

import java.util.Map;

public class DataproviderExample {
    MainPage mainPage = new MainPage();
    ResultPage resultPage = new ResultPage();

    @Test(dataProvider ="csvReader", dataProviderClass = CsvDataProviders.class)
    public void shouldReturnNoResultsFroArmenia(Map<String, String> testData){
        String text = testData.get("text");
        String result = testData.get("result");

        Configuration.startMaximized = true;
        new BasePage().open();
        mainPage
                .clickSearch()
                .enterSearch(text);
        resultPage
                .resultShouldbe(text,result);
    }

}
