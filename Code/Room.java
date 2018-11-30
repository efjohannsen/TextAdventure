import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;

public class Room {

  Point position;
  RoomTile[] roomTiles;
  private int MAXSIZE = 5; // The length of one side/axis

  private static final char EMPTY    = '·';

  // Generates a room
  public Room(int x, int y) {

    Point position = new Point(x,y);

    Random ran = new Random();
    int SIZE = ran.nextInt(MAXSIZE) + 1;

    roomTiles = new RoomTile[SIZE * SIZE];
  }

  public String toString() {
    return EMPTY + "   ";
  }
  
}
