package game;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import game.grids.Grid;
import game.util.MapFuncs;
import game.util.VisionFuncs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class Driver {
    public static int GRID_WIDTH = 60;
    public static int GRID_HEIGHT = 40;

    public static int INFO_BAR_HEIGHT = 10;

    public static int MAP_WIDTH = 10;
    public static int MAP_HEIGHT = 10;

    public static JFrame mainFrame;

    public static void main(String args[]){
        MapFuncs.initializeSolidGlyphs();
        VisionFuncs.initializeSeeThroughGlyphs();

        mainFrame = new JFrame();
        AsciiPanel tileGrid = new AsciiPanel(GRID_WIDTH, GRID_HEIGHT, AsciiFont.CP437_16x16);
        AsciiPanel infoBar = new AsciiPanel(GRID_WIDTH, INFO_BAR_HEIGHT, AsciiFont.CP437_16x16);
        GameWrangler.getInstance(tileGrid, infoBar);

        mainFrame.setSize(GRID_WIDTH * 16, (GRID_HEIGHT + INFO_BAR_HEIGHT) * 16);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(tileGrid, BorderLayout.PAGE_START);
        mainFrame.add(infoBar, BorderLayout.PAGE_END);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

    }
}
