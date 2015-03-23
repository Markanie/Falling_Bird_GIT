package fallingbird;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.engine.GameEngine;
import android.util.Log;

import com.android.vissenspel.Strawberry;
import com.android.vissenspel.Vissenkom;

/**
 * Created by Luuk on 18-3-2015.
 */
public class ObstacleSpawner implements IAlarm{

    private FallingBird mygame;
    private Alarm BerryAlarm;

    private int ObstacleSpeed;
    private Alarm BranchAlarm;

    public ObstacleSpawner(FallingBird FB){
        mygame = FB;

        BerryAlarm = new Alarm(1, 1, this);
        BranchAlarm = new Alarm(2,2,this);

        BerryAlarm.startAlarm();
        BranchAlarm.startAlarm();

        ObstacleSpeed = -8;
    }

    public void triggerAlarm(int id) {
        if (id == 1) {
           // Log.d("alarm test", "geslaagd!" + id);
            BerryAlarm.setTime(10 + (int) (500 * Math.random()));
            BerryAlarm.restartAlarm();
            Berry s = new Berry(mygame, ObstacleSpeed);
            // world size has not been fixed, put it in a block of 600*400 pixels
            int y = 10 + (int) (990 * Math.random());

            mygame.addGameObject(s, GameEngine.getScreenWidth(), y);
        }

        else if (id == 2) {
            BranchAlarm.setTime(10 + (int) (80 * Math.random()));
            BranchAlarm.restartAlarm();
            Branch r = new Branch(mygame, "right", ObstacleSpeed);
            Branch l = new Branch(mygame, "left", ObstacleSpeed);
            Log.d("alarm test", "Branch alarm!" + id);
            mygame.addGameObject(r, GameEngine.getScreenWidth(), 0);
            mygame.addGameObject(l, GameEngine.getScreenWidth(), GameEngine.getScreenHeight()-100);
        }
        else if (id==3) {
            
        }
    }
}
