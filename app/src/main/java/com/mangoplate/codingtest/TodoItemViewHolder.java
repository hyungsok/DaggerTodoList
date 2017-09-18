package com.mangoplate.codingtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mangoplate.codingtest.model.Todo;
import com.mangoplate.codingtest.presenter.TodoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public class TodoItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.text)
    TextView text;

    private TodoPresenter mPresenter;
    private Todo mTodo;

    public TodoItemViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void setTodoPresenter(TodoPresenter presenter) {
        mPresenter = presenter;
    }

    public void bind(Todo todo) {
        text.setText(todo.getContent());
        mTodo = todo;
    }

    @OnClick(R.id.xbutton)
    public void delete() {
        mPresenter.delTodo(mTodo);
    }
}
