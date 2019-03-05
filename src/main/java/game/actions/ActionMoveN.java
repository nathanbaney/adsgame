package game.actions;

import org.hexworks.zircon.api.Positions;
import org.hexworks.zircon.api.data.Position;
import org.hexworks.zircon.api.screen.Screen;
import game.Entity;

public class ActionMoveN extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        ent.yPos--;
        ent.position = Positions.create(ent.xPos, ent.yPos);
    }
}
