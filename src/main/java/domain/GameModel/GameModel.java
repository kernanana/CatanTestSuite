package domain.GameModel;

import domain.DevelopmentCards.DevelopmentCard;
import domain.DevelopmentCards.Knight;
import domain.DevelopmentCards.Monopoly;
import domain.DevelopmentCards.RoadBuilding;
import domain.DevelopmentCards.VictoryPoint;
import domain.DevelopmentCards.YearofPlenty;
import domain.Resource;
import domain.Roads.Road;
import domain.Settlements.SettlementLocation;
import domain.Terrain.Terrain;
import domain.Terrain.TerrainTypes;

import domain.player.Player;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.Map.Entry;

public class GameModel {
    //public static final int NUM_CARDS = 25;
    public static final int NUM_RESOURCES = 19;
    private Map<Resource, Integer> bank;
    private List<Player> players;
    private List<DevelopmentCard> developmentCards;
    private Dice[] dice;
    private Map<Integer, Terrain> board;
    private List<SettlementLocation> settlementLocations;
    private List<Road> roadLocations;
    private Map<String, Map<Resource, Integer>> costs;
    private Random random;
    private Map<SettlementLocation, Character> harbors;
    private int robberLocation;

    GameModel(List<Player> players, Map<Resource, Integer> bank,
                     List<DevelopmentCard> developmentCards, Dice[] dice,
                     Map<Integer, Terrain> board,
                     List<SettlementLocation> settlementLocations,
                     List<Road> roadLocations, int robberLocation) {
        this.bank = bank;
        this.players = players;
        this.developmentCards = developmentCards;
        this.dice = dice;
        this.board = board;
        this.settlementLocations = settlementLocations;
        this.roadLocations = roadLocations;
        this.robberLocation = robberLocation;
        initializeCost();
    }
    GameModel(List<Player> players, Map<Resource, Integer> bank,
              List<DevelopmentCard> developmentCards, Dice[] dice,
              Map<Integer, Terrain> board,
              List<SettlementLocation> settlementLocations,
              List<Road> roadLocations, int robberLocation, Random random) {
        this.bank = bank;
        this.players = players;
        this.developmentCards = developmentCards;
        this.dice = dice;
        this.board = board;
        this.settlementLocations = settlementLocations;
        this.roadLocations = roadLocations;
        this.robberLocation = robberLocation;
        this.random = random;
        initializeCost();
    }
    GameModel(List<Player> players, Map<Resource, Integer> bank,
              List<DevelopmentCard> developmentCards, Dice[] dice,
              Map<Integer, Terrain> board,
              List<SettlementLocation> settlementLocations,
              List<Road> roadLocations, HashMap<SettlementLocation,
              Character> harbors, int robberLocation) {
        this.bank = bank;
        this.players = players;
        this.developmentCards = developmentCards;
        this.dice = dice;
        this.board = board;
        this.settlementLocations = settlementLocations;
        this.roadLocations = roadLocations;
        this.robberLocation = robberLocation;
        this.harbors = harbors;
        initializeCost();
    }

    GameModel(List<Player> players) {
        this.players = players;
        dice = new Dice[2];
        random = new Random();
        initializeCost();
        initializeBank();
        initializeDevelopmentCards();
        initializeBoard();
        initializeSettlementLocationsHarborsAndRoads();
    }

