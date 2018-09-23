/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import arma.Sight;
import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */
public class SightDao {
    private ArrayList<Sight> sights = new ArrayList();

    public SightDao() {
    }
    
    public void insert(Sight s){
        sights.add(s);
    }
    
    public void getSight(int id){
        
    }
    
    public void deleteSight(int id){
        
    }
    
    public void replaceSight(){
        
    }
    
}
