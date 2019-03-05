package game.parts;

import game.Entity;

public abstract class Part {
    public Entity holder;
    public String name;
    public int health;
    public int attack;
    public int armor;
    public PartType type;

    public Part(Entity holder){
        this.holder = holder;
        name = "default_part";
        health = 1;
        attack = 1;
        armor = 1;
        type = PartType.TORSO_PART;
    }
    public void integrate(){
        holder.totalAttack += attack;
        holder.totalArmor += armor;
    }
    public void deintegrate(){
        holder.totalAttack -= attack;
        holder.totalArmor -= armor;
    }
    public String toString(){
        return name + " hp: " + health + " atk: " + attack + " ac: " + armor;
    }
}
