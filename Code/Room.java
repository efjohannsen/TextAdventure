import static statics.StaticLib.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * @author Esben
 */
public class Room extends Area {
	
	//declaring array lists
	private ArrayList<Item> items;
	private ArrayList<Person> persons;
	
	private Random ran = new Random();

	//room constructor
	public Room(int x, int y) {
	
    //creating room size randomly, minimum size is 3x3
		super(x, y);
		
		items = new ArrayList<Item>();
		persons = new ArrayList<Person>();
		
		//odds of generating item/npc
		final int ITEM_CHANCE = 10;
		final int NPC_CHANCE = 20;
		
		//populating room with items and NPCs
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(ran.nextInt(ITEM_CHANCE) == 0) {
					items.add(new Item(i,j));
				}
				else if(ran.nextInt(NPC_CHANCE) == 0) {
					persons.add(new Person(i,j,new ArrayList<Item>()));
				}
			}
		}
		
		//System.out.println(this);
		
	}
	
	public String toString() {
	
		//fills temp array with 'empty', items and persons symbols
		String[] temp = new String[SIZE * SIZE];
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = Game.EMPTY + "   ";
		}
		for(Item t: items) {
			temp[ (int)(t.getX() + SIZE * t.getY()) ] = Game.ITEM + "   ";
		}
		for(Person p: persons) {
			temp[ (int)(p.getX() + SIZE * p.getY()) ] = Game.NPC + "   ";
		}
		
		//creating final text string with linebreaks
		String txt = "";
		
		for(int i = 0; i < temp.length; i++) {
			txt += temp[i];
			if(((i+1) % SIZE) == 0) {
				txt += "\n";
			}
		}
		
		return txt;
	}
	
}
