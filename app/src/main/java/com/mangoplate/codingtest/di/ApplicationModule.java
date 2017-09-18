package com.mangoplate.codingtest.di;

import android.content.Context;

import com.mangoplate.codingtest.Constants;
import com.mangoplate.codingtest.di.main.MainActivityComponent;
import com.mangoplate.codingtest.retrofit.TodoService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hyungsoklee on 2017. 7. 19..
 */
@Module(subcomponents = {
        MainActivityComponent.class
})
public class ApplicationModule {
    private static final String NAME_BASE_URL = "NAME_BASE_URL";

    @Provides
    @Singleton
    public Context provideContext(@ForApplication Context context) {
        return context;
    }

    @Provides
    @Named(NAME_BASE_URL)
    public String provideBaseUrlString() {
        return Constants.BASE_API_URL;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named(NAME_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public TodoService provideTodoService(Retrofit retrofit) {
        return retrofit.create(TodoService.class);
    }

}
