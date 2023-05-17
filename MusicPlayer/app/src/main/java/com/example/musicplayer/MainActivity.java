package com.example.musicplayer;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Trace;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Song> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new Song("hype boy","Newjeans"));

        RecyclerView recyclerView = findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);


    }
}




