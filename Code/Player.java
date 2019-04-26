import java.util.ArrayList;

/**
 * @author Marcus
 */
public class Player extends Person {

  // public Player(String name) {

  //   super(name, new ArrayList<Item>());
  // }

  public Player(int x, int y) {
    super(x, y, new ArrayList<Item>());
  }
  
}
