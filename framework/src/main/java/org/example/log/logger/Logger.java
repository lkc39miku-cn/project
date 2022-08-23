package org.example.log.logger;

import org.example.log.enums.BusinessType;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logger {
    String title() default "";
    BusinessType businessType() default BusinessType.OTHER;
}