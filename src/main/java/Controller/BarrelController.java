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
        dao.insertItem(s);
        return s;
    }

    public Barrel updateBarrel(Barrel s){
        dao.replaceItem(s, s.getId());
        return s;
    }

    public ArrayList<Barrel> getBarrels(){
        return dao.getList();
    }

    public void removeBarrel(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.remove(i);
        }catch(NumberFormatException e){
            return;
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
