
package arma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author arthur
 */
public class Sight extends Item implements Camouflage {
    
    private String name;
    private int modPrecission;
    private float weight;
    private String camouflage;
    
    public Sight(int id) {
        super(id);
    }
    
    @JsonCreator
    public Sight(
            @JsonProperty("name") String name,
            @JsonProperty("mod-precission") int modPrecission,
            @JsonProperty("weight") float weight, 
            @JsonProperty("id") int id
    ) {
        super(id);
        this.name = name;
        this.modPrecission = modPrecission;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModPrecission() {
        return modPrecission;
    }

    public void setModPrecission(int modPrecission) {
        this.modPrecission = modPrecission;
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
            
            System.out.println("This sight has no camouflage.");
        }
    }
    
    public String getStyle(){
       
        return this.camouflage;
    }   
       
    @Override
    public String toString(){
      StringBuilder tstring = new StringBuilder();
      tstring.append("Name: ").append(this.name).append(" ID: ").append(this.getId()).append(" Precision modifier: ").append(this.modPrecission).append(" Weight: ").append(this.weight).append(" Camouflage: ").append(this.camouflage);
      return tstring.toString();
    }
}
