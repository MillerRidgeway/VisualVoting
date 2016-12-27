/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miller
 */
public class Point {
    double x,y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point min(Point p)
    {
        return new Point(Math.min(this.x, p.x),Math.min(this.y, p.y));
    }
    
    public Point max(Point p)
    {
        return new Point(Math.max(this.x, p.x),Math.max(this.y, p.y));
    }
    
}
