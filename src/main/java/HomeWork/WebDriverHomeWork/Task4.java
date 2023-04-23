package HomeWork.WebDriverHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*4)
https://uhomki.com.ua/
Написать метод, который будет выводить в консоль тексты всех
элементов, которые можно найти по заданнму параметру.
Например при помощи него можно будет получить значения всех элементов
из списков заданных на "Рисунок 4.png" и "Рисунок 5.png".*/
public class Task4 {

    public static void Method ( WebElement element){

        if(element.getText()!=null)
        {System.out.println("Текст элемента: " +element.getText());}
        if(element.getTagName()!=null)
        {System.out.println("Тег элемента: " + element.getTagName());}
        if(element.getAttribute("class")!=null)
        {System.out.println("Класс элемента: "+ element.getAttribute("class"));}
        if(element.getAttribute("id")!=null)
        {System.out.println("Айди элемента"+ element.getAttribute("id"));}

    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");

        WebElement dogs = driver.findElement(By.xpath("//a[@href='/ru/sobaki/'][@class='products-menu__title-link']"));
        Method(dogs);
        WebElement cats = driver.findElement(By.xpath("//a[@href='/ru/koshki/1074/'][@class='products-menu__title-link']"));
        Method(cats);
        WebElement dogscats = driver.findElement(By.xpath("//a[@href='/ru/sobaki-koshki-obshchee/'][@class='products-menu__title-link']"));
        Method(dogscats);
        WebElement khorki = driver.findElement(By.xpath("//a[@href='/ru/khorki/1093/'][@class='products-menu__title-link']"));
        Method(khorki);
        WebElement gryzyny = driver.findElement(By.cssSelector("a[href*='1098'].products-menu__title-link"));
        Method(gryzyny);
        WebElement ptitsy = driver.findElement(By.cssSelector("a[href*='1110'].products-menu__title-link"));
        Method(ptitsy);
        WebElement terrariumistika = driver.findElement(By.cssSelector("a[href*='1118'].products-menu__title-link"));
        Method(terrariumistika);
        WebElement aquariumistika = driver.findElement(By.cssSelector("a[href*='1124'].products-menu__title-link"));
        Method(aquariumistika);
        WebElement selsTovary = driver.findElement(By.cssSelector("a[href*='1131'].products-menu__title-link"));
        Method(selsTovary);
        WebElement veterinariya = driver.findElement(By.cssSelector("a[href*='1140'].products-menu__title-link"));
        Method(veterinariya);
        WebElement container = driver.findElement(By.cssSelector(".products-menu.j-products-menu"));
        Method(container);

        WebElement katalog = driver.findElement(By.xpath("//div[@class='footer__heading'][text()='Каталог']/following-sibling::ul"));
        Method(katalog);
        WebElement klientam = driver.findElement(By.xpath("//div[@class='footer__heading'][text()='Клиентам']/following-sibling::ul"));
        Method(klientam);
    }
}
