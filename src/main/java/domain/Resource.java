package domain;

import java.util.ArrayList;
import java.util.List;

public enum Resource {
    BRICK,
    ORE,
    WHEAT,
    WOOL,
    LUMBER;

    public static List<Resource> getResourceList() {
        List<Resource> resources = new ArrayList<>();
        resources.add(BRICK);
        resources.add(ORE);
        resources.add(WHEAT);
        resources.add(WOOL);
        resources.add(LUMBER);
        return resources;
    }
}