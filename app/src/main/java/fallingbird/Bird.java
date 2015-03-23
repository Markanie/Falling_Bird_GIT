package fallingbird;

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.MotionSensor;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;
import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import java.lang.Math;

import com.android.vissenspel.Monster;
import com.android.vissenspel.Strawberry;
import com.android.vissenspel.Vissenkom;

import java.util.ArrayList;
import java.util.List;

import static android.gameengine.icadroids.engine.GameEngine.getScreenHeight;
import static android.gameengine.icadroids.engine.GameEngine.getScreenWidth;

/**
 * Created by Luuk on 18-3-2015.
 */
public class Bird extends MoveableGameObject implements ICollision{
    private FallingBird mygame;
    private int score;


    public Bird (FallingBird mygame){
        this.mygame = mygame;
        setSprite("bird", 1);
        setFriction(0.1);
    }
    @Override
    public void update()
    {


        super.update();
      //  Log.d("roll", "" + MotionSensor.roll);
        setxSpeed((MotionSensor.roll-88)/0.8);

        if(getX() > getScreenWidth()- this.getFrameWidth()) {
          this.setX( this.getPrevX() - 3);

        }
        if(getX() < 0) {
            this.setX (this.getPrevX() + 3);

        }

        ArrayList<GameObject>
        gameObjects = getCollidedObjects();
        if (gameObjects != null && gameObjects.size() > 0) {
            for(GameObject gameObject : gameObjects) {
                if(gameObject instanceof Berry){
                    gameObject.setVisibility(false);
                }
            }
        }


    }
    @Override
    public void collisionOccurred(List<TileCollision> collidedTiles)
    {

    }
    public int getScore()
    {
        return score;
    }

    @Override
    public ArrayList<GameObject> getCollidedObjects() {
        ArrayList<GameObject> collidedObjects = new ArrayList<GameObject>();
        for (int i = 0; i < GameEngine.items.size(); i++) {
            if (GameEngine.items.get(i) != this) {
                if (this.ylocation > GameEngine.items.get(i).getY() - GameEngine.items.get(i).getFrameHeight() &&
                        this.ylocation - this.getFrameHeight() < GameEngine.items.get(i).getY()&&
                          this.xlocation + this.getFrameWidth() > GameEngine.items.get(i).getX()){
                    collidedObjects.add(GameEngine.items.get(i));
                }
            }
        }
        if (collidedObjects.size() > 0) {
            return collidedObjects;
        }
        return null;
    }

}
