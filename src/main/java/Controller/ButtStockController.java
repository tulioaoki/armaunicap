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
    
    public void removeButtStock(Integer id){
        dao.removeButtStock(id);
    }
}
