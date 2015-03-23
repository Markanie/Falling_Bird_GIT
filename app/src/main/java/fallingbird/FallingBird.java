package fallingbird;

import android.content.pm.ActivityInfo;
import android.gameengine.icadroids.dashboard.DashboardTextView;
import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.MotionSensor;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;
import android.gameengine.icadroids.tiles.GameTiles;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;

import com.android.vissenspel.StrawberryControler;

public class FallingBird extends GameEngine{
    private Bird bird;
    @Override
    protected void initialize() {
        TouchInput.use = false;
        MotionSensor.use = true;
        OnScreenButtons.use = false;
        ObstacleSpawner spawner = new ObstacleSpawner(this);
        bird = new Bird(this);
        addGameObject(bird, 160, 50);
        setBackground("bg");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    @Override
    public void update() {
        super.update();
    }
}
