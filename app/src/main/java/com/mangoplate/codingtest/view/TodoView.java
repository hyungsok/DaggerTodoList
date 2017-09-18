package com.mangoplate.codingtest.view;

import com.mangoplate.codingtest.model.Todo;

import java.util.List;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public interface TodoView {
    void reload(List<Todo> todos);
    void reload(Todo todo);
    void remove(Todo todo);
}
