package HomeWork.WebDriverHomeWork;

import org.openqa.selenium.WebElement;

/*2)
Написать метод в параметры которого принимаются два ВебЭлемента.
метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
какой из элементов располагается левее на странице,
а также какой из элементов занимает большую площадь.
Параметры метода могут также включать в себя другие аргументы, если это необходимо.*/
public class WebElementTask2 {

    public static void MethodWebElement(WebElement button1, WebElement button2) {
        System.out.println("Координата x верхнего левого угла элемента button1 " + button1.getLocation().x);
        System.out.println("Координата y верхнего левого угла элемента button1" + button1.getLocation().y);

        System.out.println("Координата x верхнего левого угла элемента button2" + button2.getLocation().x);
        System.out.println("Координата y верхнего левого угла элемента button2" + button2.getLocation().y);

        if (button1.getLocation().y > button2.getLocation().y) {
            System.out.println("Второй элемент выше первого");
        } else System.out.println("Первый элемент выше второго");

        if (button1.getLocation().x > button2.getLocation().x) {
            System.out.println("Второй элемент левее на странице");
        } else System.out.println("Первый элеент левее на странице");

        double S1 = button1.getSize().height * button1.getSize().width;
        double S2 = button2.getSize().height * button2.getSize().width;
        if (S1 > S2) System.out.println("Площадь первого элемента больше");
        else System.out.println("Площадь второго элемента больше");

    }
    }
