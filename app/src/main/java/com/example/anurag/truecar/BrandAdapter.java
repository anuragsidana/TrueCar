package com.example.anurag.truecar;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anurag on 2/20/2017.
 */

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyHolder> {
    static ArrayList<BrandInformation> list ;
    LayoutInflater inflater;
    Context context;

    public BrandAdapter(Context context, ArrayList<BrandInformation> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public BrandAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.brand_layout, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BrandAdapter.MyHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getLogo()).centerCrop().resize(340,310).into(holder.logo);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("ada2","size is "+list.size());
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        CardView cardView;

        public MyHolder(View itemView) {
            super(itemView);
            logo= (ImageView) itemView.findViewById(R.id.logo);
            cardView= (CardView) itemView.findViewById(R.id.cardView);
        }
    }

}
