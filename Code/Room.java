import static statics.StaticLib.*;
import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;

public class Room extends Point {
	
	private ArrayList<Item> items;
	private ArrayList<Person> persons;
	
	//room constructor
	public void Room(int x, int y) {
	
		super(x, y);
		
		//creating room size randomly, minimum size is 3x3
		Random ran = new Random();
		final int SIZE_X = Math.max(3,ran.nextInt(5)+1);
		final int SIZE_Y = Math.max(3,ran.nextInt(5)+1);

		//odds of generating item/npc
		final int ITEM_CHANCE = 10;
		final int NPC_CHANCE = 20;
		
		//populating room with items and NPCs
		for(int i = 0; i < SIZE_X; i++) {
			for(int j = 0; j < SIZE_Y; j++) {
				if(ran.nextInt(ITEM_CHANCE) == 0) {
					items.add(new Item(i,j));
				}
				else if(ran.nextInt(NPC_CHANCE) == 0) {
					persons.add(new Person(i,j));
				}
			}
		}
		
	}
	
	public String toString() {
	
		String txt = "";
	
		for(int i = 0; i < SIZE_X; i++) {
			for(int j = 0; j < SIZE_Y; j++) {
				txt += EMPTY + "   ";
			}
			txt += "\n";			
		}
	
		return txt;
	}
	
}