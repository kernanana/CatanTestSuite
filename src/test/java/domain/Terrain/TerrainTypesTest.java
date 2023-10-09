package domain.Terrain;

import domain.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TerrainTypesTest {
    @Test
    public void testGetResourceMountain_Ore() {
        Assertions.assertEquals(TerrainTypes.MOUNTAIN.getResource(), Resource.ORE);
    }

    @Test
    public void testGetResourceForest_Lumber() {
        Assertions.assertEquals(TerrainTypes.FOREST.getResource(), Resource.LUMBER);
    }

    @Test
    public void testGetResourceHills_Brick() {
        Assertions.assertEquals(TerrainTypes.HILLS.getResource(), Resource.BRICK);
    }

    @Test
    public void testGetResourcePasture_Wool() {
        Assertions.assertEquals(TerrainTypes.PASTURE.getResource(), Resource.WOOL);
    }

    @Test
    public void testGetResourceField_Wheat() {
        Assertions.assertEquals(TerrainTypes.FIELD.getResource(), Resource.WHEAT);
    }
    @Test
    public void testGetResourceDesert_Null() {
        Assertions.assertEquals(TerrainTypes.DESERT.getResource(), null);
    }

    @Test
    public void testToStringMountain_Mountain() {
        Assertions.assertEquals(TerrainTypes.MOUNTAIN.toString(), "Mountain");
    }
    @Test
    public void testToStringField_Field() {
        Assertions.assertEquals(TerrainTypes.FIELD.toString(), "Field");
    }
    @Test
    public void testToStringHills_Hills() {
        Assertions.assertEquals(TerrainTypes.HILLS.toString(), "Hills");
    }
    @Test
    public void testToStringPasture_Pasture() {
        Assertions.assertEquals(TerrainTypes.PASTURE.toString(), "Pasture");
    }
    @Test
    public void testToStringForest_Forest() {
        Assertions.assertEquals(TerrainTypes.FOREST.toString(), "Forest");
    }
    @Test
    public void testToStringDesert_Desert() {
        Assertions.assertEquals(TerrainTypes.DESERT.toString(), "Desert");
    }
}
