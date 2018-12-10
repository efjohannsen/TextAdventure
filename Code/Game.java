/**
 * @author Marcus
 */
public class Game {
  // Pick a language here.
  public static enum Language {EN, ES};
  public static Language lang = Language.EN;
  public static final String LANGPATH = "Res/Lang/" + lang + "/";
  public static final int SIZE = 21; // The length of one side/axis of the World

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public static void main(String[] args) {
    new GameMenu(); 
  }
}
