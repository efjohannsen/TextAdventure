import static statics.StaticLib.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

public class World {
  // User configurable
  private Player player;
  private ArrayList<Building> buildings = new ArrayList<Building>();
  private ArrayList<Person> persons = new ArrayList<Person>();
  private Random rand;

  public World() {
    rand = new Random(); 

    for (int y = 0; y<Game.SIZE; y++) {

      for (int x = 0; x<Game.SIZE; x++) {

        // Set the starter building and Player near the map center
        if (x == Math.floor(Game.SIZE/2) && y == Math.floor(Game.SIZE/2) ) {
          buildings.add( new Building(x,y,true) );
          player = new Player(x,y);
          persons.add( player );
        }
        else {
          if (rand.nextInt(15) == 1) persons.add( new NPC(x, y) );
          // 20% chance of replacing the null placeholder building we just added as default above, with an actual building
          else if (rand.nextInt(20) == 1) buildings.add(new Building(x, y, false));
        }
      }
    }
  }


  public String toString() {

    String[] tempArray = new String[Game.SIZE*Game.SIZE];

    // Fill array with empty symbols.
    for (int x = 0; x<Game.SIZE*Game.SIZE; x++) {
        tempArray[x] = Game.EMPTY + "   ";
    }

    // Update it with buildings
    for (Building building : buildings) {
      char symbol;
      if (building.starterBuilding) symbol = Game.WONDERLAND;
      else symbol = Game.BUILDING;

      tempArray[ (int) (building.getX() + Game.SIZE * building.getY()) ] = symbol + "   ";
    }

    // Update it with NPCs and Player(s)
    for (Person person : persons) {
      char symbol = Game.IAMERROR; // If an error happens, which shouldn't happen. TODO: Raise exception
      int personArrayPos = (int) (person.getX() + Game.SIZE * person.getY());
      if (person instanceof Player) {
        symbol = Game.PLAYER;
      }
      else if ( !tempArray[personArrayPos].equals(Game.PLAYER) ) symbol = Game.NPC;
      tempArray[personArrayPos] = symbol + "   ";
    }

    String ret = "";

		ret += player.toString() + "\n";

    // Creating the final string, adding newlines as needed
    for (int i = 0; i<tempArray.length; i++) {
      if (i > 0 && i % Game.SIZE == 0) {
        ret += "\n\n";
      }
      ret += tempArray[i];
    }
    return ret;
  }

  public void killPersonsAtPlayerPosition() {
    int x = (int) player.getX();
    int y = (int) player.getY();

    int i = 0;
    while ( i < persons.size() ) {
      if (persons.get(i).getX() == x && persons.get(i).getY() == y && persons.get(i) instanceof NPC) {
        persons.remove(i);
      }
      else i++;
    }
  }

  // Move all NPCs one space, with 50% chance of standing still for each one
  public void moveNPCs() {
    for (Person p : persons) {
      int num = rand.nextInt(2);
      if (num == 1 && p instanceof NPC) moveRandom1(p);
    }
  }

  // Moves a Person one step in a random direction. Could even be the Player for full simulation mode!
  public void moveRandom1(Person person) {
    int num = rand.nextInt(4);
    Command.Direction direction = Command.Direction.NORTH;
    switch (num) {
      case 0:
        // Default value, ie. NORTH
        break;
      case 1:
        direction = Command.Direction.EAST;
        break;
      case 2:
        direction = Command.Direction.SOUTH;
        break;
      case 3:
        direction = Command.Direction.WEST;
        break;
      }
    move(person, direction, 1);
  }

  public void movePlayer(Command.Direction direction, int distance) {
    move(player, direction, distance);
  }

  // TODO: Make similar move method for Rooms!
  private void move(Person reqPerson, Command.Direction direction, int reqDistance) {

    for (Person person : persons) {
      if ( person == reqPerson) { 
        int distance;

        if (direction == Command.Direction.NORTH) {
          distance = Math.min(reqDistance, (int) person.getY() );
          person.translate(0, -distance);
        }
        else if (direction == Command.Direction.EAST) {
          distance = Math.min( reqDistance, (int) person.getX() );
          person.translate(distance, 0);
        }
        else if (direction == Command.Direction.SOUTH) {
          distance = Math.min( reqDistance, Game.SIZE-1 - (int) person.getY() );
          person.translate(0, distance);
        }
        else { // West
          distance = Math.min( reqDistance, Game.SIZE-1 - (int) person.getY() );
          person.translate(-distance, 0);
        }
        break; // We've found the right person and moved her/him, no need to go through the rest.
        
      }
    }
  }

  // CURRENTLY UNUSED
  // Checks whether the Player is at a given location (always show the Player even if an NPC is at the same position)
  public boolean playerAtPosition(Point p) {
    for (Person per : persons) {
      if ( p instanceof Player && per.getLocation() == p.getLocation() ) return true;
    }
    return false;
  }

  // Returns ...?
  public int playerOnBuilding() {
    Point playerPosition = getPlayerPosition();
    for (Building b : buildings) {
      if ( b.getLocation().equals(playerPosition) ) {
        if (b.starterBuilding == true) return 2;
        else return 1;
      }
    }
    return 0;
  }

  public Point getPlayerPosition() {
    for (Person p : persons) {
      if (p instanceof Player) return p.getLocation();
    }
    return new Point(-1, -1); // ERROR. TODO: Raise exception here instead.
  }

  // Checks if the Player is standing on an NPC: Battle!
  public boolean playerOnNPC() {
    for (Person p : persons) {
      if (p instanceof NPC) { // Don't fight yourself
        if ( p.getX() == player.getX() && p.getY() == player.getY() ) 
          return true;
      }
    }
    return false;
  }
}
