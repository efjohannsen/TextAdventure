public class Game {

  // Pick a language here.
  public static enum Language {EN, ES};
  public static Language lang = Language.EN;
  public static final String LANGPATH = "Res/Lang/" + lang + "/";
  public static final int SIZE = 21; // The length of one side/axis of the World

  /* MAP SYMBOLS: How the different objects are displayed on the map/printed out */

  //public static final char PLAYER   = '\u2b24';
  //public static final char NPC      			= '\u26f9';
  //public static final char BUILDING 			= '\u25a0';
  //public static final char WONDERLAND 		= '\u2b1b';
  public static final char WONDERLAND 		= 'W';
  public static final char ITEM    			  = '\u2b4d';
  public static final char EMPTY    			= '\u00b7';
  public static final char BONEKING       = '\u2020';
  //public static final char EASTER         = '\u1F47B';
  // The above characters are better but the symbols are apparently not part of the default font used in cmd in Windows, hence these replacements
  public static final char PLAYER         = 'X';
  public static final char NPC      			= '\u00a7';
  public static final char BUILDING 			= '\u25a0';
  public static final char IAMERROR 			= '?';


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
