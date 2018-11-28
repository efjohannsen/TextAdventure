import java.awt.Point;
import java.util.ArrayList;

public class World {
  // WorldTiles[] worldTiles;
  // User configurable
  int size = 100;
  WorldTile[] worldTiles;

  public World() {
    worldTiles = new WorldTile[size];

    for (int i = 0; i<worldTiles.length; i++) {

      worldTiles[i] = new WorldTile(new Point(i % 20, i / 20));
    }

  }
}
