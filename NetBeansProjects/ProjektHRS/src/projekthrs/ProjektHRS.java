/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

        
        

/**
 *
 * @author cirilmlinar
 */
public class ProjektHRS {

    /**
     * @param args the command line arguments
     */
    ProjektHRS demo = new ProjektHRS();
 
    Class clazz = demo.getClass();
    Annotation[] annotations = clazz.getAnnotations();    
    
    
    public static void main(String[] args) {
        
   
    ShuntingYardAlgorithm shunt = new ShuntingYardAlgorithm();
    
    //3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3
    String rez = shunt.transform("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"); 
    double rezz = shunt.calculateResult(rez);
     System.out.println(rezz);
       System.out.println(rez);      
    
       
       
     Class aClass = ShuntingYardAlgorithm.class;
Annotation annotation = aClass.getAnnotation(MyAnnotation.class);

if(annotation instanceof MyAnnotation){
    System.out.println("Class:");
    MyAnnotation myAnnotation = (MyAnnotation) annotation;
    System.out.println("name: " + myAnnotation.name());
    System.out.println("value: " + myAnnotation.value());
}  
      



   try {
      ShuntingYardAlgorithm ob = new ShuntingYardAlgorithm();
      Class c = ob.getClass();

      Method[] methods = c.getMethods();
       System.out.println("Methods:");
      for( Method method : methods ) {
            Annotation[] annotations  = method.getAnnotations();     
            for( Annotation annot : annotations ) {
                
                if(annot instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) annot;
                    System.out.println("name: " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                 }
              
            }
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    }
      
    }

}
