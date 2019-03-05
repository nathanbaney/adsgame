package game;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

import javax.swing.*;

public class Driver {
    public static int GRID_HEIGHT = 30;
    public static int GRID_WIDTH = 40;

    public static GameWrangler wrangler;
    public static JFrame mainFrame;

    public static void main(String args[]){
        mainFrame = new JFrame();
        AsciiPanel tileGrid = new AsciiPanel(40, 30, AsciiFont.TALRYTH_15_15);
        mainFrame.add(tileGrid);

        mainFrame.setSize(GRID_WIDTH * 15, GRID_HEIGHT * 15);
        mainFrame.setVisible(true);

        wrangler = new GameWrangler(tileGrid);

    }
}
