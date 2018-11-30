import java.util.Random;

public class Building {

  Room[] rooms;
  final int SIZE;

  public Building() {
    
    // TODO: Perhaps expand to make more interesting buildings
    Random ran = new Random();

    // Create the array of rooms in the building
    SIZE = ran.nextInt(5)+1;
    rooms = new Room[SIZE*SIZE];

    // Creating the rooms themselves
    for (int i = 0; i < SIZE*SIZE; i++) {
      rooms[i] = new Room(i % SIZE, i / SIZE);
    }
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
