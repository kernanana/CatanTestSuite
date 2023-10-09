package domain.DevelopmentCards;

import domain.GameController.GameController;

import java.util.ArrayList;
import java.util.Map;

public class Monopoly extends DevelopmentCard {
    public Monopoly(String name) {
        super(name);
        requiredComponents = new ArrayList<>();
        requiredComponents.add("Resource");
    }
    public void useCard(GameController gc) {
        Map<String, Integer> values = gc.getComponents();
        int resource = values.get(requiredComponents.get(0));
        gc.stealAllResources(resource);
    }
}
