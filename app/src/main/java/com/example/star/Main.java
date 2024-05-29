package com.example.star;

import com.example.star.scenes.MainMenuScene;
import com.example.myfamework.CoreFW;
import com.example.myfamework.SceneFW;

import com.example.star.classes.LoaderAssets;

public class Main extends CoreFW {

    public SceneFW getStartScene(){
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }
}