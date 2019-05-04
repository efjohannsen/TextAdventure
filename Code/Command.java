import java.util.Scanner;
import static statics.StaticLib.*;
import combat.Combat;
import java.util.Optional;

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

  private void menu() {
    
    while (running) {
      clearScreen();
      System.out.println(world.toString());
      commandOptions();
      boolean playerMoved = command();

      if (running) { // If still running at this point of the method, ie. after a command
        clearScreen();
            
        System.out.println(world.toString());

        if (playerMoved) {
          try {
            System.out.println("NPC's are now taking their turn...");
            Thread.sleep(1500); // Don't move the player and NPCs simultaneously but give the Player a bit of time to see their move first.
          }
          catch (InterruptedException e) {System.out.println(e);}
          world.moveNPCs();
          clearScreen();
          System.out.println(world.toString());
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
    System.out.println(); // Just print a newline please
    System.out.println("Returning to the main menu");
    pressEnterToContinue();
    clearScreen();
    new GameMenu();
  }

  private void gameOver() {
    clearScreen();
    printFilePath(Game.LANGPATH + "lose_game.txt");
    System.out.println(); // Just print a newline please
    System.out.println("Returning to the main menu");
    pressEnterToContinue();
    clearScreen();
    new GameMenu();
  }

  // NPC interaction happens automatically when on the same position
  private void commandOptions() {
    System.out.println(
      "\n" +
      "Type in a command." + " Type 'help' to show available commands" + "\n"
    );
  }

  private void help() {
    System.out.println(
      "Symbols on the map: " + "\n" +
      Game.PLAYER + "   is the player " + "\n" +
      Game.NPC + "   are NPCs" + "\n" +
      Game.WONDERLAND + "  is Wonderland, your home" + "\n" +
      Game.BUILDING + "   is a building" +
      "\n\n" +
      "Example commands" + "\n" +
      "go <n> <direction>   | where <n> is the number of steps to move and <direction> is either north, east, south or west." + "\n" +
      "enter                | enters a building" + "\n" +
      "exit game            | exits to the main menu" + "\n" +
      "\n"
      // Extra commands for inside rooms
      //"pickup item" +
      //"toggle door" +
      //"leave building" +
    );
    pressEnterToContinue();

  }

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
          System.out.println("Error: The go command takes three arguments: go <distance> <direction>");
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
             System.out.println("Error: Invalid direction: Must be north, east, south or west");
             pressEnterToContinue();
             return false;
          }
        }
        else {
          System.out.println("Invalid distance: Must be a positive, numerical value");
        }
        return false;

      case "enter":
          // Check if there's a building at the current position and enter the first room. Maybe there can be a building description, even?
          Optional<Building> ob = world.playerOnBuilding();
          Building b;
          if ( ob.isPresent() ) {
            b = ob.get();
            if (b.starterBuilding == true) { 
              new StartBase(); // TODO: Consider: Create a new one or restore the old one, either removing the "end" variable or setting tt to false, so it doesn't exit immediately
            }
            else { 
              // TODO: Handle entering regular building here instead
              System.out.println("Standing on a regular building!"); 
              System.out.println(b); // Just for testing
            } 
            pressEnterToContinue();
            return true;  // Entering a building counts as movement (= NPCs move)
          }
          else { 
            System.out.println("You're not standing on a building.");
            pressEnterToContinue();
            return false; // Calling the command anywhere else does not
          }
      case "exit":
        if (allWords.length > 1) {
          if (allWords[1].equals("game") ) running = false;
        }
        return false;
      default:
        System.out.println("Invalid command. Try again.");
        pressEnterToContinue();
        return false;
    }
  }

  // Picks up the item on the current position.
  public void pickup() {

  }

  public void toggleDoor() {

  }

}
