package domain.Terrain;

public class Terrain {
    public final TerrainTypes type;
    private int locID;
    private int rollNumber;

    Terrain(TerrainTypes type) {
        this.type = type;
    }

    public Terrain(int locID, TerrainTypes type, int rollNumber) {
        this.locID = locID;
        this.type = type;
        this.rollNumber = rollNumber;
    }

    public boolean hasRobber() {
        if (TerrainTypes.DESERT == type) {
            return true;
        }
        return false;
    }

    public void setRobberState(boolean state) {
    }

    public int getLocID() {
        return locID;
    }

    public void setLocID(int locID) {
        this.locID = locID;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public TerrainTypes getType() {
        return type;
    }
}
