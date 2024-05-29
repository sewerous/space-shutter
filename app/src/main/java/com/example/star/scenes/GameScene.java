package com.example.star.scenes;

import android.graphics.Color;

import com.example.star.R;
import com.example.star.classes.GameManager;
import com.example.star.generators.GeneratorBackground;
import com.example.myfamework.CoreFW;
import com.example.myfamework.SceneFW;

public class GameScene extends SceneFW {

    enum GameState{
        READY, RUNNING, PAUSE, GAMEOVER
    }

    GameState gameState;

    GameManager gameManager;

    public GameScene(CoreFW coreFW){
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        if (gameState==GameState.READY){
            updateStateReady();
        }
        if (gameState==GameState.RUNNING){
            updateStateRunning();
        }
        if (gameState==GameState.PAUSE){
            updateStatePause();
        }
        if (gameState==GameState.GAMEOVER){
            updateStateGameOver();
        }
    }



    @Override
    public void drawing() {
        
        graphicsFW.clearScene(Color.BLACK);

        if (gameState==GameState.READY){
            drawingStateReady();
        }
        if (gameState==GameState.RUNNING){
            drawingStateRunning();
        }
        if (gameState==GameState.PAUSE){
            drawingStatePause();
        }
        if (gameState==GameState.GAMEOVER){
            drawingStateGameOver();
        }
    }

    private void drawingStateGameOver() {
    }

    private void drawingStatePause() {
    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        //graphicsFW.drawText("Сцена игры", 250, 300, Color.WHITE, 60, null);
        gameManager.drawing(coreFW, graphicsFW);
    }

    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready), 250, 300, Color.WHITE, 60, null);

    }

    private void updateStateGameOver() {
    }

    private void updateStateRunning() {
        gameManager.update();
    }

    private void updateStatePause() {
    }

    private void updateStateReady() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            gameState=GameState.RUNNING;
        }
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