    public GameModel(int numPlayers) {
        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(i + 1));
        }
        dice = new Dice[2];
        this.dice[0] = new Dice();
        this.dice[1] = new Dice();
        random = new Random();
        initializeCost();
        initializeBank();
        initializeDevelopmentCards();
        initializeBoard();
        initializeSettlementLocationsHarborsAndRoads();
    }
    GameModel(List<Player> players, Map<Resource, Integer> bank,
              List<DevelopmentCard> developmentCards, Dice[] dice,
              int robberLocation) {
        this.bank = bank;
        this.players = players;
        this.developmentCards = developmentCards;
        this.dice = dice;
        this.robberLocation = robberLocation;
        random = new Random();
        initializeCost();
        initializeBoard();
        initializeSettlementLocationsHarborsAndRoads();
    }

    GameModel(Dice[] dice) {
        this.dice = dice;
    }

    private void initializeBoard() {
        List<Integer> rolls = new ArrayList<>();
        rolls.add(2);
        rolls.add(12);
        for (int i = 0; i < 4; i++) {
            rolls.add(3 + i);
            rolls.add(3 + i);
            rolls.add(11 - i);
            rolls.add(11 - i);
        }
        List<Integer> swapIndices = new ArrayList<>();
        int rollInd = 0;
        board = new HashMap<>();
        for (int j = 0; j < 7; j++) {
            if (j == 0 || j == 6) {
                for (int i = 0; i < 4; i++) {
                    board.put(i + 10 * j, new Terrain(i + 10 * j,
                            TerrainTypes.DESERT, 0));
                }
            } else if (j < 4) {
                board.put(10 * j, new Terrain(10 * j,
                        TerrainTypes.DESERT, 0));
                TerrainTypes chosenType;
                switch (j) {
                    case 1:
                        chosenType = TerrainTypes.MOUNTAIN;
                        break;
                    case 2:
                        chosenType = TerrainTypes.PASTURE;
                        break;
                    default:
                        chosenType = TerrainTypes.FOREST;
                }
                for (int i = 0; i < 2 + j; i++) {
                    if (j == 3 && i == 2) {
                        board.put(10 * j + 1 + i,
                                new Terrain(10 * j + 1 + i,
                                        TerrainTypes.DESERT, 0));
                        robberLocation = 23;
                    } else {
                        board.put(10 * j + 1 + i, new Terrain(10 * j + 1 + i,
                                chosenType, rolls.get(rollInd++)));
                    }
                    swapIndices.add(10 * j + 1 + i);
                }
                board.put(10 * j + 3 + j, new Terrain(10 * j + 3 + j,
                        TerrainTypes.DESERT, 0));
            } else {
                board.put(10 * j, new Terrain(10 * j,
                        TerrainTypes.DESERT, 0));
                TerrainTypes chosenType;
                switch (j) {
                    case 4:
                        chosenType = TerrainTypes.FIELD;
                        break;
                    default:
                        chosenType = TerrainTypes.HILLS;
                }
                for (int i = 0; i < 8 - j; i++) {
                    board.put(10 * j + 1 + i, new Terrain(10 * j + 1 + i,
                            chosenType, rolls.get(rollInd++)));
                    swapIndices.add(10 * j + 1 + i);
                }
                board.put(10 * j + 9 - j, new Terrain(10 * j + 9 - j,
                        TerrainTypes.DESERT, 0));
            }
        }
        for (int i = 0; i < 5 * swapIndices.size(); i++) {
            int r1 = random.nextInt(swapIndices.size());
            int r2 = random.nextInt(swapIndices.size());
            TerrainTypes tempType = board.get(swapIndices.get(r1)).type;
            board.put(swapIndices.get(r1), new Terrain(swapIndices.get(r1),
                    board.get(swapIndices.get(r2)).type,
                    board.get(swapIndices.get(r1)).getRollNumber()));
            board.put(swapIndices.get(r2), new Terrain(swapIndices.get(r2),
                    tempType,
                    board.get(swapIndices.get(r2)).getRollNumber()));

        }
        for (int i = 0; i < swapIndices.size(); i++) {
            if (board.get(swapIndices.get(i)).type == TerrainTypes.DESERT) {
                swapIndices.remove(i);
                break;
            }
        }
        boolean redsconnecting = true;
        while (redsconnecting) {
            System.out.println("Fixing");
            for (int i = 0; i < 5 * swapIndices.size(); i++) {
                int r1 = random.nextInt(swapIndices.size());
                int r2 = random.nextInt(swapIndices.size());
                Terrain tempTerrain = board.get(swapIndices.get(r1));
                board.put(swapIndices.get(r1), new Terrain(swapIndices.get(r1),
                        board.get(swapIndices.get(r1)).type,
                        board.get(swapIndices.get(r2)).getRollNumber()));
                board.put(swapIndices.get(r2), new Terrain(swapIndices.get(r2),
                        board.get(swapIndices.get(r2)).type,
                        tempTerrain.getRollNumber()));
            }
            redsconnecting = false;
            for (int i = 0; i < swapIndices.size(); i++) {
                if (board.get(swapIndices.get(i)).getRollNumber() == 6
                        || board.get(swapIndices.get(i)).getRollNumber() == 8) {
                    int j = swapIndices.get(i);
                    int modifier = 1;
                    if (j < 30) {
                        modifier = 0;
                    }
                    if (swapIndices.contains(j + 10 - modifier)) {
                        if (board.get(j + 10 - modifier).getRollNumber() == 6
                                || board.get(j + 10 - modifier)
                                .getRollNumber() == 8) {
                            redsconnecting = true;
                            break;
                        }
                    }
                    if (swapIndices.contains(j + 11 - modifier)) {
                        if (board.get(j + 11 - modifier).getRollNumber() == 6
                                || board.get(j + 11 - modifier)
                                .getRollNumber() == 8) {
                            redsconnecting = true;
                            break;
                        }
                    }
                    if (swapIndices.contains(j + 1)) {
                        if (board.get(j + 1).getRollNumber() == 6
                                || board.get(j + 1).getRollNumber() == 8) {
                            redsconnecting = true;
                            break;
                        }
                    }
                    if (swapIndices.contains(j - 1)) {
                        if (board.get(j - 1).getRollNumber() == 6
                                || board.get(j - 1).getRollNumber() == 8) {
                            redsconnecting = true;
                            break;
                        }
                    }
                    modifier = 1;
                    if (j < 40) {
                        modifier = 0;
                    }
                    if (swapIndices.contains(j - 10 + modifier)) {
                        if (board.get(j - 10 + modifier).getRollNumber() == 6
                                || board.get(j - 10 + modifier)
                                .getRollNumber() == 8) {
                            redsconnecting = true;
                            break;
                        }
                    }
                    if (swapIndices.contains(j - 11 + modifier)) {
                        if (board.get(j - 11 + modifier).getRollNumber() == 6
                                || board.get(j - 11 + modifier)
                                .getRollNumber() == 8) {
                            redsconnecting = true;
                            break;
                        }
                    }
                }
            }
        }

    }

    public List<String> checkOptionsToBuy(int playerID) {
        return players.get(playerID - 1).getBuyableItems();
    }

    private void initializeSettlementLocationsHarborsAndRoads() {
        settlementLocations = new ArrayList<>();
        roadLocations = new ArrayList<>();
        harbors = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                for (int j = 0; j < 3 + i; j++) {
                    List<Terrain> terrs = new ArrayList<>();
//                    List<Road> roadList = new ArrayList<>();
//                    roadList.add(new Road());
//                    roadList.add(new Road());
//                    roadList.add(new Road());
                    terrs.add(board.get(10 * i + j));
                    terrs.add(board.get(10 * i + j + 1));
                    terrs.add(board.get(10 * (i + 1) + j + 1));
                    SettlementLocation settlementLocation =
                            new SettlementLocation(terrs);
                    if (i == 0 && j == 0) {
                        harbors.put(settlementLocation, '?');
                    } else if (i == 0 && j == 1) {
                        harbors.put(settlementLocation, 'H');
                    } else if (i == 1 && j == 3) {
                        harbors.put(settlementLocation, 'O');
                    } else if (i == 2 && j == 0) {
                        harbors.put(settlementLocation, 'L');
                    }
                    settlementLocations.add(settlementLocation);
                }
            } else {
                for (int j = 0; j < 9 - i; j++) {
                    List<Terrain> terrs = new ArrayList<>();
//                    List<Road> roadList = new ArrayList<>();
//                    roadList.add(new Road());
//                    roadList.add(new Road());
//                    roadList.add(new Road());
                    terrs.add(board.get(10 * i + j));
                    terrs.add(board.get(10 * i + j + 1));
                    terrs.add(board.get(10 * (i + 1) + j));
                    SettlementLocation settlementLocation =
                            new SettlementLocation(terrs);
                    if (i == 3 && j == 5) {
                        harbors.put(settlementLocation, '?');
                    } else if (i == 4 && j == 0) {
                        harbors.put(settlementLocation, 'B');
                    } else if (i == 4 && j == 4) {
                        harbors.put(settlementLocation, 'W');
                    } else if (i == 5 && j == 0) {
                        harbors.put(settlementLocation, '?');
                    } else if (i == 5 && j == 2) {
                        harbors.put(settlementLocation, '?');
                    }
                    settlementLocations.add(settlementLocation);
                }
            }

            if (i < 3) {
                for (int j = 0; j < 4 + i; j++) {
                    List<Terrain> terrs = new ArrayList<>();
//                    List<Road> roadList = new ArrayList<>();
//                    roadList.add(new Road());
//                    roadList.add(new Road());
//                    roadList.add(new Road());
                    terrs.add(board.get(10 * i + j));
                    terrs.add(board.get(10 * (i + 1) + j));
                    terrs.add(board.get(10 * (i + 1) + j + 1));
                    SettlementLocation settlementLocation =
                            new SettlementLocation(terrs);
                    if (i == 0 && j == 0) {
                        harbors.put(settlementLocation, '?');
                    } else if (i == 0 && j == 2) {
                        harbors.put(settlementLocation, 'H');
                    } else if (i == 1 && j == 0) {
                        harbors.put(settlementLocation, 'L');
                    } else if (i == 1 && j == 4) {
                        harbors.put(settlementLocation, 'O');
                    } else if (i == 2 && j == 5) {
                        harbors.put(settlementLocation, '?');
                    }
                    settlementLocations.add(settlementLocation);
                }
            } else {
                for (int j = 0; j < 8 - i; j++) {
                    List<Terrain> terrs = new ArrayList<>();
//                    List<Road> roadList = new ArrayList<>();
//                    roadList.add(new Road());
//                    roadList.add(new Road());
//                    roadList.add(new Road());
                    terrs.add(board.get(10 * i + j + 1));
                    terrs.add(board.get(10 * (i + 1) + j));
                    terrs.add(board.get(10 * (i + 1) + j + 1));
                    SettlementLocation settlementLocation =
                            new SettlementLocation(terrs);
                    if (i == 3 && j == 0) {
                        harbors.put(settlementLocation, 'B');
                    } else if (i == 4 && j == 3) {
                        harbors.put(settlementLocation, 'W');
                    } else if (i == 5 && j == 0) {
                        harbors.put(settlementLocation, '?');
                    } else if (i == 5 && j == 1) {
                        harbors.put(settlementLocation, '?');
                    }
                    settlementLocations.add(settlementLocation);
                }
            }
        }
        for (int i = 0; i < settlementLocations.size(); i++) {
            // int k = 0;
            SettlementLocation sl1 = settlementLocations.get(i);
            for (int j = i + 1; j < settlementLocations.size(); j++) {
                SettlementLocation sl2 = settlementLocations.get(j);
                if ((sl2.getTerrains().contains(sl1.getTerrains().get(0))
                        && sl2.getTerrains().contains(sl1.getTerrains()
                        .get(1)))
                        || (sl2.getTerrains().contains(sl1.getTerrains()
                        .get(1))
                        && sl2.getTerrains().contains(sl1.getTerrains()
                        .get(2)))
                        || (sl2.getTerrains().contains(sl1.getTerrains()
                        .get(2))
                        && sl2.getTerrains().contains(sl1.getTerrains()
                        .get(0)))) {
                    Road road = new Road();
                    road.addSettlement(sl1);
                    road.addSettlement(sl2);
                    sl1.addRoad(road);
                    sl2.addRoad(road);
                    roadLocations.add(road);
                }
            }
        }

    }

    private void initializeDevelopmentCards() {
        developmentCards = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            developmentCards.add(new Knight("Knight"));
        }
        for (int i = 0; i < 2; i++) {
            developmentCards.add(new YearofPlenty("Year of Plenty"));
            developmentCards.add(new RoadBuilding("Road.java Building"));
            developmentCards.add(new Monopoly("Monopoly"));
        }
        for (int i = 0; i < 5; i++) {
            developmentCards.add(new VictoryPoint("Year of Plenty"));
        }
        for (int i = 0; i < 5 * developmentCards.size(); i++) {
            int r1 = random.nextInt(developmentCards.size());
            int r2 = random.nextInt(developmentCards.size());
            DevelopmentCard tempCard = developmentCards.get(r1);
            developmentCards.set(r1, developmentCards.get(r2));
            developmentCards.set(r2, tempCard);
        }
    }

    private void initializeBank() {
        bank = new HashMap<>();
        bank.put(Resource.ORE, NUM_RESOURCES);
        bank.put(Resource.LUMBER, NUM_RESOURCES);
        bank.put(Resource.WOOL, NUM_RESOURCES);
        bank.put(Resource.BRICK, NUM_RESOURCES);
        bank.put(Resource.WHEAT, NUM_RESOURCES);
    }

    private void initializeCost() {
        costs = new HashMap<>();
        Map<Resource, Integer> cityCost = new HashMap<>();
        cityCost.put(Resource.WHEAT, 2);
        cityCost.put(Resource.ORE, 3);
        costs.put("City", cityCost);
        Map<Resource, Integer> roadCost = new HashMap<>();
        roadCost.put(Resource.BRICK, 1);
        roadCost.put(Resource.LUMBER, 1);
        costs.put("Road", roadCost);
        Map<Resource, Integer> settlementCost = new HashMap<>();
        settlementCost.put(Resource.BRICK, 1);
        settlementCost.put(Resource.LUMBER, 1);
        settlementCost.put(Resource.WHEAT, 1);
        settlementCost.put(Resource.WOOL, 1);
        costs.put("Settlement", settlementCost);
        Map<Resource, Integer> developmentCardCost = new HashMap<>();
        developmentCardCost.put(Resource.ORE, 1);
        developmentCardCost.put(Resource.WHEAT, 1);
        developmentCardCost.put(Resource.WOOL, 1);
        costs.put("Development Card", developmentCardCost);
    }

    public Map<Resource, Integer> getPlayerResources(int playerID) {
        Map<Resource, Integer> playerResources = new HashMap<>();
        playerResources.put(Resource.ORE, players.get(playerID)
                .getResourceAmount(Resource.ORE));
        playerResources.put(Resource.WHEAT, players.get(playerID)
                .getResourceAmount(Resource.WHEAT));
        playerResources.put(Resource.BRICK, players.get(playerID)
                .getResourceAmount(Resource.BRICK));
        playerResources.put(Resource.LUMBER, players.get(playerID)
                .getResourceAmount(Resource.LUMBER));
        playerResources.put(Resource.WOOL, players.get(playerID)
                .getResourceAmount(Resource.WOOL));
        return playerResources;
    }

    public int getDevelopmentCardCount() {
        return developmentCards.size();
    }

    public boolean tradeResources(int playerTradingIndex,
                                  int playerTradedToIndex,
                                  Map<Resource, Integer> traded,
                                  Map<Resource, Integer> tradedFor) {
        if (hasResources(playerTradingIndex, traded)
                && hasResources(playerTradedToIndex, tradedFor)) {
            Resource[] typeArr = {Resource.ORE, Resource.BRICK,
                    Resource.WOOL, Resource.LUMBER, Resource.WHEAT};
            for (int i = 0; i < typeArr.length; i++) {
                players.get(playerTradingIndex).removeResources(typeArr[i],
                        traded.get(typeArr[i]));
                players.get(playerTradedToIndex).removeResources(typeArr[i],
                        tradedFor.get(typeArr[i]));
                players.get(playerTradingIndex).addResources(typeArr[i],
                        tradedFor.get(typeArr[i]));
                players.get(playerTradedToIndex).addResources(typeArr[i],
                        traded.get(typeArr[i]));
            }
            return true;
        }
        return false;
    }

    public boolean hasResources(int playerIndex,
                                Map<Resource, Integer> resources) {
        Player player = players.get(playerIndex);
        Resource[] typeArr = {Resource.ORE, Resource.BRICK,
                Resource.WOOL, Resource.LUMBER, Resource.WHEAT};
        for (int i = 0; i < typeArr.length; i++) {
            if (player.getResourceAmount(typeArr[i])
                    < resources.get(typeArr[i])) {
                return false;
            }
        }
        return true;
    }

