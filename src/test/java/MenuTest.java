import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.testng.Assert;
import org.testng.annotations.*;
import widgets.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuTest {

    MainPage mainPage = new MainPage();
    ResultPage resultPage = new ResultPage();
    MenuPage menuPage = new MenuPage();
    CareersPage careersPage = new CareersPage();

    @BeforeClass
    void inicializatedriver(){
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    void setUp(){
        new BasePage().open();
    }

    @Test
    void shouldReturnNoResultsFroArmenia (){

        mainPage
                .clickSearch()
                .enterSearch("Armenia");
        resultPage
                .resultShouldbe("Armenia", "No results found. Please try a different search.");
    }

    @Test
    public void footerItemsShouldMatchExpected(){
        List<String> footlocker = new ArrayList<String>(Arrays.asList("FAQs", "Report Fraud and Corruption", "Legal", "Privacy Statement", "Access to Information", "Extranet", "Careers", "Contact Us"));
        assert (footlocker.equals(menuPage.getFooterCategories()));
    }

    @Test(enabled = false)
    public void screenCareers(){
        //Screen look in \build\reports\tests\1601578464558.0.png
        mainPage.clickMenu();
        menuPage.clickCareers();
        careersPage.getScreenContainer();
    }

    @Test
   public void testAboutUsCategories(){
        mainPage.clickMenu();
        Assert.assertEquals(7, menuPage.getNumberOfCategoriesForAboutUs());
    }

    @Test
    public void testMainMenuCategoriesQuantity(){
        mainPage.clickMenu();
        Assert.assertEquals(6, menuPage.getNumberOfCategories());
    }


    @Test
    public void footerMenuSize(){
        Assert.assertEquals(8, menuPage.getNumberOfFooterCategories());
    }

}

