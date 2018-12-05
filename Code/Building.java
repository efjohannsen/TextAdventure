import java.util.Random;
import java.awt.Point;

public class Building extends Point{

  Room[] rooms;
  // Hardcoded to a value without the constructor just while testing
  final int SIZE = 21;

  public Building(int x, int y) {
    // super(x, y);
    
    // TODO: Perhaps expand to make more interesting buildings
    Random ran = new Random();

    // Create the array of rooms in the building
    // SIZE = ran.nextInt(5)+1;
    // rooms = new Room[SIZE*SIZE];

    // Creating the rooms themselves
    // for (int i = 0; i < SIZE*SIZE; i++) {
    //   rooms[i] = new Room(i % SIZE, i / SIZE);
    // }
  }

  // TODO: UNFINISHED
  public String toString() {

    String result = "";
    for (int i = 0; i<rooms.length; i++) {
      if (i % SIZE == 0) result += "\n\n"; // Such double newline trickery!
      result += rooms[i].toString();
    }
    return result;
  }
}
