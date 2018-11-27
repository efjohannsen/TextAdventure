import java.util.ArrayList;

public class Player extends Person {

  public Player(int xLocation, int yLocation, int level, String name, ArrayList<Item> items) {
    super(xLocation, yLocation, level, name, items);
  }

  public Player(int xLocation, int yLocation) {
    super(xLocation, yLocation);
  }
  
}
