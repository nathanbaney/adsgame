package game;

import game.parts.Part;
import game.util.Line;

import java.awt.*;

import static game.Driver.wrangler;

public class PartEntity extends Entity {
    public PartEntity(Part part, int x, int y){
        super();
        this.name = part.name;
        this.tile = new Tile(getGlyph(part), getColor(part), Tile.DEFAULT_BACKGROUND, true, true);
        this.xPos = x;
        this.yPos = y;
        this.position = new Point(x, y);
    }
    private char getGlyph(Part part){
        char glyph = 0;
        switch (part.type){
            case HEAD_PART:
                glyph = (char)155;
                break;
            case TORSO_PART:
                glyph = (char)157;
                break;
            case LEG_PART:
                glyph = (char)243;
                break;
        }
        return glyph;
    }
    private Color getColor(Part part){
        Color color = Color.WHITE;
        if (part.health < 3){
            color = Color.RED;
        }else if (part.health < 6){
            color = Color.ORANGE;
        }else if (part.health < 9){
            color = Color.YELLOW;
        }
        return color;
    }
}
