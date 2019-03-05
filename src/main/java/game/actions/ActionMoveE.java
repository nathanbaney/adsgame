package game.actions;

import game.Entity;
import game.screens.Screen;

import java.awt.*;

public class ActionMoveE extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        ent.xPos++;
        ent.position = new Point(ent.xPos, ent.yPos);
        screen.draw();
    }
}
