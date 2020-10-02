import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import widgests.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class MenuTest {

    MainPage mainPage = new MainPage();
    ResultPage resultPage = new ResultPage();
    MenuPage menuPage = new MenuPage();
    CareersPage careersPage = new CareersPage();
    @BeforeClass
    public static void setUp() {
        //Разворачивает окно браузера во весь экран
        Configuration.startMaximized = true;
    }

    @Before
    public void init () {
        //Открывает проект в браузере для каждого теста
        new BasePage().open();
    }

    @After
    public void tearsDown() {
        //Чистит все куки после каждого теста
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void findNewsAboutArmenia (){
        //Проверяет что при вводе в поиск текста Armenia, поисковик возвращает сообщение  No results found
        mainPage
                .clickSearch()
                .enterSearch("Armenia");
        resultPage
                .resultShouldbe("No results found. Please try a different search.");
    }

    @Test
    public void aboutUsCategories(){
        //Проверяет что категория "О нас" имеет 7 подразделов
        mainPage.clickMenu();
        assertSame(7, menuPage.getNumberOfCategoriesForAboutUs());
    }


    @Test
    public void invalidTestMenuCategories(){
        //Проверяет что "Меню" не имеет 7 разделов
        mainPage.clickMenu();
        assertNotSame(7, menuPage.getNumberOfCategories());
    }

    @Test
    public void testMenuCategories(){
        //Проверяет что "Меню" имеет 6 разделов
        mainPage.clickMenu();
        assertSame(6, menuPage.getNumberOfCategories());
    }

   
    public void openCareers(){
        //Открывает категорию Карьера, скринит содержание контейнера
        //Screen look in \build\reports\tests\1601578464558.0.png
        mainPage.clickMenu();
        menuPage.clickCareers();
        careersPage.getScreenContainer();
    }

    @Test
    public void footerMenuSize(){
        //Проверяет что footer состоит из 8 разделов
        assertSame(8, menuPage.getNumberOfFooterCategories());
    }

    @Test
    public void footerMenuList(){
        //Проверяет что название разделов в footer соответствует ожидаемому
        List<String> footlocker = new ArrayList<String>(Arrays.asList("FAQs", "Report Fraud and Corruption", "Legal", "Privacy Statement", "Access to Information", "Extranet", "Careers", "Contact Us"));
        assert (footlocker.equals(menuPage.getFooterCategories()));
    }
}

