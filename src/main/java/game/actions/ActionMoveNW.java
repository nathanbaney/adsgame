package game.actions;

import game.Entity;
import org.hexworks.zircon.api.Positions;
import org.hexworks.zircon.api.screen.Screen;

public class ActionMoveNW extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        ent.xPos--;
        ent.yPos--;
        ent.position = Positions.create(ent.xPos, ent.yPos);
    }
}
