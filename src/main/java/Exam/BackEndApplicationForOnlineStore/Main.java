package Exam.BackEndApplicationForOnlineStore;

import Exam.BackEndApplicationForOnlineStore.Menu.impl.MainMenu;
import Exam.BackEndApplicationForOnlineStore.Menu.Menu;

public class Main {
    public static final String EXIT_COMMAND = "exit";

    static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
