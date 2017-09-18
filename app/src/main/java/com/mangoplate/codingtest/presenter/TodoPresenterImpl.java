package com.mangoplate.codingtest.presenter;

import android.util.Log;

import com.mangoplate.codingtest.model.Todo;
import com.mangoplate.codingtest.retrofit.TodoService;
import com.mangoplate.codingtest.view.TodoView;

import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public class TodoPresenterImpl implements TodoPresenter {
    private static final String LOG_TAG = TodoPresenterImpl.class.getSimpleName();

    private TodoView mTodoView;
    private TodoService mTodoService;

    @Inject
    public TodoPresenterImpl(TodoView todoView, TodoService todoService) {
        mTodoView = todoView;
        mTodoService = todoService;
    }

    @Override
    public void requestList() {
        mTodoService.getTodoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Todo>>() {
                    @Override
                    public void call(List<Todo> todos) {
                        Log.d(LOG_TAG, "++ requestList() todos : " + todos);
                        mTodoView.reload(todos);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(LOG_TAG, "++ requestList() throwable : " + throwable);
                    }
                });
    }

    @Override
    public void addTodo(String content) {
        mTodoService.addTodoRx(new Todo(content))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Todo>() {
                    @Override
                    public void call(Todo todo) {
                        Log.d(LOG_TAG, "++ addTodoRx() todo : " + todo);
                        mTodoView.reload(todo);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(LOG_TAG, "++ addTodoRx() throwable : " + throwable);
                    }
                });
    }

    @Override
    public void delTodo(final Todo todo) {
        mTodoService.delTodoRx(String.valueOf(todo.getId()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Todo>() {
                    @Override
                    public void call(Todo t) {
                        Log.d(LOG_TAG, "++ delTodoRx() todo : " + t);
                        mTodoView.remove(todo);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(LOG_TAG, "++ delTodoRx() throwable : " + throwable);
                    }
                });
    }
}
