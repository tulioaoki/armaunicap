/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import arma.Bullet;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author tulioaoki
 */
@ApplicationScoped
public class BulletDao implements DaoBridge<Bullet> {
    private final ArrayList< Bullet> db;
    private static BulletDao instance;

    public static BulletDao getInstance() {
        if (instance == null) {
            instance = new BulletDao();
        }
        return instance;
    }

    private BulletDao() {
        this.db = new ArrayList();
    }

    @Override
    public ArrayList getList() {
        return this.db;
    }

    @Override
    public void insertItem(Bullet s) {
        db.add(s);
    }

    @Override
    public Bullet getById(int id) {
        for (Bullet m : db) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Bullet i = this.getById(id);
        db.remove(i);
    }

    @Override
    public void replaceItem(Bullet newBullet, int id) {
        Bullet oldBullet = this.getById(id);
        int index = db.indexOf(oldBullet);
        db.set(index, newBullet);
    }

    @Override
    public boolean idExists(int id) {
        return this.getById(id) != null;
    }
}
