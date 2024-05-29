package com.example.star.obgicts;

import com.example.myfamework.AnimationGameFW;
import com.example.myfamework.CoreFW;
import com.example.myfamework.GraphicsFW;
import com.example.myfamework.ObjectFW;
import com.example.star.Util.UtilResource;

public class MainPlayer extends ObjectFW {
    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationGameFW animSpriteMainPlayer;
    AnimationGameFW animMainPlayerBoost;
    CoreFW coreFW;

    boolean boosting;
    private int shieldsPlayer;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        x = 20;
        y = 200;
        speed = 3;
        shieldsPlayer = 3;
        boosting = false;
        this.coreFW=coreFW;
        this.minScreenY = minScreenY;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        animSpriteMainPlayer = new AnimationGameFW(1, UtilResource.spritePlayer.get(0), UtilResource.spritePlayer.get(1), UtilResource.spritePlayer.get(2), UtilResource.spritePlayer.get(3));
        animMainPlayerBoost = new AnimationGameFW(1, UtilResource.spritePlayerBoost.get(0), UtilResource.spritePlayerBoost.get(1), UtilResource.spritePlayerBoost.get(2), UtilResource.spritePlayerBoost.get(3));
    }

    public void update(){
        if (coreFW.getTouchListenerFW().getTouchDown(0, minScreenY, maxScreenX, maxScreenY)){
            startBoosting();
        }
        if (coreFW.getTouchListenerFW().getTouchUp(0, minScreenY, maxScreenX, maxScreenY)){
            stopBoosting();
        }
        if (boosting){
            speed+=0.1;
        }else speed-=3;

        if (speed>MAX_SPEED){
            speed=MAX_SPEED;
        }
        if (speed<MIN_SPEED){
            speed=MIN_SPEED;
        }
        y -= speed+GRAVITY;
        if (y < minScreenY){
            y = minScreenY;
        }
        if (y < maxScreenY){
            y = maxScreenY;
        }

        if (boosting){
            animMainPlayerBoost.runAnimation();
        } else animSpriteMainPlayer.runAnimation();
    }

    private void stopBoosting() {
        boosting=false;
    }

    private void startBoosting() {
        boosting=true;
    }

    public void drawing(GraphicsFW graphicsFW){
        if (boosting){
            animMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
        } else animSpriteMainPlayer.drawingAnimation(graphicsFW, x, y);
    }

    public double getSpeedPlayer(){
        return speed;
    }
    public int getShieldsPlayer(){
        return shieldsPlayer;
    }
}
