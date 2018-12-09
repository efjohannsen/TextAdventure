import static statics.StaticLib.*;
import combat.Combat;

/**
 *
 * @param  name desc
 * @param  name desc
 * @return      desc
 */
public class GameMenu {

  boolean running = true;

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public GameMenu() {
    printFilePath("Res/dillon.txt");
    getInput();
    menu();
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public void menu() {
    while (running) {
      menuOptions();
      int choice = getNumericalInputRangeLoop(1,6);
      menuChoice(choice);
            
      if (running) {
          getInput(); //pressEnterToContinue
          clearScreen();
      }
    }
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  private void menuOptions() {
      print(
      "\nTextAdventure!\n" +
      "--------------\n" +
      "1. Start game \n" + 
      "2. Options \n" + 
      "--------------\n" +
      "3. Exit game \n\n" +
      "--------------\n" +
      "4. StartBase (testing)\n" +
      "5. Combat (testing)\n" +
      "6. Dialog (testing)\n\n" + 
      "Choose your destiny: ", true);
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  private void menuChoice(int choice) {

    switch (choice) {
      case 1:
        clearScreen();
        new World();
        break;
      case 2:
        break;
      case 3:
        running = false;
        break;
      case 4:
        new StartBase("abc", "bac", "bac");
        break;
      case 5:
        Combat combat = new Combat();
        combat.combat();
        break;
      case 6:
        Text.dialog();
        break;
    }
  }

}
