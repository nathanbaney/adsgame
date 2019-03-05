package game;

import java.awt.Color;

public class Tile {
    public static Color DEFAULT_BACKGROUND = Color.BLACK;
    public static Color DEFAULT_FOREGROUND = Color.WHITE;

    public char glyph;
    public Color foregroundColor;
    public Color backgroundColor;

    public Tile(char glyph, Color frgrnd, Color bckgrnd){
        this.glyph = glyph;
        this.foregroundColor = frgrnd;
        this.backgroundColor = bckgrnd;
    }
    public Tile (char glyph){
        this(glyph, DEFAULT_FOREGROUND, DEFAULT_BACKGROUND);
    }
    public Tile(){
        this('.');
    }
}
