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
import java.util.List;

public class PlayScreen extends Screen {
    public Map<String, Tile> tiles;
    private Map<Integer, Action> actionMap;
    private Map<Integer, Action> actionMapLM; //look mode
    public List<Entity> entities;
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
        entities = new ArrayList<>();
        highlightedEntities = new HashSet<>();
        playerVision = new HashSet<>();

        focusedEntity = wrangler.player;
        lookMode = false;
        focusedEntityIndex = 0;

        entities.add(wrangler.player);
        addCommonTiles();
        addActions();
        addTestEntities();
    }
    @Override
    public void draw(){
        wrangler.tileGrid.clear();
        wrangler.infoBar.clear();

        playerVision = VisionFuncs.getVision(wrangler.player.position, wrangler.currentMapGrid);
        drawGrid(wrangler.currentMapGrid);

        if (lookMode){
            wrangler.infoBar.write("LOOK MODE", 1, 3);
        }
        for (Entity entity : entities){
            if (entity.behavior != null){
                entity.behavior.act();
                if (wrangler.tryMove(entity.behavior.nextPoint)){
                    entity.setPosition(entity.behavior.nextPoint);
                }
            }
            entity.setDistanceFromPlayer(Line.getLine(entity.position, wrangler.player.position).size());
            System.out.println(entity.name + " dist: " + entity.distanceFromPlayer);
            if (playerVision.contains(entity.position)){
                entity.draw(wrangler.tileGrid);
            }
        }
        Collections.sort(entities, (Entity e1, Entity e2) -> {
            return e1.distanceFromPlayer - e2.distanceFromPlayer;
        });
        for (Entity entity : highlightedEntities){
            entity.highlight(wrangler.tileGrid, Color.YELLOW);
            highlightedEntities.remove(entity);
        }

        wrangler.tileGrid.repaint();
        wrangler.infoBar.repaint();
    }

    public void drawGrid(Grid grid){
        for (int x = 0; x < Driver.GRID_WIDTH; x++){
            for (int y = 0; y < Driver.GRID_HEIGHT; y++){
                if (playerVision.contains(new Point(x, y))){
                    grid.getTile(x, y).draw(wrangler.tileGrid, x, y);
                }else{
                    grid.getTile(x, y).drawFOW(wrangler.tileGrid, x, y);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!lookMode) {
            if (actionMap.containsKey(e.getKeyCode())) {
                actionMap.get(e.getKeyCode()).execute(this, wrangler.player);
            }
        }else{
            if (actionMapLM.containsKey(e.getKeyCode())) {
                actionMapLM.get(e.getKeyCode()).execute(this, focusedEntity);
            }
        }
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

    private void addTestEntities(){
        for (int ii = 0; ii < 10; ii++){
            Entity tmp = new Entity("test" + ii, new Tile((char)(ii + 10)), null, ii * 3, ii * 2);
            BehaviorFollow b = new BehaviorFollow(tmp);
            b.setTarget(wrangler.player);
            tmp.behavior = b;
            entities.add(tmp);
        }

    }
}
