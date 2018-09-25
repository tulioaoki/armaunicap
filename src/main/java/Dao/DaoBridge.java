/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author zearthur99
 * @param <T> Tipo do DAOBridge
 */
@ApplicationScoped
public interface DaoBridge<T> {
    public ArrayList getList();
    public void insertItem(T s);
    public boolean idExists(int id);
    public T getById(int id);
    public void remove(int id);
    public void replaceItem(T newItem, int id);
}
