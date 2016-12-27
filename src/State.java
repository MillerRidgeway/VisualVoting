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
public class State {

    ArrayList<District> districts = new ArrayList<>();
    Point high, low;
    String name;

    public State() {
    }

    public static State loadState(String fileName) {
        FileE reader = new FileE(fileName);
        State state = new State();
        state.low = reader.getPoint();
        state.high = reader.getPoint();
        state.name = fileName;
        int n = reader.getInt();
        for (int i = 0; i < n; i++) {
            state.districts.add(District.readDistrict(reader));
        }
        reader.close();
        return state;
    }

    public String[] getVotes(String fileName, int year) {
        FileE f = new FileE(fileName + Main.allYears[year]);
        String line = f.readLine();
        if (line != null) {
            String[] s = line.split(",");
            String b;
            while ((b = f.readLine()) != null) {
                String[] votes = f.parseCommas(b, 4);
                District d = getDistrict(votes[0]);
                if (d != null) {
                    d.r[year] = f.parseInt(votes[1]);
                    d.d[year] = f.parseInt(votes[2]);
                    d.i[year] = f.parseInt(votes[3]);
                }
            }
            return s;
        }
        return null;
    }

    public District getDistrict(String dName) {
        for (District d : districts) {
            if (d.name.equals(dName)) {
                return d;
            }
        }
        System.out.println("Name " + dName + " not found");
        return null;

    }
}
