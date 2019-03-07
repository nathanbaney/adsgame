package game.util;

import java.awt.*;

public class PointFuncs {
    public Point getN(Point point){
        return new Point(point.x, point.y - 1);
    }
    public Point getNE(Point point){
        return new Point(point.x + 1, point.y - 1);
    }
    public Point getE(Point point){
        return new Point(point.x + 1, point.y);
    }
    public Point getSE(Point point){
        return new Point(point.x + 1, point.y + 1);
    }
    public Point getS(Point point){
        return new Point(point.x, point.y + 1);
    }
    public Point getSW(Point point){
        return new Point(point.x - 1, point.y + 1);
    }
    public Point getW(Point point){
        return new Point(point.x - 1, point.y);
    }
    public Point getNW(Point point){
        return new Point(point.x - 1, point.y - 1);
    }
}
