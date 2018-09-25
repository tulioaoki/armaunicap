package Controller;
import Dao.SightDao;
import arma.Sight;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class SightController {
    private SightDao dao = SightDao.getInstance();
    
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
    
    public Sight putStyle(String id, String style) {
        int i;
        Sight m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            m.putStyle(style);
            dao.replaceItem(m, i);
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
            m = dao.getById(i);
            m.removeStyle();
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
}
