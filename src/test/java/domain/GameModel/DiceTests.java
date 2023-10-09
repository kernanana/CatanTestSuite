package domain.GameModel;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class DiceTests {
    @Test
    public void test_roll_withRandomNumber0_expect1() {
        Random random = EasyMock.createMock(Random.class);
        EasyMock.expect(random.nextInt(6)).andReturn(0);
        Dice dice = new Dice(random);
        EasyMock.replay(random);
        Assertions.assertEquals(1, dice.roll());
        EasyMock.verify(random);
    }

    @Test
    public void test_roll_withRandomNumber5_expect6() {
        Random random = EasyMock.createMock(Random.class);
        EasyMock.expect(random.nextInt(6)).andReturn(5);
        Dice dice = new Dice(random);
        EasyMock.replay(random);
        Assertions.assertEquals(6, dice.roll());
        EasyMock.verify(random);
    }
}
