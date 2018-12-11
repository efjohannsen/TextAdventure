import java.util.Scanner;
import static statics.StaticLib.*;
import combat.Combat;

/**
 * @author Marcus
 */
public class Command {
  Scanner scanner = new Scanner(System.in);
  boolean running = true;
  World world; // Passed in to be able to move a Player
  StartBase startBase; // Passed in to remember the state of NPC dialogue/quests
  public enum Direction {NORTH, EAST, SOUTH, WEST}; // TODO: Also needed in World?


  public Command(World world, StartBase startBase) {
    this.world = world;
    this.startBase = startBase;
    menu();
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  private void menu() {
    
    while (running) {
      clearScreen();
      print(world.toString(), true);
      commandOptions();
      boolean playerMoved = command();

      if (running) {
        clearScreen();
            
        print(world.toString(), true);

        if (playerMoved) {
          try {
            Thread.sleep(1500); // Don't move the player and NPCs simultaneously but give the Player a bit of time to see their move first.
          }
          catch (InterruptedException e) {System.out.println(e);}
          world.moveNPCs();
          clearScreen();
          print(world.toString(), true);
        }
        // Both the player and NPCs move before we check for combat
        if ( world.playerOnNPC() ) {
          int res = new Combat().combat(); // TODO: When to destroy NPC or Player?
          if (res == Combat.PLAYER_DEAD) gameOver();
          else if (res == Combat.BONEKING_DEFEATED) youWin();
          else world.killPersonsAtPlayerPosition();
          clearScreen();
        }
      }
    }
  }

  private void youWin() {
    clearScreen();
    printFilePath(Game.LANGPATH + "win_game.txt");
    print("", true); // Just print a newline please
    print("Returning to the main menu", true);
    pressEnterToContinue();
    clearScreen();
    new GameMenu();
  }

  private void gameOver() {
    clearScreen();
    printFilePath(Game.LANGPATH + "lose_game.txt");
    print("", true); // Just print a newline please
    print("Returning to the main menu", true);
    pressEnterToContinue();
    clearScreen();
    new GameMenu();
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  // NPC interaction happens automatically when on the same position
  private void commandOptions() {
    print(
      "\n" +
      "Type in a command." + " Type 'help' to show available commands" + "\n"
      , true
    );
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  private void help() {
    print(
      "Symbols on the map: " + "\n" +
      PLAYER + "   is the player " + "\n" +
      NPC + "   are NPCs" + "\n" +
      WONDERLAND + "  is Wonderland, your home" + "\n" +
      BUILDING + "   is a building" +
      "\n\n" +
      "Example commands" + "\n" +
      "go <n> <direction>   | where <n> is the number of steps to move and <direction> is either north, east, south or west." + "\n" +
      "enter building       | enters a building" + "\n" +
      "exit game            | Exits to the main menu" + "\n" +
      "\n"
      // Extra commands for inside rooms
      //"pickup item" +
      //"toggle door" +
      //"leave building" +
      , true
    );
    pressEnterToContinue();

  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  // Returns true only if the player moved, because the NPCs only move if the player did and not if they fx. typed an invalid command.
  private boolean command() {

    String inputLine = "";
    if ( scanner.hasNextLine() )
      inputLine = scanner.nextLine();

    String[] allWords = inputLine.split(" ");

    switch (allWords[0]) {
      case "help":
        help();
        return false;
      case "go":
        if (allWords.length < 3) {
          print("Error: The go command takes three arguments: go <distance> <direction>", true);
          pressEnterToContinue();
          return false;
        }
        int distance = checkNumericalPositiveInput( allWords[1] );
        if ( distance != -1) {

          switch (allWords[2]) {
            case "north":
              world.movePlayer(Direction.NORTH, distance);
              return true;
            case "east":
              world.movePlayer(Direction.EAST, distance);
              return true;
            case "south":
              world.movePlayer(Direction.SOUTH, distance);
              return true;
            case "west":
              world.movePlayer(Direction.WEST, distance);
              return true;
            default:
             print("Error: Invalid direction: Must be north, east, south or west", true);
             pressEnterToContinue();
             return false;
          }
        }
        else {
          print("Invalid distance: Must be a positive, numerical value", true);
        }
        return false;

      case "enter":
        if (allWords[1].equals("building")) {
          //for (Building b : buildings
          // Check if there's a building at the current position and enter the first room. Maybe there can be a building description, even?
          int res = world.playerOnBuilding();
          if (res == 2) { 
            print("Standing on the starter building!", true); 
            new StartBase(); // TODO: Consider: Create a new one or restore the old one, either removing the "end" variable or setting tt to false, so it doesn't exit immediately
          }
          else if (res == 1) { print("Standing on a regular building!", true); } // TODO: Handle entering regular building here instead
          else print("You're not standing on a building.", true);
          pressEnterToContinue();
          return true;  // Entering a building counts as movement (= NPCs move)
        }
        return false; // Calling the command anywhere else does not
      case "exit":
        if (allWords[1].equals("game") ) running = false;
        return false;
      default:
        print("Invalid command. Try again.", true);
        pressEnterToContinue();
        return false;
    }
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  // Picks up the item on the current position.
  public void pickup() {

  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public void toggleDoor() {

  }

}
