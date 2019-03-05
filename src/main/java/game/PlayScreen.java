package game;

import game.actions.*;

import java.awt.event.KeyEvent;
import java.util.*;

public class PlayScreen extends Screen {
    private Map<String, Tile> tiles;
    private Map<Integer, Action> actionMap;

    public PlayScreen(GameWrangler wrangler){
        super(wrangler);

        tiles = new HashMap<>();

        actionMap = new HashMap<>();

        addCommonTiles();
        addActions();
    }
    @Override
    public void draw(){
        wrangler.tileGrid.clear();
        wrangler.tileGrid.write('@', wrangler.player.xPos, wrangler.player.yPos);
        wrangler.tileGrid.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(wrangler.player.xPos + " " + wrangler.player.yPos);

        if (actionMap.containsKey(e.getKeyCode())){
            actionMap.get(e.getKeyCode()).execute(this, Driver.wrangler.player);
        }
        draw();
    }

    private void addCommonTiles(){
        Tile background = new Tile('.');
        tiles.put("background_tile", background);
    }

    private void addActions(){
        actionMap.put(KeyEvent.VK_NUMPAD8, new ActionMoveN());
        actionMap.put(KeyEvent.VK_NUMPAD9, new ActionMoveNE());
        actionMap.put(KeyEvent.VK_NUMPAD6, new ActionMoveE());
        actionMap.put(KeyEvent.VK_NUMPAD3, new ActionMoveSE());
        actionMap.put(KeyEvent.VK_NUMPAD2, new ActionMoveS());
        actionMap.put(KeyEvent.VK_NUMPAD1, new ActionMoveSW());
        actionMap.put(KeyEvent.VK_NUMPAD4, new ActionMoveW());
        actionMap.put(KeyEvent.VK_NUMPAD7, new ActionMoveNW());
        actionMap.put(KeyEvent.VK_ESCAPE, new ActionExit());
    }
}
