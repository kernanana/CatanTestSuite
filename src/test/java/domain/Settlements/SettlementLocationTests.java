package domain.Settlements;


import domain.Resource;
import domain.Terrain.TerrainTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.easymock.EasyMock;

import domain.Roads.Road;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Terrain.Terrain;

public class SettlementLocationTests {




//    @Test
//    public void Test_toString_correctName() {
//        String expected = "City";
//        SettlementLocation c = new SettlementLocation();
//        String actual = c.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void Test_toString_emptyString() {
//        String notExpected = "";
//        SettlementLocation c = new SettlementLocation();
//        String actual = c.toString();
//        Assertions.assertNotEquals(notExpected, actual);
//    }
//
//    @Test
//    public void Test_toString_wrongName() {
//        String notExpected = "Default Settlement";
//        SettlementLocation c = new SettlementLocation();
//        String actual = c.toString();
//        Assertions.assertNotEquals(notExpected, actual);
//    }

    @Test
    public void Test_getMultiplierCity_return2() {
        int expected = 2;
        SettlementLocation c = new SettlementLocation();
        c.convertToCity();
        int actual = c.getMultiplier();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void Test_getMultiplierCity_notReturn1() {
        int notExpected = 1;
        SettlementLocation c = new SettlementLocation();
        c.convertToCity();
        int actual = c.getMultiplier();
        Assertions.assertNotEquals(notExpected, actual);
    }

    @Test
    public void Test_getMultiplierCity_notReturn3() {
        int notExpected = 3;
        SettlementLocation c = new SettlementLocation();
        c.convertToCity();
        int actual = c.getMultiplier();
        Assertions.assertNotEquals(notExpected, actual);
    }

    @Test
    public void TestOwnedbyP1_getOwner_Return1(){
        int expected = 1;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestUnowned_getOwner_Return1(){
        int expected = 1;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void TestOwnedbyP2_getOwner_Return2(){
        int expected = 2;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestOwnedbyP3_getOwner_Return3(){
        int expected = 3;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestOwnedbyP4_getOwner_Return4(){
        int expected = 4;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }


//        @Test
//        public void Test_toString_correctName() {
//            String expected = "Default Settlement";
//            SettlementLocation ds = new SettlementLocation();
//            Assertions.assertEquals(ds.toString(), expected);
//        }
//
//        @Test
//        public void Test_toString_emptyString() {
//            String emptyString = "";
//            SettlementLocation ds = new DefaultSettlement();
//            Assertions.assertNotEquals(ds.toString(), emptyString);
//        }
//
//        @Test
//        public void Test_toString_wrongName() {
//            String wrongName = "SettlementLocation";
//            SettlementLocation ds = new DefaultSettlement();
//            Assertions.assertNotEquals(ds.toString(), wrongName);
//        }

    @Test
    public void Test_getMultiplierDefault_return1() {
        int expected = 1;
        SettlementLocation ds = new SettlementLocation();
        int actual = ds.getMultiplier();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test_getMultiplierDefault_notReturnNeg1() {
        int notExpected = -1;
        SettlementLocation ds = new SettlementLocation();
        int actual = ds.getMultiplier();
        Assertions.assertNotEquals(notExpected, actual);
    }

    @Test
    public void Test_getMultiplierDefault_notReturn0() {
        int notExpected = 0;
        SettlementLocation ds = new SettlementLocation();
        int actual = ds.getMultiplier();
        Assertions.assertNotEquals(notExpected, actual);
    }

    @Test
    public void Test_getMultiplierDefault_notReturn2() {
        int notExpected = 2;
        SettlementLocation ds = new SettlementLocation();
        int actual = ds.getMultiplier();
        Assertions.assertNotEquals(notExpected, actual);
    }

    @Test
    public void TestDefaultSettlement_getOwner_Return0(){
        int expected = 0;
        SettlementLocation ds = new SettlementLocation();
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementOwnedbyP1_getOwner_Return1(){
        int expected = 1;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementOwnedbyP2_getOwner_Return2(){
        int expected = 2;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementOwnedbyP3_getOwner_Return3(){
        int expected = 3;
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(expected);
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementUnowned_addOwnerWithParam0_isTrue(){
        int expected = 0;
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertTrue(ds.setOwner(expected));
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementUnowned_addOwnerWithParam1_isTrue(){
        int expected = 1;
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertTrue(ds.setOwner(expected));
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementUnowned_addOwnerWithParam2_isTrue(){
        int expected = 2;
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertTrue(ds.setOwner(expected));
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementUnowned_addOwnerWithParam3_isTrue(){
        int expected = 3;
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertTrue(ds.setOwner(expected));
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementWhenOwned_addOwner_throwsException(){
        SettlementLocation ds = new SettlementLocation();
        ds.setOwner(1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            ds.setOwner(2);}, "This settlement is already owned");
    }

    @Test
    public void TestDefaultSettlementWhenUnowned_addOwner4_expectOwner4(){
        int expected = 4;
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertTrue(ds.setOwner(expected));
        int actual = ds.getOwner();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestDefaultSettlementWhenUnowned_addOwnerNegOne_throwsException(){
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            ds.setOwner(-1);}, "Only valid playerIDs are 0-3");
    }

    @Test
    public void TestDefaultSettlementFirstRoadNull_getRoads_FirstRoadNull(){
        List<Road> roads = new ArrayList<>();
        roads.add(null);
        roads.add(EasyMock.createMock(Road.class));
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>(), roads);
        List<Road> roadsAccessed = ds.getRoads();
        Assertions.assertNull(roadsAccessed.get(0));
        Assertions.assertEquals(2,roadsAccessed.size());
    }

    @Test
    public void TestDefaultSettlement_setOwner5_ReturnException() {
        SettlementLocation ds = new SettlementLocation();
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            ds.setOwner(5);}, "Only valid playerIDs are 0-3");
    }


    @Test
    public void TestDefaultSettlementSecondRoadNull_getRoads_SecondRoadNull(){
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(null);
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>(), roads);
        List<Road> roadsAccessed = ds.getRoads();
        Assertions.assertNull(roadsAccessed.get(1));
        Assertions.assertEquals(2,roadsAccessed.size());
    }

    @Test
    public void TestDefaultSettlementBothRoadsNull_getRoads_BothRoadsNull(){
        List<Road> roads = new ArrayList<>();
        roads.add(null);
        roads.add(null);
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>(), roads);
        List<Road> roadsAccessed = ds.getRoads();
        Assertions.assertNull(roadsAccessed.get(0));
        Assertions.assertNull(roadsAccessed.get(1));
        Assertions.assertEquals(2,roadsAccessed.size());
    }

    @Test
    public void TestDefaultSettlementRoadsDefined_getRoads_RoadsDefined(){
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>(), roads);
        List<Road> roadsAccessed = ds.getRoads();
        Assertions.assertEquals(2,roadsAccessed.size());
    }

    @Test
    public void TestDefaultSettlementTerrainsDefined_getTerrains_TerrainsDefined(){
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        SettlementLocation ds = new SettlementLocation(terrains, new ArrayList<Road>());
        List<Terrain> terrainsAccessed = ds.getTerrains();
        Assertions.assertEquals(3,terrainsAccessed.size());
    }

    @Test
    public void TestDefaultSettlementFirstTerrainNull_getTerrains_FirstTerrainNull(){
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(null);
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        SettlementLocation ds = new SettlementLocation(terrains, new ArrayList<Road>());
        List<Terrain> terrainsAccessed = ds.getTerrains();
        Assertions.assertNull(terrainsAccessed.get(0));
        Assertions.assertEquals(3,terrainsAccessed.size());
    }

    @Test
    public void TestDefaultSettlementSecondTerrainNull_getTerrains_SecondTerrainNull(){
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(null);
        terrains.add(EasyMock.createMock(Terrain.class));
        SettlementLocation ds = new SettlementLocation(terrains, new ArrayList<Road>());
        List<Terrain> terrainsAccessed = ds.getTerrains();
        Assertions.assertNull(terrainsAccessed.get(1));
        Assertions.assertEquals(3,terrainsAccessed.size());
    }

    @Test
    public void TestDefaultSettlementThirdTerrainNull_getTerrains_ThirdTerrainNull(){
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(null);
        SettlementLocation ds = new SettlementLocation(terrains, new ArrayList<Road>());
        List<Terrain> terrainsAccessed = ds.getTerrains();
        Assertions.assertNull(terrainsAccessed.get(2));
        Assertions.assertEquals(3,terrainsAccessed.size());
    }

    @Test
    public void TestRoadNull_addRoad_Exception(){
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>());
        Exception e = Assertions.assertThrows(NullPointerException.class,
                () -> {ds.addRoad(null);}, "NullPointerException" +
                        "should be thrown");
        Assertions.assertEquals("Null Road cannot be added", e.getMessage());
    }

    @Test
    public void TestNoRoads_addRoad_True(){
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>());
        Road road = EasyMock.createMock(Road.class);
        Assertions.assertTrue(ds.addRoad(road));
    }

    @Test
    public void TestOneRoad_addRoad_True(){
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>());
        Road road1 = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        ds.addRoad(road1);
        Assertions.assertTrue(ds.addRoad(road2));
    }

    @Test
    public void TestTwoRoads_addRoad_True(){
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>());
        Road road1 = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        Road road3 = EasyMock.createMock(Road.class);
        ds.addRoad(road1);
        ds.addRoad(road2);
        Assertions.assertTrue(ds.addRoad(road3));
    }

    @Test
    public void TestThreeRoads_addRoad_False(){
        SettlementLocation ds = new SettlementLocation(new ArrayList<Terrain>());
        Road road1 = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        Road road3 = EasyMock.createMock(Road.class);
        Road road4 = EasyMock.createMock(Road.class);
        ds.addRoad(road1);
        ds.addRoad(road2);
        ds.addRoad(road3);
        Assertions.assertFalse(ds.addRoad(road4));
    }

    @Test
    public void TestgetResourceAmountGainedFromRollNumber_RelevantRollNum_gain1Resrouce(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 1);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        List<Terrain> terrains = new ArrayList<>();
        Terrain irrelevantTerrain = EasyMock.createMock(Terrain.class);
        Terrain mockTerrainWithRelevantRoll = EasyMock.createMock(Terrain.class);
        terrains.add(irrelevantTerrain);
        terrains.add(irrelevantTerrain);
        terrains.add(mockTerrainWithRelevantRoll);

        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(5);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(4);
        EasyMock.expect(mockTerrainWithRelevantRoll.getRollNumber()).andReturn(1);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.hasRobber()).andReturn(false);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.replay(irrelevantTerrain, mockTerrainWithRelevantRoll);

        SettlementLocation sl = new SettlementLocation(terrains);
        Map<Resource, Integer> actual = sl.getResourceAmountGainedFromRollNumber(1);
        Assertions.assertEquals(expected,actual);

        EasyMock.verify(irrelevantTerrain, mockTerrainWithRelevantRoll);
    }

