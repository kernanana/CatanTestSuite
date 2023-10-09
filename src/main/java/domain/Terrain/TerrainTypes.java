package domain.Terrain;

import domain.Resource;

public enum TerrainTypes {
    MOUNTAIN, FIELD, PASTURE, FOREST, HILLS, DESERT, OCEAN;

    public Resource getResource() {
        switch (this) {
            case MOUNTAIN:
                return Resource.ORE;
            case FIELD:
                return Resource.WHEAT;
            case PASTURE:
                return Resource.WOOL;
            case FOREST:
                return Resource.LUMBER;
            case HILLS:
                return Resource.BRICK;
            default:
                return null;

        }
    }
    public String toString() {
        switch (this) {
            case MOUNTAIN:
                return "Mountain";
            case FIELD:
                return "Field";
            case HILLS:
                return "Hills";
            case PASTURE:
                return "Pasture";
            case FOREST:
                return "Forest";
            default:
                return "Desert";
        }
    }
}

