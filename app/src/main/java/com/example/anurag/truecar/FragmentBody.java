package com.example.anurag.truecar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by anurag on 2/20/2017.
 */

public class FragmentBody extends Fragment implements ListLoadedListener, FragmentVisible {

    static LinearLayout mLayout;
   static BodyAdapter adapter;
    static RecyclerView recyclerView;
    static LinearLayout mainLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body, container, false);
        mLayout = (LinearLayout) view.findViewById(R.id.headerProgress);
        mainLayout=(LinearLayout) view.findViewById(R.id.linear);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }


    public void showResults(Context context) {
        if (Utils.isConnected(context)) {
            mLayout.setVisibility(View.VISIBLE);
            MyAsyncTask task = new MyAsyncTask(context, this, "http://139.59.38.81/body/");
            task.execute();

        }
        else {
            Snackbar s = Snackbar.make(mainLayout, "You are not connected to INTERNET", Snackbar.LENGTH_LONG);
            s.show();
        }
    }

    @Override
    public void fragmentBecomeVisible(int position) {
        showResults(MyApplication.getAppContext());
    }

    @Override
    public void onListLoaded(String data) {
        mLayout.setVisibility(View.GONE);
        ArrayList<BrandInformation> list=getList(data);
       if(list!=null&&list.size()>0) {
            adapter = new BodyAdapter(MyApplication.getAppContext(),list );
            recyclerView.setAdapter(adapter);
        }
        else{
            Toast.makeText(MyApplication.getAppContext(),"Data didnt loaded perfectly ,Trying again",Toast.LENGTH_LONG);
            showResults(MyApplication.getAppContext());
        }
    }

    ArrayList<BrandInformation> getList(String s) {
        ArrayList<BrandInformation> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(s);
            if (jsonArray != null &&jsonArray.length()>0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    BrandInformation information = new BrandInformation();
                    JSONObject current = jsonArray.getJSONObject(i);
                    information.setBrandName(current.getString("bode_type"));
                    information.setLogo(current.getString("logo_add"));
                    list.add(information);
                }
            }
            }catch(JSONException e){
                e.printStackTrace();
            }

        Log.d("ada2","size br=efore sending is "+list.size());
        return list;
    }


}
