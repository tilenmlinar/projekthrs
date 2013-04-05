package projektTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projekthrs.BinaryOperator;
import projekthrs.Constant;
import projekthrs.ShuntingYardAlgorithm;
import projekthrs.UnaryOperator;
/**
 *
 * @author cirilmlinar
 */
public class IzraziTest {
    
    
    @Test
    public void testManuallyTree_binary() {
        
        assertEquals(5.0, new BinaryOperator("/",new BinaryOperator("+",new Constant(5),new Constant(5)),new Constant(2)).evaluate(),0);
         
    }
    
     @Test
    public void testManuallyTree_Unary() { 
   
        assertEquals(7.0, new UnaryOperator("++", new Constant(6)).evaluate(),0);
             
    }
    @Test
    public void testManuallyTree_Unary2() { 
   
        assertEquals(3.0, new UnaryOperator("sqrt", new Constant(9)).evaluate(),0);
             
    } 
    @Test
    public void testBuildTree1() { 
   
        ShuntingYardAlgorithm shunt = new ShuntingYardAlgorithm();
    
        assertEquals("3 5 + 6 -", shunt.transform("3 + 5 - 6"));
             
    }
    @Test
    public void testBuildTree2() { 
   
        ShuntingYardAlgorithm shunt = new ShuntingYardAlgorithm();
    
        assertEquals("3 5 6 * +", shunt.transform("3 + 5 * 6"));
             
    }  
    @Test
    public void testBuildTree3() { 
   
        ShuntingYardAlgorithm shunt = new ShuntingYardAlgorithm();
    
        assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", shunt.transform("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
             
    } 
    
    @Test
    public void testEvaluateGeneratedTree1() { 
   
        ShuntingYardAlgorithm shunt = new ShuntingYardAlgorithm();

        assertEquals(27.0, shunt.calculateResult(shunt.transform("3 + 12 * 2")),0);
             
    } 
    
    
    
 
}
