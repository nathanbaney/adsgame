package game.parts;

import game.Entity;

public class PartSpines extends Part{

    public PartSpines(Entity holder){
        super(holder);
        name = "spines";
        health = 15;
        attack = 5;
        armor = 2;
        type = PartType.HEAD_PART;
    }
}
