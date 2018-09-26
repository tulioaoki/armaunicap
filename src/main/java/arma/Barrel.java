
package arma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author arthur
 */
public class Barrel extends Item{
    private String name;
    private int modSound;
    private int modRange;
    private float weight;
    
    @JsonCreator
    public Barrel(
            @JsonProperty("name") String name, 
            @JsonProperty("mod-sound") int modSound,
            @JsonProperty("mod-range") int modRange, 
            @JsonProperty("weight") float weight,
            @JsonProperty("id") int id) {
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
    
    
    @Override
    public String toString(){
        StringBuilder tstring = new StringBuilder();
        tstring
                .append("Name: ")
                .append(this.name)
                .append(" ID: ")
                .append(this.getId())
                .append(" Sound modifier: ")
                .append(this.modSound)
                .append(" Range modifier: ")
                .append(this.modRange)
                .append(" Weight: ")
                .append(this.weight);
        return tstring.toString();
                
    }
}
