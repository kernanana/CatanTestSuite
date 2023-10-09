package domain.GameController;

import domain.Resource;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;

public class GameControllerTests {
    @Test
    public void testNextPhase_phaseNegOne_Except() {
        Random rand = EasyMock.mock(Random.class);
        GameController gc = new GameController(4, rand, -1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.nextPhase();}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void testNextPhase_phase0Turn3_Phase1Turn3() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(3);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        gc.nextPhase();
        Assertions.assertEquals(1,gc.getPhase());
        Assertions.assertEquals(3,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testNextPhase_phase2Turn1_Phase0Turn2() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(1);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 2);
        gc.nextPhase();
        Assertions.assertEquals(0,gc.getPhase());
        Assertions.assertEquals(2,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testNextPhase_phaseThree_Except() {
        Random rand = EasyMock.createMock(Random.class);
        GameController gc = new GameController(4, rand, 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.nextPhase();}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void testNextPhase_phase0TurnNegOne_Except() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(-1);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.nextPhase();}, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(rand);
    }

    @Test
    public void testNextPhase_phase1Turn0_Phase2Turn0() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(0);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 1);
        gc.nextPhase();
        Assertions.assertEquals(2,gc.getPhase());
        Assertions.assertEquals(0,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testNextPhase_phase2Turn3_Phase0Turn0() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(3);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 2);
        gc.nextPhase();
        Assertions.assertEquals(0,gc.getPhase());
        Assertions.assertEquals(0,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testNextPhase_phase0Turn4_Except() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(4);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.nextPhase();}, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_phaseNegOne_Except() {
        Random rand = EasyMock.mock(Random.class);
        GameController gc = new GameController(4, rand, -1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.startingNextPhase();}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void testStartingNextPhase_phase0Turn3_Phase1Turn3() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(3);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        gc.startingNextPhase();
        Assertions.assertTrue(gc.getSetup());
        Assertions.assertEquals(1,gc.getPhase());
        Assertions.assertEquals(3,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_phase3Turn1_Phase2Turn0() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(2);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        for(int i = 0; i < 9; i++) {
            gc.startingNextPhase();
        }
        gc.startingNextPhase();
        Assertions.assertTrue(gc.getSetup());
        Assertions.assertEquals(2,gc.getPhase());
        Assertions.assertEquals(0,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_phase4_Except() {
        Random rand = EasyMock.mock(Random.class);
        GameController gc = new GameController(4, rand, 4);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.startingNextPhase();}, "IndexOutOfBoundsException should be thrown");
    }

    @Test
    public void testStartingNextPhase_phase0TurnNegOne_Except() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(-1);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.startingNextPhase();}, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_phase1Turn0_Phase0Turn1() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(0);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 1);
        gc.startingNextPhase();
        Assertions.assertTrue(gc.getSetup());
        Assertions.assertEquals(0,gc.getPhase());
        Assertions.assertEquals(1,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }
    @Test
    public void testStartingNextPhase_phase2Turn3_Phase3Turn3() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(3);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 2);
        gc.startingNextPhase();
        Assertions.assertTrue(gc.getSetup());
        Assertions.assertEquals(3,gc.getPhase());
        Assertions.assertEquals(3,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_phase0Turn4_Except() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(4);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            gc.startingNextPhase();}, "IndexOutOfBoundsException should be thrown");
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_TruePhase1Turn3_Phase2Turn3() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(0);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        for(int i = 0; i < 7; i++) {
            gc.startingNextPhase();
        }
        gc.startingNextPhase();
        Assertions.assertTrue(gc.getSetup());
        Assertions.assertEquals(2,gc.getPhase());
        Assertions.assertEquals(3,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }

    @Test
    public void testStartingNextPhase_TruePhase3Turn3_Phase0Turn0() {
        Random rand = EasyMock.createMock(Random.class);
        EasyMock.expect(rand.nextInt(4)).andReturn(0);
        EasyMock.replay(rand);
        GameController gc = new GameController(4, rand, 0);
        for(int i = 0; i < 15; i++) {
            gc.startingNextPhase();
        }
        gc.startingNextPhase();
        Assertions.assertFalse(gc.getSetup());
        Assertions.assertEquals(0,gc.getPhase());
        Assertions.assertEquals(0,gc.getCurrentPlayer());
        EasyMock.verify(rand);
    }


}
