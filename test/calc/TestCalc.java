/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.Description;
 
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
 

public class TestCalc {
    // @Test - это аннотация, которая обозначает, что метод должен быть вызван для тестирования чего-нибудь
 
    @Test
    public void getSumTest() {
        Calc c = new Calc();
        assertEquals(55, c.getSum(20, 30));
    }
 
    @Test
    public void getSubtractionTest() {
        Calc c = new Calc();
        assertEquals(-12, c.getSubtraction(20, 30));
    }
    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }
 
    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalcListener());
        core.run(TestCalc.class);
    }
}
 
class CalcListener extends RunListener {
 
   
 
    @Override
    public void testFailure(Failure fail) {
        System.out.println("Failed:" + fail.getDescription().getDisplayName() + " [" + fail.getMessage() + "]");
    }
}