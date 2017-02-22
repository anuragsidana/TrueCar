package com.example.anurag.truecar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by anurag on 2/20/2017.
 */

public class MyAsyncTask extends AsyncTask<Void,Void,String> {
Context context;
    ListLoadedListener listener;
    String url;
    public MyAsyncTask(Context context, Fragment fragment,String url){
        this.context=context;
        this.url=url;
        listener= (ListLoadedListener) fragment;

    }



    @Override
    protected String doInBackground(Void... voids) {
        return SearchData(url);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.onListLoaded(s);
    }

    public String SearchData(String urlstr) {
        String result = null;
        HttpURLConnection conn = null;
        InputStream stream = null;
        URL url=null;
        try{
            url=new URL(urlstr);
            conn = (HttpURLConnection) url.openConnection();
            Log.d("click", "inside try 2");
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            if (conn.getResponseCode() == 200) {

                stream = conn.getInputStream();
                Log.d("click", "inside try 3");
                if (stream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                    StringBuilder builder = new StringBuilder();
                    Log.d("click", "inside tr4y");
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {

                        builder.append(line + "\n");
                        Log.d("line", line);

                    }

                    result = builder.toString();
                }
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return result;
    }


}
