package equipment;

public class Shield {

    private float protection;
    private int uses;

    public Shield (float protection, int uses){
    	this.protection = protection;
    	this.uses = uses;
    }

    private float getProtection(){
        return this.protection;
    }

    private int getUses(){
        return this.uses;
    }

    public float protect(){
        if (this.uses > 0){
            return this.protection;
        }else{
            return 0;
        }
    }

    public String toString(){
        return "S[" + this.protection + ", " + this.uses + "]";
    }
    
    public boolean discard() {
    	return Dice.discardElement(this.uses);
    }
    
}
