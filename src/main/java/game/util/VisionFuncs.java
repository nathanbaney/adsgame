package game.util;

import game.Driver;
import game.grids.Grid;

import java.awt.*;
import java.util.*;
import java.util.List;

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
    public static List<Point> shortestPath(Point start, Point target, Grid grid){
        List<Point> path = new ArrayList<>();
        //dijkstra stuff
        int infinity = 200; //lol
        Queue<PathNode> queue = new PriorityQueue<>((PathNode node1, PathNode node2) ->{
            int comp = 0;
            if (node1.cost < node2.cost){
                comp = -1;
            }else if (node2.cost < node1.cost){
                comp = 1;
            }
            return comp;
        }
                );
        PathNode nodes[][] = new PathNode[Driver.GRID_WIDTH][Driver.GRID_HEIGHT];
        for (int x = 0; x < Driver.GRID_WIDTH; x++){
            for (int y = 0; y < Driver.GRID_HEIGHT; y++){
                nodes[x][y] = new PathNode(new Point(x, y), infinity, null);
            }
        }
        nodes[start.x][start.y].cost = 0;
        for (int x = 0; x < Driver.GRID_WIDTH; x++){
            for (int y = 0; y < Driver.GRID_HEIGHT; y++){
                queue.add(nodes[x][y]);
            }
        }
        while (!queue.isEmpty()){
            PathNode u = queue.poll();
            if (u.equals(target)){
                queue.clear();
            }else{
                Set<Point> neighbors = PointFuncs.getNeighbors(u.point);
                for (Point v : neighbors){
                    if (PointFuncs.isValidPoint(v)){
                        float alt = u.cost + costOfGlyph(grid.getTile(v).glyph);
                        if (PointFuncs.isDiagonal(u.point, v)){
                            alt += 0.5f;
                        }
                        if (alt < nodes[v.x][v.y].cost){
                            nodes[v.x][v.y].cost = alt;
                            nodes[v.x][v.y].prev = u;
                        }
                    }
                }
            }
        }
        for (int y = 0; y < Driver.GRID_HEIGHT; y++){
            for (int x = 0; x < Driver.GRID_WIDTH; x++){
                System.out.print(nodes[x][y].cost + " ");
            }
            System.out.println();
        }
        PathNode pathNode = nodes[target.x][target.y];
        while (pathNode.prev != null){
            path.add(0, pathNode.point);
            pathNode = pathNode.prev;
        }
        return path;
    }
    private static float costOfGlyph(char glyph){
        float cost = 1;
        int infinity = 200;
        if (!MapFuncs.isWalkable(glyph)){
            cost = infinity;
        }
        return cost;
    }
    private static class PathNode{
        Point point;
        PathNode prev;
        float cost;
        public PathNode(Point point, float cost, PathNode prev){
            this.point = point;
            this.prev = prev;
            this.cost = cost;
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
