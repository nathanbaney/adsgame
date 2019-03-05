package game;

import org.hexworks.zircon.api.*;

import org.hexworks.zircon.api.grid.TileGrid;

public class Driver {
    public static int GRID_HEIGHT = 30;
    public static int GRID_WIDTH = 40;

    public static GameWrangler wrangler;

    public static void main(String args[]){
        TileGrid tileGrid = SwingApplications.startTileGrid(
                AppConfigs.newConfig()
                        .withSize(Sizes.create(GRID_WIDTH, GRID_HEIGHT))
                        .withDefaultTileset(CP437TilesetResources.cooz16x16())
                        .build());

        GameWrangler wrangler = new GameWrangler(tileGrid);
        wrangler.getCurrentScreen().display();
    }
}
