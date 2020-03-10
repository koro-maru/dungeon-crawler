package src;
import src.Element.Elements;
import src.Status.Statuses;


public class Spell extends Attack{
  private double manaCost;
  private Statuses status;
  private int statusChance;
  private Elements element;
	
  public Spell(double damage, double manaCost, Elements element){
	super(damage);
    this.manaCost = manaCost;
    this.element = element;
  }

  public Spell (double damage, double manaCost, Elements element, Statuses status, int statusChance){
	super(damage, status, statusChance);
	this.manaCost = manaCost;
	this.element = element;
  }


  public double getSpellDamage(){
      return damage;
  }

  public double getSpellManaCost(){
      return manaCost;
  }

  public Elements getSpellElement(){
      return element;
  }
  
  public Statuses getSpellStatusEffect(){
    return status;
  }

  
}