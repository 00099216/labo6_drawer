package com.andres00099216.labo6_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Andres on 14/5/2018.
 */

public class MenuFragmento extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.rcycler_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager  = new LinearLayoutManager(container.getContext());
        MenuAdapter adapter = new MenuAdapter(container.getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }
}
