package game.actions;

import game.Entity;
import game.GameWrangler;
import game.screens.Screen;

public class ActionGetPlayScreen extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        GameWrangler.getInstance().setCurrentScreen(GameWrangler.getInstance().playScreen);
    }
}
