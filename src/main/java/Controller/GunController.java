/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao;
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

    Dao dao = Dao.getInstance();

    public Gun createGun(Gun s) {
        dao.insertGun(s);
        return s;
    }

    public Gun updateGun(Gun s, String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getGun(g);
            gun.setName(s.getName());
            dao.replaceGun(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }

    public ArrayList< Gun> getGuns() {
        return dao.getGuns();
    }

    public void removeGun(String id) {
        int i;
        try {
            i = Integer.parseInt(id);
            dao.removeGun(i);
        } catch (NumberFormatException e) {
            return;
        }
    }

    public Gun getById(String id) {
        int i;
        try {
            i = Integer.parseInt(id);
            return dao.getGun(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Gun putStyle(String id, String style) {
        int i;
        Gun m;
        try {
            i = Integer.parseInt(id);
            m = dao.getGun(i);
            m.putStyle(style);
            dao.replaceGun(m, i);
            return m;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Gun delStyle(String id) {
        int i;
        Gun m;
        try {
            i = Integer.parseInt(id);
            m = dao.getGun(i);
            m.removeStyle();
            dao.replaceGun(m, i);
            return m;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    //COMPATIBILITY ITENS
    
    public Gun addCompatibilityBarrel(String id, String item) {
        int i;
        int ib;
        Gun m;
        try{
            i = Integer.parseInt(id);
            ib = Integer.parseInt(item);
            m = dao.getGun(i);
            Barrel b = dao.getBarrel(ib);
            m.addCompatibility(b);
            dao.replaceGun(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun addCompatibilityBt(String id, String item) {
        int i;
        int ib;
        Gun m;
        try{
            i = Integer.parseInt(id);
            ib = Integer.parseInt(item);
            m = dao.getGun(i);
            ButtStock b = dao.getButtStock(ib);
            m.addCompatibility(b);
            dao.replaceGun(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun addCompatibilityMagazine(String id, String item) {
        int i;
        int ib;
        Gun m;
        try{
            i = Integer.parseInt(id);
            ib = Integer.parseInt(item);
            m = dao.getGun(i);
            Magazine b = dao.getMagazine(ib);
            m.addCompatibility(b);
            dao.replaceGun(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun addCompatibilitySight(String id, String item) {
        int i;
        int ib;
        Gun m;
        try{
            i = Integer.parseInt(id);
            ib = Integer.parseInt(item);
            m = dao.getGun(i);
            Sight b = dao.getSight(ib);
            m.addCompatibility(b);
            dao.replaceGun(m, i);
            return m;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    //PUT ITENS
    public Gun putBarrel(String id, String item) {
        int i,g;
        Gun gun;
        Barrel it;
        try{
            i = Integer.parseInt(item);
            g = Integer.parseInt(id);
            it = dao.getBarrel(i);
            gun = dao.getGun(g);
            gun = gun.setBarrel(it);
            dao.replaceGun(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun putButtStock(String id, String item) {
        int i,g;
        Gun gun;
        ButtStock it;
        try{
            i = Integer.parseInt(item);
            g = Integer.parseInt(id);
            it = dao.getButtStock(i);
            gun = dao.getGun(g);
            gun = gun.setButtstock(it);
            dao.replaceGun(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun putMagazine(String id, String item) {
        int i,g;
        Gun gun;
        Magazine it;
        try{
            i = Integer.parseInt(item);
            g = Integer.parseInt(id);
            it = dao.getMagazine(i);
            gun = dao.getGun(g);
            gun = gun.setMagazine(it);
            dao.replaceGun(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    public Gun putSight(String id, String item) {
        int i,g;
        Gun gun;
        Sight it;
        try{
            i = Integer.parseInt(item);
            g = Integer.parseInt(id);
            it = dao.getSight(i);
            gun = dao.getGun(g);
            gun = gun.setSight(it);
            dao.replaceGun(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    
    //END PUT ITENS
    public Gun delBarrel(String id) {
        int g;
        Gun gun;
        try{
            g = Integer.parseInt(id);
            gun = dao.getGun(g);
            gun = gun.setBarrel(null);
            dao.replaceGun(gun, g);
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
            gun = dao.getGun(g);
            gun = gun.setButtstock(null);
            dao.replaceGun(gun, g);
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
            gun = dao.getGun(g);
            gun = gun.setMagazine(null);
            dao.replaceGun(gun, g);
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
            gun = dao.getGun(g);
            gun = gun.setSight(null);
            dao.replaceGun(gun, g);
            return gun;
        }catch(NumberFormatException e){
            return null;
        }
    }
    //DEL ITENS
    
    //END
    
    
}
