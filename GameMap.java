package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.Enemy.Personality;
public class GameMap{
	
	StringBuilder mapBuilder = new StringBuilder();
	
	enum Locations{
		RUINS_OF_AVARICE, DESERT_OF_PRIDE, OCEAN_OF_LUST
	}

	static Enemy jackFrost = new Enemy.EnemyBuilder().name("Jack Frost").magicalAttack(1.0).personality(Personality.IRRITABLE).build();
	static Enemy silky = new Enemy.EnemyBuilder().name("Silky").magicalAttack(1.0).personality(Personality.IRRITABLE).build();
	static Enemy chariot = new Enemy.EnemyBuilder().name("Chariot").magicalAttack(1.0).personality(Personality.IRRITABLE).build();
	static Enemy obariyon = new Enemy.EnemyBuilder().name("Obariyon").magicalAttack(1.0).personality(Personality.IRRITABLE).build();
	static Enemy iluyanka = new Enemy.EnemyBuilder().name("Iluyanka").magicalAttack(1.0).personality(Personality.IRRITABLE).build();
	static Enemy ford = new Enemy.EnemyBuilder().name("Ford").magicalAttack(1.0).personality(Personality.IRRITABLE).build();
	
	private static Locations currentLocation;
	
	static ArrayList<Enemy> ruinsEnemies = new ArrayList<Enemy>(){{
		add(jackFrost);
		add(silky);
		add(chariot);
		add(obariyon);
		add(iluyanka);
		add(ford);
	}};
	
	public String[][] map = new String[10][10];
	
	static Map<Locations, ArrayList<Enemy>> enemyPool = Map.ofEntries(
		Map.entry(Locations.RUINS_OF_AVARICE, ruinsEnemies)
			);
	
	/*TODO:
	 * Implement battling system
	 * Implement moving throughout the map
	 * Implement a way for battling to initiate through random chance
	 * The elusive procedural generation algorithm
	 * Showing what steps the player has already traveled in the map.
	 */

	static ArrayList<Enemy>localEnemyPool = new ArrayList<Enemy>();
	
	public static void locationInit(Locations l) {
		currentLocation = l;
		localEnemyPool = enemyPool.get(l);
	}
	
	public Locations getCurrentLocation() {
		return currentLocation;
	}
	
}