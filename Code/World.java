import static statics.StaticLib.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

public class World {
  // WorldTiles[] worldTiles;
  // User configurable
  private final int SIZE = 21; // The length of one side/axis
  private Player player;
  private ArrayList<Building> buildings;
  private ArrayList<Person> persons = new ArrayList<Person>();

  public World() {
    Random rand = new Random(); 

    for (int x = 0; x<SIZE; x++) {

      // We add empty buildings and an empty personsPoint (using null) to only have to check one index in the array rather than having to go through the entire arraylist for every single Point.
      for (int y = 0; y<SIZE; y++) {

        if (x == 11 && y == 11 ) persons.add( new Player(x, y) );
        else {
          if (rand.nextInt(15) == 1) persons.add( new NPC(x, y) );
          // 20% chance of replacing the null placeholder building we just added as default above, with an actual building
          else if (rand.nextInt(20) == 1) buildings.add(new Building(x, y));
        }
      }
    }

    // Just for testing. Remove afterwards, probably
    print(this.toString(), true);

    //new Command(this);
  }

  // TODO: Loop through the ArrayLists for persons and buildings
  public String toString() {

    String[] tempArray = new String[SIZE*SIZE];

    // Fill array with empty symbols.
    for (int x = 0; x<SIZE*SIZE; x++) {
        tempArray[x] = EMPTY + "   ";
    }

    // Update it with buildings
    for (Building building : buildings) {
      tempArray[ (int) (building.getX() * building.getY()) ] = BUILDING + "   ";
    }

    // Update it with NPCs and Player(s)
    for (Person person : persons) {
      String personToPrint;
      if (person instanceof NPC) {
        personToPrint = NPC + "   ";
      }
      else personToPrint = PLAYER + "   ";
      tempArray[ (int) (person.getX() * person.getY()) ] = personToPrint;
    }

    String ret = "";

    // Creating the final string, adding newlines where necessary
    for (int i = 0; i<tempArray.length; i++) {
      ret += tempArray[i];
      if (i > 0 && i % SIZE == 0) {
        ret += "\n\n";
      }
    }
    return ret;
  }

    /*
    String result = "";
    for (int i = 0; i<worldTiles.length; i++) {
      if (i % SIZE == 0) result += "\n\n";
      result += worldTiles[i].toString();
    }
    return result;
  }
  */

  /*
  public void movePlayer(Command.Direction direction, int distance) {
    move(player, direction, distance);
  }

  // TODO: Loop through the worldTile array and move the Player as much as possible in the requested direction.
  // Remove the player from the old WorldTile and insert her/him into the new one.
  // TODO: Make similar move method for Rooms!
  private void move(Person person, Command.Direction direction, int reqDistance) {

    OUTER:
    // Find the WorldTile where the person is
    for (int i = 0; i<worldTiles.length; i++) {
      // Check all persons in the WorldTile
      for ( Person wtPerson : worldTiles[i].getPersons() ) {
      // We want to check if it's literally the same object, so the default equals method should work.
        if (person == wtPerson) {
          int maxDistance;

          if (direction == Command.Direction.NORTH) {
            maxDistance = Math.min(i - (reqDistance*SIZE), closestNumberDivisibleByX(i, SIZE));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          else if (direction == Command.Direction.EAST) {
            // Add the person to the new WorldTile. +1 unless they're at the far east, ie. something divisible by 21?
            maxDistance = Math.min(i + reqDistance, closestNumberDivisibleByX(i, SIZE-1));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          else if (direction == Command.Direction.SOUTH) {
            maxDistance = Math.min(i + (reqDistance*SIZE), closestNumberDivisibleByX(SIZE, i));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          else { // West
            if (i < SIZE) maxDistance = 0;
            else maxDistance = Math.min(i - reqDistance, closestNumberDivisibleByX(i, SIZE));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          // Remove the person from the old WorldTile regardless of which direction they walked
          worldTiles[i].removePerson(wtPerson);
          break OUTER;
        }
      }
    }
  }
  */
}

