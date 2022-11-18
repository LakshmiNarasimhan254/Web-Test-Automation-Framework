package org.mln.annotations;

import org.mln.enums.Categories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {

     String[] author() default "";
     Categories[] categories() default Categories.SMOKE;


}
