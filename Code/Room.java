import java.awt.Point;
import java.util.Random;

public class Room {

  Point position;
  RoomTile[] roomTiles;
  private int MAXSIZE = 5; // The length of one side/axis

  private static final char EMPTY    = '·';

  // Generates a room
  public Room(int x, int y) {

    this.position = new Point(x,y);

    Random ran = new Random();
    int SIZE = ran.nextInt(MAXSIZE) + 1;

    roomTiles = new RoomTile[SIZE * SIZE];
  }
  
  public Room() {
  
   this.position = new Point(0,0);
   roomTiles = new RoomTile[5 * 5];
  
  }

  public String toString() {
    return EMPTY + "   ";
  }
  
}
