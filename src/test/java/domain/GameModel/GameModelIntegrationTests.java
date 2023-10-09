package domain.GameModel;

import domain.DevelopmentCards.DevelopmentCard;
import domain.Resource;
import domain.Roads.Road;
import domain.Settlements.SettlementLocation;
import domain.Terrain.Terrain;
import domain.Terrain.TerrainTypes;
import domain.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModelIntegrationTests {
    public static final int NUM_RESOURCES = 19;
    @Test
    public void Test_GameModelWithOneTerrainAndOneRobber_Return0(){
        int expected = 0;
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank;
        bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        Terrain terrain = new Terrain(0, TerrainTypes.DESERT,6);
        board.put(0, terrain);
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roadLocations = new ArrayList<>();
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roadLocations, 0);
        int actual = gm.getRobberLocation();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void Test_InitialGameModelWithFullBoard_DesertIsOnLoc22_Return22(){
        int expected = 22;
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank;
        bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        for(int i = 0; i < 3; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST,6);
            board.put(i, terrain);
        }
        for(int i = 10; i < 14; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            board.put(i, terrain);
        }
        for(int i = 20; i < 25; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            if(i == 22){
                terrain = new Terrain(i, TerrainTypes.DESERT, 6);
                terrain.setRobberState(true);
            }
            board.put(i, terrain);
        }
        for(int i = 30; i < 34; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            board.put(i, terrain);
        }
        for(int i = 40; i < 43; i++) {
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            board.put(i, terrain);
        }
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roadLocations = new ArrayList<>();
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roadLocations, 22);
        int actual = gm.getRobberLocation();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void Test_InitialGameModelWithFullBoard_DesertIsOnLoc22_MovedToLoc21_Return21(){
        int expected = 21;
        List<Player> players = new ArrayList<>();
        Map<Resource, Integer> bank;
        bank = new HashMap<>();
        List<DevelopmentCard>developmentCards = new ArrayList<>();
        Dice[] dice = new Dice[2];
        Map<Integer, Terrain> board = new HashMap<>();
        for(int i = 0; i < 3; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST,6);
            board.put(i, terrain);
        }
        for(int i = 10; i < 14; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            board.put(i, terrain);
        }
        for(int i = 20; i < 25; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            if(i == 22){
                terrain = new Terrain(i, TerrainTypes.DESERT, 6);
                terrain.setRobberState(true);
            }
            board.put(i, terrain);
        }
        for(int i = 30; i < 34; i++){
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            board.put(i, terrain);
        }
        for(int i = 40; i < 43; i++) {
            Terrain terrain = new Terrain(i, TerrainTypes.FOREST, 6);
            board.put(i, terrain);
        }
        List<SettlementLocation> settlementLocations = new ArrayList<>();
        List<Road> roadLocations = new ArrayList<>();
        GameModel gm = new GameModel(players, bank, developmentCards, dice, board, settlementLocations, roadLocations, 22);
        gm.moveRobber(21);
        int actual = gm.getRobberLocation();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void TestGameTracksVictoryPoints_WhenNoPlayers_ReturnEmptyList(){
        List<Integer> expected = new ArrayList<>();
        GameModel gm = new GameModel(0);
        List<Integer> actual = gm.getVictoryPoints();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGameTracksVictoryPoints_WhenFourPlayersInitialBoard_ReturnListof4Zeros(){
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            expected.add(0);
        }
        GameModel gm = new GameModel(4);
        List<Integer> actual = gm.getVictoryPoints();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestGameTracksVictoryPoints_WhenOnePlayerHasOneVictoryPoint_ReturnListof3Zeros1One(){
        List<Player> players = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        Player player = new Player(1);
        player.addVictoryPoints(1);
        players.add(player);
        expected.add(1);
        for (int i = 2; i < 5; i++)  {
            expected.add(0);
            players.add(new Player(i));
        }
        GameModel gm = new GameModel(players);
        List<Integer> actual = gm.getVictoryPoints();
        Assertions.assertEquals(expected, actual);
    }

}
