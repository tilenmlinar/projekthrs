/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;

/**
 *
 * @author cirilmlinar
 */
public class BinaryOperator extends Operator{

    public Token left;
    public Token right;
        
    public BinaryOperator(String operator, Token left, Token right)
    {
        
        this.left = left;
        this.right = right;
        this.symbol = operator;
 
    }

    
    @Override
    public double evaluate() {
        
         switch (symbol.charAt(0)) {
            
            case '+': return left.evaluate() + right.evaluate(); 
            case '*': return left.evaluate() * right.evaluate();
            case '-': return left.evaluate() - right.evaluate();
            case '/': return left.evaluate() / right.evaluate();
            case '^': return Math.pow(left.evaluate(), right.evaluate());
        
        }
        return 0;
    }
    
}
