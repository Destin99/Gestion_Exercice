/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.view;

import java.awt.Component;
import javax.swing.SpinnerNumberModel;
import tp3_poo.model.Exercice;
import tp3_poo.model.ExerciceComplexe;
import tp3_poo.model.ExerciceSimple;
import tp3_poo.model.ExerciceStandard;
import tp3_poo.model.ManipTp;
import tp3_poo.model.PossedeExercice;
import tp3_poo.model.QuestionDeCours;

/**
 *
 * @author Moutek
 */
public class AjouterExoView extends javax.swing.JFrame {

    private final PossedeExercice possedeExercice;
    private Exercice exercice;
    private SujetExamenView sujetExamenView;

    /**
     * Creates new form SacView
     *
     * @param possedeExercice
     */
    public AjouterExoView(PossedeExercice possedeExercice) {
        initComponents();
        setLocationRelativeTo(null);
        this.possedeExercice = possedeExercice;
        typeExoValueChangeAction(typeExoComboBox.getSelectedItem());
    }

    public AjouterExoView(PossedeExercice possedeExercice, SujetExamenView sujetExamenView) {
        this(possedeExercice);
        this.sujetExamenView = sujetExamenView;
    }

    public final void typeExoValueChangeAction(Object newValue) {
        if (newValue.equals("Standard")) {
            //Définition de valeurs
            exercice = new ExerciceStandard(
                    enonceJTextArea.getText(),
                    (Integer) dureeSpinner.getValue(),
                    annexeJTextArea.getText());
            cotationJSpinner.setValue(((ExerciceStandard) exercice).getCotation());
            //Activer les composants nécessaires
            enonceJTextArea.setEditable(true);
            dureeSpinner.setEnabled(true);
            annexeJTextArea.setEditable(true);
            cotationJSpinner.setEnabled(true);
            //Désactiver les composants non nécessaires
            courbeFTextField.setEditable(false);
            ajouterButton.setEnabled(false);
        } else if (newValue.equals("QuestionDeCours")) {
            //Définition de valeurs
            exercice = new QuestionDeCours(
                    enonceJTextArea.getText(),
                    (Integer) dureeSpinner.getValue());
            cotationJSpinner.setValue(((QuestionDeCours) exercice).getCotation());
            //Activer les composants nécessaires
            enonceJTextArea.setEditable(true);
            dureeSpinner.setEnabled(true);
            cotationJSpinner.setEnabled(true);
            //Désactiver les composants non nécessaires
            courbeFTextField.setEditable(false);
            annexeJTextArea.setEditable(false);
            ajouterButton.setEnabled(false);
        } else if (newValue.equals("ManipTP")) {
            //Définition de valeurs
            exercice = new ManipTp(
                    enonceJTextArea.getText(),
                    (Integer) dureeSpinner.getValue(),
                    parseFloatTab(courbeFTextField.getText()));
            //Activer les composants nécessaires
            enonceJTextArea.setEditable(true);
            dureeSpinner.setEnabled(true);
            courbeFTextField.setEditable(true);
            //Désactiver les composants non nécessaires
            annexeJTextArea.setEditable(false);
            cotationJSpinner.setEnabled(false);
            ajouterButton.setEnabled(false);
        } else if (newValue.equals("ExoComplexe")) {
            exercice = new ExerciceComplexe();
            //TODO: Désactiver les composants nécessaires
            //Activer les composants nécessaires
            ajouterButton.setEnabled(true);
            //Désactiver les composants non nécessaires
            annexeJTextArea.setEditable(false);
            cotationJSpinner.setEnabled(false);
            enonceJTextArea.setEditable(false);
            dureeSpinner.setEnabled(false);
            courbeFTextField.setEditable(false);
        }
        dureeSpinner.setModel(new SpinnerNumberModel(0, 0, 7200, 1));
        cotationJSpinner.setModel(new SpinnerNumberModel(0, 0, 20, 1));
        calculer();
    }

    private void calculer() {
        baremeFTextField1.setText(String.valueOf(exercice.calculerBareme()));
    }

    private float[] parseFloatTab(String expression) {
        if (expression != null && !expression.isEmpty()) {
            String[] strings = expression.split(",");
            float[] result = new float[strings.length];
            int i = 0;
            for (String s : strings) {
                result[i++] = Float.parseFloat(s);
            }
            return result;
        } else {
            return null;
        }
    }

