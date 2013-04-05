/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;

/**
 *
 * @author cirilmlinar
 */
public class Constant  extends Token
{
    private double value;
    
    public Constant (double value1)
    {
        value = value1; 
    }
    
    
    public double evaluate()
    {
        return value; 
    }

    
}
