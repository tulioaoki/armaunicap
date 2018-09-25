/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author zearthur99
 */
@ApplicationScoped
public class SightDao implements DaoBridge<Sight>{
    private final ArrayList<Sight> db;
    private static SightDao instance;

    public static SightDao getInstance(){
        if(instance == null){
            instance = new SightDao();
        }
        return instance;
    }
    
    private SightDao() {
        this.db = new ArrayList<>();
    }

    @Override
    public ArrayList getList() {
        return this.db;
    }

    @Override
    public void insertItem(Sight s) {
        db.add(s);
    }

    @Override
    public Sight getById(int id) {
        for (Sight m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Sight i = this.getById(id);
        db.remove(i);
    }

    @Override
    public void replaceItem(Sight newSight, int id) {
        Sight oldSight = this.getById(id);
        int index = db.indexOf(oldSight);
        db.set(index, newSight);
    }

    @Override
    public boolean idExists(int id) {
        return this.getById(id) != null;
    }

}
