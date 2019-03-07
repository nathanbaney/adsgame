package game;

import asciiPanel.AsciiPanel;

import java.awt.Color;

public class Tile {
    public static Color DEFAULT_BACKGROUND = Color.BLACK;
    public static Color DEFAULT_FOREGROUND = Color.WHITE;

    public static Color FOW_BACKGROUND = Color.BLACK;
    public static Color FOW_FOREGROUND = Color.DARK_GRAY;

    public char glyph;
    public Color foregroundColor;
    public Color backgroundColor;

    public boolean walkable;
    public boolean seeThrough;

    public Tile(char glyph, Color frgrnd, Color bckgrnd, boolean walkable, boolean seeThrough){
        this.glyph = glyph;
        this.foregroundColor = frgrnd;
        this.backgroundColor = bckgrnd;
        this.walkable = walkable;
        this.seeThrough = seeThrough;
    }
    public Tile (char glyph){
        this(glyph, DEFAULT_FOREGROUND, DEFAULT_BACKGROUND, true, true);
    }
    public Tile(){
        this('.');
    }
    public void draw(AsciiPanel tileGrid, int x, int y){
        tileGrid.write(glyph, x, y, foregroundColor, backgroundColor);
    }
    public void drawFOW(AsciiPanel tileGrid, int x, int y){
        tileGrid.write(glyph, x, y, FOW_FOREGROUND, FOW_BACKGROUND);
    }
}
