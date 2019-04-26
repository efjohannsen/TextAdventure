import static statics.StaticLib.*;
import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Marcus, Esben
 */
public class Building extends Point {

	private ArrayList<Room> rooms;

  private Random ran = new Random();
	private final int SIZE_X = ran.nextInt(4)+1;
	private final int SIZE_Y = ran.nextInt(4)+1;
  public boolean starterBuilding;

	//building constructor with world map coordinate parameters
	public Building(int x, int y, boolean starterBuilding) {
		
		super(x, y);
    this.starterBuilding = starterBuilding;
		
		//creating array of rooms in a building
		rooms = new ArrayList<Room>();
		
		//creating rooms
		for (int i=0; i<SIZE_X; i++) {
			for (int j=0; j<SIZE_Y; j++) {
				rooms.add(new Room(i,j));
			}
		}
		
	}

	public String toString() {

		String txt = "";
		for (int i=0; i<SIZE_X; i++) {
			for (int j=0; j<SIZE_Y; j++) {
				txt += Game.EMPTY + "   ";
			}
			txt += "\n";
		}
		return txt;
	
	}

}
