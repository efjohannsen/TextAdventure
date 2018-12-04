import static statics.StaticLib.*;

public class World {
  // WorldTiles[] worldTiles;
  // User configurable
  private final int SIZE = 21; // The length of one side/axis
  private WorldTile[] worldTiles;
  private Player player;

  public World() {
    worldTiles = new WorldTile[SIZE * SIZE];

    for (int i = 0; i<worldTiles.length; i++) {

      worldTiles[i] = new WorldTile(i % SIZE, i / SIZE);
    }

    // Setting the player and starter building
    WorldTile wt = worldTiles[ (SIZE * SIZE / 2)];
    this.player = new Player();
    wt.clearPersons(); // Cleanup/Remove any NPC that might have been placed here by the random generator.
    wt.addPerson( player );
    wt.setBuilding( new Building() );
    print(this.toString(), true);  

    new Command(this);
  }

  public String toString() {

    String result = "";
    for (int i = 0; i<worldTiles.length; i++) {
      if (i % SIZE == 0) result += "\n\n"; // Such double newline trickery!
      result += worldTiles[i].toString();
    }
    return result;
  }

  public WorldTile[] getWorldTiles() {
    return worldTiles;
  }

  public void movePlayer(Command.Direction direction, int distance) {
    move(player, direction, distance);
  }

  // TODO: Loop through the worldTile array and move the Player as much as possible in the requested direction.
  // Remove the player from the old WorldTile and insert her/him into the new one.
  // TODO: Make similar move method for Rooms!
  private void move(Person person, Command.Direction direction, int reqDistance) {

    OUTER:
    // Find the WorldTile where the person is
    for (int i = 0; i<worldTiles.length; i++) {
      // Check all persons in the WorldTile
      for ( Person wtPerson : worldTiles[i].getPersons() ) {
      // We want to check if it's literally the same object, so the default equals method should work.
        if (person == wtPerson) {
          int maxDistance;

          if (direction == Command.Direction.NORTH) {
            maxDistance = Math.min(i - (reqDistance*SIZE), closestNumberDivisibleByX(i, SIZE));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          else if (direction == Command.Direction.EAST) {
            // Add the person to the new WorldTile. +1 unless they're at the far east, ie. something divisible by 21?
            maxDistance = Math.min(i + reqDistance, closestNumberDivisibleByX(i, SIZE-1));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          else if (direction == Command.Direction.SOUTH) {
            maxDistance = Math.min(i + (reqDistance*SIZE), closestNumberDivisibleByX(SIZE, i));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          else { // West
            if (i < SIZE) maxDistance = 0;
            else maxDistance = Math.min(i - reqDistance, closestNumberDivisibleByX(i, SIZE));
            worldTiles[maxDistance].addPersonFirst(wtPerson);
          }
          // Remove the person from the old WorldTile regardless of which direction they walked
          worldTiles[i].removePerson(wtPerson);
          break OUTER;
        }
      }
    }
  }
}

