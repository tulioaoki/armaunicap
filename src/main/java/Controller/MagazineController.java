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
        if(dao.idExists(s.getId()) == false){
            dao.insertItem(s);
        return s;
        }
        return null;
    }
    
    public Magazine updateMagazine(String id,Magazine s){
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
    
    public ArrayList<Magazine> getMagazines(){
        return dao.getList();
    }
    
    public boolean removeMagazine(String id){
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
            if(b == null){
                return null;
            }
            if(m.load(b)){
                dao.replaceItem(m, i);
                return m;
            }else{
                return null;
            }
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


