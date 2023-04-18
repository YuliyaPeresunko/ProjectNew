package LocatorsHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkLocators {

    private static class Locators {
        private static final By buttonVhod1 = By.className("userbar__button-text");
        private static final By buttonVhod2 = By.partialLinkText("Вхо");
        private static final By buttonVhod3 = By.xpath("//span[text()='Вход']");
        private static final By buttonVhod4 = By.xpath("//div[contains(@class, 'header__column')]//span[contains(@class,'userbar')]");
        private static final By dogCat = By.xpath("//div[text()='Каталог']/following-sibling::ul/li[3]/a");
        private static final By itText = By.xpath("//h2[contains(text(),'IT специальностям')]");
        private static final By aquariums
                = By.xpath("//a[contains(text(),'Аквариумистика')]/../following-sibling::div//span[text()='Аквариумы']/..");
        private static final By numTel = By.xpath("//div[@class='dropbtn-phones']/span");
        private static final By education = By.xpath("//h2[@class='re-section-title re-home-children__title']");
        private static final By id1element = By.xpath("//input[@id='search2']");
        private static final By id2element = By.xpath("//button[@id='learntocode_searchbtn']");
        private static final By id3element = By.xpath("//a[@id='nav_translate_btn']");
        private static final By id4element = By.xpath("//a[@id='nav_translate_btn']");
        private static final By id5element = By.xpath("//a[@id='navbtn_tutorials']");
        private static final By id6element = By.xpath("//a[@id='navbtn_references']");
        private static final By id7element = By.xpath("//a[@id='navbtn_exercises']");
        private static final By id8element = By.xpath("//a[@id='signupbtn_topnav']");
        private static final By id9element = By.xpath("//a[@id='w3loginbtn']");
        private static final By id10element = By.xpath("//a[@id='cert_navbtn']");
        private static final By programming = By.xpath("//a[@class='re-home-adult__link']/../following-sibling::*[4]/a");
        private static final By downloadButton = By.xpath("//a[contains(@class,'wt-col-inline menu-second__download-button')]");
        private static final By download1 = By.xpath("//p[text()='Free 30-day trial available']/../../span/a");
        private static final By download2 = By.xpath("//p[text()='Free, built on open source']/../../span/a");

    }

    private static class Url {
        private static final String itStep = "https://itstep.dp.ua/ru\n";
        private static final String homiak = "https://uhomki.com.ua/ru/koshki/1074/";
        private static final String w3schools = "https://www.w3schools.com/";
        private static final String idea = "https://www.jetbrains.com/idea/";
        private static final String ideaDownload = "https://www.jetbrains.com/idea/download/#section=windows";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver_win32\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            //1.кнопка вход
            driver.get(Url.homiak);
            driver.findElement(Locators.buttonVhod1).click();
            driver.findElement(Locators.buttonVhod2).click();
            driver.findElement(Locators.buttonVhod3).click();
            driver.findElement
                    (Locators.buttonVhod4).click();

            // 2.Найти элемент "Каталог", а при помощи него найти путь к элементу
            //"Собаки/кошки общее" используя xpath.
            driver.get(Url.homiak);
            driver.findElement(Locators.dogCat).click();

            //3.Найти данный элемент по тексту "IT специальностям"
            driver.get(Url.itStep);
            System.out.println(
                    driver.findElement(Locators.itText).getText());
            driver.quit();

            //4.Найти путь к элементу Аквариумы

            driver.get(Url.homiak);
            driver.findElement(Locators.aquariums).click();

            //5.Найти путь к элементу номер телефона не используя текст
            driver.get(Url.itStep);
            System.out.println(
                    driver.findElement(Locators.numTel).getText());

            //6.Найти локатор элемента 'Образование для детей' не используя текст
            driver.get(Url.itStep);
            System.out.println(
                    driver.findElement(Locators.education).getText());
            driver.quit();

            //7.найти 10 элементов на странице, для нахождения которых можно использовать
            //только айди и с которыми можно взаимодействовать. (Кликнуть, ввести текст и т.д.)
            driver.get(Url.w3schools);

            driver.findElement
                    (Locators.id1element).click();

            driver.findElement
                    (Locators.id2element).click();

            driver.findElement
                    (Locators.id3element).click();

            driver.findElement
                    (Locators.id4element).click();

            driver.findElement
                    (Locators.id5element).click();

            driver.findElement
                    (Locators.id6element).click();

            driver.findElement
                    (Locators.id7element).click();

            driver.findElement
                    (Locators.id8element).click();

            driver.findElement
                    (Locators.id9element).click();

            driver.findElement
                    (Locators.id10element).click();

           /* 8.Отыскать один элемент на основе другого (Университет-программирование)
            Для нахождения первого элемента можете использовать любые методы и локаторы,
            для прописывания дальнейшего поиска второго элемента не использовать текст.
            */
            driver.get(Url.itStep);
            driver.findElement
                    (Locators.programming).click();

            //9.Найти данный элемент (Download) не используя текст. Используя только имя класса.
            driver.get(Url.idea);
            driver.findElement
                    (Locators.downloadButton).click();

            //10.найти локаторы к двум данным кнопкам.(Download и Download)
            //Пользоваться любыми локаторами и методами.
            driver.get(Url.ideaDownload);
            driver.findElement
                    (Locators.download1).click();
            driver.findElement
                    (Locators.download2).click();
        }
    }


}