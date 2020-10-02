import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import widgets.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
import static org.junit.Assert.*;


public class MenuTest {

    MainPage mainPage = new MainPage();
    ResultPage resultPage = new ResultPage();
    MenuPage menuPage = new MenuPage();
    CareersPage careersPage = new CareersPage();
    @BeforeClass
    public static void setUp() {
        Configuration.startMaximized = true;
    }

    @Before
    public void init () {
        new BasePage().open();
    }

    @After
    public void tearsDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void shouldReturnNoResultsFroArmenia (){
        mainPage
                .clickSearch()
                .enterSearch("Armenia");
        resultPage
                .resultShouldbe("No results found. Please try a different search.");
    }

    @Test
    public void testAboutUsCategories(){
        mainPage.clickMenu();
        assertSame(7, menuPage.getNumberOfCategoriesForAboutUs());
    }


    @Test
    public void testMainMenuCategoriesQuantity(){
        mainPage.clickMenu();
        assertSame(6, menuPage.getNumberOfCategories());
    }

    public void screenCareers(){
        //Screen look in \build\reports\tests\1601578464558.0.png
        mainPage.clickMenu();
        menuPage.clickCareers();
        careersPage.getScreenContainer();
    }

    @Test
    public void footerMenuSize(){
        assertSame(8, menuPage.getNumberOfFooterCategories());
    }

    @Test
    public void footerItemsShouldMatchExpected(){
        List<String> footlocker = new ArrayList<String>(Arrays.asList("FAQs", "Report Fraud and Corruption", "Legal", "Privacy Statement", "Access to Information", "Extranet", "Careers", "Contact Us"));
        assert (footlocker.equals(menuPage.getFooterCategories()));
    }
}

