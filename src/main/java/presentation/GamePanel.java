package presentation;
import presentation.PieceData.*;

import javax.swing.*;

import java.awt.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GamePanel extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private Map<Integer, Hexagon> terrainPieces;
    private Map<String, Circle> settlementPieces;
    private BankInfo bankInfo;
    private Map<String, Line> roadPieces;
    private String currentTurn;
    private String phase;
    private String playerHandInfo = "";
    private JLabel playerHands;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        terrainPieces = new HashMap();
        settlementPieces = new HashMap<>();
        roadPieces = new HashMap<>();
        setupDefaultTiles();
        setupDefaultRoads();
        setupDefaultSettlements();
        initializeInformationPanels();
    }

    private void initializeInformationPanels() {
        bankInfo = new BankInfo(550, 50);
        currentTurn = "";
        phase = "";
        playerHands = new JLabel("Player Hands");
    }

    private void setupDefaultRoads() {
        roadPieces.put("0, 1, 11, 0, 10, 11", new Line(0, 180,  115, 150, 130));
        roadPieces.put("0, 1, 11, 1, 11, 12", new Line(0, 180, 115, 210, 130));
        roadPieces.put("1, 2, 12, 1, 11, 12", new Line(0, 240, 115, 210, 130));
        roadPieces.put("1, 2, 12, 2, 12, 13", new Line(0, 240, 115, 270, 130));
        roadPieces.put("2, 3, 13, 2, 12, 13", new Line(0, 300, 115, 270, 130));
        roadPieces.put("2, 3, 13, 3, 13, 14", new Line(0, 300, 115, 330, 130));

        roadPieces.put("0, 10, 11, 10, 11, 21",
                new Line(0, 150, 130, 150, 160));
        roadPieces.put("1, 11, 12, 11, 12, 22",
                new Line(0, 210, 130, 210, 160));
        roadPieces.put("2, 12, 13, 12, 13, 23",
                new Line(0, 270, 130, 270, 160));
        roadPieces.put("3, 13, 14, 13, 14, 24",
                new Line(0, 330, 130, 330, 160));

        roadPieces.put("10, 11, 21, 10, 20, 21",
                new Line(0, 120,  175, 150, 160));
        roadPieces.put("10, 11, 21, 11, 21, 22",
                new Line(0, 150, 160, 180, 175));
        roadPieces.put("11, 12, 22, 11, 21, 22",
                new Line(0, 180, 175, 210, 160));
        roadPieces.put("11, 12, 22, 12, 22, 23",
                new Line(0, 210, 160, 240, 175));
        roadPieces.put("12, 13, 23, 12, 22, 23",
                new Line(0, 240, 175, 270, 160));
        roadPieces.put("12, 13, 23, 13, 23, 24",
                new Line(0, 270, 160, 300, 175));
        roadPieces.put("13, 14, 24, 13, 23, 24",
                new Line(0, 300, 175, 330, 160));
        roadPieces.put("13, 14, 24, 14, 24, 25",
                new Line(0, 330, 160, 360, 175));

        roadPieces.put("10, 20, 21, 20, 21, 31",
                new Line(0, 120, 175, 120, 205));
        roadPieces.put("11, 21, 22, 21, 22, 32",
                new Line(0, 180, 175, 180, 205));
        roadPieces.put("12, 22, 23, 22, 23, 33",
                new Line(0, 240, 175, 240, 205));
        roadPieces.put("13, 23, 24, 23, 24, 34",
                new Line(0, 300, 175, 300, 205));
        roadPieces.put("14, 24, 25, 24, 25, 35",
                new Line(0, 360, 175, 360, 205));

        roadPieces.put("20, 21, 31, 20, 30, 31",
                new Line(0, 90,  220, 120, 205));
        roadPieces.put("20, 21, 31, 21, 31, 32",
                new Line(0, 120, 205, 150, 220));
        roadPieces.put("21, 22, 32, 21, 31, 32",
                new Line(0, 150, 220, 180, 205));
        roadPieces.put("21, 22, 32, 22, 32, 33",
                new Line(0, 180, 205, 210, 220));
        roadPieces.put("22, 23, 33, 22, 32, 33",
                new Line(0, 210, 220, 240, 205));
        roadPieces.put("22, 23, 33, 23, 33, 34",
                new Line(0, 240, 205, 270, 220));
        roadPieces.put("23, 24, 34, 23, 33, 34",
                new Line(0, 270, 220, 300, 205));
        roadPieces.put("23, 24, 34, 24, 34, 35",
                new Line(0, 300, 205, 330, 220));
        roadPieces.put("24, 25, 35, 24, 34, 35",
                new Line(0, 330, 220, 360, 205));
        roadPieces.put("24, 25, 35, 25, 35, 36",
                new Line(0, 360, 205, 390, 220));

        roadPieces.put("20, 30, 31, 30, 31, 40",
                new Line(0, 90, 220, 90, 250));
        roadPieces.put("21, 31, 32, 31, 32, 41",
                new Line(0, 150, 220, 150, 250));
        roadPieces.put("22, 32, 33, 32, 33, 42",
                new Line(0, 210, 220, 210, 250));
        roadPieces.put("23, 33, 34, 33, 34, 43",
                new Line(0, 270, 220, 270, 250));
        roadPieces.put("24, 34, 35, 34, 35, 44",
                new Line(0, 330, 220, 330, 250));
        roadPieces.put("25, 35, 36, 35, 36, 45",
                new Line(0, 390, 220, 390, 250));

        roadPieces.put("30, 31, 40, 31, 40, 41",
                new Line(0, 90,  250, 120, 265));
        roadPieces.put("31, 32, 41, 31, 40, 41",
                new Line(0, 120, 265, 150, 250));
        roadPieces.put("31, 32, 41, 32, 41, 42",
                new Line(0, 150, 250, 180, 265));
        roadPieces.put("32, 33, 42, 32, 41, 42",
                new Line(0, 180, 265, 210, 250));
        roadPieces.put("32, 33, 42, 33, 42, 43",
                new Line(0, 210, 250, 240, 265));
        roadPieces.put("33, 34, 43, 33, 42, 43",
                new Line(0, 240, 265, 270, 250));
        roadPieces.put("33, 34, 43, 34, 43, 44",
                new Line(0, 270, 250, 300, 265));
        roadPieces.put("34, 35, 44, 34, 43, 44",
                new Line(0, 300, 265, 330, 250));
        roadPieces.put("34, 35, 44, 35, 44, 45",
                new Line(0, 330, 250, 360, 265));
        roadPieces.put("35, 36, 45, 35, 44, 45",
                new Line(0, 360, 265, 390, 250));

        roadPieces.put("31, 40, 41, 40, 41, 50",
                new Line(0, 120, 265, 120, 295));
        roadPieces.put("32, 41, 42, 41, 42, 51",
                new Line(0, 180, 265, 180, 295));
        roadPieces.put("33, 42, 43, 42, 43, 52",
                new Line(0, 240, 265, 240, 295));
        roadPieces.put("34, 43, 44, 43, 44, 53",
                new Line(0, 300, 265, 300, 295));
        roadPieces.put("35, 44, 45, 44, 45, 54",
                new Line(0, 360, 265, 360, 295));

        roadPieces.put("40, 41, 50, 41, 50, 51",
                new Line(0, 120,  295, 150, 310));
        roadPieces.put("41, 42, 51, 41, 50, 51",
                new Line(0, 150, 310, 180, 295));
        roadPieces.put("41, 42, 51, 42, 51, 52",
                new Line(0, 180, 295, 210, 310));
        roadPieces.put("42, 43, 52, 42, 51, 52",
                new Line(0, 210, 310, 240, 295));
        roadPieces.put("42, 43, 52, 43, 52, 53",
                new Line(0, 240, 295, 270, 310));
        roadPieces.put("43, 44, 53, 43, 52, 53",
                new Line(0, 270, 310, 300, 295));
        roadPieces.put("43, 44, 53, 44, 53, 54",
                new Line(0, 300, 295, 330, 310));
        roadPieces.put("44, 45, 54, 44, 53, 54",
                new Line(0, 330, 310, 360, 295));

        roadPieces.put("41, 50, 51, 50, 51, 60",
                new Line(0, 150, 310, 150, 340));
        roadPieces.put("42, 51, 52, 51, 52, 61",
                new Line(0, 210, 310, 210, 340));
        roadPieces.put("43, 52, 53, 52, 53, 62",
                new Line(0, 270, 310, 270, 340));
        roadPieces.put("44, 53, 54, 53, 54, 63",
                new Line(0, 330, 310, 330, 340));

        roadPieces.put("50, 51, 60, 51, 60, 61",
                new Line(0, 180,  355, 150, 340));
        roadPieces.put("51, 52, 61, 51, 60, 61",
                new Line(0, 180, 355, 210, 340));
        roadPieces.put("51, 52, 61, 52, 61, 62",
                new Line(0, 240, 355, 210, 340));
        roadPieces.put("52, 53, 62, 52, 61, 62",
                new Line(0, 240, 355, 270, 340));
        roadPieces.put("52, 53, 62, 53, 62, 63",
                new Line(0, 300, 355, 270, 340));
        roadPieces.put("53, 54, 63, 53, 62, 63",
                new Line(0, 300, 355, 330, 340));
    }

    private void setupDefaultSettlements() {
        settlementPieces.put("0, 1, 11", new Circle(0, 180, 100));
        settlementPieces.put("1, 2, 12", new Circle(0, 240, 100));
        settlementPieces.put("2, 3, 13", new Circle(0, 300, 100));

        settlementPieces.put("0, 10, 11", new Circle(0, 150, 115));
        settlementPieces.put("1, 11, 12", new Circle(0, 210, 115));
        settlementPieces.put("2, 12, 13", new Circle(0, 270, 115));
        settlementPieces.put("3, 13, 14", new Circle(0, 330, 115));

        settlementPieces.put("10, 11, 21", new Circle(0, 150, 145));
        settlementPieces.put("11, 12, 22", new Circle(0, 210, 145));
        settlementPieces.put("12, 13, 23", new Circle(0, 270, 145));
        settlementPieces.put("13, 14, 24", new Circle(0, 330, 145));

        settlementPieces.put("10, 20, 21", new Circle(0, 120, 160));
        settlementPieces.put("11, 21, 22", new Circle(0, 180, 160));
        settlementPieces.put("12, 22, 23", new Circle(0, 240, 160));
        settlementPieces.put("13, 23, 24", new Circle(0, 300, 160));
        settlementPieces.put("14, 24, 25", new Circle(0, 360, 160));

        settlementPieces.put("20, 21, 31", new Circle(0, 120, 190));
        settlementPieces.put("21, 22, 32", new Circle(0, 180, 190));
        settlementPieces.put("22, 23, 33", new Circle(0, 240, 190));
        settlementPieces.put("23, 24, 34", new Circle(0, 300, 190));
        settlementPieces.put("24, 25, 35", new Circle(0, 360, 190));

        settlementPieces.put("20, 30, 31", new Circle(0, 90,  205));
        settlementPieces.put("21, 31, 32", new Circle(0, 150, 205));
        settlementPieces.put("22, 32, 33", new Circle(0, 210, 205));
        settlementPieces.put("23, 33, 34", new Circle(0, 270, 205));
        settlementPieces.put("24, 34, 35", new Circle(0, 330, 205));
        settlementPieces.put("25, 35, 36", new Circle(0, 390, 205));

        settlementPieces.put("30, 31, 40", new Circle(0, 90,  235));
        settlementPieces.put("31, 32, 41", new Circle(0, 150, 235));
        settlementPieces.put("32, 33, 42", new Circle(0, 210, 235));
        settlementPieces.put("33, 34, 43", new Circle(0, 270, 235));
        settlementPieces.put("34, 35, 44", new Circle(0, 330, 235));
        settlementPieces.put("35, 36, 45", new Circle(0, 390, 235));

        settlementPieces.put("31, 40, 41", new Circle(0, 120, 250));
        settlementPieces.put("32, 41, 42", new Circle(0, 180, 250));
        settlementPieces.put("33, 42, 43", new Circle(0, 240, 250));
        settlementPieces.put("34, 43, 44", new Circle(0, 300, 250));
        settlementPieces.put("35, 44, 45", new Circle(0, 360, 250));

        settlementPieces.put("40, 41, 50", new Circle(0, 120, 280));
        settlementPieces.put("41, 42, 51", new Circle(0, 180, 280));
        settlementPieces.put("42, 43, 52", new Circle(0, 240, 280));
        settlementPieces.put("43, 44, 53", new Circle(0, 300, 280));
        settlementPieces.put("44, 45, 54", new Circle(0, 360, 280));

        settlementPieces.put("41, 50, 51", new Circle(0, 150, 295));
        settlementPieces.put("42, 51, 52", new Circle(0, 210, 295));
        settlementPieces.put("43, 52, 53", new Circle(0, 270, 295));
        settlementPieces.put("44, 53, 54", new Circle(0, 330, 295));

        settlementPieces.put("50, 51, 60", new Circle(0, 150, 325));
        settlementPieces.put("51, 52, 61", new Circle(0, 210, 325));
        settlementPieces.put("52, 53, 62", new Circle(0, 270, 325));
        settlementPieces.put("53, 54, 63", new Circle(0, 330, 325));

        settlementPieces.put("51, 60, 61", new Circle(0, 180, 340));
        settlementPieces.put("52, 61, 62", new Circle(0, 240, 340));
        settlementPieces.put("53, 62, 63", new Circle(0, 300, 340));
    }

    private void setupDefaultTiles() {
        int rowOneStart = 150;
        int rowTwoStart = 120;
        int rowThreeStart = 90;
        int rowFourStart = 60;

        int terrainRowHeight = 100;
        for (int i = 0; i < 4; i++) {
            terrainPieces.put(i, new Hexagon(Color.CYAN,
                    rowOneStart + (i * 60), terrainRowHeight, i));
        }
        terrainRowHeight = 145;
        terrainPieces.put(10, new Hexagon(Color.CYAN,
                rowTwoStart, terrainRowHeight, 11));
        terrainPieces.put(14, new Hexagon(Color.CYAN,
                rowTwoStart + 240, terrainRowHeight, 14));
        for (int i = 11; i < 14; i++) {
            terrainPieces.put(i, new Hexagon(Color.GREEN,
                    rowTwoStart + ((i - 10) * 60), terrainRowHeight, i));
        }
        terrainRowHeight = 190;
        terrainPieces.put(20, new Hexagon(Color.CYAN,
                rowThreeStart, terrainRowHeight, 20));
        terrainPieces.put(25, new Hexagon(Color.CYAN,
                rowThreeStart + 300, terrainRowHeight, 25));
        for (int i = 21; i < 25; i++) {
            terrainPieces.put(i, new Hexagon(Color.GREEN,
                    rowThreeStart + ((i - 20) * 60), terrainRowHeight, i));
        }
        terrainRowHeight = 235;
        terrainPieces.put(30, new Hexagon(Color.CYAN,
                rowFourStart, terrainRowHeight, 30));
        terrainPieces.put(36, new Hexagon(Color.CYAN,
                rowFourStart + 360, terrainRowHeight, 36));
        for (int i = 31; i < 36; i++) {
            terrainPieces.put(i, new Hexagon(Color.GREEN,
                    rowFourStart + ((i - 30) * 60), terrainRowHeight, i));
        }
        terrainRowHeight = 280;
        terrainPieces.put(40, new Hexagon(Color.CYAN,
                rowThreeStart, terrainRowHeight, 40));
        terrainPieces.put(45, new Hexagon(Color.CYAN,
                rowThreeStart + 300, terrainRowHeight, 45));
        for (int i = 41; i < 45; i++) {
            terrainPieces.put(i, new Hexagon(Color.GREEN,
                    rowThreeStart + ((i - 40) * 60), terrainRowHeight, i));
        }
        terrainRowHeight = 325;
        terrainPieces.put(50, new Hexagon(Color.CYAN,
                rowTwoStart, terrainRowHeight, 50));
        terrainPieces.put(54, new Hexagon(Color.CYAN,
                rowTwoStart + 240, terrainRowHeight, 54));
        for (int i = 51; i < 54; i++) {
            terrainPieces.put(i, new Hexagon(Color.GREEN,
                    rowTwoStart + ((i - 50) * 60), terrainRowHeight, i));
        }
        terrainRowHeight = 370;
        for (int i = 60; i < 64; i++) {
            terrainPieces.put(i, new Hexagon(Color.CYAN,
                    rowOneStart + ((i - 60) * 60), terrainRowHeight, i));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Welcome To Catan: Some Buttons"
                + " might load unless you change screen size", 10, 10);
        g.setColor(Color.BLACK);
        for (Map.Entry<Integer, Hexagon> entry: terrainPieces.entrySet()) {
            int x = terrainPieces.get(entry.getKey()).getxPos();
            int y = terrainPieces.get(entry.getKey()).getyPos();
            String rollNum = terrainPieces.get(entry.getKey()).getRollNum();
            Polygon toDraw = terrainPieces.get(entry.getKey()).getHexTile();
            Color tileColor = terrainPieces.get(entry.getKey()).getColor();
            g.setColor(tileColor);
            g.fillPolygon(toDraw);
            g.setColor(Color.black);
            g.drawString(rollNum, x, y);
        }
        for (Map.Entry<String, Line> entry: roadPieces.entrySet()) {
            List<Integer> coord =
                    roadPieces.get(entry.getKey()).getCoordinates();
            Color roadColor = roadPieces.get(entry.getKey()).getColor();
            g.setColor(roadColor);
            Graphics2D g2d = (Graphics2D) g;
            float thickness = 3.0f;
            g2d.setStroke(new BasicStroke(thickness));
            g.drawLine(coord.get(0), coord.get(1), coord.get(2), coord.get(3));

        }
        for (Map.Entry<String, Circle> entry: settlementPieces.entrySet()) {
            Color circleColor = settlementPieces.get(entry.getKey()).getColor();
            g.setColor(circleColor);
            Graphics2D g2 = (Graphics2D) g;
            g2.fill(entry.getValue().getEllipse());
        }
        drawBank(g);
        drawPlayerHands(g);
        g.setColor(Color.BLACK);
        g.drawString("Turn of Player Number : " + this.currentTurn, 500, 270);
        g.drawString("Current Turn Phase: " + this.phase, 500, 300);
    }

    private void drawPlayerHands(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(playerHandInfo, 50, 500);
    }

    private void drawBank(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("The Bank", 565, 70);
        g.drawRect(bankInfo.getxPos(), bankInfo.getyPos(), 120, 180);
        g.drawString("Wool: " + bankInfo.getQuantity("Wool"), 575, 130);
        g.drawString("Ore: " + bankInfo.getQuantity("Ore"), 575, 150);
        g.drawString("Wheat: " + bankInfo.getQuantity("Wheat"), 575, 170);
        g.drawString("Brick: " + bankInfo.getQuantity("Brick"), 575, 190);
        g.drawString("Lumber: " + bankInfo.getQuantity("Lumber"), 575, 110);
        g.drawString("Dev Cards: " + bankInfo.
                getQuantity("DevCards"), 575, 210);
    }

    public void updateBankAmount(String updateInfo, String devCardInfo) {
        for (int i = 0; i < 5; i++) {
            String resource = updateInfo.substring(0, updateInfo.indexOf(","));
            String amount = updateInfo.substring(
                    updateInfo.indexOf(",") + 1, updateInfo.indexOf("~"));
            bankInfo.updateQuantity(resource, amount);
            updateInfo = updateInfo.substring(updateInfo.indexOf("~") + 1);
        }
        bankInfo.updateQuantity("DevCards", devCardInfo);
    }

    public void updateTerrains(String terrainInfo) {
        for (int i = 0; i < 4; i++) {
            String locID = terrainInfo.substring(0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String terrainType =
                    terrainInfo.substring(0, terrainInfo.indexOf(" "));
            terrainInfo =
                    terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String hasRobber =
                    terrainInfo.substring(0, terrainInfo.indexOf(" "));
            terrainInfo =
                    terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String rollNumber =
                    terrainInfo.substring(0, terrainInfo.indexOf("~"));
            terrainInfo =
                    terrainInfo.substring(terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            if (rollNumber.equals("0")) {
                terrainPieces.get(key).setRollNumber("");
                terrainPieces.get(Integer.parseInt(locID)).setColor(Color.CYAN);
            } else {
                terrainPieces.get(Integer.parseInt(locID)).setRobber(hasRobber);
            }
        }
        for (int i = 10; i < 15; i++) {
            String locID = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String terrainType = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String hasRobber = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String rollNumber = terrainInfo.substring(
                    0, terrainInfo.indexOf("~"));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            if (i == 10 || i == 14) {
                terrainPieces.get(key).setRollNumber("");
                terrainPieces.get(key).setColor(Color.CYAN);
            } else {
                terrainPieces.get(key).setRobber(hasRobber);
                terrainPieces.get(key).setRollNumber(rollNumber);
                terrainPieces.get(key).setColorBasedOnTerrain(terrainType);
            }
        }
        for (int i = 20; i < 26; i++) {
            String locID = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String terrainType = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String hasRobber = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String rollNumber = terrainInfo.substring(
                    0, terrainInfo.indexOf("~"));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            if (i == 20 || i == 25) {
                terrainPieces.get(key).setRollNumber("");
                terrainPieces.get(key).setColor(Color.CYAN);
            } else {
                terrainPieces.get(key).setRobber(hasRobber);
                terrainPieces.get(key).setRollNumber(rollNumber);
                terrainPieces.get(key).setColorBasedOnTerrain(terrainType);
            }
        }
        for (int i = 30; i < 37; i++) {
            String locID = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String terrainType = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String hasRobber = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String rollNumber = terrainInfo.substring(
                    0, terrainInfo.indexOf("~"));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            if (i == 30 || i == 36) {
                terrainPieces.get(key).setColor(Color.CYAN);
                terrainPieces.get(key).setRollNumber("");
            } else {
                terrainPieces.get(key).setRobber(hasRobber);
                terrainPieces.get(key).setRollNumber(rollNumber);
                terrainPieces.get(key).setColorBasedOnTerrain(terrainType);
            }
        }
        for (int i = 40; i < 46; i++) {
            String locID = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String terrainType = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String hasRobber = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String rollNumber = terrainInfo.substring(
                    0, terrainInfo.indexOf("~"));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            if (i == 40 || i == 45) {
                terrainPieces.get(key).setColor(Color.CYAN);
                terrainPieces.get(key).setRollNumber("");
            } else {
                terrainPieces.get(key).setRobber(hasRobber);
                terrainPieces.get(key).setRollNumber(rollNumber);
                terrainPieces.get(key).setColorBasedOnTerrain(terrainType);
            }
        }
        for (int i = 50; i < 55; i++) {
            String locID = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(
                    terrainInfo.indexOf(" ") + 1);
            String terrainType = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String hasRobber = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String rollNumber = terrainInfo.substring(
                    0, terrainInfo.indexOf("~"));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            if (i == 50 || i == 54) {
                terrainPieces.get(key).setColor(Color.CYAN);
                terrainPieces.get(key).setRollNumber("");
            } else {
                terrainPieces.get(key).setRobber(hasRobber);
                terrainPieces.get(key).setRollNumber(rollNumber);
                terrainPieces.get(key).setColorBasedOnTerrain(terrainType);
            }
        }
        for (int i = 60; i < 64; i++) {
            String locID = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String terrainType = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String hasRobber = terrainInfo.substring(
                    0, terrainInfo.indexOf(" "));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf(" ") + 1);
            String rollNumber = terrainInfo.substring(
                    0, terrainInfo.indexOf("~"));
            terrainInfo = terrainInfo.substring(terrainInfo.indexOf("~") + 1);
            int key = Integer.parseInt(locID);
            terrainPieces.get(key).setColor(Color.CYAN);
            terrainPieces.get(key).setRollNumber("");
        }
    }

    public void updateTurn(String turn) {
        int correctTurn = Integer.parseInt(turn) + 1;
        this.currentTurn = correctTurn + "";
    }

    public int updateTurnPhase(String phase) {
        String phaseNum = phase.substring(0, 1);
//        String phaseSetUp = phase.substring(2);
        System.out.println("Phase: " + phase + "\n");
        if (phaseNum.equals("0")) {
            if (phase.substring(1).equals(" false")) {
                this.phase = "Roll";
                return 0;
            } else {
                this.phase = "Place Settlement";
                return 0;
            }
        } else if (phaseNum.equals("1")) {
            if (phase.substring(1).equals(" false")) {
                this.phase = "Trade";
                return 1;
            } else {
                this.phase = "Place Road";
                return 1;
            }
        } else if (phaseNum.equals("2")) {
            if (phase.substring(1).equals(" false")) {
                this.phase = "Build";
                return 2;
            } else {
                this.phase = "Place Second Settlement";
                return 2;
            }
        } else {
            this.phase = "Place Second Road";
            return 3;
        }
    }

    public void updatePlayerHands(String hands, String devCards) {
        int index = devCards.indexOf("~");
        int playerNum = 1;
        while (index != -1) {
            devCards = devCards.substring(0, index)
                    + " || Hand of Player" + playerNum
                    + ": " + devCards.substring(index + 1);
            index = devCards.indexOf("~");
            playerNum++;
        }
        playerHandInfo = devCards;
    }

    public void makeSettlementsClickable(Map<String, JButton> buttons) {
        System.out.println("Make settlements clickable");
        this.setLayout(null);
        for (Map.Entry<String, JButton> entry : buttons.entrySet()) {
            add(entry.getValue());
        }
    }


    public Map<String, Circle> getCircles() {
        return Map.copyOf(settlementPieces);
    }

    public Map<String, Line> getLines() {
        return Map.copyOf(roadPieces);
    }

    public void makeRoadsClickable(Map<String, JButton> roadListeners) {
        System.out.println("Make roads clickable");
        this.setLayout(null);
        for (Map.Entry<String, JButton> entry : roadListeners.entrySet()) {
            add(entry.getValue());
        }
    }
}