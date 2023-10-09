package presentation.PieceData;

import java.awt.*;

public class Hexagon {
    private Color color;
    private int xPos;
    private int yPos;
    private String rollNum = "0";
    private Polygon hexTile;
    private boolean hasRobber;

//    private int locationID;

    public Hexagon(Color c, int x, int y, int locationID) {
        color = c;
        xPos = x;
        yPos = y;
        hexTile = new Polygon();
        hexTile.addPoint(x, y - 30);
        hexTile.addPoint(x + 30, y - 15);
        hexTile.addPoint(x + 30, y + 15);
        hexTile.addPoint(x, y + 30);
        hexTile.addPoint(x - 30, y + 15);
        hexTile.addPoint(x - 30, y - 15);
        hasRobber = false;
    }

    public Polygon getHexTile() {
        Polygon copy = new Polygon();
        copy.addPoint(xPos, yPos - 30);
        copy.addPoint(xPos + 30, yPos - 15);
        copy.addPoint(xPos + 30, yPos + 15);
        copy.addPoint(xPos, yPos + 30);
        copy.addPoint(xPos - 30, yPos + 15);
        copy.addPoint(xPos - 30, yPos - 15);
        return copy;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public void setRobber(String hasRobber) {
        if (hasRobber.equals("true")) {
            color = Color.gray;
            this.hasRobber = true;
        } else {
            this.hasRobber = false;
        }
    }

    public boolean hasRobber() {
        return hasRobber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNum = rollNumber;
    }

    public int getxPos() {
        return xPos;
    }
    public int getyPos() {
        return yPos;
    }

    public void setColorBasedOnTerrain(String terrainType) {
        if (terrainType.equals("Desert")) {
            color = Color.YELLOW;
        } else if (terrainType.equals("Mountain")) {
            color = Color.DARK_GRAY;
        } else if (terrainType.equals("Pasture")) {
            color = Color.green;
        } else if (terrainType.equals("Field")) {
            color = Color.orange;
        } else if (terrainType.equals("Forest")) {
            color = Color.MAGENTA;
        } else {
            color = Color.RED;
        }
    }
}
