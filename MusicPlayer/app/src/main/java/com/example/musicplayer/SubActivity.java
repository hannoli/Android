package com.example.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.nio.Buffer;

public class SubActivity extends Activity {
    MediaPlayer music;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_songs);
        Intent intent =getIntent();


        ImageView start = findViewById(R.id.img_start);
        music = MediaPlayer.create(this, R.raw.hypeboy);
        music.setLooping(true);
        TextView title = findViewById(R.id.song_title);
        SeekBar seekbar = findViewById(R.id.seekBar);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (music.isPlaying()) {
                    music.pause();
                    try {
                        music.prepare();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    start.setImageResource(R.drawable.play_button);
                    seekbar.setProgress(music.getCurrentPosition());
                } else {
                    music.start();
                    start.setImageResource(R.drawable.pause_button);

                    Thread();
                }
            }

            public void Thread() {
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        while (music.isPlaying()) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            seekbar.setProgress(music.getCurrentPosition());
                        }
                    }
                };
                Thread thread = new Thread(task);
                thread.start();
            }
        });
        seekbar.setMax(music.getDuration());

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    music.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            public void start(View v) {

            }

        });

    }
}
