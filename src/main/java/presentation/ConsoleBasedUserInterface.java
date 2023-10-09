package presentation;

//import domain.GameController.GameController;

//import java.util.Scanner;

import java.util.Map;

public class ConsoleBasedUserInterface implements UserInterface {
    //GameController gameController;
    //Scanner sc;
    public ConsoleBasedUserInterface() {
        //sc = new Scanner(System.in);
        //gameController = new GameController(this, 4);
        setup();
    }
    private void setup() {

    }
    public void setVisible(boolean b) {
        if (b) {
            System.out.println("Visible");
        }
    }
    public void update(Map<String, String> state) {

    }
}
