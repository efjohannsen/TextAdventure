        //Mangler en clear-screen funktion (blandt mange andre ting, lol)
        //Mangler implementering af NPC og player (Kan evt udelades) 
        //Mangler en metode til, at give fejl når der vælges andet end de givne muligheder
        
        
import static statics.StaticLib.*;
import java.util.Scanner; 
import java.io.IOException;
import java.io.File; 


public class StartBase
{
 
   private final String DESCRIPTION; 
   private final String DIALOUGE; 
   private final String NPC;  
   public static boolean end = false; 
   public static boolean introTextSeen = false; 
   File NPCDIAL          = new File("Res/Lang/EN/Dialogue/NPCs_Dialogue.txt");
   File QUESTDESC        = new File("Res/Lang/EN/Dialogue/QuestDescription.txt");
   File PLAYERDIAL       = new File("Res/Lang/EN/Dialogue/PLAYER_Dialogue.txt");
   File NPCDESC          = new File("Res/Lang/EN/Dialogue/NPC_Description.txt"); 
   
   //evt inds�t NPC navne her
   
   public StartBase(String DESCRIPTION, String DIALOUGE, String NPC)
   {
   
      this.DESCRIPTION   = DESCRIPTION; 
      this.DIALOUGE      = DIALOUGE; 
      this.NPC           = NPC;        //Importer fra NPC klasse - Kald på constructor derfra 
      
      intro();   
      menu(); 
   }
   
   public void intro() {
      if (!introTextSeen) {        
         System.out.println(dialogue(NPCDESC, 1)); 
         System.out.println();
         System.out.println(dialogue(NPCDESC, 2));  
         System.out.println(dialogue(NPCDESC, 3)); 
         System.out.println(dialogue(NPCDESC, 4)); 
         System.out.println(dialogue(NPCDESC, 5)); 
         System.out.println(dialogue(NPCDESC, 6)); 
         System.out.println(dialogue(NPCDESC, 7)); 
         System.out.println(dialogue(NPCDESC, 8)); 
         System.out.println(dialogue(NPCDESC, 9)); 
         System.out.println(dialogue(NPCDESC, 10)); 
         System.out.println(dialogue(NPCDESC, 11)); 
         System.out.println();
         introTextSeen = true;
      }
   }
   
   public void menu()
   {
      Scanner sc = new Scanner(System.in);
     
      while (!end) 
      {
        // System.out.println("Description..."); //Evt indlæs txt med Description (indeholder intro til startbase) 
         System.out.println("Press '1' to interact with The Priestess"); //Beskrivelsen ændres selvfølgelig 
         System.out.println("Press '2' to interact with The Sergant");
         System.out.println("Press '3' to interact with The Junker");
         System.out.println("Press '4' to interact with The Doc");
         System.out.println("Press '5' to interact with The Scout");
         System.out.println("Press '6' to interact with The Mayor");
         System.out.println("Press '7' to interact with The Scientist");
         System.out.println("Press '8' to interact with The Wounded Soldier");
         System.out.println(); 
         System.out.println("Press '9' to return to the MainBase"); 
 
         int choice = sc.nextInt(); 
        
         clearScreen();   
         switch (choice)
         {            
            case 1:  
             thePriestess(); 
            break;    
            
            case 2:  
             theSergant(); 
            break; 
            
            case 3:   
             theJunker();
            break; 
            
            case 4:  
             theDoc();    
            break; 
            
            case 5:    
             theScout();  
            break; 
            
            case 6:
             theMayor();  
            break; 
            
            case 7:           
             theScientist();
            break; 
            
            case 8: 
             theWoundedSoldier();
             break; 
            
            case 9:
             System.out.println("You are now back in the StartBase");
             end = true; 
            break; 
         }
  
      }
   
   }
      
   public void thePriestess() {
      //dialogue(PLAYERDIAL, 1);
      System.out.println(dialogue(NPCDESC, 13));
      System.out.println(); 
     
     // System.out.println(dialogue(NPCDIAL, 2)); 
      
   }
   
   public void theSergant() {
      System.out.println(dialogue(NPCDESC, 14));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 6));
      //System.out.println(dialogue(NPCDIAL, 7));
   }
   
   public void theJunker() {
      System.out.println(dialogue(NPCDESC, 15));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 1));
   }
   
   
   public void theDoc() {
      System.out.println(dialogue(NPCDESC, 16));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 1)); 
   }
   
   
   public void theScout() {
      System.out.println(dialogue(NPCDESC, 17));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 8));
   }
   
   public void theMayor() {
      System.out.println(dialogue(NPCDESC, 18));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 1)); 
   }
   
   public void theScientist() {
      System.out.println(dialogue(NPCDESC, 19));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 1));
      
   }
   
   public void theWoundedSoldier() {
      System.out.println(dialogue(NPCDESC, 20));
      System.out.println(); 
      
      //System.out.println(dialogue(NPCDIAL, 1)); 
   }   
   
   //Metode som 'burde' læse fra Dialogue.txt filen
   public String dialogue(File file, int line)
   {
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
         System.out.println(e);
      }    
      return "";
   }
  
 }




