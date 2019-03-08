package game.actions;

import game.Entity;
import game.GameWrangler;
import game.PartEntity;
import game.parts.Part;
import game.screens.Screen;

public class ActionDropPart extends Action{
    @Override
    public void execute(Screen screen, Entity ent) {
        int slot = GameWrangler.getInstance().bodyScreen.selectedSlot;
        int headSlots = GameWrangler.getInstance().bodyScreen.currentEntity.headSlots;
        int torsoSlots = GameWrangler.getInstance().bodyScreen.currentEntity.torsoSlots;
        int legSlots = GameWrangler.getInstance().bodyScreen.currentEntity.legSlots;
        Part temp = null;
        if (GameWrangler.getInstance().bodyScreen.selectedSlot == 0){
            //do nothing
        }else if (GameWrangler.getInstance().bodyScreen.selectedSlot <= headSlots){
            if (GameWrangler.getInstance().bodyScreen.currentEntity.headParts.get(slot - 1) != null) {
                temp = GameWrangler.getInstance().bodyScreen.currentEntity.headParts.remove(slot - 1);
            }
        }else if (GameWrangler.getInstance().bodyScreen.selectedSlot <= headSlots + torsoSlots){
            if (GameWrangler.getInstance().bodyScreen.currentEntity.headParts.get(slot - headSlots - 1) != null) {
                temp = GameWrangler.getInstance().bodyScreen.currentEntity.torsoParts.remove(slot - headSlots - 1);
            }
        }else if (GameWrangler.getInstance().bodyScreen.selectedSlot <= headSlots + torsoSlots + legSlots){
            if (GameWrangler.getInstance().bodyScreen.currentEntity.headParts.get(slot - torsoSlots - headSlots - 1) != null) {
                temp = GameWrangler.getInstance().bodyScreen.currentEntity.legParts.remove(slot - torsoSlots - headSlots - 1);
            }
        }
        if (temp != null){
            GameWrangler.getInstance().currentMapGrid.entities.add(new PartEntity(temp, ent.xPos, ent.yPos));
        }
        GameWrangler.getInstance().bodyScreen.draw();
    }
}
