/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Polygon;
import java.util.ArrayList;

/**
 *
 * @author Miller
 */
public class DPolygon {

    ArrayList<Point> points;
    Polygon reg;

    public DPolygon(ArrayList<Point> points) {
        this.points = points;
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public Polygon toPolygon(double scale, double dx, double dy) {
        int[] xs = new int[points.size()];
        int[] ys = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xs[i] = (int) (scale * (points.get(i).x - dx));
            ys[i] = 500-(int) (scale * (points.get(i).y - dy));
        }
        return reg = new Polygon(xs, ys, points.size());
    }

    public static DPolygon readDPolygon(FileE f) {
        ArrayList<Point> temp = new ArrayList<>();
        int size = f.parseInt(f.readLine());
        for (int i = 0; i<size; i++) {
            temp.add(f.getPoint());
        }
        return new DPolygon(temp);
    }
}
