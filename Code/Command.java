import java.util.Scanner;
import static statics.StaticLib.*;


// Fx.: 
// go north 4
// pickup 1 (presented with a list of items, each with a number)
public class Command {
  Scanner scanner = new Scanner(System.in);
  boolean running = true;
  World world; // Passed in to be able to move a Player
  public enum Direction {NORTH, EAST, SOUTH, WEST}; // TODO: Also needed in World?


  public Command(World world) {
    this.world = world;
    menu();
  }

  private void menu() {
    
    while (running) {
      commandOptions();
      command();
            
      if (running) {
        clearScreen();
        print(world.toString(), true);
      }
    }
  }

  // NPC interaction happens automatically when on the same position
  private void commandOptions() {
    print(
    "Type in a command." + "\n" +
    "Example commands" + "\n" +
    "help                 | display this command" + "\n" +
    "go <n> <direction> | where <n> is the number of steps to move and <direction> is either north, east, south or west." + "\n" +
    "enter building       | enters a building" + "\n" +
    "exit game            | Exits to the main menu" + "\n"
    // Extra commands for inside rooms
    //"pickup item" +
    //"toggle door" +
    //"leave building" +
    , true
    );
  }

  private void command() {

    String inputLine = "";
    if ( scanner.hasNextLine() )
      inputLine = scanner.nextLine();

    String[] allWords = inputLine.split(" ");

    switch (allWords[0]) {
      case "help":
        commandOptions();
        break;
      case "go":
        if (allWords.length < 3) {
          print("Error: The go command takes three arguments: go <distance> <direction>", true);
          print("Press Enter to continue", true);
          getInput();
          break;
        }
        int distance = checkNumericalPositiveInput( allWords[1] );
        if ( distance != -1) {

          switch (allWords[2]) {
            case "north":
              world.movePlayer(Direction.NORTH, distance);
              break;
            case "east":
              world.movePlayer(Direction.EAST, distance);
              break;
            case "south":
              world.movePlayer(Direction.SOUTH, distance);
              break;
            case "west":
              world.movePlayer(Direction.WEST, distance);
              break;
            default:
             print("Error: Invalid direction: Must be north, east, south or west", true);
             print("Press Enter to continue", true);
             getInput();
             break;
          }
        }
        else {
          print("Invalid distance: Must be a positive, numerical value", true);
        }
        break;

      case "enter":
        if (allWords[1] == "building") break;
        break;
      case "exit":
        if (allWords[1] == "game") running = false;
        break;
      default:
        print("Invalid command. Try again.", true);
        print("Press Enter to continue", true);
        getInput();
    }
  }

  // TODO: We need to print some kind of current position info

  // Speaks to npc on current position.
  public void speak() {
  }

  // Picks up the item on the current position.
  public void pickup() {

  }

  public void toggleDoor() {

  }

  // Quits to the main menu
  public void quit() {
  }

}
