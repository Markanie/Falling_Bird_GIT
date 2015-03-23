package fallingbird;

import android.gameengine.icadroids.objects.collisions.ICollision;

/**
 * Created by Steuwsen on 22-03-15.
 */
public class Branch extends Obstacle implements ICollision{

    private FallingBird mygame;

    public Branch(FallingBird game, String pos,float speed){
        mygame = game;
        if(pos == "left"){
            setSprite("lbranch");
        }
        else if (pos == "right"){
            setSprite("rbranch");
        }
        else if (pos == "centre"){
            setSprite("cbranch");
        }
        this.setxSpeed(speed);
    }
    public void update() {
        super.update();

    }
}
