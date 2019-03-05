package game;

import game.parts.Part;
import game.parts.PartType;
import org.hexworks.zircon.api.Positions;
import org.hexworks.zircon.api.color.TileColor;
import org.hexworks.zircon.api.data.Position;
import org.hexworks.zircon.api.data.Tile;

import java.util.*;

public class Entity{
    public final String name;
    public Tile tile;

    public Position position;
    public int xPos;
    public int yPos;

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

    public Entity(String name, Tile tile, int x, int y){
        this.name = name;
        this.tile = tile;
        xPos = x;
        yPos = y;
        position = Positions.create(xPos,yPos);

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
