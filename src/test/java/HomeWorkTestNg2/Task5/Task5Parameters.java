package HomeWorkTestNg2.Task5;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
/*
Task5:
        Решить предыдущую задачи используя аннотацию @Parameters. А также создать для работы с
        данным тестом дополнительный xml файл testngParametersHome.xml.
*/

public class Task5Parameters {
    WebDriver driver;
    MyWaiters myWaiters;

    @BeforeClass
    public void driverInitialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        myWaiters = new MyWaiters(driver);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath(
                "//div[@id='user-location-popup']//i[@class='icon icon-close']")).click();
    }

    @Test
    @Parameters({"input"})
    public void SearchTask4(String searchParams)  {

        Actions actions = new Actions(driver);
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//input[@type='search']"));
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        String input = searchParams;
        searchField.sendKeys(input);
        driver.findElement(By.xpath("//input[@value='Знайти']")).click();

        // if(driver.findElement(By.xpath("//div[@class='page__title']/h1")).isDisplayed())
        //{
        WebElement resultSearch = myWaiters.waitPresenceOfElementReturn(By.xpath(
                "//div[@class='page__title']/h1"));
        String resultUpdate = resultSearch.getText().replace("Знайдено по запиту ", "");
        assertTrue(resultUpdate.equals("«" +input+ "»"));//}

        //WebElement senseSearch = myWaiters.waitPresenceOfElementReturn(By.xpath("//div[@class='search-page__box-title']"));
       /*if(driver.findElement(By.xpath("//div[@class='search-page__box-title']")).isDisplayed())
       {
            WebElement senseSearch = myWaiters.waitPresenceOfElementReturn(By.xpath(
                    "//div[@class='search-page__box-title']"));
        String resultUpdate2 = senseSearch.getText().replace("За запитом ", "");
        String resultUpdate3=resultUpdate2.replace(" нічого не знайдено", "");
        assertTrue(resultUpdate3.equals("«" +input+ "»"));}
        //div[@class="search-page__box-title"] смысл*/

    }
}
