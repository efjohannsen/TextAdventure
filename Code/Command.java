import java.util.Scanner;
import static statics.StaticLib.*;
import combat.Combat;


// Fx.: 
// go north 4
// pickup 1 (presented with a list of items, each with a number)
/**
 *
 * @param  name desc
 * @param  name desc
 * @return      desc
 */
public class Command {
  Scanner scanner = new Scanner(System.in);
  boolean running = true;
  World world; // Passed in to be able to move a Player
  public enum Direction {NORTH, EAST, SOUTH, WEST}; // TODO: Also needed in World?


  public Command(World world) {
    this.world = world;
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
          new Combat().combat(); // TODO: When to destroy NPC or Player?
        }
      }
    }
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
          print("Entering building!", true);
          pressEnterToContinue();
        }
        return false;
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
