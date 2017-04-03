/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;



import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.Description;
 
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 

@RunWith(Parameterized.class)
public class TestCalc {
    // Обратите внимание на данные в скобках - первый два - числа, которые складываем/вычитаем
    // Вторые - это их сумма и разность
 
    @Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                    {5, 3, 9, 2},
                    {15, 10, 25, 5},
                    {5, 10, 15, -5}
                });
    }
    int x1, x2, sum, sub;
 
    public TestCalc(int x1, int x2, int sum, int sub) {
        this.x1 = x1;
        this.x2 = x2;
        this.sum = sum;
        this.sub = sub;
    }
 
    @Test
    public void getSumTest() {
        Calc c = new Calc();
        assertEquals(sum, c.getSum(x1, x2));
    }
 
    @Test
    public void getSubtractionTest() {
        Calc c = new Calc();
        assertEquals(sub, c.getSubtraction(x1, x2));
    }
 
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalcListener());
        core.run(TestCalc.class);
    }
}
 
class CalcListener extends RunListener {
 
    @Override
    public void testStarted(Description desc) {
        System.out.println("Started:" + desc.getDisplayName());
    }
 
    @Override
    public void testFinished(Description desc) {
        System.out.println("Finished:" + desc.getDisplayName());
    }
 
    @Override
    public void testFailure(Failure fail) {
        System.out.println("Failed:" + fail.getDescription().getDisplayName() + " [" + fail.getMessage() + "]");
    }
}