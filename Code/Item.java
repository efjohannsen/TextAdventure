import java.awt.Point;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;

import java.util.Random;

/**
 * @author Marcus
 */
public class Item extends Point {
  int id;
  final static int LINESIZE = 45 + 1; // The number of characters + a newline (\n).

  /**
   * Fetches a random Item.
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public Item(int x, int y) {
    super(x, y);
  }

  /**
   * Fetches a specific regular item (not StatItem or ConsumableItem)
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public Item(int x, int y, int id) {
    super(x, y);
  }

  public String toString() {
    return ""; 
  }
}
