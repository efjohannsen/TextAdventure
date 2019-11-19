//Importering af klasser 
import static statics.StaticLib.*;
import java.util.Scanner; 
import java.io.IOException;
import java.io.File; 


/**
 * @author Tariq
 */
public class StartBase {

  //Initialisering 
  private boolean end                               = false; 
  private static boolean introTextSeen              = false; 
  private final File NPCDESC                        = new File("Res/Lang/EN/Dialogue/NPC_Description.txt"); 
  private final File NPCDIAL                        = new File("Res/Lang/EN/Dialogue/NPCs_Dialogue.txt");
  private final File QUESTDESC                      = new File("Res/Lang/EN/Dialogue/QuestDescription.txt");
  private final File PLAYERDIAL                     = new File("Res/Lang/EN/Dialogue/PLAYER_Dialogue.txt");
  public static String name                         = "The building";
  private static World world;

  //metode StartBase: kalder paa intro-metode, menu-metode, clearscreen-metode.    
  public StartBase() {
    enter();   
  }

  //Metode som rydder terminal: 
  public void enter() {
    clearScreen();
    intro();
    menu();
    if (world == null) world = new World();
    new Command(world, this);
  }

  //intro-tekst: Metode der printer historien 1 gang. Kalder paa metoderne fra Dialog. 
  public void intro() {
    //Koerer 1 gang. 
    if (!introTextSeen) {        
      System.out.println(dialogue(NPCDESC, 1)); 
      System.out.println();
      System.out.println(dialogue(NPCDESC, 2));  
      System.out.println(dialogue(NPCDESC, 3)); 
      System.out.println(dialogue(NPCDESC, 4)); 
      System.out.println(dialogue(NPCDESC, 5)); 
      System.out.println(dialogue(NPCDESC, 6)); 
      System.out.println(dialogue(NPCDESC, 7)); 
      System.out.println(dialogue(NPCDESC, 9)); 
      System.out.println(dialogue(NPCDESC, 10)); 
      System.out.println(dialogue(NPCDESC, 11)); 
      System.out.println();
      introTextSeen = true;
    }
  }

  public void menu() {
    //skanner: tager input som parameter 
    Scanner sc = new Scanner(System.in);
    //while-loop: Koerer saa laenge end != true. 
    while (!end) {
      // Print af menu
      System.out.println("Press '1' to interact with The Priestess"); 
      System.out.println("Press '2' to interact with The AsgJar");
      System.out.println("Press '3' to interact with The Junker");
      System.out.println("Press '4' to interact with The Doc");
      System.out.println("Press '5' to interact with The Scout");
      System.out.println("Press '6' to interact with The Mayor");
      System.out.println("Press '7' to interact with The Scientist");
      System.out.println("Press '8' to interact with The Wounded Soldier");
      System.out.println(); 
      System.out.println("Press '9' to exit " + name); 

      //Kalder paa StaticLib-klassen - Afgoer om input er int og/eller String. 
      int choice = getNumericalInputRangeLoop(1, 9);
      //clearscreen-metode fra StaticLib-klassen
      clearScreen();   
      //Switch-metode: kalder paa char-metoderne. 
      switch (choice) {            
        case 1:  
          thePriestess(); break;    
        case 2:  
          theSergant(); break; 
        case 3:   
          theJunker(); break; 
        case 4:  
          theDoc();    break; 
        case 5:    
          theScout();  break; 
        case 6:
          theMayor();  break; 
        case 7:           
          theScientist(); break; 
        case 8: 
          theWoundedSoldier(); break; 
        case 9:
          System.out.println("Exited to the New World wilderness");
          end = true; break; 
      }
    }
  }
  //Creating the NPC's (8/8) in their own seperate methods 

