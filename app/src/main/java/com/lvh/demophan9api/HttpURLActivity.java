package com.lvh.demophan9api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.lvh.demophan9api.adapter.PostAdapter;
import com.lvh.demophan9api.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class HttpURLActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PostAdapter mPostAdapter;
    private ArrayList<Posts> mPostList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPostList = new ArrayList<>();
    }

    public void httpGet(View view) {

        mPostAdapter = new PostAdapter(HttpURLActivity.this,mPostList);
        mRecyclerView.setAdapter(mPostAdapter);

        HttpGetTask httpGetTask = new HttpGetTask(new HttpGetTask.IDone() {
            @Override
            public void done(List<Posts> a) {
                mPostList.addAll(a);
                mPostAdapter.notifyDataSetChanged();
            }
        });

        httpGetTask.execute("http://asian.dotplays.com/wp-json/wp/v2/posts");



    }
}
