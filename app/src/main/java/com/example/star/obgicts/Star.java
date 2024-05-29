package com.example.star.obgicts;

import com.example.myfamework.ObjectFW;
import com.example.myfamework.util.UtilRandomFW;

public class Star extends ObjectFW {
    public Star(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        this.speed = 2;
        this.x = UtilRandomFW.getCasualNumber(maxScreenX);
        this.y = UtilRandomFW.getGap(minScreenY, maxScreenY);
    }

    public void update (double speedPlayer){
        x -= speedPlayer;
        x -= speed;
        if (x < 0){
            x = maxScreenX;
            this.y = UtilRandomFW.getCasualNumber(maxScreenY);
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
