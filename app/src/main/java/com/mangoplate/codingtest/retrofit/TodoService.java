package com.mangoplate.codingtest.retrofit;

import com.mangoplate.codingtest.model.Todo;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public interface TodoService {
    @GET("todo")
    Observable<List<Todo>> getTodoList();

    @POST("todo")
    Observable<Todo> addTodoRx(@Body Todo todo);

    @DELETE("todo/{id}")
    Observable<Todo> delTodoRx(@Path("id") String id);
}

