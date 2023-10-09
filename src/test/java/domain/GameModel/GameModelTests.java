package domain.GameModel;

import javax.annotation.CheckReturnValue;

import domain.DevelopmentCards.*;
import domain.Resource;
import domain.Roads.Road;
import domain.Settlements.SettlementLocation;
import domain.Terrain.Terrain;
import domain.Terrain.TerrainTypes;
import org.easymock.EasyMock;
import org.easymock.MockType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.player.Player;

import java.security.InvalidParameterException;
import java.util.*;

public class GameModelTests {
    @Test
    @CheckReturnValue
    public void testGetPlayerResources_withNegativeOne_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Map<Resource, Integer> r = gm.getPlayerResources(-1);
        }, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlayerResources_with3_ReturnEmpty() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        EasyMock.expect(l.get(3).getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resources = new HashMap<>();
        resources.put(Resource.WHEAT, 0);
        resources.put(Resource.ORE, 0);
        resources.put(Resource.BRICK, 0);
        resources.put(Resource.LUMBER, 0);
        resources.put(Resource.WOOL, 0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(resources, gm.getPlayerResources(3));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlayerResources_with0_Return95() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        EasyMock.expect(l.get(0).getResourceAmount(Resource.ORE)).andReturn(19);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.WOOL)).andReturn(19);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.LUMBER)).andReturn(19);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.WHEAT)).andReturn(19);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.BRICK)).andReturn(19);
        Map<Resource, Integer> resources = new HashMap<>();
        resources.put(Resource.WHEAT, 19);
        resources.put(Resource.ORE, 19);
        resources.put(Resource.BRICK, 19);
        resources.put(Resource.LUMBER, 19);
        resources.put(Resource.WOOL, 19);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(resources, gm.getPlayerResources(0));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));

    }

    @Test
    @CheckReturnValue
    public void testGetPlayerResources_with4_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Map<Resource, Integer> r = gm.getPlayerResources(4);
        }, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));

    }

    @Test
    public void testGetPlayerResources_with2_TwoResources() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        EasyMock.expect(l.get(2).getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.WOOL)).andReturn(1);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resources = new HashMap<>();
        resources.put(Resource.WHEAT, 0);
        resources.put(Resource.ORE, 0);
        resources.put(Resource.BRICK, 0);
        resources.put(Resource.LUMBER, 1);
        resources.put(Resource.WOOL, 1);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(resources, gm.getPlayerResources(2));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlayerResources_with1_OneResource() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        EasyMock.expect(l.get(1).getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resources = new HashMap<>();
        resources.put(Resource.WHEAT, 0);
        resources.put(Resource.ORE, 0);
        resources.put(Resource.BRICK, 0);
        resources.put(Resource.LUMBER, 1);
        resources.put(Resource.WOOL, 0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(resources, gm.getPlayerResources(1));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetDevelopmentCardCount_EmptyDeck_Zero() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(0, gm.getDevelopmentCardCount());
    }

    @Test
    public void testGetDevelopmentCardCount_OneCard_One() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        developmentCards.add(EasyMock.createMock(Knight.class));
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(1, gm.getDevelopmentCardCount());
    }

    @Test
    public void testGetDevelopmentCardCount_TwoCards_Two() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        developmentCards.add(EasyMock.createMock(Knight.class));
        developmentCards.add(EasyMock.createMock(VictoryPoint.class));
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(2, gm.getDevelopmentCardCount());
    }

    @Test
    public void testGetDevelopmentCardCount_MaxCards_25() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            developmentCards.add(EasyMock.createMock(Knight.class));
        }
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(25, gm.getDevelopmentCardCount());
    }


    @Test
    public void testHasResources_PlayerThreeOneResource_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(3);
        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(1);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resourceAmounts = new HashMap<>();
        resourceAmounts.put(Resource.WHEAT, 0);
        resourceAmounts.put(Resource.ORE, 0);
        resourceAmounts.put(Resource.WOOL, 1);
        resourceAmounts.put(Resource.BRICK, 0);
        resourceAmounts.put(Resource.LUMBER, 0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.hasResources(3, resourceAmounts));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testHasResources_PlayerZeroEmptyHand_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(0);
        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resourceAmounts = new HashMap<>();
        resourceAmounts.put(Resource.WHEAT, 0);
        resourceAmounts.put(Resource.ORE, 0);
        resourceAmounts.put(Resource.WOOL, 0);
        resourceAmounts.put(Resource.BRICK, 0);
        resourceAmounts.put(Resource.LUMBER, 0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);

        Assertions.assertTrue(gm.hasResources(0, resourceAmounts));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testHasResources_PlayerOneTwoResources_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(1);
        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(1);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resourceAmounts = new HashMap<>();
        resourceAmounts.put(Resource.WHEAT, 1);
        resourceAmounts.put(Resource.ORE, 0);
        resourceAmounts.put(Resource.WOOL, 0);
        resourceAmounts.put(Resource.BRICK, 0);
        resourceAmounts.put(Resource.LUMBER, 1);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);

        Assertions.assertTrue(gm.hasResources(1, resourceAmounts));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testHasResources_PlayerTwoNinetyFiveResources_False() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(1);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(16);
        Map<Resource, Integer> resourceAmounts = new HashMap<>();
        resourceAmounts.put(Resource.WHEAT, 19);
        resourceAmounts.put(Resource.ORE, 19);
        resourceAmounts.put(Resource.WOOL, 19);
        resourceAmounts.put(Resource.BRICK, 19);
        resourceAmounts.put(Resource.LUMBER, 19);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);

        Assertions.assertFalse(gm.hasResources(1, resourceAmounts));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testHasResources_PlayerTwoAllButOneResource_False() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(3);
        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(1);
        Map<Resource, Integer> resourceAmounts = new HashMap<>();
        resourceAmounts.put(Resource.WHEAT, 1);
        resourceAmounts.put(Resource.ORE, 0);
        resourceAmounts.put(Resource.WOOL, 0);
        resourceAmounts.put(Resource.BRICK, 0);
        resourceAmounts.put(Resource.LUMBER, 0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);

        Assertions.assertFalse(gm.hasResources(2, resourceAmounts));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }


    @Test
    public void testHasResources_PlayerOneEmptyHand_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(1);
        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);
        Map<Resource, Integer> resourceAmounts = new HashMap<>();
        resourceAmounts.put(Resource.WHEAT, 0);
        resourceAmounts.put(Resource.ORE, 0);
        resourceAmounts.put(Resource.WOOL, 0);
        resourceAmounts.put(Resource.BRICK, 0);
        resourceAmounts.put(Resource.LUMBER, 0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);

        Assertions.assertTrue(gm.hasResources(1, resourceAmounts));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    @CheckReturnValue
    public void testHasResources_PlayerMax_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            boolean r = gm.hasResources(4, new HashMap<Resource, Integer>());
        }, "IndexOutOfBoundsException should be called");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testHasResources_PlayerNegativeOne_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            boolean r = gm.hasResources(-1, new HashMap<Resource, Integer>());
        }, "IndexOutOfBoundsException should be called");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerNegativeOne_Except() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.tradeResources(-1, 0, new HashMap<Resource, Integer>(), new HashMap<Resource, Integer>());
        }, "IndexOutOfBoundsException should be called");
    }

    @Test
    public void testTradeResources_FirstPlayerZeroSecondPlayerOneBothHaveEnough_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(0);
        Player player2 = l.get(1);
        EasyMock.expect(player.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);

        EasyMock.expect(player2.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.ORE)).andReturn(3);
        EasyMock.expect(player2.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.BRICK)).andReturn(0);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 0);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 0);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.tradeResources(0, 1, traded, traded));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerThreeSecondPlayerTwoSecondNotEnough_False() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(3);
        Player player2 = l.get(2);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);

        EasyMock.expect(player2.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.ORE)).andReturn(3);
        EasyMock.expect(player2.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.BRICK)).andReturn(0);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 0);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 2);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertFalse(gm.tradeResources(3, 2, traded, traded));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerFour_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.tradeResources(4, 3, new HashMap<Resource, Integer>(), new HashMap<Resource, Integer>());
        }, "IndexOutOfBoundsException should be called");
    }

    @Test
    public void testTradeResources_SecondPlayerNegativeOne_Except() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.tradeResources(0, -1, new HashMap<Resource, Integer>(), new HashMap<Resource, Integer>());
        }, "IndexOutOfBoundsException should be called");
    }

    @Test
    public void testTradeResources_SecondPlayerFour_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(3);
        //Player player2 = l.get(0);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(19);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 0);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 10);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.tradeResources(3, 4, traded, traded);
        }, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerOneSecondPlayerZeroBothNotEnough_False() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(1);
        //Player player2 = l.get(0);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 0);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 10);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertFalse(gm.tradeResources(1, 0, traded, traded));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerTwoSecondPlayerThreeFirstNotEnough_False() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(2);
        //Player player2 = l.get(3);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(3);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(4);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(9);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(5);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 0);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 10);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertFalse(gm.tradeResources(2, 3, traded, traded));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerOneSecondPlayerTwoEmptyCollections_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(2);
        Player player2 = l.get(3);
        EasyMock.expect(player.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);

        EasyMock.expect(player2.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.ORE)).andReturn(3);
        EasyMock.expect(player2.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.BRICK)).andReturn(0);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 0);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 0);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.tradeResources(2, 3, traded, traded));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerZeroSecondPlayerOneSizeOneTradePossible_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(0);
        Player player2 = l.get(1);
        EasyMock.expect(player.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);

        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);

        EasyMock.expect(player2.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.ORE)).andReturn(3);
        EasyMock.expect(player2.getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player2.getResourceAmount(Resource.BRICK)).andReturn(0);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 1);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 0);

        Map<Resource, Integer> tradedFor = new HashMap<>();
        tradedFor.put(Resource.ORE, 1);
        tradedFor.put(Resource.WOOL, 0);
        tradedFor.put(Resource.LUMBER, 0);
        tradedFor.put(Resource.BRICK, 0);
        tradedFor.put(Resource.WHEAT, 0);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.tradeResources(0, 1, traded, tradedFor));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerTwoSecondPlayerOneSizeTwoTradeBothNotEnough_False() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(2);
        //Player player2 = l.get(3);

//        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(1);
//        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(0);

