package unittests.DevelopmentCardTests;

import domain.GameController.GameController;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.DevelopmentCards.DevelopmentCard;
import domain.DevelopmentCards.Knight;

import java.util.HashMap;
import java.util.Map;

public class KnightTests {
    @Test
    public void Test_toString_correctName() {
        DevelopmentCard k = new Knight("Knight");
        Assertions.assertEquals(k.toString(), "Knight");
    }

    @Test
    public void Test_toString_emptyString() {
        DevelopmentCard k = new Knight("Knight");
        Assertions.assertNotEquals(k.toString(), "");
    }

    @Test
    public void Test_toString_wrongName() {
        DevelopmentCard k = new Knight("Knight");
        Assertions.assertNotEquals(k.toString(), "Development Cards");
    }
    @Test
    public void Test_useCardNullGC_Except() {
        DevelopmentCard k = new Knight("Knight");
        Assertions.assertThrows(NullPointerException.class,() -> {k.useCard(null);}
                ,"NullPointerException should be thrown");
    }
    @Test
    public void Test_useCardDefinedGC_NoExcept() {
        DevelopmentCard k = new Knight("Knight");
        GameController gc = EasyMock.createMock(GameController.class);
        Map<String, Integer> components = new HashMap<>();
        components.put("Terrain", 10);
        components.put("PlayerFromBoard", 1);
        EasyMock.expect(gc.getComponents()).andReturn(components);
        gc.moveRobber(10);
        EasyMock.expectLastCall();
        gc.getRandomCard(1);
        EasyMock.expectLastCall();
        EasyMock.replay(gc);
        k.useCard(gc);
        EasyMock.verify(gc);
    }
}
