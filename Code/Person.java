import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Point;

/**
 * @author Marcus
 */
public class Person extends Point {

  private static final int NUMBER_OF_STATS = 8;           // Total number of stats. Determines how many total attribute points are created.
  private static final int BASE_STAT = 1;                 // Raise this to ensure a character gets at least this value in each stat.
  private static final int STARTING_STAT_POINTS = NUMBER_OF_STATS * 40; // 40 points for each stat at character generation.
  private static final int MAX_STAT = 100;                // The max value a stat can be
  private static final int LEVEL_CAP = 100;                // The max level for any Person.

  // TODO: Future location system idea:
  // Stop extending Point and have several Points as location instead. Easily extendable to new coordinates in even more places!
  // WorldPoint: Where the person is in the World. Never null.
  // BuildingID (or just the building object): Which building the person is in, or null if outside.
  // RoomID (or just the Room object itself): Which room the Person is in. No significance if outside.
  // RoomPoint: Where the person is in the Room, if in a Room. No significance if outside.
  boolean isInBuilding = false; // If in Room call the Room move method, otherwise the World move method. Starting value depends on whether the Player starts in the World or a Room.

  String name;
  int strength,     // Inventory capacity, damage
      personality,  // NPC interaction
      intelligence, // ?
      willpower,    // ?
      agility,      // To hit percentage
      endurance,    // Hitpoints
      speed,        // Extra turns in battle?
      luck,         // Extra chance for higher (fx. double) damage?
      level,

      health = 100;
  List<Item> inventory;

  static Random rand = new Random(); 

  // TODO: Should this constructor instead handle creating the item arraylist if a new one is wanted? Factory?
  // Basically it would be convenient to not have to create a million constructors and have the option to send a "true" for whether each attribute is provided or should be randomized

  // Randomize name + level
  public Person(int x, int y, List<Item> items) {
    this( x, y, randomName(), items, LEVEL_CAP);
  }

  // Randomize level only (under passed in maxLevel)
  public Person(int x, int y, String name, List<Item> items, int maxLevel) {
    this( x, y, rand.nextInt(maxLevel), name, items);
  }

  // Randomize name only (Currently PLAYER)
  public Person(int x, int y, int level, List<Item> items) {
    this( x, y, level, randomName(), items );
  }

  // MAIN CONSTRUCTOR THAT ALL OTHER CONSTRUCTORS EVENTUALLY CALL
  // Named person + specified level
  public Person(int x, int y, int level, String name, List<Item> items) {

    super(x,y);
    this.name = name;

    randomizeStats();

    // May be empty or contain items already.
    this.inventory = items;
  }

  private void randomizeStats() {
    // Randomly generate stat points and distribute them randomly
    int statPointsToDistribute = STARTING_STAT_POINTS - (BASE_STAT * NUMBER_OF_STATS);
    List<Integer> statStartValues = new ArrayList<>();

    for (int i = 0; i < NUMBER_OF_STATS-1; i++) {
      int stat = rand.nextInt( Math.min(statPointsToDistribute, MAX_STAT) );
      statStartValues.add(stat);
      statPointsToDistribute -= stat;
    }
    // The last value should be however many points remain, even if above MAX_STAT
    statStartValues.add(statPointsToDistribute);

    strength     = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    personality  = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    intelligence = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    willpower    = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    agility      = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    endurance    = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    speed        = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    luck         = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
  }

  private static String randomName() {
    // Split these up if support for other languages was implemented
    File firstFile = new File(Game.LANGPATH + "/first_names.csv");
    File lastFile = new File(Game.LANGPATH + "/last_names.csv");

    List<String> firstNames = new ArrayList<>();
    List<String> lastNames = new ArrayList<>();

    try {
      Scanner firstScan = new Scanner(firstFile).useDelimiter(",");
      Scanner lastScan = new Scanner(lastFile).useDelimiter(",");

      while (firstScan.hasNext() ) {
        firstNames.add(firstScan.next());
      }

      while (lastScan.hasNext() ) {
        lastNames.add(lastScan.next());
      }
    }
    catch (IOException e) { e.printStackTrace(); }

    return firstNames.get(rand.nextInt( firstNames.size() )) + " " + lastNames.get(rand.nextInt( lastNames.size() ) );
  }

  // TODO: Needs to handle system language in some way.
  public String toString() {
    return "Name: " + name + " HP:" + health + " STR: " + strength + " PER: " + personality;
  }
}
