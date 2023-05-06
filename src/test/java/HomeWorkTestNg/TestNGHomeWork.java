package HomeWorkTestNg;

import lesson5.MyWaiters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestNGHomeWork {
    WebDriver driver;

    //Task1:
    //Открыть сайт https://dan-it.com.ua/uk/ . На этой странице открыть в новых вкладках ссылки “Java”,
    // “Quality Assurance (QA)”, “FrontEnd”.
    //Прописать тест, проверяющий количество открытых окон. Он должен проходить,
    // если количество открытых окон равно 4.

    @Test
    public void windowCountTask1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");

        Actions actions = new Actions(driver);
        String firstDes = driver.getWindowHandle();
        Set<String> setFirst = driver.getWindowHandles();

        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//a[text()='Для дорослих']"));
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Для дорослих']"))).perform();

        WebElement FrontEnd = driver.findElement(By.xpath(" //a[@class='header__nav-item-link'][text()='FrontEnd']"));
        actions.keyDown(Keys.CONTROL).click(FrontEnd).keyUp(Keys.CONTROL).build().perform();

        Set<String> setSecond = driver.getWindowHandles();
        setSecond.removeAll(setFirst);
        String secondDesc = setSecond.iterator().next();

        WebElement qualityAssurance = driver.findElement(By.xpath(" //a[@class='header__nav-item-link'][text()='Quality Assurance (QA)']"));
        Set<String> setSecondAgain = driver.getWindowHandles();
        actions.keyDown(Keys.CONTROL).click(qualityAssurance).keyUp(Keys.CONTROL).build().perform();

        Set<String> setThird = driver.getWindowHandles();
        setThird.removeAll(setSecondAgain);

        String thirdDesc = setThird.iterator().next();

        WebElement java = driver.findElement(By.xpath("//a[@class='header__nav-item-link'][text()='Java']"));
        Set<String> setThirdAgain = driver.getWindowHandles();
        actions.keyDown(Keys.CONTROL).click(qualityAssurance).keyUp(Keys.CONTROL).build().perform();

        Set<String> setFourth = driver.getWindowHandles();
        setFourth.removeAll(setThirdAgain);

        String fourthDesc = setFourth.iterator().next();

        Set<String> setForthAgain = driver.getWindowHandles();
        assertTrue(setForthAgain.size() == 4, "Кол-во открытых окон не равно 4");

    }

    //Task2:
//Открыть сайт https://uhomki.com.ua/ru/.  Проверить, что после нажатия кнопки “ Оплата и доставка”
// открывается страница с нужной ссылкой.
//А именно https://uhomki.com.ua/ru/oplata-i-dostavka/.
    @Test
    public void PaymentAndDeliveryTask2() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");

        Actions actions = new Actions(driver);
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//div[@class='header__section']//a[text()='Оплата и доставка']"));
        WebElement paymentAndDelivery = driver.findElement(By.xpath("//div[@class='header__section']//a[text()='Оплата и доставка']"));
        paymentAndDelivery.click();
        String url = new String("https://uhomki.com.ua/ru/oplata-i-dostavka/");
        assertEquals(url, driver.getCurrentUrl());

    }
//    Task3:
//    Открыть сайт https://uhomki.com.ua/ru/. Ввести в строку поиска слово “смесь” и совершить поиск.
//    Проверить что слово “смесь” присутствует в сообщении о результатах поиска.
//    После ввести в строку поиска слово “спесь” и совершить поиск. Проверить что слово “спесь”
//    присутствует в сообщении о результатах поиска. После ввести в строку поиска слово “ересь” и совершить поиск.
//    Проверить что слово “ересь” присутствует в сообщении о результатах поиска.

    @Test
    public void SearchWordTask3() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");

        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//input[@placeholder='поиск товаров']"));
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='поиск товаров']"));
        String input="смесь";
        search.sendKeys(input);
        search.submit();
        String result=driver.findElement(By.xpath("//h1[@id='j-catalog-header']")).getText();
        String resultUpdate=result.replace("Результаты поиска ", "");

        assertTrue(resultUpdate.equals("«"+input+"»"));

        WebElement search2 = driver.findElement(By.xpath("//input[@placeholder='поиск товаров']"));
        search2.clear();
        String input2="спесь";
        search2.sendKeys(input2);
        search2.submit();
        String result2=driver.findElement(By.xpath(" //h1[@id='j-catalog-header']")).getText();
        String resultUpdate2=result2.replace("Результаты поиска ", "");

        assertTrue(resultUpdate2.equals("«"+input2+"»"));

        WebElement search3 = driver.findElement(By.xpath("//input[@placeholder='поиск товаров']"));
        search3.clear();
        String input3="ересь";
        search3.sendKeys(input3);
        search3.submit();
        String result3=driver.findElement(By.xpath(" //h1[@id='j-catalog-header']")).getText();
        String resultUpdate3=result3.replace("Результаты поиска ", "");

        assertTrue(resultUpdate3.equals("«"+input3+"»"));
    }

   /* Task4:
    Открыть сайт https://www.guinnessworldrecords.com/Account/Login. Написать тест, проверяющий
    что изначально чек-бокс “RememberMe” не выбран. Потом кликнуть на него и реализовать проверку того,
    что он выбран. После снова нажать на чек-бокс и проверить что он снова не выбран.
*/ @Test
   public void RememberMe4() {
       System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.guinnessworldrecords.com/Account/Login");

       new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//input[@name='RememberMe'][1]"));

       WebElement unclicked = new MyWaiters(driver).waitPresenceOfElementReturn
               (By.xpath("//input[@name='RememberMe'][1]"));
       assertFalse(unclicked.isSelected(), "Чек-бокс выбран");
       unclicked.click();

       assertTrue(
               new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//input[@name='RememberMe'][1]"))
                       .isSelected(), "Чек-бокс не выбран");

       WebElement clicked =driver.findElement(By.xpath("//input[@name='RememberMe'][1]"));
       clicked.click();

       assertFalse(
               new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//input[@name='RememberMe'][1]"))
                       .isSelected(),"Чек-бокс выбран");
}

   /* Task5:
    Открыть сайт http://only-testing-blog.blogspot.com/2014/01/textbox.html?. Написать тест, проверяющий
    содержит ли модальное окно, которое появляется после нажатия на кнопку “Show Me Alert”необходимый текст.

    После написания всех тестов нужно создать отдельно файл testngHomework.xml после запуска которого
    все ваши вышенаписанные тесты будут запускаться и проходить.
*/
   @Test
   public void AlertTextTask5() {
       System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");

       new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//input[@onclick='myFunction1()']"));
       driver.findElement(By.xpath("//input[@onclick='myFunction1()']")).click();
       Alert alert = driver.switchTo().alert();
       assertEquals(alert.getText(), "Hi.. This is alert message!", "Текст в модельном окне не соответствует ожидаемому ");
       alert.accept();

   }
}