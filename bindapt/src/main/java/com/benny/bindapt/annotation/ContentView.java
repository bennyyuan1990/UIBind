package com.benny.bindapt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yuanbb on 2018/3/15.
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ContentView {
    int value();
}
