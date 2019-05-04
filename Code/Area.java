import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Area extends Point {

  public static int idCounter = 1;
  public int ID;
  public int SIZE;
  protected Player player;
  protected ArrayList<Person> persons = new ArrayList<Person>();
	private Random ran = new Random();

  // Used for world
  public Area(int x, int y, int size) {
    super(x, y);
    this.ID = idCounter++;
    this.SIZE = size;
  }

  // Used for rooms (room size is generated requiring a Random object which can't be created in Room as super MUST be called first
  public Area(int x, int y) {
    super(x, y);
    //creating room size randomly, minimum size is 3x3
		SIZE = Math.max(3,ran.nextInt(5)+1);
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
      int num = ran.nextInt(2);
      if (num == 1 && p instanceof NPC) moveRandom1(p);
    }
  }

  // Moves a Person one step in a random direction. Could even be the Player for full simulation mode!
  public void moveRandom1(Person person) {
    int num = ran.nextInt(4);
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

  // North and west are similar in that the boundary is 0, while East and South are similar in that the boundary is SIZE-1
  private void move(Person reqPerson, Command.Direction direction, int reqDistance) {

    for (Person person : persons) {
      if ( person == reqPerson) { 
        int distance;

        if (direction == Command.Direction.NORTH) {
          distance = Math.min( reqDistance, (int) person.getY() );
          person.translate(0, -distance);
        }
        else if (direction == Command.Direction.EAST) {
          distance = Math.min( reqDistance, SIZE-1 - (int) person.getX() );
          person.translate(distance, 0);
        }
        else if (direction == Command.Direction.SOUTH) {
          distance = Math.min( reqDistance, SIZE-1 - (int) person.getY() );
          person.translate(0, distance);
        }
        else { // West
          distance = Math.min( reqDistance, (int) person.getX() );
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


  public Point getPlayerPosition() {
    for (Person p : persons) {
      if (p instanceof Player) return p.getLocation();
    }
    throw new RuntimeException("ERROR: Player not found?!");
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
