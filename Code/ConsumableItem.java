import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;

import java.util.Random;

/**
 *
 * @param  name desc
 * @param  name desc
 * @return      desc
 */
public class ConsumableItem extends Item {

  final static int LINESIZE = 50 + 1; // The number of characters + a newline (\n).

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public ConsumableItem(int x, int y) {
    super(x, y);
  } 

  public ConsumableItem(int x, int y, int id) {
    super(x, y);
  }

  public String toString() {
    return ""; 
  }
}
