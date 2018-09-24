/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao;
import arma.Barrel;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class BarrelController {
    Dao dao = Dao.getInstance();
    
    public Barrel createBarrel(Barrel s){
        dao.insertBarrel(s);
        return s;
    }
    
    public Barrel updateBarrel(Barrel s){
        dao.replaceBarrel(s, s.getId());
        return s;
    }
    
    public ArrayList<Barrel> getBarrels(){
        return dao.getBarrels();
    }
    
    public void removeBarrel(Integer id){
        dao.removeBarrel(id);
    }
}
