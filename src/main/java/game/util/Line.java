package game.util;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Line {
    public static List<Point> getLine(Point p1, Point p2){
        List<Point> points;
        if (Math.abs(p2.y - p1.y) < Math.abs(p2.x - p1.x)) {
            if (p1.x > p2.x) {
                points = plotLineLow(p2, p1);
            } else {
                points = plotLineLow(p1, p2);
            }
        }else {
            if (p1.y > p2.y) {
                points = plotLineHigh(p2, p1);
            } else {
                points = plotLineHigh(p1, p2);
            }
        }
        points.add(p2);
        return points;
    }
    private static List<Point> plotLineLow(Point p1, Point p2){
        List<Point> points = new ArrayList<>();
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        int yi = 1;
        if (dy < 0) {
            yi = -1;
            dy = -dy;
        }
        int D = 2*dy - dx;
        int y = p1.y;

        for (int x = p1.x; x < p2.x; x++) {
            points.add(new Point(x, y));
            if (D > 0) {
                y = y + yi;
                D = D - 2 * dx;
            }
            D = D + 2 * dy;
        }
        return points;
    }
    private static List<Point> plotLineHigh(Point p1, Point p2){
        List<Point> points = new ArrayList<>();
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        int xi = 1;
        if (dx < 0) {
            xi = -1;
            dx = -dx;
        }
        int D = 2*dx - dy;
        int x = p1.x;

        for (int y = p1.y; y < p2.y; y++) {
            points.add(new Point(x, y));
            if (D > 0) {
                x = x + xi;
                D = D - 2 * dy;
            }
            D = D + 2 * dx;
        }
        return points;
    }

}
