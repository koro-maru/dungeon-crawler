package src;

public class RestorationItem {
	private int healthRegained;
	private Integer manaRegained;
	
	public RestorationItem(int healthRegained) {
		this.healthRegained = healthRegained;
	}
	
	public RestorationItem(int healthRegained, int manaRegained) {
		this.healthRegained = healthRegained;
		this.manaRegained = manaRegained;
	}
	public static void drinkRestorationItem(Unit u) {
		
	}

	public int getManaRegained() {
		return manaRegained;
	}

	public void setManaRegained(int manaRegained) {
		this.manaRegained = manaRegained;
	}

	public int getHealthRegained() {
		return healthRegained;
	}

	public void setHealthRegained(int healthRegained) {
		this.healthRegained = healthRegained;
	}
}
