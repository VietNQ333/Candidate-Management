package View;

import Controller.Manager;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        
        while (true) {
            manager.run();
        }
    }
}

