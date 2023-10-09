package unittests.DevelopmentCardTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.DevelopmentCards.DevelopmentCard;
import domain.DevelopmentCards.VictoryPoint;

public class VictoryPointTests {
    @Test
    public void Test_toString_correctName() {
        DevelopmentCard vp = new VictoryPoint("Victory Point");
        Assertions.assertEquals(vp.toString(), "Victory Point");
    }

    @Test
    public void Test_toString_emptyString() {
        DevelopmentCard vp = new VictoryPoint("Victory Point");
        Assertions.assertNotEquals(vp.toString(), "");
    }

    @Test
    public void Test_toString_wrongName() {
        DevelopmentCard vp = new VictoryPoint("Victory Point");
        Assertions.assertNotEquals(vp.toString(), "Development Card");
    }
}
