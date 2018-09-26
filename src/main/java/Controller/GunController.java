/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.GunDao;
import arma.Barrel;
import arma.ButtStock;
import arma.Gun;
import arma.Magazine;
import arma.Sight;
import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */
public class GunController {

    private GunDao dao = GunDao.getInstance();
    private BarrelController barrels;
    private ButtStockController bt;
    private MagazineController magazines;
    private SightController sights;

    public GunController() {
        barrels = new BarrelController();
        bt = new ButtStockController();
        magazines = new MagazineController();
        sights = new SightController();
    }

    
    public Gun createGun(Gun s) {
        if(dao.idExists(s.getId()) == false){
            dao.insertItem(s);
        return s;
        }
        return null;
    }

    public Gun updateGun(Gun s, String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getById(g);
            gun.setName(s.getName());
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }

    public ArrayList< Gun> getList() {
        return dao.getList();
    }

    public boolean remove(String id) {
        int i;
        try{
            i = Integer.parseInt(id);
            if(this.getById(id) != null){
                dao.remove(i);
                return true;
            }
            return false;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public Gun getById(String id) {
        int i;
        try {
            i = Integer.parseInt(id);
            return dao.getById(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    
    //COMPATIBILITY ITENS
    
    public Gun addCompatibilityBarrel(String id, String item) {
        int i;
        Gun m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            Barrel b = barrels.getById(item);
            m.addCompatibility(b);
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun addCompatibilityBt(String id, String item) {
        int i;
        Gun m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            ButtStock b = bt.getById(item);
            m.addCompatibility(b);
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun addCompatibilityMagazine(String id, String item) {
        int i;
        Gun m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            Magazine b = magazines.getById(item);
            m.addCompatibility(b);
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun addCompatibilitySight(String id, String item) {
        int i;
        Gun m;
        try{
            i = Integer.parseInt(id);
            m = dao.getById(i);
            Sight b = sights.getById(item);
            m.addCompatibility(b);
            dao.replaceItem(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    //PUT ITENS
    public Gun putBarrel(String id, String item) {
        int g;
        Gun gun;
        Barrel it;
        try{
            g = Integer.parseInt(id);
            it = barrels.getById(item);
            gun = dao.getById(g);
            gun.setBarrel(it);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun putButtStock(String id, String item) {
        int g;
        Gun gun;
        ButtStock it;
        try{
            g = Integer.parseInt(id);
            it = bt.getById(item);
            gun = dao.getById(g);
            gun = gun.setButtstock(it);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun putMagazine(String id, String item) {
        int g;
        Gun gun;
        Magazine it;
        try{
            g = Integer.parseInt(id);
            it = magazines.getById(item);
            gun = dao.getById(g);
            gun = gun.setMagazine(it);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun putSight(String id, String item) {
        int g;
        Gun gun;
        Sight it;
        try{
            g = Integer.parseInt(id);
            it = sights.getById(item);
            gun = dao.getById(g);
            gun = gun.setSight(it);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    //END PUT ITENS
    
    //DEL ITENS
    public Gun delBarrel(String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getById(g);
            gun = gun.setBarrel(null);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun delButtStock(String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getById(g);
            gun = gun.setButtstock(null);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun delMagazine(String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getById(g);
            gun = gun.setMagazine(null);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun delSight(String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getById(g);
            gun = gun.setSight(null);
            dao.replaceItem(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    //END
    
    
}
