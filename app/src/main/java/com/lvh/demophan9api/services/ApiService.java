package com.lvh.demophan9api.services;

import android.view.View;

import com.lvh.demophan9api.interfaces.IGetData;
import com.lvh.demophan9api.interfaces.IPostData;
import com.lvh.demophan9api.interfaces.IPutData;
import com.lvh.demophan9api.model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiService {

    public void getPosts(final IGetData iGetData) {
        Call<List<Post>> call = BaseServices.getBaseService().getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    iGetData.onFail("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();
                iGetData.onSuccess(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                iGetData.onFail(t.getMessage());
            }
        });
    }

    public void deletePost(final IGetData iGetData) {
        Call<Void> call = BaseServices.getBaseService().deletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                iGetData.onFail("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                iGetData.onFail(t.getMessage());
            }
        });
    }

    public void postPosts(final IPostData iPostData) {
        Post post = new Post(23, "new Title", "new Text");
        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title", "New Title");
        //  Call<Post> call = jsonPlaceHolderApi.createPost(fields);

        Call<Post> call = BaseServices.getBaseService().createPost(fields);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    iPostData.onFail("Code: " + response.code());
                    return;
                }

                Post posts = response.body();
                iPostData.onSuccess(posts);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                iPostData.onFail(t.getMessage());
            }
        });
    }

    public void putPost(final IPutData iPutData) {
        Post post = new Post(12, null, "New Text");

        Call<Post> call = BaseServices.getBaseService().putPost(5, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    iPutData.onFail("Code: " + response.code());
                    return;
                }
                Post posts = response.body();
                iPutData.onSuccess(5, posts);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                iPutData.onFail(t.getMessage());
            }
        });
    }


}
