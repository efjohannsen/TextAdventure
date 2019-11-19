import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;

import java.util.Random;

/**
 * @author Marcus
 */
public class StatItem extends Item {

  final static File file = new File(Game.LANGPATH + "statItem.csv");

  final static int LINESIZE = 63 + 1; // The number of characters + a newline (\n).
  static Random rand = new Random(); 

  // Fetches a random StatItem
  public StatItem(int x, int y) {
    super(x, y);
    id = rand.nextInt( (int) (file.length() / LINESIZE) -1) + 1; // Generates an ID above 1, as the first line is the header
  }

  // Fetches a specific StatItem
  public StatItem(int x, int y, int id) {
    super(x, y);
    id = id;
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
      "Attack " + attrs[1]   + "\n" +
      "To hit: " + attrs[2]  + "\n" +
      "Defense: " + attrs[3] + "\n" +
      "Health: " + attrs[4]  + "\n" +
      "Weight: " + attrs[5]  + "\n" +
      "Description: " + attrs[6];

    return ret;
  }
}
