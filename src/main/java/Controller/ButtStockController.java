/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao;
import arma.ButtStock;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class ButtStockController {
    Dao dao = Dao.getInstance();
    
    public ButtStock createButtStock(ButtStock s){
        dao.insertButtStock(s);
        return s;
    }
    
    public ButtStock updateButtStock(ButtStock s){
        dao.replaceButtStock(s, s.getId());
        return s;
    }
    
    public ArrayList<ButtStock> getButtStocks(){
        return dao.getButtStocks();
    }
    
    public ButtStock getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getButtStock(i);
        }catch(NumberFormatException e){
            return null;
        }
        
    }
    
    public void removeButtStock(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.removeButtStock(i);
        }catch(NumberFormatException e){
            return;
        }   
    }
    
    public ButtStock putStyle(String id, String style) {
        int i;
        ButtStock m;
        try{
            i = Integer.parseInt(id);
            m = dao.getButtStock(i);
            m.putStyle(style);
            dao.replaceButtStock(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public ButtStock delStyle(String id) {
        int i;
        ButtStock m;
        try{
            i = Integer.parseInt(id);
            m = dao.getButtStock(i);
            m.removeStyle();
            dao.replaceButtStock(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
}
