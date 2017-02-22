package com.example.anurag.truecar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;


/**
 * Created by anurag on 2/20/2017.
 */

public class BodyAdapter extends RecyclerView.Adapter<BodyAdapter.MyHolder> {
    static ArrayList<BrandInformation> list ;
    LayoutInflater inflater;
Context context;
    public BodyAdapter(Context context,ArrayList<BrandInformation> list) {
        this.context=context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.body_layout, parent, false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
       // Picasso.with(context).load(list.get(position).getLogo()).centerCrop().resize(300,210).into(holder.imageView);
        holder.textView.setText(list.get(position).getBrandName());


        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width > height) {
                    int crop = (width - height) / 2;
                    Bitmap cropImg = Bitmap.createBitmap(bitmap, crop, 0, height, height);
                    holder.imageView.setImageBitmap(cropImg);
                } else {
                    int crop = (height - width) / 2;
                    Bitmap cropImg = Bitmap.createBitmap(bitmap, 0, crop, width, width);

                    holder.imageView.setImageBitmap(cropImg);
                }

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        holder.imageView.setTag(target);
        Picasso.with(context).load(list.get(position).getLogo()).into(target);










        Log.d("ram2","brand name is "+list.get(position).getBrandName()+" logo "+list.get(position).getLogo());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
    TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView= (TextView) itemView.findViewById(R.id.body_name);

        }
    }
}


