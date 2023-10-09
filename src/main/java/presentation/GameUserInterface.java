package presentation;


import domain.GameController.GameController;
import presentation.PieceData.Circle;
import presentation.PieceData.Line;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUserInterface extends JFrame implements UserInterface {
    public JPanel languageOptions;
    public JLabel languageOptionsText;
    public JButton english;
    public JButton spanish;
    public GameController game;
    public ResourceBundle rb;
    private GamePanel gamePanel;
    private JButton placeSettlementButton;
    private JButton placeRoadButton;
    private JButton rollDieButton;
    private JButton endTurnButton;
    private JButton lastRolledDie;
    private JButton buySettlementButton;
    private JButton buyRoadButton;
    private JButton buyCityButton;
    private JButton buyDevelopmentCarButton;
    private JButton tradeDomesticTradeButton;
    private JButton tradeMaritimeTradeButton;
    private JButton playDevelopmentCardButton;
    private Map<String, JButton> settlementListeners;
    private Map<String, JButton> roadListeners;
    private int roll;


    public GameUserInterface() {
        gamePanel = new GamePanel();
        english = new JButton("English");
        spanish = new JButton("Espa" + Character.toString(241) + "ol");
        languageOptions = new LanguagePanel(english, spanish);
        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rb = ResourceBundle.getBundle("messages", Locale.ENGLISH);
                createGamePanel();
            }
        });

        spanish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rb = ResourceBundle.getBundle("messages",
                        new Locale("ES", "US"));
                createGamePanel();
            }
        });
        setLayout(new FlowLayout());

        add(languageOptions);

        this.pack();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game = new GameController(this, 4);
    }
    public void createGamePanel() {
        this.setSize(1400, 800);
        remove(languageOptions);
        gamePanel = new GamePanel();
        initializeButtons();
        game.sendState();
        game.sendState();
        // ALL INTERACTABLE COMPONENTS GO HERE
        //    JLabel lumber = new JLabel(rb.getString("lumber"));
        //    gamePanel.add(lumber);
        getContentPane().add(gamePanel);
        roll = 0;
    }

    @Override
    public void update(Map<String, String> state) {
        remove(gamePanel);

        System.out.println("updating");
        takeDownButtons();
        initializeButtons();
        gamePanel.updatePlayerHands(state.get("Hands"), state.get("DevCards"));
        gamePanel.updateBankAmount(state.get("Bank"), state.get("DevCardDeck"));
        gamePanel.updateTerrains(state.get("Terrains"));
        gamePanel.updateTurn(state.get("Turn"));
        int currentPhase = gamePanel.updateTurnPhase(state.get("Phase"));
        determineCurrentPhase(currentPhase);
        gamePanel.revalidate();
        gamePanel.repaint();

        add(gamePanel);
        this.revalidate();
        this.repaint();
    }

    private void takeDownButtons() {
        remove(rollDieButton);
        remove(placeSettlementButton);
        remove(endTurnButton);
        remove(placeRoadButton);
        this.remove(buyRoadButton);
        this.remove(buySettlementButton);
        this.remove(buyCityButton);
        this.remove(buyDevelopmentCarButton);
        this.remove(tradeDomesticTradeButton);
        this.remove(tradeMaritimeTradeButton);
        remove(playDevelopmentCardButton);
        remove(lastRolledDie);
    }

    private void initializeButtons() {
        rollDieButton = new JButton("Roll Dice");
        placeSettlementButton = new JButton("Place a Settlement");
        placeRoadButton = new JButton("Place a Road");
        endTurnButton = new JButton("End Turn");
        lastRolledDie = new JButton("Last Rolled Die: ");
        buyRoadButton = new JButton("Buy A Road");
        buySettlementButton = new JButton("Buy A Settlement");
        buyCityButton = new JButton("Buy A City");
        buyDevelopmentCarButton = new JButton("Buy a Resource Card");
        tradeDomesticTradeButton = new JButton("Domestic Trade");
        tradeMaritimeTradeButton = new JButton("Maritime Trade");
        playDevelopmentCardButton = new JButton("Play Development Card");

        this.add(rollDieButton);
        this.add(placeSettlementButton);
        this.add(placeRoadButton);
        this.add(endTurnButton);
        this.add(buyRoadButton);
        this.add(buySettlementButton);
        this.add(buyCityButton);
        this.add(buyDevelopmentCarButton);
        this.add(tradeDomesticTradeButton);
        this.add(tradeMaritimeTradeButton);
        this.add(playDevelopmentCardButton);
        this.add(lastRolledDie);
    }
    private void determineCurrentPhase(int currentPhase) {
        if (currentPhase == 0) {
            if (game.checkSetup()) {
                // gamePanel.updateTurnPhase("10");
                // setUpSettlementPhase();
                setUpTradeBuildPhase();
            } else {
                setUpRollPhase();
            }
        } else if (currentPhase == 1) {
            if (game.checkSetup()) {
                setUpRoadPhase();
            } else {
                setUpTradeBuildPhase();
            }
        } else if (currentPhase == 2) {
            if (game.checkSetup()) {
                setUpSettlementPhase();
            } else {
                setUpTradeBuildPhase();
            }
        } else if (currentPhase == 3) {
            setUpRoadPhase();
        } else {
            System.out.println("Not implemented: phase " + currentPhase);
        }
    }

    private void setUpRoadPhase() {
        removeButtonActionListeners();
        System.out.println("Now in setup phase for Road");
        ActionListener illegalClick = e -> System.out.println(
                "Not allowed during setup phase for Road");
        placeSettlementButton.addActionListener(illegalClick);
        endTurnButton.addActionListener(illegalClick);
        buyCityButton.addActionListener(illegalClick);
        buyRoadButton.addActionListener(illegalClick);
        buyDevelopmentCarButton.addActionListener(illegalClick);
        buySettlementButton.addActionListener(illegalClick);
        tradeDomesticTradeButton.addActionListener(illegalClick);
        tradeMaritimeTradeButton.addActionListener(illegalClick);
        playDevelopmentCardButton.addActionListener(illegalClick);
        ActionListener placeRoad = e -> placeRoadOnClick(e);
        placeRoadButton.addActionListener(placeRoad);
        this.revalidate();
    }

    private void setUpSettlementPhase() {
        removeButtonActionListeners();
        System.out.println("Now in setup phase for Settlement");
        ActionListener illegalClick = e -> System.out.println(
                "Not allowed during setup phase for Settlement");
        placeRoadButton.addActionListener(illegalClick);
        endTurnButton.addActionListener(illegalClick);
        buyCityButton.addActionListener(illegalClick);
        buyRoadButton.addActionListener(illegalClick);
        buyDevelopmentCarButton.addActionListener(illegalClick);
        buySettlementButton.addActionListener(illegalClick);
        tradeDomesticTradeButton.addActionListener(illegalClick);
        tradeMaritimeTradeButton.addActionListener(illegalClick);
        playDevelopmentCardButton.addActionListener(illegalClick);
        ActionListener placeSettlement = e -> placeSettlementOnClick(e);
        placeSettlementButton.addActionListener(placeSettlement);
        this.revalidate();
    }
    private void setUpRollPhase() {
        removeButtonActionListeners();
        System.out.println("Now in roll phase");
        ActionListener illegalClick = e -> System.out.println(
                "Not allowed during roll phase");
        placeSettlementButton.addActionListener(illegalClick);
        placeRoadButton.addActionListener(illegalClick);
        endTurnButton.addActionListener(illegalClick);
        buyCityButton.addActionListener(illegalClick);
        buyRoadButton.addActionListener(illegalClick);
        buyDevelopmentCarButton.addActionListener(illegalClick);
        buySettlementButton.addActionListener(illegalClick);
        tradeDomesticTradeButton.addActionListener(illegalClick);
        tradeMaritimeTradeButton.addActionListener(illegalClick);
        rollDieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roll = game.rollDice();
                lastRolledDie.setText("Rolled a " + roll);
                game.nextPhase();
                game.sendState();
                revalidate();

            }
        });
    }
    private void setUpTradeBuildPhase() {
        removeButtonActionListeners();
        lastRolledDie.setText("Rolled a " + roll);
        System.out.println("Now in build/trade phase");
        ActionListener illegalClick = e -> System.out.println(
                "Not allowed during roll phase");
        placeSettlementButton.addActionListener(illegalClick);
        placeRoadButton.addActionListener(illegalClick);
        rollDieButton.addActionListener(illegalClick);
        buyCityButton.addActionListener(illegalClick);
        buyRoadButton.addActionListener(illegalClick);
        buyDevelopmentCarButton.addActionListener(illegalClick);
        buySettlementButton.addActionListener(illegalClick);

        // setUpPlacePieceListeners();
        // setupBuyButtonListeners();
        setupTradeButtonListeners();
        // setUpDevelopmentCardListeners();

        ActionListener endThisPlayersTurn = e -> endTurnAndStartNewPlayerTurn();
        endTurnButton.addActionListener(endThisPlayersTurn);
    }

    private void setUpPlacePieceListeners() {
        ActionListener illegalClick = e -> System.out.println(
                "Not allowed during trade/build phase");
        rollDieButton.addActionListener(illegalClick);
        ActionListener placeSettlement = e -> placeSettlementOnClick(e);
        placeSettlementButton.addActionListener(placeSettlement);
        ActionListener placeRoad = e -> placeRoadOnClick(e);
        placeRoadButton.addActionListener(placeRoad);
    }

    private void setupBuyButtonListeners() {
        List<String> buyable = game.getBuyableItems(game.getCurrentPlayer());

        if (buyable.contains("Road")) {
            ActionListener buyroad = e -> {
                System.out.println("TODO: buy road"); };
            buyRoadButton.addActionListener(buyroad);
        }

        if (buyable.contains("Settlement")) {
            ActionListener buySettlement = e -> {
                System.out.println("TODO: buy settlement"); };
            buySettlementButton.addActionListener(buySettlement);
        }

        if (buyable.contains("City")) {
            ActionListener buyCity = e -> {
                System.out.println("TODO: buy city"); };
            buyCityButton.addActionListener(buyCity);
        }

        if (buyable.contains("Development Card")) {
            ActionListener buyDevelopmentCard = e -> {
                System.out.println("TODO: buy development card"); };
            buyDevelopmentCarButton.addActionListener(buyDevelopmentCard);
        }
    }

    private void setupTradeButtonListeners() {
        ActionListener openDomesticTradeMenu = e -> {
            System.out.println("Opening Domestic Trade Menu");
            setUpDomesticTradeListener();
            this.revalidate();
        };
        tradeDomesticTradeButton.addActionListener(openDomesticTradeMenu);

        ActionListener openMaritimeTradeField = e -> {
            System.out.println("Opening Maritime Trade Menu");
            setUpMaritimeTradeListener();
            this.revalidate();
        };
        tradeMaritimeTradeButton.addActionListener(openMaritimeTradeField);


    }

    private void setUpMaritimeTradeListener() {
        JPanel maritimeTradePanel = new JPanel();
        maritimeTradePanel.setLayout(
                new BoxLayout(maritimeTradePanel, BoxLayout.Y_AXIS));
        JLabel enterDomesticTradeTitle = new JLabel(
                "You have selected to maritime trade");
        String lumberMaritimeQuantity = "3";
        String brickMaritimeQuantity = "3";
        String woolMaritimeQuantity = "3";
        String wheatMaritimeQuantity = "3";
        String oreMaritimeQuantity = "3";
        JButton lumberOffer = new JButton(
                "You will recieve 1 lumber for: "
                        + lumberMaritimeQuantity + " resources");
        JButton brickOffer = new JButton(
                "You will recieve 1 brick for: "
                        + brickMaritimeQuantity + " resources");
        JButton woolOffer = new JButton(
                "You will recieve 1 wool for: "
                        + woolMaritimeQuantity + " resources");
        JButton wheatOffer = new JButton(
                "You will recieve 1 wheat for: "
                        + wheatMaritimeQuantity + " resources");
        JButton oreOffer = new JButton(
                "You will recieve 1 ore for: "
                        + oreMaritimeQuantity + " resources");

        ActionListener takeLumberOffer = e -> {
            System.out.println("Lumber 1;" + lumberMaritimeQuantity);
            remove(maritimeTradePanel);
            this.revalidate();
        };
        lumberOffer.addActionListener(takeLumberOffer);
        ActionListener takeBrickOffer = e -> {
            System.out.println("Brick 1;" + brickMaritimeQuantity);
            remove(maritimeTradePanel);
            this.revalidate();
        };
        lumberOffer.addActionListener(takeBrickOffer);
        ActionListener takeWoolOffer = e -> {
            System.out.println("Wool 1;" + woolMaritimeQuantity);
            remove(maritimeTradePanel);
            this.revalidate();
        };
        lumberOffer.addActionListener(takeWoolOffer);
        ActionListener takeWheatOffer = e -> {
            System.out.println("Wheat 1;" + wheatMaritimeQuantity);
            remove(maritimeTradePanel);
            this.revalidate();
        };
        lumberOffer.addActionListener(takeWheatOffer);
        ActionListener takeOreOffer = e -> {
            System.out.println("Ore 1;" + oreMaritimeQuantity);
            remove(maritimeTradePanel);
            this.revalidate();
        };
        lumberOffer.addActionListener(takeOreOffer);

        maritimeTradePanel.add(enterDomesticTradeTitle);
        maritimeTradePanel.add(lumberOffer);
        maritimeTradePanel.add(brickOffer);
        maritimeTradePanel.add(woolOffer);
        maritimeTradePanel.add(wheatOffer);
        maritimeTradePanel.add(oreOffer);
        add(maritimeTradePanel);
        this.revalidate();
    }

    private void setUpDomesticTradeListener() {
        JPanel domesticTradePanel = new JPanel();
        domesticTradePanel.setLayout(
                new BoxLayout(domesticTradePanel, BoxLayout.Y_AXIS));
        JLabel enterDomesticTradeTitle = new JLabel(
                "You have selected to domestic trade");
        JLabel youGetLabel = new JLabel("You will recieve: ");
        JLabel lumber = new JLabel("Lumber");
        JTextField lumberAmount = new JTextField("0");
        JLabel brick = new JLabel("Brick");
        JTextField brickAmount = new JTextField("0");
        JLabel wool = new JLabel("Wool");
        JTextField woolAmount = new JTextField("0");
        JLabel wheat = new JLabel("Wheat");
        JTextField wheatAmount = new JTextField("0");
        JLabel ore = new JLabel("Ore");
        JTextField oreAmount = new JTextField("0");

        JLabel theyGetLabel = new JLabel("They will recieve: ");
        JLabel lumber2 = new JLabel("Lumber");
        JTextField lumberAmount2 = new JTextField("0");
        JLabel brick2 = new JLabel("Brick");
        JTextField brickAmount2 = new JTextField("0");
        JLabel wool2 = new JLabel("Wool");
        JTextField woolAmount2 = new JTextField("0");
        JLabel wheat2 = new JLabel("Wheat");
        JTextField wheatAmount2 = new JTextField("0");
        JLabel ore2 = new JLabel("Ore");
        JTextField oreAmount2 = new JTextField("0");
        JButton submitDomTrade = new JButton("Submit Trade Offer");
        ActionListener submitTrade = e -> {
            String tradeOffer = "";
            tradeOffer += "~Lumber " + lumberAmount.getText().toString();
            tradeOffer += "~Brick " + brickAmount.getText().toString();
            tradeOffer += "~Wool " + woolAmount.getText().toString();
            tradeOffer += "~Wheat " + wheatAmount.getText().toString();
            tradeOffer += "~Ore " + oreAmount.getText().toString();
            tradeOffer += ";";
            tradeOffer += "Lumber " + lumberAmount2.getText().toString();
            tradeOffer += "~Brick " + brickAmount2.getText().toString();
            tradeOffer += "~Wool " + woolAmount2.getText().toString();
            tradeOffer += "~Wheat " + wheatAmount2.getText().toString();
            tradeOffer += "~Ore " + oreAmount2.getText().toString();
            System.out.println(tradeOffer);
            this.remove(domesticTradePanel);
            this.revalidate();
        };
        submitDomTrade.addActionListener(submitTrade);

        domesticTradePanel.add(enterDomesticTradeTitle);

        domesticTradePanel.add(youGetLabel);
        domesticTradePanel.add(lumber);
        domesticTradePanel.add(lumberAmount);
        domesticTradePanel.add(brick);
        domesticTradePanel.add(brickAmount);
        domesticTradePanel.add(wheat);
        domesticTradePanel.add(wheatAmount);
        domesticTradePanel.add(wool);
        domesticTradePanel.add(woolAmount);
        domesticTradePanel.add(ore);
        domesticTradePanel.add(oreAmount);

        domesticTradePanel.add(theyGetLabel);
        domesticTradePanel.add(lumber2);
        domesticTradePanel.add(lumberAmount2);
        domesticTradePanel.add(brick2);
        domesticTradePanel.add(brickAmount2);
        domesticTradePanel.add(wheat2);
        domesticTradePanel.add(wheatAmount2);
        domesticTradePanel.add(wool2);
        domesticTradePanel.add(woolAmount2);
        domesticTradePanel.add(ore2);
        domesticTradePanel.add(oreAmount2);
        domesticTradePanel.add(submitDomTrade);

        this.add(domesticTradePanel);
        this.validate();
    }

    private void placeRoadOnClick(ActionEvent e) {
        Map<String, Line> lines = gamePanel.getLines();
        this.roadListeners = makeRoadListeners(lines);
        gamePanel.makeRoadsClickable(roadListeners);
        gamePanel.revalidate();
        System.out.println("Select a road to build on");
    }

    private Map<String, JButton> makeRoadListeners(Map<String, Line> lines) {
        Map<String, JButton> buttons = new HashMap<>();
        for (Map.Entry<String, Line> entry : lines.entrySet()) {
            if (entry.getValue().getColor() != Color.BLACK) {
                continue;
            }
            JButton button = new JButton();
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(entry.getKey());
                    removeRoadListeners();
                    entry.getValue().setOwner(game.getCurrentPlayer() + 1);
                    gamePanel.revalidate();
                    if (game.checkSetup()) {
                        game.startingNextPhase();
                    } else {
                        game.nextPhase();
                    }
                    game.sendState();
                }
            };
            button.addActionListener(actionListener);
            int x = entry.getValue().getX();
            int y = entry.getValue().getY();
            button.setBounds(x, y, 10, 10);
            buttons.put(entry.getKey(), button);
        }
        return buttons;
    }

    private void removeRoadListeners() {
        System.out.println("disabling clickable settlements");
        for (Map.Entry<String, JButton> entry : roadListeners.entrySet()) {
            gamePanel.remove(entry.getValue());
        }
        gamePanel.revalidate();
    }

    private void removeButtonActionListeners() {
        for (ActionListener al: rollDieButton.getActionListeners()) {
            rollDieButton.removeActionListener(al);
        }
        for (ActionListener al: placeSettlementButton.getActionListeners()) {
            placeSettlementButton.removeActionListener(al);
        }
        for (ActionListener al: placeRoadButton.getActionListeners()) {
            placeRoadButton.removeActionListener(al);
        }
        for (ActionListener al: endTurnButton.getActionListeners()) {
            endTurnButton.removeActionListener(al);
        }
        for (ActionListener al: buyDevelopmentCarButton.getActionListeners()) {
            buyDevelopmentCarButton.removeActionListener(al);
        }
        for (ActionListener al: buySettlementButton.getActionListeners()) {
            buySettlementButton.removeActionListener(al);
        }
        for (ActionListener al: buyRoadButton.getActionListeners()) {
            buyRoadButton.removeActionListener(al);
        }
        for (ActionListener al: buyCityButton.getActionListeners()) {
            buyCityButton.removeActionListener(al);
        }
        for (ActionListener al: tradeMaritimeTradeButton.getActionListeners()) {
            tradeMaritimeTradeButton.removeActionListener(al);
        }
        for (ActionListener al
                : tradeDomesticTradeButton.getActionListeners()) {
            tradeDomesticTradeButton.removeActionListener(al);
        }
        for (ActionListener al
                : playDevelopmentCardButton.getActionListeners()) {
            playDevelopmentCardButton.removeActionListener(al);
        }
    }

    private void endTurnAndStartNewPlayerTurn() {
        System.out.println("Ending player turn: "
                + (game.getCurrentPlayer() + 1));
        if (game.getPhase() == 1) {
            game.nextPhase();
            game.nextPhase();
            game.sendState();
        } else if (game.getPhase() == 2) {
            game.nextPhase();
            game.sendState();
        }
    }
    private void placeSettlementOnClick(ActionEvent e) {
        Map<String, Circle> circles = gamePanel.getCircles();
        this.settlementListeners = makeSettlementListeners(circles);
        gamePanel.makeSettlementsClickable(settlementListeners);
        gamePanel.revalidate();
        System.out.println("Select a settlement to build on");
    }

    private Map<String, JButton> makeSettlementListeners(
            Map<String, Circle> circles) {
        Map<String, JButton> buttons = new HashMap<>();
        for (Map.Entry<String, Circle> entry : circles.entrySet()) {
            if (entry.getValue().getColor() != Color.WHITE) {
                continue;
            }
            JButton button = new JButton();
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Key:" + entry.getKey());
                    removeSettlementListeners();
                    entry.getValue().setPlayerNum(game.getCurrentPlayer() + 1);
                    if (game.checkSetup()) {
                        game.startingNextPhase();
                    } else {
                        game.nextPhase();
                    }
                    game.sendState();
                    // game.send
                }
            };
            button.addActionListener(actionListener);
            int x = entry.getValue().getxPos();
            int y = entry.getValue().getyPos();
            button.setBounds(x - 5, y + 10, 10, 10);
            buttons.put(entry.getKey(), button);
        }
        return buttons;
    }

    private void removeSettlementListeners() {
        for (Map.Entry<String, JButton> entry
                : this.settlementListeners.entrySet()) {
            gamePanel.remove(entry.getValue());
        }
        gamePanel.revalidate();
    }
}