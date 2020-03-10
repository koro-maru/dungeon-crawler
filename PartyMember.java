package src;

import java.util.Map.Entry;

public class PartyMember extends Unit{
	private static final long serialVersionUID = -3358736613020133544L;
	protected int agility;
    protected int strength;
    protected int wisdom;
    protected int fortitude;
    protected int level = 1; 
    protected int experience = 0;
    protected int experienceToNextLevel = 200;

   protected Armor[] armorSlots = new Armor[4];
   protected Weapon[] weaponSlot = new Weapon[1];

   public void changeArmor(Armor a, int pos) {
	   if(armorSlots[pos]!=null) {
		   Player.weaponsList.add(weaponSlot[0]);
	   }
	   armorSlots[pos] = a;
   }
   
   public void changeWeapon(Weapon w) {
	   if(weaponSlot[0]!=null) {
		   Player.weaponsList.add(weaponSlot[0]);
	   }
	   weaponSlot[0]=w;
   }
 	public String analyzeEnemy(Enemy e){
 	StringBuilder analyzeEnemyBuilder = new StringBuilder();
 	System.out.println((e.name.toUpperCase()) +
 	("=============") +
 	("HEATLH: " + e.currentHealth + "/" + e.maxHealth) +
 	("MANA: " + e.currentMana + "/" + e.maxMana) +
 	("MAGICAL ATTACK: " + e.magicalAttack) +
 	("MAGICAL DEFENSE: " + e.magicalDefense) +
 	("PHYSICAL ATTACK: " + e.physicalAttack) + 
 	("PHYSICAL DEFENSE: " + e.physicalDefense));
	return analyzeEnemyBuilder.toString();
 	}
 	

 	public void attack(Enemy e, Attack a){
 		e.currentHealth-=calculatePhysicalDamage(this.physicalAttack, a, e);
 	}

 	public void setExperience(int experience){
    this.experience = experience;
}

 	public void levelUp(){
 		if(experience>=experienceToNextLevel){
 			level++;
 			experienceToNextLevel *= 1.5;
 		}
 	}

	@Override
	void ultimateAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void physicalAttack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void magicalAttack(Unit u) {
		System.out.println("Which spell will you use?");
		System.out.println(listSpells());
		String target = Main.sc.nextLine();
		Spell spellChoice = (Spell) Unit.findAttackByName(target, this.spells);
		if(spellChoice!=null) {
			u.currentHealth-=Unit.calculateMagicalDamage(this.magicalAttack, spellChoice, u);
		}
	}

	
	protected String listSpells() {
		StringBuilder spellsStringBuilder = new StringBuilder();
		spellsStringBuilder.append("===SPELLS===\n");
		for(Entry<String, Spell> entry : this.spells.entrySet()) {
			spellsStringBuilder.append(entry.getKey() + "\n");
		}
		return spellsStringBuilder.toString();
	}
	
	protected String listAttacks() {
		StringBuilder spellsStringBuilder = new StringBuilder();
		spellsStringBuilder.append("===SPELLS===\n");
		for(String key : this.attacks.keySet()) {
			spellsStringBuilder.append(">" + key.toUpperCase() +"\n");
		}
		return spellsStringBuilder.toString();
	}
	
	public void promptAction() {
		System.out.println("What will you do?\n");
	}
	
	
}