package game.util;

import game.Driver;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class PointFuncs {
    public static Point getN(Point point){
        return new Point(point.x, point.y - 1);
    }
    public static Point getNE(Point point){
        return new Point(point.x + 1, point.y - 1);
    }
    public static Point getE(Point point){
        return new Point(point.x + 1, point.y);
    }
    public static Point getSE(Point point){
        return new Point(point.x + 1, point.y + 1);
    }
    public static Point getS(Point point){
        return new Point(point.x, point.y + 1);
    }
    public static Point getSW(Point point){
        return new Point(point.x - 1, point.y + 1);
    }
    public static Point getW(Point point){
        return new Point(point.x - 1, point.y);
    }
    public static Point getNW(Point point){
        return new Point(point.x - 1, point.y - 1);
    }
    public static Set<Point> getNeighbors(Point point){
        Set<Point> points = new HashSet<>();
        points.add(getN(point));
        points.add(getNE(point));
        points.add(getE(point));
        points.add(getSE(point));
        points.add(getS(point));
        points.add(getSW(point));
        points.add(getW(point));
        points.add(getNW(point));
        return points;
    }
    public static Set<Point> getValidNeighbors(Point point){
        Set<Point> points = getNeighbors(point);
        for (Point tmp : points){
            if (!isValidPoint(tmp)){
                points.remove(tmp);
            }
        }
        return points;
    }
    public static boolean isValidPoint(Point point){
        if (point.x >= 0 && point.x < Driver.GRID_WIDTH && point.y >= 0 && point.y < Driver.GRID_HEIGHT){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDiagonal(Point p1, Point p2){
        if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 1){
            return true;
        }else {
            return false;
        }
    }
}
