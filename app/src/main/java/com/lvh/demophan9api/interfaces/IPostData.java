package com.lvh.demophan9api.interfaces;

import com.lvh.demophan9api.model.Post;

import java.util.List;

public interface IPostData {
    void onSuccess(Post post);
    void onFail(String message);
}
