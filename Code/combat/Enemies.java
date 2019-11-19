package combat;

import java.util.Random;

/**
 * @author: Alexander
 */
public class Enemies {

  Random rand = new Random();

  String[] enemies = {"Ghoul","Zombie","Raider","Monster","Acid Goo","Monster Rat","Sewage Tentacle","Death Mold","Political extremists","Religious extremists","Icywind","Raiderboss","Zombieboss","Madcow","Supermutant","Deathclaw","Boneking"}; 

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public String generateEnemy () {

    String enemy = enemies[rand.nextInt (enemies.length) ];

    return enemy;
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public int setEnemyHealth (String enemy) {

    Random randomHealth = new Random();

    int maxEnemyHealth = 1;

    int maxGhoulHealth = 10;
    int maxZombieHealth = 15;
    int maxRaiderHealth = 15;
    int maxMonsterHealth = 20;
    int maxAcidGooHealth = 20;
    int maxMonsterRatHealth = 20;
    int maxSewageTentacleHealth = 25;
    int maxDeathmoldHealth = 25;
    int maxPoliticalextremistsHealth = 30;
    int maxReligiousextremistsHealth = 30;
    int maxIcywindHealth = 1;
    int maxRaiderbossHealth = 40;
    int maxZombiebossHealth = 40;
    int maxMadcowHealth = 50;
    int maxSupermutantHealth = 60;
    int maxDeathclawHealth = 75;
    int maxBonekingHealth = 100;

    if(enemy.contains("Ghoul")){
      maxEnemyHealth = randomHealth.nextInt(maxGhoulHealth);
    } 
    else if (enemy.contains("Zombie")) {
      maxEnemyHealth = randomHealth.nextInt(maxZombieHealth);
    } 
    else if (enemy.contains("Raider")) {
      maxEnemyHealth = randomHealth.nextInt(maxRaiderHealth);
    } 
    else if (enemy.contains("Monster")) {
      maxEnemyHealth = randomHealth.nextInt(maxMonsterHealth);
    }
    else if(enemy.contains("AcidGoo")) {
      maxEnemyHealth = randomHealth.nextInt(maxAcidGooHealth);
    }
    else if(enemy.contains("MonsterRat")) {
      maxEnemyHealth = randomHealth.nextInt(maxMonsterRatHealth);
    }
    else if(enemy.contains("SewageTentacle")) {
      maxEnemyHealth = randomHealth.nextInt(maxSewageTentacleHealth);
    }
    else if(enemy.contains("DeathMold")) {
      maxEnemyHealth = randomHealth.nextInt(maxDeathmoldHealth);
    }
    else if(enemy.contains("Politcalextremists")) {
      maxEnemyHealth = randomHealth.nextInt(maxPoliticalextremistsHealth);
    }
    else if(enemy.contains("Religiousextremists")) {
      maxEnemyHealth = randomHealth.nextInt(maxReligiousextremistsHealth);
    }
    else if(enemy.contains("Icywind")) {
      maxEnemyHealth = randomHealth.nextInt(maxIcywindHealth);
    }
    else if(enemy.contains("Raiderboss")) {
      maxEnemyHealth = randomHealth.nextInt(maxRaiderbossHealth);
    }
    else if(enemy.contains("Zombieboss")) {
      maxEnemyHealth = randomHealth.nextInt(maxZombiebossHealth);
    }
    else if(enemy.contains("Madcow")) {
      maxEnemyHealth = randomHealth.nextInt(maxMadcowHealth);
    }
    else if(enemy.contains("Supermutant")) {
      maxEnemyHealth = randomHealth.nextInt(maxSupermutantHealth);
    }
    else if(enemy.contains("Deathclaw")) {
      maxEnemyHealth = randomHealth.nextInt(maxDeathclawHealth);
    }
    else if(enemy.contains("Boneking")) {
      maxEnemyHealth = randomHealth.nextInt(maxBonekingHealth) + 60; // Between 59-159 HP, shouldn't be too easy
    }     

    if(maxEnemyHealth == 0) {
      maxEnemyHealth = 1;
    }
    return maxEnemyHealth;
  }
}
