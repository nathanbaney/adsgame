package game;

import game.behaviors.Behavior;
import game.parts.Part;

import java.awt.Point;
import java.util.List;

public class EntityFactory {
    private Entity tempEntity;

    public EntityFactory(){

    }
    public void makeEntity(){
        tempEntity = new Entity();
    }
    public void withPosition(Point point){
        tempEntity.setPosition(point);
    }
    public void withName(String name){
        tempEntity.name = name;
    }
    public void withTile(Tile tile){
        tempEntity.tile = tile;
    }
    public void withParts(List<Part> parts){
        for (Part part : parts){
            tempEntity.addPart(part);
        }
    }
    public void withBehavior(Behavior behavior){
        tempEntity.behavior = behavior;
    }
    public Entity build(){
        return tempEntity;
    }
}
