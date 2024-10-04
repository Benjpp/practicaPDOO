
public class weapon {
    private float power;
    private int uses;
    public weapon (float power, int uses){

    }

    private float getPower(){
        return this.power;
    }

    private int getUses(){
        return this.uses;
    }

    public float attack (){
        if (this.uses > 0){
            this.uses--;
            return this.power;
        }else{
            return 0;
        }
    }
    
    public String toString(){
        return "W[" + this.power + ", " + this.uses + "]";
    }

}
