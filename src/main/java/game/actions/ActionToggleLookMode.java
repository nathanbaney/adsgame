package game.actions;

import game.Entity;
import game.screens.Screen;

import java.awt.*;

import static game.Driver.wrangler;

public class ActionToggleLookMode extends Action {
    @Override
    public void execute(Screen screen, Entity ent) {
        if (wrangler.playScreen.lookMode){
            wrangler.playScreen.lookMode = false;
            System.out.println("LOOK MODE DISENGAGED");
            screen.draw();
        }else{
            wrangler.playScreen.lookMode = true;
            System.out.println("LOOK MODE ENGAGED");
            screen.draw();
        }
    }
}
