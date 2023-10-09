package domain.GameModel;

import java.util.Random;

public class Dice {
    private Random random;
    private int recentRoll;
    Dice(Random random) {
        this.random = random;
    }
    public Dice() {
        this.random = new Random();
        this.recentRoll = 1;
    }
    public int roll() {
        recentRoll = random.nextInt(6) + 1;
        return recentRoll;
    }
    public int getLastRoll() {
        return recentRoll;
    }
}
