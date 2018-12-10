package combat;

import java.util.Random;

/**
  * @author: Alexander
  */
public class Weapons {
   
   Random rand = new Random();
   
   //percent chances 
   
  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int daggerAttack () {
    int daggerDamage = 10;
    Random randDagger = new Random(); 
    return randDagger.nextInt(daggerDamage);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int pistolAttack () {
    int pistolDamage = 20;
    Random randPistol = new Random();
    return randPistol.nextInt(pistolDamage);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int shotgunAttack () {
    int shotgunDamage = 30;
    Random randShotgun = new Random();
    return randShotgun.nextInt(shotgunDamage);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int riffleAttack () {
    int riffleDamage = 30;
    Random randRiffle = new Random();
    return randRiffle.nextInt(riffleDamage);
  } 

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int automaticgunAttack () {
    int automaticgunDamage = 40;
    Random randAutomaticGun = new Random();
    return randAutomaticGun.nextInt(automaticgunDamage);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int sledgehammerAttack () {
    int sledgehammerDamage = 20;
    Random randSledgehammer = new Random();
    return randSledgehammer.nextInt(sledgehammerDamage);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int crowbarAttack () {
    int crowbarDamage = 20;
    Random randCrowbar = new Random();
    return randCrowbar.nextInt(crowbarDamage);
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public int chainsawAttack () {
    int chainsawDamage = 30;
    Random randChainsaw = new Random();
    return randChainsaw.nextInt(chainsawDamage);
  }
}

//hit and ammo?
