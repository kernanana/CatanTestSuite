package domain.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import domain.DevelopmentCards.DevelopmentCard;
import domain.Resource;
import domain.Roads.Road;
import domain.Settlements.SettlementLocation;

public class Player {

    private int playerID;
    private Map<Resource, Integer> resources;
    private int cityCount;
    private List<DevelopmentCard> developmentCards;
    private int victoryPoints;
    private List<SettlementLocation> settlementLocations;
    private List<Road> roads;
    private int knightsPlayed;
    private String harborString;

    public Player(int playerID) {
        this.playerID = playerID;
        resources = new HashMap<Resource, Integer>();
        victoryPoints = 0;
        settlementLocations = new ArrayList<>();
        roads = new ArrayList<>();
        knightsPlayed = 0;
        harborString = "";
        cityCount = 0;
        developmentCards = new ArrayList<>();
//        developmentCards.add(new Knight("Knight"));
//        developmentCards.add(new Monopoly("Monopoly"));
//        developmentCards.add(new RoadBuilding("Road Building"));
//        developmentCards.add(new VictoryPoint("Victory Point"));
//        developmentCards.add(new YearofPlenty("Year of Plenty"));
    }

    Player(Road road, SettlementLocation settlementLocation) {
        roads = new ArrayList<>();
        settlementLocations = new ArrayList<>();
        road.addSettlement(settlementLocation);
        settlementLocations.add(settlementLocation);
        roads.add(road);
        playerID = 1;
        knightsPlayed = 0;
    }

    Player(List<Road> roads, SettlementLocation s1, SettlementLocation s2) {
        this.roads = roads;
        settlementLocations = new ArrayList<>();
        settlementLocations.add(s1);
        settlementLocations.add(s2);
    }

    Player(ArrayList<Road> roads, SettlementLocation s1,
           SettlementLocation s2, SettlementLocation s3) {
        this.roads = roads;
        settlementLocations = new ArrayList<>();
        settlementLocations.add(s1);
        settlementLocations.add(s2);
        settlementLocations.add(s3);
    }

    Player(List<DevelopmentCard> developmentCards) {
        this.developmentCards = developmentCards;
    }


    public boolean addResources(Resource terrain, int quantity) {

        if (quantity <= 0) {
            return false;
        } else {
            if (resources.containsKey(terrain)) {
                resources.put(terrain, resources.get(terrain) + quantity);
            } else {
                resources.put(terrain, quantity);
            }
            return true;
        }
    }

    public int addVictoryPoints(int quantity) {
        if (quantity < 1 || quantity > 11) {
            throw new IllegalArgumentException(
            "Quantity must be greater than 0 and less than 12");
        }

        victoryPoints += quantity;
        return victoryPoints;
    }

    public boolean checkWinCondition() {
        if (victoryPoints >= 10) {
            return true;
        }
        return false;
    }

    public int getResourceAmount(Resource resource) {
        if (resources.containsKey(resource)) {
            return resources.get(resource);
        }
        return 0;
    }

    public boolean removeResources(Resource resource, int quantity) {
        if (this.getResourceAmount(resource) == 0) {
            return false;
        } else if (quantity <= 0) {
            return false;
        } else {
            resources.put(resource, resources.get(resource) - quantity);
            return true;
        }
    }

    public int getHandSize() {
        int result = 0;

        for (Map.Entry<Resource, Integer> resource : resources.entrySet()) {
            result += resource.getValue();
        }

        return result;
    }

    public boolean removeVictoryPoints(int quantity) {
        if (victoryPoints - quantity > -1) {
            if (quantity > 0) {
                victoryPoints -= quantity;
                return true;
            }
        }
        return false;
    }

    public Integer getVictoryPoints() {
        return victoryPoints;
    }

    public Set<SettlementLocation> getPossibleSettlementLocations() {
        if (settlementLocations.size() < 2 || settlementLocations.size() > 4) {
            throw new
            IllegalStateException("Player does not have enough settlements");
        }

        Set<SettlementLocation> checkedSettlementLocations = new HashSet<>();
        Set<SettlementLocation> possibleSettlementLocations = new HashSet<>();

        for (Road road : roads) {
            for (SettlementLocation settlementLocation
            : road.getSettlements()) {
                if (!checkedSettlementLocations.contains(settlementLocation)
                && settlementLocation.getOwner() == 0) {
                    if (checkIfSettlementLocationIsPossible(
                        settlementLocation)) {
                        possibleSettlementLocations.add(settlementLocation);
                    }
                    checkedSettlementLocations.add(settlementLocation);
                }

            }
        }
        return possibleSettlementLocations;
    }

