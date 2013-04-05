/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekthrs;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author cirilmlinar
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
     public String value();

     public String name();
    
}
