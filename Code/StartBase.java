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
   
   public StartBase(String DESCRIPTION, String DIALOUGE, String NPC)
   {
   
      this.DESCRIPTION   = DESCRIPTION; 
      this.DIALOUGE      = DIALOUGE; 
      this.NPC           = NPC;        //Importer fra NPC klasse - Kald på constructor derfra 
   
      readDesc();
      menu(); 
   }
   

   
   public static void menu()
   {
     Scanner sc = new Scanner(System.in);
     

      while (!end) 
      {
        // System.out.println("Description..."); //Evt indlæs txt med Description (indeholder intro til startbase) 
         System.out.println("Press '1' to interact with npc1"); //Beskrivelsen ændres selvfølgelig 
         System.out.println("Press '2' to interact with npc2");
         System.out.println("Press '3' to interact with npc3");
         System.out.println("Press '4' to interact with npc4");
         System.out.println("Press '5' to interact with npc5");
         System.out.println("Press '6' to interact with npc6");
         System.out.println("Press '7' to interact with npc7");
         System.out.println("Press '8' to interact with npc8");
 
         int choice = sc.nextInt();  
         //int option = sc.nextInt(); //Evt. lav en anden skanner? 
        
        //Evt importer NPC txt filer her? -Fører videre til muligheder osv pr NPC
               //Implementer dialog-menu 
        
         
         switch (choice)
         {
            case 1: 
             System.out.println("You have chosen 'NPC1' -insert description and quest\n");
            // String word = sc.nextLine(); 
            // readDialogue(word2); 
            
            // System.out.print("Do you want to interact with this NPC. y/n?");   
             break; 
             
             
            case 2:
             System.out.println("You have chosen 'NPC 2' -insert description and quest\n");    
            break;    
            
            case 3: 
             System.out.println("You have chosen 'NPC 3' -insert description and quest\n");
            break; 
            
            case 4:
             System.out.println("You have chosen 'NPC 4' -insert description and quest\n");
            break; 
            
            case 5:
             System.out.println("You have chosen 'NPC 5' -insert description and quest\n");   
            break; 
            
            case 6:
             System.out.println("You have chosen 'NPC 6' -insert description and quest\n");   
            break; 
            
            case 7:
             System.out.println("You have chosen 'NPC 7' -insert description and quest\n");   
            break; 
            
            case 8:           
             System.out.println("You have chosen 'NPC 8' -insert description and quest\n");
            break; 
            
            case 9:
             System.out.println("You are now back in the StartBase");
             end = true; 
            break; 
         }
  
      }
   
   }
      
   public static void thePriestess() {
      readDialogue(); 
   }
   
   public static void theSergant() {
      readDialogue(); 
   }
   
   public static void theJunker() {
      readDialogue();
   }
   
   
   public static void theDoc() {
      readDialogue(); 
   }
   
   
   public static void theScout() {
      readDialogue(); 
   }
   
   public static void theMayor() {
      readDialogue(); 
   }
   
   public static void theScientist() {
      readDialogue(); 
   }
   
   public static void theWoundedSoldier() {
      readDialogue(); 
   }   
   
   
   
   
   //metode som 'burde' læse fra Description.txt filen 
   public static void readDesc() {
      try {
          File file = new File("test.txt");     
          Scanner sc = new Scanner(file);
          String word = sc.nextLine(); 
          System.out.print(word);
      }  
      catch (IOException e){
         System.out.println(e); 
      }
   }
   //Metode som 'burde' læse fra Dialogue.txt filen
   public static void readDialogue()
   {
      try {
          File file = new File("test.txt"); 
          Scanner sc = new Scanner(file);
          String word = sc.nextLine(); 
          System.out.print(word); 
      }
      catch (IOException e) {
         System.out.println(e);
      }    
   }

}

