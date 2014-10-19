package sad.teamone.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tuyen on 10/10/2014.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE) //Use for class level
@Component
public @interface Controller {
    String value() default "";
}