  public void thePriestess() {
    System.out.println(dialogue(NPCDESC, 12));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 1));
    System.out.println(dialogue(NPCDIAL, 2));
    System.out.println(dialogue(NPCDIAL, 3));
    System.out.println();
    //Boolean - bruges til at holde while-loop koerende 
    boolean npcTalk = false; 
    //while-loop: Koerer saa laenge 'npcTalk' != true
    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 2));
      System.out.println("2: " + dialogue(PLAYERDIAL, 5));
      System.out.println("3: " + dialogue(PLAYERDIAL, 6) + "\n");
      System.out.println("Press '4' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 4);
      //if-else metoder: Tager brugerens input og returnerer NPCDIAL (Kalder paa metoden 'dialogue'. 
      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 4)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 5)); 
      }
      else if (choice == 3) {
        System.out.println(dialogue(NPCDIAL, 2)); 
      }
      //Vender tilbage til char-menu 
      else if (choice == 4) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theSergant() {
    System.out.println(dialogue(NPCDESC, 13));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 8));
    System.out.println(dialogue(NPCDIAL, 9));
    System.out.println(dialogue(NPCDIAL, 10));
    System.out.println();

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 7));
      System.out.println("2: " + dialogue(PLAYERDIAL, 8));
      System.out.println("3: " + dialogue(PLAYERDIAL, 9));
      System.out.println("4: " + dialogue(PLAYERDIAL, 12) + "\n");
      System.out.println("Press '5' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 5);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 12)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 11)); 
      }
      else if (choice == 3) {
        System.out.println(dialogue(NPCDIAL, 13)); 
      }
      else if (choice == 4) {
        System.out.println(dialogue(NPCDIAL, 16)); 
      }
      else if (choice == 5) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theJunker() {
    System.out.println(dialogue(NPCDESC, 14));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 18));
    System.out.println(dialogue(NPCDIAL, 19));
    System.out.println(); 

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 13));
      System.out.println("2: " + dialogue(PLAYERDIAL, 14));
      System.out.println("3: " + dialogue(PLAYERDIAL, 15));
      System.out.println("4: " + dialogue(PLAYERDIAL, 16) + "\n");
      System.out.println("Press '5' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 5);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 21)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 22)); 
      }
      else if (choice == 3) {
        System.out.println(dialogue(NPCDIAL, 23)); 
      }
      else if (choice == 4) {
        System.out.println(dialogue(NPCDIAL, 19)); 
      }
      else if (choice == 5) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theDoc() {
    System.out.println(dialogue(NPCDESC, 15));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 25));
    System.out.println(dialogue(NPCDIAL, 26));
    System.out.println();

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 17));
      System.out.println("2: " + dialogue(PLAYERDIAL, 18));
      System.out.println("3: " + dialogue(PLAYERDIAL, 20) + "\n");
      System.out.println("Press '4' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 4);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 28)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 30)); 
      }
      else if (choice == 3) {
        System.out.println(dialogue(NPCDIAL, 26)); 
      }
      else if (choice == 4) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theScout() {
    System.out.println(dialogue(NPCDESC, 16));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 33));
    System.out.println(dialogue(NPCDIAL, 34));
    System.out.println(dialogue(NPCDIAL, 35));
    System.out.println();

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 24));
      System.out.println("2: " + dialogue(PLAYERDIAL, 22));
      System.out.println("3: " + dialogue(PLAYERDIAL, 23));
      System.out.println("4: " + dialogue(PLAYERDIAL, 25) + "\n");
      System.out.println("Press '5' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 5);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 39)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 37)); 
      }
      else if (choice == 3) {
        System.out.println(dialogue(NPCDIAL, 38)); 
      }
      else if (choice == 4) {
        System.out.println(dialogue(NPCDIAL, 40)); 
      }
      else if (choice == 5) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theMayor() {
    System.out.println(dialogue(NPCDESC, 17));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 43));
    System.out.println(dialogue(NPCDIAL, 44));
    System.out.println(dialogue(NPCDIAL, 45));
    name = "Wonderland";
    System.out.println(); 

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 26));
      System.out.println("2: " + dialogue(PLAYERDIAL, 27) + "\n");
      System.out.println("Press '3' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 3);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 48)); 
      }

      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 45)); 
      }
      else if (choice == 3) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theScientist() {
    System.out.println(dialogue(NPCDESC, 18));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 50));
    System.out.println(dialogue(NPCDIAL, 51));
    System.out.println(dialogue(NPCDIAL, 52));
    System.out.println();

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 31));
      System.out.println("2: " + dialogue(PLAYERDIAL, 30));
      System.out.println("3: " + dialogue(PLAYERDIAL, 25) + "\n");
      System.out.println("Press '4' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 4);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 55)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 56)); 
      }
      else if (choice == 3) {
        System.out.println(dialogue(NPCDIAL, 52)); 
      }
      else if (choice == 4) {
        npcTalk = true; 
      }
    }
  }

  // -||-
  public void theWoundedSoldier() {
    System.out.println(dialogue(NPCDESC, 19));
    System.out.println(); 
    System.out.println(dialogue(NPCDIAL, 59));
    System.out.println(dialogue(NPCDIAL, 60));
    System.out.println(dialogue(NPCDIAL, 61));
    System.out.println(); 

    boolean npcTalk = false; 

    while(!npcTalk) {
      System.out.println();
      System.out.println("1: " + dialogue(PLAYERDIAL, 32));
      System.out.println("2: " + dialogue(PLAYERDIAL, 33) + "\n");
      System.out.println("Press '3' to go back");  
      System.out.println(); 

      int choice = getNumericalInputRangeLoop(1, 3);

      if (choice == 1) {
        System.out.println(dialogue(NPCDIAL, 61)); 
      }
      else if (choice == 2) {
        System.out.println(dialogue(NPCDIAL, 62)); 
      }
      else if (choice == 3) {
        npcTalk = true; 
      }
    }
  }   

  //metode som laeser txt.filerne. Tager 'fil' og 'int' som parameter 
  public String dialogue(File file, int line) {    
    try {      
      Scanner sc = new Scanner(file);
      int i = 1; 

      while(sc.hasNextLine()) {
        if (i == line) {
          return sc.nextLine(); 
        } 
        sc.nextLine(); 
        i++;
      } 
    }
    catch (IOException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Dialogue method's IO failed. Does the requested file not exist?");
    }    
    throw new IllegalArgumentException("Dialogue method's couldn't find the requested line. Is it higher than the total number of lines in the file?");
  }
}
