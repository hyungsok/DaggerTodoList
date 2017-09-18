package com.mangoplate.codingtest.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by munkyushin on 6/28/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForActivity {
}
