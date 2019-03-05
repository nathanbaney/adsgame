package game.actions;

import game.Entity;
import game.screens.Screen;

import java.awt.*;

public class ActionMoveN extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        ent.yPos--;
        ent.position = new Point(ent.xPos, ent.yPos);
        screen.draw();
    }
}
