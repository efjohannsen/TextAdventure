import java.util.ArrayList;

/**
 * @author Marcus
 */
public class Player extends Person {

  private static int PLAYER_STARTING_LEVEL = 1;

  // public Player(String name) {

  //   super(name, new ArrayList<Item>());
  // }

  public Player(int x, int y) {
    super(x, y, PLAYER_STARTING_LEVEL, new ArrayList<Item>());
  }

}
