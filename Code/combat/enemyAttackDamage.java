package combat;

import java.util.Random;

/**
 * @author: Alexander
 */
public class enemyAttackDamage {

  public int setEnemyAttackDamage (String enemy) {

    Random rand = new Random();

    int EnemyAttackDamage = 1;

    int GhoulAttackDamage = 2;
    int ZombieAttackDamage = 5;
    int RaiderAttackDamage = 8;
    int MonsterAttackDamage = 11;
    int AcidGooAttackDamage = 14;
    int MonsterRatAttackDamage = 10;
    int SewageTentacleAttackDamage = 15;
    int DeathmoldAttackDamage = 19;
    int PoliticalextremistsAttackDamage = 22;
    int ReligiousextremistsAttackDamage = 22;
    int IcywindAttackDamage = 10;
    int RaiderbossAttackDamage = 15;
    int ZombiebossAttackDamage = 15;
    int MadcowAttackDamage = 25;
    int SupermutantAttackDamage = 28;
    int DeathclawAttackDamage = 35;
    int BonekingAttackDamage = 45;

    if(enemy.contains("Ghoul")){
      EnemyAttackDamage = rand.nextInt(GhoulAttackDamage);
    } 
    else if (enemy.contains("Zombie")) {
      EnemyAttackDamage = rand.nextInt(ZombieAttackDamage);
    } 
    else if (enemy.contains("Raider")) {
      EnemyAttackDamage = rand.nextInt(RaiderAttackDamage);
    } 
    else if (enemy.contains("Monster")) {
      EnemyAttackDamage = rand.nextInt(MonsterAttackDamage);
    }
    else if(enemy.contains("AcidGoo")) {
      EnemyAttackDamage = rand.nextInt(AcidGooAttackDamage);
    }
    else if(enemy.contains("MonsterRat")) {
      EnemyAttackDamage = rand.nextInt(MonsterRatAttackDamage);
    }
    else if(enemy.contains("SewageTentacle")) {
      EnemyAttackDamage = rand.nextInt(SewageTentacleAttackDamage);
    }
    else if(enemy.contains("DeathMold")) {
      EnemyAttackDamage = rand.nextInt(DeathmoldAttackDamage);
    }
    else if(enemy.contains("Politcalextremists")) {
      EnemyAttackDamage = rand.nextInt(PoliticalextremistsAttackDamage);
    }
    else if(enemy.contains("Religiousextremists")) {
      EnemyAttackDamage = rand.nextInt(ReligiousextremistsAttackDamage);
    }
    else if(enemy.contains("Icywind")) {
      EnemyAttackDamage = rand.nextInt(IcywindAttackDamage);
    }
    else if(enemy.contains("Raiderboss")) {
      EnemyAttackDamage = rand.nextInt(RaiderbossAttackDamage);
    }
    else if(enemy.contains("Zombieboss")) {
      EnemyAttackDamage = rand.nextInt(ZombiebossAttackDamage);
    }
    else if(enemy.contains("Madcow")) {
      EnemyAttackDamage = rand.nextInt(MadcowAttackDamage);
    }
    else if(enemy.contains("Supermutant")) {
      EnemyAttackDamage = rand.nextInt(SupermutantAttackDamage);
    }
    else if(enemy.contains("Deathclaw")) {
      EnemyAttackDamage = rand.nextInt(DeathclawAttackDamage);
    }
    else if(enemy.contains("Boneking")) {
      EnemyAttackDamage = rand.nextInt(BonekingAttackDamage);
    } else {
      EnemyAttackDamage = 1;
    }     

    if(EnemyAttackDamage == 0){
      EnemyAttackDamage = 1;
    }

    return EnemyAttackDamage;
  }
}
