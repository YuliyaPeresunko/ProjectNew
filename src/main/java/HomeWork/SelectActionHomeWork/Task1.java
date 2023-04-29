package HomeWork.SelectActionHomeWork;

import lesson3.SelectorsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
//Написать программу реализующую действие показанное на "видео1.mp4".
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(Url.url);

        WebElement car = driver.findElement(Locators2.car);
        Select carSelect = new Select(car);

        System.out.println("Автомобили доступные для выбора:");
        List<WebElement> carList = carSelect.getOptions();
        for (WebElement carName:carList){
            System.out.print(carName.getText() + ", ");
        }

        carSelect.selectByVisibleText("Renault");
        Thread.sleep(4000);

        Select countryListSelect = new Select(driver.findElement(Locators2.country));
        System.out.println("\nСтраны из первой таблицы:");

        List<WebElement> countList = countryListSelect.getOptions();
        for (WebElement countries :countList){
            System.out.print(countries.getText() + ", ");
        }

        countryListSelect.selectByIndex(2);
        countryListSelect.selectByIndex(5);
        Thread.sleep(1000);
        countryListSelect.deselectByIndex(5);
        countryListSelect.selectByIndex(6);
        countryListSelect.selectByIndex(7);
        countryListSelect.selectByIndex(9);
        Thread.sleep(1000);
        countryListSelect.deselectByIndex(9);
        countryListSelect.selectByIndex(8);

        driver.findElement(Locators2.buttonChoice).click();

        System.out.println("\nСтраны из второй таблицы:");
        Select countryList2 = new Select(driver.findElement(Locators2.country2));
        List<WebElement> finalList = countryList2.getOptions();
        for (WebElement c :finalList){
            System.out.print(c.getText() + ", ");
        }
    }

    private static class Locators2 {
        private static final By country = By.xpath("//select[@name='FromLB']");
        private static final By country2 = By.xpath("//select[@name='ToLB']");
        private static final By car = By.id("Carlist");
        private static final By buttonChoice = By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']");
    }

    private static class Url {
        private static final String url = "http://only-testing-blog.blogspot.com/2014/01/textbox.html?";
    }
}