package HomeWork.SelectActionHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Написать программу, которая будет автоматизировать сценарий показанный на видео "Сценарий для автоматизии.mp4".
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.ashortjourney.com/");
        Actions actions = new Actions(driver);

       Thread.sleep(8000);
       actions.moveToElement(driver.findElement
                      (By.xpath("//*[local-name()='circle'][2]"))).
              clickAndHold().moveToElement(driver.findElement(By.xpath("//li[@id='ui-sound']"))).release().build().perform();
        Thread.sleep(8000);

        actions.moveToElement(driver.findElement
                        (By.xpath("//*[local-name()='circle'][2]"))).pause(5).
                clickAndHold().pause(5).moveToElement(driver.findElement(By.xpath("//*[local-name()='circle'][1]"))).pause(5).release().pause(5).build().perform();
        Thread.sleep(8000);

        actions.moveToElement(driver.findElement
                        (By.xpath("//*[local-name()='circle'][2]"))).pause(10).
                clickAndHold().moveToElement(driver.findElement(By.xpath("//ul[@id='ui-right']/li"))).pause(5).release().pause(5).build().perform();
        Thread.sleep(8000);

        actions.moveToElement(driver.findElement
                        (By.xpath("//*[local-name()='circle'][2]"))).
                clickAndHold().moveToElement(driver.findElement(By.xpath("//*[local-name()='circle'][1]"))).release().build().perform();
        Thread.sleep(8000);

        actions.moveToElement(driver.findElement
                        (By.xpath("//*[local-name()='circle'][2]"))).
                clickAndHold().moveToElement(driver.findElement(By.xpath("//*[local-name()='circle'][1]"))).release().build().perform();
        Thread.sleep(8000);

        actions.moveToElement(driver.findElement
                        (By.xpath("//*[local-name()='circle'][2]"))).
                clickAndHold().moveToElement(driver.findElement(By.xpath("//ul[@id='ui-right']/li"))).release().build().perform();
        Thread.sleep(8000);

        actions.moveToElement(driver.findElement
                        (By.xpath("//*[local-name()='circle'][2]"))).
                clickAndHold().moveToElement(driver.findElement(By.xpath("//div[@id='fb-root']"))).pause(20).release().pause(20).build().perform();
        Thread.sleep(10000);

        WebElement postcard = driver.findElement(By.xpath("//textarea"));
        postcard.click();
        postcard.sendKeys("Задание выполнено!");

        Thread.sleep(2000);
        driver.quit();

    }
}
