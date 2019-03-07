package game.behaviors;

import game.Entity;

public abstract class Behavior {
    public Entity entity;

    public Behavior(Entity entity){
        this.entity = entity;
    }
    public void act(){
    }
}
