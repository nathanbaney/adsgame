package game.actions;

import game.Driver;
import game.Entity;
import game.screens.Screen;

import java.awt.*;

public class ActionMoveW extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        if (Driver.wrangler.tryMove(ent.xPos - 1, ent.yPos)) {
            ent.xPos--;
            ent.position = new Point(ent.xPos, ent.yPos);
        }
        screen.draw();
    }
}
