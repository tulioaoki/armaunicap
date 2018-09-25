package Controller;

import Dao.MagazineDao;
import arma.Bullet;
import arma.Magazine;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author tulioaoki
 */
@ApplicationScoped
public class MagazineController {
    private MagazineDao dao = MagazineDao.getInstance();

    public Magazine createMagazine(Magazine s){
        dao.insertItem(s);
        return s;
    }
    
    public Magazine updateMagazine(Magazine s){
        dao.replaceItem(s, s.getId());
        return s;
    }
    
    public ArrayList<Magazine> getMagazines(){
        return dao.getList();
    }
    
    public void removeMagazine(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.remove(i);
        }catch(NumberFormatException e){
            return;
        } 
    }

    public Magazine getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getById(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }

    public Magazine addCompatibility(String id, String bullet) {
        int i;
        BulletController bc = new BulletController();
        Magazine m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            Bullet b = bc.getById(bullet);
            m.addCompatibility(b);
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Magazine load(String id, String bullet){
        int i;
        BulletController bc = new BulletController();
        Magazine m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            Bullet b = bc.getById(bullet);
            m.load(b);
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }

    }

    public Magazine unload(String id) {
        int i;
        Magazine m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            m.unload();
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }

    }
}


