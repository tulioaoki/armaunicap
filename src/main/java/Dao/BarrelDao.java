/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import arma.Barrel;
import java.util.ArrayList;

/**
 *
 * @author zearthur99
 */
public class BarrelDao implements DaoBridge<Barrel>{
    
    private final ArrayList<Barrel> db;

    private static BarrelDao instance;

    public static BarrelDao getInstance(){
        if(instance != null){
            instance = new BarrelDao();
        }
        return instance;
    }
    
    private BarrelDao() {
        this.db = new ArrayList<>();
    }

    @Override
    public ArrayList getList() {
        return this.db;
    }

    @Override
    public void insertItem(Barrel s) {
        db.add(s);
    }

    @Override
    public Barrel getById(int id) {
        for (Barrel m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Barrel i = this.getById(id);
        db.remove(i);
    }

    @Override
    public void replaceItem(Barrel newBarrel, int id) {
        Barrel oldBarrel = this.getById(id);
        int index = db.indexOf(oldBarrel);
        db.set(index, newBarrel);
    }

    @Override
    public boolean idExists(int id) {
        return this.getById(id) != null;
    }

}
