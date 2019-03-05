package game.actions;

import game.Entity;
import game.screens.Screen;

import static game.Driver.wrangler;

public class ActionGetBodyScreen extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        wrangler.bodyScreen.currentEntity = ent;
        wrangler.setCurrentScreen(wrangler.bodyScreen);
    }
}
