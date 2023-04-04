/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Moutek
 */
public abstract class Exercice implements Serializable {

    protected int numero;

    public Exercice() {

    }

    public Exercice(int num) {
        this.numero = num;
    }

    public abstract String afficher();
    
    public abstract int getDuree();

    public abstract float calculerBareme();

    public boolean egal(Exercice e) {
        return equals(e);
    }

    public static void ajouterExercice(List<Exercice> exercices, Exercice... exos) {
        for (Exercice exo : exos) {
            boolean t = false;
            if (!exercices.contains(exo)) {
                for (Exercice e : exercices) {
                    if (e instanceof ExerciceComplexe && ((ExerciceComplexe)e).getExercices().contains(e)) {
                        t = true;
                        break;
                    }
                }
            }
            else {
                t = true;
            }
            if (!t) {
                exo.setNumero(exercices.size() + 1);
                exercices.add(exo);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exercice other = (Exercice) obj;
        return this.numero == other.numero;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.numero;
        return hash;
    }

    @Override
    public String toString() {
        return afficher();
    }
    
    public void setNumero(int n) {
        this.numero = n;
    }

    public int getNumero() {
        return numero;
    }
}
