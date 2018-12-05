

import java.util.Scanner; 
import java.io.IOException;
import java.io.File; 


public class StartBase  
{
 
   private final String DESCRIPTION; 
   private final String DIALOUGE; 
   private final int NPC;  
   public boolean end = false; 
   
   private StartBase(String DESCRIPTION, String DIALOUGE, int NPC)
   {
   
      this.DESCRIPTION = DESCRIPTION; 
      this.DIALOUGE    = DIALOUGE; 
      this.NPC         = NPC;
   
   }
   
     
   /*
   public Player() 
   {
   
      //Kald på attributter (som name, stats osv) fra Player klassen. 
   
   }*/
   
   
   public void menu()
   {
     Scanner sc = new Scanner(System.in);
     

      while (!end) 
      {
         System.out.println("Menu..."); 
         System.out.println("Press '1' to Enter the game");
         System.out.println("Press '2' to quit the game"); 
         
         int choice = sc.nextInt();  
         
         //Ændres til switch
         switch (choice);
         {
            case 1: choice = 1;
               <statement>
               break;
            case 2: choice = 2; 
               <statement>
               break; 
            case 3: choice = 3; 
               <statement>
               break; 
            case 4: choice = 4;
               <statement>
               break; 
            case 5: choice = 5; 
               <statement>
               break; 
            case 6: choice = 6;
               <statement>
               break; 
            case 7: choice = 7; 
               <statement>
               break; 
            case 8: choice = 8; 
               <statement>
               break;
         }
 
  
      }
   
   }
   
   public void description() 
      throws IOException
   {
   
      //String DESCRIPTION = baseDescription; 
     // File file new File("description.csv");
      
   }
   
   //Kan m
   public void NPC() 
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

}

