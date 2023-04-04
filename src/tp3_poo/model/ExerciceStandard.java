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
public class ExerciceStandard extends ExerciceSimple {

    private int cotation = 3;
    private String annexe;

    public ExerciceStandard(String e, int d, String a) {
        super(e, d);
        this.annexe = a;
    }

    public int getCotation() {
        return cotation;
    }

    public String getAnnexe() {
        return annexe;
    }

    public void setAnnexe(String annexe) {
        this.annexe = annexe;
    }

    public void setCotation(int cotation) {
        this.cotation = cotation;
    }

    @Override
    public String afficher() {
        return String.format("%s\nANNEXE :\n%s", super.afficher(), annexe);
    }

    @Override
    public float calculerBareme() {
        return Math.round(cotation * Math.log(1 + duree));
    }

}
