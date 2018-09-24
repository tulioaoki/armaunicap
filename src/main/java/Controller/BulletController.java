package Controller;

import Dao.Dao;
import arma.Bullet;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class BulletController {
    Dao dao = Dao.getInstance();
    
    public Bullet createBullet(Bullet s){
        dao.insertBullet(s);
        return s;
    }
    
    public Bullet getSight(int id){
        return dao.getBullet(id);
    }
    
    public Bullet updateBullet(Bullet s){
        dao.replaceBullet(s, s.getId());
        return s;
    }
    
    public ArrayList<Bullet> getBullets(){
        return dao.getBullets();
    }
    
    public void removeBullet(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.removeBullet(i);
        }catch(NumberFormatException e){
            return;
        }
    }
    
    public Bullet getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getBullet(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }
    
}