        //Mangler en clear-screen funktion (blandt mange andre ting, lol)
        //Mangler implementering af NPC og 

import java.util.Scanner; 
import java.io.IOException;
import java.io.File; 


public class StartBase  
{
 
   private final String DESCRIPTION; 
   private final String DIALOUGE; 
   private final String NPC;  
   public static boolean end = false; 
   
   private StartBase(String DESCRIPTION, String DIALOUGE, String NPC)
   {
   
      this.DESCRIPTION   = DESCRIPTION; 
      this.DIALOUGE      = DIALOUGE; 
      this.NPC           = NPC;        //Importer fra NPC klasse - Kald på constructor derfra 
   
   }
   
   //Main er bare en test
   public static void main(String[] args) 
   {
   
      menu(); 
   
   }
   
     
   /*
   public Player() 
   {
   
      //Kald på attributter (som name, stats osv) fra Player klassen. - Når den bliver lavet 
   
   }
   
   public void NPC() //Kald på NPC klassen - Når den bliver lavet 
   {
   
      NPC npc1 = new NPC();
      NPC npc2 = new NPC();
      NPC npc3 = new NPC();
      NPC npc4 = new NPC();
      NPC npc5 = new NPC();
      NPC npc6 = new NPC();
      NPC npc7 = new NPC();
      NPC npc8 = new NPC();
   
   }
   */
   
   
   public static void menu()
   {
     Scanner sc = new Scanner(System.in);
     

      while (!end) 
      {
         System.out.println("Description..."); //Evt indlæs txt med Description (indeholder intro til startbase) 
         System.out.println("Press '1' to interact with npc1"); //Beskrivelsen ændres selvfølgelig 
         System.out.println("Press '2' to interact with npc2");
         System.out.println("Press '3' to interact with npc3");
         System.out.println("Press '4' to interact with npc4");
         System.out.println("Press '5' to interact with npc5");
         System.out.println("Press '6' to interact with npc6");
         System.out.println("Press '7' to interact with npc7");
         System.out.println("Press '8' to interact with npc8");
         
 
         int choice = sc.nextInt();  
        
        //Evt importer NPC txt filer her? -Fører videre til muligheder osv pr NPC
               //Implementer dialog-menu 
        
         switch (choice)
         {
            case 1: choice = '1';
             System.out.println("You have chosen 'NPC1' -insert description and quest\n");
             break; 
             
            case 2: choice = '2'; 
             System.out.println("You have chosen 'NPC 2' -insert description and quest\n"); 
            break;    
            
            case 3: choice = '3'; 
             System.out.println("You have chosen 'NPC 3' -insert description and quest\n");
            break; 
            
            case 4: choice = '4';
             System.out.println("You have chosen 'NPC 4' -insert description and quest\n");
            break; 
            
            case 5: choice = '5'; 
             System.out.println("You have chosen 'NPC 5' -insert description and quest\n");   
            break; 
            
            case 6: choice = '6';
             System.out.println("You have chosen 'NPC 6' -insert description and quest\n");   
            break; 
            
            case 7: choice = '7'; 
             System.out.println("You have chosen 'NPC 7' -insert description and quest\n");   
            break; 
            
            case 8: choice = '8';             
             System.out.println("You have chosen 'NPC 8' -insert description and quest\n");
            break; 
         }
  
      }
   
   }
   //Description af startbase - bliver kaldt på fra Menu-metoden 
   public void description() 
      throws IOException
   {
   
     File file = new File("description.txt");
      Scanner sc = new Scanner(file);
         String word = sc.nextLine(); 
     
     System.out.print(word);
      
   }

}

