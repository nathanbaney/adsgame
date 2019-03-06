package game.actions;

import game.Driver;
import game.Entity;
import game.screens.Screen;

import java.awt.*;

public class ActionMoveS extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        if (Driver.wrangler.tryMove(ent.xPos, ent.yPos + 1)) {
            ent.yPos++;
            ent.position = new Point(ent.xPos, ent.yPos);
        }
        screen.draw();
    }
}
