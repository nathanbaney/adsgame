package game.actions;

import game.Entity;
import game.PartEntity;
import game.parts.Part;
import game.screens.Screen;

import static game.Driver.wrangler;

public class ActionDropPart extends Action{
    @Override
    public void execute(Screen screen, Entity ent) {
        int slot = wrangler.bodyScreen.selectedSlot;
        int headSlots = wrangler.bodyScreen.currentEntity.headSlots;
        int torsoSlots = wrangler.bodyScreen.currentEntity.torsoSlots;
        int legSlots = wrangler.bodyScreen.currentEntity.legSlots;
        Part temp = null;
        if (wrangler.bodyScreen.selectedSlot == 0){
            //do nothing
        }else if (wrangler.bodyScreen.selectedSlot <= headSlots){
            if (wrangler.bodyScreen.currentEntity.headParts.get(slot - 1) != null) {
                temp = wrangler.bodyScreen.currentEntity.headParts.remove(slot - 1);
            }
        }else if (wrangler.bodyScreen.selectedSlot <= headSlots + torsoSlots){
            if (wrangler.bodyScreen.currentEntity.headParts.get(slot - headSlots - 1) != null) {
                temp = wrangler.bodyScreen.currentEntity.torsoParts.remove(slot - headSlots - 1);
            }
        }else if (wrangler.bodyScreen.selectedSlot <= headSlots + torsoSlots + legSlots){
            if (wrangler.bodyScreen.currentEntity.headParts.get(slot - torsoSlots - headSlots - 1) != null) {
                temp = wrangler.bodyScreen.currentEntity.legParts.remove(slot - torsoSlots - headSlots - 1);
            }
        }
        if (temp != null){
            wrangler.playScreen.entities.add(new PartEntity(temp, ent.xPos, ent.yPos));
        }
        wrangler.bodyScreen.draw();
    }
}
