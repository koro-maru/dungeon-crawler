package src;

import java.util.Random;

public class Status {
   public enum Statuses {
        BURNING, FROZEN, SHOCKED, CHARMED, HORRIFIED, NONE
    }

   	public static int generateStatusTurns() {
   		Random r = new Random();
   		return r.nextInt(4) + 1;
   	}
   	
    public static void burning(Spell s, Unit u){
    	if(!u.isBurning) {
     int turnCalled = Battling.turns;
     while( Battling.turns != turnCalled + generateStatusTurns()) {
    	 
     }
    }
    	else {
    		System.out.println(u.name + " is already burning!");
    	}
    }

    public static void frozen(Unit u){
    	for(int temp = Battling.turns; temp < temp + generateStatusTurns(); temp++) {
       	 u.isFrozen = true;
        }
    	u.isFrozen = false;
    }

    public static void shocked(){
        //cant move 30% of the time and has a chance to shock allies.
    	for(int temp = Battling.turns; temp < temp+ generateStatusTurns(); temp++) {
       	 
        }
        
    }

    public static void charmed(){
        //any enemy inflicted with this attacks allies
    	for(int temp = Battling.turns; temp < temp + generateStatusTurns(); temp++) {
       	 
        }
    }


}