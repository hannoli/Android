package com.example.timer;

import static androidx.appcompat.widget.ResourceManagerInternal.get;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;
import java.util.List;

public class WorldRecyclerViewAdapter extends RecyclerView.Adapter<WorldRecyclerViewAdapter.Holder> {
    public Context context;
    private List<ItemData> list = new ArrayList<>();

    public WorldRecyclerViewAdapter(Context context, List<ItemData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WorldRecyclerViewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.worldrecyclerview_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorldRecyclerViewAdapter.Holder holder, int position) {
        int itemposition = position;
        holder.textView1.setText(list.get(itemposition).word);
        holder.textView2.setText(list.get(itemposition).meaning);

        Log.e("StudyApp", "onBindViewHolder" + itemposition);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public ImageView cloud;

        public Holder(View view) {
            super(view);
            textView1 = (TextView) view.findViewById(R.id.world_recycler_city);
            textView2 = (TextView) view.findViewById(R.id.world_recycler_time);
            cloud = (ImageView) view.findViewById(R.id.world_recycler_cloud);
        }
    }
}
