package game;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import game.grids.Grid;
import game.util.MapLoader;

import javax.swing.*;
import java.io.File;

public class Driver {
    public static int GRID_HEIGHT = 60;
    public static int GRID_WIDTH = 60;

    public static GameWrangler wrangler;
    public static JFrame mainFrame;

    public static void main(String args[]){

        mainFrame = new JFrame();
        AsciiPanel tileGrid = new AsciiPanel(GRID_WIDTH, GRID_HEIGHT, AsciiFont.TALRYTH_15_15);
        mainFrame.add(tileGrid);

        mainFrame.setSize(GRID_WIDTH * 15, GRID_HEIGHT * 15);
        mainFrame.setVisible(true);

        wrangler = new GameWrangler(tileGrid);
    }
}
