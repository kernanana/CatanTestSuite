package domain.Settlements;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Resource;
import domain.Terrain.Terrain;
import domain.Roads.Road;
import domain.Terrain.TerrainTypes;

public class SettlementLocation {
    protected int ownerID;
    private List<Terrain> terrains;
    private List<Road> roads;
    private int multiplier;
    SettlementLocation() {
        ownerID = 0;
        multiplier = 1;
        terrains = new ArrayList<>();
    }

    SettlementLocation(List<Terrain> terrains, List<Road> roads) {
        ownerID = 0;
        this.terrains = new ArrayList<>(terrains);
        this.roads = new ArrayList<>(roads);
        multiplier = 1;
    }
    public SettlementLocation(List<Terrain> terrains) {
        ownerID = 0;
        this.terrains = new ArrayList<>(terrains);
        this.roads = new ArrayList<>();
        multiplier = 1;
    }

    public void convertToCity() {
        this.multiplier = 2;
    }


    public int getMultiplier() {
        return multiplier;
    }

    public int getOwner() {
        return ownerID;
    }

    public boolean setOwner(int owner) {
        if (owner > 4) {
            throw new InvalidParameterException("Only valid playerIDs are 0-3");
        }

        if (owner < 0) {
            throw new InvalidParameterException("Only valid playerIDs are 0-3");
        }
        if (ownerID != 0) {
            throw new IllegalStateException("This settlement is already owned");
        }
        ownerID = owner;
        return true;
    }
    public List<Road> getRoads() {
        return new ArrayList<>(roads);
    }

    public List<Terrain> getTerrains() {
        return new ArrayList<>(terrains);
    }

    public boolean addRoad(Road road) {
        if (road == null) {
            throw new NullPointerException("Null Road cannot be added");
        }
        if (roads.size() >= 3) {
            return false;
        }
        roads.add(road);
        return true;
    }


    public Map<Resource, Integer> getResourceAmountGainedFromRollNumber(
            int rollNumber) {
        Map<Resource, Integer> quantity = new HashMap<>();
        quantity.put(Resource.LUMBER, 0);
        quantity.put(Resource.ORE, 0);
        quantity.put(Resource.BRICK, 0);
        quantity.put(Resource.WOOL, 0);
        quantity.put(Resource.WHEAT, 0);
        for (int i = 0; i < terrains.size(); i++) {
            if (terrains.get(i).getRollNumber() == rollNumber) {
                if (terrains.get(i).getType() == TerrainTypes.DESERT
                        || terrains.get(i).hasRobber()) {
                    assert true;
                } else {
                    int currentAmount = quantity.get(
                            terrains.get(i).getType().getResource());
                    quantity.replace(terrains.get(i).getType().getResource(),
                            currentAmount + getMultiplier());
                }
            }
        }
        return quantity;
    }
}
