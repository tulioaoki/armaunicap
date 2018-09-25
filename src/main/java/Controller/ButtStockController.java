/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ButtStockDao;
import arma.ButtStock;
import java.util.ArrayList;


/**
 *
 * @author zearthur99
 */
public class ButtStockController {
    private ButtStockDao dao = ButtStockDao.getInstance();

    public ButtStock createButtStock(ButtStock s){
        dao.insertItem(s);
        return s;
    }

    public ButtStock updateButtStock(ButtStock s){
        dao.replaceItem(s, s.getId());
        return s;
    }

    public ArrayList<ButtStock> getButtStocks(){
        return dao.getList();
    }

    public void removeButtStock(String id){
        int i;
        try{
            i = Integer.parseInt(id);
            dao.remove(i);
        }catch(NumberFormatException e){
            return;
        }
    }

    public ButtStock getById(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            return dao.getById(i);
        }catch(NumberFormatException e){
            return null;
        }

    }

    public ButtStock putStyle(String id, String style) {
        int i;
        ButtStock m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            m.putStyle(style);
            dao.replaceItem(m, i);
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
            m = dao.getById(i);
            m.removeStyle();
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
}
