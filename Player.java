package src;
import java.util.ArrayList;
import java.util.HashMap;

public class Player extends PartyMember {
    private int reputation;
    public static int gold;
    public static ArrayList<Armor> armorList = new ArrayList<Armor>();
    public static HashMap<String, Integer> restorationItems = new HashMap<String, Integer>();
    public static ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
    public static ArrayList<String> keyItems = new ArrayList<String>();
    
    
    private static Player p; 

    enum Commands{
    	ITEMS, SKILLS, EQUIPMENT
    }
    //A classic use of the singleton pattern, ensuring that only a single player is active at a time
    public static Player getInstance(){
        if(p==null){
           p = new Player();
        }
        return p;
    }

    public int getReputation(){
        return reputation;
    }

    public void setReputation(int reputation){
        this.reputation = reputation;
    }
    
    public String displayArmor() {
    	StringBuilder armorDisplayStringBuilder = new StringBuilder();
    	for(Armor a : armorList) {
    		armorDisplayStringBuilder.append(a.toString());
    	}
		return armorDisplayStringBuilder.toString();
    }
    
    public class InventoryItems{
    	Armor armor;
    	Weapon weapon;
    	String keyItem;
    }
    
   
}