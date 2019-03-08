package game.actions;

import game.Entity;
import game.GameWrangler;
import game.screens.Screen;

public class ActionToggleLookMode extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        if (GameWrangler.getInstance().playScreen.lookMode){
            GameWrangler.getInstance().playScreen.lookMode = false;
            System.out.println("LOOK MODE DISENGAGED");
            screen.draw();
        }else{
            GameWrangler.getInstance().playScreen.lookMode = true;
            System.out.println("LOOK MODE ENGAGED");
            screen.draw();
        }
    }
}
