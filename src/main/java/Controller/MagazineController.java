package Controller;

import Dao.Dao;
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
    Dao dao = Dao.getInstance();

    public Magazine createMagazine(Magazine s){
        dao.insertMagazine(s);
        return s;
    }
    
    public Magazine updateMagazine(Magazine s){
        dao.replaceMagazine(s, s.getId());
        return s;
    }
    
    public ArrayList<Magazine> getMagazines(){
        return dao.getMagazines();
    }
    
    public void removeMagazine(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.removeMagazine(i);
        }catch(NumberFormatException e){
            return;
        } 
    }

    public Magazine getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getMagazine(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }

    public Magazine addCompatibility(String id, String bullet) {
        int i;
        int ib;
        Magazine m;
        try{
            i = Integer.parseInt(id);
            ib = Integer.parseInt(bullet);
            m = dao.getMagazine(i);
            Bullet b = dao.getBullet(ib);
            m.addCompatibility(b);
            dao.replaceMagazine(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Magazine load(String id, String bullet){
        int i;
        int ib;
        Magazine m;
        try{
            i = Integer.parseInt(id);
            ib = Integer.parseInt(bullet);
            m = dao.getMagazine(i);
            Bullet b = dao.getBullet(ib);
            m.load(b);
            dao.replaceMagazine(m, i);
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
            m = dao.getMagazine(i);
            m.unload();
            dao.replaceMagazine(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }

    public Magazine putStyle(String id, String style) {
        int i;
        Magazine m;
        try{
            i = Integer.parseInt(id);
            m = dao.getMagazine(i);
            m.putStyle(style);
            dao.replaceMagazine(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Magazine delStyle(String id) {
        int i;
        Magazine m;
        try{
            i = Integer.parseInt(id);
            m = dao.getMagazine(i);
            dao.replaceMagazine(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
}


