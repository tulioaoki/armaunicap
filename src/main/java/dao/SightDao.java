/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author tulioaoki
 */
@ApplicationScoped
public class SightDao {
    @ApplicationScoped
    private ArrayList<Sight> sights = new ArrayList();
    public SightDao() {
    }
    
    public ArrayList get(){
        return this.sights;
    }
    
    public void insert(Sight s){
        sights.add(s);
    }
    
    public boolean isIn(int id){
        return this.getSight(id) != null;
    }
    
    public Sight getSight(int id){
        for(Sight s: sights){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    
    public void deleteSight(int id){
        Sight sig = this.getSight(id);
        sights.remove(sig);
    }
    
    public void replaceSight(Sight newSight, int id){
        Sight oldSight = this.getSight(id);
        int index = sights.indexOf(oldSight);
        sights.set(index, newSight);
    }
    
}
