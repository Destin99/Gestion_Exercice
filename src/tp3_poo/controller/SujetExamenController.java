/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import tp3_poo.controller.ext.Message;
import tp3_poo.db.DataBase;
import tp3_poo.model.Exercice;
import tp3_poo.model.SujetExamen;

/**
 *
 * @author Moutek
 */
public class SujetExamenController {
    
    private SujetExamen formObject;
    private Exercice addObject;
    private Message message;

    public SujetExamenController() {
        effacer();
    }
    
    public final void effacer() {
        this.formObject = null;
        this.addObject = null;
        this.message = new Message("", Message.Type.INFO);
    }
    
    public void ajouter() {
        formObject.ajouterExercice(addObject);
    }
    
    public void enregistrer() {
        try {
            DataBase.create(formObject);
            message = new Message("Succès de l'enregistrement", Message.Type.INFO);
        } catch (Exception ex) {
            message = new Message("Erreur lors de l'enregistrement; Raison : "+ex.getMessage(), Message.Type.INFO);
            Logger.getLogger(SujetExamenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SujetExamen getFormObject() {
        return formObject;
    }

    public void setFormObject(SujetExamen formObject) {
        this.formObject = formObject;
    }

    public Exercice getAddObject() {
        return addObject;
    }

    public void setAddObject(Exercice addObject) {
        this.addObject = addObject;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    
}
