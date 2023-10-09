package unittests.DevelopmentCardTests;

import domain.DevelopmentCards.Knight;
import domain.GameController.GameController;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.DevelopmentCards.DevelopmentCard;
import domain.DevelopmentCards.Monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonopolyTests {
    @Test
    public void Test_toString_correctName() {
        DevelopmentCard m = new Monopoly("Monopoly");
        Assertions.assertEquals(m.toString(), "Monopoly");
    }

    @Test
    public void Test_toString_emptyString() {
        DevelopmentCard m = new Monopoly("Monopoly");
        Assertions.assertNotEquals(m.toString(), "");
    }

    @Test
    public void Test_toString_wrongName() {
        DevelopmentCard m = new Monopoly("DevelopmentCard");
        Assertions.assertNotEquals(m.toString(), "");
    }

    @Test
    public void Test_useCardNullGC_Except() {
        DevelopmentCard m = new Monopoly("Monopoly");
        Assertions.assertThrows(NullPointerException.class,() -> {m.useCard(null);}
                , "NullPointerException should be thrown");
    }

    @Test
    public void Test_useCardDefinedGC_NoExcept() {
        DevelopmentCard m = new Monopoly("Monopoly");
        GameController gc = EasyMock.createMock(GameController.class);
        Map<String, Integer> components = new HashMap<>();
        components.put("Resource", 1);
        EasyMock.expect(gc.getComponents()).andReturn(components);
        gc.stealAllResources(1);
        EasyMock.expectLastCall();
        EasyMock.replay(gc);
        m.useCard(gc);
        EasyMock.verify(gc);
    }
}
