package com.example.musicplayer;

public class Song {
    public String singer;
    public String text;

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    Song(String text, String singer) {
        this.text = text;
        this.singer = singer;
    }
}
