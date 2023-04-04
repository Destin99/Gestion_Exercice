/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.persistance;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gyldas_atta_kouassi
 * @param <T>
 */
public interface FilePersistence<T extends Serializable> {
    
    public void creer(T objet) throws Exception;
    
    public <T> List<T> lire(Class<T> type) throws Exception;
    
    public <T> List<T> lire(Class<T> type, int deb, int nbLignes) throws Exception;
}
