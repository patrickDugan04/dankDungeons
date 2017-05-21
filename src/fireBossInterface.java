import java.util.Scanner;

public class fireBossInterface {

	fireBossInterface(Player Patrick, fireBoss Boss){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int turns = 0;
		int act;
		boolean menue = true;
		Boss.make();
		while(Boss.life) {
			menue = false;
			
	          System.out.println("1.) Attack (sword)");
	          System.out.println("2.) Block");
		      System.out.println("3.) Item");
		      if(Patrick.Magic()) {
			    System.out.println("4.) Attack (magic)");
			  }
		      System.out.println("5.) Quit");
	          act = input.nextInt();
	          if (act == 1){
			    Boss.damage(Patrick);	
		      } else if (act == 2) {
	            Patrick.Block(Patrick);
		      } else if (act == 3) {
			    System.out.println("Your items are");	
			    System.out.println("1.) Heath potions : " + Patrick.Get('P'));
			    System.out.println("2.) Shop Tp Potions : " + Patrick.Get('T'));
			    System.out.println("3.) Stun Potions : " + Patrick.Get('S'));
			    System.out.println("4.) Ice Potions : " + Patrick.icePot);
			    System.out.println("5.) Back");	
		        act = input.nextInt();
	            if (act == 1 && Patrick.Get('P') > 0) {
			      Patrick.heal(Patrick.Get('H') , 'P');
			      menue = true;
		        } else if (act == 1) {
			      System.out.println("You dont have any heath potions");
			      menue = true;
	            } else if (act == 2 && Patrick.Get('T') > 0) {
	            	System.out.println("You drink the potion and appear right out side of the shop");  
			      Patrick.returnShop(Patrick);
			      menue = true;	
		        } else if (act == 2) {
			      System.out.println("You dont have this item");
			      menue = true;	
		        } else if (act == 3 && Patrick.Get('S') > 0 ) {
			      System.out.println("You try to stun the demond but it dose not work");
			      Patrick.stunPotion = Patrick.stunPotion - 1;
		        } else if (act == 3) {
			      System.out.println("You dont have this item");	
		        } else if(act == 4){
		        	if(Patrick.icePot > 0){
		        		Patrick.icePot = Patrick.icePot - 1;
		        		Boss.icePot();
		        	}else{
		        		System.out.println("You dont have this item");
		        	}
		        }else if (act == 5) {
	              menue = true;	
	            }
	          } else if (act == 4 && Patrick.Magic()) {
			    Boss.damage(Patrick);
		      } else if (act == 5){
		        act = 0; 
		        System.exit(0);
		      } else if (act == 200 || act == 2004 || act == 420) {
		        Patrick.Dev(act,Patrick);
		        menue = true;
	          }
	          
	          if(!menue && Boss.life == true) {
	        	 if(Math.random() > .5){
	        		 Boss.attack('S',Patrick);
	        	 }else{
	        	Boss.attack('M',Patrick);
	        	 }
	          menue = false;
	          }
	          Patrick.Block = 0;
	          turns = turns + 1;
				if(turns >= 3){
					if(Math.random() > .5){
						Patrick.icePot = Patrick.icePot + 1;	//to get a ice potion
						System.out.println("in the heat of battle you see a ice potion right next to you \" might come in handy \" you think while quikly grabing it");
					}
					turns = 0;
				}
			}
		Patrick.shopTpPotoins = Patrick.shopTpPotoins + 1;
		Patrick.returnShop(Patrick);
		
		}
	}
