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
    
    public void removeSight(Integer id){
        dao.removeSight(id);
    }
}
