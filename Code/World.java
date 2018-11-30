public class World {
  // WorldTiles[] worldTiles;
  // User configurable
  private final int SIZE = 21; // The length of one side/axis
  private WorldTile[] worldTiles;

  public World() {
    worldTiles = new WorldTile[SIZE * SIZE];

    for (int i = 0; i<worldTiles.length; i++) {

      worldTiles[i] = new WorldTile(i % SIZE, i / SIZE);
    }

    // Setting the player and starter building
    WorldTile wt = worldTiles[ (SIZE * SIZE / 2)];
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
