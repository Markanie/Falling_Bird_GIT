package fallingbird;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.util.Log;

import com.android.vissenspel.Strawberry;
import com.android.vissenspel.Vissenkom;

/**
 * Created by Luuk on 18-3-2015.
 */
public class ObstacleSpawner implements IAlarm{

    private FallingBird mygame;
    private Alarm BerryAlarm;
    private Alarm ObstacleAlarm;

    public ObstacleSpawner(FallingBird FB){
        mygame = FB;
        BerryAlarm = new Alarm(2, 1, this);
        ObstacleAlarm = new Alarm(1,2,this);

        BerryAlarm.startAlarm();
        ObstacleAlarm.startAlarm();
    }

    public void triggerAlarm(int id) {
        if (id == 2) {
            Log.d("alarm test", "geslaagd!" + id);
            BerryAlarm.setTime(10 + (int) (500 * Math.random()));
            BerryAlarm.restartAlarm();
            Berry s = new Berry(mygame, -8);
            // world size has not been fixed, put it in a block of 600*400 pixels
            int x = 10 + (int) (990 * Math.random());

            mygame.addGameObject(s, 1795, x);
        }
        if (id == 1){
            ObstacleAlarm.setTime(10 + (int) (80 * Math.random()));
            ObstacleAlarm.restartAlarm();
            Log.d("alarm test", "obstacle alarm!" + id);
        }
    }
}
