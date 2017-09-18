package com.mangoplate.codingtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mangoplate.codingtest.model.Todo;
import com.mangoplate.codingtest.presenter.TodoPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoItemViewHolder> {

    private List<Todo> mTodoList = new ArrayList<>();

    private TodoPresenter mTodoPresenter;

    public TodoListAdapter(TodoPresenter todoPresenter) {
        this.mTodoPresenter = todoPresenter;
    }

    @Override
    public TodoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TodoItemViewHolder(View.inflate(parent.getContext(), R.layout.view_todo_item, null));
    }

    @Override
    public void onBindViewHolder(TodoItemViewHolder holder, int position) {
        holder.setTodoPresenter(mTodoPresenter);
        holder.bind(mTodoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTodoList != null ? mTodoList.size() : 0;
    }

    public void add(Todo todo) {
        mTodoList.add(0, todo);
        notifyDataSetChanged();
    }

    public void addAll(List<Todo> todos) {
        mTodoList.addAll(todos);
        notifyDataSetChanged();
    }

    public void remove(Todo todo) {
        mTodoList.remove(todo);
        notifyDataSetChanged();
    }

    public void clear() {
        mTodoList.clear();
        notifyDataSetChanged();
    }

}
