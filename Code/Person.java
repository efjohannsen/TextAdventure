import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Person {

    public enum Direction {NORTH, EAST, SOUTH, WEST};

    static final int NUMBER_OF_STATS = 8;
    static final int BASE_STAT = 1;                 // Raise this to ensure a character gets at least this value in each stat.
    static final int STARTING_STAT_POINTS = NUMBER_OF_STATS * 40; // 40 points for each stat at character generation.
    static final int MAX_STAT_START = 100;                // The max value a stat can be
    static final int MAX_STAT = 255;                // The max value a stat can be
    static final int MAX_LEVEL = 100;               // The max level a Person can be

  // Only one location pair necessary, or do we need to track inside/outside building explicitly?
  String name;
  int xLocation,
      yLocation,
      strength,     // Inventory capacity, damage
      intelligence, // ?
      willpower,    // ?
      agility,      // To hit percentage
      endurance,    // Hitpoints
      personality,  // NPC interaction
      speed,        // Extra turns in battle?
      luck,         // Extra chance for higher (fx. double) damage?
      level;
  ArrayList<Item> items;

  static Random rand = new Random(); 

  public Person(int xLocation, int yLocation) {
    this( xLocation, yLocation, rand.nextInt(MAX_LEVEL), randomName(), new ArrayList<Item>() );
  }

  public Person(int xLocation, int yLocation, int level, String name, ArrayList<Item> items) {

    this.xLocation = xLocation;
    this.yLocation = yLocation;
    this.level = level;
    this.name = name;
    this.items = items;

    // Randomly generate stat points and distribute them randomly
    int statPointsToDistribute = STARTING_STAT_POINTS - (BASE_STAT * NUMBER_OF_STATS);
    ArrayList<Integer> statStartValues = new ArrayList<Integer>();

    for (int i = 0; i < NUMBER_OF_STATS-1; i++) {
      int stat = rand.nextInt( Math.min(statPointsToDistribute, MAX_STAT_START) );
      statStartValues.add(stat);
      statPointsToDistribute -= stat;
    }
    // The last value should be however many points remain, even if above MAX_STAT_START
    statStartValues.add(statPointsToDistribute);

    this.strength = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.intelligence = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.willpower = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.agility = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.endurance = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.personality = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.speed = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
    this.luck = statStartValues.remove( rand.nextInt( statStartValues.size() ) );
  }

  // Res: http://listofrandomnames.com/index.cfm
  private static String randomName() {
    File firstFile = new File("Res/Lang/" + Game.lang + "/first_names.csv");
    File lastFile = new File("Res/Lang/" + Game.lang + "/last_names.csv");

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
    
    String firstName = firstNames.get(rand.nextInt( firstNames.size() ));
    String lastName = lastNames.get(rand.nextInt( lastNames.size() ) );
 
    return firstName + " " + lastName;
  }

  // North, south, east, west. Enum?
  public void move() {
  }

  // TODO: Needs to handle system language in some way.
  public String toString() {
    return "Name: " + name
    + "\n" +  "xLocation: " + xLocation
    + "\n" + "yLocation: " + yLocation 
    + "\n" + "Strength: " + strength 
    + "\n" + "Intelligence: " + intelligence 
    + "\n" + "Willpower: " + willpower 
    + "\n" + "Agility: " + agility 
    + "\n" + "Endurance: " + endurance 
    + "\n" + "Personality: " + personality 
    + "\n" + "Speed: " + speed 
    + "\n" + "Luck: " + luck 
    + "\n" + "Level: " + level ;
  }
}
