package my;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author : zhousy
 * @date : 2022/10/1 10:29
 * @version : 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE,TYPE_PARAMETER})
@Documented
@Inherited
public @interface MyAnnotations {
    public MyAnnotation[] value() ;
}
