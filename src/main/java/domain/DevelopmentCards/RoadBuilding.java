package domain.DevelopmentCards;

import domain.GameController.GameController;

import java.util.ArrayList;
import java.util.Map;

public class RoadBuilding extends DevelopmentCard {
    public RoadBuilding(String name) {
        super(name);
        this.twice = true;
        requiredComponents = new ArrayList<>();
        requiredComponents.add("Road");
    }
    public void useCard(GameController gc) {
        Map<String, Integer> values = gc.getComponents();
        int road = values.get("Road");
        gc.addRoad(road);
    }
}
