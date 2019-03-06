package game.grids;

import game.Driver;
import game.Tile;

import java.awt.*;

public class Grid {

    public Tile grid[][];

    public Grid(){
        grid = new Tile[Driver.GRID_WIDTH][Driver.GRID_HEIGHT];
    }
    public void putTile(int x, int y, Tile tile){
        grid[x][y] = tile;
    }
    public void putTile(Point point, Tile tile){
        grid[point.x][point.y] = tile;
    }
    public Tile getTile(int x, int y){
        return grid[x][y];
    }
    public Tile getTile(Point point){
        return grid[point.x][point.y];
    }
}
