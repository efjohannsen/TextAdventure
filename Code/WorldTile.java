import java.awt.Point;
import java.util.ArrayList;

public class WorldTile {
  private ArrayList<Person> persons = new ArrayList<Person>();
  private Building building; // Max one building per tile
  private Point point = new Point(0,0);

  public WorldTile(Point point) {

    this.point = point;

    ArrayList<Person> persons = new Person<>();
    NPC npc1 = new NPC(0,0);
    NPC npc2 = new NPC(0,0);
    persons.add(npc1);
    persons.add(npc2);

    this.persons = persons;
    this.building = new Building();
  }
  
}
