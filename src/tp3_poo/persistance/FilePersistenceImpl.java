/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.persistance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moutek
 * @param <T>
 */
public class FilePersistenceImpl<T extends Serializable> implements FilePersistence<T> {

    private final static String STORE_FILE = "C:\\Users\\FATOU\\Documents\\NetBeansProjects\\TP3_POO\\db.txt";
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    private Object readObject(ObjectInputStream ois) throws Exception {
        try {
            return ois.readObject();
        } catch (EOFException ex) {
            return null;
        }
    }

    @Override
    public void creer(T objet) throws Exception {
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(STORE_FILE))));
            //Nous allons écrire l'objet dans le fichier
            oos.writeObject(objet);
            //Ne pas oublier de fermer le flux !
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Le système de persistance est inaccessible");
        } catch (IOException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erreur lors de l'interraction avec le système de persistance");
        }
    }

    @Override
    public <T> List<T> lire(Class<T> type) throws Exception {
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File(STORE_FILE))));
            List<T> result = new ArrayList<>();
            Object o;
            while ((o = readObject(ois)) != null && (o.getClass().equals(type))) {
                result.add((T) o);
            }
            ois.close();
            return result;
        } catch (EOFException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Aucune donnée disponible...");
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Le système de persistance est inaccessible");
        } catch (IOException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erreur lors de l'interraction avec le système de persistance");
        }
    }

    @Override
    public <T> List<T> lire(Class<T> type, int deb, int nbLignes) throws Exception {
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File(STORE_FILE))));
            List<T> result = new ArrayList(nbLignes);
            Object o;
            int i = 1;
            while (((o = readObject(ois)) != null) && (o.getClass().equals(type)) && ((i - deb) < nbLignes)) {
                if (i++ >= deb) {
                    result.add((T) o);
                }
            }
            ois.close();
            return result;
        } catch (EOFException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Aucune donnée disponible...");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Le système de persistance est inaccessible");
        } catch (IOException ex) {
            Logger.getLogger(FilePersistenceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erreur lors de l'interraction avec le système de persistance");
        }
    }
}
