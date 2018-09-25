/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import arma.ButtStock;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author tulioaoki
 */
@ApplicationScoped
public class ButtStockDao implements DaoBridge<ButtStock> {

    private final ArrayList< ButtStock> db;

    private static ButtStockDao instance;

    public static ButtStockDao
            getInstance() {
        if (instance == null) {
            instance = new ButtStockDao();
        }
        return instance;
    }

    private ButtStockDao() {
        this.db = new ArrayList<>();
    }

    @Override
    public ArrayList getList() {
        return this.db;
    }

    @Override
    public void insertItem(ButtStock s) {
        db.add(s);
    }

    @Override
    public ButtStock getById(int id) {
        for (ButtStock m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        ButtStock i = this.getById(id);
        db.remove(i);
    }

    @Override
    public void replaceItem(ButtStock newButtStock, int id) {
        ButtStock oldButtStock = this.getById(id);
        int index = db.indexOf(oldButtStock);
        db.set(index, newButtStock);
    }

    @Override
    public boolean idExists(int id) {
        return this.getById(id) != null;
    }
}
