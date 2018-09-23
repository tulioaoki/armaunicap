
package arma;

/**
 *
 * @author arthur
 */
public class Bullet extends Item{
    private String name;
    private int modDamage;
    private int modSound;
    private float weight;

    public Bullet(String name, int modDamage, int modSound, float weight, int id) {
        super(id);
        this.name = name;
        this.modDamage = modDamage;
        this.modSound = modSound;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModDamage() {
        return modDamage;
    }

    public void setModDamage(int modDamage) {
        this.modDamage = modDamage;
    }

    public int getModSound() {
        return modSound;
    }

    public void setModSound(int modSound) {
        this.modSound = modSound;
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
        tstring.append("Name: ").append(this.name).append(" ID: ").append(this.getId()).append(" Sound modifier: ").append(this.modSound).append(" Damage modifier: ").append(this.modDamage).append(" Weight: ").append(this.weight);
        return tstring.toString();
    }
    
    
}
