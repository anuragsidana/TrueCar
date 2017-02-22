package com.example.anurag.truecar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anurag on 2/20/2017.
 */

public class FragmentBudget extends Fragment{
BudgetAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_budget,container,false);
        String[] s=getContext().getResources().getStringArray(R.array.budget_values);
        adapter=new BudgetAdapter(getContext(),s);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new VerticalSpace(30));
        recyclerView.setAdapter(adapter);
        return view;
    }


}
