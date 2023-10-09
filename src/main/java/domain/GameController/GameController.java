package domain.GameController;

//import domain.GameModel.GameModel;
//import presentation.GameUserInterface;
import domain.DevelopmentCards.DevelopmentCard;
import domain.GameModel.GameModel;
import domain.Resource;
import domain.Roads.Road;
import domain.Settlements.SettlementLocation;
import domain.Terrain.Terrain;
import presentation.UserInterface;
import java.util.Map.Entry;

import java.util.*;

//import java.util.Random;


public class GameController {
    public UserInterface gui;
    private int longestRoadPlayerIndex;
    private int largestArmyPlayerIndex;
    private int phase;
    //UserInterface ui;
    GameModel gameModel;
    //private int forwards;
    Random random;
    private int currentPlayerIndex;
    private int numPlayers;
    private int startingPlayer;
    private boolean setup;
    private Map<String, Integer> components;
    private List<String> componentsNeeded;
    private DevelopmentCard currentCard;
    GameController(int numPlayers, Random random, int phase) {
        this.random = random;
        this.numPlayers = numPlayers;
        this.phase = phase;
        setup = true;
        components = new HashMap<>();
        componentsNeeded = new ArrayList<>();
        chooseTurnOrder();
    }
    public GameController(UserInterface ui, int numPlayers) {
        gui = ui;
        gui.setVisible(true);
        //this.ui = ui;
        gameModel = new GameModel(numPlayers);
        phase = 0;
        random = new Random();
        this.numPlayers = numPlayers;
        largestArmyPlayerIndex = -1;
        longestRoadPlayerIndex = -1;
        setup = true;
        components = new HashMap<>();
        componentsNeeded = new ArrayList<>();
        chooseTurnOrder();
    }

    private void chooseTurnOrder() {
        currentPlayerIndex = random.nextInt(numPlayers);
        startingPlayer = currentPlayerIndex;
    }

    //when setup is true
    //phase 0: first settlement
    //phase 1: first road
    //phase 2: second settlement
    //phase 3: second road

    //when setup is false
    //phase 0: roll die
    //phase 1: trade
    //phase 2: build
    //Turn 0, 1, 2, 3 then 3, 2, 1, 0
    public void startingNextPhase() {
        if (phase < 0 || phase > 3 || currentPlayerIndex < 0
                || currentPlayerIndex >= numPlayers) {
            throw new IndexOutOfBoundsException();
        } else if (phase % 2 == 0) {
            phase++;
        } else if (phase == 1) {
            if ((currentPlayerIndex + 1) % numPlayers == startingPlayer) {
                phase++;
            } else {
                phase--;
                currentPlayerIndex++;
                currentPlayerIndex = currentPlayerIndex % numPlayers;
            }
        } else {
            if (startingPlayer == currentPlayerIndex) {
                setup = false;
                phase = 0;
            } else {
                phase--;
                currentPlayerIndex--;
                currentPlayerIndex = (currentPlayerIndex + numPlayers)
                        % numPlayers;
            }
        }
    }
    public void nextPhase() {
        if (phase < 0 || phase > 2 || currentPlayerIndex < 0
                || currentPlayerIndex >= numPlayers) {
            throw new IndexOutOfBoundsException();
        } else if (++phase == 3) {
            phase = 0;
            currentPlayerIndex++;
            currentPlayerIndex = currentPlayerIndex % numPlayers;
        }
        // sendState();
    }
    public int getPhase() {
        return phase;
    }
    public int getCurrentPlayer() {
        return currentPlayerIndex;
    }
    public boolean getSetup() {
        return setup;
    }

    public void sendState() {
        Map<String, String> modelState = gameModel.getBoardState();
        modelState.put("Turn", (currentPlayerIndex + 1) + "");
        modelState.put("playerCount", numPlayers + "");
        modelState.put("Phase", phase + " " + setup);
        modelState.put("LongestRoadPlayer", (longestRoadPlayerIndex + 1) + "");
        modelState.put("largestArmyPlayer", (largestArmyPlayerIndex + 1) + "");
        System.out.println(modelState.get("Terrains"));
        System.out.println(modelState.get("SettlementLocations"));
//        System.out.println(modelState.get("Turn"));
//        System.out.println(modelState.get("Phase"));
        System.out.println(modelState.get("DevCards"));
        System.out.println(modelState.get("Hands"));
        gui.update(modelState);
    }

    public int rollDice() {
       return gameModel.rollDice();
    }

    public List<String> getBuyableItems(int playerIndex) {
        return gameModel.checkOptionsToBuy(playerIndex);
    }

    public boolean checkSetup() {
        return setup;
    }

