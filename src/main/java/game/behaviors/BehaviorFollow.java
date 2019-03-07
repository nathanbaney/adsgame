package game.behaviors;

import game.Entity;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BehaviorFollow extends Behavior {

    public int followDistance;
    public Queue<Point> stepQueue;
    public Entity target;

    public BehaviorFollow(Entity entity){
        super(entity);
        followDistance = 1;
        stepQueue = new ArrayBlockingQueue<>(30);
    }
    private void setTarget(Entity entity){

    }


}
