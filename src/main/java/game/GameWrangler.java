package game;

import asciiPanel.AsciiPanel;
import game.grids.Grid;
import game.parts.PartDoubleJointedLegs;
import game.parts.PartHorn;
import game.parts.PartScales;
import game.parts.PartSpines;
import game.screens.BodyScreen;
import game.screens.MainMenuScreen;
import game.screens.PlayScreen;
import game.screens.Screen;
import game.util.MapFuncs;

import java.awt.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class GameWrangler {
    public final AsciiPanel tileGrid;

    public Set<Screen> screens;
    public Screen currentScreen;
    public MainMenuScreen mainMenuScreen;
    public PlayScreen playScreen;
    public BodyScreen bodyScreen;

    public Grid mapGrid[][];
    public Grid currentMapGrid;
    public Point currentMapGridIndex;

    public Entity player;

    public GameWrangler(AsciiPanel tileGrid){
        this.tileGrid = tileGrid;
        this.mapGrid = new Grid[Driver.MAP_WIDTH][Driver.MAP_HEIGHT];
        initializeMapGrid();
        currentMapGridIndex = new Point(0,0);
        currentMapGrid = getMapGrid(currentMapGridIndex);
        MapFuncs.load(new File("E:\\development\\adsgame\\src\\main\\java\\game\\grids\\testmap1.xml"), currentMapGrid);

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
    public Grid getMapGrid(Point index){
        return mapGrid[index.x][index.y];
    }
    public boolean tryMove(Point point){
        return tryMove(point.x, point.y);
    }
    public boolean tryMove(int x, int y){
        if (MapFuncs.isWalkable(currentMapGrid.getTile(x, y).glyph)){
            return true;
        }else {
            System.out.println("BONK! ouch -.-#");
            return false;
        }
    }
    private void initializeMapGrid(){
        for (int x = 0; x < Driver.MAP_WIDTH; x++){
            for (int y = 0; y < Driver.MAP_HEIGHT; y++){
                mapGrid[x][y] = new Grid();
                //eventually load map info
            }
        }
    }


}
