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
public class StatItem extends Item {

  final static File file = new File(Game.LANGPATH + "statItem.csv");

  final static int LINESIZE = 57 + 1; // The number of characters + a newline (\n).
  static Random rand = new Random(); 
  int id;
  
  /**
    * Fetches a random StatItem
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public StatItem(int x, int y) {
    super(x, y);
    this.id = rand.nextInt( (int) file.length() / LINESIZE) + 1; // Generates an ID above 1, as the first line is the header
  }

  /**
    * Fetches a specific StatItem
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public StatItem(int x, int y, int id) {
    super(x, y);
    this.id = id;
  }

  public String toString() {
    String item = "";

    try {
      RandomAccessFile handler = new RandomAccessFile(file, "r");
      // LINESIZE + 1 to go to the next line
      handler.seek( (LINESIZE + 1) * id ); // randomMultiplier to get a random line, just for testing currently
      item = handler.readLine();
    }
    catch (IOException e) {System.out.println(e);}

    return item;
  }
}
