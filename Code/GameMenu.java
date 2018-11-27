import static statics.StaticLib.*;

import java.util.Scanner;

public class GameMenu {

  boolean running = true;

  public GameMenu() {
    menu();
  }

  private void menu() {
    Scanner scanner = new Scanner(System.in);
    while (running) {
      menuOptions();
      int choice = getNumericalInputRange(1,3); 
      menuChoice(choice);
            
      if (running) {
          getInput(); //pressEnterToContinue
          clearScreen();
      }
      scanner.close();
    }
  }

  private void menuOptions()
  {
      System.out.println(
      "\nTextAdventure!\n" +
      "-------------------\n" +
      "1. Start game \n" + 
      "2. Options \n" + 
      "-------------------\n" +
      "3. Exit game \n\n" +
      "Choose your destiny: ");
  }

  private void menuChoice(int choice) {
    switch (choice) {
      case 1:
        new World();
        break;
      case 2:
        running = false; // For now it just quits as well. Otherwise running this and then exiting -> Exception
        break;
      case 3:
        running = false;
        break;
    }
  }

}
