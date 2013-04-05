/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;

import java.util.Stack;
import projekthrs.BinaryOperator;
import projekthrs.Constant;
import projekthrs.UnaryOperator;
/**
 *
 * @author cirilmlinar
 */
@MyAnnotation(name="SY_algorithm",  value = "Class impelemnts Shunting Yard algorithm. Transforming the expression into tree and evaluating the tree.")
public class ShuntingYardAlgorithm {
   
    
    private String result;
    String[] tokens;
    private Stack<String> previousTokens; 
    private boolean in;
    
    @MyAnnotation(name="Transform",  value = "transform the expression into the tree")
    public String transform (String expression)
    {
        
        
        tokens = expression.split(" ");
        previousTokens = new Stack<String>();
        
        result = "";
       processTokens();
       
      
            
        return result;
    }
    

    private void appendToken(String token)
    {
        if(result.length()>0 && token.length() >0)
            result+=" ";
       
        
        result+= token;
              
    }

    private boolean IsLiteral(String token) {
        
      return token.matches("-?\\d+(\\.\\d+)?");  
              
    }

    private void appendPreviousToken() {
        
        
        if(previousTokens.size()>0) 
            appendToken(previousTokens.pop());
        
        
        
    }

    public void handleOperator(String current) {
        
        while(previousExecutesBefore(current))
            appendPreviousToken();
        previousTokens.push(current);
    }

    private boolean previousExecutesBefore(String current) {
        
        if(previousTokens.size() ==0)
            return false;
        
        int previousPrecedence = CalculatePrecedence(previousTokens.peek());
        
        int currentPrecedence = CalculatePrecedence(current);
        
        if(current.equals("^"))
           return previousPrecedence > currentPrecedence;
        return previousPrecedence >= currentPrecedence;
    }

    private int CalculatePrecedence(String current) {
        
        switch(current.charAt(0))
        {
           
            case '^': return 12;
            case '/': return 10;
            case '*': return 10;
            case '+': return 8;
             case '-': return 8;   
             case '(': return -1;     
             case ')': return -1;       
            default: return 1;    
            
            
        
        }
    }

    private void appendAllPreviousTokens() {
        
        
        while(previousTokens.size()>0) {
            appendPreviousToken();
        }
    }

    public void processTokens() {
        
        
        for(String current: tokens)
        {
              if(IsLiteral(current))
              {    
                  appendToken(current);
              }
              else if(isOpenParentheses(current))
                 handleOpenParentheses();
              else if(isCloseParentheses(current))            
                 handleCloseParentheses();     
              else
              {
                 handleOperator(current);
              }  
            
        }   
       appendAllPreviousTokens();
    }

    private boolean isOpenParentheses(String current) {
        return "(".equals(current);
    }

    private void handleOpenParentheses() {
        previousTokens.push("(");
    }

    private void handleCloseParentheses() {
        balanceToOpenParantheses();
        dropTheOpenParantheses();
    }

    private boolean isCloseParentheses(String current) {
        return ")".equals(current);
    }

    public void balanceToOpenParantheses() {
        while(!previousTokens.peek().equals("("))
            appendPreviousToken();
    }

    public void dropTheOpenParantheses() {
        previousTokens.pop();
    }
    
    @MyAnnotation(name="Calculate result",  value = "method calculate the value of the tree")
    public double calculateResult(String tree){
        
        
        String[] tokens2;
        tokens2 = tree.split(" ");
      
        Stack<Token> result = new Stack<Token>();
      
        for(String current : tokens2){
            
            if(IsLiteral(current)) {
                result.push(new Constant(Double.parseDouble(current)));
                
            }
            else
            {
                Token token_right = result.pop();
                Token token_left = result.pop();
                
                
                BinaryOperator op = new BinaryOperator(current, token_left, token_right);
                
                result.push(new Constant(op.evaluate()));
                
            } 
  
            
        }
        
        return result.pop().evaluate();
    }
        
    
    
}
