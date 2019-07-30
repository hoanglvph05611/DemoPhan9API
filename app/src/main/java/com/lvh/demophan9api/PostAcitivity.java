package com.lvh.demophan9api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lvh.demophan9api.interfaces.IGetData;
import com.lvh.demophan9api.interfaces.IPostData;
import com.lvh.demophan9api.interfaces.IPutData;
import com.lvh.demophan9api.model.Post;
import com.lvh.demophan9api.services.ApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostAcitivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_acitivity);
        textViewResult = findViewById(R.id.text_view_result);


    }

    public void getPosts(View view) {
        ApiService apiService = new ApiService();
        apiService.getPosts(new IGetData() {
            @Override
            public void onSuccess(List<Post> post) {
                if (post != null && post.size() > 0) {
                    for (int i = 0; i < post.size(); i++) {
                        String content = "";
                        content += "ID: " + post.get(i).getId() + "\n";
                        content += "User ID: " + post.get(i).getUserId() + "\n";
                        content += "Title: " + post.get(i).getTitle() + "\n";
                        content += "Text: " + post.get(i).getText() + "\n\n";

                        textViewResult.append(content);

                    }
                }
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void postPosts(View view) {
        ApiService apiService = new ApiService();
        apiService.postPosts(new IPostData() {
            @Override
            public void onSuccess(Post post) {
                String content = "";
                content += "ID: " + post.getId() + "\n";
                content += "User ID: " + post.getUserId() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewResult.append(content);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void putPost(View view) {
        ApiService apiService = new ApiService();
        apiService.putPost(new IPutData() {
            @Override
            public void onSuccess(int id, Post post) {


                String content = "";

                content += "ID: " + post.getId() + "\n";
                content += "User ID: " + post.getUserId() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Text: " + post.getText() + "\n\n";

                textViewResult.append(content);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void deletePost(View view) {
        ApiService apiService = new ApiService();
        apiService.getPosts(new IGetData() {
            @Override
            public void onSuccess(List<Post> post) {
                textViewResult.setText(" ");
            }

            @Override
            public void onFail(String message) {

            }
        });
    }


}