    @Override
    public final void setLocationRelativeTo(Component c) {
        super.setLocationRelativeTo(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        effacerButton = new javax.swing.JButton();
        ajouterButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        numeroLabel = new javax.swing.JLabel();
        dureeSpinner = new javax.swing.JSpinner();
        poidsLabel = new javax.swing.JLabel();
        envoiLabel = new javax.swing.JLabel();
        typeExoComboBox = new javax.swing.JComboBox<>();
        dateReceptionLabel = new javax.swing.JLabel();
        courbeFTextField = new javax.swing.JFormattedTextField();
        numeroLabel1 = new javax.swing.JLabel();
        cotationJSpinner = new javax.swing.JSpinner();
        dateReceptionLabel1 = new javax.swing.JLabel();
        baremeFTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        enonceJTextArea = new javax.swing.JTextArea();
        poidsLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        annexeJTextArea = new javax.swing.JTextArea();

        setTitle("Ajout d'exercice");
        setPreferredSize(new java.awt.Dimension(768, 250));

        effacerButton.setText("Effacer");
        effacerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerButtonActionPerformed(evt);
            }
        });

        ajouterButton.setText("Ajouter");
        ajouterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        numeroLabel.setText("Durée (en min)");

        dureeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dureeValueChange(evt);
            }
        });

        poidsLabel.setText("Enoncé");

        envoiLabel.setText("Type Exo");

        typeExoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "QuestionDeCours", "ManipTP", "ExoComplexe" }));
        typeExoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeExoValueChange(evt);
            }
        });

        dateReceptionLabel.setText("Courbe");

        courbeFTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                courbeValueChange(evt);
            }
        });

        numeroLabel1.setText("Cotation");

        cotationJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cotationValueChange(evt);
            }
        });

        dateReceptionLabel1.setText("Barème");

        baremeFTextField1.setEditable(false);

        enonceJTextArea.setColumns(20);
        enonceJTextArea.setRows(5);
        enonceJTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enonceValueChange(evt);
            }
        });
        jScrollPane2.setViewportView(enonceJTextArea);

        poidsLabel1.setText("Annexe");

        annexeJTextArea.setColumns(20);
        annexeJTextArea.setRows(5);
        annexeJTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                annexeValueChange(evt);
            }
        });
        jScrollPane3.setViewportView(annexeJTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateReceptionLabel1)
                            .addComponent(baremeFTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(poidsLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(envoiLabel))
                                            .addComponent(typeExoComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(numeroLabel)
                                                .addGap(24, 24, 24))
                                            .addComponent(dureeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cotationJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(numeroLabel1)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateReceptionLabel)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courbeFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(poidsLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ajouterButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(effacerButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(envoiLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(typeExoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dateReceptionLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(baremeFTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numeroLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cotationJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dateReceptionLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(courbeFTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numeroLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dureeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(poidsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(poidsLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterButton)
                    .addComponent(effacerButton)
                    .addComponent(okButton))
                .addGap(281, 281, 281))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        possedeExercice.ajouterExercice(exercice);
        setVisible(false);
        if (sujetExamenView != null) {
            sujetExamenView.actualiser();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void effacerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerButtonActionPerformed
        typeExoValueChangeAction(typeExoComboBox.getSelectedItem());
    }//GEN-LAST:event_effacerButtonActionPerformed

    private void ajouterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterButtonActionPerformed
        new AjouterExoView((ExerciceComplexe) exercice).setVisible(true);
    }//GEN-LAST:event_ajouterButtonActionPerformed

    private void typeExoValueChange(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeExoValueChange
        typeExoValueChangeAction(evt.getItem());
    }//GEN-LAST:event_typeExoValueChange

    private void annexeValueChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_annexeValueChange
        ((ExerciceStandard) exercice).setAnnexe(annexeJTextArea.getText());
    }//GEN-LAST:event_annexeValueChange

    private void enonceValueChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enonceValueChange
        ((ExerciceSimple) exercice).setEnonce(enonceJTextArea.getText());
    }//GEN-LAST:event_enonceValueChange

    private void dureeValueChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dureeValueChange
        ((ExerciceSimple) exercice).setDuree((Integer) dureeSpinner.getValue());
        calculer();
    }//GEN-LAST:event_dureeValueChange

    private void cotationValueChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cotationValueChange
        if (exercice instanceof ExerciceStandard) {
            ((ExerciceStandard) exercice).setCotation((Integer) cotationJSpinner.getValue());
        } else if (exercice instanceof QuestionDeCours) {
            ((QuestionDeCours) exercice).setCotation((Integer) cotationJSpinner.getValue());
        }
        calculer();
    }//GEN-LAST:event_cotationValueChange

    private void courbeValueChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courbeValueChange
        ((ManipTp) exercice).setCourbe(parseFloatTab(courbeFTextField.getText()));
    }//GEN-LAST:event_courbeValueChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterButton;
    private javax.swing.JTextArea annexeJTextArea;
    private javax.swing.JFormattedTextField baremeFTextField1;
    private javax.swing.JSpinner cotationJSpinner;
    private javax.swing.JFormattedTextField courbeFTextField;
    private javax.swing.JLabel dateReceptionLabel;
    private javax.swing.JLabel dateReceptionLabel1;
    private javax.swing.JSpinner dureeSpinner;
    private javax.swing.JButton effacerButton;
    private javax.swing.JTextArea enonceJTextArea;
    private javax.swing.JLabel envoiLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JLabel numeroLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel poidsLabel;
    private javax.swing.JLabel poidsLabel1;
    private javax.swing.JComboBox<String> typeExoComboBox;
    // End of variables declaration//GEN-END:variables
}
