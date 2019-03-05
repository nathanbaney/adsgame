package game.actions;

import game.Entity;
import game.screens.Screen;

public class ActionExit extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        System.exit(1);
    }
}
