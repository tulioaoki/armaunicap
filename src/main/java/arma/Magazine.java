
package arma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import Dao.Dao;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author arthur
 */

@ApplicationScoped
public class Magazine extends Item implements Camouflage{
    private String name;
    private int capacity;
    private ArrayList<Item> compatibility;
    private Bullet ammo;
    private String camouflage;
    
    @JsonCreator
    public Magazine(
            @JsonProperty("name") String name,
            @JsonProperty("capacity") int capacity,
            @JsonProperty("id") int id)
    {
        super(id);
        this.name = name;
        this.capacity = capacity;
        this.compatibility = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void addCompatibility(Item i){
        this.compatibility.add(i);
    }

    public Bullet getAmmo() {
        return ammo;
    }
    
    public void load(Bullet b){
        if(b.compatible(this.compatibility)){ 
            this.ammo = b;
        }
        
    }
    
    public void unload(){
       this.ammo = null;
    }
    
    public void putStyle(String type){
        
        this.camouflage = type;
    }
    
    public void removeStyle(){
        
        if(this.camouflage != null){
            
            this.camouflage = null;
        
        }else{
            
            System.out.println("This magazine has no camouflage.");
        }
    }
    
    public String getStyle(){
       
        return this.camouflage;
    }
    
    @Override
    public String toString(){
        String ammot = (this.ammo == null)?"null":this.ammo.getName();
        StringBuilder tstring = new StringBuilder();
        tstring.append("Name: ").append(this.name).append(" ID: ").append(this.getId()).append(" Capacity: ").append(this.capacity).append(" Bullet: ").append(ammot).append(" Camouflage: ").append(this.camouflage);
        return tstring.toString();
    }
}
