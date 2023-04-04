/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moutek
 */
public class SujetExamen implements PossedeExercice, Serializable {

    private String matiere;
    private int annee;
    private List<Exercice> exercices = new ArrayList<>();

    public SujetExamen() {
    }
    
    public SujetExamen(String m, int a, Exercice... exo) {
        this.matiere = m;
        this.annee = a;
        ajouterExercice(exo);
    }

    @Override
    public final void ajouterExercice(Exercice... exos) {
        Exercice.ajouterExercice(exercices, exos);
    }

    public void supprimer(int numero) {
        exercices.remove(numero);
    }

    public String decrire() {
        String result = String.format("Epreuve de %s, (%d)\n\n", matiere, annee);
        for (Exercice e : exercices) {
            result += e + "\n\n";
        }
        return result;
    }

    @Override
    public String toString() {
        return decrire();
    }

    public String getMatiere() {
        return matiere;
    }

    public int getAnnee() {
        return annee;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }
}
