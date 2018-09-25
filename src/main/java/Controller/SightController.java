package Controller;
import Dao.SightDao;
import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;


/**
 *
 * @author zearthur99
 */
@ApplicationScoped
public class SightController {
    private SightDao dao = SightDao.getInstance();

    public SightController() {
    }
    
    public Sight createSight(Sight s){
        dao.insertItem(s);
        return s;
    }
    
    public Sight updateSight(Sight s){
        dao.replaceItem(s, s.getId());
        return s;
    }
    
    public ArrayList<Sight> getSights(){
        return dao.getList();
    }
    
    public void removeSight(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.remove(i);
        }catch(NumberFormatException e){
            return;
        } 
    }

    public Sight getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getById(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }
}
