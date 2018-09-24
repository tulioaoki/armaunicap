package Dao;

import arma.Barrel;
import arma.Bullet;
import arma.ButtStock;
import arma.Gun;
import arma.Magazine;
import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
@author tulioaoki
**/

@ApplicationScoped

public class Dao {

    private static Dao mInstance;
    private final ArrayList< Sight> sights;
    private final ArrayList< Barrel> barrels;
    private final ArrayList< Bullet> bullets;
    private final ArrayList< ButtStock> buttstocks;
    private final ArrayList< Magazine> magazines;
    private final ArrayList< Gun> guns;

    public static Dao getInstance() {
        if (mInstance == null) {
            mInstance = new Dao();
        }

        return mInstance;
    }

    private Dao() {
        sights = new ArrayList();
        barrels = new ArrayList();
        bullets = new ArrayList();
        buttstocks = new ArrayList();
        magazines = new ArrayList();
        guns = new ArrayList();
    }

// SIGHTS ** ** ** ** ** ** ** ** ** ** ** ** **
    public ArrayList getSights() {
        return this.sights;
    }

    public void insertSight(Sight s) {
        sights.add(s);
    }

    public boolean SightIsIn(int id) {
        return this.getSight(id) != null;
    }

    public Sight getSight(int id) {
        for (Sight s : sights) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void removeSight(int id) {
        Sight sig = this.getSight(id);
        sights.remove(sig);
    }

    public void replaceSight(Sight newSight, int id) {
        Sight oldSight = this.getSight(id);
        int index = sights.indexOf(oldSight);
        sights.set(index, newSight);
    }

// END SIGHTS  ** ** ** ** ** ** ** ** ** *
// MAGAZINES ** ** ** ** ** ** ** ** **
public ArrayList getMagazines() {
        return this.magazines;
    }

    public void insertMagazine(Magazine s) {
        magazines.add(s);
    }

    public boolean MagazinesIsIn(int id) {
        return this.getMagazine(id) != null;
    }

    public Magazine getMagazine(int id) {
        for (Magazine m : magazines) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void removeMagazine(int id) {
        Magazine mag = this.getMagazine(id);
        magazines.remove(mag);
    }

    public void replaceMagazine(Magazine newMagazines, int id) {
        Magazine oldMagazines = this.getMagazine(id);
        int index = magazines.indexOf(oldMagazines);
        magazines.set(index, newMagazines);
    }

// END MAGAZINES** ** ** ** ** ** **
// BULLETS ** ** ** ** *
public ArrayList getBullets() {
        return this.bullets;
    }

    public void  insertBullet(Bullet s) {
        bullets.add(s);
    }

    public boolean BulletsIsIn(int id) {
        return this.getBullet(id) != null;
    }

    public Bullet getBullet(int id) {
        for (Bullet m : bullets) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void removeBullet(int id) {
        Bullet mag = this.getBullet(id);
        bullets.remove(mag);
    }

    public void replaceBullets(Bullet newBullets, int id) {
        Bullet oldBullets = this.getBullet(id);
        int index = bullets.indexOf(oldBullets);
        bullets.set(index, newBullets);
    }
// END BULLETS 

// Barrels ** ** ** ** ** ** ** **


    public ArrayList getBarrels() {
        return this.barrels;
    }

    public void insertBarrel(Barrel s) {
        barrels.add(s);
    }

    public boolean BarrelsIsIn(int id) {
        return this.getBarrel(id) != null;
    }

    public Barrel getBarrel(int id) {
        for (Barrel m : barrels) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void removeBarrel(int id) {
        Barrel mag = this.getBarrel(id);
        barrels.remove(mag);
    }

    public void replaceBarrels(Barrel newBarrels, int id) {
        Barrel oldBarrels = this.getBarrel(id);
        int index = barrels.indexOf(oldBarrels);
        barrels.set(index, newBarrels);
    }
// END BARRELS** ** ** ** ** ** ** ** ** **

// BUTTSTOCK ** ** ** ** ** ** ** ** ** ** *
    public ArrayList getButtStocks() {
        return this.buttstocks;
    }

    public void insertButtStock(ButtStock s) {
        buttstocks.add(s);
    }

    public boolean ButtStocksIsIn(int id) {
        return this.getButtStock(id) != null;
    }

    public ButtStock getButtStock(int id) {
        for (ButtStock m : buttstocks) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void removeButtStock(int id) {
        ButtStock mag = this.getButtStock(id);
        buttstocks.remove(mag);
    }

    public void replaceButtStock(ButtStock newButtStocks, int id) {
        ButtStock oldButtStocks = this.getButtStock(id);
        int index = buttstocks.indexOf(oldButtStocks);
        buttstocks.set(index, newButtStocks);
    }

// END BUTTSTOCK
}
