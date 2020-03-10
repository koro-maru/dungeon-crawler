package src;
public class Armor{
    private String name;
    private int damageThreshold;
    private int cost;
    StringBuilder sb = new StringBuilder();
    
    public Armor(String name, int damageThreshold){
        this.name = name;
        this.damageThreshold = damageThreshold;
    }

	public String getName() {
		return name;
	}

	public int getDamageThreshold() {
		return damageThreshold;
	}

	public int getCost() {
		return cost;
	}

    @Override
    public String toString() {
    	sb.setLength(0);
		sb.append("====" + name.toUpperCase() + "====");
		sb.append("DAMAGE THRESHOLD:" + damageThreshold);
		sb.append("COST: " + cost);
		return sb.toString();
    }
    
}