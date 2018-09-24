package Controller;
import Dao.Dao;
import arma.Sight;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class SightController {
    Dao dao = Dao.getInstance();
    
    public Sight createSight(Sight s){
        dao.insertSight(s);
        return s;
    }
    
    public Sight updateSight(Sight s){
        dao.replaceSight(s, s.getId());
        return s;
    }
    
    public ArrayList<Sight> getSights(){
        return dao.getSights();
    }
    
    public void removeSight(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.removeSight(i);
        }catch(NumberFormatException e){
            return;
        } 
    }

    public Sight getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getSight(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }
    
    public Sight putStyle(String id, String style) {
        int i;
        Sight m;
        try{
            i = Integer.parseInt(id);
            m = dao.getSight(i);
            m.putStyle(style);
            dao.replaceSight(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Sight delStyle(String id) {
        int i;
        Sight m;
        try{
            i = Integer.parseInt(id);
            m = dao.getSight(i);
            m.removeStyle();
            dao.replaceSight(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
}
