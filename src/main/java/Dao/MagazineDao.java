/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import arma.Magazine;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author zearthur99
 */
@ApplicationScoped
public class MagazineDao implements DaoBridge<Magazine>{
    
    private final ArrayList<Magazine> db;

    private static MagazineDao instance;

    public static MagazineDao getInstance(){
        if(instance == null){
            instance = new MagazineDao();
        }
        return instance;
    }
    
    private MagazineDao() {
        this.db = new ArrayList<>();
    }

    @Override
    public ArrayList getList() {
        return this.db;
    }

    @Override
    public void insertItem(Magazine s) {
        db.add(s);    
    }
    

    @Override
    public Magazine getById(int id) {
        for (Magazine m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Magazine mag = this.getById(id);
        db.remove(mag);
    }

    @Override
    public void replaceItem(Magazine newMagazines, int id) {
        Magazine oldMagazines = this.getById(id);
        int index = db.indexOf(oldMagazines);
        db.set(index, newMagazines);
    }

    @Override
    public boolean idExists(int id) {
        return this.getById(id) != null;
    }

}
