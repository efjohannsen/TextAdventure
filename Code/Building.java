import static statics.StaticLib.*;
import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;

public class Building extends Point {

	private ArrayList<Room> rooms;

	//creating a building size randomly
	private Random ran = new Random();
	private final int SIZE_X = ran.nextInt(4)+1;
	private final int SIZE_Y = ran.nextInt(4)+1;

	//building constructor with world map coordinate parameters
	public Building(int x, int y) {
		
		super(x, y);
		
		//creating array of rooms in a building
		rooms = new ArrayList<Room>();
		
		//creating rooms
		for (int i=0; i<SIZE_X; i++) {
			for (int j=0; j<SIZE_Y; j++) {
				rooms.add(new Room(i,j));
			}
		}
		
	}

	//prints a building
	public String toString() {

		String txt = "";
		for (int i=0; i<SIZE_X; i++) {
			for (int j=0; j<SIZE_Y; j++) {
				txt += EMPTY + "   ";
			}
			txt += "\n";
		}
		return txt;
	
	}

}