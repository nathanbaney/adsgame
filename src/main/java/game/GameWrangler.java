package game;

import asciiPanel.AsciiPanel;
import game.parts.PartDoubleJointedLegs;
import game.parts.PartHorn;
import game.parts.PartScales;
import game.parts.PartSpines;
import game.screens.BodyScreen;
import game.screens.MainMenuScreen;
import game.screens.PlayScreen;
import game.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class GameWrangler {
    public final AsciiPanel tileGrid;

    public Set<Screen> screens;
    public Screen currentScreen;
    public MainMenuScreen mainMenuScreen;
    public PlayScreen playScreen;
    public BodyScreen bodyScreen;

    public Entity player;

    public GameWrangler(AsciiPanel tileGrid){
        this.tileGrid = tileGrid;

        player = new Entity("player", new Tile('@'), 4, 4);
        player.addPart(new PartDoubleJointedLegs(player));
        player.addPart(new PartHorn(player));
        player.addPart(new PartScales(player));
        player.addPart(new PartSpines(player));

        screens = new HashSet<>();
        mainMenuScreen = new MainMenuScreen(this);
        playScreen = new PlayScreen(this);
        bodyScreen = new BodyScreen(this);
        screens.add(mainMenuScreen);
        screens.add(playScreen);
        screens.add(bodyScreen);

        /////

        setCurrentScreen(playScreen);
    }

    public Screen getCurrentScreen(){
        return currentScreen;
    }
    public void setCurrentScreen(Screen screen){
        currentScreen = screen;
        Driver.mainFrame.addKeyListener(screen);
        currentScreen.draw();
    }


}
