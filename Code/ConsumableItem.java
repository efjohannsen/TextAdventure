import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;

import java.util.Random;

/**
 * @author Marcus
 */
public class ConsumableItem extends Item {

  final static int LINESIZE = 50 + 1; // The number of characters + a newline (\n).
  final static File file = new File(Game.LANGPATH + "consumableItem.csv");
  static Random rand = new Random(); 

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public ConsumableItem(int x, int y) {
    super(x, y);
    id = rand.nextInt( (int) (file.length() / LINESIZE) -1) + 1; // Generates an ID above 1, as the first line is the header
  } 

  public ConsumableItem(int x, int y, int id) {
    super(x, y);
    this.id = id;
  }

  public String toString() {
    String item = "";
    String ret = "";

    try {
      RandomAccessFile handler = new RandomAccessFile(file, "r");
      handler.seek( LINESIZE * id );
      item = handler.readLine();
    }
    catch (IOException e) {System.out.println(e);}

    String[] attrs = item.split(",");
    ret = attrs[0] + "\n" +
      "Amount healed:" + attrs[1] + "\n" + 
      "Description:" + attrs[2];

    return ret;
  }
}
