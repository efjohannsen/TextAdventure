import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;

import java.util.Random;

// TODO: Basically unused at the moment. Candidate for deletion or inclusion somewhere.

/**
  *
  * @param  name desc
  * @param  name desc
  * @return      desc
  */
public class Text {

  final static int LINESIZE = 17; // 16 characters + a newline. Linux newline is only a \n, whereas it might be two bytes for Windows as it uses \r\n. Verified offsets at the current line size of 17: 18, 36, 54

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public static void dialog() {

    try {
      File file = new File(Game.LANGPATH + "dialog.csv");
      RandomAccessFile handler = new RandomAccessFile(file, "r");

      Random rand = new Random(); 

      handler.seek( (LINESIZE + 1) * rand.nextInt(3) ); // randomMultiplier to get a random line, just for testing currently
      System.out.println( handler.readLine() );
    }
    catch (IOException e) {System.out.println(e);}
  }
}
