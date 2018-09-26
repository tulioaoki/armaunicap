package Controller;

import Dao.BulletDao;
import arma.Bullet;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */

public class BulletController {
    private final BulletDao dao = BulletDao.getInstance();
    
    public Bullet createBullet(Bullet s){
        if(dao.idExists(s.getId()) == false){
            dao.insertItem(s);
        return s;
        }
        return null;
    }

    public Bullet updateBullet(String id, Bullet s){
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

    public ArrayList getBullets(){
        return dao.getList();
    }

    public boolean removeBullet(String id){
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

    public Bullet getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getById(i);
        }catch(NumberFormatException e){
            return null;
        }

    }
}