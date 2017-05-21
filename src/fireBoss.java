
public class fireBoss {

	int times = 1;
	int health;
	boolean ice;
	boolean life;
	
fireBoss(){
	ice = false;
}
void damage(Player P){
	if(ice){
		System.out.println("You hit the Fire demon right in the weak spot");
		health = health - 1;
		if (health <= 0){
			System.out.println("The fire demon falls befor you whith a pain full scream");			//when you try to attack the boss
			life = false;
			ice = false;
			P.gold = P.gold + times * 100;
			System.out.println("You gain " + times * 100 + " gold you now have " + P.gold + " gold");
			times = times + 1;
		}else{
			System.out.println("The fire demon lets out whale of pain but isnt out for the count yet");
			ice = false;
		}
	}else{
			System.out.println("you summon up all your strength for this attack but its skin is to though");
	}
	ice = false;
}
 	void attack(char T, Player P){
 		System.out.print("The Fire Demon");
 		if(T == 'S'){
 			System.out.print(" throws a punch at you");
 			if(P.swordPt >= times * 2){
			 System.out.println(" but your reflecses from sword traning kick in and you doge out of the way");
 			}else{
 				if(P.Block != 0){
 					System.out.println(" but your sheald protects you from a bit of the damage");
 				}
 				P.health = P.health - (times * 2 - P.Block/2);
 			}
 		}else if(T == 'M'){
 			System.out.print(" casts a powerful fire breath spell");
 			if(P.magicPt >= times * 2){
 				System.out.println(" but because of your knowlage of the arcane arts you sumon a magic barrier");
 			}else{
 				if(P.Block != 0){
			 		System.out.println(" your block dose nothing agenst magic");
 				}
 				P.health = P.health - (times * 2);
 				if(P.health <= 0){
 					System.out.print("R.I.P here lies the grate adventurer ");
 					System.out.print(P.name);
 					System.out.println(" who died on a grand adventure whith a score of " + P.Kills);
 					System.exit(0);
 				}
 			}
 		}
 		System.out.println();
 		System.out.println(" Your health is now " + P.health + " out of " + P.healthSlot);
 		
 	}
 	void icePot(){
 		System.out.println("You throw a ice potion at the fire demon you notie that it exposes a weak point whare it hit");
 		ice = true;
 	}
 	void make(){
 		System.out.println("You walk into a dark room whith a evil feel you relize that in this room is a mytical creture known as a fire demon!!!!");
 		life = true;
 		health = 3;
 	}
}
