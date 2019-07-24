package com.lvh.demophan9api.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.demophan9api.R;
import com.lvh.demophan9api.model.Posts;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context context;
    private List<Posts> postList;

    public PostAdapter(Context context, List<Posts> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Posts mPost = postList.get(position);
        //   String imagerUrl = mPost.getTitle();
        String date = mPost.getDate();
        String title = mPost.getTitle();
        int id = mPost.getId();

        viewHolder.tvId.setText("Id: " + id);
        viewHolder.tvDate.setText("Date: " + date);
        viewHolder.tvTitle.setText("Title: " + title);

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //   public ImageView imageView;
        public TextView tvId;
        public TextView tvDate;
        public TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // imageView = itemView.findViewById(R.id.image_view);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvId = itemView.findViewById(R.id.tvId);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
