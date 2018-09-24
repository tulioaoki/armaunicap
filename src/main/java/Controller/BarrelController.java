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
    
    public void removeBarrel(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.removeBarrel(i);
        }catch(NumberFormatException e){
            return;
        }
    }
    
    public Barrel getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getBarrel(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }
    
    public Barrel putStyle(String id, String style) {
        int i;
        Barrel m;
        try{
            i = Integer.parseInt(id);
            m = dao.getBarrel(i);
            m.putStyle(style);
            dao.replaceBarrel(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Barrel delStyle(String id) {
        int i;
        Barrel m;
        try{
            i = Integer.parseInt(id);
            m = dao.getBarrel(i);
            m.removeStyle();
            dao.replaceBarrel(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
}