//        EasyMock.expect(player2.getResourceAmount(Resource.LUMBER)).andReturn(0);
//        EasyMock.expect(player2.getResourceAmount(Resource.ORE)).andReturn(1);
//        EasyMock.expect(player2.getResourceAmount(Resource.WOOL)).andReturn(0);
//        EasyMock.expect(player2.getResourceAmount(Resource.WHEAT)).andReturn(0);
//        EasyMock.expect(player2.getResourceAmount(Resource.BRICK)).andReturn(0);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 0);
        traded.put(Resource.WOOL, 2);
        traded.put(Resource.LUMBER, 0);
        traded.put(Resource.BRICK, 0);
        traded.put(Resource.WHEAT, 0);

        Map<Resource, Integer> tradedFor = new HashMap<>();
        tradedFor.put(Resource.ORE, 2);
        tradedFor.put(Resource.WOOL, 0);
        tradedFor.put(Resource.LUMBER, 0);
        tradedFor.put(Resource.BRICK, 0);
        tradedFor.put(Resource.WHEAT, 0);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertFalse(gm.tradeResources(2, 3, traded, tradedFor));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testTradeResources_FirstPlayerOneSecondPlayerZeroSize95TradePossible_True() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Player player = l.get(1);
        Player player2 = l.get(0);

        EasyMock.expect(player.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.addResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);
        EasyMock.expect(player2.removeResources(EasyMock.isA(Resource.class), EasyMock.anyInt())).andReturn(true).times(5);


        EasyMock.expect(player.getResourceAmount(Resource.LUMBER)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.ORE)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.WOOL)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.WHEAT)).andReturn(19);
        EasyMock.expect(player.getResourceAmount(Resource.BRICK)).andReturn(19);

        EasyMock.expect(player2.getResourceAmount(Resource.LUMBER)).andReturn(19);
        EasyMock.expect(player2.getResourceAmount(Resource.ORE)).andReturn(19);
        EasyMock.expect(player2.getResourceAmount(Resource.WOOL)).andReturn(19);
        EasyMock.expect(player2.getResourceAmount(Resource.WHEAT)).andReturn(19);
        EasyMock.expect(player2.getResourceAmount(Resource.BRICK)).andReturn(19);

        Map<Resource, Integer> traded = new HashMap<>();
        traded.put(Resource.ORE, 19);
        traded.put(Resource.WOOL, 19);
        traded.put(Resource.LUMBER, 19);
        traded.put(Resource.BRICK, 19);
        traded.put(Resource.WHEAT, 19);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.tradeResources(1, 0, traded, traded));
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlaceableSettlements_withNegativeOne_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Set temp = gm.getPlaceableSettlements(-1);
        }, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlaceableSettlements_withZeroAnd12Locations_12Locations() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Set<SettlementLocation> possibleLocs = new HashSet<>();
        for (int i = 0; i < 12; i++) {
            possibleLocs.add(EasyMock.createMock(SettlementLocation.class));
        }
        EasyMock.expect(l.get(0).getPossibleSettlementLocations()).andReturn(possibleLocs);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(12, gm.getPlaceableSettlements(0).size());
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlaceableSettlements_withThreeAndNoLocations_NoLocations() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Set<SettlementLocation> possibleLocs = new HashSet<>();
        EasyMock.expect(l.get(3).getPossibleSettlementLocations()).andReturn(possibleLocs);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(0, gm.getPlaceableSettlements(3).size());
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlaceableSettlements_witFour_Except() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Set temp = gm.getPlaceableSettlements(4);
        }, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlaceableSettlements_withOneAndMaxLocations_MaxLocations() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Set<SettlementLocation> possibleLocs = new HashSet<>();
        for (int i = 0; i < 70; i++) {
            possibleLocs.add(EasyMock.createMock(SettlementLocation.class));
        }
        EasyMock.expect(l.get(1).getPossibleSettlementLocations()).andReturn(possibleLocs);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(70, gm.getPlaceableSettlements(1).size());
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetPlaceableSettlements_withTwoAndOneLocation_OneLocations() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Player p = EasyMock.createMock(Player.class);
            l.add(p);
        }
        Set<SettlementLocation> possibleLocs = new HashSet<>();
        possibleLocs.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(l.get(2).getPossibleSettlementLocations()).andReturn(possibleLocs);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(1, gm.getPlaceableSettlements(2).size());
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetVictoryPoints_withZeroPlayers_Empty() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(new ArrayList<>(), gm.getVictoryPoints());
    }

    @Test
    public void testGetVictoryPoints_withOnePlayer_OneElement() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.mock(Player.class);
        l.add(p);
        EasyMock.expect(p.getVictoryPoints()).andReturn(2);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        Assertions.assertEquals(expected, gm.getVictoryPoints());
        EasyMock.verify(p);
    }

    @Test
    public void testGetVictoryPoints_withTwoPlayers_TwoElements() {
        List<Player> l = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            l.add(EasyMock.mock(Player.class));
        }
        EasyMock.expect(l.get(0).getVictoryPoints()).andReturn(3);
        EasyMock.expect(l.get(1).getVictoryPoints()).andReturn(5);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        Assertions.assertEquals(expected, gm.getVictoryPoints());
        EasyMock.verify(l.get(0), l.get(1));
    }

    @Test
    public void testGetVictoryPoints_withMaxPlayers_MaxElements() {
        List<Player> l = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            l.add(EasyMock.mock(Player.class));
            EasyMock.expect(l.get(i).getVictoryPoints()).andReturn(9);
            expected.add(9);
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(expected, gm.getVictoryPoints());
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void testGetSettlementLocations_withZero_EmptyCollection() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(expected, gm.getSettlementLocations());
    }

    @Test
    public void testGetSettlementLocations_withOne_OneList() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(0);
        first.add(1);
        first.add(11);
        first.add(0);//owner
        first.add(1);//multiplier
        expected.add(first);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        SettlementLocation temp = EasyMock.createMock(SettlementLocation.class);
        List<Terrain> terrains = new ArrayList<>();
        settlementLocations.add(temp);
        for (int i = 0; i < 3; i++) {
            terrains.add(EasyMock.createMock(Terrain.class));
        }
        EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
        EasyMock.expect(temp.getTerrains()).andReturn(terrains);
        EasyMock.expect(temp.getOwner()).andReturn(0);
        EasyMock.expect(temp.getMultiplier()).andReturn(1);
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(temp, terrains.get(0), terrains.get(1), terrains.get(2));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(expected, gm.getSettlementLocations());
        EasyMock.verify(temp, terrains.get(0), terrains.get(1), terrains.get(2));
    }

    @Test
    public void testGetSettlementLocations_withTwo_TwoLists() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(0);
        first.add(1);
        first.add(11);
        first.add(0);
        first.add(1);
        List<Integer> second = new ArrayList<>(first);
        expected.add(first);
        expected.add(second);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Terrain> allTerrains = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            SettlementLocation temp = EasyMock.createMock(SettlementLocation.class);
            List<Terrain> terrains = new ArrayList<>();
            settlementLocations.add(temp);
            for (int i = 0; i < 3; i++) {
                terrains.add(EasyMock.createMock(Terrain.class));
                allTerrains.add(terrains.get(i));
            }
            EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
            EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
            EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
            EasyMock.expect(temp.getTerrains()).andReturn(terrains);
            EasyMock.expect(temp.getOwner()).andReturn(0);
            EasyMock.expect(temp.getMultiplier()).andReturn(1);
            EasyMock.replay(temp, terrains.get(0), terrains.get(1), terrains.get(2));
        }

        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(expected, gm.getSettlementLocations());
        for (int i = 0; i < settlementLocations.size(); i++) {
            EasyMock.verify(settlementLocations.get(i));
        }
        for (int i = 0; i < allTerrains.size(); i++) {
            EasyMock.verify(allTerrains.get(i));
        }
    }

    @Test
    public void testGetSettlementLocations_withMax_MaxLists() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        for (int i = 0; i < 70; i++) {
            List<Integer> first = new ArrayList<>();
            first.add(0);
            first.add(1);
            first.add(11);
            first.add(0);
            first.add(1);
            expected.add(first);
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Terrain> allTerrains = new ArrayList<>();
        for (int j = 0; j < 70; j++) {
            SettlementLocation temp = EasyMock.createMock(SettlementLocation.class);
            List<Terrain> terrains = new ArrayList<>();
            settlementLocations.add(temp);
            for (int i = 0; i < 3; i++) {
                terrains.add(EasyMock.createMock(Terrain.class));
                allTerrains.add(terrains.get(i));
            }
            EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
            EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
            EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
            EasyMock.expect(temp.getTerrains()).andReturn(terrains);
            EasyMock.expect(temp.getOwner()).andReturn(0);
            EasyMock.expect(temp.getMultiplier()).andReturn(1);
            EasyMock.replay(temp, terrains.get(0), terrains.get(1), terrains.get(2));
        }

        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(expected, gm.getSettlementLocations());
        for (int i = 0; i < settlementLocations.size(); i++) {
            EasyMock.verify(settlementLocations.get(i));
        }
        for (int i = 0; i < allTerrains.size(); i++) {
            EasyMock.verify(allTerrains.get(i));
        }
    }

    @Test
    public void testGetRoadLocations_WithTerrainlessBoard_ReturnEmpty() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(expected, gm.getRoadLocations());
    }

    @Test
    public void testGetRoadLocations_With4Terrains_ReturnOneRoad() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> roadData = new ArrayList<>();
        roadData.add(0);
        roadData.add(10);
        roadData.add(11);
        roadData.add(0);
        roadData.add(1);//owner
        roadData.add(11);//multiplier
        roadData.add(0);
        expected.add(roadData);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Terrain> terrains = new ArrayList<>();
        SettlementLocation settlementLoc1 = EasyMock.createMock(SettlementLocation.class);
        List<Terrain> terrains2 = new ArrayList<>();
        SettlementLocation settlementLoc2 = EasyMock.createMock(SettlementLocation.class);
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(settlementLoc1);
        settlementLocations.add(settlementLoc2);
        Terrain t0 = EasyMock.createMock(Terrain.class);
        Terrain t1 = EasyMock.createMock(Terrain.class);
        Terrain t2 = EasyMock.createMock(Terrain.class);
        Terrain t3 = EasyMock.createMock(Terrain.class);
        Terrain t4 = EasyMock.createMock(Terrain.class);
        Terrain t5 = EasyMock.createMock(Terrain.class);
        terrains.add(t0);
        terrains.add(t1);
        terrains.add(t2);
        terrains2.add(t3);
        terrains2.add(t4);
        terrains2.add(t5);
        List<Road> roads = new ArrayList<>();
        Road road = EasyMock.createMock(Road.class);
        roads.add(road);
        EasyMock.expect(road.getSettlements()).andReturn(settlementLocations);
        EasyMock.expect(settlementLoc1.getTerrains()).andReturn(terrains);
        EasyMock.expect(t0.getLocID()).andReturn(0);
        EasyMock.expect(t1.getLocID()).andReturn(10);
        EasyMock.expect(t2.getLocID()).andReturn(11);
        EasyMock.expect(settlementLoc2.getTerrains()).andReturn(terrains2);
        EasyMock.expect(t3.getLocID()).andReturn(0);
        EasyMock.expect(t4.getLocID()).andReturn(1);
        EasyMock.expect(t5.getLocID()).andReturn(11);
        EasyMock.expect(road.getOwner()).andReturn(0);

        EasyMock.replay(road, settlementLoc1, settlementLoc2, t0, t1, t2, t3, t4, t5);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<List<Integer>> actual = gm.getRoadLocations();
        Assertions.assertEquals(expected, actual);
        EasyMock.verify(road, settlementLoc1, settlementLoc2, t0, t1, t2, t3, t4, t5);
    }

    @Test
    public void testGetRoadLocations_With4TerrainsOwnedByP1_ReturnOneRoadAndPlayerID1() {
        List<Player> l = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> roadData = new ArrayList<>();
        roadData.add(0);
        roadData.add(10);
        roadData.add(11);
        roadData.add(0);
        roadData.add(1);//owner
        roadData.add(11);//multiplier
        roadData.add(1);
        expected.add(roadData);

        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Terrain> terrains = new ArrayList<>();
        SettlementLocation settlementLoc1 = EasyMock.createMock(SettlementLocation.class);
        List<Terrain> terrains2 = new ArrayList<>();
        SettlementLocation settlementLoc2 = EasyMock.createMock(SettlementLocation.class);
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(settlementLoc1);
        settlementLocations.add(settlementLoc2);
        Terrain t0 = EasyMock.createMock(Terrain.class);
        Terrain t1 = EasyMock.createMock(Terrain.class);
        Terrain t2 = EasyMock.createMock(Terrain.class);
        Terrain t3 = EasyMock.createMock(Terrain.class);
        Terrain t4 = EasyMock.createMock(Terrain.class);
        Terrain t5 = EasyMock.createMock(Terrain.class);
        terrains.add(t0);
        terrains.add(t1);
        terrains.add(t2);
        terrains2.add(t3);
        terrains2.add(t4);
        terrains2.add(t5);
        List<Road> roads = new ArrayList<>();
        Road road = EasyMock.createMock(Road.class);
        roads.add(road);
        EasyMock.expect(road.getSettlements()).andReturn(settlementLocations);
        EasyMock.expect(settlementLoc1.getTerrains()).andReturn(terrains);
        EasyMock.expect(t0.getLocID()).andReturn(0);
        EasyMock.expect(t1.getLocID()).andReturn(10);
        EasyMock.expect(t2.getLocID()).andReturn(11);
        EasyMock.expect(settlementLoc2.getTerrains()).andReturn(terrains2);
        EasyMock.expect(t3.getLocID()).andReturn(0);
        EasyMock.expect(t4.getLocID()).andReturn(1);
        EasyMock.expect(t5.getLocID()).andReturn(11);
        EasyMock.expect(road.getOwner()).andReturn(1);

        EasyMock.replay(road, settlementLoc1, settlementLoc2, t0, t1, t2, t3, t4, t5);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<List<Integer>> actual = gm.getRoadLocations();
        Assertions.assertEquals(expected, actual);
        EasyMock.verify(road, settlementLoc1, settlementLoc2, t0, t1, t2, t3, t4, t5);
    }


    @Test
    public void testGetDevelopmentCardHandSize_NoPlayersInitial_throwException() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.getDevelopmentCardHandSize(1);
        }, "This player does not exist");
    }

    @Test
    public void testGetDevelopmentCardHandSize_Input0_throwException() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.getDevelopmentCardHandSize(0);
        }, "This player does not exist");
    }

    @Test
    public void testGetDevelopmentCardHandSize_4PlayersIntial_return0() {
        List<Player> l = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            l.add(new Player(i));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(0, gm.getDevelopmentCardHandSize(1));
        Assertions.assertEquals(0, gm.getDevelopmentCardHandSize(2));
        Assertions.assertEquals(0, gm.getDevelopmentCardHandSize(3));
        Assertions.assertEquals(0, gm.getDevelopmentCardHandSize(4));
    }

    @Test
    public void testGetDevelopmentCardHandSize_1PlayerWithaKnight_return1() {
        List<Player> l = new ArrayList<>();
        Player player = EasyMock.createMock(Player.class);
        l.add(player);
        List<DevelopmentCard> devCards = new ArrayList<>();
        devCards.add(EasyMock.createMock(Knight.class));
        EasyMock.expect(player.getOwnedDevelopmentCards()).andReturn(devCards);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(player);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(1, gm.getDevelopmentCardHandSize(1));
        EasyMock.verify(player);
    }

    @Test
    public void testGetDevelopmentCardHandSize_1PlayerWith1of2DiffTypesofCards_return2() {
        List<Player> l = new ArrayList<>();
        Player player = EasyMock.createMock(Player.class);
        l.add(player);
        List<DevelopmentCard> devCards = new ArrayList<>();
        devCards.add(EasyMock.createMock(Knight.class));
        devCards.add(EasyMock.createMock(VictoryPoint.class));
        EasyMock.expect(player.getOwnedDevelopmentCards()).andReturn(devCards);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(player);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(2, gm.getDevelopmentCardHandSize(1));
        EasyMock.verify(player);
    }

    @Test
    public void testGetDevelopmentCardHandSize_1PlayerWithMultipleNumOfManyDiffTypesofCards_return4() {
        List<Player> l = new ArrayList<>();
        Player player = EasyMock.createMock(Player.class);
        l.add(player);
        List<DevelopmentCard> devCards = new ArrayList<>();
        devCards.add(EasyMock.createMock(Knight.class));
        devCards.add(EasyMock.createMock(Knight.class));
        devCards.add(EasyMock.createMock(VictoryPoint.class));
        devCards.add(EasyMock.createMock(Monopoly.class));
        EasyMock.expect(player.getOwnedDevelopmentCards()).andReturn(devCards);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(player);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(4, gm.getDevelopmentCardHandSize(1));
        EasyMock.verify(player);
    }

    @Test
    public void testGetDevelopmentCardHandSize_InputMAXnumOfPlayersPlus1_throwException() {
        List<Player> l = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            l.add(new Player(i));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.getDevelopmentCardHandSize(5);
        }, "This player does not exist");
    }

    @Test
    public void testGetRoadLengths_NoPlayers_Empty() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(new ArrayList<Integer>(), gm.getRoadLengths());
    }

    @Test
    public void testGetRoadLengths_OnePlayer_OneLength() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getRoadLength()).andReturn(2);
        l.add(p);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        Assertions.assertEquals(expected, gm.getRoadLengths());
        EasyMock.verify(p);
    }

    @Test
    public void testGetRoadLengths_TwoPlayers_TwoLengths() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getRoadLength()).andReturn(2);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        EasyMock.expect(p2.getRoadLength()).andReturn(1);
        l.add(p2);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(1);
        Assertions.assertEquals(expected, gm.getRoadLengths());
        EasyMock.verify(p, p2);
    }

    @Test
    public void testGetRoadLengths_MaxPlayers_MaxLengths() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getRoadLength()).andReturn(2);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        EasyMock.expect(p2.getRoadLength()).andReturn(1);
        l.add(p2);
        Player p3 = EasyMock.createMock(Player.class);
        EasyMock.expect(p3.getRoadLength()).andReturn(4);
        l.add(p3);
        Player p4 = EasyMock.createMock(Player.class);
        EasyMock.expect(p4.getRoadLength()).andReturn(5);
        l.add(p4);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2, p3, p4);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(1);
        expected.add(4);
        expected.add(5);
        Assertions.assertEquals(expected, gm.getRoadLengths());
        EasyMock.verify(p, p2, p3, p4);
    }

    @Test
    public void testGetArmySizes_NoPlayers_Empty() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(new ArrayList<Integer>(), gm.getArmySizes());
    }

    @Test
    public void testGetArmySizes_OnePlayer_OneSize() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getArmySize()).andReturn(1);
        l.add(p);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        Assertions.assertEquals(expected, gm.getArmySizes());
        EasyMock.verify(p);
    }

    @Test
    public void testGetArmySizes_TwoPlayers_TwoSizes() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getArmySize()).andReturn(1);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        EasyMock.expect(p2.getArmySize()).andReturn(0);
        l.add(p2);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);
        Assertions.assertEquals(expected, gm.getArmySizes());
        EasyMock.verify(p, p2);
    }

    @Test
    public void testGetArmySizes_MaxPlayers_MaxSizes() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getArmySize()).andReturn(1);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        EasyMock.expect(p2.getArmySize()).andReturn(0);
        l.add(p2);
        Player p3 = EasyMock.createMock(Player.class);
        EasyMock.expect(p3.getArmySize()).andReturn(3);
        l.add(p3);
        Player p4 = EasyMock.createMock(Player.class);
        EasyMock.expect(p4.getArmySize()).andReturn(0);
        l.add(p4);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2, p3, p4);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);
        expected.add(3);
        expected.add(0);
        Assertions.assertEquals(expected, gm.getArmySizes());
        EasyMock.verify(p, p2, p3, p4);
    }

    @Test
    public void testGetHandSizes_NoPlayers_Empty() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(new ArrayList<Integer>(), gm.getHandSizes());
    }

    @Test
    public void testGetHandSizes_OnePlayer_OneSize() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getHandSize()).andReturn(1);
        l.add(p);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        Assertions.assertEquals(expected, gm.getHandSizes());
        EasyMock.verify(p);
    }

    @Test
    public void testGetHandSizes_TwoPlayers_TwoSizes() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getHandSize()).andReturn(1);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        EasyMock.expect(p2.getHandSize()).andReturn(0);
        l.add(p2);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);
        Assertions.assertEquals(expected, gm.getHandSizes());
        EasyMock.verify(p, p2);
    }

    @Test
    public void testGetHandSizes_MaxPlayers_MaxSizes() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        EasyMock.expect(p.getHandSize()).andReturn(1);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        EasyMock.expect(p2.getHandSize()).andReturn(0);
        l.add(p2);
        Player p3 = EasyMock.createMock(Player.class);
        EasyMock.expect(p3.getHandSize()).andReturn(5);
        l.add(p3);
        Player p4 = EasyMock.createMock(Player.class);
        EasyMock.expect(p4.getHandSize()).andReturn(1);
        l.add(p4);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2, p3, p4);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(0);
        expected.add(5);
        expected.add(1);
        Assertions.assertEquals(expected, gm.getHandSizes());
        EasyMock.verify(p, p2, p3, p4);
    }

    @Test
    public void testGetHands_NoPlayers_Empty() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertEquals(new ArrayList<List<String>>(), gm.getHands());
    }

    @Test
    public void testGetHands_OnePlayer_OneHand() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        List<String> cards = new ArrayList<>();
        cards.add("Knight");
        EasyMock.expect(p.getHand()).andReturn(cards);
        l.add(p);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<List<String>> expected = new ArrayList<>();
        expected.add(cards);
        Assertions.assertEquals(expected, gm.getHands());
        EasyMock.verify(p);
    }

    @Test
    public void testGetHands_TwoPlayers_TwoHands() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        List<String> cards = new ArrayList<>();
        cards.add("Knight");
        cards.add("Victory Point");
        EasyMock.expect(p.getHand()).andReturn(cards);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        List<String> cards2 = new ArrayList<>();
        cards2.add("Knight");
        EasyMock.expect(p2.getHand()).andReturn(cards2);
        l.add(p2);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<List<String>> expected = new ArrayList<>();
        expected.add(cards);
        expected.add(cards2);
        Assertions.assertEquals(expected, gm.getHands());
        EasyMock.verify(p, p2);
    }

    @Test
    public void testGetHands_MaxPlayers_MaxHands() {
        List<Player> l = new ArrayList<>();
        Player p = EasyMock.createMock(Player.class);
        List<String> cards = new ArrayList<>();
        cards.add("Knight");
        cards.add("Victory Point");
        EasyMock.expect(p.getHand()).andReturn(cards);
        l.add(p);
        Player p2 = EasyMock.createMock(Player.class);
        List<String> cards2 = new ArrayList<>();
        cards2.add("Knight");
        EasyMock.expect(p2.getHand()).andReturn(cards2);
        l.add(p2);
        Player p3 = EasyMock.createMock(Player.class);
        List<String> cards3 = new ArrayList<>();
        cards3.add("Knight");
        cards3.add("Victory Point");
        cards3.add("Monopoly");
        cards3.add("Road Building");
        cards3.add("Year of Plenty");
        EasyMock.expect(p3.getHand()).andReturn(cards3);
        l.add(p3);
        Player p4 = EasyMock.createMock(Player.class);
        List<String> cards4 = new ArrayList<>();
        EasyMock.expect(p4.getHand()).andReturn(cards4);
        l.add(p4);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(p, p2, p3, p4);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        List<List<String>> expected = new ArrayList<>();
        expected.add(cards);
        expected.add(cards2);
        expected.add(cards3);
        expected.add(cards4);
        Assertions.assertEquals(expected, gm.getHands());
        EasyMock.verify(p, p2, p3, p4);
    }

    @Test
    public void testMaritimeTradeResources_PlayerNegOne_Except() {
        List<Player> l = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.maritimeTradeResources(-1, 2, Resource.ORE, Resource.BRICK);
        }, "InvalidParameterException should be thrown");
    }

    @Test
    public void testMaritimeTradeResources_PlayerZero3ResourcesBrickLumber_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(0).addResources(Resource.LUMBER, 1)).andReturn(true);
        EasyMock.expect(l.get(0).removeResources(Resource.BRICK, 3)).andReturn(true);
        EasyMock.replay(l.get(0));
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.BRICK, 0);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.maritimeTradeResources(0, 3, Resource.BRICK, Resource.LUMBER));
        EasyMock.verify(l.get(0));
    }

    @Test
    public void testMaritimeTradeResources_PlayerThree2ResourcesWheatOre_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(3).addResources(Resource.ORE, 1)).andReturn(true);
        EasyMock.expect(l.get(3).removeResources(Resource.WHEAT, 2)).andReturn(true);
        EasyMock.replay(l.get(3));
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.ORE, 19);
        bank.put(Resource.WHEAT, 0);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.maritimeTradeResources(3, 2, Resource.WHEAT, Resource.ORE));
        EasyMock.verify(l.get(3));
    }


    @Test
    public void testMaritimeTradeResources_Player4_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.maritimeTradeResources(4, 2, Resource.ORE, Resource.BRICK);
        }, "InvalidParameterException should be thrown");
    }

    @Test
    public void testMaritimeTradeResources_PlayerOne1ResourceOreWool_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.maritimeTradeResources(1, 1, Resource.ORE, Resource.WOOL);
        }, "InvalidParameterException should be thrown");
    }

    @Test
    public void testMaritimeTradeResources_PlayerTwo2ResourceWoolBrick_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(2).addResources(Resource.BRICK, 1)).andReturn(true);
        EasyMock.expect(l.get(2).removeResources(Resource.WOOL, 2)).andReturn(true);
        EasyMock.replay(l.get(2));
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.WOOL, 0);
        bank.put(Resource.BRICK, 19);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.maritimeTradeResources(2, 2, Resource.WOOL, Resource.BRICK));
        EasyMock.verify(l.get(2));
    }

    @Test
    public void testMaritimeTradeResources_PlayerThree4ResourceLumberWheat_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(3).addResources(Resource.WHEAT, 1)).andReturn(true);
        EasyMock.expect(l.get(3).removeResources(Resource.LUMBER, 4)).andReturn(true);
        EasyMock.replay(l.get(3));
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 0);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.maritimeTradeResources(3, 4, Resource.LUMBER, Resource.WHEAT));
        EasyMock.verify(l.get(3));
    }

    @Test
    public void testMaritimeTradeResources_PlayerZero5ResourceBrickLumber_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            gm.maritimeTradeResources(0, 5, Resource.BRICK, Resource.LUMBER);
        }, "InvalidParameterException should be thrown");
    }

    @Test
    public void testMaritimeTradeResources_PlayerOne2ResourceNullLumber_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(NullPointerException.class, () -> {
            gm.maritimeTradeResources(1, 2, null, Resource.LUMBER);
        }, "NullPointerException should be thrown");
    }

    @Test
    public void testMaritimeTradeResources_PlayerTwo3ResourceOreNull_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertThrows(NullPointerException.class, () -> {
            gm.maritimeTradeResources(2, 3, Resource.ORE, null);
        }, "NullPointerException should be thrown");
    }

    @Test
    public void testMaritimeTradeResources_PlayerTwo2ResourceOreLumber_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(2).addResources(Resource.LUMBER, 1)).andReturn(true);
        EasyMock.expect(l.get(2).removeResources(Resource.ORE, 2)).andReturn(true);
        EasyMock.replay(l.get(2));
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.ORE, 0);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertTrue(gm.maritimeTradeResources(2, 2, Resource.ORE, Resource.LUMBER));
        EasyMock.verify(l.get(2));
    }

    @Test
    public void testMaritimeTradeResources_PlayerTwo2ResourceOreLumberPlayerNotEnough_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(2).removeResources(Resource.ORE, 2)).andReturn(false);
        EasyMock.replay(l.get(2));
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.ORE, 0);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertFalse(gm.maritimeTradeResources(2, 2, Resource.ORE, Resource.LUMBER));
        EasyMock.verify(l.get(2));
    }

    @Test
    public void testMaritimeTradeResources_PlayerTwo2ResourceOreLumberBankNotEnough_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 0);
        bank.put(Resource.ORE, 0);
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 0);
        Assertions.assertFalse(gm.maritimeTradeResources(2, 2, Resource.ORE, Resource.LUMBER));
    }
    public void TestBaseGameModel_moveRobberInputLocOffBoard_ThrowException(){
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(board.containsKey(-2)).andReturn(false);

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.moveRobber(-2);},
                "This Terrain's location does not exist");
        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_moveRobberInputValidLoc0_ReturnEmptyList(){
        List<Player> expected = new ArrayList<>();
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);
        Terrain oldRobberTerrain = EasyMock.createMock(Terrain.class);
        Terrain newRobberTerrain = EasyMock.createMock(Terrain.class);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);

        EasyMock.expect(board.containsKey(0)).andReturn(true);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.hasRobber()).andReturn(false);
        EasyMock.expect(board.get(23)).andReturn(oldRobberTerrain);
        oldRobberTerrain.setRobberState(false);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        newRobberTerrain.setRobberState(true);
        EasyMock.expect(settlementLocations.size()).andReturn(0);

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations);
        EasyMock.replay(newRobberTerrain);

        List<Player> actual = gm.moveRobber(0);
        Assertions.assertEquals(expected, actual);

        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_moveRobberInputValidLoc0WithOnePlayerSettlement_ListWithPlayer1(){
        List<Player> expected = new ArrayList<>();
        Player player1 = new Player(1);
        expected.add(player1);
        List<Terrain> terrainsAroundPlayer1SettlementLoc = EasyMock.createMock(ArrayList.class);
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);
        Terrain oldRobberTerrain = EasyMock.createMock(Terrain.class);
        Terrain newRobberTerrain = EasyMock.createMock(Terrain.class);
        SettlementLocation player1SettlementLoc = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(board.containsKey(0)).andReturn(true);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.hasRobber()).andReturn(false);
        EasyMock.expect(board.get(23)).andReturn(oldRobberTerrain);
        oldRobberTerrain.setRobberState(false);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        newRobberTerrain.setRobberState(true);

        EasyMock.expect(settlementLocations.size()).andReturn(1);
        EasyMock.expect(settlementLocations.get(0)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(0)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(settlementLocations.size()).andReturn(1);
        EasyMock.expect(players.get(0)).andReturn(player1);

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations);
        EasyMock.replay(terrainsAroundPlayer1SettlementLoc, player1SettlementLoc, oldRobberTerrain, newRobberTerrain);

        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        List<Player> actual = gm.moveRobber(0);
        Assertions.assertEquals(expected, actual);

        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_moveRobberInputValidLoc0WithTwoPlayerOneSettlements_ListWithPlayer1(){
        List<Player> expected = new ArrayList<>();
        Player player1 = new Player(1);
        expected.add(player1);
        List<Terrain> terrainsAroundPlayer1SettlementLoc = EasyMock.createMock(ArrayList.class);
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);
        Terrain oldRobberTerrain = EasyMock.createMock(Terrain.class);
        Terrain newRobberTerrain = EasyMock.createMock(Terrain.class);
        SettlementLocation player1SettlementLoc = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(board.containsKey(0)).andReturn(true);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.hasRobber()).andReturn(false);
        EasyMock.expect(board.get(23)).andReturn(oldRobberTerrain);
        oldRobberTerrain.setRobberState(false);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        newRobberTerrain.setRobberState(true);

        EasyMock.expect(settlementLocations.size()).andReturn(2);
        EasyMock.expect(settlementLocations.get(0)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(0)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);

        EasyMock.expect(settlementLocations.size()).andReturn(2);
        EasyMock.expect(settlementLocations.get(1)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(1)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(settlementLocations.size()).andReturn(2);

        EasyMock.expect(players.get(0)).andReturn(player1);

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations);
        EasyMock.replay(terrainsAroundPlayer1SettlementLoc, player1SettlementLoc, oldRobberTerrain, newRobberTerrain);

        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        List<Player> actual = gm.moveRobber(0);
        Assertions.assertEquals(expected, actual);

        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_moveRobberInputValidLoc0WithFourSettlementsFromAllPlayers_ListWithPlayer1(){
        List<Player> expected = new ArrayList<>();
        for(int i = 1; i < 5; i++){
            Player player1 = new Player(i);
            expected.add(player1);
        }
        List<Terrain> terrainsAroundPlayer1SettlementLoc = EasyMock.createMock(ArrayList.class);
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);
        Terrain oldRobberTerrain = EasyMock.createMock(Terrain.class);
        Terrain newRobberTerrain = EasyMock.createMock(Terrain.class);
        SettlementLocation player1SettlementLoc = EasyMock.createMock(SettlementLocation.class);

        EasyMock.expect(board.containsKey(0)).andReturn(true);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.hasRobber()).andReturn(false);
        EasyMock.expect(board.get(23)).andReturn(oldRobberTerrain);
        oldRobberTerrain.setRobberState(false);
        EasyMock.expect(board.get(0)).andReturn(newRobberTerrain);
        newRobberTerrain.setRobberState(true);

        EasyMock.expect(settlementLocations.size()).andReturn(4);
        EasyMock.expect(settlementLocations.get(0)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(0)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);

        EasyMock.expect(settlementLocations.size()).andReturn(4);
        EasyMock.expect(settlementLocations.get(1)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(1)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(2);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);

        EasyMock.expect(settlementLocations.size()).andReturn(4);
        EasyMock.expect(settlementLocations.get(2)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(2)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(3);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);

        EasyMock.expect(settlementLocations.size()).andReturn(4);
        EasyMock.expect(settlementLocations.get(3)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getTerrains()).andReturn(terrainsAroundPlayer1SettlementLoc);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.get(0)).andReturn(newRobberTerrain);
        EasyMock.expect(newRobberTerrain.getLocID()).andReturn(0);
        EasyMock.expect(settlementLocations.get(3)).andReturn(player1SettlementLoc);
        EasyMock.expect(player1SettlementLoc.getOwner()).andReturn(4);
        EasyMock.expect(terrainsAroundPlayer1SettlementLoc.size()).andReturn(1);
        EasyMock.expect(settlementLocations.size()).andReturn(4);

        EasyMock.expect(players.get(0)).andReturn(expected.get(0));
        EasyMock.expect(players.get(1)).andReturn(expected.get(1));
        EasyMock.expect(players.get(2)).andReturn(expected.get(2));
        EasyMock.expect(players.get(3)).andReturn(expected.get(3));

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations);
        EasyMock.replay(terrainsAroundPlayer1SettlementLoc, player1SettlementLoc, oldRobberTerrain, newRobberTerrain);

        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        List<Player> actual = gm.moveRobber(0);
        Assertions.assertEquals(expected, actual);

        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_moveRobberInputOceanLoc10_ThrowException(){
        Terrain ocean = EasyMock.createMock(Terrain.class);
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(board.containsKey(10)).andReturn(true);
        EasyMock.expect(board.get(10)).andReturn(ocean);
        EasyMock.expect(ocean.getType()).andReturn(TerrainTypes.OCEAN);

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations, ocean);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.moveRobber(10);},
                "Robber can not be placed on an ocean");
        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations, ocean);
    }

    @Test
    public void TestBaseGameModel_moveRobberAtSameLoc23_ThrowException(){
        Terrain forest = EasyMock.createMock(Terrain.class);
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(HashMap.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(board.containsKey(23)).andReturn(true);
        EasyMock.expect(board.get(23)).andReturn(forest);
        EasyMock.expect(forest.getType()).andReturn(TerrainTypes.FOREST);
        EasyMock.expect(board.get(23)).andReturn(forest);
        EasyMock.expect(forest.hasRobber()).andReturn(true);

        EasyMock.replay(players, bank, developmentCards,board,settlementLocations,roadLocations, forest);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.moveRobber(23);},
                "Robber can not be placed in the same place");
        EasyMock.verify(players, bank, developmentCards,board,settlementLocations,roadLocations, forest);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber0_ThrowException(){
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.replay(developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.disperseResourcesBasedOnRollNumber(0);},
                "Valid rolls are 1-12");
        EasyMock.verify(developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber13_ThrowException(){
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.replay(developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.disperseResourcesBasedOnRollNumber(13);},
                "Valid rolls are 1-12");
        EasyMock.verify(developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber7_ThrowException(){
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.replay(developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.disperseResourcesBasedOnRollNumber(7);},
                "Roll 7 does not disperse resources");
        EasyMock.verify(developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndNoSettlementsDetected_NoResourcesGiven(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 19);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> emptyBank = new HashMap<>();
        emptyBank.put(Resource.LUMBER, 0);
        emptyBank.put(Resource.ORE, 0);
        emptyBank.put(Resource.BRICK, 0);
        emptyBank.put(Resource.WOOL, 0);
        emptyBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(emptyBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        //System.out.println(gm.getResourceCardDeckSize().get(Resource.LUMBER));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1gets1Wood_OneWoodGiven(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 18);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBank = new HashMap<>();
        oneWoodBank.put(Resource.LUMBER, 1);
        oneWoodBank.put(Resource.ORE, 0);
        oneWoodBank.put(Resource.BRICK, 0);
        oneWoodBank.put(Resource.WOOL, 0);
        oneWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1gets2Wood_TwoWoodGiven(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 17);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBank = new HashMap<>();
        oneWoodBank.put(Resource.LUMBER, 2);
        oneWoodBank.put(Resource.ORE, 0);
        oneWoodBank.put(Resource.BRICK, 0);
        oneWoodBank.put(Resource.WOOL, 0);
        oneWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1And2gets1WoodEach_TwoWoodGiven(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 17);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBank = new HashMap<>();
        oneWoodBank.put(Resource.LUMBER, 1);
        oneWoodBank.put(Resource.ORE, 0);
        oneWoodBank.put(Resource.BRICK, 0);
        oneWoodBank.put(Resource.WOOL, 0);
        oneWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1gets1Wood1Brick_1wood1brickGiven(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 18);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 18);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBank = new HashMap<>();
        oneWoodBank.put(Resource.LUMBER, 1);
        oneWoodBank.put(Resource.ORE, 0);
        oneWoodBank.put(Resource.BRICK, 1);
        oneWoodBank.put(Resource.WOOL, 0);
        oneWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1SupposedToGet2Wood_BankOnlyhas1Wood(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 0);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> bankInitial = new HashMap<>();
        bankInitial.put(Resource.LUMBER, 1);
        bankInitial.put(Resource.ORE, 19);
        bankInitial.put(Resource.BRICK, 19);
        bankInitial.put(Resource.WOOL, 19);
        bankInitial.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> twoWoodBank = new HashMap<>();
        twoWoodBank.put(Resource.LUMBER, 2);
        twoWoodBank.put(Resource.ORE, 0);
        twoWoodBank.put(Resource.BRICK, 0);
        twoWoodBank.put(Resource.WOOL, 0);
        twoWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(twoWoodBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players, bankInitial, new ArrayList<>(), new Dice[2],
                new HashMap<>(), new ArrayList<>(), new ArrayList<>(), 3);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1And2gets1WoodEachWhenBankOnlyhas1Wood_NoWoodGiven(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 1);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> bankInitial = new HashMap<>();
        bankInitial.put(Resource.LUMBER, 1);
        bankInitial.put(Resource.ORE, 19);
        bankInitial.put(Resource.BRICK, 19);
        bankInitial.put(Resource.WOOL, 19);
        bankInitial.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBank = new HashMap<>();
        oneWoodBank.put(Resource.LUMBER, 1);
        oneWoodBank.put(Resource.ORE, 0);
        oneWoodBank.put(Resource.BRICK, 0);
        oneWoodBank.put(Resource.WOOL, 0);
        oneWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);


        EasyMock.replay(p1);
        GameModel gm = new GameModel(players, bankInitial, new ArrayList<>(), new Dice[2],
                new HashMap<>(), new ArrayList<>(), new ArrayList<>(), 3);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1And2gets1Wood1BrickEachWhenBankOnlyhas1Wood2Brick_0Wood2BricksGivenFromBank(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 1);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 0);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> bankInitial = new HashMap<>();
        bankInitial.put(Resource.LUMBER, 1);
        bankInitial.put(Resource.ORE, 19);
        bankInitial.put(Resource.BRICK, 2);
        bankInitial.put(Resource.WOOL, 19);
        bankInitial.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBank = new HashMap<>();
        oneWoodBank.put(Resource.LUMBER, 1);
        oneWoodBank.put(Resource.ORE, 0);
        oneWoodBank.put(Resource.BRICK, 1);
        oneWoodBank.put(Resource.WOOL, 0);
        oneWoodBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players, bankInitial, new ArrayList<>(), new Dice[2],
                new HashMap<>(), new ArrayList<>(), new ArrayList<>(), 3);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1To4gets1Wood1BrickEachWhenBankOnlyhas3Wood4Brick_0Wood4BricksGivenFromBank(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 3);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 0);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> bankInitial = new HashMap<>();
        bankInitial.put(Resource.LUMBER, 3);
        bankInitial.put(Resource.ORE, 19);
        bankInitial.put(Resource.BRICK, 4);
        bankInitial.put(Resource.WOOL, 19);
        bankInitial.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBrickBank = new HashMap<>();
        oneWoodBrickBank.put(Resource.LUMBER, 1);
        oneWoodBrickBank.put(Resource.ORE, 0);
        oneWoodBrickBank.put(Resource.BRICK, 1);
        oneWoodBrickBank.put(Resource.WOOL, 0);
        oneWoodBrickBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);
        players.add(p1);
        players.add(p1);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players, bankInitial, new ArrayList<>(), new Dice[2],
                new HashMap<>(), new ArrayList<>(), new ArrayList<>(), 3);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1To4gets1WoodEachFromFullBank_4WoodGivenFromBank(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 15);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 19);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> bankInitial = new HashMap<>();
        bankInitial.put(Resource.LUMBER, 19);
        bankInitial.put(Resource.ORE, 19);
        bankInitial.put(Resource.BRICK, 19);
        bankInitial.put(Resource.WOOL, 19);
        bankInitial.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> oneWoodBrickBank = new HashMap<>();
        oneWoodBrickBank.put(Resource.LUMBER, 1);
        oneWoodBrickBank.put(Resource.ORE, 0);
        oneWoodBrickBank.put(Resource.BRICK, 0);
        oneWoodBrickBank.put(Resource.WOOL, 0);
        oneWoodBrickBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);
        players.add(p1);
        players.add(p1);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);
        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(oneWoodBrickBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players, bankInitial, new ArrayList<>(), new Dice[2],
                new HashMap<>(), new ArrayList<>(), new ArrayList<>(), 3);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_disperseResourcesBasedOnRollNumber5_AndP1gets2Wood2BrickEachWhenBankOnlyhas1Wood2Brick_1Wood2BricksGivenFromBank(){
        HashMap<Resource, Integer> bankExpected = new HashMap<>();
        bankExpected.put(Resource.LUMBER, 0);
        bankExpected.put(Resource.ORE, 19);
        bankExpected.put(Resource.BRICK, 0);
        bankExpected.put(Resource.WOOL, 19);
        bankExpected.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> bankInitial = new HashMap<>();
        bankInitial.put(Resource.LUMBER, 1);
        bankInitial.put(Resource.ORE, 19);
        bankInitial.put(Resource.BRICK, 2);
        bankInitial.put(Resource.WOOL, 19);
        bankInitial.put(Resource.WHEAT, 19);
        HashMap<Resource, Integer> playerShouldGetBank = new HashMap<>();
        playerShouldGetBank.put(Resource.LUMBER, 2);
        playerShouldGetBank.put(Resource.ORE, 0);
        playerShouldGetBank.put(Resource.BRICK, 2);
        playerShouldGetBank.put(Resource.WOOL, 0);
        playerShouldGetBank.put(Resource.WHEAT, 0);
        List<Player> players = new ArrayList<>();
        Player p1 = EasyMock.createNiceMock(Player.class);
        players.add(p1);

        EasyMock.expect(p1.getResourceAmountGainedFromRollNumber(5)).andReturn(playerShouldGetBank);

        EasyMock.replay(p1);
        GameModel gm = new GameModel(players, bankInitial, new ArrayList<>(), new Dice[2],
                new HashMap<>(), new ArrayList<>(), new ArrayList<>(), 3);
        Assertions.assertTrue(gm.disperseResourcesBasedOnRollNumber(5));
        Assertions.assertEquals(bankExpected, gm.getResourceCardDeckSize());
        EasyMock.verify(p1);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_InvalidPlayerNum0_ThrowException(){
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(Map.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andReturn(1);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerTakeFromBank(0, Resource.LUMBER, 1);},
                "this player's ID does not exist");
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_InvalidTooHighOfPlayerNum_ThrowException(){
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = EasyMock.createMock(Map.class);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andReturn(1);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerTakeFromBank(2, Resource.LUMBER, 1);},
                "this player's ID does not exist");
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_TooSmallAnAmount_ThrowException(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerTakeFromBank(1, Resource.LUMBER, 0);},
                "Quantitiy must be greater than 0");
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_NotEnoughInBank_ThrowException(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(bank.get(Resource.LUMBER)).andReturn(19);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerTakeFromBank(20, Resource.LUMBER, 0);},
                "Quantitiy can not exceed amount left in the bank");
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_P1OneWoodValid_ReturnTrue(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.ORE, 19);
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.WOOL, 19);
        bank.put(Resource.BRICK, 19);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.addResources(Resource.LUMBER, 1)).andStubReturn(true);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerTakeFromBank(1, Resource.LUMBER, 1));
        Assertions.assertEquals(18, gm.getResourceCardDeckSize().get(Resource.LUMBER));
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_P1Take19WoodValid_ReturnTrue(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.ORE, 19);
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.WOOL, 19);
        bank.put(Resource.BRICK, 19);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.addResources(Resource.LUMBER, 1)).andStubReturn(true);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerTakeFromBank(1, Resource.LUMBER, 19));
        Assertions.assertEquals(0, gm.getResourceCardDeckSize().get(Resource.LUMBER));
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_P1Take1WoolValid_ReturnTrue(){
        Resource type = Resource.WOOL;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.ORE, 19);
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.WOOL, 19);
        bank.put(Resource.BRICK, 19);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.addResources(type, 1)).andStubReturn(true);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerTakeFromBank(1, type, 1));
        Assertions.assertEquals(18, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_P1Take1BrickValid_ReturnTrue(){
        Resource type = Resource.BRICK;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        Dice[] dice = new Dice[2];
        bank.put(Resource.ORE, 19);
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.WOOL, 19);
        bank.put(Resource.BRICK, 19);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.addResources(type, 1)).andStubReturn(true);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerTakeFromBank(1, type, 1));
        Assertions.assertEquals(18, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_P1Take1WheatValid_ReturnTrue(){
        Resource type = Resource.WHEAT;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.ORE, 19);
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.WOOL, 19);
        bank.put(Resource.BRICK, 19);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.addResources(type, 1)).andStubReturn(true);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerTakeFromBank(1, type, 1));
        Assertions.assertEquals(18, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_P1Take1OREValid_ReturnTrue(){
        Resource type = Resource.ORE;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.ORE, 19);
        bank.put(Resource.LUMBER, 19);
        bank.put(Resource.WOOL, 19);
        bank.put(Resource.BRICK, 19);
        bank.put(Resource.WHEAT, 19);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.addResources(type, 1)).andStubReturn(true);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerTakeFromBank(1, type, 1));
        Assertions.assertEquals(18, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_InvalidPlayerNum0_ThrowException(){
        List<Player> players = EasyMock.createMock(ArrayList.class);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andReturn(1);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerGiveToBank(0, Resource.LUMBER, 1);},
                "this player's ID does not exist");
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_TooSmallAnAmount_ThrowException(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);

        EasyMock.replay(players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerTakeFromBank(1, Resource.LUMBER, 0);},
                "Quantitiy must be greater than 0");
        EasyMock.verify(players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerTakeFromBank_NotEnoughInPlayer_ThrowException(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 0);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(Resource.LUMBER)).andReturn(0);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    gm.playerGiveToBank(1, Resource.LUMBER, 1);},
                "This player has insufficient resources");
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_P1OneWoodValid_ReturnTrue(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 18);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(Resource.LUMBER)).andStubReturn(1);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.removeResources(Resource.LUMBER, 1)).andReturn(true);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerGiveToBank(1, Resource.LUMBER, 1));
        Assertions.assertEquals(19, gm.getResourceCardDeckSize().get(Resource.LUMBER));
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_P1NineteenWoodValid_ReturnTrue(){
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(Resource.LUMBER, 0);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(Resource.LUMBER)).andStubReturn(19);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.removeResources(Resource.LUMBER, 19)).andReturn(true);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerGiveToBank(1, Resource.LUMBER, 19));
        Assertions.assertEquals(19, gm.getResourceCardDeckSize().get(Resource.LUMBER));
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_P1OneWoolValid_ReturnTrue(){
        Resource type = Resource.WOOL;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(type, 18);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(type)).andStubReturn(1);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.removeResources(type, 1)).andReturn(true);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerGiveToBank(1, type, 1));
        Assertions.assertEquals(19, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_P1OneBrickValid_ReturnTrue(){
        Resource type = Resource.BRICK;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(type, 18);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(type)).andStubReturn(1);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.removeResources(type, 1)).andReturn(true);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerGiveToBank(1, type, 1));
        Assertions.assertEquals(19, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_P1OneWheatValid_ReturnTrue(){
        Resource type = Resource.WHEAT;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(type, 18);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(type)).andStubReturn(1);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.removeResources(type, 1)).andReturn(true);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerGiveToBank(1, type, 1));
        Assertions.assertEquals(19, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_playerGiveToBank_P1OneOreValid_ReturnTrue(){
        Resource type = Resource.ORE;
        List<Player> players = EasyMock.createMock(MockType.NICE, ArrayList.class);
        Player mockPlayer = EasyMock.createMock(MockType.NICE, Player.class);
        Map<Resource, Integer> bank = new HashMap<>();
        bank.put(type, 18);
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);

        EasyMock.expect(players.size()).andStubReturn(1);
        EasyMock.expect(players.get(0)).andStubReturn(mockPlayer);
        EasyMock.expect(mockPlayer.getResourceAmount(type)).andStubReturn(1);
        EasyMock.expect(players.get(0)).andReturn(mockPlayer);
        EasyMock.expect(mockPlayer.removeResources(type, 1)).andReturn(true);

        EasyMock.replay(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertTrue(gm.playerGiveToBank(1, type, 1));
        Assertions.assertEquals(19, gm.getResourceCardDeckSize().get(type));
        EasyMock.verify(mockPlayer, players, developmentCards,board,settlementLocations,roadLocations);
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerNegOne_Except(){
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addHarbors(-1, 0, 1, 11);},"Should throw IndexOutOfBounds Exception");
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerZeroTer0Ter1Ter11_True(){
        List<Player> players = new ArrayList<>();
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        players.add(EasyMock.createMock(Player.class));
        players.get(0).addHarbor('?');
        EasyMock.expectLastCall();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(0), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addHarbors(0, 0, 1, 11));
        EasyMock.verify(players.get(0), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerThreeTer10Ter20Ter21_True(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(20);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(21);
        harbors.put(settlementLocations.get(0),'L');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        players.get(3).addHarbor('L');
        EasyMock.expectLastCall();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(3), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addHarbors(3, 10, 20, 21));
        EasyMock.verify(players.get(3), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerFour_Except(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        GameModel gm = new GameModel(players,bank,developmentCards,dice,23);
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {gm.addHarbors(4, 11, 20, 21);},"IndexOutOfBounds Exception should be thrown");
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerOneTerNegOneTer1Ter11InvalidFirst_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addHarbors(1, -1, 1, 11));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerTwoTer0Ter19Ter11InvalidSecond_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addHarbors(2, 0, 19, 11));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerThreeTer0Ter1Ter27InvalidThird_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addHarbors(3, 0, 1, 27));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addHarbors_PlayerZeroTer0Ter1Ter12NoSettlementLocationHere_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addHarbors(0, 0, 1, 12));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }


    @Test
    public void TestBaseGameModel_addHarbors_PlayerZeroTer2Ter3Ter13NoHarborHere_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        List<Terrain> slTerrains2 = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(3);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(13);
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);
        harbors.put(settlementLocations.get(1),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addHarbors(0, 2, 3, 13));
        EasyMock.verify(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1));
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerNegOne_Except(){
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = EasyMock.createMock(HashMap.class);
        List<SettlementLocation> settlementLocations = EasyMock.createMock(ArrayList.class);
        List<Road> roadLocations = EasyMock.createMock(ArrayList.class);
        GameModel gm = new GameModel(players,bank,developmentCards,dice,board,settlementLocations,roadLocations, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addSettlement(-1, 0, 1, 11);},"Should throw IndexOutOfBounds Exception");
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerZeroTer0Ter1Ter11_True(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);
        harbors.put(settlementLocations.get(0),'?');
        EasyMock.expect(players.get(0).addSettlement(settlementLocations.get(0))).andReturn(true);
        players.get(0).addHarbor('?');
        EasyMock.expectLastCall();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(0), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addSettlement(0, 0, 1, 11));
        EasyMock.verify(players.get(0), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerThreeTer10Ter20Ter21_True(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(10).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(20).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(21).times(2);
        harbors.put(settlementLocations.get(0),'L');
        EasyMock.expect(players.get(3).addSettlement(settlementLocations.get(0))).andReturn(true);
        players.get(3).addHarbor('L');
        EasyMock.expectLastCall();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(3), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addSettlement(3, 10, 20, 21));
        EasyMock.verify(players.get(3), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerFour_Except(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        GameModel gm = new GameModel(players,bank,developmentCards,dice,23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addSettlement(4, 0, 1, 11);},"Should throw IndexOutOfBounds Exception");
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerOneTerNegOneTer1Ter11_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(1), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addSettlement(1, -1, 1, 11));
        EasyMock.verify(players.get(1), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerTwoTer0Ter19Ter11_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addSettlement(2, 0, 19, 11));
        EasyMock.verify(players.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerThreeTer0Ter1Ter27_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(3), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addSettlement(3, 0, 1, 27));
        EasyMock.verify(players.get(3), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addSettlement_PlayerZeroTer0Ter1Ter12_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);
        harbors.put(settlementLocations.get(0),'?');
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(players.get(0), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addSettlement(0, 0, 1, 12));
        EasyMock.verify(players.get(0), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_addRoad_PlayerNegOne_Except(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        GameModel gm = new GameModel(players,bank,developmentCards,dice,23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addRoad(-1, 0, 1, 11, 0, 10, 11);},"Should throw IndexOutOfBounds Exception");
    }


    @Test
    public void TestBaseGameModel_addRoad_PlayerZeroTer0Ter1Ter11Ter0Ter10Ter11_True(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        List<Terrain> slTerrains2 = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);
        roads.add(EasyMock.createMock(Road.class));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(settlementLocations);
        EasyMock.expect(players.get(0).addRoad(roads.get(0))).andReturn(true);
        Map<Integer, Terrain> board = new HashMap<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addRoad(0, 0, 1, 11, 0, 10, 11));
        EasyMock.verify(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(0));
    }

    @Test
    public void TestBaseGameModel_addRoad_PlayerThreeTer10Ter20Ter21Ter10Ter11Ter21_True(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        List<Terrain> slTerrains2 = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(20);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(21);
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(21);
        roads.add(EasyMock.createMock(Road.class));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(settlementLocations);
        EasyMock.expect(players.get(3).addRoad(roads.get(0))).andReturn(true);
        Map<Integer, Terrain> board = new HashMap<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(3));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addRoad(3, 10, 20, 21, 10, 11, 21));
        EasyMock.verify(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(3));
    }

    @Test
    public void TestBaseGameModel_addRoad_PlayerOneTerNegOneTer1Ter11Ter0Ter10Ter11_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        List<Terrain> slTerrains2 = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);
        roads.add(EasyMock.createMock(Road.class));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(settlementLocations);
        Map<Integer, Terrain> board = new HashMap<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addRoad(1, -1, 1, 11, 1, 10, 11));
        EasyMock.verify(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(1));
    }

    @Test
    public void TestBaseGameModel_addRoad_PlayerFour_Except(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        GameModel gm = new GameModel(players,bank,developmentCards,dice,23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addRoad(4, 0, 1, 11, 0, 10, 11);},"Should throw IndexOutOfBounds Exception");
    }

    @Test
    public void TestBaseGameModel_addRoad_PlayerOneTer0Ter1Ter11Ter1Ter2Ter12_False(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        List<Terrain> slTerrains2 = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);
        roads.add(EasyMock.createMock(Road.class));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(settlementLocations);
        Map<Integer, Terrain> board = new HashMap<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertFalse(gm.addRoad(1, 0, 1, 11, 1, 2, 12));
        EasyMock.verify(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0));
    }


    @Test
    public void TestBaseGameModel_addRoad_PlayerOneTer1Ter2Ter12Ter1Ter11Ter12_True(){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            players.add(EasyMock.createMock(Player.class));
        }
        List<Terrain> slTerrains = new ArrayList<>();
        List<Terrain> slTerrains2 = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(12);
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(12);
        roads.add(EasyMock.createMock(Road.class));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(settlementLocations);
        EasyMock.expect(players.get(1).addRoad(roads.get(0))).andReturn(true);
        Map<Integer, Terrain> board = new HashMap<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertTrue(gm.addRoad(1, 1, 2, 12, 1, 11, 12));
        EasyMock.verify(slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), settlementLocations.get(1), roads.get(0), players.get(1));
    }

    @Test
    public void TestBaseGameModel_stealAll_PlayerNegOne_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.stealAll(-1, Resource.LUMBER);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_stealAll_PlayerZeroResourceLumber_NoExcept() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.expect(l.get(0).getResourceAmount(Resource.LUMBER)).andReturn(2);
        EasyMock.expect(l.get(0).removeResources(Resource.LUMBER, 2)).andReturn(true);
        EasyMock.expect(l.get(0).addResources(Resource.LUMBER, 2)).andReturn(true);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.LUMBER)).andReturn(3);
        EasyMock.expect(l.get(1).removeResources(Resource.LUMBER, 3)).andReturn(true);
        EasyMock.expect(l.get(0).addResources(Resource.LUMBER, 3)).andReturn(true);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.LUMBER)).andReturn(1);
        EasyMock.expect(l.get(2).removeResources(Resource.LUMBER, 1)).andReturn(true);
        EasyMock.expect(l.get(0).addResources(Resource.LUMBER, 1)).andReturn(true);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.LUMBER)).andReturn(4);
        EasyMock.expect(l.get(3).removeResources(Resource.LUMBER, 4)).andReturn(true);
        EasyMock.expect(l.get(0).addResources(Resource.LUMBER, 4)).andReturn(true);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        gm.stealAll(0, Resource.LUMBER);
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }

    @Test
    public void TestBaseGameModel_stealAll_PlayerThreeResourceWool_NoExcept() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.expect(l.get(0).getResourceAmount(Resource.WOOL)).andReturn(2);
        EasyMock.expect(l.get(0).removeResources(Resource.WOOL, 2)).andReturn(true);
        EasyMock.expect(l.get(3).addResources(Resource.WOOL, 2)).andReturn(true);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.WOOL)).andReturn(3);
        EasyMock.expect(l.get(1).removeResources(Resource.WOOL, 3)).andReturn(true);
        EasyMock.expect(l.get(3).addResources(Resource.WOOL, 3)).andReturn(true);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.WOOL)).andReturn(1);
        EasyMock.expect(l.get(2).removeResources(Resource.WOOL, 1)).andReturn(true);
        EasyMock.expect(l.get(3).addResources(Resource.WOOL, 1)).andReturn(true);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.WOOL)).andReturn(4);
        EasyMock.expect(l.get(3).removeResources(Resource.WOOL, 4)).andReturn(true);
        EasyMock.expect(l.get(3).addResources(Resource.WOOL, 4)).andReturn(true);
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0), l.get(1), l.get(2), l.get(3));
        gm.stealAll(3, Resource.WOOL);
        EasyMock.verify(l.get(0), l.get(1), l.get(2), l.get(3));
    }
    @Test
    public void TestBaseGameModel_stealAll_PlayerFour_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.stealAll(4, Resource.LUMBER);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_stealAll_PlayerTwoNullResource_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(NullPointerException.class, () -> {
            gm.stealAll(2, null);
        }, "NullPointerException should be thrown");
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_FirstPlayerNegOne_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.sendRandomResource(-1, 1);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingRoads_TerNegOneTer10Ter11_Empty(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);

        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(2).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        List<SettlementLocation> firstRoadSettlements = new ArrayList<>();
        firstRoadSettlements.add(settlementLocations.get(0));
        firstRoadSettlements.add(settlementLocations.get(1));
        List<SettlementLocation> secondRoadSettlements = new ArrayList<>();
        secondRoadSettlements.add(settlementLocations.get(0));
        secondRoadSettlements.add(settlementLocations.get(2));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(firstRoadSettlements);
        EasyMock.expect(roads.get(1).getSettlements()).andReturn(secondRoadSettlements);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(new ArrayList<>(), gm.getPossibleStartingRoads(-1, 10, 11));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingRoads_Ter0Ter19Ter11_Empty(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);

        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(2).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        List<SettlementLocation> firstRoadSettlements = new ArrayList<>();
        firstRoadSettlements.add(settlementLocations.get(0));
        firstRoadSettlements.add(settlementLocations.get(1));
        List<SettlementLocation> secondRoadSettlements = new ArrayList<>();
        secondRoadSettlements.add(settlementLocations.get(0));
        secondRoadSettlements.add(settlementLocations.get(2));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(firstRoadSettlements);
        EasyMock.expect(roads.get(1).getSettlements()).andReturn(secondRoadSettlements);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(new ArrayList<>(), gm.getPossibleStartingRoads(0, 19, 11));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingRoads_Ter0Ter10TerNegTen_Empty(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);

        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(2).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        List<SettlementLocation> firstRoadSettlements = new ArrayList<>();
        firstRoadSettlements.add(settlementLocations.get(0));
        firstRoadSettlements.add(settlementLocations.get(1));
        List<SettlementLocation> secondRoadSettlements = new ArrayList<>();
        secondRoadSettlements.add(settlementLocations.get(0));
        secondRoadSettlements.add(settlementLocations.get(2));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(firstRoadSettlements);
        EasyMock.expect(roads.get(1).getSettlements()).andReturn(secondRoadSettlements);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(new ArrayList<>(), gm.getPossibleStartingRoads(0, 10, -10));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingRoads_Ter21Ter10Ter1NotConnected_Empty(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);

        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(2).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        List<SettlementLocation> firstRoadSettlements = new ArrayList<>();
        firstRoadSettlements.add(settlementLocations.get(0));
        firstRoadSettlements.add(settlementLocations.get(1));
        List<SettlementLocation> secondRoadSettlements = new ArrayList<>();
        secondRoadSettlements.add(settlementLocations.get(0));
        secondRoadSettlements.add(settlementLocations.get(2));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(firstRoadSettlements);
        EasyMock.expect(roads.get(1).getSettlements()).andReturn(secondRoadSettlements);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(new ArrayList<>(), gm.getPossibleStartingRoads(21, 10, 1));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingRoads_Ter0Ter10Ter11TwoRoads_TwoRoads(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains).times(2);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(2);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(2);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(2);

        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(0);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(1);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(11);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(2).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        List<SettlementLocation> firstRoadSettlements = new ArrayList<>();
        firstRoadSettlements.add(settlementLocations.get(0));
        firstRoadSettlements.add(settlementLocations.get(1));
        List<SettlementLocation> secondRoadSettlements = new ArrayList<>();
        secondRoadSettlements.add(settlementLocations.get(0));
        secondRoadSettlements.add(settlementLocations.get(2));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(firstRoadSettlements);
        EasyMock.expect(roads.get(1).getSettlements()).andReturn(secondRoadSettlements);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(roads, gm.getPossibleStartingRoads(0, 10, 11));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), roads.get(0), roads.get(1));
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingRoads_Ter11Ter21Ter22ThreeRoads_ThreeRoads(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(slTerrains);
        EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(21);
        EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(22);
        EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(32);

        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(1).getTerrains()).andReturn(slTerrains2).times(3);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(11).times(3);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(21).times(3);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(22).times(3);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(2).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);

        List<Terrain> slTerrains4 = new ArrayList<>();
        slTerrains4.add(EasyMock.createMock(Terrain.class));
        slTerrains4.add(EasyMock.createMock(Terrain.class));
        slTerrains4.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(3).getTerrains()).andReturn(slTerrains4);
        EasyMock.expect(slTerrains4.get(0).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains4.get(1).getLocID()).andReturn(12);
        EasyMock.expect(slTerrains4.get(2).getLocID()).andReturn(22);

        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        roads.add(EasyMock.createMock(Road.class));
        List<SettlementLocation> firstRoadSettlements = new ArrayList<>();
        firstRoadSettlements.add(settlementLocations.get(0));
        firstRoadSettlements.add(settlementLocations.get(1));
        List<SettlementLocation> secondRoadSettlements = new ArrayList<>();
        secondRoadSettlements.add(settlementLocations.get(1));
        secondRoadSettlements.add(settlementLocations.get(2));
        List<SettlementLocation> thirdRoadSettlements = new ArrayList<>();
        thirdRoadSettlements.add(settlementLocations.get(1));
        thirdRoadSettlements.add(settlementLocations.get(3));
        EasyMock.expect(roads.get(0).getSettlements()).andReturn(firstRoadSettlements);
        EasyMock.expect(roads.get(1).getSettlements()).andReturn(secondRoadSettlements);
        EasyMock.expect(roads.get(2).getSettlements()).andReturn(thirdRoadSettlements);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        EasyMock.replay(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), slTerrains4.get(0), slTerrains4.get(1), slTerrains4.get(2), settlementLocations.get(3), roads.get(0), roads.get(1), roads.get(2));
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(roads, gm.getPossibleStartingRoads(11, 21, 22));
        EasyMock.verify(slTerrains.get(0), slTerrains.get(1), slTerrains.get(2), settlementLocations.get(0), slTerrains2.get(0), slTerrains2.get(1), slTerrains2.get(2), settlementLocations.get(1), slTerrains3.get(0), slTerrains3.get(1), slTerrains3.get(2), settlementLocations.get(2), slTerrains4.get(0), slTerrains4.get(1), slTerrains4.get(2), settlementLocations.get(3), roads.get(0), roads.get(1), roads.get(2));
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingSettlements_NoSettlements_70Options(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        for(int i = 0; i < 70; i++) {
            List<Terrain> slTerrains = new ArrayList<>();
            slTerrains.add(EasyMock.createMock(Terrain.class));
            slTerrains.add(EasyMock.createMock(Terrain.class));
            slTerrains.add(EasyMock.createMock(Terrain.class));
            settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
            EasyMock.expect(settlementLocations.get(i).getOwner()).andReturn(0);
            EasyMock.expect(settlementLocations.get(i).getTerrains()).andReturn(slTerrains);
            EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
            EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10);
            EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
        }

        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        for(int i = 0; i < 70; i ++) {
            EasyMock.replay(settlementLocations.get(i));
        }
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(settlementLocations, gm.getPossibleStartingSettlements());
        for(int i = 0; i < 70; i ++) {
            EasyMock.verify(settlementLocations.get(i));
        }
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingSettlements_OneSettlement_66Options(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<SettlementLocation> expectedLocations = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        for(int i = 0; i < 66; i++) {
            settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
            EasyMock.expect(settlementLocations.get(i).getOwner()).andReturn(0);
            EasyMock.expect(settlementLocations.get(i).getTerrains()).andReturn(slTerrains);
            EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
            EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10);
            EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
            expectedLocations.add(settlementLocations.get(i));
        }
        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(66).getOwner()).andReturn(1);
        EasyMock.expect(settlementLocations.get(66).getTerrains()).andReturn(slTerrains2).times(71);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(11).times(71);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(21).times(71);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(22).times(71);

        List<Terrain> slTerrains3 = new ArrayList<>();
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        slTerrains3.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(67).getOwner()).andReturn(0);
        EasyMock.expect(settlementLocations.get(67).getTerrains()).andReturn(slTerrains3);
        EasyMock.expect(slTerrains3.get(0).getLocID()).andReturn(10);
        EasyMock.expect(slTerrains3.get(1).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains3.get(2).getLocID()).andReturn(21);

        List<Terrain> slTerrains4 = new ArrayList<>();
        slTerrains4.add(EasyMock.createMock(Terrain.class));
        slTerrains4.add(EasyMock.createMock(Terrain.class));
        slTerrains4.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(68).getOwner()).andReturn(0);
        EasyMock.expect(settlementLocations.get(68).getTerrains()).andReturn(slTerrains4);
        EasyMock.expect(slTerrains4.get(0).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains4.get(1).getLocID()).andReturn(12);
        EasyMock.expect(slTerrains4.get(2).getLocID()).andReturn(22);

        List<Terrain> slTerrains5 = new ArrayList<>();
        slTerrains5.add(EasyMock.createMock(Terrain.class));
        slTerrains5.add(EasyMock.createMock(Terrain.class));
        slTerrains5.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(69).getOwner()).andReturn(0);
        EasyMock.expect(settlementLocations.get(69).getTerrains()).andReturn(slTerrains5);
        EasyMock.expect(slTerrains5.get(0).getLocID()).andReturn(21);
        EasyMock.expect(slTerrains5.get(1).getLocID()).andReturn(22);
        EasyMock.expect(slTerrains5.get(2).getLocID()).andReturn(32);

        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        for(int i = 0; i < 70; i ++) {
            EasyMock.replay(settlementLocations.get(i));
        }
        for(int i = 0; i < 3; i++) {
            EasyMock.replay(slTerrains.get(i), slTerrains2.get(i), slTerrains3.get(i), slTerrains4.get(i), slTerrains5.get(i));
        }
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(expectedLocations, gm.getPossibleStartingSettlements());
        for(int i = 0; i < 70; i ++) {
            EasyMock.verify(settlementLocations.get(i));
        }
        for(int i = 0; i < 3; i++) {
            EasyMock.verify(slTerrains.get(i), slTerrains2.get(i), slTerrains3.get(i), slTerrains4.get(i), slTerrains5.get(i));
        }
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingSettlements_30Settlements_1Option(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<SettlementLocation> expectedLocations = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        for(int i = 0; i < 69; i++) {
            settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
            if(i < 30) {
                EasyMock.expect(settlementLocations.get(i).getOwner()).andReturn(1);
                EasyMock.expect(settlementLocations.get(i).getTerrains()).andReturn(slTerrains).times(71);
                EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(71);
                EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(71);
                EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(71);
            }
            else {
                EasyMock.expect(settlementLocations.get(i).getOwner()).andReturn(0);
                EasyMock.expect(settlementLocations.get(i).getTerrains()).andReturn(slTerrains);
                EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0);
                EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10);
                EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11);
            }
        }
        List<Terrain> slTerrains2 = new ArrayList<>();
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        slTerrains2.add(EasyMock.createMock(Terrain.class));
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(69).getOwner()).andReturn(0);
        EasyMock.expect(settlementLocations.get(69).getTerrains()).andReturn(slTerrains2);
        EasyMock.expect(slTerrains2.get(0).getLocID()).andReturn(11);
        EasyMock.expect(slTerrains2.get(1).getLocID()).andReturn(21);
        EasyMock.expect(slTerrains2.get(2).getLocID()).andReturn(22);
        expectedLocations.add(settlementLocations.get(69));
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        for(int i = 0; i < 70; i ++) {
            EasyMock.replay(settlementLocations.get(i));
        }
        for(int i = 0; i < 3; i++) {
            EasyMock.replay(slTerrains.get(i), slTerrains2.get(i));
        }
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(expectedLocations, gm.getPossibleStartingSettlements());
        for(int i = 0; i < 70; i ++) {
            EasyMock.verify(settlementLocations.get(i));
        }
        for(int i = 0; i < 3; i++) {
            EasyMock.verify(slTerrains.get(i), slTerrains2.get(i));
        }
    }

    @Test
    public void TestBaseGameModel_getPossibleStartingSettlements_70Settlements_0Options(){
        List<Player> players = new ArrayList<>();
        HashMap<SettlementLocation, Character> harbors = new HashMap<>();
        List<SettlementLocation> expectedLocations = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Terrain> slTerrains = new ArrayList<>();
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        slTerrains.add(EasyMock.createMock(Terrain.class));
        for(int i = 0; i < 70; i++) {
            settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
            EasyMock.expect(settlementLocations.get(i).getOwner()).andReturn(1);
            EasyMock.expect(settlementLocations.get(i).getTerrains()).andReturn(slTerrains).times(71);
            EasyMock.expect(slTerrains.get(0).getLocID()).andReturn(0).times(71);
            EasyMock.expect(slTerrains.get(1).getLocID()).andReturn(10).times(71);
            EasyMock.expect(slTerrains.get(2).getLocID()).andReturn(11).times(71);
        }
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = EasyMock.createMock(ArrayList.class);
        Dice[] dice = new Dice[2];
        for(int i = 0; i < 70; i ++) {
            EasyMock.replay(settlementLocations.get(i));
        }
        for(int i = 0; i < 3; i++) {
            EasyMock.replay(slTerrains.get(i));
        }
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roads, harbors, 23);
        Assertions.assertEquals(expectedLocations, gm.getPossibleStartingSettlements());
        for(int i = 0; i < 70; i ++) {
            EasyMock.verify(settlementLocations.get(i));
        }
        for(int i = 0; i < 3; i++) {
            EasyMock.verify(slTerrains.get(i));
        }
    }
    @Test
    public void TestBaseGameModel_sendRandomResource_FirstPlayer0SecondPlayer1HasResource_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Random random = EasyMock.createMock(Random.class);
        EasyMock.expect(random.nextInt(3)).andReturn(2);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.ORE)).andReturn(2);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.WHEAT)).andReturn(1);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.BRICK)).andReturn(0);
        EasyMock.expect(l.get(1).getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(l.get(1).removeResources(Resource.WHEAT, 1)).andReturn(true);
        EasyMock.expect(l.get(0).addResources(Resource.WHEAT, 1)).andReturn(true);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23, random);
        EasyMock.replay(l.get(1), l.get(2), random);
        Assertions.assertTrue(gm.sendRandomResource(0, 1));
        EasyMock.verify(l.get(1), l.get(2), random);
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_FirstPlayer3SecondPlayer2NoResources_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(2).getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.BRICK)).andReturn(0);
        EasyMock.expect(l.get(2).getResourceAmount(Resource.WOOL)).andReturn(0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(2));
        Assertions.assertFalse(gm.sendRandomResource(3, 2));
        EasyMock.verify(l.get(2));
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_FirstPlayerFour_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.sendRandomResource(4, 1);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_SecondPlayerNegOne_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.sendRandomResource(1, -1);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_FirstPlayer2SecondPlayer0NoResources_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(0).getResourceAmount(Resource.LUMBER)).andReturn(0);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.ORE)).andReturn(0);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.WHEAT)).andReturn(0);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.BRICK)).andReturn(0);
        EasyMock.expect(l.get(0).getResourceAmount(Resource.WOOL)).andReturn(0);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0));
        Assertions.assertFalse(gm.sendRandomResource(2, 0));
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_FirstPlayer1SecondPlayer3HasResource_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Random random = EasyMock.createMock(Random.class);
        EasyMock.expect(random.nextInt(7)).andReturn(4);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.LUMBER)).andReturn(2);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.ORE)).andReturn(1);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.WHEAT)).andReturn(3);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.BRICK)).andReturn(1);
        EasyMock.expect(l.get(3).getResourceAmount(Resource.WOOL)).andReturn(0);
        EasyMock.expect(l.get(3).removeResources(Resource.WHEAT, 1)).andReturn(true);
        EasyMock.expect(l.get(1).addResources(Resource.WHEAT, 1)).andReturn(true);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23, random);
        EasyMock.replay(l.get(1), l.get(3), random);
        Assertions.assertTrue(gm.sendRandomResource(1, 3));
        EasyMock.verify(l.get(1), l.get(3), random);
    }

    @Test
    public void TestBaseGameModel_sendRandomResource_SecondPlayerFour_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.sendRandomResource(2, 4);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void test_rollDice_withMinimumValue_expect2() {
        
        Dice d1 = EasyMock.createMock(Dice.class);
        Dice d2 = EasyMock.createMock(Dice.class);

        Dice[] dice = new Dice[2];
        dice[0] = d1;
        dice[1] = d2;

        EasyMock.expect(d1.roll()).andReturn(1);
        EasyMock.expect(d2.roll()).andReturn(1);
        
        EasyMock.replay(d1, d2);
        GameModel gm = new GameModel(dice);
        int result = gm.rollDice();
        EasyMock.verify(d1, d2);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_rollDice_withMaximumValue_expect12() {
            
            Dice d1 = EasyMock.createMock(Dice.class);
            Dice d2 = EasyMock.createMock(Dice.class);
    
            Dice[] dice = new Dice[2];
            dice[0] = d1;
            dice[1] = d2;
    
            EasyMock.expect(d1.roll()).andReturn(6);
            EasyMock.expect(d2.roll()).andReturn(6);
            
            EasyMock.replay(d1, d2);
            GameModel gm = new GameModel(dice);
            int result = gm.rollDice();
            EasyMock.verify(d1, d2);
            Assertions.assertEquals(12, result);
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_PlayerNegOne_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.getDevelopmentCard(-1, 0);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player4_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.getDevelopmentCard(4, 0);
        }, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player0Card1_Knight() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Knight k = EasyMock.createMock(Knight.class);
        EasyMock.expect(l.get(0).removeDevelopmentCard(1)).andReturn(k);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertEquals(k, gm.getDevelopmentCard(0, 1));
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player3Card2_VictoryPoint() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        VictoryPoint vp = EasyMock.createMock(VictoryPoint.class);
        EasyMock.expect(l.get(3).removeDevelopmentCard(2)).andReturn(vp);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(3));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertEquals(vp, gm.getDevelopmentCard(3, 2));
        EasyMock.verify(l.get(3));
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player0CardNegOne_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(0).removeDevelopmentCard(-1)).andThrow(new IndexOutOfBoundsException());
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(0));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    gm.getDevelopmentCard(0, -1);}, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player1CardFour_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(1).removeDevelopmentCard(4)).andThrow(new IndexOutOfBoundsException());
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(1));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gm.getDevelopmentCard(1, 4);}, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(l.get(1));
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player1Card0_Monopoly() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Monopoly m = EasyMock.createMock(Monopoly.class);
        EasyMock.expect(l.get(1).removeDevelopmentCard(0)).andReturn(m);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(1));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertEquals(m, gm.getDevelopmentCard(1, 0));
        EasyMock.verify(l.get(1));
    }

    @Test
    public void TestBaseGameModel_getDevelopmentCard_Player2Card3_YearofPlenty() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        YearofPlenty yop = EasyMock.createMock(YearofPlenty.class);
        EasyMock.expect(l.get(2).removeDevelopmentCard(3)).andReturn(yop);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(l.get(2));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertEquals(yop, gm.getDevelopmentCard(2, 3));
        EasyMock.verify(l.get(2));
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_PlayerNegOne_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addDevelopmentCard(-1);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_Player0DevCards2_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        EasyMock.expect(l.get(0).addOneDevelopmentCard(developmentCards.get(1))).andReturn(true);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0));
        gm.addDevelopmentCard(0);
        Assertions.assertEquals(1, developmentCards.size());
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_Player3DevCards5_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        EasyMock.expect(l.get(3).addOneDevelopmentCard(developmentCards.get(4))).andReturn(true);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(3));
        gm.addDevelopmentCard(3);
        Assertions.assertEquals(4, developmentCards.size());
        EasyMock.verify(l.get(3));
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_PlayerFour_Except() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.addDevelopmentCard(4);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_Player1DevCards0_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        gm.addDevelopmentCard(1);
        Assertions.assertNotEquals(-1, developmentCards.size());
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_Player2DevCards1_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 1; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        EasyMock.expect(l.get(2).addOneDevelopmentCard(developmentCards.get(0))).andReturn(true);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(2));
        gm.addDevelopmentCard(2);
        Assertions.assertEquals(0, developmentCards.size());
        EasyMock.verify(l.get(2));
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_Player0DevCards3_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        EasyMock.expect(l.get(0).addOneDevelopmentCard(developmentCards.get(2))).andReturn(true);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0));
        gm.addDevelopmentCard(0);
        Assertions.assertEquals(2, developmentCards.size());
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_addDevelopmentCard_Player3DevCards25_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            developmentCards.add(EasyMock.createMock(DevelopmentCard.class));
        }
        EasyMock.expect(l.get(3).addOneDevelopmentCard(developmentCards.get(24))).andReturn(true);
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(3));
        gm.addDevelopmentCard(3);
        Assertions.assertEquals(24, developmentCards.size());
        EasyMock.verify(l.get(3));
    }

    @Test
    public void TestBaseGameModel_turnToCity_Player0ValidSettlementLocationNoSettlement_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(terrains);
        EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
        EasyMock.expect(settlementLocations.get(0).getOwner()).andReturn(0);
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertFalse(gm.turnToCity(0, 0, 1, 11));
        EasyMock.verify(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_turnToCity_Player1InvalidSettlementLocation_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(terrains);
        EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertFalse(gm.turnToCity(1, 0, 1, 12));
        EasyMock.verify(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_turnToCity_Player3ValidSettlementLocationSettlement_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(terrains);
        EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
        EasyMock.expect(settlementLocations.get(0).getOwner()).andReturn(4);
        settlementLocations.get(0).convertToCity();
        EasyMock.expectLastCall();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertTrue(gm.turnToCity(3, 0, 1, 11));
        EasyMock.verify(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_turnToCity_PlayerNegOne_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.turnToCity(-1, 0, 1, 11);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_turnToCity_PlayerFour_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.turnToCity(4, 0, 1, 11);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_turnToCity_Player0ValidSettlementLocationSettlementWrongOwner_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        List<Terrain> terrains = new ArrayList<>();
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        terrains.add(EasyMock.createMock(Terrain.class));
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        settlementLocations.add(EasyMock.createMock(SettlementLocation.class));
        EasyMock.expect(settlementLocations.get(0).getTerrains()).andReturn(terrains);
        EasyMock.expect(terrains.get(0).getLocID()).andReturn(0);
        EasyMock.expect(terrains.get(1).getLocID()).andReturn(1);
        EasyMock.expect(terrains.get(2).getLocID()).andReturn(11);
        EasyMock.expect(settlementLocations.get(0).getOwner()).andReturn(3);
        EasyMock.expectLastCall();
        List<Road> roads = new ArrayList<>();
        EasyMock.replay(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertFalse(gm.turnToCity(0, 0, 1, 11));
        EasyMock.verify(terrains.get(0), terrains.get(1), terrains.get(2), settlementLocations.get(0));
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_PlayerNegOne_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.changeVictoryPoints(-1, 1);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_Player05VPPlusOne_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(0).addVictoryPoints(1)).andReturn(1);
        EasyMock.expect(l.get(0).checkWinCondition()).andReturn(false);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0));
        Assertions.assertFalse(gm.changeVictoryPoints(0, 1));
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_Player39VPPlusTwo_True() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(3).addVictoryPoints(2)).andReturn(2);
        EasyMock.expect(l.get(3).checkWinCondition()).andReturn(true);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(3));
        Assertions.assertTrue(gm.changeVictoryPoints(3, 2));
        EasyMock.verify(l.get(3));
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_PlayerFour_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {gm.changeVictoryPoints(4, 1);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_Player0withNeg3VP_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(InvalidParameterException.class, () -> {gm.changeVictoryPoints(0, -3);}, "InvalidParameterException should be thrown");
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_Player1with3VPNeg2VP_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(1).removeVictoryPoints(2)).andReturn(true);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(1));
        Assertions.assertFalse(gm.changeVictoryPoints(1, -2));
        EasyMock.verify(l.get(1));
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_Player3with7VPPlus2VP_False() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(3).addVictoryPoints(2)).andReturn(2);
        EasyMock.expect(l.get(3).checkWinCondition()).andReturn(false);
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(3));
        Assertions.assertFalse(gm.changeVictoryPoints(3, 2));
        EasyMock.verify(l.get(3));
    }

    @Test
    public void TestBaseGameModel_changeVictoryPoints_Player20VPPlus3VP_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(InvalidParameterException.class, () -> {gm.changeVictoryPoints(2, 3);}, "InvalidParameterException should be thrown");
    }

    @Test
    public void TestBaseGameModel_getHarborString_PlayerNegOne_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {String r = gm.getHarborString(-1);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void TestBaseGameModel_getHarborString_Player0_EmptyString() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(0).getHarborString()).andReturn("");
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(0));
        Assertions.assertEquals("", gm.getHarborString(0));
        EasyMock.verify(l.get(0));
    }

    @Test
    public void TestBaseGameModel_getHarborString_Player3_Length1String() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        EasyMock.expect(l.get(3).getHarborString()).andReturn("L");
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        EasyMock.replay(l.get(3));
        Assertions.assertEquals("L", gm.getHarborString(3));
        EasyMock.verify(l.get(3));
    }

    @Test
    public void TestBaseGameModel_getHarborString_Player4_Exception() {
        List<Player> l = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            l.add(EasyMock.createMock(Player.class));
        }
        Map<Resource, Integer> bank = new HashMap<>();
        List<DevelopmentCard> developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        Map<Integer, Terrain> board = new HashMap<>();
        List<Road> roads = new ArrayList<>();
        GameModel gm = new GameModel(l, bank, developmentCards, dice, board, settlementLocations, roads, 23);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {String r = gm.getHarborString(4);}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void test_checkOptionsToBuyWithPlayerID1() {
        Player p1 = EasyMock.createMock(Player.class);
        Player p2 = EasyMock.createMock(Player.class);
        Player p3 = EasyMock.createMock(Player.class);
        Player p4 = EasyMock.createMock(Player.class);

        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);

        EasyMock.expect(p1.getBuyableItems()).andReturn(new ArrayList<>());
        EasyMock.replay(p1);

        GameModel model = new GameModel(l);

        List<String> actual = model.checkOptionsToBuy(1);

        EasyMock.verify(p1);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_checkOptionsToBuyWithPlayerID2() {
        Player p1 = EasyMock.createMock(Player.class);
        Player p2 = EasyMock.createMock(Player.class);
        Player p3 = EasyMock.createMock(Player.class);
        Player p4 = EasyMock.createMock(Player.class);

        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);

        EasyMock.expect(p2.getBuyableItems()).andReturn(new ArrayList<>());
        EasyMock.replay(p2);

        GameModel model = new GameModel(l);

        List<String> actual = model.checkOptionsToBuy(2);

        EasyMock.verify(p2);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_checkOptionsToBuyWithPlayerID3() {
        Player p1 = EasyMock.createMock(Player.class);
        Player p2 = EasyMock.createMock(Player.class);
        Player p3 = EasyMock.createMock(Player.class);
        Player p4 = EasyMock.createMock(Player.class);

        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);

        EasyMock.expect(p3.getBuyableItems()).andReturn(new ArrayList<>());
        EasyMock.replay(p3);

        GameModel model = new GameModel(l);

        List<String> actual = model.checkOptionsToBuy(3);

        EasyMock.verify(p3);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_checkOptionsToBuyWithPlayerID4() {
        Player p1 = EasyMock.createMock(Player.class);
        Player p2 = EasyMock.createMock(Player.class);
        Player p3 = EasyMock.createMock(Player.class);
        Player p4 = EasyMock.createMock(Player.class);

        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);

        EasyMock.expect(p4.getBuyableItems()).andReturn(new ArrayList<>());
        EasyMock.replay(p4);

        GameModel model = new GameModel(l);

        List<String> actual = model.checkOptionsToBuy(4);

        EasyMock.verify(p4);
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void test_checkOptionsToBuyWithPlayerID1_withResourcesToBuyRoad() {
        Player p1 = EasyMock.createMock(Player.class);
        Player p2 = EasyMock.createMock(Player.class);
        Player p3 = EasyMock.createMock(Player.class);
        Player p4 = EasyMock.createMock(Player.class);

        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);

        List<String> buyables = new ArrayList<>();
        buyables.add("Road");

        EasyMock.expect(p1.addResources(Resource.LUMBER, 1)).andReturn(true);
        EasyMock.expect(p1.addResources(Resource.BRICK, 1)).andReturn(true);
        EasyMock.expect(p1.getBuyableItems()).andReturn(buyables);
        
        EasyMock.replay(p1);

        GameModel model = new GameModel(l);


        p1.addResources(Resource.LUMBER, 1);
        p1.addResources(Resource.BRICK, 1);
        List<String> actual = model.checkOptionsToBuy(1);

        EasyMock.verify(p1);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals("Road", actual.get(0));
    }

    @Test
    public void Test_MoveRobber_ToInvalidLocationID_throwException() {
        GameModel gm = new GameModel(new ArrayList<>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gm.moveRobber(99);
        }, "This locationID does not exist");
    }

    @Test
    public void Test_playerTakeFromBank_InvalidQuantity_throwException() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));
        GameModel gm = new GameModel(new ArrayList<>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gm.playerTakeFromBank(1, Resource.BRICK, 99);
        }, "Quantitiy can not exceed amount left in the bank");
    }
}
