package game.util;

import game.Driver;
import game.grids.Grid;
import game.parts.Part;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VisionFuncs {

    public static Set<Character> seeThroughGlyphs = new HashSet<>();

    public static Set<Point> getVision(Point start, Grid grid){
        Set<Point> vision = new HashSet<>();
        vision.add(start);
        for (int x = 0; x < Driver.GRID_WIDTH; x++){
            for (int y = 0; y < Driver.GRID_HEIGHT; y++){
                Point tmp = new Point(x,y);
                if (isVisible(start, tmp, grid)){
                    vision.add(tmp);
                }
            }
        }
        return vision;
    }
    public static boolean isVisible(Point start, Point target, Grid grid){
        boolean isVisible = true;
        List<Point> visionLine = Line.getLine(start, target);
        for (int ii = 1; ii < visionLine.size(); ii++){
            if (!isSeeThrough(grid.getTile(visionLine.get(ii - 1)).glyph)){
                isVisible = false;
            }
        }
        return isVisible;
    }
    public static boolean isSeeThrough(char glyph){
        if (seeThroughGlyphs.contains(glyph)){
            return false;
        }else{
            return true;
        }
    }
    public static void initializeSeeThroughGlyphs(){
        for (int ii = 1; ii < 32; ii++){
            seeThroughGlyphs.add((char)ii);
        }
        seeThroughGlyphs.add((char)33);
        for (int ii = 35; ii < 39; ii++){
            seeThroughGlyphs.add((char)ii);
        }
        seeThroughGlyphs.add((char)40);
        seeThroughGlyphs.add((char)41);
        for (int ii = 47; ii < 94; ii++){
            seeThroughGlyphs.add((char)ii);
        }
        for (int ii = 97; ii < 127; ii++){
            seeThroughGlyphs.add((char)ii);
        }
        for (int ii = 179; ii < 224; ii++){
            seeThroughGlyphs.add((char)ii);
        }
        seeThroughGlyphs.add((char)254);
    }
}
