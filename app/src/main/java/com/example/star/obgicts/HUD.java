package com.example.star.obgicts;

import android.graphics.Color;

import com.example.myfamework.CoreFW;
import com.example.myfamework.GraphicsFW;
import com.example.star.R;

public class HUD {
    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    CoreFW coreFW;

    private final int HEIGHT_HUD = 50;

    public HUD(CoreFW coreFW) {
        this.coreFW = coreFW;
    }

    public void update(int passedDistance, int currentSpeedPlayer, int currentShieldsPlayer){
        this.passedDistance = passedDistance;
        this.currentSpeedPlayer = currentSpeedPlayer;
        this.currentShieldsPlayer = currentShieldsPlayer;
    }

    public void drawing(GraphicsFW graphicsFW){
        graphicsFW.drawLine(0, graphicsFW.getHeightFrameBuffer(), HEIGHT_HUD, HEIGHT_HUD, Color.WHITE);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_passedDistance)+":"+passedDistance, 10, 30, Color.BLUE, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_currentSpeedPlayer)+":"+currentSpeedPlayer, 350, 30, Color.BLUE, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_hud_currentShieldsPlayer)+":"+currentShieldsPlayer, 650, 30, Color.BLUE, 25, null);
    }

    public int getHEIGHT_HUD() {
        return HEIGHT_HUD;
    }
}
