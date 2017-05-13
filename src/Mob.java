
public class Mob {
	int health;
	int level;
	int damage;
	boolean life;
	boolean Stun;
	double Attack;
	int spearDam;
Mob(int x){
    level = x;
    health = level + 2;
    damage = level;
	life = true;
}
void Damage (int D,Player P,Mob Mob,char T){
		health = health - D;
		if(T == 'N'){
			System.out.println("After hiting the Mob its health gose down by " + D + " hit points and now is " + health+ " hit points");
		}else if (T == 'B'){
			System.out.println("Becuase the Mob hit you while you had you shield up he took " + D + " damage");
			System.out.println("You stun the mob for one turn");
			Mob.Stun('S');
			
			
		}
	if(health <= 0){
	P.loot(P,Mob);	
	Mob.Stun('U');
	System.out.println("Congrats you killed it");
	life = false;
	}
	}
void attack (Player P,Mob Mob){
   
    if(life && Mob.Stun('G') == false){
    Attack = Math.random();
    if(Attack <= .5){
	  P.Damage(damage,Mob,P,1);
    }else if (Attack >= .4 ){
    	spearDam = damage - damage/3;
    	P.Damage(spearDam,Mob,P,2);
    }
    }else if (life && Mob.Stun('G')){
    	System.out.println("The mob is stuned for this turn");
    	Mob.Stun('U');
    }
	}
boolean getLife(){
	return life;	
	}
void New(int T){
	System.out.println("A new mob runs at you");
	if(T == 5){
		level = level - 2;
		health = level * level - level * 2;
	    damage = level * 2;
	    level = level + 1;
	    life = true;
	}else if(T > 5){
		health = level * level - level * 2;
	    damage = level * 2;
	    life = true;
	    level = level + 1;
	}else if ( T < 5){
	level = level + 1;
    health = level + 2;
    damage = level;
	life = true;	
	}
	}
boolean Stun(char sG){
	if (sG == 'S'){
	Stun = true;	
	}else if(sG == 'U'){
	Stun = false;	
	}
	return Stun;
}
int getLevel(){
	return level;
}

	
}

	


	

