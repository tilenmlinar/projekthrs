/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;

/**
 *
 * @author cirilmlinar
 */
public class UnaryOperator extends Operator{

    Token child;
    
    
    public UnaryOperator(String operator, Token child)
    {
        this.child = child;
        this.symbol = operator;
    }
    
    
    @Override
    public double evaluate() {

        if(symbol.equals("++"))
        {
             return child.evaluate() +1; 
             
        }
        if(symbol.equals("--"))
        {
             return child.evaluate() -1; 
             
        }
        if(symbol.equals("neg"))
        {
             return child.evaluate() * (-1); 
             
        }
        if(symbol.equals("sqrt"))
        {
             return  Math.sqrt(child.evaluate());    
        }
           
        return 0;
    }
    
    
}
