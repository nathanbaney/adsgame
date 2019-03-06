package game.grids;

import game.Driver;
import game.Tile;

public class Grid {

    public Tile grid[][];

    public Grid(){
        grid = new Tile[Driver.GRID_WIDTH][Driver.GRID_HEIGHT];
    }
    public void putTile(int x, int y, Tile tile){
        grid[x][y] = tile;
    }
    public Tile getTile(int x, int y){
        return grid[x][y];
    }
}
