package game;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import game.util.MapFuncs;
import game.util.VisionFuncs;

import javax.swing.*;
import java.awt.*;

public class Driver {
    public static int GRID_WIDTH = 60;
    public static int GRID_HEIGHT = 40;

    public static int INFO_BAR_HEIGHT = 10;

    public static int MAP_WIDTH = 10;
    public static int MAP_HEIGHT = 10;

    public static GameWrangler wrangler;
    public static JFrame mainFrame;

    public static void main(String args[]){

        mainFrame = new JFrame();
        AsciiPanel tileGrid = new AsciiPanel(GRID_WIDTH, GRID_HEIGHT, AsciiFont.CP437_16x16);
        AsciiPanel infoBar = new AsciiPanel(GRID_WIDTH, INFO_BAR_HEIGHT, AsciiFont.CP437_16x16);

        mainFrame.setSize(GRID_WIDTH * 16, (GRID_HEIGHT + INFO_BAR_HEIGHT) * 16);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(tileGrid, BorderLayout.PAGE_START);
        mainFrame.add(infoBar, BorderLayout.PAGE_END);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

        MapFuncs.initializeSolidGlyphs();
        VisionFuncs.initializeSeeThroughGlyphs();
        wrangler = new GameWrangler(tileGrid, infoBar);
    }
}
