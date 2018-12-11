import static statics.StaticLib.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

/**
  * @author Marcus
  */
public class World {
  // User configurable
  private Player player;
  private ArrayList<Building> buildings = new ArrayList<Building>();
  private ArrayList<Person> persons = new ArrayList<Person>();
  private Random rand;

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public World() {
    rand = new Random(); 

    for (int x = 0; x<Game.SIZE; x++) {

      for (int y = 0; y<Game.SIZE; y++) {

        // Set the starter building and Player near the middle
        if (x == Math.floor(Game.SIZE/2) && y == Math.floor(Game.SIZE/2) ) {
          buildings.add( new Building(y,x,true) );
          player = new Player(y,x);
          persons.add( player );
        }
        else {
          if (rand.nextInt(15) == 1) persons.add( new NPC(y, x) );
          // 20% chance of replacing the null placeholder building we just added as default above, with an actual building
          else if (rand.nextInt(20) == 1) buildings.add(new Building(y, x, false));
        }
      }
    }

    new Command(this);
  }


  public String toString() {

    String[] tempArray = new String[Game.SIZE*Game.SIZE];

    // Fill array with empty symbols.
    for (int x = 0; x<Game.SIZE*Game.SIZE; x++) {
        tempArray[x] = EMPTY + "   ";
    }

    // Update it with buildings
    for (Building building : buildings) {
      char symbol;
      if (building.starterBuilding) symbol = WONDERLAND;
      else symbol = BUILDING;

      tempArray[ (int) (building.getX() + Game.SIZE * building.getY()) ] = symbol + "   ";
    }

    // Update it with NPCs and Player(s)
    for (Person person : persons) {
      char symbol = IAMERROR; // If an error happens, which shouldn't happen. TODO: Raise exception
      if (person instanceof Player) {
        symbol = PLAYER;
      }
      else if ( !playerAtPosition(person.getLocation()) ) symbol = NPC;
      tempArray[ (int) (person.getX() + Game.SIZE * person.getY()) ] = symbol + "   ";
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

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  // Move all NPCs one space, with 50% chance of standing still for each one
  public void moveNPCs() {
    for (Person p : persons) {
      int num = rand.nextInt(2);
      if (num == 1 && p instanceof NPC) moveRandom1(p);
    }
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
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
  
  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public void movePlayer(Command.Direction direction, int distance) {
    move(player, direction, distance);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  // TODO: Make similar move method for Rooms!
  private void move(Person reqPerson, Command.Direction direction, int reqDistance) {

    for (Person person : persons) {
      if ( person == reqPerson) { 
        double newX, newY = 0;

        if (direction == Command.Direction.NORTH) {
          newY = Math.max(person.getY() - reqDistance, 0);
          person.setLocation(person.getX(), newY);
        }
        else if (direction == Command.Direction.EAST) {
          newX = Math.min(person.getX() + reqDistance, Game.SIZE-1);
          person.setLocation(newX, person.getY());
        }
        else if (direction == Command.Direction.SOUTH) {
          newY = Math.min(person.getY() + reqDistance, Game.SIZE-1);
          person.setLocation(person.getX(), newY);
        }
        else { // West
          newX = Math.max(person.getX() - reqDistance, 0);
          person.setLocation(newX, person.getY());
        }
        break; // We've found the right person and moved her/him. Break!
        
      }
    }
  }

  // Checks whether the Player is at a given location (always show the Player even if an NPC is at the same position)
  public boolean playerAtPosition(Point p) {
    for (Person per : persons) {
      if ( p instanceof Player && per.getLocation() == p.getLocation() ) return true;
    }
    return false;
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
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
