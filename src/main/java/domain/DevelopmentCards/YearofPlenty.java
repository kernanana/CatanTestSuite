package domain.DevelopmentCards;

import domain.GameController.GameController;

import java.util.ArrayList;
import java.util.Map;

public class YearofPlenty extends DevelopmentCard {
    public YearofPlenty(String name) {
        super(name);
        this.twice = true;
        requiredComponents = new ArrayList<>();
        requiredComponents.add("Resource");
    }
    public void useCard(GameController gc) {
        Map<String, Integer> values = gc.getComponents();
        int resource = values.get("Resource");
        gc.addResource(resource);
    }
}