    public void moveRobber(int locID) {
        gameModel.moveRobber(locID);
    }
    public void getRandomCard(int stolenPlayer) {
        gameModel.sendRandomResource(currentPlayerIndex, stolenPlayer - 1);
    }
    public Map<String, Integer> getComponents() {
        return new HashMap<>(components);
    }
    public void stealAllResources(int resourceID) {
        Resource resource;
        switch (resourceID) {
            case 0:
                resource = Resource.LUMBER;
                break;
            case 1:
                resource = Resource.WHEAT;
                break;
            case 2:
                resource = Resource.ORE;
                break;
            case 3:
                resource = Resource.BRICK;
                break;
            default:
                resource = Resource.WOOL;
        }
        gameModel.stealAll(currentPlayerIndex, resource);
    }

    public void addRoad(int roadID) {
        if (gameModel.addRoad(currentPlayerIndex, roadID / 1000000,
                (roadID / 10000) % 100, (roadID / 100) % 100,
                (roadID / 10000) % 100, (roadID / 100) % 100,
                roadID % 100)) {
            List<Integer> roadLengths = gameModel.getRoadLengths();
            int maxInd = longestRoadPlayerIndex;
            if (longestRoadPlayerIndex == -1) {
                maxInd = 0;
            }
            for (int i = 0; i < roadLengths.size(); i++) {
                if (roadLengths.get(i) > roadLengths.get(maxInd)) {
                    maxInd = i;
                }
            }
            if (maxInd != longestRoadPlayerIndex
                    && roadLengths.get(maxInd) >= 5) {
                if (longestRoadPlayerIndex != -1) {
                    gameModel.changeVictoryPoints(longestRoadPlayerIndex, -2);
                }
                gameModel.changeVictoryPoints(maxInd, 2);
                longestRoadPlayerIndex = maxInd;
            }
        }
    }
    public void addSettlement(int settlementID) {
        if (gameModel.addSettlement(currentPlayerIndex, settlementID / 10000,
                (settlementID / 100) % 100, settlementID % 100)) {
            gameModel.changeVictoryPoints(currentPlayerIndex, 1);
        }
    }
    public void addResource(int resourceID) {
        gameModel.playerTakeFromBank(currentPlayerIndex,
                Resource.getResourceList().get(resourceID), 1);
    }

    public List<List<Integer>> getPossibleStartingSettlements() {
        List<SettlementLocation> possibleSettlementLocations =
                gameModel.getPossibleStartingSettlements();
        List<List<Integer>> settlementLocations = new ArrayList<>();
        for (SettlementLocation sl: possibleSettlementLocations) {
            List<Integer> terrainNums = new ArrayList<>();
            List<Terrain> terrains = sl.getTerrains();
            for (int i = 0; i < terrains.size(); i++) {
                terrainNums.add(terrains.get(i).getLocID());
            }
            settlementLocations.add(terrainNums);
        }
        return settlementLocations;
    }


    public List<List<Integer>> getPossibleStartingRoads(
            int ter1, int ter2, int ter3) {
        List<Road> possibleRoadLocations =
                gameModel.getPossibleStartingRoads(ter1, ter2, ter3);
        List<List<Integer>> roadLocations = new ArrayList<>();
        for (Road r: possibleRoadLocations) {
            List<Integer> terrainNums = new ArrayList<>();
            for (SettlementLocation sl: r.getSettlements()) {
                List<Terrain> terrains = sl.getTerrains();
                for (int i = 0; i < terrains.size(); i++) {
                    terrainNums.add(terrains.get(i).getLocID());
                }
            }
            roadLocations.add(terrainNums);
        }
        return roadLocations;
    }

    public List<List<Integer>> getPossibleRoads() {
        Set<Road> possibleRoadLocations =
                gameModel.getPossibleRoads(currentPlayerIndex);
        List<List<Integer>> roadLocations = new ArrayList<>();
        for (Road r: possibleRoadLocations) {
            List<Integer> terrainNums = new ArrayList<>();
            for (SettlementLocation sl: r.getSettlements()) {
                List<Terrain> terrains = sl.getTerrains();
                for (int i = 0; i < terrains.size(); i++) {
                    terrainNums.add(terrains.get(i).getLocID());
                }
            }
            roadLocations.add(terrainNums);
        }
        return roadLocations;
    }

