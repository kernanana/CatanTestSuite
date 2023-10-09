package unittests.DevelopmentCardTests;

import domain.DevelopmentCards.RoadBuilding;
import domain.GameController.GameController;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.DevelopmentCards.DevelopmentCard;
import domain.DevelopmentCards.YearofPlenty;

import java.util.HashMap;
import java.util.Map;

public class YearofPlentyTests {
    @Test
    public void Test_toString_correctName() {
        DevelopmentCard y = new YearofPlenty("Year of Plenty");
        Assertions.assertEquals(y.toString(), "Year of Plenty");
    }

    @Test
    public void Test_toString_emptyString() {
        DevelopmentCard y = new YearofPlenty("Year of Plenty");
        Assertions.assertNotEquals(y.toString(), "");
    }

    @Test
    public void Test_toString_wrongName() {
        DevelopmentCard y = new YearofPlenty("Year of Plenty");
        Assertions.assertNotEquals(y.toString(), "Development Card");
    }

    @Test
    public void Test_useCardNullGC_Except() {
        DevelopmentCard yop = new YearofPlenty("Year of Plenty");
        Assertions.assertThrows(NullPointerException.class,() -> {yop.useCard(null);}
                ,"NullPointerException should be thrown");
    }

    @Test
    public void Test_useCardDefinedGC_NoExcept() {
        DevelopmentCard yop = new YearofPlenty("Year of Plenty");
        GameController gc = EasyMock.createMock(GameController.class);
        Map<String, Integer> components = new HashMap<>();
        components.put("Resource", 2);
        EasyMock.expect(gc.getComponents()).andReturn(components);
        gc.addResource(2);
        EasyMock.expectLastCall();
        EasyMock.replay(gc);
        yop.useCard(gc);
        EasyMock.verify(gc);
    }
}
