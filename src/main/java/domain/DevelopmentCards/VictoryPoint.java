package domain.DevelopmentCards;

import domain.GameController.GameController;

import java.util.ArrayList;

public class VictoryPoint extends DevelopmentCard {

    public VictoryPoint(String name) {
        super(name);
        requiredComponents = new ArrayList<>();
    }
    public void useCard(GameController gc) {

    }
}
