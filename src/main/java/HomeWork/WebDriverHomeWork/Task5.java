package HomeWork.WebDriverHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*5)
Написать программу, которая повторит действия на видео "Задание 5.mp4".*/
public class Task5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/ru/");
        Thread.sleep(4000);
        WebElement search = driver.findElement(By.cssSelector(".search__input"));
        search.click();
        search.sendKeys("Хорек");
        Thread.sleep(4000);
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[href='/ru/vitaminy-beafar-pasta-malt-s-dvoynym-deystviem-dlya-khorkov-100g/']")).click();
        driver.getPageSource();
        driver.findElement(By.xpath("//span[text()='К сравнению']")).click();
        WebElement search2 = driver.findElement(By.xpath("//input[@name='q']"));
        search2.click();
        search2.sendKeys("Медведь");
        Thread.sleep(4000);
        search2.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(text(),'Белый медведь')]")).click();
        driver.getPageSource();
        driver.findElement(By.cssSelector(".comparison-button__text")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(".comparison-view__button-text")).click();

}}
