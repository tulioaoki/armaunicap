
package arma;

/**
 *
 * @author arthur
 */
public class Barrel extends Item implements Camouflage{
    private String name;
    private int modSound;
    private int modRange;
    private float weight;
    private String camouflage;

    public Barrel(String name, int modSound, int modRange, float weight, int id) {
        super(id);
        this.name = name;
        this.modSound = modSound;
        this.modRange = modRange;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModSound() {
        return modSound;
    }

    public void setModSound(int modSound) {
        this.modSound = modSound;
    }

    public int getModRange() {
        return modRange;
    }

    public void setModRange(int modRange) {
        this.modRange = modRange;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public void putStyle(String type){
        
        this.camouflage = type;
    }
    
    public void removeStyle(){
        
        if(this.camouflage != null){
            
            this.camouflage = null;
        
        }else{
            
            System.out.println("This barrel has no camouflage.");
        }
    }
    
   public String getStyle(){
       
        return this.camouflage;
    }
    
    @Override
    public String toString(){
        StringBuilder tstring = new StringBuilder();
        tstring.append("Name: ").append(this.name).append(" ID: ").append(this.getId()).append(" Sound modifier: ").append(this.modSound).append(" Range modifier: ").append(this.modRange).append(" Weight: ").append(this.weight).append(" Camouflage: ").append(this.camouflage);
        return tstring.toString();
                
    }
}
