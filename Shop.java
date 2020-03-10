package src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Shop implements Serializable{

    protected static ArrayList<Armor> armorInventory = new ArrayList<Armor>();
    protected static HashMap<String, Integer> restorationItemInventory = new HashMap<String, Integer>();
    
    //Custom iterator
    public static String displayArmor(){
    	StringBuilder armorStringBuilder = new StringBuilder();
    	int count = 1;
        for(Armor a : armorInventory){
        	armorStringBuilder.append(count + ": " + a.getName()  + " Cost: " + a.getCost() + "\n");
        	count++;
        }
        return armorStringBuilder.toString();
    }
    
  
    
    public static String displayItem(){
    	StringBuilder displayStringBuilder = new StringBuilder();
        for(Entry<String, Integer> entry : restorationItemInventory.entrySet()){
        	displayStringBuilder.append(entry.getKey()  + " Cost: " + entry.getValue() + "\n");
        }
      return displayStringBuilder.toString();
    }

    public static void buyArmor(String s) {
    	int pos = -1;
    	for (int i  = 0; i < armorInventory.size(); i++) {
    	if(armorInventory.get(i).getName().equals(s)) {
    		pos = i;
    }
          if(pos!=-1) { 
        	  Player.gold-= armorInventory.get(pos).getCost();
        	  System.out.println("You bought: " + armorInventory.get(pos).getName());
          }
          else {
        	  System.out.println("That armor does not exist.");
          }
    }
    }
}