//    public List<SettlementLocation> getSettlements(int playerIndex) {
//        return players.get(playerIndex).getSettlementLocations();
//    }

    public Set<SettlementLocation> getPlaceableSettlements(int playerIndex) {
        return players.get(playerIndex).getPossibleSettlementLocations();
    }

    public Set<Road> getPossibleRoads(int playerIndex) {
        return players.get(playerIndex).getPossibleRoadLocations();
    }

    public List<Integer> getVictoryPoints() {
        List<Integer> victoryPoints = new ArrayList<>();
        for (Player p : players) {
            victoryPoints.add(p.getVictoryPoints());
        }
        return victoryPoints;
    }

    public List<List<Integer>> getSettlementLocations() {
        List<List<Integer>> descriptive = new ArrayList<>();
        for (SettlementLocation sl : settlementLocations) {
            List<Integer> descriptiveNumbers = new ArrayList<>();
            List<Terrain> terrains = sl.getTerrains();
            for (Terrain terrain : terrains) {
                descriptiveNumbers.add(terrain.getLocID());
            }
            descriptiveNumbers.add(sl.getOwner());
            descriptiveNumbers.add(sl.getMultiplier());
            descriptive.add(descriptiveNumbers);
        }
        return descriptive;
    }

    public List<List<Integer>> getRoadLocations() {
        List<List<Integer>> roadPositions = new ArrayList<>();
        for (Road road: roadLocations) {
            List<Integer> roadPos = new ArrayList<>();
            List<SettlementLocation> settlements = road.getSettlements();
            for (int j = 0; j < settlements.size(); j++) {
                List<Terrain> terrains = settlements.get(j).getTerrains();
                for (int k = 0; k < terrains.size(); k++) {
                    roadPos.add(terrains.get(k).getLocID());
                }
            }
            roadPos.add(road.getOwner());
            roadPositions.add(roadPos);
        }
        return roadPositions;
    }

    public int getDevelopmentCardHandSize(int playerID) {
        if (playerID < 1 || playerID > players.size()) {
            throw new InvalidParameterException("This player does not exist");
        }
        int playerIndex = playerID - 1;
        List<DevelopmentCard> devCards =
                players.get(playerIndex).getOwnedDevelopmentCards();
        return devCards.size();
    }

    public Map<Resource, Integer> getResourceCardDeckSize() {
        return new HashMap<Resource, Integer>(bank);
    }

    public List<Integer> getRoadLengths() {
        List<Integer> lengths = new ArrayList<>();
        for (Player p: players) {
            lengths.add(p.getRoadLength());
        }
        return lengths;
    }

    public List<Integer> getArmySizes() {
        List<Integer> armies = new ArrayList<>();
        for (Player p: players) {
            armies.add(p.getArmySize());
        }
        return armies;
    }

    public List<Integer> getHandSizes() {
        List<Integer> handSizes = new ArrayList<>();
        for (Player p: players) {
            handSizes.add(p.getHandSize());
        }
        return handSizes;
    }

    public List<List<String>> getHands() {
        List<List<String>> playerHands = new ArrayList<>();
        for (Player p: players) {
            playerHands.add(p.getHand());
        }
        return playerHands;
    }
    public boolean maritimeTradeResources(int player, int numResources,
                                          Resource traded, Resource received) {
        if (player < 0 || player >= players.size()
                || numResources < 2 || numResources > 4) {
            throw new InvalidParameterException();
        }
        if (traded == null || received == null) {
            throw new NullPointerException();
        }
        Player p = players.get(player);
        if (bank.get(received) > 0 && p.removeResources(traded, numResources)) {
            bank.put(traded, bank.get(traded) + numResources);
            bank.put(received, bank.get(traded) - 1);
            p.addResources(received, 1);
            return true;
        }
        return false;
    }

    public String getHarborString(int player) {
        return players.get(player).getHarborString();
    }

    public int getRobberLocation() {
        return robberLocation;
    }

    public List<Player> moveRobber(int locID) {
        List<Player> result = new ArrayList<>();
        List<Integer> playerIDs = new ArrayList<>();
        if (!board.containsKey(locID)) {
            throw new IllegalArgumentException(
                    "This locationID does not exist");
        }
        if (board.get(locID).getType() == TerrainTypes.OCEAN) {
            throw new IllegalArgumentException(
                    "Robber can not be placed on ocean");
        }
        if (board.get(locID).hasRobber()) {
            throw new IllegalArgumentException(
                    "You can not replace the Robber in the same spot");
        }
        board.get(robberLocation).setRobberState(false);
        board.get(locID).setRobberState(true);
        for (int i = 0; i < settlementLocations.size(); i++) {
            List<Terrain> terrainsAroundSL =
                    settlementLocations.get(i).getTerrains();
            for (int j = 0; j < terrainsAroundSL.size(); j++) {
                if (terrainsAroundSL.get(j).getLocID() == locID) {
                    int playerIDIndex =
                            settlementLocations.get(i).getOwner() - 1;
                    if (!playerIDs.contains(playerIDIndex)) {
                        playerIDs.add(playerIDIndex);
                    }
                }
            }
        }
        for (int i = 0; i < playerIDs.size(); i++) {
            result.add(players.get(playerIDs.get(i)));
        }
        robberLocation = locID;
        return result;
    }

    public boolean disperseResourcesBasedOnRollNumber(int rollNum) {
        ArrayList<Map<Resource, Integer>> amountAddedToPlayers
                = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            Map<Resource, Integer> emptyBank = new HashMap<>();
            emptyBank.put(Resource.LUMBER, 0);
            emptyBank.put(Resource.ORE, 0);
            emptyBank.put(Resource.BRICK, 0);
            emptyBank.put(Resource.WOOL, 0);
            emptyBank.put(Resource.WHEAT, 0);
            amountAddedToPlayers.add(emptyBank);
        }
        Map<Resource, Integer> amountRemovedFromBank = new HashMap<>();
        amountRemovedFromBank.put(Resource.LUMBER, 0);
        amountRemovedFromBank.put(Resource.ORE, 0);
        amountRemovedFromBank.put(Resource.BRICK, 0);
        amountRemovedFromBank.put(Resource.WOOL, 0);
        amountRemovedFromBank.put(Resource.WHEAT, 0);
        Map<Resource, Boolean> notEnoughWarningFlags = new HashMap<>();
        notEnoughWarningFlags.put(Resource.LUMBER, false);
        notEnoughWarningFlags.put(Resource.ORE, false);
        notEnoughWarningFlags.put(Resource.BRICK, false);
        notEnoughWarningFlags.put(Resource.WOOL, false);
        notEnoughWarningFlags.put(Resource.WHEAT, false);
        if (rollNum < 1 || rollNum > 12) {
            throw new IllegalArgumentException("Valid rolls are 1-12");
        }
        if (rollNum == 7) {
            throw new IllegalArgumentException(
                    "Roll 7 does not disperse resources");
        }
        for (int i = 0; i < players.size(); i++) {
            Map<Resource, Integer> quantityGained =
                    players.get(i).
                            getResourceAmountGainedFromRollNumber(rollNum);
            for (Entry<Resource, Integer> entry: quantityGained.entrySet()) {
                int currentAmount = bank.get(entry.getKey());
                int totalRemovedAmount =
                        amountRemovedFromBank.get(entry.getKey());
                int playeriaddedAmount =
                        amountAddedToPlayers.get(i).get(entry.getKey());
                if (currentAmount <= entry.getValue()) {
                    if (currentAmount == entry.getValue()) {
//                        System.out.println("first removal");
                        players.get(i).addResources(entry.getKey(),
                                bank.get(entry.getKey()));
                        bank.replace(entry.getKey(), 0);
                        amountAddedToPlayers.get(i).replace(entry.getKey(),
                                playeriaddedAmount + entry.getValue());
                        amountRemovedFromBank.replace(entry.getKey(),
                                totalRemovedAmount + entry.getValue());
                        notEnoughWarningFlags.replace(entry.getKey(), true);
                    } else {
                        if (notEnoughWarningFlags.get(entry.getKey())) {
                            int bankAmountToReset =
                                    amountRemovedFromBank.get(entry.getKey());
                            bank.replace(entry.getKey(), bankAmountToReset);
                            for (int j = 0; j < amountAddedToPlayers.size();
                                 j++) {
                                int resourceAmountToRemove =
                                        amountAddedToPlayers.get(j)
                                        .get(entry.getKey());
                                players.get(j).removeResources(entry.getKey(),
                                        resourceAmountToRemove);
                            }
                        } else {
                            players.get(i).addResources(entry.getKey(),
                                    bank.get(entry.getKey()));
                            amountAddedToPlayers.get(i).replace(entry.getKey(),
                                    playeriaddedAmount + entry.getValue());
                            bank.replace(entry.getKey(), 0);
                            amountRemovedFromBank.replace(entry.getKey(),
                                    totalRemovedAmount + entry.getValue());
                            notEnoughWarningFlags.replace(entry.getKey(), true);
                        }
                    }
                } else {
                    bank.replace(entry.getKey(),
                            currentAmount - entry.getValue());
                    amountAddedToPlayers.get(i).replace(entry.getKey(),
                            playeriaddedAmount + entry.getValue());
                    amountRemovedFromBank.replace(entry.getKey(),
                            totalRemovedAmount + entry.getValue());
                    players.get(i).addResources(entry.getKey(),
                            entry.getValue());
                }

            }
        }
        return true;
    }

    public boolean playerTakeFromBank(
            int playerID, Resource resourceName, int quantity) {
        if (playerID > players.size() || playerID < 1) {
            throw new IllegalArgumentException(
                    "this player's ID does not exist");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantitiy must be greater than 0");
        }
        if (quantity > bank.get(resourceName)) {
            throw new IllegalArgumentException(
                    "Quantitiy can not exceed amount left in the bank");
        }
        players.get(playerID - 1).addResources(resourceName, quantity);
        bank.replace(resourceName, bank.get(resourceName) - quantity);
        return true;
    }

    public boolean playerGiveToBank(
            int playerID, Resource resourceName, int quantity) {
        if (playerID > players.size() || playerID < 1) {
            throw new IllegalArgumentException(
                    "this player's ID does not exist");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantitiy must be greater than 0");
        }
        if (quantity > (players.get((playerID - 1)).
                getResourceAmount(resourceName))) {
            throw new IllegalArgumentException(
                    "This player has insufficient resources");
        }
        players.get(playerID - 1).removeResources(resourceName, quantity);
        bank.replace(resourceName, bank.get(resourceName) + quantity);
        return true;
    }
    public Map<String, String> getBoardState() {
        Map<String, String> state = new HashMap<>();
        String terrains = "";
        for (Entry<Integer, Terrain> e: board.entrySet()) {
            terrains += e.getKey() + " " + e.getValue().getType().toString()
                    + " " + e.getValue().hasRobber() + " "
                    + e.getValue().getRollNumber() + "~";
        }
        terrains = terrains.trim();
        state.put("Terrains", terrains);
        state.put("DevCardDeck", "" + getDevelopmentCardCount());
        String bankString = "";
        bankString += "Wool," + bank.get(Resource.WOOL) + "~";
        bankString += "Ore," + bank.get(Resource.ORE) + "~";
        bankString += "Wheat," + bank.get(Resource.WHEAT) + "~";
        bankString += "Brick," + bank.get(Resource.BRICK) + "~";
        bankString += "Lumber," + bank.get(Resource.LUMBER) + "~";
        state.put("Bank", bankString);
        state.put("Roll", dice[0].getLastRoll() + " " + dice[1].getLastRoll());
        state.put("SettlementLocations", getSettlementLocations().toString());
        state.put("Victory Points", getVictoryPoints().toString());
        state.put("Roads", getRoadLocations().toString());
//        String devCardHandSizes = "";
//        for(int i = 0; i < players.size(); i++) {
//            devCardHandSizes += getDevelopmentCardHandSize(i) + " ";
//        }
        String devCardHands = "";
        for (int i = 0; i < players.size(); i++) {
            devCardHands +=  "~" + players.get(i).getOwnedDevelopmentCards();
        }
        state.put("DevCards", devCardHands);
        state.put("RoadLengths", getRoadLengths().toString());
        state.put("ArmySizes", getArmySizes().toString());
        state.put("Hands", getHands().toString());
        return state;
    }
    public boolean addHarbors(int player, int ter1, int ter2, int ter3) {
        if (player < 0 || player >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        Set<Integer> ters = new HashSet<>();
        ters.add(ter1);
        ters.add(ter2);
        ters.add(ter3);
        for (SettlementLocation sl: settlementLocations) {
            List<Terrain> terrains = sl.getTerrains();
            Set<Integer> slters = new HashSet<>();
            for (int i = 0; i < terrains.size(); i++) {
                slters.add(terrains.get(i).getLocID());
            }
            if (ters.equals(slters) && harbors.keySet().contains(sl)) {
                players.get(player).addHarbor(harbors.get(sl));
                return true;
            }
        }
        return false;
    }

    public int rollDice() {
        return dice[0].roll() + dice[1].roll();
    }

    public boolean addSettlement(int player, int ter1, int ter2, int ter3) {
        if (player < 0 || player >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        addHarbors(player, ter1, ter2, ter3);
        Set<Integer> ters = new HashSet<>();
        ters.add(ter1);
        ters.add(ter2);
        ters.add(ter3);
        for (SettlementLocation sl: settlementLocations) {
            List<Terrain> terrains = sl.getTerrains();
            Set<Integer> slters = new HashSet<>();
            for (int i = 0; i < terrains.size(); i++) {
                slters.add(terrains.get(i).getLocID());
            }
            if (ters.equals(slters)) {
                players.get(player).addSettlement(sl);
                return true;
            }
        }
        return false;
    }

    public boolean addRoad(int player, int ter1, int ter2, int ter3,
                           int ter4, int ter5, int ter6) {
        if (player < 0 || player >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        Set<Integer> ters = new HashSet<>();
        ters.add(ter1);
        ters.add(ter2);
        ters.add(ter3);
        ters.add(ter4);
        ters.add(ter5);
        ters.add(ter6);
        for (Road r: roadLocations) {
            List<SettlementLocation> tempSettlementLocations =
                    r.getSettlements();
            Set<Integer> slters = new HashSet<>();
            for (SettlementLocation sl: tempSettlementLocations) {
                List<Terrain> terrains = sl.getTerrains();
                for (int i = 0; i < terrains.size(); i++) {
                    slters.add(terrains.get(i).getLocID());
                }
            }
            if (ters.equals(slters)) {
                players.get(player).addRoad(r);
                return true;
            }
        }
        return false;
    }
    public List<Road> getPossibleStartingRoads(int ter1, int ter2, int ter3) {
        List<Road> roads = new ArrayList<>();
        Set<Integer> inputTerrainValues = new HashSet<>();
        inputTerrainValues.add(ter1);
        inputTerrainValues.add(ter2);
        inputTerrainValues.add(ter3);
        for (Road r: roadLocations) {
            boolean appears = false;
            for (SettlementLocation sl: r.getSettlements()) {
                Set<Integer> terrainValues = new HashSet<>();
                for (Terrain t: sl.getTerrains()) {
                    terrainValues.add(t.getLocID());
                }
                if (inputTerrainValues.equals(terrainValues)) {
                    appears = true;
                }
            }
            if (appears) {
                roads.add(r);
            }
        }
        return roads;
    }
    public List<SettlementLocation> getPossibleStartingSettlements() {
        List<SettlementLocation> owned = new ArrayList<>();
        List<SettlementLocation> finalList = new ArrayList<>();
        for (SettlementLocation sl: settlementLocations) {
            if (sl.getOwner() != 0) {
                owned.add(sl);
            }
        }
        for (SettlementLocation sl: settlementLocations) {
            boolean add = true;
            Set<Integer> terLocs1 = new HashSet<>();
            for (Terrain t : sl.getTerrains()) {
                terLocs1.add(t.getLocID());
            }
            for (SettlementLocation osl : owned) {
                Set<Integer> terLocs2 = new HashSet<>();
                for (Terrain t : osl.getTerrains()) {
                    terLocs2.add(t.getLocID());
                }
                terLocs1.retainAll(terLocs2);
                if (terLocs1.size() >= 2) {
                    add = false;
                }
            }
            if (add) {
                finalList.add(sl);
            }
        }
        return finalList;
    }
    public void stealAll(int stealingPlayer, Resource resource) {
        if (stealingPlayer < 0 || stealingPlayer >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (resource == null) {
            throw new NullPointerException();
        }
        for (Player p: players) {
            int amount = p.getResourceAmount(resource);
            p.removeResources(resource, amount);
            players.get(stealingPlayer).addResources(resource, amount);
        }
    }
    public boolean sendRandomResource(int playerTo, int playerFrom) {
        if (playerTo < 0 || playerTo >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        List<Resource> resources = Resource.getResourceList();
        Player p = players.get(playerFrom);
        List<Resource> totalResources = new ArrayList<>();
        for (Resource r: resources) {
            int amount = p.getResourceAmount(r);
            for (int i = 0; i < amount; i++) {
                totalResources.add(r);
            }
        }
        if (totalResources.size() == 0) {
            return false;
        }
        Resource toRemove = totalResources.get(
                random.nextInt(totalResources.size()));
        p.removeResources(toRemove, 1);
        players.get(playerTo).addResources(toRemove, 1);
        return true;
    }

    public DevelopmentCard getDevelopmentCard(int player, int index) {
        if (player < 0 || player >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        return players.get(player).removeDevelopmentCard(index);
    }

    public void addDevelopmentCard(int player) {
        if (developmentCards.size() != 0) {
            players.get(player).addOneDevelopmentCard(
                    developmentCards.remove(developmentCards.size() - 1));
        }
    }

    public boolean turnToCity(int playerID, int ter1, int ter2, int ter3) {
        if (playerID < 0 || playerID >= players.size()) {
            throw new IndexOutOfBoundsException();
        }
        Set<Integer> ters = new HashSet<>();
        ters.add(ter1);
        ters.add(ter2);
        ters.add(ter3);
        for (SettlementLocation sl: settlementLocations) {
            Set<Integer> values = new HashSet<>();
            for (Terrain t: sl.getTerrains()) {
                values.add(t.getLocID());
            }
            if (values.equals(ters)) {
                if (sl.getOwner() == playerID + 1) {
                    sl.convertToCity();
                    return true;
                }
            }
        }
        return false;
    }
    public boolean changeVictoryPoints(int playerID, int num) {
        if (num <= -3 || num >= 3) {
            throw new InvalidParameterException();
        }
        if (num < 0) {
            players.get(playerID).removeVictoryPoints(-num);
            return false;
        }
        players.get(playerID).addVictoryPoints(num);
        return players.get(playerID).checkWinCondition();
    }

}

