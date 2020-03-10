package src;


import src.Status.Statuses;

public class Attack  {
    protected  double damage;
    protected  Statuses status;
	protected  int statusChance;

    public Attack(double damage){
        this.damage = damage;
        this.status = Statuses.NONE;
        this.statusChance = 0;
    }

    public Attack(double damage, Statuses status, int statusChance){
        this.damage = damage;
        this.status = status;
        this.statusChance = statusChance;
    }


    public double getAttackDamage(){
        return damage;
    }


    public Statuses getAttackStatus(){
        return status;
    }
    

   
}

