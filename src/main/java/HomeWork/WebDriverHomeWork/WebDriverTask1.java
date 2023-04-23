package HomeWork.WebDriverHomeWork;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

/*1.Написать программу, которая будет открывать пять различных страниц в новых окнах:
        https://uhomki.com.ua/
        https://zoo.kiev.ua/
        https://www.w3schools.com/
        https://taxi838.ua/ru/dnepr/
        https://klopotenko.com/

        Прописать цикл, который будет переключаться поочередно через все страницы,
        для каждой страницы выводить в консоль название и ссылку на эту страницу.
        И будет закрывать ту страницу в названии которой есть слово зоопарк.
*/
public class WebDriverTask1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver_win32\\chromedriver.exe");
        org.openqa.selenium.WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] array = new String[5];
        array[0] = "https://uhomki.com.ua/";
        array[1] = "https://zoo.kiev.ua/";
        array[2] = "https://www.w3schools.com/";
        array[3] = "https://taxi838.ua/ru/dnepr/";
        array[4] = "https://klopotenko.com/";

        for (String i : array) {

            driver.navigate().to(i);

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            Set<String> setFirst = driver.getWindowHandles();
            ((JavascriptExecutor)driver).executeScript("window.open()");

            if (driver.getTitle().contains("зоопарк")) {
                driver.close(); }

            Set<String> setSecond = driver.getWindowHandles();
            setSecond.removeAll(setFirst);
            String finalDesc = setSecond.iterator().next();

            driver.switchTo().window(finalDesc);

    }

}}
