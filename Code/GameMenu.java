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
      int choice = getNumericalInputRangeLoop(1,5);
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
      "--------------\n\n" + // 4 and 5 work as well, for testing combat and statitem generation respectively
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
        System.out.println( new StatItem(0, 0) );
        break;
    }
  }

}
