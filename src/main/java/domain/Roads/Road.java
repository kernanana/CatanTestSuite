package domain.Roads;

//import domain.Terrain.Terrain;

//import java.util.ArrayList;
//import java.util.List;

import domain.Settlements.SettlementLocation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Road {
    //List<Terrain> terrains;
   private int ownerID;
   private List<SettlementLocation> settlements;
    public Road() {
        ownerID = 0;
        settlements = new ArrayList<>();
    }

    Road(SettlementLocation s1, SettlementLocation s2) {
        ownerID = 0;
        settlements = new ArrayList<>();
        settlements.add(s1);
        settlements.add(s2);
    }

    public int getOwner() {
        return ownerID;
    }

    public boolean setOwner(int playerID) {
        if (playerID > 4 || playerID < 0) {
            throw new InvalidParameterException("Player IDs can only be 0-3");
        }
        if (ownerID != 0) {
            throw new IllegalStateException("This road is already owned");
        }
        ownerID = playerID;
        return true;
    }

    public List<SettlementLocation> getSettlements() {
        return new ArrayList<>(settlements);
    }

    public boolean addSettlement(SettlementLocation settlement) {
        if (settlements.size() >= 2) {
            return false;
        }
        settlements.add(settlement);
        return true;
    }
}