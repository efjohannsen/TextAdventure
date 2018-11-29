import java.awt.Point;

public class World {
  // WorldTiles[] worldTiles;
  // User configurable
  final int SIZE = 21; // The length of one side/axis
  WorldTile[] worldTiles;

  public World() {
    worldTiles = new WorldTile[SIZE * SIZE];

    for (int i = 0; i<worldTiles.length; i++) {

      worldTiles[i] = new WorldTile(new Point(i % SIZE, i / SIZE));
    }

    final double SIZEDOUBLE = (double) SIZE;
    WorldTile wt = worldTiles[ (int) (SIZEDOUBLE * SIZEDOUBLE / 2)];
    wt.setPersons( new Player() );
    wt.setBuilding( new Building() );
    new Command();

    System.out.println(this);  

  }

  public String toString() {

    String result = "";
    for (int i = 0; i<worldTiles.length; i++) {
      if (i % SIZE == 0) result += "\n\n"; // Such double newline trickery!
      result += worldTiles[i].toString();
    }
    return result;
  }

}
