/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_poo.view;

import java.awt.Component;
import tp3_poo.model.SujetExamen;

/**
 *
 * @author Moutek
 */
public class AfficherSujetExamenView extends javax.swing.JFrame {
    
    private SujetExamen sujetExamen;
    
    /**
     * Creates new form SacView
     * @param sujetExamen
     */
    public AfficherSujetExamenView(SujetExamen  sujetExamen) {
        initComponents();
        setLocationRelativeTo(null);
        setSujetExamen(sujetExamen);
    }

    @Override
    public final void setLocationRelativeTo(Component c) {
        super.setLocationRelativeTo(c); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        afficherTextArea = new javax.swing.JTextArea();
        enregistrerButton = new javax.swing.JButton();

        setTitle("Affichage de sujet d'examen");

        afficherTextArea.setEditable(false);
        afficherTextArea.setColumns(20);
        afficherTextArea.setRows(5);
        jScrollPane2.setViewportView(afficherTextArea);

        enregistrerButton.setText("OK");
        enregistrerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(enregistrerButton)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enregistrerButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enregistrerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_enregistrerButtonActionPerformed

    public final void setSujetExamen(SujetExamen sujetExamen) {
        this.sujetExamen = sujetExamen;
        afficherTextArea.setText(sujetExamen.toString());
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea afficherTextArea;
    private javax.swing.JButton enregistrerButton;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
