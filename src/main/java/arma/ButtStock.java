
package arma;

/**
 *
 * @author arthur
 */
public class ButtStock extends Item implements Camouflage{
    
    private int modRecoil;
    private String name;
    private float weight;
    private String camouflage;
    
    public ButtStock(int modRecoil, String name, float weight, int id) {
        super(id);
        this.modRecoil = modRecoil;
        this.name = name;
        this.weight = weight;
    }

    public int getModRecoi() {
        return modRecoil;
    }

    public void setModRecoi(int modRecoi) {
        this.modRecoil = modRecoi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            
            System.out.println("This buttStock has no camouflage.");
        }
    }
    
    public String getStyle(){
       
        return this.camouflage;
    }
    
    @Override
    public String toString(){
        StringBuilder tstring = new StringBuilder();
        tstring.append("Name: ").append(this.name).append(" ID: ").append(this.getId()).append(" Recoil modfier: ").append(this.modRecoil).append(" Weight: ").append(this.weight).append(" Camouflage: ").append(this.camouflage);
        return tstring.toString();
    }
}
