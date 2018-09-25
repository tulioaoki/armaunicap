package Controller;

import Dao.BulletDao;
import arma.Bullet;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class BulletController {
    private BulletDao dao = BulletDao.getInstance();

    public Bullet createBullet(Bullet s){
        dao.insertItem(s);
        return s;
    }

    public Bullet updateBullet(Bullet s){
        dao.replaceItem(s, s.getId());
        return s;
    }

    public ArrayList<Bullet> getBullets(){
        return dao.getList();
    }

    public void removeBullet(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.remove(i);
        }catch(NumberFormatException e){
            return;
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