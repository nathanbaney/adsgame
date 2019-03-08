package game.grids;

import game.Driver;
import game.Entity;
import game.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Grid {

    public Tile grid[][];
    public List<Entity> entities;

    public Grid(){
        grid = new Tile[Driver.GRID_WIDTH][Driver.GRID_HEIGHT];
        entities = new ArrayList<>();
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
