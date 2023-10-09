package domain.DevelopmentCards;

import domain.GameController.GameController;

import java.util.ArrayList;
import java.util.Map;

public class Knight extends DevelopmentCard {

    public Knight(String name) {
        super(name);
        requiredComponents = new ArrayList<>();
        requiredComponents.add("Terrain");
        requiredComponents.add("PlayerFromBoard");
    }
    public void useCard(GameController gc) {
        Map<String, Integer> values = gc.getComponents();
        int terrain = values.get(requiredComponents.get(0));
        int player = values.get(requiredComponents.get(1));
        gc.moveRobber(terrain);
        gc.getRandomCard(player);
    }

}
