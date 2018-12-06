import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;

public class Building extends Point {

	ArrayList<Room> rooms;

	Random ran = new Random();
	final int SIZE_X = ran.nextInt(4)+1;
	final int SIZE_Y = ran.nextInt(4)+1;

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
				txt += "[ ] ";
			}
			txt += "\n";
		}
		return txt;
	
	}

}