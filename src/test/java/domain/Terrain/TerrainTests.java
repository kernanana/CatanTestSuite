package domain.Terrain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TerrainTests {
    @Test
    public void Test_InitialDesert_hasRobber() {
        Terrain terrain = new Terrain(TerrainTypes.DESERT);
        Assertions.assertTrue(terrain.hasRobber());

    }

    @Test
    public void Test_InitialMountain_hasRobber() {
        Terrain terrain = new Terrain((TerrainTypes.MOUNTAIN));
        Assertions.assertFalse(terrain.hasRobber());
    }

    @Test
    public void Test_InitialField_hasRobber() {
        Terrain terrain = new Terrain((TerrainTypes.FIELD));
        Assertions.assertFalse(terrain.hasRobber());
    }

    @Test
    public void Test_InitialPasture_hasRobber() {
        Terrain terrain = new Terrain((TerrainTypes.PASTURE));
        Assertions.assertFalse(terrain.hasRobber());
    }

    @Test
    public void Test_InitialForest_hasRobber() {
        Terrain terrain = new Terrain((TerrainTypes.FOREST));
        Assertions.assertFalse(terrain.hasRobber());
    }

    @Test
    public void Test_Zero_getLocID() {
        Terrain terrain = new Terrain(0, TerrainTypes.FOREST, 2);
        Assertions.assertEquals(0, terrain.getLocID());
    }

    @Test
    public void Test_NegativeOne_getLocID() {
        Terrain terrain = new Terrain(-1, TerrainTypes.FOREST, 2);
        Assertions.assertEquals(-1, terrain.getLocID());
    }

    @Test
    public void Test_Max_getLocID() {
        Terrain terrain = new Terrain(63, TerrainTypes.FOREST, 2);
        Assertions.assertEquals(63, terrain.getLocID());
    }

    @Test
    public void Test_MaxPlusOne_getLocID() {
        Terrain terrain = new Terrain(64, TerrainTypes.FOREST, 2);
        Assertions.assertEquals(64, terrain.getLocID());
    }

    @Test
    public void Test_Zero_getRollNumber() {
        Terrain terrain = new Terrain(12, TerrainTypes.FOREST, 0);
        Assertions.assertEquals(0, terrain.getRollNumber());
    }

    @Test
    public void Test_NegativeOne_getRollNumber() {
        Terrain terrain = new Terrain(12, TerrainTypes.FOREST, -1);
        Assertions.assertEquals(-1, terrain.getRollNumber());
    }

    @Test
    public void Test_Twelve_getRollNumber() {
        Terrain terrain = new Terrain(12, TerrainTypes.FOREST, 12);
        Assertions.assertEquals(12, terrain.getRollNumber());
    }

    @Test
    public void Test_Thirteen_getRollNumber() {
        Terrain terrain = new Terrain(12, TerrainTypes.FOREST, 13);
        Assertions.assertEquals(13, terrain.getRollNumber());
    }

    @Test
    public void Test_Zero_setLocID() {
        Terrain terrain = new Terrain(20, TerrainTypes.FOREST, 2);
        terrain.setLocID(0);
        Assertions.assertEquals(0, terrain.getLocID());
    }

    @Test
    public void Test_NegativeOne_setLocID() {
        Terrain terrain = new Terrain(20, TerrainTypes.FOREST, 2);
        terrain.setLocID(-1);
        Assertions.assertEquals(-1, terrain.getLocID());
    }

    @Test
    public void Test_Max_setLocID() {
        Terrain terrain = new Terrain(62, TerrainTypes.FOREST, 2);
        terrain.setLocID(63);
        Assertions.assertEquals(63, terrain.getLocID());
    }

    @Test
    public void Test_MaxPlusOne_setLocID() {
        Terrain terrain = new Terrain(60, TerrainTypes.FOREST, 2);
        terrain.setLocID(64);
        Assertions.assertEquals(64, terrain.getLocID());
    }
}
