import java.util.Scanner;
import static statics.StaticLib.*;

// Fx.: 
// go north 4
// pickup 1 (presented with a list of items, each with a number)
public class Command {
  Scanner scanner = new Scanner(System.in);
  boolean running = true;

  public Command() {
  }

  private void menu() {
    
    while (running) {
      commandOptions();
      command();
            
      if (running) {
          getInput(); //pressEnterToContinue
          clearScreen();
      }
    }
  }

  // NPC interaction happens automatically when on the same position
  private void commandOptions() {
    System.out.println(
    "Type in a command." +
    "Example commands" +
    "help                 | display this command" +
    "walk <n> <direction> | where <n> is the number of steps to walk and <direction> is either north, east, south or west." +
    "enter building       | enters a building" +
    "exit game            | Exits to the main menu"
    // Extra commands for inside rooms
    //"pickup item" +
    //"toggle door" +
    //"leave building" +
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
      case "walk":
        if ( isNumericalValue(allWords[1]) ) {
          switch (allWords[2]) {
            case "north":
              break;
            case "east":
              break;
            case "south":
              break;
            case "west":
              break;
            default:
              System.out.println("Invalid direction");
          }
        }
        break;
      case "enter":
        if (allWords[1] == "building") break;
        break;
      case "exit game":
        new GameMenu().menu();
        break;
      default:
        System.out.println("Invalid command. Try again.");
    }
  }

  // TODO: We need to print some kind of current position info

  // Speaks to npc on current position.
  public void speak() {
  }

  private void help() {
    
  }

  // Walks to the north, east, south, west. 
  public void walk() {
    
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
