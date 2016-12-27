/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

/**
 *
 * @author Miller
 */
public class District {

    DPolygon shape;
    int[] r = new int[Main.allYears.length];
    int[] d = new int[Main.allYears.length];
    int[] i = new int[Main.allYears.length];
    String name, stateName;
    int[] votes;
    public District() {
        this.votes = new int[Main.allYears.length];
    }

    public static District readDistrict(FileE f) {
        District d = new District();
        f.checkBlank();
        d.name = f.readLine();
        d.stateName = f.readLine();
        d.shape = DPolygon.readDPolygon(f);
        return d;
    }

    public Color getColor(int year) {
        double total = (r[year] + d[year] + i[year] + 1);
        if (Main.comboColor) {
            return new Color((int) (255 * (r[year] / total)), (int) (255 * (i[year] / total)), (int) (255 * (d[year] / total)));
        } else {
            return new Color((int) (255 * (r[year] / total)), 0, (int) (255 * (d[year] / total)));
        }
    }
}
