package game.behaviors;

import game.Driver;
import game.Entity;
import game.util.Line;

import java.awt.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BehaviorFollow extends Behavior {

    public int followDistance;
    public Queue<Point> stepQueue;
    public Entity target;

    public int behaviorStep;

    public BehaviorFollow(Entity entity){
        super(entity);
        followDistance = 1;
        stepQueue = new ArrayBlockingQueue<>(30);
        behaviorStep = 0;
    }
    @Override
    public void setTarget(Entity target){
        this.target = target;
        stepQueue.addAll(Line.getLine(entity.position, target.position));
    }
    @Override
    public void act(){
        if (stepQueue.peek() == null || behaviorStep > 5){
            stepQueue.clear();
            stepQueue.addAll(Line.getLine(entity.position, target.position));
            behaviorStep = 0;
        }
        nextPoint = stepQueue.poll();
        behaviorStep++;
    }
}
