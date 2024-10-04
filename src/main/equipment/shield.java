public class shield {

    private float protection;
    private int uses;

    public shield (int protection, int uses){

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

}
