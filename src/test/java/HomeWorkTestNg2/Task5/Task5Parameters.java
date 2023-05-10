package HomeWorkTestNg2.Task5;

import lesson5.MyWaiters;
import lesson9.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    //MyWaiters myWaiters;

    @BeforeClass
    public void driverInitialisation() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath(
                "//div[@id='user-location-popup']//i[@class='icon icon-close']")).click();
    }

    @Test
    @Parameters({"input"})
    public void SearchTask4(String searchParams) {

        MyWaiters myWaiters = new MyWaiters(driver);
        Assertions asserts = new Assertions(driver);
        Actions actions = new Actions(driver);
        new MyWaiters(driver).waitVisabilityOfWebElentReturn(By.xpath("//input[@type='search']"));
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        String searchText = searchParams;
        searchField.sendKeys( searchText);
        driver.findElement(By.xpath("//input[@value='Знайти']")).click();

        myWaiters.waitTitleContainsText("Знайдено по запиту ");
        myWaiters.waitVisabilityOfWebElent(By.tagName("h1"));
        if ((driver.findElement(By.tagName("h1"))).getText().contains("Знайдено по запиту ")) {
            String resultOfReach = (driver.findElement(By.tagName("h1")))
                    .getText().replace("Знайдено по запиту ", "");
            assertTrue(resultOfReach.equals("«" + searchText + "»"));

            //  asserts.equalsOfStrings(resultOfReach, "«"+input+"»" );
        } else if ((driver.findElement(By.tagName("h1"))).getText().contains("Результати пошуку")) {
            String resultOfReach2 = (driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")))
                    .getText();

            assertTrue(resultOfReach2.equals("«" +  searchText + "»"));
            //asserts.equalsOfStrings(resultOfReach2, "«"+input+"»" );
        }
    }
}