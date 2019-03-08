package game.screens;

import game.*;
import game.actions.*;
import game.behaviors.BehaviorFollow;
import game.grids.Grid;
import game.util.Line;
import game.util.VisionFuncs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class PlayScreen extends Screen {
    public Map<String, Tile> tiles;
    private Map<Integer, Action> actionMap;
    private Map<Integer, Action> actionMapLM; //look mode
    public Set<Entity> highlightedEntities;
    public Set<Point> playerVision;

    public Entity focusedEntity;
    public boolean lookMode;
    public int focusedEntityIndex;

    public PlayScreen(GameWrangler wrangler){
        super(wrangler);

        tiles = new HashMap<>();
        actionMap = new HashMap<>();
        actionMapLM = new HashMap<>();
        highlightedEntities = new HashSet<>();
        playerVision = new HashSet<>();

        focusedEntity = wrangler.player;
        lookMode = false;
        focusedEntityIndex = 0;

        addActions();
        addTestEntity();
    }
    @Override
    public void draw(){
        GameWrangler.getInstance().tileGrid.clear();
        GameWrangler.getInstance().infoBar.clear();

        playerVision = VisionFuncs.getVision(GameWrangler.getInstance().player.position, GameWrangler.getInstance().currentMapGrid);
        drawGrid(GameWrangler.getInstance().currentMapGrid);

        if (lookMode){
            GameWrangler.getInstance().infoBar.write("LOOK MODE", 1, 3);
        }
        for (Entity entity : GameWrangler.getInstance().currentMapGrid.entities){
            if (entity.behavior != null){
                entity.behavior.act();
            }
            entity.setDistanceFromPlayer(Line.getLine(entity.position, GameWrangler.getInstance().player.position).size());
            System.out.println(entity.name + " dist: " + entity.distanceFromPlayer);
            if (playerVision.contains(entity.position)){
                entity.draw(GameWrangler.getInstance().tileGrid);
            }
        }
        GameWrangler.getInstance().player.draw(GameWrangler.getInstance().tileGrid);
        Collections.sort(GameWrangler.getInstance().currentMapGrid.entities, (Entity e1, Entity e2) -> {
            return e1.distanceFromPlayer - e2.distanceFromPlayer;
        });
        for (Entity entity : highlightedEntities){
            entity.highlight(GameWrangler.getInstance().tileGrid, Color.YELLOW);
            highlightedEntities.remove(entity);
        }

        wrangler.tileGrid.repaint();
        wrangler.infoBar.repaint();
    }

    public void drawGrid(Grid grid){
        for (int x = 0; x < Driver.GRID_WIDTH; x++){
            for (int y = 0; y < Driver.GRID_HEIGHT; y++){
                if (playerVision.contains(new Point(x, y))){
                    grid.getTile(x, y).draw(GameWrangler.getInstance().tileGrid, x, y);
                }else{
                    grid.getTile(x, y).drawFOW(GameWrangler.getInstance().tileGrid, x, y);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!lookMode) {
            if (actionMap.containsKey(e.getKeyCode())) {
                actionMap.get(e.getKeyCode()).execute(this, GameWrangler.getInstance().player);
            }
        }else{
            if (actionMapLM.containsKey(e.getKeyCode())) {
                actionMapLM.get(e.getKeyCode()).execute(this, focusedEntity);
            }
        }
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
        actionMap.put(KeyEvent.VK_I, new ActionGetBodyScreen());
        actionMap.put(KeyEvent.VK_L, new ActionToggleLookMode());

        actionMapLM.put(KeyEvent.VK_NUMPAD6, new ActionLMCycleRight());
        actionMapLM.put(KeyEvent.VK_NUMPAD4, new ActionLMCycleLeft());
        actionMapLM.put(KeyEvent.VK_ESCAPE, new ActionExit());
        actionMapLM.put(KeyEvent.VK_L, new ActionToggleLookMode());
        actionMapLM.put(KeyEvent.VK_I, new ActionGetBodyScreen());

    }
    public void highlight(Entity entity){
        highlightedEntities.add(entity);
    }
    public void addTestEntity(){
        Entity test = new Entity(
                "test",
                new Tile('T'),
                null,
                30, 25, GameWrangler.getInstance().currentMapGrid);
        test.behavior = new BehaviorFollow(test);
        test.behavior.setTarget(GameWrangler.getInstance().player);
        GameWrangler.getInstance().currentMapGrid.entities.add(test);
    }
}
