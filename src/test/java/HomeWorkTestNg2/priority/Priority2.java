package HomeWorkTestNg2.priority;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Priority2 {

/*
Task1:
        Создать отдельный пакет priority. В нем класс Priority1. В этом классе создать тесты a, b, c, d, e , f, g
        Сделать так, чтобы при запуске данного класса эти тесты проходили в порядке обратном алфавитному.
        Придумать по крайней мере два способа, как это можно сделать.

        Второй вариант
*/

        @Test(dependsOnMethods = {"b"})
        public void a(){assertTrue(true);}

        @Test(dependsOnMethods = {"c"})
        public void b(){assertTrue(true);}

        @Test(dependsOnMethods = {"d"})
        public void c(){assertTrue(true);}

        @Test(dependsOnMethods = {"e"})
        public void d(){assertTrue(true);}

        @Test(dependsOnMethods = {"f"})
        public void e(){assertTrue(true);}

        @Test(dependsOnMethods = {"g"})
        public void f(){assertTrue(true);}

        @Test
        public void g(){assertTrue(true);}
    }


