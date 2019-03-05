package game.parts;

import game.Entity;

public class PartScales extends Part{
    public PartScales(Entity holder){
        super(holder);
        name = "scales";
        health = 20;
        attack = 0;
        armor = 10;
        type = PartType.TORSO_PART;
    }
}
