package domain.player;

import java.util.*;

import domain.DevelopmentCards.*;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.Resource;
import domain.Roads.Road;
import domain.Settlements.SettlementLocation;


public class PlayerTests {

    @Test
    public void test_addResources_withOreQuantityZero_expectFalse() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.ORE, 0);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_addResources_withMountainQuantityOne_expectTrue() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.ORE, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, player.getResourceAmount(Resource.ORE));
    }

    @Test
    public void test_addResources_withMountainMaxInteger_expectTrue() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.ORE, Integer.MAX_VALUE);
        Assertions.assertTrue(result);
        Assertions.assertEquals(Integer.MAX_VALUE, player.getResourceAmount(Resource.ORE));
    }

    @Test
    public void test_addResources_withOre_expectTrue() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.ORE, 3);
        Assertions.assertTrue(result);
        Assertions.assertEquals(3, player.getResourceAmount(Resource.ORE));
    }

    @Test
    public void test_addResources_withWheat_expectTrue() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.WHEAT, 3);
        Assertions.assertTrue(result);
        Assertions.assertEquals(3, player.getResourceAmount(Resource.WHEAT));
    }

    @Test
    public void test_addResources_withBrick_expectTrue() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.BRICK, 3);
        Assertions.assertTrue(result);
        Assertions.assertEquals(3, player.getResourceAmount(Resource.BRICK));
    }

    @Test
    public void test_addResources_multipleAddsToSameResource_expectTrue() {
        Player player = new Player(1);
        boolean result = player.addResources(Resource.ORE, 3);
        Assertions.assertTrue(result);
        result = player.addResources(Resource.ORE, 3);
        Assertions.assertTrue(result);
        result = player.addResources(Resource.ORE, 3);
        Assertions.assertTrue(result);
        Assertions.assertEquals(9, player.getResourceAmount(Resource.ORE));
    }

    @Test
    public void test_addVictoryPoints_withZero_expectZero() {
        Player player = new Player(1);
        String expected = "Quantity must be greater than 0 and less than 12";
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.addVictoryPoints(0);
        });
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_addVictoryPoints_withOne_expectOne() {
        Player player = new Player(1);
        int result = player.addVictoryPoints(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_addVictoryPoints_withEleven_expectEleven() {
        Player player = new Player(1);
        int result = player.addVictoryPoints(11);
        Assertions.assertEquals(11, result);
    }

    @Test
    public void test_addVictoryPoints_withTwelve_expectException() {
        Player player = new Player(1);
        String expected = "Quantity must be greater than 0 and less than 12";
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.addVictoryPoints(12);
        });
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_checkWinCondition_withNineVP_expectFalse() {
        Player player = new Player(1);
        player.addVictoryPoints(9);
        boolean result = player.checkWinCondition();
        Assertions.assertFalse(result);
    }

    @Test
    public void test_checkWinCondition_withTenVP_expectTrue() {
        Player player = new Player(1);
        player.addVictoryPoints(10);
        boolean result = player.checkWinCondition();
        Assertions.assertTrue(result);
    }

    @Test
    public void test_checkWinCondition_withElevenVP_expectTrue() {
        Player player = new Player(1);
        player.addVictoryPoints(11);
        boolean result = player.checkWinCondition();
        Assertions.assertTrue(result);
    }

    @Test
    public void test_getResourceAmountOfTypeOre_expect1() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 1);
        int result = player.getResourceAmount(Resource.ORE);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getResourceAmountOfTypeWheat_expect1() {
        Player player = new Player(1);
        player.addResources(Resource.WHEAT, 1);
        int result = player.getResourceAmount(Resource.WHEAT);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getResourceAmountOfTypeBrick_expect1() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 1);
        int result = player.getResourceAmount(Resource.BRICK);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getResourceAmountOfTypeWool_expect1() {
        Player player = new Player(1);
        player.addResources(Resource.WOOL, 1);
        int result = player.getResourceAmount(Resource.WOOL);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getResourceAmountOfTypeWood_expect1() {
        Player player = new Player(1);
        player.addResources(Resource.LUMBER, 1);
        int result = player.getResourceAmount(Resource.LUMBER);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getResourceAmountOfTypeOre_expect2() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 2);
        int result = player.getResourceAmount(Resource.ORE);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_getResourceAmountOfTypeOreMaxQuantity_expectMaxQuantity() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, Integer.MAX_VALUE);
        int result = player.getResourceAmount(Resource.ORE);
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void test_getResourceAmountOfTypeOre_expect0() {
        Player player = new Player(1);
        int result = player.getResourceAmount(Resource.ORE);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_removeResources_withOreQuantityToRemove1_expectTrue() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 1);
        boolean result = player.removeResources(Resource.ORE, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getResourceAmount(Resource.ORE));
    }

    @Test
    public void test_removeResources_withOre_PlayerHasNoOre_expectFalse() {
        Player player = new Player(1);
        boolean result = player.removeResources(Resource.ORE, 1);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_removeResources_withOreQuantityToRemove0_expectFalse() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 2);
        boolean result = player.removeResources(Resource.ORE, 0);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_removeResources_withOreQuantityToRemove2_expectTrue() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 2);
        boolean result = player.removeResources(Resource.ORE, 2);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getResourceAmount(Resource.ORE));
    }

    @Test
    public void test_removeResources_withWheatQuantityToRemove1_expectTrue() {
        Player player = new Player(1);
        player.addResources(Resource.WHEAT, 1);
        boolean result = player.removeResources(Resource.WHEAT, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getResourceAmount(Resource.WHEAT));
    }

    @Test
    public void test_removeResources_withWoolQuantityToRemove1_expectTrue() {
        Player player = new Player(1);
        player.addResources(Resource.WOOL, 1);
        boolean result = player.removeResources(Resource.WOOL, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getResourceAmount(Resource.WOOL));
    }

    @Test
    public void test_removeResources_withBrickQuantityToRemove1_expectTrue() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 1);
        boolean result = player.removeResources(Resource.BRICK, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getResourceAmount(Resource.BRICK));
    }

    @Test
    public void test_removeResources_withWoodQuantityToRemove1_expectTrue() {
        Player player = new Player(1);
        player.addResources(Resource.LUMBER, 1);
        boolean result = player.removeResources(Resource.LUMBER, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getResourceAmount(Resource.LUMBER));
    }

    @Test
    public void test_getHandSize_withHandSize0_expect0() {
        Player player = new Player(1);
        int result = player.getHandSize();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_getHandSize_withHandSize1_expect1() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 1);
        int result = player.getHandSize();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getHandSize_withHandSize2_expect2() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 1);
        player.addResources(Resource.WHEAT, 1);
        int result = player.getHandSize();
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_getHandSize_withMaxSize_expectMaxSize() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, Integer.MAX_VALUE);
        int result = player.getHandSize();
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void test_removeVictoryPoints_withVPToRemove1_expectTrue() {
        Player player = new Player(1);
        player.addVictoryPoints(1);
        boolean result = player.removeVictoryPoints(1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getVictoryPoints());
    }

    @Test
    public void test_removeVictoryPoints_withVPToRemove0_expectFalse() {
        Player player = new Player(1);
        player.addVictoryPoints(1);
        boolean result = player.removeVictoryPoints(0);
        Assertions.assertFalse(result);
        Assertions.assertEquals(1, player.getVictoryPoints());
    }

    @Test
    public void test_removeVictoryPoints_withVPToRemove11_expectTrue() {
        Player player = new Player(1);
        player.addVictoryPoints(11);
        boolean result = player.removeVictoryPoints(11);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, player.getVictoryPoints());
    }

    @Test
    public void test_removeVictoryPoints_withCurrentVPLessThanQuantityToRemove_expectFalse() {
        Player player = new Player(1);
        player.addVictoryPoints(10);
        boolean result = player.removeVictoryPoints(11);
        Assertions.assertFalse(result);
        Assertions.assertEquals(10, player.getVictoryPoints());
    }

    @Test
    public void test_removeVictoryPoints_withVPToRemove12_expectFalse() {
        Player player = new Player(1);
        player.addVictoryPoints(11);
        boolean result = player.removeVictoryPoints(12);
        Assertions.assertFalse(result);
        Assertions.assertEquals(11, player.getVictoryPoints());
    }

    @Test
    public void test_removeVictoryPointsWithVPToRemove13_expectFalse() {
        Player player = new Player(1);
        player.addVictoryPoints(11);
        boolean result = player.removeVictoryPoints(13);
        Assertions.assertFalse(result);
        Assertions.assertEquals(11, player.getVictoryPoints());
    }

    @Test
    public void test_addSettlement_withUnownedSettlementLocation_expectTrue() {

        Player player = new Player(1);
        SettlementLocation settlementLocation = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(settlementLocation.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlementLocation.setOwner(1)).andReturn(true);
        EasyMock.replay(settlementLocation);
        boolean result = player.addSettlement(settlementLocation);

        EasyMock.verify(settlementLocation);

        Assertions.assertTrue(result);

    }

    @Test
    public void test_addSettlement_withOwnedSettlementLocation_expectFalse() {

        Player player = new Player(1);
        Player otherPlayer = new Player(2);
        SettlementLocation settlementLocation = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(settlementLocation.getOwner()).andReturn(otherPlayer.getID()).times(2);
        EasyMock.replay(settlementLocation);
        boolean result = player.addSettlement(settlementLocation);

        EasyMock.verify(settlementLocation);

        Assertions.assertFalse(result);
    }

    @Test
    public void test_addSettlement_withNullSettlementLocation_expectException() {

        Player player = new Player(1);
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            player.addSettlement(null);
        });

        String expectedMessage = "Settlement cannot be null";


        Assertions.assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    public void test_addSettlement_withCityLocationOwnedbyPlayer_expectTrue() {

        Player player = new Player(1);
        SettlementLocation settlementLocation = EasyMock.createMock(SettlementLocation.class);
        EasyMock.expect(settlementLocation.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlementLocation.setOwner(1)).andReturn(true);
        EasyMock.expect(settlementLocation.getOwner()).andReturn(1);
        settlementLocation.convertToCity();
        EasyMock.replay(settlementLocation);
        player.addSettlement(settlementLocation);
        boolean result = player.addSettlement(settlementLocation);
        EasyMock.verify(settlementLocation);

        Assertions.assertTrue(result);
    }

    @Test
    public void test_getBuyableItems_withNoResources_expectEmptyList() {
        Player player = new Player(1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void test_getBuyableItems_with1Lumber1Brick_expectListWithRoad() {
        Player player = new Player(1);
        player.addResources(Resource.LUMBER, 1);
        player.addResources(Resource.BRICK, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Road", result.get(0));
    }

    @Test
    public void test_getBuyableItems_with1Lumber1Brick1Wheat1Wool_expectListWithRoadAndSettlement() {
        Player player = new Player(1);
        player.addResources(Resource.LUMBER, 1);
        player.addResources(Resource.BRICK, 1);
        player.addResources(Resource.WHEAT, 1);
        player.addResources(Resource.WOOL, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Road", result.get(0));
        Assertions.assertEquals("Settlement", result.get(1));
    }

    @Test
    public void test_getBuyableItems_with1Lumber1Brick1Wheat1Wool1Ore_expectListWithRoadAndSettlementAndDevlopmentCard() {
        Player player = new Player(1);
        player.addResources(Resource.LUMBER, 1);
        player.addResources(Resource.BRICK, 1);
        player.addResources(Resource.WHEAT, 1);
        player.addResources(Resource.WOOL, 1);
        player.addResources(Resource.ORE, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("Road", result.get(0));
        Assertions.assertEquals("Settlement", result.get(1));
        Assertions.assertEquals("Development Card", result.get(2));
    }

    @Test
    public void test_getBuyableItems_with1Brick_expectEmptyList() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void test_getBuyableItems_with1Brick1Lumber1Wheat_expectRoad() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 1);
        player.addResources(Resource.LUMBER, 1);
        player.addResources(Resource.WHEAT, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Road", result.get(0));
    }

    @Test
    public void test_getBuyableItem_with2Brick2Lumber2Wheat2Wool2Ore_expectRoadAndSettlementAndDevelopmentCard() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 2);
        player.addResources(Resource.LUMBER, 2);
        player.addResources(Resource.WHEAT, 2);
        player.addResources(Resource.WOOL, 2);
        player.addResources(Resource.ORE, 2);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("Road", result.get(0));
        Assertions.assertEquals("Settlement", result.get(1));
        Assertions.assertEquals("Development Card", result.get(2));
    }

    @Test
    public void test_getBuyableItems_with2Brick2Lumber1Wheat2Wool3Ore_expectRoadAndSettlementAndDevelopmentCard() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 2);
        player.addResources(Resource.LUMBER, 2);
        player.addResources(Resource.WHEAT, 1);
        player.addResources(Resource.WOOL, 2);
        player.addResources(Resource.ORE, 3);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("Road", result.get(0));
        Assertions.assertEquals("Settlement", result.get(1));
        Assertions.assertEquals("Development Card", result.get(2));
    }

    @Test
    public void test_getBuyableItems_with2Brick2Lumber2Wheat2Wool3Ore_expectRoadAndSettlementAndDevelopmentCardAndCity() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 2);
        player.addResources(Resource.LUMBER, 2);
        player.addResources(Resource.WHEAT, 2);
        player.addResources(Resource.WOOL, 2);
        player.addResources(Resource.ORE, 3);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals("Road", result.get(0));
        Assertions.assertEquals("Settlement", result.get(1));
        Assertions.assertEquals("City", result.get(2));
        Assertions.assertEquals("Development Card", result.get(3));
    }

    @Test
    public void test_getBuyableItems_with2Brick2Lumber3Wheat2Wool4Ore_expectRoadAndSettlementAndDevelopmentCardAndCity() {
        Player player = new Player(1);
        player.addResources(Resource.BRICK, 2);
        player.addResources(Resource.LUMBER, 2);
        player.addResources(Resource.WHEAT, 3);
        player.addResources(Resource.WOOL, 2);
        player.addResources(Resource.ORE, 4);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals("Road", result.get(0));
        Assertions.assertEquals("Settlement", result.get(1));
        Assertions.assertEquals("City", result.get(2));
        Assertions.assertEquals("Development Card", result.get(3));
    }

    @Test
    public void test_getBuyableItems_with1Ore_expectEmptyList() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void test_getBuyableItems_with1Ore1Wheat_expectEmptyList() {
        Player player = new Player(1);
        player.addResources(Resource.ORE, 1);
        player.addResources(Resource.WHEAT, 1);
        List<String> result = player.getBuyableItems();
        Assertions.assertEquals(0, result.size());
    }
    @Test
    public void test_addRoad_withUnownedRoadAttachedToSettlement_expectTrue() {
        Player player = new Player(1);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        Road road = EasyMock.createMock(Road.class);
        ArrayList<SettlementLocation> roadSettlementLocations = new ArrayList<>();
        roadSettlementLocations.add(settlement);
        
        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);

        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(roadSettlementLocations);
        EasyMock.expect(road.setOwner(1)).andReturn(true);
        EasyMock.replay(road, settlement);
        player.addSettlement(settlement);
        // road.addSettlement(settlement);
        boolean result = player.addRoad(road);
        EasyMock.verify(road, settlement);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_addRoad_withUnownedRoad_RoadNotAttachedToPlayerSettlement_expectFalse() {
        Player player = new Player(1);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        Road road = EasyMock.createMock(Road.class);
        List<SettlementLocation> roadSettlmentLocations = EasyMock.createMock(List.class);
        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);
        EasyMock.expect(road.getSettlements()).andReturn(roadSettlmentLocations);
        EasyMock.expect(roadSettlmentLocations.contains(settlement)).andReturn(false);
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.replay(road, settlement, roadSettlmentLocations);
        player.addSettlement(settlement);
        boolean result = player.addRoad(road);
        EasyMock.verify(road, settlement, roadSettlmentLocations);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_addRoad_withOwnedRoad_expectTrue() {
        Player player = new Player(1);
        Road road = EasyMock.createMock(Road.class);
        EasyMock.expect(road.setOwner(1)).andReturn(true);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.replay(road);
        road.setOwner(1);
        boolean result = player.addRoad(road);
        EasyMock.verify(road);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_addRoad_withUnownedRoadAttachedtoPlayerRoad_expectTrue() {
        SettlementLocation settlement = EasyMock.createStrictMock(SettlementLocation.class);
        SettlementLocation settlement2 = EasyMock.createStrictMock(SettlementLocation.class);
        SettlementLocation settlement3 = EasyMock.createStrictMock(SettlementLocation.class);
        Road road = EasyMock.createStrictMock(Road.class);
        Road road2 = EasyMock.createStrictMock(Road.class);



        //addRoad
        List<SettlementLocation> sls = new ArrayList<>();
        List<SettlementLocation> sls2 = new ArrayList<>();
        sls2.add(settlement);
        sls2.add(settlement2);
        sls.add(settlement2);
        sls.add(settlement3);
        EasyMock.expect(road2.addSettlement(settlement)).andReturn(true);
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(sls).times(2);
        EasyMock.expect(road2.getSettlements()).andReturn(sls2);
        EasyMock.expect(settlement2.getOwner()).andReturn(0);
        EasyMock.expect(road.setOwner(1)).andReturn(true);
        EasyMock.replay(road, road2, settlement, settlement2);
        Player player = new Player(road2, settlement);
        boolean result = player.addRoad(road);
        EasyMock.verify(road, road2, settlement, settlement2);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_addRoad_withUnownedRoadNotAttachedToRoadorSettlement_expectFalse() {
        Player player = new Player(1);
        Road road = EasyMock.createMock(Road.class);
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.replay(road);
        boolean result = player.addRoad(road);
        EasyMock.verify(road);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_addRoad_withNullRoad_expectException() {
        Player player = new Player(1);
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            player.addRoad(null);
        });

        Assertions.assertEquals("Road cannot be null", exception.getMessage());
    }

    @Test
    public void test_addRoad_withUnownedRoad_NextToDifferentPlayerSettlement_expectFalse() {
       
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement2 = EasyMock.createMock(SettlementLocation.class);
        Road road = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        ArrayList<SettlementLocation> roadSettlementLocations = new ArrayList<>();
        roadSettlementLocations.add(settlement);

        ArrayList<SettlementLocation> roadSettlementLocations2 = new ArrayList<>();
        roadSettlementLocations2.add(settlement2);
        roadSettlementLocations2.add(settlement);
        
        EasyMock.expect(road2.addSettlement(settlement2)).andReturn(true);
        EasyMock.expect(road.getOwner()).andReturn(0);
        // EasyMock.expect(road2.getSettlements()).andReturn(roadSettlementLocations2).times(2); 
        EasyMock.expect(road.getSettlements()).andReturn(roadSettlementLocations).times(2);
        EasyMock.expect(road2.getSettlements()).andReturn(roadSettlementLocations2);
        EasyMock.expect(settlement.getOwner()).andReturn(2);
        EasyMock.replay(road, settlement, road2, settlement2);
        // player.addSettlement(settlement);
        Player player = new Player(road2, settlement2);
        boolean result = player.addRoad(road);
        EasyMock.verify(road, settlement, road2, settlement2);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_getVictoryPoints_with0VictoryPoints_expect0() {
        Player player = new Player(1);
        Assertions.assertEquals(0, player.getVictoryPoints());
    }

    @Test
    public void test_getVictoryPoints_with1VictoryPoint_expect1() {
        Player player = new Player(1);
        player.addVictoryPoints(1);
        Assertions.assertEquals(1, player.getVictoryPoints());
    }

    @Test
    public void test_getVictoryPoints_with11VictoryPoints_expect11() {
        Player player = new Player(1);
        player.addVictoryPoints(5);
        player.addVictoryPoints(6);
        Assertions.assertEquals(11, player.getVictoryPoints());
    }

    @Test
    public void test_addOneDevelopmentCard_WithKnight_expectTrue(){
        Player player = new Player(1);
        List<DevelopmentCard> expected = new ArrayList<>();
        Knight knight = EasyMock.createMock(Knight.class);
        EasyMock.expect(knight.string()).andReturn("Knight");
        EasyMock.replay(knight);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        Assertions.assertTrue(player.addOneDevelopmentCard(knight));
        expected.add(knight);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        EasyMock.verify(knight);
    }

    @Test
    public void test_addOneDevelopmentCard_WithMonopoly_expect1() {
        Player player = new Player(1);
        List<DevelopmentCard> expected = new ArrayList<>();
        Monopoly mono = EasyMock.createMock(Monopoly.class);
        EasyMock.expect(mono.string()).andReturn("Monopoly");
        EasyMock.replay(mono);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        Assertions.assertTrue(player.addOneDevelopmentCard(mono));
        expected.add(mono);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        EasyMock.verify(mono);
    }

    @Test
    public void test_addOneDevelopmentCard_WithRoadBuilding_expect1() {
        Player player = new Player(1);
        List<DevelopmentCard> expected = new ArrayList<>();
        RoadBuilding roadbuilding = EasyMock.createMock(RoadBuilding.class);
        EasyMock.expect(roadbuilding.string()).andReturn("Road Building");
        EasyMock.replay(roadbuilding);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        Assertions.assertTrue(player.addOneDevelopmentCard(roadbuilding));
        expected.add(roadbuilding);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        EasyMock.verify(roadbuilding);
    }

    @Test
    public void test_addOneDevelopmentCard_WithVictoryPoint_expect1() {
        Player player = new Player(1);
        List<DevelopmentCard> expected = new ArrayList<>();
        VictoryPoint vp = EasyMock.createMock(VictoryPoint.class);
        EasyMock.expect(vp.string()).andReturn("Victory Point");
        EasyMock.replay(vp);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        Assertions.assertTrue(player.addOneDevelopmentCard(vp));
        expected.add(vp);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        EasyMock.verify(vp);
    }

    @Test
    public void test_addOneDevelopmentCard_WithYearOfPlenty_expect1() {
        Player player = new Player(1);
        List<DevelopmentCard> expected = new ArrayList<>();
        YearofPlenty year = EasyMock.createMock(YearofPlenty.class);
        EasyMock.expect(year.string()).andReturn("Year of Plenty");
        EasyMock.replay(year);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        Assertions.assertTrue(player.addOneDevelopmentCard(year));
        expected.add(year);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        EasyMock.verify(year);
    }

    @Test
    public void test_addOneDevelopmentCard_CallTwiceWithKnight_expect2() {
        Player player = new Player(1);
        List<DevelopmentCard> expected = new ArrayList<>();
        Knight knight = EasyMock.createMock(Knight.class);
        EasyMock.expect(knight.string()).andReturn("Knight").times(2);
        EasyMock.replay(knight);
        player.addOneDevelopmentCard(knight);
        expected.add(knight);

        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        Assertions.assertTrue(player.addOneDevelopmentCard(knight));
        expected.add(knight);
        Assertions.assertEquals(expected, player.getOwnedDevelopmentCards());
        EasyMock.verify(knight);
    }

    @Test
    public void test_addOneDevelopmentCard_CallWithInvalidCardName_throwException(){
        String cardName = "Brick";
        Knight knight = EasyMock.createMock(Knight.class);
        EasyMock.expect(knight.string()).andReturn(cardName);
        EasyMock.replay(knight);
        Player player = new Player(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.addOneDevelopmentCard(knight);
        });
        EasyMock.verify(knight);
    }

    @Test
    public void test_getHand_with0Cards_expectEmpty() {
        Player player = new Player(1);
        Assertions.assertEquals(new ArrayList<String>(), player.getHand());
    }

    @Test
    public void test_getHand_withOneCard_expectOneString() {
        Player player = new Player(1);
        Knight knight = EasyMock.createMock(Knight.class);
        EasyMock.expect(knight.string()).andReturn("Knight").times(2);
        EasyMock.replay(knight);
        player.addOneDevelopmentCard(knight);
        List<String> expected = new ArrayList<>();
        expected.add("Knight");
        Assertions.assertEquals(expected, player.getHand());
        EasyMock.verify(knight);
    }

    @Test
    public void test_getHand_withTwoCards_expectTwoStrings() {
        Player player = new Player(1);
        Knight knight = EasyMock.createMock(Knight.class);
        EasyMock.expect(knight.string()).andReturn("Knight").times(2);
        VictoryPoint vp = EasyMock.createMock(VictoryPoint.class);
        EasyMock.expect(vp.string()).andReturn("Victory Point").times(2);
        EasyMock.replay(knight, vp);
        player.addOneDevelopmentCard(knight);
        player.addOneDevelopmentCard(vp);
        List<String> expected = new ArrayList<>();
        expected.add("Knight");
        expected.add("Victory Point");
        Assertions.assertEquals(expected, player.getHand());
        EasyMock.verify(knight, vp);
    }

    @Test
    public void test_getHand_withMaxCards_expectMaxStrings() {
        Player player = new Player(1);
        List<String> expected = new ArrayList<>();
        List<Monopoly> mocks = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            Monopoly mono = EasyMock.createMock(Monopoly.class);
            mocks.add(mono);
            EasyMock.expect(mono.string()).andReturn("Monopoly").times(2);
            expected.add("Monopoly");
            EasyMock.replay(mocks.get(i));
            player.addOneDevelopmentCard(mono);
        }
        Assertions.assertEquals(expected, player.getHand());
        for(int i = 0; i < 25; i++) {
            EasyMock.verify(mocks.get(i));
        }


    }

    @Test
    public void test_getPossibleSettlementLocationswithEnoughRoadSpace_expectListSize1() {
        Player player = new Player(1);
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);

        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);

        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s2);

        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);
        expectedForr2.add(s3);
        

        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(r1);
        s2Roads.add(r2);

        List<Road> s3Roads = new ArrayList<>();
        s3Roads.add(r2);

        //add Settlements
        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);
        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.setOwner(1)).andReturn(true);

        //add Roads
        EasyMock.expect(r1.addSettlement(s1)).andReturn(true);
        EasyMock.expect(r1.addSettlement(s2)).andReturn(true);
        EasyMock.expect(r2.addSettlement(s2)).andReturn(true);
        EasyMock.expect(r2.addSettlement(s3)).andReturn(true);
        
        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);
        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        //getPossibleSettlementLocations
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1); //r1 is adjacent to player
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        EasyMock.expect(s2.getRoads()).andReturn(s2Roads);//s2 is adjacent to player settlement
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2); //r2 is adjacent to player
        EasyMock.expect(s2.getOwner()).andReturn(0);
        EasyMock.expect(s3.getOwner()).andReturn(0);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);//s3 is not adjacent to player settlement
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);

        EasyMock.replay(s1, s2, s3, r1, r2, s4);

        player.addSettlement(s1);
        player.addSettlement(s4);
        r1.addSettlement(s1);
        r1.addSettlement(s2);
        r2.addSettlement(s2);
        r2.addSettlement(s3);
        player.addRoad(r1);
        player.addRoad(r2);
        Set<SettlementLocation> actual = player.getPossibleSettlementLocations();

        EasyMock.verify(s1, s2, s3, r1, r2, s4);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertTrue(actual.contains(s3));
    }

    @Test
    public void test_getPossibleSettlementLocationsWith1Settlement_expectException() {
        Player player = new Player(1);
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);

        EasyMock.replay(s1);

        player.addSettlement(s1);
        String expected = "Player does not have enough settlements";
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            player.getPossibleSettlementLocations();
        });

        EasyMock.verify(s1);
        Assertions.assertEquals(expected, exception.getMessage());
    }

    @Test
    public void test_getPossibleSettlementLocationsWith5Settlements_expectException() {
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s5 = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true);

        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.setOwner(1)).andReturn(true);

        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.setOwner(1)).andReturn(true);

        EasyMock.expect(s5.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s5.setOwner(1)).andReturn(true);

        EasyMock.replay(s1, s2, s3, s4, s5);

        Player player = new Player(1);
        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addSettlement(s3);
        player.addSettlement(s4);
        player.addSettlement(s5);
        String expected = "Player does not have enough settlements";
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            player.getPossibleSettlementLocations();
        });

        EasyMock.verify(s1, s2, s3, s4, s5);
        Assertions.assertEquals(expected, exception.getMessage());
    }

    @Test
    public void test_getPossibleSettlementLocationswithNotEnoughRoadSpace_expectEmptySet() {
        Player player = new Player(1);
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);

        Road r1 = EasyMock.createMock(Road.class);
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s3);

        List<Road> s3Roads = new ArrayList<>();
        s3Roads.add(r1);
        
        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true);

        EasyMock.expect(r1.addSettlement(s1)).andReturn(true);
        EasyMock.expect(r1.addSettlement(s3)).andReturn(true);

        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1); //r1 is adjacent to player
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(s3.getOwner()).andReturn(0);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.replay(s1, s2, s3, r1);

        player.addSettlement(s1);
        player.addSettlement(s2);
        r1.addSettlement(s1);
        r1.addSettlement(s3);
        player.addRoad(r1);
        Set<SettlementLocation> actual = player.getPossibleSettlementLocations();

        EasyMock.verify(s1, s2, s3, r1);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_getPossibleSettlementLocationswithEnoughRoadSpaceButSettlementIsOccupied_expectEmpty() {
        Player player = new Player(1);
        Player player2 = new Player(2);
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);

        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);

        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s2);

        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);
        expectedForr2.add(s3);
        

        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(r1);
        s2Roads.add(r2);


        //add Settlements
        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);

        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.setOwner(1)).andReturn(true);

        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.setOwner(2)).andReturn(true);

        //add Roads
        EasyMock.expect(r1.addSettlement(s1)).andReturn(true);
        EasyMock.expect(r1.addSettlement(s2)).andReturn(true);
        EasyMock.expect(r2.addSettlement(s2)).andReturn(true);
        EasyMock.expect(r2.addSettlement(s3)).andReturn(true);
        
        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);
        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        //getPossibleSettlementLocations
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1); //r1 is adjacent to player
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        EasyMock.expect(s2.getRoads()).andReturn(s2Roads);//s2 is adjacent to player settlement
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2); //r2 is adjacent to player
        EasyMock.expect(s3.getOwner()).andReturn(2);

        EasyMock.replay(s1, s2, s3, r1, r2, s4);

        player.addSettlement(s1);
        player.addSettlement(s4);
        player2.addSettlement(s3);
        r1.addSettlement(s1);
        r1.addSettlement(s2);
        r2.addSettlement(s2);
        r2.addSettlement(s3);
        player.addRoad(r1);
        player.addRoad(r2);
        Set<SettlementLocation> actual = player.getPossibleSettlementLocations();

        EasyMock.verify(s1, s2, s3, r1, r2, s4);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_getPossibleSettlementLocationsWith4Settlements_2possiblelocations_expectSetWithSize2() {
        Player player = new Player(1);
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s5 = EasyMock.createMock(SettlementLocation.class);//s1Roads that are adjacent to player
        SettlementLocation s6 = EasyMock.createMock(SettlementLocation.class);//s1Roads that are adjacent to player
        SettlementLocation s7 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s8 = EasyMock.createMock(SettlementLocation.class);

        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        Road r4 = EasyMock.createMock(Road.class);

        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s5);

        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s5);
        expectedForr2.add(s7);

        List<SettlementLocation> expectedForr3 = new ArrayList<>();
        expectedForr3.add(s2);
        expectedForr3.add(s6);

        List<SettlementLocation> expectedForr4 = new ArrayList<>();
        expectedForr4.add(s6);
        expectedForr4.add(s8);

        List<Road> s5roads = new ArrayList<>();
        s5roads.add(r1);
        s5roads.add(r2);

        List<Road> s6Roads = new ArrayList<>();
        s6Roads.add(r3);
        s6Roads.add(r4);

        List<Road> s7roads = new ArrayList<>();
        s7roads.add(r2);

        List<Road> s8Roads = new ArrayList<>();
        s8Roads.add(r4);
        
        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true);

        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.setOwner(1)).andReturn(true);

        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.setOwner(1)).andReturn(true);

        //add r1
        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        //add r2
        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(5);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s5.getOwner()).andReturn(0);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        //add r3
        EasyMock.expect(r3.getOwner()).andReturn(0);
        EasyMock.expect(r3.getSettlements()).andReturn(expectedForr3).times(2);
        EasyMock.expect(r3.setOwner(1)).andReturn(true);

        //add r4
        EasyMock.expect(r4.getOwner()).andReturn(0);
        EasyMock.expect(r4.getSettlements()).andReturn(expectedForr4).times(7);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(r3.getSettlements()).andReturn(expectedForr3);
        EasyMock.expect(s6.getOwner()).andReturn(0);
        EasyMock.expect(r4.setOwner(1)).andReturn(true);

        //get possible locations
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(s5.getOwner()).andReturn(0);

        EasyMock.expect(s5.getRoads()).andReturn(s5roads);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s7.getOwner()).andReturn(0);

        EasyMock.expect(s7.getRoads()).andReturn(s7roads);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s5.getOwner()).andReturn(0);

        // EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);

        EasyMock.expect(r3.getSettlements()).andReturn(expectedForr3);
        EasyMock.expect(s2.getOwner()).andReturn(1);
        EasyMock.expect(s6.getOwner()).andReturn(0);

        EasyMock.expect(s6.getRoads()).andReturn(s6Roads);
        EasyMock.expect(r3.getSettlements()).andReturn(expectedForr3);
        EasyMock.expect(s2.getOwner()).andReturn(1);

        EasyMock.expect(r4.getSettlements()).andReturn(expectedForr4);
        EasyMock.expect(s8.getOwner()).andReturn(0);

        EasyMock.expect(s8.getRoads()).andReturn(s8Roads);
        EasyMock.expect(r4.getSettlements()).andReturn(expectedForr4);
        EasyMock.expect(s6.getOwner()).andReturn(0);

        EasyMock.replay(s1, s2, s3, s4, s5, s6, s7, s8, r1, r2, r3, r4);

        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addSettlement(s3);
        player.addSettlement(s4);
        player.addRoad(r1);
        player.addRoad(r2);
        player.addRoad(r3);
        player.addRoad(r4);

        Set<SettlementLocation> actual = player.getPossibleSettlementLocations();

        EasyMock.verify(s1, s2, s3, s4, s5, s6, s7, s8, r1, r2, r3, r4);
        Assertions.assertEquals(2, actual.size());
        Assertions.assertTrue(actual.contains(s7));
        Assertions.assertTrue(actual.contains(s8));
    }

    @Test
    public void test_getPossibleRoadLocations_with1Road_expectException() {
        Player player = new Player(1);

        SettlementLocation s1 = EasyMock.niceMock(SettlementLocation.class);
        Road road = EasyMock.niceMock(Road.class);
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);

        EasyMock.expect(s1.getOwner()).andReturn(0);
        EasyMock.expect(s1.setOwner(1)).andReturn(true); 

        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(road.setOwner(1)).andReturn(true);

        EasyMock.replay(s1, road);
        player.addSettlement(s1);
        player.addRoad(road);

        String expected = "Invalid number of roads";
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            player.getPossibleRoadLocations();
        });

        EasyMock.verify(s1, road);

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @Test
    public void test_getPossibleRoadLocationsWith2Roads_withAvailableAdjacentRoadToSettlement_expectSetofSize1(){
        Player player = new Player(1);

        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);

        List<Road> s1roads = new ArrayList<>();
        s1roads.add(r1);
        s1roads.add(r3);

        List<Road> s2roads = new ArrayList<>();
        s2roads.add(r2);

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true); 

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true); 

        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        EasyMock.expect(s1.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(r3.getOwner()).andReturn(0);

        EasyMock.expect(s2.getRoads()).andReturn(s2roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);

        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s2.getOwner()).andReturn(1);


        EasyMock.replay(s1, s2, r1, r2, r3);
        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addRoad(r1);
        player.addRoad(r2);

        Set<Road> actual = player.getPossibleRoadLocations();

        EasyMock.verify(s1, s2, r1, r2, r3);

        Assertions.assertEquals(1, actual.size());
        Assertions.assertTrue(actual.contains(r3));
    }

    @Test
    public void test_getPossibleRoadLocations_with2Roads_withOwnedAdjacentRoadToSettlement_expectSetofSize0(){
        Player player = new Player(1);

        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);

        List<Road> s1roads = new ArrayList<>();
        s1roads.add(r1);
        s1roads.add(r3);

        List<Road> s2roads = new ArrayList<>();
        s2roads.add(r2);

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true); 

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true); 

        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        EasyMock.expect(s1.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(r3.getOwner()).andReturn(1);

        EasyMock.expect(s2.getRoads()).andReturn(s2roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);

        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s2.getOwner()).andReturn(1);

        EasyMock.replay(s1, s2, r1, r2, r3);
        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addRoad(r1);
        player.addRoad(r2);

        Set<Road> actual = player.getPossibleRoadLocations();

        EasyMock.verify(s1, s2, r1, r2, r3);

        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_getPossibleRoadLocations_with14Roads_withUnownedAdjacentRoad_expectSetSize1() {
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        Road r4 = EasyMock.createMock(Road.class);
        Road r5 = EasyMock.createMock(Road.class);
        Road r6 = EasyMock.createMock(Road.class);
        Road r7 = EasyMock.createMock(Road.class);
        Road r8 = EasyMock.createMock(Road.class);
        Road r9 = EasyMock.createMock(Road.class);
        Road r10 = EasyMock.createMock(Road.class);
        Road r11 = EasyMock.createMock(Road.class);
        Road r12 = EasyMock.createMock(Road.class);
        Road r13 = EasyMock.createMock(Road.class);
        Road r14 = EasyMock.createMock(Road.class);

        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(r1);
        s1Roads.add(r2);
        s1Roads.add(r3);
        s1Roads.add(r4);
        s1Roads.add(r5);
        s1Roads.add(r6);
        s1Roads.add(r7);
        s1Roads.add(r8);
        s1Roads.add(r14);
        s1Roads.add(r9);
        s1Roads.add(r10);
        s1Roads.add(r11);
        s1Roads.add(r12);
        s1Roads.add(r13);
        List<Road> s1roads = new ArrayList<>();
        s1roads.add(r1);

        // List<Road> s2roads = new ArrayList<>();
        // s2roads.add(r1);


        Player player = new Player(s1Roads, s1, s2);
        EasyMock.expect(s1.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getOwner()).andReturn(0);

        EasyMock.expect(s2.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r2.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r3.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r4.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r5.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r6.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r7.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r8.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r9.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r10.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r11.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r12.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r13.getSettlements()).andReturn(new ArrayList<>());
        EasyMock.expect(r14.getSettlements()).andReturn(new ArrayList<>());


        EasyMock.replay(s1, s2, r1, r2, r3, r4, r5, r6, r7, r8, r14, r9, r10, r11, r12, r13);
        
        Set<Road> actual = player.getPossibleRoadLocations();

        EasyMock.verify(s1, s2, r1, r2, r3, r4, r5, r6, r7, r8, r14, r9, r10, r11, r12, r13);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertTrue(actual.contains(r1));
    }

    @Test
    public void test_getPossibleRoadLocationsWith15Roads_expectException() {
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        Road r4 = EasyMock.createMock(Road.class);
        Road r5 = EasyMock.createMock(Road.class);
        Road r6 = EasyMock.createMock(Road.class);
        Road r7 = EasyMock.createMock(Road.class);
        Road r8 = EasyMock.createMock(Road.class);
        Road r9 = EasyMock.createMock(Road.class);
        Road r10 = EasyMock.createMock(Road.class);
        Road r11 = EasyMock.createMock(Road.class);
        Road r12 = EasyMock.createMock(Road.class);
        Road r13 = EasyMock.createMock(Road.class);
        Road r14 = EasyMock.createMock(Road.class);
        Road r15 = EasyMock.createMock(Road.class);

        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(r1);
        s1Roads.add(r2);
        s1Roads.add(r3);
        s1Roads.add(r4);
        s1Roads.add(r5);
        s1Roads.add(r6);
        s1Roads.add(r7);
        s1Roads.add(r8);
        s1Roads.add(r14);
        s1Roads.add(r9);
        s1Roads.add(r10);
        s1Roads.add(r11);
        s1Roads.add(r12);
        s1Roads.add(r13);
        s1Roads.add(r15);

        Player player = new Player(s1Roads, s1, s2);

        EasyMock.replay(s1, s2, r1, r2, r3, r4, r5, r6, r7, r8, r14, r9, r10, r11, r12, r13, r15);

        String expected = "Invalid number of roads";
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            player.getPossibleRoadLocations();
        });

        EasyMock.verify(s1, s2, r1, r2, r3, r4, r5, r6, r7, r8, r14, r9, r10, r11, r12, r13, r15);

        Assertions.assertEquals(expected, exception.getMessage());
    }

    @Test
    public void test_getPossibleRoadLocations_with2Roads_withUnownedAdjacentRoadNextToRoad_expectSetSize1() {
        Player player = new Player(1);

        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s3);
        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);

        List<Road> s1roads = new ArrayList<>();
        s1roads.add(r1);
        // s1roads.add(r3);

        List<Road> s2roads = new ArrayList<>();
        s2roads.add(r2);

        List<Road> s3Roads = new ArrayList<>();
        s3Roads.add(r3);

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true); 

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true); 

        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        EasyMock.expect(s1.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(s2.getRoads()).andReturn(s2roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);

        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.expect(s3.getOwner()).andReturn(0);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(r3.getOwner()).andReturn(0);

        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s2.getOwner()).andReturn(1);

        EasyMock.replay(s1, s2, r1, r2, r3, s3);

        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addRoad(r1);
        player.addRoad(r2);

        Set<Road> actual = player.getPossibleRoadLocations();

        EasyMock.verify(s1, s2, r1, r2, r3, s3);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertTrue(actual.contains(r3));
    }

    @Test
    public void test_getPossibleRoadLocations_with2Roads_withOwnedAdjacentRoadNextToRoad_expectSetSize1() {
        Player player = new Player(1);

        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s3);
        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);

        List<Road> s1roads = new ArrayList<>();
        s1roads.add(r1);
        // s1roads.add(r3);

        List<Road> s2roads = new ArrayList<>();
        s2roads.add(r2);

        List<Road> s3Roads = new ArrayList<>();
        s3Roads.add(r3);

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true); 

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true); 

        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        EasyMock.expect(s1.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(s2.getRoads()).andReturn(s2roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);

        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.expect(s3.getOwner()).andReturn(0);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(r3.getOwner()).andReturn(1);

        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s2.getOwner()).andReturn(1);

        EasyMock.replay(s1, s2, r1, r2, r3, s3);

        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addRoad(r1);
        player.addRoad(r2);

        Set<Road> actual = player.getPossibleRoadLocations();

        EasyMock.verify(s1, s2, r1, r2, r3, s3);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_getPossibleRoadLocations_with2Roads_withUnownedAdjacentRoad_toSettlementAndRoad_expectSetOfSize2() {
        Player player = new Player(1);

        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        Road r4 = EasyMock.createMock(Road.class);
        // Road r5 = EasyMock.createMock(Road.class);
        
        List<SettlementLocation> expectedForr1 = new ArrayList<>();
        expectedForr1.add(s1);
        expectedForr1.add(s3);
        List<SettlementLocation> expectedForr2 = new ArrayList<>();
        expectedForr2.add(s2);

        List<Road> s1roads = new ArrayList<>();
        s1roads.add(r1);
        s1roads.add(r4);

        List<Road> s2roads = new ArrayList<>();
        s2roads.add(r2);

        List<Road> s3Roads = new ArrayList<>();
        s3Roads.add(r3);
        s3Roads.add(r2);
        

        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true); 

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true); 

        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2).times(2);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        EasyMock.expect(s1.getRoads()).andReturn(s1roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(r4.getOwner()).andReturn(0);
        EasyMock.expect(s2.getRoads()).andReturn(s2roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);

        EasyMock.expect(r1.getSettlements()).andReturn(expectedForr1);
        EasyMock.expect(s1.getOwner()).andReturn(1);

        EasyMock.expect(s3.getOwner()).andReturn(0);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(r3.getOwner()).andReturn(0);

        EasyMock.expect(r2.getSettlements()).andReturn(expectedForr2);
        EasyMock.expect(s2.getOwner()).andReturn(1);

        EasyMock.replay(s1, s2, r1, r2, r3, s3, r4);

        player.addSettlement(s1);
        player.addSettlement(s2);
        player.addRoad(r1);
        player.addRoad(r2);

        Set<Road> actual = player.getPossibleRoadLocations();

        EasyMock.verify(s1, s2, r1, r2, r3, s3, r4);
        Assertions.assertEquals(2, actual.size());
        Assertions.assertTrue(actual.contains(r3));
        Assertions.assertTrue(actual.contains(r4));
    }

    @Test
    public void test_addHarborEmptyString_L1String() {
        Player player = new Player(1);
        player.addHarbor('W');
        Assertions.assertEquals("W",player.getHarborString());
    }
    @Test
    public void test_addHarborL1String_L2String() {
        Player player = new Player(1);
        player.addHarbor('W');
        String original = player.getHarborString();
        player.addHarbor('O');
        Assertions.assertEquals(original + "O",player.getHarborString());
    }

    @Test
    public void test_addHarborL2String_L3String() {
        Player player = new Player(1);
        player.addHarbor('W');
        player.addHarbor('B');
        String original = player.getHarborString();
        player.addHarbor('O');
        Assertions.assertEquals(original + "O",player.getHarborString());
    }

    @Test
    public void test_addHarborL8String_L9String() {
        Player player = new Player(1);
        player.addHarbor('W');
        player.addHarbor('B');
        player.addHarbor('O');
        player.addHarbor('L');
        for(int i = 0; i < 4; i++) {
            player.addHarbor('?');
        }
        String original = player.getHarborString();
        player.addHarbor('H');
        Assertions.assertEquals(original + "H",player.getHarborString());
    }

    @Test
    public void TestgetResourceAmountGainedFromTerrain_InvalidTerrain_ThrowException(){
        Player player = new Player(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.getResourceAmountGainedFromRollNumber(-1);
        });
    }

    @Test
    public void TestgetResourceAmountGainedFromTerrain_InvalidTerrain0_ThrowException(){
        Player player = new Player(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.getResourceAmountGainedFromRollNumber(0);
        });
    }

    @Test
    public void test_getResourceAmountGainedFromTerrain_withRollNumber13_expectException() {
        Player player = new Player(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.getResourceAmountGainedFromRollNumber(13);
        });
    }

    @Test
    public void TestgetResourceAmountGainedFromTerrain_NoSettlmentsOwned_Return0s(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 0);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        Player player = new Player(1);
        Map<Resource, Integer> actual = player.getResourceAmountGainedFromRollNumber(12);
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void TestgetResourceAmountGainedFromTerrain_NoSettlmentsOnTerrain_Return0s(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 0);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        SettlementLocation noResourceSettlement = EasyMock.createMock(SettlementLocation.class);
        Road road = new Road();

        EasyMock.expect(noResourceSettlement.getResourceAmountGainedFromRollNumber(11)).andReturn(expected);
        EasyMock.replay(noResourceSettlement);

        Player player = new Player(road, noResourceSettlement);
        Map<Resource, Integer> actual = player.getResourceAmountGainedFromRollNumber(11);
        Assertions.assertEquals(actual, expected);
        EasyMock.verify(noResourceSettlement);
    }

    @Test
    public void TestgetResourceAmountGainedFromTerrain_OneSettlmentsOnTerrain_Return1Wood(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 1);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        SettlementLocation settlementOnRolledTerrain = EasyMock.createMock(SettlementLocation.class);
        Road road = new Road();


        EasyMock.expect(settlementOnRolledTerrain.getResourceAmountGainedFromRollNumber(11)).andReturn(expected);
        EasyMock.replay(settlementOnRolledTerrain);

        Player player = new Player(road, settlementOnRolledTerrain);
        Map<Resource, Integer> actual = player.getResourceAmountGainedFromRollNumber(11);
        Assertions.assertEquals(actual, expected);
        EasyMock.verify(settlementOnRolledTerrain);
    }

    @Test
    public void TestgetResourceAmountGainedFromTerrain_ThreeSettlementsOnTerrain_Return3(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 3);
        expected.put(Resource.ORE, 0);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        HashMap mockedHash = EasyMock.createNiceMock(HashMap.class);
        SettlementLocation settlementOnRolledTerrain = EasyMock.createMock(SettlementLocation.class);
        ArrayList<Road> s1Roads = new ArrayList<>();

        EasyMock.expect(settlementOnRolledTerrain.getResourceAmountGainedFromRollNumber(5)).andReturn(mockedHash);
        EasyMock.expect(mockedHash.get(Resource.ORE)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.BRICK)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.WOOL)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(mockedHash.get(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(settlementOnRolledTerrain.getResourceAmountGainedFromRollNumber(5)).andReturn(mockedHash);
        EasyMock.expect(mockedHash.get(Resource.ORE)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.BRICK)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.WOOL)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(mockedHash.get(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(settlementOnRolledTerrain.getResourceAmountGainedFromRollNumber(5)).andReturn(mockedHash);
        EasyMock.expect(mockedHash.get(Resource.ORE)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.BRICK)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.WOOL)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(mockedHash.get(Resource.WHEAT)).andReturn(0);
        EasyMock.replay(settlementOnRolledTerrain, mockedHash);

        Player player = new Player(s1Roads, settlementOnRolledTerrain, settlementOnRolledTerrain, settlementOnRolledTerrain);
        Map<Resource, Integer> actual = player.getResourceAmountGainedFromRollNumber(5);
        Assertions.assertEquals(actual, expected);
        EasyMock.verify(mockedHash, settlementOnRolledTerrain);
    }

    @Test
    public void TestgetResourceAmountGainedFromTerrain_SettlementOnTwoTerrainsWithSameRoll_Return2DiffResources(){
        HashMap<Resource, Integer> expected = new HashMap<>();
        expected.put(Resource.LUMBER, 1);
        expected.put(Resource.ORE, 1);
        expected.put(Resource.BRICK, 0);
        expected.put(Resource.WOOL, 0);
        expected.put(Resource.WHEAT, 0);
        HashMap mockedHash = EasyMock.createNiceMock(HashMap.class);
        SettlementLocation settlementOnRolledTerrain = EasyMock.createMock(SettlementLocation.class);
        Road road = EasyMock.createMock(Road.class);

        EasyMock.expect(settlementOnRolledTerrain.getResourceAmountGainedFromRollNumber(5)).andReturn(mockedHash);
        EasyMock.expect(mockedHash.get(Resource.ORE)).andReturn(1);
        EasyMock.expect(mockedHash.get(Resource.BRICK)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.WOOL)).andReturn(0);
        EasyMock.expect(mockedHash.get(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(mockedHash.get(Resource.WHEAT)).andReturn(0);
        EasyMock.replay(settlementOnRolledTerrain, mockedHash);

        Player player = new Player(road, settlementOnRolledTerrain);
        Map<Resource, Integer> actual = player.getResourceAmountGainedFromRollNumber(5);
        Assertions.assertEquals(actual, expected);
        EasyMock.verify(mockedHash, settlementOnRolledTerrain);
    }

    @Test
    public void test_getRoadLength_noRoads_returns0() {
        Player player = new Player(1);
        Assertions.assertEquals(0, player.getRoadLength());
    }

    @Test
    public void test_getRoadLength_oneRoad_returns1() {
        Player player = new Player(1);
        Road road = EasyMock.createMock(Road.class);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);

        List<SettlementLocation> r1SettlementLocations = new ArrayList<>();
     r1SettlementLocations.add(settlement);

        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(road);

        //addSettlement
        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);


        //addRoad
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(road.setOwner(1)).andReturn(true);

        //getLongestRoadLength
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement.getOwner()).andReturn(1);
        EasyMock.expect(settlement.getRoads()).andReturn(s1Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);

        EasyMock.replay(road, settlement);

        player.addSettlement(settlement);
        player.addRoad(road);

        int result = player.getRoadLength();

        EasyMock.verify(road, settlement);

        Assertions.assertEquals(1, result);
    }

    @Test
    public void test_getRoadLength_2Roads_longestLength2() {
        Player player = new Player(1);
        Road road = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement2 = EasyMock.createMock(SettlementLocation.class);

        List<SettlementLocation> r1SettlementLocations = new ArrayList<>();
        r1SettlementLocations.add(settlement);
        r1SettlementLocations.add(settlement2);


        List<SettlementLocation> r2SettlementLocations = new ArrayList<>();
        r2SettlementLocations.add(settlement2);


        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(road);
        
        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(road);
        s2Roads.add(road2);

        //addSettlement
        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);


        //addRoad road
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(road.setOwner(1)).andReturn(true);


        //addRoad road2
        EasyMock.expect(road2.getOwner()).andReturn(0);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations).times(2);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement2.getOwner()).andReturn(0);
        EasyMock.expect(road2.setOwner(1)).andReturn(true);

        //getLongestRoadLength
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement.getOwner()).andReturn(1);
        EasyMock.expect(settlement.getRoads()).andReturn(s1Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(settlement2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(1);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(settlement2.getOwner()).andReturn(1);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(1);
        
        

        EasyMock.replay(road, road2, settlement, settlement2);

        player.addSettlement(settlement);
        player.addRoad(road);
        player.addRoad(road2);

        int result = player.getRoadLength();

        EasyMock.verify(road, road2, settlement, settlement2);
        Assertions.assertEquals(2, result);

    }

    @Test
    public void test_getRoadLength_3Roads_longestLength2() {
        Player player = new Player(1);
        Road road = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        Road road3 = EasyMock.createMock(Road.class);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement3 = EasyMock.createMock(SettlementLocation.class);

        List<SettlementLocation> r1SettlementLocations = new ArrayList<>();
        r1SettlementLocations.add(settlement);
        r1SettlementLocations.add(settlement2);


        List<SettlementLocation> r2SettlementLocations = new ArrayList<>();
        r2SettlementLocations.add(settlement2);

        List<SettlementLocation> r3SettlementLocations = new ArrayList<>();
        r3SettlementLocations.add(settlement3);


        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(road);
        
        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(road);
        s2Roads.add(road2);

        List<Road> s3Roads  = new ArrayList<>();
        s3Roads.add(road3);

        //addSettlement
        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);

        //addSettlement settlement3
        EasyMock.expect(settlement3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement3.setOwner(1)).andReturn(true);

        //addRoad road3
        EasyMock.expect(road3.getOwner()).andReturn(0);
        EasyMock.expect(road3.getSettlements()).andReturn(r3SettlementLocations).times(2);
        EasyMock.expect(road3.setOwner(1)).andReturn(true);

        //addRoad road
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(road.setOwner(1)).andReturn(true);


        //addRoad road2
        EasyMock.expect(road2.getOwner()).andReturn(0);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations).times(3);
        EasyMock.expect(road3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement2.getOwner()).andReturn(0);
        EasyMock.expect(road2.setOwner(1)).andReturn(true);

        

        //getLongestRoadLength

        EasyMock.expect(road3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(settlement3.getOwner()).andReturn(1);
        EasyMock.expect(settlement3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(road3.getOwner()).andReturn(1);

        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement.getOwner()).andReturn(1);
        EasyMock.expect(settlement.getRoads()).andReturn(s1Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(settlement2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(1);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(settlement2.getOwner()).andReturn(1);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(1);

       

        EasyMock.replay(road, road2, settlement, settlement2, settlement3, road3);

        player.addSettlement(settlement);
        player.addSettlement(settlement3);
        player.addRoad(road3);
        player.addRoad(road);
        player.addRoad(road2);
        

        int result = player.getRoadLength();

        EasyMock.verify(road, road2, settlement, settlement2, settlement3, road3);
        Assertions.assertEquals(2, result);
    }
    
    @Test
    public void test_getRoadLength_15Roads_expectLength15() {
        Player player = new Player(1);
        Road r1 = EasyMock.createMock(Road.class);
        Road r2 = EasyMock.createMock(Road.class);
        Road r3 = EasyMock.createMock(Road.class);
        Road r4 = EasyMock.createMock(Road.class);
        Road r5 = EasyMock.createMock(Road.class);
        Road r6 = EasyMock.createMock(Road.class);
        Road r7 = EasyMock.createMock(Road.class);
        Road r8 = EasyMock.createMock(Road.class);
        Road r9 = EasyMock.createMock(Road.class);
        Road r10 = EasyMock.createMock(Road.class);
        Road r11 = EasyMock.createMock(Road.class);
        Road r12 = EasyMock.createMock(Road.class);
        Road r13 = EasyMock.createMock(Road.class);
        Road r14 = EasyMock.createMock(Road.class);
        Road r15 = EasyMock.createMock(Road.class);
        SettlementLocation s1 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s5 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s6 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s7 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s8 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s9 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s10 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s11 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s12 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s13 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s14 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s15 = EasyMock.createMock(SettlementLocation.class);

        List<SettlementLocation> r1SettlementLocations = new ArrayList<>();
        r1SettlementLocations.add(s1);
        r1SettlementLocations.add(s2);

        List<SettlementLocation> r2SettlementLocations = new ArrayList<>();
        r2SettlementLocations.add(s2);
        r2SettlementLocations.add(s3);

        List<SettlementLocation> r3SettlementLocations = new ArrayList<>();
        r3SettlementLocations.add(s3);
        r3SettlementLocations.add(s4);

        List<SettlementLocation> r4SettlementLocations = new ArrayList<>();
        r4SettlementLocations.add(s4);
        r4SettlementLocations.add(s5);        

        List<SettlementLocation> r5SettlementLocations = new ArrayList<>();
        r5SettlementLocations.add(s5);
        r5SettlementLocations.add(s6);

        List<SettlementLocation> r6SettlementLocations = new ArrayList<>();
        r6SettlementLocations.add(s6);
        r6SettlementLocations.add(s7);

        List<SettlementLocation> r7SettlementLocations = new ArrayList<>();
        r7SettlementLocations.add(s7);
        r7SettlementLocations.add(s8);

        List<SettlementLocation> r8SettlementLocations = new ArrayList<>();
        r8SettlementLocations.add(s8);
        r8SettlementLocations.add(s9);

        List<SettlementLocation> r9SettlementLocations = new ArrayList<>();
        r9SettlementLocations.add(s9);
        r9SettlementLocations.add(s10);

        List<SettlementLocation> r10SettlementLocations = new ArrayList<>();
        r10SettlementLocations.add(s10);
        r10SettlementLocations.add(s11);

        List<SettlementLocation> r11SettlementLocations = new ArrayList<>();
        r11SettlementLocations.add(s11);
        r11SettlementLocations.add(s12);

        List<SettlementLocation> r12SettlementLocations = new ArrayList<>();
        r12SettlementLocations.add(s12);
        r12SettlementLocations.add(s13);

        List<SettlementLocation> r13SettlementLocations = new ArrayList<>();
        r13SettlementLocations.add(s13);
        r13SettlementLocations.add(s14);

        List<SettlementLocation> r14SettlementLocations = new ArrayList<>();
        r14SettlementLocations.add(s14);
        r14SettlementLocations.add(s15);

        List<SettlementLocation> r15SettlementLocations = new ArrayList<>();
        r15SettlementLocations.add(s15);
        // r15SettlementLocations.add(s16);

        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(r1);

        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(r1);
        s2Roads.add(r2);

        List<Road> s3Roads = new ArrayList<>();
        s3Roads.add(r2);
        s3Roads.add(r3);

        List<Road> s4Roads = new ArrayList<>();
        s4Roads.add(r3);
        s4Roads.add(r4);

        List<Road> s5Roads = new ArrayList<>();
        s5Roads.add(r4);
        s5Roads.add(r5);

        List<Road> s6Roads = new ArrayList<>();
        s6Roads.add(r5);
        s6Roads.add(r6);

        List<Road> s7Roads = new ArrayList<>();
        s7Roads.add(r6);
        s7Roads.add(r7);

        List<Road> s8Roads = new ArrayList<>();
        s8Roads.add(r7);
        s8Roads.add(r8);

        List<Road> s9Roads = new ArrayList<>();
        s9Roads.add(r8);
        s9Roads.add(r9);

        List<Road> s10Roads = new ArrayList<>();
        s10Roads.add(r9);
        s10Roads.add(r10);

        List<Road> s11Roads = new ArrayList<>();
        s11Roads.add(r10);
        s11Roads.add(r11);

        List<Road> s12Roads = new ArrayList<>();
        s12Roads.add(r11);
        s12Roads.add(r12);

        List<Road> s13Roads = new ArrayList<>();
        s13Roads.add(r12);
        s13Roads.add(r13);

        List<Road> s14Roads = new ArrayList<>();
        s14Roads.add(r13);
        s14Roads.add(r14);

        List<Road> s15Roads = new ArrayList<>();
        s15Roads.add(r14);
        s15Roads.add(r15);

        //addSettlement
        EasyMock.expect(s1.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s1.setOwner(1)).andReturn(true);

        //addRoad r1
        EasyMock.expect(r1.getOwner()).andReturn(0);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r1.setOwner(1)).andReturn(true);

        //addRoad r2
        EasyMock.expect(r2.getOwner()).andReturn(0);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(s2.getOwner()).andReturn(0);
        EasyMock.expect(r2.setOwner(1)).andReturn(true);

        //addRoad r3
        EasyMock.expect(r3.getOwner()).andReturn(0);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(s3.getOwner()).andReturn(0);
        EasyMock.expect(r3.setOwner(1)).andReturn(true);

        //addRoad r4
        EasyMock.expect(r4.getOwner()).andReturn(0);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(s4.getOwner()).andReturn(0);
        EasyMock.expect(r4.setOwner(1)).andReturn(true);

        //addRoad r5
        EasyMock.expect(r5.getOwner()).andReturn(0);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(s5.getOwner()).andReturn(0);
        EasyMock.expect(r5.setOwner(1)).andReturn(true);

        //addRoad r6
        EasyMock.expect(r6.getOwner()).andReturn(0);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(s6.getOwner()).andReturn(0);
        EasyMock.expect(r6.setOwner(1)).andReturn(true);

        //addRoad r7
        EasyMock.expect(r7.getOwner()).andReturn(0);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(s7.getOwner()).andReturn(0);
        EasyMock.expect(r7.setOwner(1)).andReturn(true);

        //addRoad r8
        EasyMock.expect(r8.getOwner()).andReturn(0);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(s8.getOwner()).andReturn(0);
        EasyMock.expect(r8.setOwner(1)).andReturn(true);

        //addRoad r9
        EasyMock.expect(r9.getOwner()).andReturn(0);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(s9.getOwner()).andReturn(0);
        EasyMock.expect(r9.setOwner(1)).andReturn(true);

        //addRoad r10
        EasyMock.expect(r10.getOwner()).andReturn(0);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(s10.getOwner()).andReturn(0);
        EasyMock.expect(r10.setOwner(1)).andReturn(true);

        //addRoad r11
        EasyMock.expect(r11.getOwner()).andReturn(0);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(s11.getOwner()).andReturn(0);
        EasyMock.expect(r11.setOwner(1)).andReturn(true);

        //addRoad r12
        EasyMock.expect(r12.getOwner()).andReturn(0);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(s12.getOwner()).andReturn(0);
        EasyMock.expect(r12.setOwner(1)).andReturn(true);

        //addRoad r13
        EasyMock.expect(r13.getOwner()).andReturn(0);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(s13.getOwner()).andReturn(0);
        EasyMock.expect(r13.setOwner(1)).andReturn(true);

        //addRoad r14
        EasyMock.expect(r14.getOwner()).andReturn(0);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(s14.getOwner()).andReturn(0);
        EasyMock.expect(r14.setOwner(1)).andReturn(true);

        //addRoad r15
        EasyMock.expect(r15.getOwner()).andReturn(0);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations).times(2);
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(s15.getOwner()).andReturn(0);
        EasyMock.expect(r15.setOwner(1)).andReturn(true);

        //getRoadLength
        EasyMock.expect(r1.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(s1.getOwner()).andReturn(1);
        EasyMock.expect(s1.getRoads()).andReturn(s1Roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(r2.getOwner()).andReturn(1);
        EasyMock.expect(r2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(r1.getOwner()).andReturn(1);
        EasyMock.expect(r2.getOwner()).andReturn(1);
        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);
        EasyMock.expect(r3.getOwner()).andReturn(1);
        EasyMock.expect(r3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.getRoads()).andReturn(s3Roads);
        EasyMock.expect(r2.getOwner()).andReturn(1);
        EasyMock.expect(r3.getOwner()).andReturn(1);
        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.getRoads()).andReturn(s4Roads);
        EasyMock.expect(r3.getOwner()).andReturn(1);
        EasyMock.expect(r4.getOwner()).andReturn(1);
        EasyMock.expect(r4.getSettlements()).andReturn(r4SettlementLocations);
        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.getRoads()).andReturn(s4Roads);
        EasyMock.expect(r3.getOwner()).andReturn(1);
        EasyMock.expect(r4.getOwner()).andReturn(1);
        EasyMock.expect(s5.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s5.getRoads()).andReturn(s5Roads);
        EasyMock.expect(r4.getOwner()).andReturn(1);
        EasyMock.expect(r5.getOwner()).andReturn(1);
        EasyMock.expect(r5.getSettlements()).andReturn(r5SettlementLocations);
        EasyMock.expect(s5.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s5.getRoads()).andReturn(s5Roads);
        EasyMock.expect(r4.getOwner()).andReturn(1);
        EasyMock.expect(r5.getOwner()).andReturn(1);
        EasyMock.expect(s6.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s6.getRoads()).andReturn(s6Roads);
        EasyMock.expect(r5.getOwner()).andReturn(1);
        EasyMock.expect(r6.getOwner()).andReturn(1);
        EasyMock.expect(r6.getSettlements()).andReturn(r6SettlementLocations);
        EasyMock.expect(s6.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s6.getRoads()).andReturn(s6Roads);
        EasyMock.expect(r5.getOwner()).andReturn(1);
        EasyMock.expect(r6.getOwner()).andReturn(1);
        EasyMock.expect(s7.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s7.getRoads()).andReturn(s7Roads);
        EasyMock.expect(r6.getOwner()).andReturn(1);
        EasyMock.expect(r7.getOwner()).andReturn(1);
        EasyMock.expect(r7.getSettlements()).andReturn(r7SettlementLocations);
        EasyMock.expect(s7.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s7.getRoads()).andReturn(s7Roads);
        EasyMock.expect(r6.getOwner()).andReturn(1);
        EasyMock.expect(r7.getOwner()).andReturn(1);
        EasyMock.expect(s8.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s8.getRoads()).andReturn(s8Roads);
        EasyMock.expect(r7.getOwner()).andReturn(1);
        EasyMock.expect(r8.getOwner()).andReturn(1);
        EasyMock.expect(r8.getSettlements()).andReturn(r8SettlementLocations);
        EasyMock.expect(s8.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s8.getRoads()).andReturn(s8Roads);
        EasyMock.expect(r7.getOwner()).andReturn(1);
        EasyMock.expect(r8.getOwner()).andReturn(1);
        EasyMock.expect(s9.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s9.getRoads()).andReturn(s9Roads);
        EasyMock.expect(r8.getOwner()).andReturn(1);
        EasyMock.expect(r9.getOwner()).andReturn(1);
        EasyMock.expect(r9.getSettlements()).andReturn(r9SettlementLocations);
        EasyMock.expect(s9.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s9.getRoads()).andReturn(s9Roads);
        EasyMock.expect(r8.getOwner()).andReturn(1);
        EasyMock.expect(r9.getOwner()).andReturn(1);
        EasyMock.expect(s10.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s10.getRoads()).andReturn(s10Roads);
        EasyMock.expect(r9.getOwner()).andReturn(1);
        EasyMock.expect(r10.getOwner()).andReturn(1);
        EasyMock.expect(r10.getSettlements()).andReturn(r10SettlementLocations);
        EasyMock.expect(s10.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s10.getRoads()).andReturn(s10Roads);
        EasyMock.expect(r9.getOwner()).andReturn(1);
        EasyMock.expect(r10.getOwner()).andReturn(1);
        EasyMock.expect(s11.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s11.getRoads()).andReturn(s11Roads);
        EasyMock.expect(r10.getOwner()).andReturn(1);
        EasyMock.expect(r11.getOwner()).andReturn(1);
        EasyMock.expect(r11.getSettlements()).andReturn(r11SettlementLocations);
        EasyMock.expect(s11.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s11.getRoads()).andReturn(s11Roads);
        EasyMock.expect(r10.getOwner()).andReturn(1);
        EasyMock.expect(r11.getOwner()).andReturn(1);
        EasyMock.expect(s12.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s12.getRoads()).andReturn(s12Roads);
        EasyMock.expect(r11.getOwner()).andReturn(1);
        EasyMock.expect(r12.getOwner()).andReturn(1);
        EasyMock.expect(r12.getSettlements()).andReturn(r12SettlementLocations);
        EasyMock.expect(s12.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s12.getRoads()).andReturn(s12Roads);
        EasyMock.expect(r11.getOwner()).andReturn(1);
        EasyMock.expect(r12.getOwner()).andReturn(1);
        EasyMock.expect(s13.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s13.getRoads()).andReturn(s13Roads);
        EasyMock.expect(r12.getOwner()).andReturn(1);
        EasyMock.expect(r13.getOwner()).andReturn(1);
        EasyMock.expect(r13.getSettlements()).andReturn(r13SettlementLocations);
        EasyMock.expect(s13.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s13.getRoads()).andReturn(s13Roads);
        EasyMock.expect(r12.getOwner()).andReturn(1);
        EasyMock.expect(r13.getOwner()).andReturn(1);
        EasyMock.expect(s14.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s14.getRoads()).andReturn(s14Roads);
        EasyMock.expect(r13.getOwner()).andReturn(1);
        EasyMock.expect(r14.getOwner()).andReturn(1);
        EasyMock.expect(r14.getSettlements()).andReturn(r14SettlementLocations);
        EasyMock.expect(s14.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s14.getRoads()).andReturn(s14Roads);
        EasyMock.expect(r13.getOwner()).andReturn(1);
        EasyMock.expect(r14.getOwner()).andReturn(1);
        EasyMock.expect(s15.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s15.getRoads()).andReturn(s15Roads);
        EasyMock.expect(r14.getOwner()).andReturn(1);
        EasyMock.expect(r15.getOwner()).andReturn(1);
        EasyMock.expect(r15.getSettlements()).andReturn(r15SettlementLocations);
        EasyMock.expect(s15.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s15.getRoads()).andReturn(s15Roads);
        EasyMock.expect(r14.getOwner()).andReturn(1);
        EasyMock.expect(r15.getOwner()).andReturn(1);


        EasyMock.replay(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,
                s11, s12, s13, s14, s15);

        player.addSettlement(s1);
        player.addRoad(r1);
        player.addRoad(r2);
        player.addRoad(r3);
        player.addRoad(r4);
        player.addRoad(r5);
        player.addRoad(r6);
        player.addRoad(r7);
        player.addRoad(r8);
        player.addRoad(r9);
        player.addRoad(r10);
        player.addRoad(r11);
        player.addRoad(r12);
        player.addRoad(r13);
        player.addRoad(r14);
        player.addRoad(r15);

        int result = player.getRoadLength();
        EasyMock.verify(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,
                s11, s12, s13, s14, s15);

        Assertions.assertEquals(15, result);
    }

    @Test
    public void test_getRoadLength_with3Roads_opponentSettlementCuts_expectLength2() {
        Player player = new Player(1);
        Player player2 = new Player(2);
        Road road = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        Road road3 = EasyMock.createMock(Road.class);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement3 = EasyMock.createMock(SettlementLocation.class);

        List<SettlementLocation> r1SettlementLocations = new ArrayList<>();
        r1SettlementLocations.add(settlement);
        r1SettlementLocations.add(settlement2);


        List<SettlementLocation> r2SettlementLocations = new ArrayList<>();
        r2SettlementLocations.add(settlement2);
        r2SettlementLocations.add(settlement3);

        List<SettlementLocation> r3SettlementLocations = new ArrayList<>();
        r3SettlementLocations.add(settlement3);


        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(road);
        
        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(road);
        s2Roads.add(road2);

       

        //addSettlement settlement
        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);

        
        //addRoad road
        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(road.setOwner(1)).andReturn(true);


        //addRoad road2
        EasyMock.expect(road2.getOwner()).andReturn(0);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations).times(2);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement2.getOwner()).andReturn(0);
        EasyMock.expect(road2.setOwner(1)).andReturn(true);

        //addRoad road3
        EasyMock.expect(road3.getOwner()).andReturn(0);
        EasyMock.expect(road3.getSettlements()).andReturn(r3SettlementLocations).times(2);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(road3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(settlement3.getOwner()).andReturn(0);
        EasyMock.expect(road3.setOwner(1)).andReturn(true);


        //addSettlement settlement3
        EasyMock.expect(settlement3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement3.setOwner(2)).andReturn(true);

        //getRoadLength
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement.getOwner()).andReturn(1);
        EasyMock.expect(settlement.getRoads()).andReturn(s1Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(settlement2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(1);

        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(settlement2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(1);
        EasyMock.expect(settlement3.getOwner()).andReturn(2).times(2);

        EasyMock.expect(road3.getSettlements()).andReturn(r3SettlementLocations);
        EasyMock.expect(settlement3.getOwner()).andReturn(2).times(2);




        EasyMock.replay(road, road2, road3, settlement, settlement2, settlement3);

        player.addSettlement(settlement);
        player.addRoad(road);
        player.addRoad(road2);
        player.addRoad(road3);
        player2.addSettlement(settlement3);

        int result = player.getRoadLength();
        EasyMock.verify(road, road2, road3, settlement, settlement2, settlement3);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_getRoadLength_oneRoad_adjacentOpponentRoad_expectLength1() {
        Player player = new Player(1);
        Player player2 = new Player(2);
        Road road = EasyMock.createMock(Road.class);
        Road road2 = EasyMock.createMock(Road.class);
        SettlementLocation settlement = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation settlement3 = EasyMock.createMock(SettlementLocation.class);

        List<SettlementLocation> r1SettlementLocations = new ArrayList<>();
        r1SettlementLocations.add(settlement);
        r1SettlementLocations.add(settlement2);

        List<SettlementLocation> r2SettlementLocations = new ArrayList<>();
        r2SettlementLocations.add(settlement2);
        r2SettlementLocations.add(settlement3);

        List<Road> s1Roads = new ArrayList<>();
        s1Roads.add(road);

        List<Road> s2Roads = new ArrayList<>();
        s2Roads.add(road);
        s2Roads.add(road2);

        EasyMock.expect(settlement.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement.setOwner(1)).andReturn(true);

        EasyMock.expect(settlement3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement3.setOwner(2)).andReturn(true);

        EasyMock.expect(road.getOwner()).andReturn(0);
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(road.setOwner(1)).andReturn(true);
        
        EasyMock.expect(road2.getOwner()).andReturn(0);
        EasyMock.expect(road2.getSettlements()).andReturn(r2SettlementLocations);
        EasyMock.expect(road2.setOwner(2)).andReturn(true);

        //getRoadLength
        EasyMock.expect(road.getSettlements()).andReturn(r1SettlementLocations);
        EasyMock.expect(settlement.getOwner()).andReturn(1);
        EasyMock.expect(settlement.getRoads()).andReturn(s1Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(settlement2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(settlement2.getRoads()).andReturn(s2Roads);
        EasyMock.expect(road.getOwner()).andReturn(1);
        EasyMock.expect(road2.getOwner()).andReturn(2);



        EasyMock.replay(road, road2, settlement, settlement2, settlement3);

        player.addSettlement(settlement);
        player2.addSettlement(settlement3);
        player.addRoad(road);
        player2.addRoad(road2);

        int result = player.getRoadLength();

        EasyMock.verify(road, road2, settlement, settlement2, settlement3);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testPlayer_removeDevelopmentCard_NoDevCards0Index_except() {
        Player player = new Player(new ArrayList<DevelopmentCard>());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            player.removeDevelopmentCard(0);
        }, "IndexOutOfBoundsException should be thrown");
    }


    @Test
    public void testPlayer_removeDevelopmentCard_1DevCard0IndexNoVP_Knight() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        devCards.add(EasyMock.createMock(Knight.class));
        Player player = new Player(devCards);
        DevelopmentCard chosen = devCards.get(0);
        EasyMock.expect(devCards.get(0).string()).andReturn("Knight");
        EasyMock.replay(devCards.get(0));
        Assertions.assertEquals(devCards.get(0), player.removeDevelopmentCard(0));
        Assertions.assertEquals(0, player.getOwnedDevelopmentCards().size());
        Assertions.assertEquals(1, player.getArmySize());
        EasyMock.verify(chosen);
    }

    @Test
    public void testPlayer_removeDevelopmentCard_2DevCards1IndexNoVP_Monopoly() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        devCards.add(EasyMock.createMock(Knight.class));
        devCards.add(EasyMock.createMock(Monopoly.class));
        Player player = new Player(devCards);
        DevelopmentCard chosen = devCards.get(1);
        EasyMock.expect(devCards.get(1).string()).andReturn("Monopoly");
        EasyMock.replay(devCards.get(1));
        Assertions.assertEquals(devCards.get(1), player.removeDevelopmentCard(1));
        Assertions.assertEquals(1, player.getOwnedDevelopmentCards().size());
        Assertions.assertEquals(0, player.getArmySize());
        EasyMock.verify(chosen);
    }

    @Test
    public void testPlayer_removeDevelopmentCard_25DevCards20IndexNoVP_YearofPlenty() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        for(int i = 0; i < 14; i++) {
            devCards.add(EasyMock.createMock(Knight.class));
        }
        for(int i = 0; i < 5; i++) {
            devCards.add(EasyMock.createMock(VictoryPoint.class));
        }
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(YearofPlenty.class));
        }
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(RoadBuilding.class));
        }
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(Monopoly.class));
        }
        DevelopmentCard chosen = devCards.get(20);
        Player player = new Player(devCards);
        EasyMock.expect(devCards.get(20).string()).andReturn("Year of Plenty");
        EasyMock.replay(devCards.get(20));
        Assertions.assertEquals(devCards.get(20), player.removeDevelopmentCard(20));
        Assertions.assertEquals(24, player.getOwnedDevelopmentCards().size());
        EasyMock.verify(chosen);
    }

    @Test
    public void testPlayer_removeDevelopmentCard_2DevCardsNegOneIndex_except() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(Monopoly.class));
        }
        Player player = new Player(devCards);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            player.removeDevelopmentCard(-1);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void testPlayer_removeDevelopmentCard_5DevCards0IndexNoVP_RoadBuilding() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(RoadBuilding.class));
        }
        for(int i = 0; i < 3; i++) {
            devCards.add(EasyMock.createMock(Knight.class));
        }
        DevelopmentCard chosen = devCards.get(0);
        Player player = new Player(devCards);
        EasyMock.expect(devCards.get(0).string()).andReturn("Road Building");
        EasyMock.replay(devCards.get(0));
        Assertions.assertEquals(devCards.get(0), player.removeDevelopmentCard(0));
        Assertions.assertEquals(4, player.getOwnedDevelopmentCards().size());
        Assertions.assertEquals(0, player.getArmySize());
        EasyMock.verify(chosen);
    }

    @Test
    public void testPlayer_removeDevelopmentCard_3DevCards2IndexVP_VictoryPoint() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(RoadBuilding.class));
        }
        devCards.add(EasyMock.createMock(VictoryPoint.class));
        EasyMock.expect(devCards.get(2).string()).andReturn("Victory Point");
        Player player = new Player(devCards);
        EasyMock.replay(devCards.get(2));
        Assertions.assertEquals(devCards.get(2), player.removeDevelopmentCard(2));
        Assertions.assertEquals(3, player.getOwnedDevelopmentCards().size());
        Assertions.assertEquals(0, player.getArmySize());
        EasyMock.verify(devCards.get(2));
    }

    @Test
    public void testPlayer_removeDevelopmentCard_3DevCards3Index_except() {
        List<DevelopmentCard> devCards = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            devCards.add(EasyMock.createMock(RoadBuilding.class));
        }
        devCards.add(EasyMock.createMock(VictoryPoint.class));
        Player player = new Player(devCards);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            player.removeDevelopmentCard(3);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void test_getPossibleCityLocations_0Settlement_expectEmptySet() {
        Player player = new Player(1);

        Set<SettlementLocation> loc = player.getPossibleCityLocations();

        Assertions.assertEquals(0, loc.size());
    }

    @Test
    public void test_getPossibleCityLocations_1Settlement_expectSetOfSize1() {
        Player player = new Player(1);
        SettlementLocation s = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(s.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s.setOwner(1)).andReturn(true);
        EasyMock.expect(s.getMultiplier()).andReturn(1);
        EasyMock.replay(s);

        player.addSettlement(s);
        Set<SettlementLocation> loc = player.getPossibleCityLocations();
        EasyMock.verify(s);
        Assertions.assertEquals(1, loc.size());
        Assertions.assertTrue(loc.contains(s));
    }

    @Test
    public void test_getPossibleCityLocations_1City_expectEmptySet() {
        Player player = new Player(1);
        SettlementLocation s = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(s.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s.setOwner(1)).andReturn(true);
        EasyMock.expect(s.getOwner()).andReturn(1);
        s.convertToCity();
        EasyMock.expect(s.getMultiplier()).andReturn(2);
        EasyMock.replay(s);

        player.addSettlement(s);
        player.addSettlement(s);
        Set<SettlementLocation> loc = player.getPossibleCityLocations();
        EasyMock.verify(s);

        Assertions.assertEquals(0, loc.size());
    }

    @Test
    public void test_getPossibleCityLocations_3SettlementAnd1City_expectSetOfSize1() {
        Player player = new Player(1);
        SettlementLocation s = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(s.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s.setOwner(1)).andReturn(true);
        EasyMock.expect(s.getOwner()).andReturn(1);
        s.convertToCity();

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true);
        EasyMock.expect(s2.getOwner()).andReturn(1);
        s2.convertToCity();

        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.setOwner(1)).andReturn(true);
        EasyMock.expect(s3.getOwner()).andReturn(1);
        s3.convertToCity();

        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.setOwner(1)).andReturn(true);


        EasyMock.expect(s.getMultiplier()).andReturn(2);
        EasyMock.expect(s2.getMultiplier()).andReturn(2);
        EasyMock.expect(s3.getMultiplier()).andReturn(2);
        EasyMock.expect(s4.getMultiplier()).andReturn(1);
        EasyMock.replay(s, s2, s3, s4);

        player.addSettlement(s);
        player.addSettlement(s);
        player.addSettlement(s2);
        player.addSettlement(s2);
        player.addSettlement(s3);
        player.addSettlement(s3);
        player.addSettlement(s4);
        
        Set<SettlementLocation> loc = player.getPossibleCityLocations();
        EasyMock.verify(s, s2, s3, s4);

        Assertions.assertEquals(1, loc.size());
        Assertions.assertTrue(loc.contains(s4));
    }

    @Test
    public void test_getPossibleCityLocations_4Cities_expectException() {
        Player player = new Player(1);

        SettlementLocation s = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s3 = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s4 = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(s.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s.setOwner(1)).andReturn(true);
        EasyMock.expect(s.getOwner()).andReturn(1);
        s.convertToCity();

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true);
        EasyMock.expect(s2.getOwner()).andReturn(1);
        s2.convertToCity();

        EasyMock.expect(s3.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s3.setOwner(1)).andReturn(true);
        EasyMock.expect(s3.getOwner()).andReturn(1);
        s3.convertToCity();

        EasyMock.expect(s4.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s4.setOwner(1)).andReturn(true);
        EasyMock.expect(s4.getOwner()).andReturn(1);
        s4.convertToCity();

        EasyMock.replay(s, s2, s3, s4);

        player.addSettlement(s);
        player.addSettlement(s);
        player.addSettlement(s2);
        player.addSettlement(s2);
        player.addSettlement(s3);
        player.addSettlement(s3);
        player.addSettlement(s4);
        player.addSettlement(s4);
        
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            Set<SettlementLocation> loc = player.getPossibleCityLocations();
        });

        EasyMock.verify(s, s2, s3, s4);

        String expectedMessage = "Max amount of Cities reached";

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_getPossibleCityLocations_2Settlement_expectSetOfSize2() {
        Player player = new Player(1);

        SettlementLocation s = EasyMock.createMock(SettlementLocation.class);
        SettlementLocation s2 = EasyMock.createMock(SettlementLocation.class);
       

        EasyMock.expect(s.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s.setOwner(1)).andReturn(true);
        EasyMock.expect(s.getMultiplier()).andReturn(1);
        

        EasyMock.expect(s2.getOwner()).andReturn(0).times(2);
        EasyMock.expect(s2.setOwner(1)).andReturn(true);
        EasyMock.expect(s2.getMultiplier()).andReturn(1);

        EasyMock.replay(s, s2);

        player.addSettlement(s);
        player.addSettlement(s2);
        Set<SettlementLocation> loc = player.getPossibleCityLocations();

        EasyMock.verify(s, s2);

        Assertions.assertEquals(2, loc.size());
        Assertions.assertTrue(loc.contains(s));
        Assertions.assertTrue(loc.contains(s2));
    }


}
