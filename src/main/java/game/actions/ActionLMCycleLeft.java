package game.actions;

import game.Entity;
import game.GameWrangler;
import game.screens.Screen;

public class ActionLMCycleLeft extends Action {

    @Override
    public void execute(Screen screen, Entity ent){
        if (GameWrangler.getInstance().playScreen.focusedEntityIndex > 0){
            GameWrangler.getInstance().playScreen.focusedEntityIndex--;
        }
        GameWrangler.getInstance().playScreen.focusedEntity = GameWrangler.getInstance()
                .currentMapGrid.entities.get(GameWrangler.getInstance().playScreen.focusedEntityIndex);
        GameWrangler.getInstance().playScreen.highlight(GameWrangler.getInstance().playScreen.focusedEntity);
        screen.draw();
    }
}
