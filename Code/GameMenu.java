import static statics.StaticLib.*;

public class GameMenu {

  boolean running = true;

  public GameMenu() {
    menu();
  }

  public void menu() {
    while (running) {
      menuOptions();
      int choice = getNumericalInputRangeLoop(1,5);
      menuChoice(choice);
            
      if (running) {
          getInput(); //pressEnterToContinue
          clearScreen();
      }
    }
  }

  private void menuOptions() {
      print(
      "\nTextAdventure!\n" +
      "-------------------\n" +
      "1. Start game \n" + 
      "2. Options \n" + 
      "-------------------\n" +
      "3. Exit game \n\n" +
      "-------------------\n" +
      "4. StartBase \n\n" +
      "5. Combat \n\n" +
      "Choose your destiny: ", true);
  }

  private void menuChoice(int choice) {

    switch (choice) {
      case 1:
        clearScreen();
        new World();
        break;
      case 2:
        running = false; // For now it just quits as well. Otherwise running this and then exiting -> Exception
        Text.dialog();
        break;
      case 3:
        running = false;
        break;
      case 4:
        new StartBase("abc", "bac", "bac");
        break;
      case 5:
        CombatSketch.combat();
        break;

    }
  }

}
