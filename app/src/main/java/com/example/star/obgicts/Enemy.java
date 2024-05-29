package com.example.star.obgicts;

import com.example.star.Util.UtilResource;
import com.example.myfamework.AnimationGameFW;
import com.example.myfamework.GraphicsFW;
import com.example.myfamework.ObjectFW;
import com.example.myfamework.util.UtilRandomFW;

public class Enemy extends ObjectFW {

    AnimationGameFW animEnemy;

    public Enemy(int maxScreenX, int maxScreenY, int mixScreenY, int enemyType) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenY = 0;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        switch (enemyType){
            case 1:
                speed = UtilRandomFW.getGap(2, 5);
                animEnemy = new AnimationGameFW(3, UtilResource.spriteEnemy.get(0), UtilResource.spriteEnemy.get(1), UtilResource.spriteEnemy.get(2), UtilResource.spriteEnemy.get(3));
                break;
            case 2:
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
    }

    public void update(double speedPlayer){
        x-=speed;
        x-=speedPlayer;
        if (x<minScreenX){
            x=maxScreenX;
            y=UtilRandomFW.getGap(minScreenY,maxScreenY);
        }
        animEnemy.runAnimation();
    }

    public void drawing(GraphicsFW graphicsFW){
        animEnemy.drawingAnimation(graphicsFW, x ,y);
    }
}
