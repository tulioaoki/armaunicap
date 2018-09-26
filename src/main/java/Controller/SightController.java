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
        if(dao.idExists(s.getId()) == false){
            dao.insertItem(s);
        return s;
        }
        return null;
    }
    
    public Sight updateSight(String id,Sight s){
        int i = Integer.parseInt(id);
        try{
            if(dao.getById(i) == null){
                return null;
            }
            dao.replaceItem(s, s.getId());
            return s;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public ArrayList<Sight> getSights(){
        return dao.getList();
    }
    
    public boolean removeSight(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            if(this.getById(id) != null){
                dao.remove(i);
                return true;
            }
            return false;
        }catch(NumberFormatException e){
            return false;
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
