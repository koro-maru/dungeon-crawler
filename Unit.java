package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import src.Element.Elements;
import src.Status.Statuses;

public abstract class Unit implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int currentHealth = 100;
    protected int maxHealth = 100;
    protected int currentMana = 100;
    protected String name;
    protected int maxMana = 100;
    protected double physicalAttack = 5.0;
    protected int critChance = 4; 
    //Corresponds to a 4% chance, as do all other "chances"
    protected double magicalAttack = 5.0;
    protected double magicalDefense = 2.0;
    protected double physicalDefense = 2.0;
    protected boolean isDead = false;
    protected boolean criticalHit = false;
    protected int evasionChance = 5;
    protected boolean isBurning;
    protected boolean isFrozen;
    protected boolean isCharmed;
    protected boolean isParalyzed;
    protected ArrayList<Elements> weaknesses = new ArrayList<Elements>();
    //spell format should generally follow: Name :: damage, mana, element, status (optional), status chance
    public static Map<String, Spell> spellPool =  Map.ofEntries(
    	Map.entry("Agi", new Spell(10.0, 5.0, Elements.FIRE, Statuses.BURNING, 5)),
    	Map.entry("Bufu", new Spell(10.0, 5.0, Elements.ICE, Statuses.FROZEN, 5)),
    	Map.entry("Zio", new Spell( 10.0, 5.0, Elements.ELECTRICITY, Statuses.SHOCKED, 5))
    	);
    public static HashMap<String, Attack> attackPool = new HashMap<String, Attack>();
    public static ArrayList<Enemy> enemyPool = new ArrayList<Enemy>();
    protected HashMap<String, Spell> spells = new HashMap<String, Spell>();
    protected HashMap<String, Attack> attacks = new HashMap<String, Attack>();
    
    
    abstract void ultimateAttack();
    abstract void physicalAttack();
    abstract void magicalAttack(Unit u);
    
    public static <T extends Map<String, ?>> Attack findAttackByName(String target, T t) {
    	for(String name : t.keySet()) {
    		if(name.equals(target)) {
				return (Attack) t.get(name);
			}
    	}
		return null;
    }
    
    protected  double calculatePhysicalDamage(double physicalAttack, Attack attack, Unit unit){
    double totalDamage;
   //calculates the total damage the unit did, accounting for critical hits, weapon and stat-affixing armor.
    Random random = new Random();
    boolean criticalHit = (random.nextInt(100) + 1) <= critChance;
    totalDamage = criticalHit ? attack.getAttackDamage() + attack.getAttackDamage()/2 : attack.getAttackDamage() - (unit.physicalDefense * .1 * attack.getAttackDamage()); //change this to a percent of the damage
    return totalDamage;
  
    }
    
    
	public void defend() {
		double tempPhys = this.physicalDefense;
		double tempMag = this.magicalDefense;
		
		this.physicalDefense += this.physicalDefense * .5;
		this.magicalDefense += this.magicalDefense * .5;
	}

    protected static double calculateMagicalDamage(double magicalAttack, Spell spell, Unit unit){
        Random random = new Random();
      //  boolean criticalHit = (random.nextInt(100) + 1) <= critChance;
        return spell.getSpellDamage();
    }
    
    protected boolean isWeak(Elements e) {
    	boolean found = false;
    	for(Elements element : weaknesses) {
    		found = element == e;
    	}
    	return found;
    }

    void targetEnemy() {
		System.out.println("What enemy would you like to target?");
		
	}
    
    public static <T extends Unit> Unit findUnitByName(String target, Collection<T> c) {
		for(T current : c) {
			if(current.name.equals(target)) {
				return current;
			}
		}
		return null;
	}
    
  
    protected static abstract class UnitBuilder<T extends Unit, B extends UnitBuilder>{
        protected int maxHealth = 100;
        protected String name;
        protected int maxMana = 100;					
        protected double physicalAttack = 5.0;
        protected int critChance = 4; 
        //Corresponds to a 4% chance
        protected double magicalAttack = 5.0;
        protected double magicalDefense = 2.0;
        protected double physicalDefense = 2.0;
        protected int evasionChance = 5;
        protected HashMap<String, Spell> spells = new HashMap<String, Spell>();
        protected HashMap<String, Attack> attacks = new HashMap<String, Attack>();
        protected ArrayList<Elements> weaknesses = new ArrayList<Elements>();
    	
        protected T unit;
        protected B unitBuilder;
        
        protected abstract T getUnit();
        protected abstract B getUnitBuilder();
        
    	public B health(int health) {
    		unit.maxHealth=health;
    		return unitBuilder;
    	}
    	
    	public B name(String name) {
    		unit.name = name;
    		return unitBuilder;
    	}
    	
    	public B magicalAttack(double magicalAttack) {
    		unit.magicalAttack = magicalAttack;
    		return unitBuilder;
    	}
    	
    	public B physicalAttack(double physicalAttack) {
    		unit.physicalAttack = physicalAttack;
    		return unitBuilder;
    	}
    	
    	public B critChance(int critChance) {
    		unit.critChance = critChance;
    		return unitBuilder;
    	}
    	
    	public B evasion(int evasion) {
    		unit.evasionChance = evasion;
    		return unitBuilder;
    	}
    	
    	public B physicalDefense(double magicalDefense) {
    		unit.magicalDefense = magicalDefense;
    		return unitBuilder;
    	}
    	
    	public B magicalDefense(double physicalDefense) {
    		unit.physicalDefense = physicalDefense;
    		return unitBuilder;
    	}
    	
    	protected UnitBuilder() {
    		unit = getUnit();
    		unitBuilder = getUnitBuilder();
    	}
    	
    	public T build() {
    		return unit;
    	}
    	
    }
}