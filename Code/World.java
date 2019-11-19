import static statics.StaticLib.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;
import java.util.Optional;

public class World extends Area {
  // User configurable
  private ArrayList<Building> buildings = new ArrayList<Building>();
  private Random rand;

  public static final int SIZE = 21; // The length of one side/axis of the World

  public World() {

    super(0, 0, SIZE); // No actual use at the moment

    rand = new Random(); 

    for (int y = 0; y<SIZE; y++) {

      for (int x = 0; x<SIZE; x++) {

        // Set the starter building and Player near the map center
        if (x == Math.floor(SIZE/2) && y == Math.floor(SIZE/2) ) {
          buildings.add( new Building(x,y,true) );
          player = new Player(x,y);
          super.persons.add( player );
        }
        else {
          if (rand.nextInt(15) == 1) super.persons.add( new NPC(x, y) );
          // 20% chance of replacing the null placeholder building we just added as default above, with an actual building
          else if (rand.nextInt(20) == 1) buildings.add(new Building(x, y, false));
        }
      }
    }
  }


  public String toString() {

    String[] tempArray = new String[SIZE*SIZE];

    // Fill array with empty symbols.
    for (int x = 0; x<SIZE*SIZE; x++) {
      tempArray[x] = Game.EMPTY + "   ";
    }

    // Update it with buildings
    for (Building building : buildings) {
      char symbol;
      if (building.starterBuilding) symbol = Game.WONDERLAND;
      else symbol = Game.BUILDING;

      tempArray[ (int) (building.getX() + SIZE * building.getY()) ] = symbol + "   ";
    }

    // Update it with NPCs and Player(s)
    for (Person person : super.persons) {
      char symbol = Game.IAMERROR; // If an error happens, which shouldn't happen. TODO: Raise exception
      int personArrayPos = (int) (person.getX() + SIZE * person.getY());
      if (person instanceof Player) {
        symbol = Game.PLAYER;
      }
      else if ( !tempArray[personArrayPos].equals(Game.PLAYER) ) symbol = Game.NPC;
      tempArray[personArrayPos] = symbol + "   ";
    }

    String ret = "";

    ret += super.player.toString() + "\n";

    // Creating the final string, adding newlines as needed
    for (int i = 0; i<tempArray.length; i++) {
      if (i > 0 && i % SIZE == 0) {
        ret += "\n\n";
      }
      ret += tempArray[i];
    }
    return ret;
  }
  // Returns ...?
  public Optional<Building> playerOnBuilding() {
    Point playerPosition = super.getPlayerPosition();
    for (Building b : buildings) {
      if ( b.getLocation().equals(playerPosition) ) {
        return Optional.of(b);
      }
    }
    return Optional.empty();
  }

}
