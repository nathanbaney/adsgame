package game.actions;

import game.Entity;
import game.screens.Screen;

import static game.Driver.wrangler;

public class ActionLMCycleLeft extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        if (wrangler.playScreen.focusedEntityIndex > 0){
            wrangler.playScreen.focusedEntityIndex--;
        }
        wrangler.playScreen.focusedEntity = wrangler.playScreen.entities.get(wrangler.playScreen.focusedEntityIndex);
        wrangler.playScreen.highlight(wrangler.playScreen.focusedEntity);
        screen.draw();
    }
}
