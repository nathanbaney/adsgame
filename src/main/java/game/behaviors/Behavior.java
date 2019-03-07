package game.behaviors;

import game.Entity;

import java.awt.*;

public abstract class Behavior {
    public Entity entity;
    public Point nextPoint;

    public Behavior(Entity entity){
        this.entity = entity;
        nextPoint = null;
    }
    public void act(){
    }

    public void setTarget(Entity player){

    }
}
