package game;

import asciiPanel.AsciiPanel;
import game.behaviors.Behavior;
import game.grids.Grid;
import game.parts.Part;
import game.util.Line;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Entity{
    public String name;
    public Tile tile;
    public Behavior behavior;

    public Point position;
    public int xPos;
    public int yPos;
    public Grid grid;

    public int speed;
    public int health;
    public int totalAttack;
    public int totalArmor;

    public List<Part> headParts;
    public List<Part> torsoParts;
    public List<Part> legParts;

    public int headSlots;
    public int torsoSlots;
    public int legSlots;

    public int distanceFromPlayer;

    public Entity(String name, Tile tile, Behavior behavior, int x, int y, Grid grid){
        this.name = name;
        this.tile = tile;
        this.behavior = behavior;
        xPos = x;
        yPos = y;
        position = new Point(x, y);
        this.grid = grid;

        speed = 1;
        health = 10;
        totalAttack = 1;
        totalArmor = 0;

        headParts = new ArrayList<>();
        torsoParts = new ArrayList<>();
        legParts = new ArrayList<>();
        headSlots = 2;
        torsoSlots = 2;
        legSlots = 2;

        distanceFromPlayer = 128;
    }
    public Entity(){
        this("null", null, null, 0, 0, GameWrangler.getInstance().currentMapGrid);
    }

    public void draw(AsciiPanel tileGrid){
        tileGrid.write(tile.glyph, xPos, yPos, tile.foregroundColor, tile.backgroundColor);
    }

    public void highlight(AsciiPanel tileGrid, Color color){
        tileGrid.write(tile.glyph, xPos, yPos, tile.foregroundColor, color);
    }

    public boolean addPart(Part part){
        boolean added = false;
        switch (part.type){
            case HEAD_PART:
                if (headParts.size() < headSlots) {
                    headParts.add(part);
                    part.integrate();
                    added = true;
                }
                break;
            case TORSO_PART:
                if (torsoParts.size() < torsoSlots) {
                    torsoParts.add(part);
                    part.integrate();
                    added = true;
                }
                break;
            case LEG_PART:
                if (legParts.size() < legSlots) {
                    legParts.add(part);
                    part.integrate();
                    added = true;
                }
                break;

        }
        return added;
    }
    public boolean removePart(String partName){
        boolean removed = false;
        for (Part part : headParts){
            if (part.name.equals(name)){
                headParts.remove(part);
                removed = true;
            }
        }
        for (Part part : torsoParts){
            if (part.name.equals(name)){
                torsoParts.remove(part);
                removed = true;
            }
        }
        for (Part part : legParts){
            if (part.name.equals(name)){
                legParts.remove(part);
                removed = true;
            }
        }
        return removed;
    }

    public void setPosition(Point point){
        position = point;
        xPos = point.x;
        yPos = point.y;
    }

    public void setDistanceFromPlayer(int distance){
        distanceFromPlayer = distance;
    }

    public String getPartsAsString(){
        StringBuilder bldr = new StringBuilder();
        bldr.append("HEAD PARTS:\n");
        for (Part part : headParts){
            bldr.append(part.name);
        }
        bldr.append("TORSO PARTS:\n");
        for (Part part : legParts){
            bldr.append(part.name);
        }
        bldr.append("\nLEG PARTS:\n");
        for (Part part : legParts){
            bldr.append(part.name);
        }
        return bldr.toString();
    }
    public String getHeadPartsAsString(){
        StringBuilder bldr = new StringBuilder();
        for (Part part : headParts){
            bldr.append(part.toString());
        }
        bldr.append('/');
        return bldr.toString();
    }
    public String getTorsoPartsAsString(){
        StringBuilder bldr = new StringBuilder();
        for (Part part : torsoParts){
            bldr.append(part.toString());
        }
        bldr.append('/');
        return bldr.toString();
    }
    public String getLegPartsAsString(){
        StringBuilder bldr = new StringBuilder();
        for (Part part : legParts){
            bldr.append(part.toString() + "\n");
        }
        bldr.append('/');
        return bldr.toString();
    }

}
