package presentation.PieceData;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JButton {

    private int xPos;
    private int yPos;
    private int playerNum = 0;

    private Ellipse2D circle;

    public Circle(int playerID, int x, int y) {
        playerNum = playerID;
        xPos = x;
        yPos = y;
        circle = new Ellipse2D.Double(x - 5, y + 10, 10, 10);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Color getColor() {
        switch (playerNum) {
            case 1:
                return Color.RED;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.PINK;
            case 4:
                return Color.MAGENTA;
            default:
                return Color.WHITE;
        }
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public Ellipse2D getEllipse() {
        return new Ellipse2D.Double(xPos - 5, yPos + 10, 10, 10);
    }
}
