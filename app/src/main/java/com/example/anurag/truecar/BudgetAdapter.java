package com.example.anurag.truecar;

/*
 * Created by anurag on 2/20/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.MyHolder> {
    static String[] list ;
    LayoutInflater inflater;
    Context context;

    public BudgetAdapter(Context context, String[] list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.budget_layout, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.t.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView t;

        public MyHolder(View itemView) {
            super(itemView);
            t = (TextView) itemView.findViewById(R.id.budget);
        }
    }
}
