package domain.DevelopmentCards;

import domain.GameController.GameController;

import java.util.ArrayList;
import java.util.List;

public abstract class DevelopmentCard {
    protected List<String> requiredComponents;
    protected boolean twice;
    private static final String[] NAMES = {"Victory Point", "Monopoly",
            "Knight", "Year of Plenty", "Road Building"};
    public static String[] getNames() {
        return NAMES.clone();
    }
    private final String name;
    public DevelopmentCard(String name) {
        this.twice = false;
        this.name = name;
    }

    public String toString() {
        return name;
    }
    //For mocking since toString doesn't work
    public String string() {
        return toString();
    }
    public List<String> getRequiredComponents() {
        return new ArrayList<>(requiredComponents);
    }
    public abstract void useCard(GameController gc);
    public boolean getIfTwice() {
        return twice;
    }
}
