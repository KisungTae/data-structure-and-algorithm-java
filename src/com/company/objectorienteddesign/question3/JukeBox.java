package com.company.objectorienteddesign.question3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JukeBox {

    public List<Music> musicList = new ArrayList<>();
    public LinkedList<Music> musicQueue = new LinkedList<>();
    public int balance;
    public static int MUSIC_PRICE = 10;

    public void selectMusic(Music music) {
        musicQueue.add(music);
    }

    public void playMusic() {
        Music music = musicQueue.pop();
        balance -= MUSIC_PRICE;
        // play music
    }

    public void addBalance(int amount) {
        balance += amount;
    }
}
