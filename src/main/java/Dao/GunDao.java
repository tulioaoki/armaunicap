package Dao;
import arma.Gun;

import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */
public class GunDao implements DaoBridge<Gun> {

    private final ArrayList<Gun> db;

    private static GunDao instance;

    public static GunDao getInstance(){
        if(instance != null){
            instance = new GunDao();
        }
        return instance;
    }

    private GunDao() {
        this.db = new ArrayList<>();
    }

    @Override
    public ArrayList getList() {
        return this.db;
    }

    @Override
    public void insertItem(Gun s) {
        db.add(s);
    }

    @Override
    public Gun getById(int id) {
        for (Gun m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Gun i = this.getById(id);
        db.remove(i);
    }

    @Override
    public void replaceItem(Gun newGun, int id) {
        Gun oldGun = this.getById(id);
        int index = db.indexOf(oldGun);
        db.set(index, newGun);
    }

    @Override
    public boolean idExists(int id) {
        return this.getById(id) != null;
    }
}
