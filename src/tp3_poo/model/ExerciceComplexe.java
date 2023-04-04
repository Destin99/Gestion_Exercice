/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moutek
 */
public class ExerciceComplexe extends Exercice implements PossedeExercice {

    private final List<Exercice> exercices = new ArrayList<>();

    public ExerciceComplexe() {
        super();
    }
    public ExerciceComplexe(Exercice... exos) {// on peut mettre autant d'exercices qu'on veut
        ajouterExercice(exos);
    }

    @Override
    public final void ajouterExercice(Exercice... exos) {
        Exercice.ajouterExercice(exercices, exos);
    }

    @Override
    public int getDuree() {
        int result = 0;
        for (Exercice exo : exercices) {
            result = result + exo.getDuree();
        }
        return result;
    }

    @Override
    public String afficher() {
        String result = String.format("Exercice %d (%.2f pts, %d min)\n", numero, calculerBareme(), getDuree());
        result = exercices.stream().map((exo) -> exo + "\n").reduce(result, String::concat);
        return result;
    }

    /*for(Exercice exo : exercice){
    result += "\t"+exo+"\n";
    }
     */
    @Override
    public float calculerBareme() {
        float result = 0F;
        for (Exercice e : exercices) {
            result = result + e.calculerBareme();
        }
        return result;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

}
