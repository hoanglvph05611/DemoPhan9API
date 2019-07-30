package com.lvh.demophan9api.interfaces;

import com.lvh.demophan9api.model.Post;

public interface IPutData {
    void onSuccess(int id,Post post);
    void onFail(String message);
}
