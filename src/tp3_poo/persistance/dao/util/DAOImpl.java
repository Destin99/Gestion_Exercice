/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.persistance.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import tp3_poo.persistance.FilePersistence;
import tp3_poo.persistance.FilePersistenceImpl;

/**
 *
 * @author Moutek
 * @param <T>
 */
public abstract class DAOImpl<T extends Serializable> implements DAO<T> {
    
    protected FilePersistence<T> db = new FilePersistenceImpl<>();
    
    @Override
    public void creer(T model) throws Exception {
        db.creer(model);
    }

    @Override
    public List<T> lire() throws Exception {
        return db.lire(findModelClass());
    }

    @Override
    public List<T> lire(int deb, int nbLignes) throws Exception {
        return db.lire(findModelClass(), deb, nbLignes);
    }
    
    public Class<T> findModelClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
