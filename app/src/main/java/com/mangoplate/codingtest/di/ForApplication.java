package com.mangoplate.codingtest.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by bernard on 4/28/14.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}
