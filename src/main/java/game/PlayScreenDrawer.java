package game;

import game.actions.*;
import org.hexworks.zircon.api.Components;
import org.hexworks.zircon.api.UIEventResponses;
import org.hexworks.zircon.api.builder.data.TileBuilder;
import org.hexworks.zircon.api.builder.graphics.LayerBuilder;
import org.hexworks.zircon.api.component.Component;
import org.hexworks.zircon.api.component.Header;
import org.hexworks.zircon.api.data.Tile;
import org.hexworks.zircon.api.graphics.Layer;
import org.hexworks.zircon.api.screen.Screen;
import org.hexworks.zircon.api.uievent.KeyCode;
import org.hexworks.zircon.api.uievent.KeyboardEvent;
import org.hexworks.zircon.api.uievent.KeyboardEventType;
import org.hexworks.zircon.api.uievent.UIEventResponse;

import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class PlayScreenDrawer extends ScreenDrawer{
    private Set<Component> components;
    private List<Layer> layers;
    private Map<String, Tile> tiles;

    private Map<KeyCode, Action> actionMap;

    public PlayScreenDrawer(Screen screen, GameWrangler wrangler){
        super(screen, wrangler);

        components = new HashSet<>();
        layers = new ArrayList<>();
        tiles = new HashMap<>();

        actionMap = new HashMap<>();

        addComponents();
        addCommonTiles();
        addLayers();
        addActions();

        screen.onKeyboardEvent(KeyboardEventType.KEY_PRESSED, ((event, phase) -> {
            if (actionMap.containsKey(event.getCode())){
                actionMap.get(event.getCode()).execute(screen, Driver.wrangler.player);
            }
            return UIEventResponses.processed();
        }));

    }
    @Override
    public void draw(Screen screen){
        for (Layer layer : layers){
            screen.draw(layer, layer.getPosition());
        }

        System.out.println(Driver.wrangler.player.position);
        screen.draw(Driver.wrangler.player.tile, Driver.wrangler.player.position);
    }
    private void addComponents() {
        Header header = Components.header()
                .withText("PLAY SCREEN")
                .withTitle("titleHeader")
                .build();
        screen.addComponent(header);
        components.add(header);
    }
    private void addCommonTiles(){
        TileBuilder bldr = new TileBuilder();
        Tile background = bldr
                .withCharacter('.')
                .build();
        tiles.put("background_tile", background);
    }
    private void addLayers(){
        LayerBuilder bldr = new LayerBuilder();
        Layer backgroundLayer = bldr
                .withSize(screen.getSize())
                .build();
        backgroundLayer.fill(tiles.get("background_tile"));
        layers.add(backgroundLayer);
    }
    private void addActions(){
        actionMap.put(KeyCode.NUMPAD_8, new ActionMoveN());
        actionMap.put(KeyCode.NUMPAD_9, new ActionMoveNE());
        actionMap.put(KeyCode.NUMPAD_6, new ActionMoveE());
        actionMap.put(KeyCode.NUMPAD_3, new ActionMoveSE());
        actionMap.put(KeyCode.NUMPAD_2, new ActionMoveS());
        actionMap.put(KeyCode.NUMPAD_1, new ActionMoveSW());
        actionMap.put(KeyCode.NUMPAD_4, new ActionMoveW());
        actionMap.put(KeyCode.NUMPAD_7, new ActionMoveNW());
        actionMap.put(KeyCode.ESCAPE, new ActionExit());
    }
}
