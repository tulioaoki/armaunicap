package arma;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Item {
    private int id;

    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setId(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            this.id = i;
        }catch(NumberFormatException e){
            return;
        } 
        
    }
    
    public Boolean compatible(ArrayList l){
        Boolean b = l.contains(this);
        return b;
    }
    
    @Override
    public String toString(){
        StringBuilder tstring = new StringBuilder();
        tstring.append("ID: ").append(this.id);
        return tstring.toString();
    }
    
}

