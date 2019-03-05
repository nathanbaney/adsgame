package game;

import org.hexworks.zircon.api.screen.Screen;
import org.hexworks.zircon.api.uievent.KeyboardEvent;
import org.hexworks.zircon.api.uievent.KeyboardEventHandler;
import org.hexworks.zircon.api.uievent.UIEventPhase;
import org.hexworks.zircon.api.uievent.UIEventResponse;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles what is actually drawn on a Screen (individual Tile data, metadata, etc).
 * This is the abstract parent, each Screen type will have its own drawer
 */
public abstract class ScreenDrawer implements KeyboardEventHandler {
    Screen screen;
    GameWrangler wrangler;

    public ScreenDrawer(Screen screen, GameWrangler wrangler){
        this.screen = screen;
        this.wrangler = wrangler;
    }

    public void draw(Screen screen){
    }

    public UIEventResponse handle(KeyboardEvent event, UIEventPhase phase){
        return null;
    }
}