    public List<List<Integer>> getPossibleSettlements() {
        Set<SettlementLocation> possibleSettlementLocations =
                gameModel.getPlaceableSettlements(currentPlayerIndex);
        List<List<Integer>> settlementLocations = new ArrayList<>();
        for (SettlementLocation sl: possibleSettlementLocations) {
            List<Integer> terrainNums = new ArrayList<>();
            List<Terrain> terrains = sl.getTerrains();
            for (int i = 0; i < terrains.size(); i++) {
                terrainNums.add(terrains.get(i).getLocID());
            }
            settlementLocations.add(terrainNums);
        }
        return settlementLocations;
    }
    public void playDevelopmentCard(int index) {
        currentCard = gameModel.getDevelopmentCard(currentPlayerIndex, index);
        componentsNeeded = currentCard.getRequiredComponents();
    }

    public String getNextNeededComponent() {
        if (components.size() > 0) {
            String next = componentsNeeded.get(0);
            componentsNeeded.remove(0);
            return next;
        } else {
            currentCard.useCard(this);
            List<Integer> armySizes = gameModel.getArmySizes();
            int maxInd = largestArmyPlayerIndex;
            if (largestArmyPlayerIndex == -1) {
                maxInd = 0;
            }
            for (int i = 0; i < armySizes.size(); i++) {
                if (armySizes.get(i) > armySizes.get(maxInd)) {
                    maxInd = i;
                }
            }
            if (maxInd != largestArmyPlayerIndex
                    && armySizes.get(maxInd) >= 5) {
                if (largestArmyPlayerIndex != -1) {
                    gameModel.changeVictoryPoints(largestArmyPlayerIndex, -2);
                }
                gameModel.changeVictoryPoints(maxInd, 2);
                largestArmyPlayerIndex = maxInd;
            }
            return "";
        }
    }

    public void addComponent(String type, int value) {
        components.put(type, value);
    }
    public void addDevelopmentCard() {
        gameModel.addDevelopmentCard(currentPlayerIndex);
    }

    public void upgrade(int ter1, int ter2, int ter3) {
        if (gameModel.turnToCity(currentPlayerIndex, ter1, ter2, ter3)) {
            gameModel.changeVictoryPoints(currentPlayerIndex, 1);
        }
    }

    public void tradeResources(int playerChosen,
                                Map<Integer, Integer> resourcesTraded,
                               Map<Integer, Integer> resourcesTradedFor) {
        Map<Resource, Integer> traded = new HashMap<>();
        for (Entry<Integer, Integer> e
        : resourcesTraded.entrySet()) {
            Resource resource;
            switch (e.getKey()) {
                case 0:
                    resource = Resource.LUMBER;
                    break;
                case 1:
                    resource = Resource.WHEAT;
                    break;
                case 2:
                    resource = Resource.ORE;
                    break;
                case 3:
                    resource = Resource.BRICK;
                    break;
                default:
                    resource = Resource.WOOL;
            }
            traded.put(resource, e.getValue());
        }

        Map<Resource, Integer> tradedFor = new HashMap<>();
        for (Entry<Integer, Integer> e: resourcesTradedFor.entrySet()) {
            Resource resource;
            switch (e.getKey()) {
                case 0:
                    resource = Resource.LUMBER;
                    break;
                case 1:
                    resource = Resource.WHEAT;
                    break;
                case 2:
                    resource = Resource.ORE;
                    break;
                case 3:
                    resource = Resource.BRICK;
                    break;
                default:
                    resource = Resource.WOOL;
            }
            tradedFor.put(resource, e.getValue());
        }
        gameModel.tradeResources(currentPlayerIndex,
        playerChosen - 1, traded, tradedFor);
    }

    public void maritimeTradeResources(int firstChosen,
                              int secondChosen) {
        Resource resource;
        switch (firstChosen) {
            case 0:
                resource = Resource.LUMBER;
                break;
            case 1:
                resource = Resource.WHEAT;
                break;
            case 2:
                resource = Resource.ORE;
                break;
            case 3:
                resource = Resource.BRICK;
                break;
            default:
                resource = Resource.WOOL;
        }
        Resource resource2;
        String c;
        switch (secondChosen) {
            case 0:
                resource2 = Resource.LUMBER;
                c = "L";
                break;
            case 1:
                resource2 = Resource.WHEAT;
                c = "H";
                break;
            case 2:
                resource2 = Resource.ORE;
                c = "O";
                break;
            case 3:
                resource2 = Resource.BRICK;
                c = "B";
                break;
            default:
                resource2 = Resource.WOOL;
                c = "W";
        }
        String harborString = gameModel.getHarborString(currentPlayerIndex);
        int numResources = 4;
        if (harborString.contains(c)) {
            numResources = 2;
        } else if (harborString.contains("/")) {
            numResources = 3;
        }
        gameModel.maritimeTradeResources(currentPlayerIndex,
        numResources, resource, resource2);
    }

}
