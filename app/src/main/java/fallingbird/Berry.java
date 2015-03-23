package fallingbird;

import android.gameengine.icadroids.objects.collisions.ICollision;
import java.util.ArrayList;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;

/**
 * Created by Luuk on 18-3-2015.
 */
public class Berry extends Obstacle implements ICollision{

    private FallingBird mygame;

    public Berry(FallingBird game,float speed){
        mygame = game;
        setSprite("kers");
        this.setySpeed(speed);
    }
    public void update() {
        super.update();

    }
}
