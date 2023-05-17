package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Song> mData = null;
    private Context mContext;
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView song_name;
        TextView singer;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            singer = itemView.findViewById(R.id.singer);
            //img = itemView.findViewById(R.id.imageView);

            song_name = itemView.findViewById(R.id.song);
         itemView.setClickable(true);
         itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 int pos =getAdapterPosition();
                 if(pos != RecyclerView.NO_POSITION){
                     Intent intent = new Intent(mContext,SubActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                     mContext.startActivity(intent);

                 }
             }
         });



        }
    }

    RecyclerViewAdapter(Context context,ArrayList<Song> list) {
        mData = list;
        this.mContext = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Song song = mData.get(position);
        String text = song.text;
        String singer = song.singer;
        holder.song_name.setText(text);
        holder.singer.setText(singer);

    }

    @Override
    public int getItemCount() {
        return (null != mData ? mData.size() : 0);
    }
}
