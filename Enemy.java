package src;

//abstract
public class Enemy extends Unit{
	enum Personality{
		IRRITABLE, UPBEAT, TIMID
	}
	
	Personality personality;
	@Override
	void ultimateAttack() {
		// TODO Auto-generated method stub
	}

	@Override
	void physicalAttack() {
	
	}

	@Override
	void magicalAttack(Unit u) {
	
	}
	
	@Override
	public String toString() {
		return this.name.toUpperCase()+ "\n=============" +
				("\nHEATLH: " + this.currentHealth + "/" + this.maxHealth) +
			 	("\nMANA: " + this.currentMana + "/" + this.maxMana);
	}
	
	
	public static class EnemyBuilder extends UnitBuilder<Enemy, EnemyBuilder>{
		private Personality personality;
		
		public EnemyBuilder personality(Personality personality) {
			unit.personality = personality;
			return this;
		}
		
		@Override
		protected Enemy getUnit() {
			return new Enemy();
		}

		@Override
		protected EnemyBuilder getUnitBuilder() {
			return this;
		}
		
					
		}
}