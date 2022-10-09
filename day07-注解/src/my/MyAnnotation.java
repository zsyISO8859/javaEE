package my;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author : zhousy
 * @date : 2022/10/1 10:29
 * @version : 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE,TYPE_PARAMETER})
@Repeatable(MyAnnotations.class)
@Documented
@Inherited
public @interface MyAnnotation {
    public String value() default "hi";
}
