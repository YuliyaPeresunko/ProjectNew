package HomeWorkTestNg2.parallelismus;
/*
Task3:
        Создать отдельный пакет parallelismus. В нем класс ParallelClass1. В котором  создать тесты
        parallel1, parallel2, parallel3, parallel4, parallel5. Создать класс ParallelClass2.
        В котором создать тесты parallel6, parallel7, parallel8, parallel9, parallel10.
        Создать отдельный xml файл testngParallelHome.xml в котором параллельно будут прогоняться выше с
        озданные два класса ParallelClass1 и ParallelClass2.
*/

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ParallelClass1 {

    @Test
    public void parallel1() throws InterruptedException {
        Thread.sleep (2000);
        assertTrue(true);}

    @Test
    public void parallel2()throws InterruptedException {
        Thread.sleep (2000);
        assertTrue(true);}

    @Test
    public void parallel3()throws InterruptedException {
        Thread.sleep (2000);
        assertTrue(true);}

    @Test
    public void parallel4()throws InterruptedException {
        Thread.sleep (2000);
        assertTrue(true);}

    @Test
    public void parallel5()throws InterruptedException {
        Thread.sleep (2000);
        assertTrue(true);}
}
