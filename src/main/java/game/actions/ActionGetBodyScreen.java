package game.actions;

import game.Entity;
import game.GameWrangler;
import game.screens.Screen;

public class ActionGetBodyScreen extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        GameWrangler.getInstance().bodyScreen.currentEntity = ent;
        GameWrangler.getInstance().setCurrentScreen(GameWrangler.getInstance().bodyScreen);
    }
}
