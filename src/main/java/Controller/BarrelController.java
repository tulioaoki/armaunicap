/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.BarrelDao;
import arma.Barrel;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class BarrelController {
    private BarrelDao dao = BarrelDao.getInstance();

    public BarrelController() {
    }
    
    public Barrel createBarrel(Barrel s){
        if(dao.idExists(s.getId()) == false){
            dao.insertItem(s);
        return s;
        }
        return null;
    }

    public Barrel updateBarrel(String id, Barrel s){
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

    public ArrayList<Barrel> getBarrels(){
        return dao.getList();
    }

    public boolean removeBarrel(String id){
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

    public Barrel getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getById(i);
        }catch(NumberFormatException e){
            return null;
        }

    }
}
