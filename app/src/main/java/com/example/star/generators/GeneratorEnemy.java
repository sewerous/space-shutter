package com.example.star.generators;

import com.example.star.obgicts.Enemy;
import com.example.myfamework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorEnemy {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemy(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        enemyArrayList = new ArrayList<>();
    }

    public void update(double speedPlayer){
        if (enemyArrayList.size()<3){
            addEnemy(speedPlayer,3);
        }
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update(speedPlayer);
        }
    }

    private void addEnemy(double speedPlayer, int amountEnemy) {
        for (int i = 0; i < amountEnemy; i++){
            enemyArrayList.add(new Enemy(maxScreenX,maxScreenY,minScreenY,1));
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).drawing(graphicsFW);
        }
    }
}
