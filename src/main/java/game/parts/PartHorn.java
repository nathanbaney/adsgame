package game.parts;

import game.Entity;

public class PartHorn extends Part{

    public PartHorn(Entity holder){
        super(holder);
        name = "horn";
        health = 10;
        attack = 5;
        armor = 0;
        type = PartType.HEAD_PART;
    }

}