    private boolean checkIfSettlementLocationIsPossible(
        SettlementLocation settlementLocation) {
        for (Road road
        : settlementLocation.getRoads()) {

            for (SettlementLocation settlementLocations
            : road.getSettlements()) {
                if (settlementLocations == settlementLocation) {
                    continue;
                }

                if (settlementLocations.getOwner() != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<String> getBuyableItems() {
        List<String> buyableItems = new ArrayList<>();

        //Roads
        if (this.getResourceAmount(Resource.BRICK) >= 1
                && this.getResourceAmount(Resource.LUMBER) >= 1) {
            buyableItems.add("Road");
        }

        //Settlements
        if (this.getResourceAmount(Resource.BRICK) >= 1
                && this.getResourceAmount(Resource.LUMBER) >= 1
                && this.getResourceAmount(Resource.WHEAT) >= 1
                && this.getResourceAmount(Resource.WOOL) >= 1) {
            buyableItems.add("Settlement");
        }

        //Cities
        if (this.getResourceAmount(Resource.ORE) >= 3
                && this.getResourceAmount(Resource.WHEAT) >= 2) {
            buyableItems.add("City");
        }

        //Development Cards
        if (this.getResourceAmount(Resource.ORE) >= 1
                && this.getResourceAmount(Resource.WHEAT) >= 1
                && this.getResourceAmount(Resource.WOOL) >= 1) {
            buyableItems.add("Development Card");
        }

        return buyableItems;
    }


    public boolean addSettlement(SettlementLocation settlementLocation) {

        if (settlementLocation == null) {
            throw new NullPointerException("Settlement cannot be null");
        }

        if (settlementLocation.getOwner() == this.playerID) {
            cityCount++;
            settlementLocation.convertToCity();
            return true;
        }

        if (settlementLocation.getOwner() == 0) {
            settlementLocation.setOwner(this.playerID);
            settlementLocations.add(settlementLocation);
            return true;
        }

        return false;
    }

    public boolean addRoad(Road road) {
        if (road == null) {
            throw new NullPointerException("Road cannot be null");
        }

        if (road.getOwner() != 0) {
            return false;
        }

        for (SettlementLocation settlementLocation : settlementLocations) {
            if (road.getSettlements().contains(settlementLocation)) {
                road.setOwner(playerID);
                roads.add(road);
                return true;
            }
        }

        for (Road myRoad : roads) {
            List<SettlementLocation> roadSettlementLocations
            = new ArrayList<>(road.getSettlements());
            roadSettlementLocations.retainAll(myRoad.getSettlements());
            if (roadSettlementLocations.size() > 0
            && roadSettlementLocations.get(0).getOwner() == 0) {
                road.setOwner(playerID);
                roads.add(road);
                return true;
            }
        }

        return false;
    }

    public int getID() {
        return playerID;
    }

    public List<DevelopmentCard> getOwnedDevelopmentCards() {
        return new ArrayList<DevelopmentCard>(developmentCards);
    }

    public boolean addOneDevelopmentCard(DevelopmentCard dc) {
        boolean found = false;
        String dcname = dc.string();
        for (String name: DevelopmentCard.getNames()) {
            if (name.equals(dcname)) {
                found = true;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Not a valid Dev Card name");
        }
        developmentCards.add(dc);
        return true;
    }
    public int getArmySize() {
        return knightsPlayed;
    }
    public List<String> getHand() {
        List<String> cards = new ArrayList<>();
        for (DevelopmentCard dc: developmentCards) {
            cards.add(dc.string());
        }
        return cards;
    }

    public Set<Road> getPossibleRoadLocations() {
        if (roads.size() < 2 || roads.size() > 14) {
            throw new IllegalStateException("Invalid number of roads");
        }

        Set<Road> checkedRoads = new HashSet<>();
        Set<Road> possibleRoads = new HashSet<>();

        for (SettlementLocation settlementLocation : settlementLocations) {
            for (Road road : settlementLocation.getRoads()) {
                if (!checkedRoads.contains(road)
                && road.getOwner() == 0) {
                    possibleRoads.add(road);
                }
                checkedRoads.add(road);
            }
        }

        for (Road road : roads) {
            for (SettlementLocation settlementLocation
            : road.getSettlements()) {
                if (settlementLocation.getOwner() != 0) {
                    continue;
                }

                for (Road road2 : settlementLocation.getRoads()) {
                    if (!checkedRoads.contains(road2)
                    && road2.getOwner() == 0) {
                        possibleRoads.add(road2);
                    }
                    checkedRoads.add(road2);
                }
            }
        }

        return possibleRoads;
    }
    public void addHarbor(char harborChar) {
        harborString += harborChar;
    }
    public String getHarborString() {
        return harborString;
    }
    public Map<Resource, Integer> getResourceAmountGainedFromRollNumber(
            int rollNumber) {
        if (rollNumber <= 0) {
            throw new IllegalArgumentException("This is not a valid roll");
        }

        if (rollNumber > 12) {
            throw new IllegalArgumentException("This is not a valid roll");
        }
        Map<Resource, Integer> quantity = new HashMap<>();
        quantity.put(Resource.LUMBER, 0);
        quantity.put(Resource.ORE, 0);
        quantity.put(Resource.BRICK, 0);
        quantity.put(Resource.WOOL, 0);
        quantity.put(Resource.WHEAT, 0);
        for (int i = 0; i < settlementLocations.size(); i++) {
            Map<Resource, Integer> gainedQuantity = settlementLocations.get(i).
                    getResourceAmountGainedFromRollNumber(rollNumber);
            for (Map.Entry<Resource, Integer> entry: quantity.entrySet()) {
                int currentAmount = quantity.get(entry.getKey());
                quantity.replace(entry.getKey(),
                        currentAmount + gainedQuantity.get(entry.getKey()));
            }
        }
        return quantity;
    }

    private Set<Road> adjacentRoadsForPlayer(LinkedList<Road> path) {
        Set<Road> adjacentRoads = new HashSet<>();

        Road startingRoad = path.getLast();

        for (SettlementLocation settlementLocation
        : startingRoad.getSettlements()) {
            if (settlementLocation.getOwner() == playerID
            || settlementLocation.getOwner() == 0) {
                for (Road road : settlementLocation.getRoads()) {
                    if (road.getOwner() == playerID
                    && !path.contains(road)) {
                        adjacentRoads.add(road);
                    }
                }
            }
        }
        return adjacentRoads;
    }

    public int getRoadLength() {
        int longestRoad = 0;
        // Map<Road, Integer> roadLengths = new HashMap<>();

        Queue<LinkedList<Road>> roadsToCheck = new LinkedList<>();
        LinkedList<Road> list = new LinkedList<>();
        for (Road road : roads) {

            if (list.contains(road)) {
                continue;
            }
            list.clear();
            list.add(road);

            roadsToCheck.add(list);

            while (roadsToCheck.size() != 0) {

                list = roadsToCheck.poll();
                // Road currentRoad = list.getLast();

                Set<Road> adjRoads = adjacentRoadsForPlayer(list);

                if (adjRoads.size() == 0) {
                    if (list.size() >= 1 + longestRoad) {
                        longestRoad = list.size();
                    }
                } else {
                    for (Road adjRoad : adjRoads) {
                        LinkedList<Road> newList = new LinkedList<>(list);
                        newList.add(adjRoad);
                        roadsToCheck.add(newList);
                    }
                }
            }
        }

        return longestRoad;
    }
    public DevelopmentCard removeDevelopmentCard(int index) {
        DevelopmentCard card = developmentCards.get(index);
        String name = card.string();
        if (!name.equals("Victory Point")) {
            developmentCards.remove(index);
        }
        if (name.equals("Knight")) {
            knightsPlayed++;
        }
        return card;
    }

    public Set<SettlementLocation> getPossibleCityLocations() {
        if (cityCount > 3) {
            throw new IllegalStateException("Max amount of Cities reached");
        }

        Set<SettlementLocation> possibleCityLocations = new HashSet<>();

        for (SettlementLocation settlementLocation : settlementLocations) {
            if (settlementLocation.getMultiplier() == 1) {
                possibleCityLocations.add(settlementLocation);
            }
        }

        return possibleCityLocations;
    }
}
