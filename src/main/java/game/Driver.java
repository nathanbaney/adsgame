package game;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import game.util.MapFuncs;

import javax.swing.*;

public class Driver {
    public static int GRID_WIDTH = 60;
    public static int GRID_HEIGHT = 60;

    public static int MAP_WIDTH = 10;
    public static int MAP_HEIGHT = 10;

    public static GameWrangler wrangler;
    public static JFrame mainFrame;

    public static void main(String args[]){

        mainFrame = new JFrame();
        AsciiPanel tileGrid = new AsciiPanel(GRID_WIDTH, GRID_HEIGHT, AsciiFont.CP437_16x16);
        mainFrame.add(tileGrid);

        mainFrame.setSize(GRID_WIDTH * 15, GRID_HEIGHT * 15);
        mainFrame.setVisible(true);

        MapFuncs.initializeSolidGlyphs();
        wrangler = new GameWrangler(tileGrid);
    }
}
