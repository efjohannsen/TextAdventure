import java.util.ArrayList;

/**
 * @author Marcus
 */
public class Player extends Person {

  // public Player(String name) {

  //   super(name, new ArrayList<Item>());
  // }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public Player(int x, int y) {
    super(x, y, new ArrayList<Item>());
  }
  
}
