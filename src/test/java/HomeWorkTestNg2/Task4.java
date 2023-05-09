package HomeWorkTestNg2;
/*4.Написать тест, который будет проверять поисковую строку сайта https://www.foxtrot.com.ua/
        Использовать в качестве проверочных слов три следующих слова:“машина”, “input”, “смысл”.
        •	Если после поиска вводимого слова пользователь видит страницу первого типа:
        То в вашем ассерте необходимо убедиться, что выделенный элемент содержит искомое слово.
Если после поиска вводимого слова пользователь видит страницу второго типа:
То в вашем ассерте также необходимо убедиться, что выделенный элемент содержит искомое слово.
Решить данную задачу использую @DataProvider.

*/

import lesson5.MyWaiters;
import lesson8.dataProvider.DataProviderExample;
import lesson9.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task4 {
    WebDriver driver;
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

    @Test(dataProvider = "search")
    public void SearchTask4(String searchParams)  {
        MyWaiters myWaiters = new MyWaiters(driver);
        Assertions asserts = new Assertions(driver);
        Actions actions = new Actions(driver);
        new MyWaiters(driver).waitVisabilityOfWebElentReturn(By.xpath("//input[@type='search']"));
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        String input = searchParams;
        searchField.sendKeys(input);
        driver.findElement(By.xpath("//input[@value='Знайти']")).click();

        myWaiters.waitTitleContainsText("Знайдено по запиту ");
        myWaiters.waitVisabilityOfWebElent(By.tagName("h1"));
        if ((driver.findElement(By.tagName("h1"))).getText().contains("Знайдено по запиту ")) {
            String resultOfReach = (driver.findElement(By.tagName("h1")))
                    .getText().replace("Знайдено по запиту ", "");
            assertTrue(resultOfReach.equals("«" +input+ "»"));

           //  asserts.equalsOfStrings(resultOfReach, "«"+input+"»" );
        }
         else if((driver.findElement(By.tagName("h1"))).getText().contains("Результати пошуку")){
            String resultOfReach2 = (driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")))
                    .getText();

            assertTrue(resultOfReach2.equals("«" +input+ "»"));
            //asserts.equalsOfStrings(resultOfReach2, "«"+input+"»" );
        }
    }

    @DataProvider(name = "search")
    public Object[] searchObj() {
        return new Object[]{
                "машина", "input", "смысл"
        };
    }
}