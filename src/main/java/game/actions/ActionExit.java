package game.actions;

import game.Entity;
import org.hexworks.zircon.api.screen.Screen;

public class ActionExit extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        System.exit(1);
    }
}
