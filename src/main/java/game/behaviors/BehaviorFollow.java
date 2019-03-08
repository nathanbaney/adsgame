package game.behaviors;

import game.Driver;
import game.Entity;
import game.GameWrangler;
import game.util.Line;
import game.util.VisionFuncs;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class BehaviorFollow extends Behavior {

    public int followDistance;
    public Queue<Point> stepQueue;
    public Entity target;

    public int behaviorStep;

    public BehaviorFollow(Entity entity){
        super(entity);
        followDistance = 2;
        stepQueue = new ArrayBlockingQueue<>(30);
        behaviorStep = 0;
    }
    @Override
    public void setTarget(Entity target){
        this.target = target;
        List<Point> path = VisionFuncs.shortestPath(entity.position, target.position, entity.grid);
        stepQueue.addAll(path);
    }
    @Override
    public void act(){
        if (!stepQueue.isEmpty()){
            if (GameWrangler.getInstance().tryMove(stepQueue.peek())){
                entity.setPosition(stepQueue.poll());
            }
        }else{
            System.out.println(target.xPos + " " + target.yPos);
            stepQueue.addAll(VisionFuncs.shortestPath(entity.position, target.position, entity.grid));
        }
        behaviorStep++;
    }
}
