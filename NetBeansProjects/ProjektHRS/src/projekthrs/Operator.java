/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;


/**
 *
 * @author cirilmlinar
 */
public abstract class Operator extends Token {

    public String symbol;
    private Boolean isBinary;

   /* private Operator(String symbol1, Boolean isBinary1) {
        
        symbol = symbol1;
        isBinary = isBinary1;
        
    }*/
    
    public abstract double evaluate();

  //  public static Operator get (String symbol)
    //{
      //  return operatorMap.get(symbol1);
        
    //}
    
}
