package presentation.PieceData;

import java.util.HashMap;
import java.util.Map;

public class BankInfo {
    int xPos;
    int yPos;
    Map<String, String> quantity;

    public BankInfo(int x, int y) {
        xPos = x;
        yPos = y;
        quantity = new HashMap<>();
        quantity.put("Wool", "19");
        quantity.put("Ore", "19");
        quantity.put("Wheat", "19");
        quantity.put("Brick", "19");
        quantity.put("Lumber", "19");
        quantity.put("DevCards", "25");
    }

    public String getQuantity(String resource) {
        return quantity.get(resource);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void updateQuantity(String resource, String amount) {
        quantity.replace(resource, amount);
    }
}
