import java.util.Scanner;

public class Player {
	int health;
    int healthSlot;
	int sword;
	int xp = 1;
	int mobHitPoint;
	int defend;
	int Block;
	int M;
	int T = 1;
	int gold;
	int healthPot = 1;
	boolean inShop = false;
	int Kills;
	int S;
	int R;
	String name;
	boolean fireSword = false;
	int swordUp = 2;
	boolean superSheald = false;
	int mobSpearDis;
	int shopTpPotoins;
	int stunPotion = 3;
	int swordPt;
	int magicPt;
	int magic;
	boolean tome = false;
	int icePot;
Player(){
    Scanner Shop = new Scanner(System.in);
	healthSlot = 6;	
    health = healthSlot;
    sword = xp * swordUp - xp/2 + 1;
    System.out.println("made player, stats are");
    System.out.println("xp is " + xp);
    System.out.println("health is " + health);
    System.out.println("sword is " + sword);
    System.out.println("healthSlot is " + healthSlot);
    System.out.println("What is your name");
    name = Shop.nextLine();
	}
	void heal(int H,char B){
		health = health + H;
		if(healthSlot < health){
			health = healthSlot;	
		}
		if (B == 'H'){
			System.out.println("You healed for " + H + " hit points now you have " + health + " hit points " + " out of " + healthSlot + " hit points ");
			
		}else if (B == 'P'){
			System.out.println("You drink your potion and heal for " + H + " hit points now you have " + health + " hit points " + " out of " + healthSlot + " hit points ");
			healthPot = healthPot - 1;
		}
		
	}
	void Damage (int D,Mob Mob,Player P,int T){
	
	if(Block != 0 && T == 1){
			System.out.println("you Block the enemys attack and negate some damage");	
			R = (D + 2) - Block;
			Mob.Damage(Block/2,P,Mob,'B' );
		}else if (Block != 0 && T == 2 && !superSheald){
			System.out.println("since the mob used a spear your block did nothing");
			R = (D + 1);  
		}else if (Block == 0 && T == 2){
			System.out.println("the mob attacked you whith a spear");	
			R = (D + 1);
		}else if (Block != 0 && T == 2 && superSheald){
			mobSpearDis = sword/3;
			System.out.println("The mob trys to attack ou whith its" 
			+ " spear but it bounces of your Super Sheald");
			System.out.println("from this the mob accidentally hits himself for "
					+ mobSpearDis + " damage");
			System.out.println("you still take a bit of damage from the attack");
			R = D/2;
			Mob.Damage(mobSpearDis,P,Mob,' ');
		}else if(Block == 0 && T == 1){
			System.out.println("The mob just normaly attacks you");
			R = (D + 2);
		}	
	health = health - R;
	System.out.println("Your health is now " + health + " hit points out of " + healthSlot + " hit points after takeing " + R + " hitpoints of damage");
		
	if(health <= 0){
		System.out.print("R.I.P here lies the grate adventurer ");
		System.out.print(name);
		System.out.println(" who died on a grand adventure whith a score of " + Kills);
		System.exit(0);
	}
	Block = 0;
	}
     void attack(Mob Mob,Player P,char T){
    	 if(T == 'S'){
    		 mobHitPoint = sword;
		
    	 }else if (T == 'M'){
    		 mobHitPoint = magic * 3/2;
		}
		Mob.Damage(mobHitPoint,P,Mob,'N');
	}
     
