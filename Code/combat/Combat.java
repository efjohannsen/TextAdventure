package combat;

import java.util.Random;
import java.util.Scanner;

/**
  * @author: Alexander
  */
public class Combat {

   //System objects
   private Enemies enemies = new Enemies();
   private Scanner in = new Scanner(System.in);
   private Random rand = new Random();

   // Return values depending on the outcome of the combat
   public static int ERROR = -1;
   public static int NPC_DEAD = 0;
   public static int PLAYER_DEAD = 1;
   public static int BONEKING_DEFEATED = 2;

   /**
     *
     * @param  name desc
     * @param  name desc
     * @return      desc
     */
   public int combat() {
     
     enemyAttackDamage enemyAttackDamageGenerator = new enemyAttackDamage();
     
     int maxEnemyHealth;
     int enemyAttackDamage;
     
     //Player variables
     int health = 100;
     int attackDamage = 50;
     int numHealthPotions = 3; 
     int healthPotionHealAmount = 30;
     int healthPotionDropChance = 50; //Percentage
     
     boolean running = true;
     
     System.out.println ("Welcome to the Wasteland!");
     
     GAME:
     while(running) {
       System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
       
       String enemy = enemies.generateEnemy();
       maxEnemyHealth = enemies.setEnemyHealth(enemy); 
             
       System.out.println("\t# " + enemy + " appeared! #\n");
       // # Enemy has appeared #
       
       while(maxEnemyHealth > 0) {
         System.out.println("\tYour HP: " + health);
         System.out.println("\t" + enemy + "'s HP:" + maxEnemyHealth);
         System.out.println("\n\tWHat would you like to do?");
         System.out.println("\t1. Attack with dagger");
         System.out.println("\t2. Attack with pistol");
         System.out.println("\t3. Attack with shotgun");
         System.out.println("\t4. Attack with riffle");
         System.out.println("\t5. Attack with automaticgun");
         System.out.println("\t6. Attack with sledgehammer");
         System.out.println("\t7. Attack with crowbar");
         System.out.println("\t8. Attack with chainsaw");
         System.out.println("\t9. Drink health potion");
         System.out.println("\t10. Run!");
         Weapons arsenal = new Weapons();
         String input = in.nextLine();
         if(input.equals("1")) {
         
            
            
            int damageDealt = arsenal.daggerAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               return PLAYER_DEAD;
            }
         }
            else if(input.equals("2")) { 
            int damageDealt = arsenal.pistolAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You shoot the" + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }
         else if(input.equals("3")) { 
            int damageDealt = arsenal.shotgunAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You shoot the" + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }else if(input.equals("4")) { 
            int damageDealt = arsenal.riffleAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You shoot the" + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }else if(input.equals("5")) { 
          
            int damageDealt = arsenal.automaticgunAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You shoot the" + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }else if(input.equals("6")) { 
            int damageDealt = arsenal.sledgehammerAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }else if(input.equals("7")) { 
            int damageDealt = arsenal.crowbarAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }
          else if(input.equals("8")) { 
            int damageDealt = arsenal.chainsawAttack();  // rand.nextInt(attackDamage);
            int damageTaken = enemyAttackDamageGenerator.setEnemyAttackDamage(enemy);
            
            maxEnemyHealth -= damageDealt;
            health -= damageTaken;         
            
            
            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + "damage.");
            System.out.println("\t> You receive " + damageTaken + " in retaliation!");
     
           
            
            if(health < 1) {
               System.out.println("\t> You have taken too much damage, you are too weak to go on!");
               break; 
               }
          }
         
         
         
         
         
         
         else if(input.equals("9")) {
               if (numHealthPotions > 0) {
                  health += healthPotionHealAmount;
                  numHealthPotions--;
                  System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + " . "
                                             + "\n\t> You now have " + health + " HP."
                                             + "\n\t> You have " + numHealthPotions + " health potions left.\n"); 
               }
               else{
                  System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
               }
         
            }
            else if(input.equals("10"))  {
               System.out.println("\tYou ran away from the " + enemy + "!");
               continue GAME;
         
            }
             else {
               System.out.println("\tInvalid command!");        
            }
         
     
            }
       
            if(health < 1){
               System.out.println("You limp away, weak from battle.");
               break;
       
            } 
     
            // Exit battle immediately and win the game if the boneking was defeated:
            if ( enemy.equals("Boneking") ) return BONEKING_DEFEATED;

            // ...otherwise ask if the player wants to continue battling
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + "HP left. #");
            if (rand.nextInt(100) < healthPotionDropChance){
               numHealthPotions++;
               System.out.println(" # The " + enemy + " dropped a health potion! # ");
               System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
     
     
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit Combat");
            
            String input = in.nextLine();
     
            while(!input.equals("1") && !input.equals("2")) {
               System.out.println("Invalid command!");
               input = in.nextLine();
       
            }
     
            if(input.equals("1")) {
               System.out.println("You continue on your adventure!");
            }
            else if(input.equals("2")) {
               System.out.println("You exit the Combat, successful from your adventures!");
               return NPC_DEAD;
            }
     
         }

         System.out.println("#######################");
         System.out.println("##### COMBAT ENDED!####");
         System.out.println("#######################");

         return ERROR;

      }
}
