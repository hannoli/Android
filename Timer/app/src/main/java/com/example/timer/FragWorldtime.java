package com.example.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragWorldtime extends Fragment {
    private RecyclerView recyclerView;
    private WorldRecyclerViewAdapter adapter;
    private ArrayList<ItemData> list = new ArrayList<>();
    ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragworldtime, container, false);
        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.world_recycler);
        recyclerView.setHasFixedSize(true);

        list = ItemData.createContactsList(5);
        adapter = new WorldRecyclerViewAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return viewGroup;
    }
}
