import java.awt.Point;
import java.util.ArrayList;

public class World {
  // WorldTiles[] worldTiles;
  // User configurable
  final int SIZE = 16; // The length of one side/axis
  WorldTile[] worldTiles;

  public World() {
    worldTiles = new WorldTile[SIZE * SIZE];

    for (int i = 0; i<worldTiles.length; i++) {

      worldTiles[i] = new WorldTile(new Point(i % SIZE, i / SIZE));
      if (i % SIZE == 0) System.out.println();
      System.out.print(worldTiles[i]);
    }

  }
}
