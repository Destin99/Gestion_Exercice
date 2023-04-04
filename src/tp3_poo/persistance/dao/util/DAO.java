/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.persistance.dao.util;

import java.util.List;

/**
 *
 * @author Moutek
 * @param <T>
 */
public interface DAO<T> {
    
    public void creer(T model) throws Exception;
    
    public List<T> lire() throws Exception;
    
    public List<T> lire(int deb, int nbLignes) throws Exception;
}
