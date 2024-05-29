package com.example.star.scenes;

import android.graphics.Color;

import com.example.star.R;
import com.example.myfamework.CoreFW;
import com.example.myfamework.SceneFW;

public class MainMenuScene extends SceneFW{

    public MainMenuScene(com.example.myfamework.CoreFW coreFW) {
        super(coreFW);
    }


    @Override
    public void update() {
        if (coreFW.getTouchListenerFW().getTouchUp(200, 200, 100, 50)){
            coreFW.setScene(new GameScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.RED, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.RED, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350, Color.RED, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_results), 20, 400, Color.RED, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 450, Color.RED, 60, null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
