package sad.teamone.common.annotation;

import sad.teamone.common.constant.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tuyen on 10/10/2014.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface RequestMapping {
    String[] url() default {};
    RequestMethod[] method() default {RequestMethod.GET};
}
