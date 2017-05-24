import java.util.Scanner;

public class Main {
	 
  public static void main(String[] args) {
	  
    Player Patrick = new Player();		 
    Mob Mob = new Mob(1);
    fireBoss Boss = new fireBoss();
	Scanner input = new Scanner(System.in);
	int act;
	boolean menue = true;
	while(true) {
		menue = false;
		if (Mob.getLife() == false) {
			System.out.println("Type 'next' to advance");
			input.next();
          	if (Patrick.Get('X') == Patrick.Get('M')) {
				System.out.println("You have cleared all Mobs in this room you walk into the next one"); //GOING TO SHOP
				System.out.println("You enter and notice the sign saying dungon shop");	
				Patrick.Shop(Patrick);
            }
          	if(Patrick.Kills == Boss.times * 10){
          		new fireBossInterface(Patrick, Boss);
          	}
            Mob.New(Patrick.Get('X'));
        } else {
        	System.out.println("1.) Attack (sword)");
        	System.out.println("2.) Block");
        	System.out.println("3.) Item");
	      if(Patrick.Magic()) {
		    System.out.println("4.) Attack (magic)");
		  }
	      System.out.println("5.) Quit");
          act = input.nextInt();
          if (act == 1){
		    Patrick.attack(Mob,Patrick,'S');	
	      } else if (act == 2) {
	    	  Patrick.Block(Patrick);
	      } else if (act == 3) {
	    	  System.out.println("Your items are");	
	    	  System.out.println("1.) Heath potions : " + Patrick.Get('P'));
	    	  System.out.println("2.) Shop Tp Potions : " + Patrick.Get('T'));
	    	  System.out.println("3.) Stun Potions : " + Patrick.Get('S'));
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
	        	menue = true;
	        	Patrick.stunPot(Mob);
	        	System.out.println("The mob is stuned so it cant move");
	        } else if (act == 3) {
	        	System.out.println("You dont have this item");	
	        } else if (act == 5) {
	        	menue = true;	
            }
          } else if (act == 4 && Patrick.Magic()) {
        	  System.out.println("You shoot the mob whith a blast of magic");
        	  Patrick.attack(Mob,Patrick,'M');
	      } else if (act == 5){
	    	  act = 0;
              input.close();
	    	  System.exit(0);
	      } else if (act == 200 || act == 2004 || act == 420 || act == 666 || act == 110) {
	    	  Patrick.Dev(act,Patrick);
	    	  if(act == 666){
	        	new fireBossInterface(Patrick, Boss);				//cheat codes for testing game they fun as well
	        }
	        menue = true;
          }
          
          if(!menue && Mob.getLife() == true) {
            Mob.attack(Patrick,Mob);
          }
        }
      }
  }
} 			
