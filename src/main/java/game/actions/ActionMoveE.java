package game.actions;

import game.Driver;
import game.Entity;
import game.GameWrangler;
import game.screens.Screen;

import java.awt.*;

public class ActionMoveE extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        if (GameWrangler.getInstance().tryMove(ent.xPos + 1, ent.yPos)){
            ent.xPos++;
            ent.position = new Point(ent.xPos, ent.yPos);
        }
        screen.draw();
    }
}
