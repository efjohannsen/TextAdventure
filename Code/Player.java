import java.util.ArrayList;

public class Player extends Person {

  public Player(String name) {

    super(name, new ArrayList<Item>());
  }

  public Player() {
    super(new ArrayList<Item>());
  }
  
}
