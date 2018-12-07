import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.File;

import java.util.Random;

// TODO: Basically unused at the moment. Candidate for deletion or inclusion somewhere.
public class Text {

  final static int LINESIZE = 16;

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
