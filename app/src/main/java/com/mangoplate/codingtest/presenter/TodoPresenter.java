package com.mangoplate.codingtest.presenter;

import com.mangoplate.codingtest.model.Todo;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public interface TodoPresenter {
    void requestList();
    void addTodo(String content);
    void delTodo(Todo todo);
}