    @Test
    public void TestgetResourceAmountGainedFromRollNumber_NotOnTerrain_gainNothing(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 0);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        List<Terrain> terrains = new ArrayList<>();
        Terrain irrelevantTerrain = EasyMock.createMock(Terrain.class);
        for (int i = 0; i < 3; i++) {
            terrains.add(irrelevantTerrain);
        }

        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(5);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(4);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(3);
        EasyMock.replay(irrelevantTerrain);

        SettlementLocation sl = new SettlementLocation(terrains);
        Map<Resource, Integer> actual = sl.getResourceAmountGainedFromRollNumber(1);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void TestgetResourceAmountGainedFromRollNumber_RelevantRollNumOnCity_Gain2Resource(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 2);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        List<Terrain> terrains = new ArrayList<>();
        Terrain irrelevantTerrain = EasyMock.createMock(Terrain.class);
        Terrain mockTerrainWithRelevantRoll = EasyMock.createMock(Terrain.class);
        terrains.add(irrelevantTerrain);
        terrains.add(irrelevantTerrain);
        terrains.add(mockTerrainWithRelevantRoll);

        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(5);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(4);
        EasyMock.expect(mockTerrainWithRelevantRoll.getRollNumber()).andReturn(1);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.hasRobber()).andReturn(false);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);

        EasyMock.replay(irrelevantTerrain, mockTerrainWithRelevantRoll);

        SettlementLocation sl = new SettlementLocation(terrains);
        sl.convertToCity();
        Map<Resource, Integer> actual = sl.getResourceAmountGainedFromRollNumber(1);
        Assertions.assertEquals(expected,actual);

        EasyMock.verify(irrelevantTerrain, mockTerrainWithRelevantRoll);
    }

    @Test
    public void TestgetResourceAmountGainedFromRollNumber_RelevantRollNumOnDesert_GainNothing(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 0);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        List<Terrain> terrains = new ArrayList<>();
        Terrain irrelevantTerrain = EasyMock.createMock(Terrain.class);
        Terrain mockTerrainWithRelevantRoll = EasyMock.createMock(Terrain.class);
        terrains.add(mockTerrainWithRelevantRoll);
        terrains.add(irrelevantTerrain);
        terrains.add(irrelevantTerrain);


        EasyMock.expect(mockTerrainWithRelevantRoll.getRollNumber()).andReturn(5);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.DESERT);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(4);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(1);

        EasyMock.replay(irrelevantTerrain, mockTerrainWithRelevantRoll);

        SettlementLocation sl = new SettlementLocation(terrains);
        sl.convertToCity();
        Map<Resource, Integer> actual = sl.getResourceAmountGainedFromRollNumber(5);
        Assertions.assertEquals(expected,actual);

        EasyMock.verify(irrelevantTerrain, mockTerrainWithRelevantRoll);
    }

    @Test
    public void TestgetResourceAmountGainedFromRollNumber_RelevantRollNumWithRobber_gainNothing(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 0);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        List<Terrain> terrains = new ArrayList<>();
        Terrain irrelevantTerrain = EasyMock.createMock(Terrain.class);
        Terrain mockTerrainWithRelevantRoll = EasyMock.createMock(Terrain.class);
        terrains.add(irrelevantTerrain);
        terrains.add(irrelevantTerrain);
        terrains.add(mockTerrainWithRelevantRoll);

        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(5);
        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(4);
        EasyMock.expect(mockTerrainWithRelevantRoll.getRollNumber()).andReturn(1);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.hasRobber()).andReturn(true);
        EasyMock.replay(irrelevantTerrain, mockTerrainWithRelevantRoll);

        SettlementLocation sl = new SettlementLocation(terrains);
        Map<Resource, Integer> actual = sl.getResourceAmountGainedFromRollNumber(1);
        Assertions.assertEquals(expected,actual);

        EasyMock.verify(irrelevantTerrain, mockTerrainWithRelevantRoll);
    }

    @Test
    public void TestgetResourceAmountGainedFromRollNumber_RelevantRollNumWithTwoTerrains_gain2DiffResources(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 1);
        expected.put(Resource.ORE, 1);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        List<Terrain> terrains = new ArrayList<>();
        Terrain irrelevantTerrain = EasyMock.createMock(Terrain.class);
        Terrain mockTerrainWithRelevantRoll = EasyMock.createMock(Terrain.class);
        terrains.add(irrelevantTerrain);
        terrains.add(mockTerrainWithRelevantRoll);
        terrains.add(mockTerrainWithRelevantRoll);

        EasyMock.expect(irrelevantTerrain.getRollNumber()).andReturn(7);
        EasyMock.expect(mockTerrainWithRelevantRoll.getRollNumber()).andReturn(5);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.hasRobber()).andReturn(false);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(mockTerrainWithRelevantRoll.getRollNumber()).andReturn(5);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.MOUNTAIN);
        EasyMock.expect(mockTerrainWithRelevantRoll.hasRobber()).andReturn(false);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.MOUNTAIN);
        EasyMock.expect(mockTerrainWithRelevantRoll.getType()).andReturn(TerrainTypes.MOUNTAIN);
        EasyMock.replay(irrelevantTerrain, mockTerrainWithRelevantRoll);

        SettlementLocation sl = new SettlementLocation(terrains);
        Map<Resource, Integer> actual = sl.getResourceAmountGainedFromRollNumber(5);
        Assertions.assertEquals(expected,actual);

        EasyMock.verify(irrelevantTerrain, mockTerrainWithRelevantRoll);
    }
}
