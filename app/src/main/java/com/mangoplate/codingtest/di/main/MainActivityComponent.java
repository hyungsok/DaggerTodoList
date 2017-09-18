package com.mangoplate.codingtest.di.main;

import com.mangoplate.codingtest.MainActivity;
import com.mangoplate.codingtest.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by hyungsoklee on 2017. 9. 7..
 */
@ActivityScope
@Subcomponent(modules = {
        MainActivityModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

}
