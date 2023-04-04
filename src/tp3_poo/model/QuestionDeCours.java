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
public class QuestionDeCours extends ExerciceSimple {

    private int cotation = 2;

    public QuestionDeCours(String e, int d) {
        super(e, d);
    }

    public int getCotation() {
        return cotation;
    }

    public void setCotation(int cotation) {
        this.cotation = cotation;
    }

    @Override
    public float calculerBareme() {
        return (float) cotation;
    }

}
