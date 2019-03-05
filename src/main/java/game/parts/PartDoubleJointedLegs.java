package game.parts;

import game.Entity;

public class PartDoubleJointedLegs extends Part{
    public PartDoubleJointedLegs(Entity holder){
        super(holder);
        name = "double-joints";
        health = 5;
        attack = 2;
        armor = 0;
        type = PartType.LEG_PART;
        holder.speed += 1;
    }

}
