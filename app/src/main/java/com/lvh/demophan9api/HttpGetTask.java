package com.lvh.demophan9api;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.lvh.demophan9api.model.Post;
import com.lvh.demophan9api.model.Posts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HttpGetTask extends AsyncTask<String, Long, String> {

    IDone iDone;

    public HttpGetTask(IDone iDone){
        this.iDone = iDone;
    }
    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            String data = "";
            while (scanner.hasNext()) {
                data = data + scanner.nextLine();
            }
            scanner.close();
            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();


        List<Posts> postList = new ArrayList<>();
        try {
            JSONArray root = new JSONArray(s);

            for (int i = 0; i < root.length(); i++) {
                JSONObject post = root.getJSONObject(i);
                int id = post.getInt("id");
                Log.e("id", String.valueOf(id));
                String date = post.getString("date");
                Log.e("date", date);
                JSONObject title = post.getJSONObject("title");
                String redered = title.getString("rendered");
                Log.e("readered", redered);

                Posts postModel = new Posts();
                postModel.id = id;
                postModel.title = redered;
                postModel.date = date;

                postList.add(postModel);
                iDone.done(postList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public interface IDone{
        void done(List<Posts> a);
    }

}
