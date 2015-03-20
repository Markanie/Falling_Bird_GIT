package fallingbird;

import android.gameengine.icadroids.objects.MoveableGameObject;
import android.gameengine.icadroids.objects.collisions.ICollision;
import android.gameengine.icadroids.objects.collisions.TileCollision;

import java.util.List;

/**
 * Created by Luuk on 18-3-2015.
 */
public class Obstacle extends MoveableGameObject implements ICollision {


    @Override
    public void collisionOccurred(List<TileCollision> collidedTiles) {

    }

}
