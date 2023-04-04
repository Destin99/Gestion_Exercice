/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.model;

/**
 *
 * @author Moutek
 */
public abstract class ExerciceSimple extends Exercice {

    protected String enonce;
    protected int duree;

    public ExerciceSimple(String e, int d) {
        super();
        this.enonce = e;
        this.duree = d;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }
    
    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    @Override
    public int getDuree() {
        return duree;
    }

    @Override
    public String afficher() {
        return String.format("Exercice %d (%.2f pts, %d min)\n %s", numero, calculerBareme(), duree, enonce);
    }
}
