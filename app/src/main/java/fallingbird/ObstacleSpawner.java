package fallingbird;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.engine.GameEngine;
import android.util.Log;

class ObstacleSpawner implements IAlarm{

    private FallingBird mygame;
    private Alarm BerryAlarm;
    private Alarm BranchAlarm;

    private int ObstacleSpeed;

    public ObstacleSpawner(FallingBird FB){
        mygame = FB;

        BerryAlarm = new Alarm(1, 1, this);
        BranchAlarm = new Alarm(2,1 ,this);

        BerryAlarm.startAlarm();
        BranchAlarm.startAlarm();

        ObstacleSpeed = -8;
    }

    public void triggerAlarm(int id) {
        if (id == 1) {
            BerryAlarm.setTime(10 + (int) (100 * Math.random()));
            BerryAlarm.restartAlarm();
            Berry s = new Berry(mygame, ObstacleSpeed);
<<<<<<< HEAD
            int y = 10 + (int) (990 * Math.random());
=======
            // world size has not been fixed, put it in a block of 600*400 pixels
            int x = 10 + (int) (990 * Math.random());
>>>>>>> origin/master

            mygame.addGameObject(s,x , GameEngine.getScreenHeight());
        }

        else if (id == 2) {
            String side;
            side = setRandomSide();
            BranchAlarm.setTime(10 + (int) (80 * Math.random()));
            BranchAlarm.restartAlarm();
<<<<<<< HEAD
            Branch r = new Branch(mygame, side, ObstacleSpeed);
            mygame.addGameObject(r, GameEngine.getScreenWidth(), 0);
            if(side == "right"){
                mygame.addGameObject(r, GameEngine.getScreenWidth(), 0);
            }
            else if(side == "left") {
                mygame.addGameObject(r, GameEngine.getScreenWidth(), GameEngine.getScreenHeight()-300);
            }
            else {
                mygame.addGameObject(r, GameEngine.getScreenWidth(), GameEngine.getScreenHeight()/2-150);
            }
        }

    }
    private String setRandomSide(){
        double side = (Math.random());
        if(side < 0.3333){
            return "right";
        }
        else if(side>0.3333 && side<0.6666){
            return "left";
=======
            Branch r = new Branch(mygame, "right", ObstacleSpeed);
            Branch l = new Branch(mygame, "left", ObstacleSpeed);
            Log.d("alarm test", "Branch alarm!" + id);
            mygame.addGameObject(r, GameEngine.getScreenWidth() - r.getFrameWidth(), GameEngine.getScreenHeight());
            mygame.addGameObject(l, 0, GameEngine.getScreenHeight());
>>>>>>> origin/master
        }
        else {
            return "center";
        }
    }
}
