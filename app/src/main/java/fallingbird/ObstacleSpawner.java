package fallingbird;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.engine.GameEngine;

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
            int y = 10 + (int) (990 * Math.random());
            int x = 10 + (int) (990 * Math.random());

            mygame.addGameObject(s,x , GameEngine.getScreenHeight());
        }

        else if (id == 2) {
            String side;
            side = setRandomSide();
            BranchAlarm.setTime(10 + (int) (80 * Math.random()));
            BranchAlarm.restartAlarm();
            Branch r = new Branch(mygame, side, ObstacleSpeed);
            mygame.addGameObject(r, GameEngine.getScreenWidth(), 0);
            if(side == "right"){
                mygame.addGameObject(r, GameEngine.getScreenWidth() - r.getFrameWidth(),GameEngine.getScreenHeight());
            }
            else if(side == "left") {
                mygame.addGameObject(r, 0, GameEngine.getScreenHeight());
            }
            else {
                mygame.addGameObject(r, GameEngine.getScreenHeight(), GameEngine.getScreenWidth() - r.getFrameWidth()/2);
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
        }
        else {
            return "center";
        }
    }
}