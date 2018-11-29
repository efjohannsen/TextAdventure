import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class WorldTile {
  private ArrayList<Person> persons = new ArrayList<Person>();
  private Building building; // Max one building per tile
  private Point position = new Point(0,0);


  // public static enum TileContent {'_', '#'};
  // public static Language lang = Language.EN;
  
  private static final char PLAYER   = '#';
  private static final char NPC      = 'o';
  private static final char BUILDING = 'M';
  private static final char EMPTY    = '·';

  public WorldTile(Point position) {

    this.position = position;

    Random rand = new Random(); 

    if (rand.nextInt(15) == 1) persons.add( new NPC() );
    else if (rand.nextInt(20) == 1) building = new Building();
  }

  public String getPosition() {
    return "(" + position.x + "," + position.y + ")";
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public void setPersons(Person person) {
    persons.add(person);
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
