package presentation.PieceData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private int ownerID;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int playerID, int xPos1, int yPos1, int xPos2, int yPos2) {
        ownerID = playerID;
        x1 = xPos1;
        x2 = xPos2;
        y1 = yPos1;
        y2 = yPos2;
    }

    public Color getColor() {
        switch (ownerID) {
            case 1:
                return Color.RED;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.PINK;
            case 4:
                return Color.MAGENTA;
            default:
                return Color.BLACK;
        }
    }

    public void setOwner(int playerID) {
        ownerID = playerID;
    }

    public List<Integer> getCoordinates() {
        List<Integer> coord = new ArrayList<>();
        coord.add(x1);
        coord.add(y1);
        coord.add(x2);
        coord.add(y2);
        return coord;
    }

    public int getX() {
        return ((x1 + x2) / 2) - 5;
    }

    public int getY() {
        return ((y1 + y2) / 2) - 5;
    }

}
