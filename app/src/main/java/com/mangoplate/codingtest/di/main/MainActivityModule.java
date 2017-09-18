package com.mangoplate.codingtest.di.main;

import android.content.Context;

import com.mangoplate.codingtest.MainActivity;
import com.mangoplate.codingtest.TodoListAdapter;
import com.mangoplate.codingtest.di.ActivityScope;
import com.mangoplate.codingtest.di.ForActivity;
import com.mangoplate.codingtest.presenter.TodoPresenter;
import com.mangoplate.codingtest.presenter.TodoPresenterImpl;
import com.mangoplate.codingtest.retrofit.TodoService;
import com.mangoplate.codingtest.view.TodoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hyungsoklee on 2017. 9. 7..
 */
@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    @ForActivity
    public Context provideActivityContext(MainActivity activity) {
        return activity;
    }

    @Provides
    @ActivityScope
    public TodoView provideTodoView(MainActivity activity) {
        return activity;
    }

    @Provides
    @ActivityScope
    public TodoPresenter provideTodoPresenter(TodoView todoView, TodoService todoService) {
        return new TodoPresenterImpl(todoView, todoService);
    }

    @Provides
    @ActivityScope
    public TodoListAdapter provideTodoListAdapter(TodoPresenter presenter) {
        return new TodoListAdapter(presenter);
    }
}
