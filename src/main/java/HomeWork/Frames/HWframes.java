package HomeWork.Frames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class HWframes {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/search");
        WebElement search = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        search.sendKeys("https://www.guinnessworldrecords.com/account/register");
        search.submit();

        String firstDes = driver.getWindowHandle();
        Set<String> setFirst = driver.getWindowHandles();
        Actions actions = new Actions(driver);

        WebElement second = driver.findElement(By.xpath("//h3[text()='Create account | Guinness World Records']"));
        actions.keyDown(Keys.CONTROL).click(second).keyUp(Keys.CONTROL).build().perform();

        Set<String> setSecond = driver.getWindowHandles();
        setSecond.removeAll(setFirst);

        String secondDesc = setSecond.iterator().next();

        driver.findElement(By.xpath("//div[@class='M2vV3 vOY7J']")).click();

        WebElement search2 = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        search2.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        search2.submit();

        WebElement third = driver.findElement(By.xpath("//h3[text()='AlertsDemo - H Y R Tutorials']"));
        Set<String> setSecondAgain = driver.getWindowHandles();
        actions.keyDown(Keys.CONTROL).click(third).keyUp(Keys.CONTROL).build().perform();

        Set<String> setThird = driver.getWindowHandles();
        setThird.removeAll(setSecondAgain);

        String thirdDesc = setThird.iterator().next();

        driver.navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        Thread.sleep(4000);

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(frame1);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='fname']"));
        firstName.clear();
        firstName.sendKeys("Yuliya");
        Thread.sleep(4000);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lname']"));

       lastName.clear();
       lastName.sendKeys("Peresunko");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

       Thread.sleep(8000);
        System.out.println(driver.findElements(By.xpath("//p")).get(1).getText());

        Thread.sleep(4000);
        driver.switchTo().window(secondDesc);

        WebElement lastName2= driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName2.click();
        lastName2.sendKeys("Peresunko");
        WebElement firstName2= driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstName2.click();
        firstName2.sendKeys("Yuliya");

        WebElement day= driver.findElement(By.xpath("//input[@name='DateOfBirthDay']"));
        day.click();
       day.sendKeys("21");

        WebElement month= driver.findElement(By.xpath("//input[@name='DateOfBirthMonth']"));
        month.click();
        month.sendKeys("11");

        WebElement year= driver.findElement(By.xpath("//input[@name='DateOfBirthYear']"));
        year.click();
        year.sendKeys("1991");

        WebElement countryElement = driver.findElement(By.xpath("//select[@name='Country']"));
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText("Ukraine");

        Thread.sleep(4000);

        WebElement state= driver.findElement(By.xpath("//input[@name='State']"));
        state.click();
        state.sendKeys("Dnipro");


        WebElement email= driver.findElement(By.xpath("//input[@name='EmailAddress']"));
        email.click();
        email.sendKeys("email@mail.com");


        WebElement emailConfirm= driver.findElement(By.xpath("//input[@name='ConfirmEmailAddress']"));
        emailConfirm.click();
        emailConfirm.sendKeys("email@mail.com");

        WebElement password= driver.findElement(By.xpath("//input[@name='Password']"));
        password.click();
        password.sendKeys("123456789");

        WebElement passwordConfirm= driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        passwordConfirm.click();
        passwordConfirm.sendKeys("123456");
        passwordConfirm.submit();

        Thread.sleep(4000);
        System.out.println(
                driver.findElement(By.xpath("//span[@for='ConfirmPassword']")).getText());
        Thread.sleep(8000);

        driver.switchTo().window(thirdDesc);

        Thread.sleep(8000);

        driver.findElement(By.xpath("//button[@id='alertBox']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='confirmBox']")).click();
        Thread.sleep(1000);
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='promptBox']")).click();
        Thread.sleep(2000);
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Final step of this task");
        alert3.accept();
        System.out.println(driver.findElement(By.xpath("//div[@id='output']")).getText());


    }}