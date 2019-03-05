package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles what is actually drawn on a Screen (individual game.Tile data, metadata, etc).
 * This is the abstract parent, each Screen type will have its own drawer
 */
public abstract class Screen extends KeyAdapter {
    GameWrangler wrangler;

    public Screen(GameWrangler wrangler){
        this.wrangler = wrangler;
    }

    public void draw(){
    }
}
