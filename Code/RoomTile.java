import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @param  name desc
 * @param  name desc
 * @return      desc
 */
public class RoomTile {
  boolean light;
  ArrayList<Item> items;
  GameObject gameObject;
  Person[] persons; 
  // Maybe these are mutually exclusive, so it would be better with a RoomObject class that they extend, and then a RoomTile can contain one RoomObject? RoomObject can also be Drawer or some such, that can contain Items?
  boolean window;
  boolean wall;
  
}

