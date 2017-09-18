package com.mangoplate.codingtest;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.mangoplate.codingtest.model.Todo;
import com.mangoplate.codingtest.presenter.TodoPresenter;
import com.mangoplate.codingtest.view.TodoView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements TodoView {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.edittext)
    EditText mEditText;

    @Inject
    TodoPresenter mTodoPresenter;
    @Inject
    TodoListAdapter mTodoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(mTodoListAdapter);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        mTodoPresenter.addTodo(v.getText().toString());
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTodoPresenter.requestList();
    }

    @Override
    public void reload(List<Todo> todoList) {
        mTodoListAdapter.addAll(todoList);
    }

    @Override
    public void reload(Todo todo) {
        mTodoListAdapter.add(todo);
    }

    @Override
    public void remove(Todo todo) {
        mTodoListAdapter.remove(todo);
    }
}
