import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Person {

    public enum Direction {NORTH, EAST, SOUTH, WEST};

    static final int NUMBER_OF_STATS = 2;
    static final int BASE_STAT = 1;                 // Raise this to ensure a character gets at least this value in each stat.
    static final int STARTING_STAT_POINTS = NUMBER_OF_STATS * 40; // 40 points for each stat at character generation.
    static final int MAX_STAT = 100;                // The max value a stat can be

  // Only one location pair necessary, or do we need to track inside/outside building explicitly?
  String name;
  int strength,     // Inventory capacity, damage
      personality;  // NPC interaction
  ArrayList<Item> inventory;

  static Random rand = new Random(); 

  public Person(ArrayList<Item> items) {
    this( randomName(), items );
  }

  public Person(String name, ArrayList<Item> items) {

    this.name = name;

    // Randomly generate stat points and distribute them randomly
    int statPointsToDistribute = STARTING_STAT_POINTS - (BASE_STAT * NUMBER_OF_STATS);
    ArrayList<Integer> statStartValues = new ArrayList<Integer>();

    for (int i = 0; i < NUMBER_OF_STATS-1; i++) {
      int stat = rand.nextInt( Math.min(statPointsToDistribute, MAX_STAT) );
      statStartValues.add(stat);
      statPointsToDistribute -= stat;
    }
    // The last value should be however many points remain, even if above MAX_STAT
    statStartValues.add(statPointsToDistribute);

    this.strength = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.personality = statStartValues.remove( rand.nextInt( statStartValues.size() ) );

    if (items.size() == 0) {
      this.inventory = new ArrayList<Item>();
    }

  }

  private static String randomName() {
    // Split these up if support for other languages was implemented
    File firstFile = new File(Game.LANGPATH + "/first_names.csv");
    File lastFile = new File(Game.LANGPATH + "/last_names.csv");

    ArrayList<String> firstNames = new ArrayList<String>();
    ArrayList<String> lastNames = new ArrayList<String>();

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
    catch (IOException e) {System.out.println(e); }
 
    return firstNames.get(rand.nextInt( firstNames.size() )) + " " + lastNames.get(rand.nextInt( lastNames.size() ) );
  }

  // North, south, east, west. Enum?
  public void move() {
  }

  // TODO: Needs to handle system languag in some way.
  public String toString() {
    return "Name: " + name
    + "\n" + "Strength: " + strength 
    + "\n" + "Personality: " + personality;
  }
}
