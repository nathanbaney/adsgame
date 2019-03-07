package game.actions;

import game.Entity;
import game.screens.Screen;

import static game.Driver.wrangler;

public class ActionGetPlayScreen extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        wrangler.setCurrentScreen(wrangler.playScreen);
    }
}
