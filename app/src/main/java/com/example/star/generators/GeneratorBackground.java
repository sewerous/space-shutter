package com.example.star.generators;

import android.graphics.Color;

import com.example.star.obgicts.Star;
import com.example.myfamework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorBackground {
    public ArrayList<Star> starArrayList = new ArrayList<Star>();

    public GeneratorBackground(int sceneWidth, int sceneHeight, int minScreenY) {
        int starsSpeak = 50;
        for (int i = 0; i < starsSpeak; i++){
            Star star = new Star(sceneWidth, sceneHeight, minScreenY);
            starArrayList.add(star);
        }
    }

    public void update(double speedPlayer){
        for (int i = 0; i < starArrayList.size() ; i++){
            starArrayList.get(i).update(speedPlayer);
        }
    }

    public  void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < starArrayList.size() ; i++){
            graphicsFW.drawPixel(starArrayList.get(i).getX(), starArrayList.get(i).getY(), Color.WHITE);
        }
    }

}
