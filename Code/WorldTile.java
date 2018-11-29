import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class WorldTile {
  private ArrayList<Person> persons = new ArrayList<Person>();
  private Building building; // Max one building per tile
  private Point position = new Point(0,0);


  // public static enum TileContent {'_', '#'};
  // public static Language lang = Language.EN;
  
  final char PLAYER = '#';
  final char NPC = 'o';
  final char BUILDING = 'M';
  final char EMPTY = '·';

  private static boolean firstRun = true;

  public WorldTile(Point position) {

    this.position = position;

    Random rand = new Random(); 
    NPC npc;

    // On the first run, ie. in the upper left corner, place a building, which is the starting building of the player!
    if (firstRun) {
      persons.add( new Player() );
      building = new Building();
      firstRun = false;
    }
    else {
      if (rand.nextInt(15) == 1) persons.add( new NPC() );
      else if (rand.nextInt(20) == 1) building = new Building();
    }
  }

  public String getPosition() {
    return "(" + position.x + "," + position.y + ")";
  }

  // firstRun needs to be reset to false whenever the user exits to the main menu in case they start a new game without restarting the program 
  public static void toggleFirstRun() {
    firstRun = !firstRun;
  }

  // Always put the player in index 0 of persons
  // When printing out showing the PLAYER takes precedence over NPC taking precedence over a BUILDING, all taking precedence over EMPTY
  public String toString() {
    //return getPosition(); 
    if (persons.size() > 0) {
      if (persons.get(0) instanceof Player) return PLAYER + "   ";
      else return NPC + "   ";
    }
    else if (building != null) return BUILDING + "   ";
    else return EMPTY + "   ";
  }
  
}
