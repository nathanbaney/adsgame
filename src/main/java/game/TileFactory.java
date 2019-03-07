package game;

import game.behaviors.Behavior;
import game.parts.Part;

import java.awt.*;
import java.util.List;

public class TileFactory {
    private Tile temp;

    public TileFactory(){

    }
    public void makeTile(){
        temp = new Tile();
    }
    public void withGlyph(char glyph){
        temp.glyph = glyph;
    }
    public void withForeground(Color color){
        temp.foregroundColor = color;
    }
    public void withBackground(Color color){
        temp.backgroundColor = color;
    }
    public void isWalkable(boolean isWalkable){
        temp.walkable = isWalkable;
    }
    public Tile build(){
        return temp;
    }
}
