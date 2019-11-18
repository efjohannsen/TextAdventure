import static statics.StaticLib.*;
import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus, Esben
 */
public class Building extends Point {

	private List<Room> rooms;

  private Random ran = new Random();
	private final int SIZE_X = ran.nextInt(4)+1;
	private final int SIZE_Y = ran.nextInt(4)+1;
  public boolean starterBuilding;

  // Which of the rooms in the building do you enter when entering the building
  private Room startingRoom;

	//building constructor with world map coordinate parameters
	public Building(int x, int y, boolean starterBuilding) {
		
		super(x, y);
    this.starterBuilding = starterBuilding;


    int startX, startY;

    // RANDOMLY SELECTING A STARTING ROOM
    // TODO: Do I prefer to store the coordinates of this entry room and/or just its Room object?
    // TODO: Test if this works as intended!
    int posLock = ran.nextInt(4); // Randomly choose to lock either X or Y axis to their min or max value, to ensure that you can only enter the building from some edge
    // Locking X to 0 or max. Then picking a random number for the Y-axis
    if (posLock == 0 || posLock == 1) {
      startX = (posLock == 0)? 0 : SIZE_X;
      startY = ran.nextInt(SIZE_Y);
      
    }
    // Locking Y to 0 or max. Then picking a random number for the X-axis
    else {
      startX = ran.nextInt(SIZE_X);
      startY = (posLock == 2)? 0 : SIZE_Y;
    }
		

		//creating array of rooms in the building
		rooms = new ArrayList<Room>();
		
		//creating rooms
		for (int i=0; i<SIZE_X; i++) {
			for (int j=0; j<SIZE_Y; j++) {
        Room r = new Room(i,j);
				rooms.add(r);
        if (i == startX && y == startY) startingRoom = r;
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
