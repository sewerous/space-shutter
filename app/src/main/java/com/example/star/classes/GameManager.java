package com.example.star.classes;

import com.example.star.generators.GeneratorBackground;
import com.example.star.generators.GeneratorEnemy;
import com.example.star.obgicts.HUD;
import com.example.star.obgicts.MainPlayer;
import com.example.myfamework.CoreFW;
import com.example.myfamework.GraphicsFW;

public class GameManager {
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;
    HUD hud;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight){
        hud = new HUD(coreFW);
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        minScreenX = 0;
        minScreenY = hud.getHEIGHT_HUD();
        mainPlayer = new MainPlayer(coreFW, maxScreenX, maxScreenY - 1000, minScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight, minScreenY);
        generatorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, minScreenY);
    }

    public void update(){
        mainPlayer.update();
        generatorBackground.update(mainPlayer.getSpeedPlayer());
        generatorEnemy.update(mainPlayer.getSpeedPlayer());

        passedDistance+=mainPlayer.getSpeedPlayer();
        currentSpeedPlayer=(int)mainPlayer.getSpeedPlayer()*60;
        currentShieldsPlayer=mainPlayer.getShieldsPlayer();

        hud.update(passedDistance, currentSpeedPlayer, currentShieldsPlayer);
    }
    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
        generatorBackground.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
        hud.drawing(graphicsFW);
    }
}
