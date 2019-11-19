import java.util.ArrayList;

/**
 * @author Marcus
 */
// TODO: Is there really any need for this class, or should we just check if the Person is a Player, otherwise it's an NPC?
public class NPC extends Person {

  public NPC(int x, int y) {

    super(x, y, new ArrayList<Item>());
  }

  private void generateLoot() {

  }
}
