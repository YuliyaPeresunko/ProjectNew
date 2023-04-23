package HomeWork.WebDriverHomeWork.Task3;

import HomeWork.WebDriverHomeWork.Task3.NoClassEx;
import HomeWork.WebDriverHomeWork.Task3.NoIdEx;
import HomeWork.WebDriverHomeWork.Task3.NoNameEx;
import HomeWork.WebDriverHomeWork.Task3.NoTextEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTask3 {
    /*3) Написать метод который выводит сообщение об айди элемента,
значении тэга элемента , значении класса элемента,
значении атрибута name элемента, текста данного элемента,
а также о координатах центра контейнера данного элемента.
Создать свой тип исключений, который будет вызываться если у элемента
нет определенного атрибута и на экран будет выводиться сообщение об отсутствии данного атрибута.*/
    public static void MethodWebElement2(WebElement button) throws NoIdEx, NoNameEx, NoTextEx, NoClassEx {

        System.out.println("координата y центра элемента = " + button.getLocation().y + button.getSize().height / 2);
        System.out.println("координата x центра элемента = " + button.getLocation().x + button.getSize().width / 2);

        System.out.println("Название тега: " + button.getTagName());

        if(button.getAttribute("id")==null){
            throw new NoIdEx("Аттрибута айди нет");
        }else {
            System.out.println("Аттрибут айди равен "+button.getAttribute("id"));
        }
        if(button.getAttribute("name")==null){
            throw new NoNameEx("Аттрибута нэйм нет");
        }else {
            System.out.println("Аттрибут name равен "+button.getAttribute("name"));
        }
        if(button.getAttribute("text")==null){
            throw new NoTextEx("Аттрибута text нет");
        }else {
            System.out.println("Аттрибут text равен " +button.getAttribute("text"));
        }
        if(button.getClass()==null){
            throw new NoClassEx("Класса нет");
        }else {
            System.out.println("Класс равен " + button.getAttribute("class"));
        }

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        try {
            MethodWebElement2(driver.findElement(By.cssSelector(".search__input")));
        }catch(NoIdEx | NoNameEx | NoClassEx | NoTextEx ex){
            System.out.println(ex.getMessage());
        }
        driver.quit();
    }
}







