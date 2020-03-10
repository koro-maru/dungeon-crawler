package src;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Battling {
		
		enum Difficulty {
        EASY, NORMAL, HARD
	}
	
	static int turns;
 	public static boolean inBattle = false;
 	static ArrayList<PartyMember> partyMembers = new ArrayList<PartyMember>();
 	ArrayList<Enemy> currentEnemies = new ArrayList();
 	
	public void battling(){
			turns = 0;
			for(PartyMember partyMember  : partyMembers) {
				
			}
			turns++;
		}
	
	public void targetEnemy() {
		System.out.println("Who would you like to target?");
		for(Enemy e : currentEnemies) {
			System.out.println(e.toString());
		}
		String target = Main.sc.nextLine();
		if(Unit.findUnitByName(target, currentEnemies) != null) {
			
		}
		else {
			
		}
	}
	
	
	public static PartyMember targetPlayer() {
		Random r = new Random();
		int targetPosition = r.nextInt(partyMembers.size() + 1);
		return partyMembers.get(targetPosition);
	}
	
	public void populateEnemies(int max) {
		Random r = new Random();
		int enemyAmount = r.nextInt(max) + 1;
		
		for(int i = 0; i<enemyAmount; i++) {
			currentEnemies.add(GameMap.localEnemyPool.get(r.nextInt(GameMap.localEnemyPool.size())));
		}
	}
	
	
}
