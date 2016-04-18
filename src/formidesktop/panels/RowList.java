/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formidesktop.panels;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author jcapiz
 */
public class RowList extends javax.swing.JPanel {
    
    private String boleta;
    
    /**
     * Creates new form RowList
     * @param boleta
     * @param materiaName
     * @param myFont
     * @param widthRef
     */
    public RowList(String boleta, String materiaName,  Font myFont, int widthRef) {
        initComponents();
        this.boleta = boleta;
        jCheckBox2.setText(materiaName);
        jCheckBox2.setFont(myFont.deriveFont(14f));
        jCheckBox1.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent evt){
                System.out.println(jCheckBox1.isSelected() ? boleta + " dice que recursará " + jCheckBox2.getText() : boleta + " dice que ya no recursará " + jCheckBox2.getText());
            }
        });
        jCheckBox2.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent evt){
                System.out.println("Are we enabled? " + jCheckBox2.isSelected());
            }
        });
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setBackground(java.awt.Color.white);
        setLayout(new java.awt.BorderLayout(12, 0));

        jCheckBox1.setBackground(java.awt.Color.white);
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setPreferredSize(new java.awt.Dimension(132, 23));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1, java.awt.BorderLayout.WEST);

        jCheckBox2.setBackground(java.awt.Color.white);
        add(jCheckBox2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    // End of variables declaration//GEN-END:variables
}