 void loot(Player P, Mob Mob){
   System.out.println("Cool you killed the mob your hit points have been replenished");
   xp = xp + 1;
   Kills = Kills + 1;
   System.out.println("Your xp is now " + xp);
   healthSlot = xp * 2 + 6;
   P.heal(healthSlot - health, 'H');
   
  if( Math.random()  > .5){
	  gold = gold + 3 * Mob.getLevel();
	  System.out.println("You have found "+ 2 * Mob.getLevel() +" Gold!! you now have " + gold + " Gold");
	  
  }
    
     }
 void Block(Player P){
    	Block = xp + 2;
    	
    }
  int Get(char in){
    if(in == 'X'){
    	M = Kills;   
    }else if (in == 'M'){
    	M = 3 * T;
    	
    }else if (in == 'P'){
    M = healthPot;	
    	
    }else if (in == 'H'){
    M = healthSlot;	
    	
    }else if (in == 'T'){
    M = shopTpPotoins;
    
    }else if (in == 'S'){
    M =	stunPotion;
   
    }
	return M; 	
    	
    }
void Shop(Player P){
    	inShop = true;
    	System.out.println("Hello welcome to the shop ");
        System.out.println("These shops are located in between every room ");
    	while(inShop){
    	System.out.println("You have " + gold + " gold Type number to buy or Leave");
    	System.out.println("1.) Leave");
    	System.out.println("2.) Heath potions : " + P.Get('P')+"(restors health by half) price 5 gold");
    	System.out.print("3.) Fire Sword (A better sword) price 1,000 gold");
    	if(fireSword){
    		System.out.println(" (out of stock)");
    	}else{
    		System.out.println("");
    	}
    	System.out.print("4.) Super Sheald (Spears cant hit you) price 1,500 gold");
    	if(superSheald){
    		System.out.println(" (out of stock)");
    	}else{
    		System.out.println("");
    	}
    	System.out.print("5.) Magic tome price 50 ");
    	if(!tome){
    		System.out.println("");
    	}else{
    		System.out.println("(out of stock)");
    	}
    	System.out.println("6.) Magic upgrade : " + magicPt + " price 5");
    	System.out.println("7.) Sword damage upgrade : " + swordPt +" price 5");
    	System.out.println("8.) Shop Tp Potions : " + shopTpPotoins + " price 5 gold");
    	System.out.println("9.) Stun Potions : " + stunPotion + " price 20 gold");
            Scanner Shop = new Scanner(System.in);
            S = Shop.nextInt();
    	if(S == 1){
    		inShop = false;
    		}else if(S == 2 && gold >= 5){
    			gold = gold - 5;
    			healthPot = healthPot + 1;
    			System.out.println("You have perchased a health potion");
    			System.out.println("You now have " + healthPot + " health potion(s)");
    		}else if (S == 2){
    			System.out.println("You do not have the gold to buy this item");	
    		}else if (S == 3 && gold >= 1000 && !fireSword){
    			 System.out.println("You have perchased the Fire Sword");
    			 fireSword = true;
    			 gold = gold - 1000;
    			 swordUp = swordUp + 1;
    			 sword = xp * swordUp - xp/2; 
    		}else if(S == 3){
    			System.out.println("You dont have the gold");
    		}else if (S == 4 && gold >= 1500 && !superSheald){
    			System.out.println("You have perchased the Super Sheald");
    			superSheald = true;
    			gold = gold - 1500;
    		}else if (S == 4){
    			System.out.println("You dont have the gold");
    		}else if (S == 5 && gold >= 50 && !tome){
    			System.out.println("You got the tome");
    			tome = true;
    			gold = gold - 50;
    		}else if (S == 5){
    			System.out.println("You dont have the gold or alredy hve this item");
    		}else if (S == 6 && gold >= 5){
    			System.out.println("You have perchased a magic upgrade");
    			gold = gold - 5;
    			magicPt = magicPt + 1;
    		}else if (S == 6){
    			System.out.println("You dont have the gold");
    		}else if (S == 7 && gold >= 5){
    			System.out.println("You have perchased a sword damage upgrade");
    			gold = gold - 5;
    			swordPt = swordPt + 1;
    		}else if (S == 7){
    			System.out.println("You dont have the gold");
    		}else if (S == 8 && gold >= 5){
    			System.out.println("You have perchased a Shop Tp Potion");
    			shopTpPotoins = shopTpPotoins + 1;
    			System.out.println("You now have " + shopTpPotoins + " Potion(s)");
    			gold = gold - 5;
    		}else if (S == 8){
    			 System.out.println("You dont have the gold to buy this");
    		}else if (S == 9 && gold >= 20){
    			System.out.println("You have perchased a Stun Potion");
    			stunPotion = stunPotion + 1;
    			System.out.println("You now have " + stunPotion + " Potion(s)");
    			gold = gold - 20;
    		}else if (S == 9){
    			System.out.println("You dont have the gold");
    		}
    	} 
    	
    	T = T + 1;
    	sword = swordPt * swordUp + 5;
    	magic = magicPt * 2 + 5;
    }
  void Dev(int c , Player P){
    if (c == 200){	
    	xp = 2000;
    	swordPt = 2000;
    	magicPt = 2000;
    	healthSlot = xp * 3 + 5;
    	health = healthSlot;
    	sword = xp; 
    	Block = xp + 2;
    	gold = 2000;
    }else if(c == 2004){
    	gold = 99999;
    	Block = xp + 2;
    }else if (c == 420){
    P.Shop(P);
    T = T - 1;
    }else if (c == 110){
    icePot = icePot + 3;	
    }
  }
  void returnShop(Player P){ 
	shopTpPotoins = shopTpPotoins - 1;  
	P.Shop(P);
	T = T - 1;   
   }
  void stunPot(Mob M){
	  M.Stun('S');
	  System.out.println("You throw your stun potion and stun the mob");
	  stunPotion = stunPotion - 1;
  } 
  boolean Magic(){
	  return tome;
  }
}
