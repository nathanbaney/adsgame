package game.screens;

import game.*;
import game.actions.*;
import game.grids.Grid;
import game.util.Line;

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

    private List<Point> lineTest;

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
        lineTest = Line.getLine(wrangler.player.position, new Point(20,20));

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
        lineTest = Line.getLine(wrangler.player.position, new Point(20,20));

        drawGrid(wrangler.grid);

        for (Point point : lineTest){
            wrangler.tileGrid.write('X', point.x, point.y);
        }
        if (lookMode){
            wrangler.tileGrid.write("LOOK MODE", 0, 0);
        }
        for (Entity entity : entities){
            entity.setDistanceFromPlayer(Line.getLine(entity.position, wrangler.player.position).size());
            System.out.println(entity.name + " dist: " + entity.distanceFromPlayer);
            entity.draw(wrangler.tileGrid);
        }
        Collections.sort(entities, (Entity e1, Entity e2) -> {
            return e1.distanceFromPlayer - e2.distanceFromPlayer;
        });
        for (Entity entity : highlightedEntities){
            entity.highlight(wrangler.tileGrid, Color.YELLOW);
            highlightedEntities.remove(entity);
        }
        wrangler.tileGrid.repaint();
    }

    public void drawGrid(Grid grid){
        for (int x = 0; x < Driver.GRID_WIDTH; x++){
            for (int y = 0; y < Driver.GRID_HEIGHT; y++){
                grid.getTile(x, y).draw(wrangler.tileGrid, x, y);
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
                actionMapLM.get(e.getKeyCode()).execute(this, wrangler.player);
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
    }

    public void highlight(Entity entity){
        highlightedEntities.add(entity);
    }

    private void addTestEntities(){
        for (int ii = 0; ii < 10; ii++){
            entities.add(new Entity("test"+ii, new Tile((char)(ii+48)), ii * 2, ii));
        }

    }
}
