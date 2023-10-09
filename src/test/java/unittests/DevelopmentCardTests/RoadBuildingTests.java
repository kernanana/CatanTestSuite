package unittests.DevelopmentCardTests;

import domain.GameController.GameController;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.DevelopmentCards.DevelopmentCard;
import domain.DevelopmentCards.RoadBuilding;

import java.util.HashMap;
import java.util.Map;

public class RoadBuildingTests {
    @Test
    public void Test_toString_correctName() {
        DevelopmentCard rb = new RoadBuilding("Road Building");
        Assertions.assertEquals(rb.toString(), "Road Building");
    }

    @Test
    public void Test_toString_emptyString() {
        DevelopmentCard rb = new RoadBuilding("Road Building");
        Assertions.assertNotEquals(rb.toString(), "");
    }

    @Test
    public void Test_toString_wrongName() {
        DevelopmentCard rb = new RoadBuilding("Road Building");
        Assertions.assertNotEquals(rb.toString(), "Development Card");
    }
    @Test
    public void Test_useCardNullGC_Expect() {
        DevelopmentCard rb = new RoadBuilding("Road Building");
        Assertions.assertThrows(NullPointerException.class,() -> {rb.useCard(null);}
                ,"NullPointerException should be thrown");
    }
    @Test
    public void Test_useCardDefinedGC_NoExpect() {
        DevelopmentCard rb = new RoadBuilding("Road Building");
        GameController gc = EasyMock.createMock(GameController.class);
        Map<String, Integer> components = new HashMap<>();
        components.put("Road", 10112021);
        EasyMock.expect(gc.getComponents()).andReturn(components);
        gc.addRoad(10112021);
        EasyMock.expectLastCall();
        EasyMock.replay(gc);
        rb.useCard(gc);
        EasyMock.verify(gc);
    }
}
