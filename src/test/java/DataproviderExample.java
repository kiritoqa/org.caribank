import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import widgets.BasePage;
import widgets.MainPage;
import widgets.ResultPage;

public class DataproviderExample {
    MainPage mainPage = new MainPage();
    ResultPage resultPage = new ResultPage();

    @BeforeClass
    void inicializatedriver(){
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    void setUp(){
        new BasePage().open();
    }

    @Test(dataProvider ="Search")
    void shouldReturnNoResultsFroArmenia (String text, String result){

        mainPage
                .clickSearch()
                .enterSearch(text);
        resultPage
                .resultShouldbe(result);
    }

    @DataProvider(name="Search")
    public Object[][] getData(){

        Object[][] data = {{"Armenia", "No results found. Please try a different search."},{"America", "We get some result"}, {"News", "We get some result"}};
        return data;
    }

}
