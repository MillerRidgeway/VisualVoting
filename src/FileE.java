/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miller
 */
public class FileE {

    int eCount, line, year;
    String fileName, cLine, state;
    BufferedReader reader;

    public FileE(String fileName) {
        try {
            this.fileName = fileName;
            this.year = year;
            reader = new BufferedReader(new FileReader("data/" + fileName + ".txt"));

        } catch (Exception e) {
            System.out.println("File not found: " + fileName + "\n" + e);
            System.exit(0);
        }
    }

    public String readLine() {
        try {
            cLine = reader.readLine();
        } catch (IOException ex) {
            reportError(ex.toString());
            return cLine;
        } finally {
            line++;
        }
        return cLine;
    }

    public void reportError(String msg) {
        System.out.println(msg);
        System.out.println(fileName + "\n" + cLine + "\n" + line);
        eCount++;
    }

    public void checkBlank() {
        readLine();
        if (!cLine.equals("")) {
            System.out.println("Error: Check Blank");
        }

    }

    public String requireString() {
        readLine();
        if (cLine == null) {
            reportError("Missing Line");
        }
        return cLine;
    }

    public int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public double parseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            System.out.println(e);
            return -1.0;
        }
    }

    public int getInt() {
        readLine();
        return parseInt(cLine);
    }

    public String[] parseSpaces(String s, int n) {
        String[] b = s.trim().split("[ ]+");
        if (b.length != n) {
            System.out.println("Size greater than specified value: Spaces");
        }
        return b;
    }

    public String[] parseCommas(String s, int n) {
        String[] b = s.split(",");
        if (b.length != n) {
            reportError("Thers no comma here!");
        }
        return b;
    }

    public Point getPoint() {
        requireString();
        String[] sLine = parseSpaces(cLine, 2);
        return new Point(parseDouble(sLine[0]), parseDouble(sLine[1]));
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(FileE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
