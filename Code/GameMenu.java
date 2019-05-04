import static statics.StaticLib.*;
import combat.Combat;

/**
 * @author Marcus
 */
public class GameMenu {

  boolean running = true;

  public GameMenu() {
    clearScreen();
    printFilePath("Res/dillon.txt");
    getInput();
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
      System.out.println(
      "\nTextAdventure!\n" +
      "--------------\n" +
      "1. Start game \n" + 
      "2. Options \n" + 
      "--------------\n" +
      "3. Exit game \n" +
      "\n" +
      "Choose your destiny: ");
  }

  private void menuChoice(int choice) {

    switch (choice) {
      case 1:
        new StartBase();
        break;
      case 2:
        break;
      case 3:
        running = false;
        break;
      case 4:
        Combat combat = new Combat();
        combat.combat();
        break;
      case 5:
        System.out.println( "Testing item generation!" );
        System.out.println();
        System.out.println( new StatItem(0, 0) );
        System.out.println();
        System.out.println( new Item(0, 0) );
        System.out.println();
        System.out.println( new ConsumableItem(0, 0) );
        break;
    }
  }

}
