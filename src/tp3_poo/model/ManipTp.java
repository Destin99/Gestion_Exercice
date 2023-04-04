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
public class ManipTp extends ExerciceSimple {

    private float courbe[];

    public ManipTp(String e, int d, float courbe[]) {
        super(e, d);
        this.courbe = courbe;
    }

    public float[] getCourbe() {
        return courbe;
    }

    public void setCourbe(float[] courbe) {
        this.courbe = courbe;
    }

    @Override
    public String afficher() {
        return String.format("%s\nCOURBE :\n%s",super.afficher(),Float.toString(courbe[1]));
    }

    @Override
    public float calculerBareme() {
        return (float) (Math.sqrt(2 * duree) - 0.5D);
    }

}
