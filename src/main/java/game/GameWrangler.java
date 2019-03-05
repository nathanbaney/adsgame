package game;

import game.parts.PartDoubleJointedLegs;
import game.parts.PartHorn;
import game.parts.PartScales;
import game.parts.PartSpines;
import org.hexworks.zircon.api.Screens;
import org.hexworks.zircon.api.Tiles;
import org.hexworks.zircon.api.builder.data.TileBuilder;
import org.hexworks.zircon.api.grid.TileGrid;
import org.hexworks.zircon.api.screen.Screen;

import java.util.HashMap;
import java.util.Map;

public class GameWrangler {
    private final TileGrid tileGrid;

    public Map<Screen, ScreenDrawer> screens;
    public Screen currentScreen;
    public Screen mainMenuScreen;
    public Screen playScreen;
    public Screen bodyScreen;

    public static Entity player;

    public GameWrangler(TileGrid tileGrid){
        this.tileGrid = tileGrid;

        player = new Entity("player",
                Tiles.newBuilder()
                        .withCharacter('@')
                        .buildCharacterTile(), 3,20);
        player.addPart(new PartDoubleJointedLegs(player));
        player.addPart(new PartHorn(player));
        player.addPart(new PartScales(player));
        player.addPart(new PartSpines(player));

        screens = new HashMap<>();
        mainMenuScreen = Screens.createScreenFor(tileGrid);
        playScreen = Screens.createScreenFor(tileGrid);
        bodyScreen = Screens.createScreenFor(tileGrid);
        screens.put(mainMenuScreen, new MainMenuScreenDrawer(mainMenuScreen, this));
        screens.put(playScreen, new PlayScreenDrawer(playScreen, this));
        screens.put(bodyScreen, new BodyScreenDrawer(bodyScreen, this));

        /////

        setCurrentScreen(playScreen);

    }

    public Screen getCurrentScreen(){
        return currentScreen;
    }
    public void setCurrentScreen(Screen screen){
        currentScreen = screen;
        currentScreen.display();
        screens.get(screen).draw(screen);
    }


}
