package arma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Gun extends Item implements Camouflage{

    private String name;
    private int defaultPrecision;
    private int defaultRecoil;
    private int defaultSound;
    private int defaultRange;
    private float defaultWeight;
    private int precision;
    private int recoil;
    private int sound;
    private int range;
    private int damage;
    private int capacity;
    private float weight;
    private Sight sight;
    private Magazine magazine;
    private ButtStock buttstock;
    private Barrel barrel;
    private ArrayList<Item> compatibility;
    private String camouflage;
    
    @JsonCreator
    public Gun(
            @JsonProperty("name") String name,
            @JsonProperty("int") int precision,
            @JsonProperty("recoil") int recoil,
            @JsonProperty("sound") int sound,
            @JsonProperty("range") int range,
            @JsonProperty("damage") int damage,
            @JsonProperty("capacity") int capacity,
            @JsonProperty("weight") float weight,
            @JsonProperty("sight") Sight sight,
            @JsonProperty("magazine") Magazine magazine,
            @JsonProperty("buttstock") ButtStock buttstock,
            @JsonProperty("barrel") Barrel barrel,
            @JsonProperty("id") int id)
    {
        super(id);
        this.name = name;
        
        if(sight == null){
            System.out.println("O campo sight não foi inicializado");
        }else{
            this.sight = sight;
        }
        if(barrel == null){
            
            System.out.println("O campo barrel não foi inicializado");
        }else{
            
            this.barrel = barrel;
        }
        if(magazine == null){
            
            System.out.println("O campo magazine não foi inicializado");
        }else{
            
            this.magazine = magazine;
        }
        if(buttstock == null){
            
            System.out.println("O campo buttstock não foi inicializado");
        }else{
            
            this.buttstock = buttstock;
        }
        this.defaultPrecision = precision;
        this.defaultRecoil = recoil;
        this.defaultSound = sound;
        this.defaultRange = range;
        this.damage = magazine.getAmmo().getModDamage();
        this.capacity = magazine.getCapacity();
        this.defaultWeight = weight;
    }

    public Gun(int id, String name) {

        super(id);
        this.name = name;
    }

    public int getPrecision() {
        return precision;
    }

    public int getRecoil() {
        return recoil;
    }

    public int getSound() {
        return sound;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getWeight() {
        return weight;
    }

    public Gun setSight(Sight sight) {

        if (sight.compatible(compatibility)) {

            this.sight = sight;
            return recalculate();

        } else {
            return recalculate();

        }
    }

    public Gun setMagazine(Magazine magazine) {
        if (magazine.compatible(compatibility)) {

            this.magazine = magazine;
            return recalculate();

        } else {

            return recalculate();
        }
    }

    public Gun setButtstock(ButtStock buttstock) {

        if (buttstock.compatible(compatibility)) {

            this.buttstock = buttstock;
            return recalculate();

        } else {

            return recalculate();
        }
    }

    public Gun setBarrel(Barrel barrel) {

        if (barrel.compatible(compatibility)) {
            this.barrel = barrel;
            return recalculate();
        } else {
            return recalculate();
        }
    }

    public void addCompatibility(Item i) { // Esse "item" é a bala
        this.compatibility.add(i);
    }

    public Gun recalculate() {

        this.weight = defaultWeight;
        this.sound = defaultSound;
        this.precision = defaultPrecision;
        this.range = defaultRange;
        this.recoil = defaultRecoil;

        if (this.sight != null) { // Arma tem um sight novo

            weight = weight + this.sight.getWeight();
            precision = precision + this.sight.getModPrecission();
        }
        if (this.barrel != null) { // Arma também tem um barrel novo

            sound = sound + this.barrel.getModSound();
            weight = weight + this.barrel.getWeight();
            range = range + this.barrel.getModRange();
        }
        if (this.magazine != null) { // Arma também tem um maganize novo

            this.capacity = this.magazine.getCapacity();
            weight = weight + (this.magazine.getCapacity() * this.magazine.getAmmo().getWeight());
            this.damage = this.magazine.getAmmo().getModDamage();
            sound = sound + this.magazine.getAmmo().getModSound();
        } else {

            this.capacity = 0;
            this.damage = 0;
        }
        if (this.buttstock != null) { // Arma também tem tem um buttstock novo

            weight = weight + this.buttstock.getWeight();
            recoil = recoil + this.buttstock.getModRecoi();
        }
        
        return this;
    }
    
     public void putStyle(String type){
        
        this.camouflage = type;
    }
    
    public void removeStyle(){
        
        if(this.camouflage != null){
            
            this.camouflage = null;
        
        }else{
            
            System.out.println("This gun has no camouflage.");
        }
    }
    
    public String getStyle(){
       
        return this.camouflage;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("ID: ")
                .append(this.getId())
                .append(" Name: ")
                .append(this.name)
                .append(" Precision: ")
                .append(this.precision)
                .append(" Recoil: ")
                .append(this.recoil)
                .append(" Sound: ")
                .append(this.sound)
                .append(" Range: ")
                .append(this.range)
                .append(" Damage: ")
                .append(this.damage)
                .append(" Capacity: ")
                .append(this.capacity)
                .append(" Weight: ")
                .append(this.weight)
                .append(" Camouflage: ")
                .append(this.camouflage);
        return sb.toString();
    }
}
