/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formidesktop.panels;

import formidesktop.Counter;
import formidesktop.database.acciones.AccionesTablaAlumnoCursaMateria;
import formidesktop.database.acciones.Parser;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jcapiz
 */
public class RowList extends javax.swing.JPanel {

    private String boleta;
    private Counter cuenta;

    /**
     * Creates new form RowList
     *
     * @param boleta
     * @param materiaName
     * @param myFont
     * @param widthRef
     * @param materiasMarcadas
     * @param counter
     */
    public RowList(String boleta, String materiaName, Font myFont, int widthRef, String[] materiasMarcadas, Counter cuenta, final JFrame parent) {
        initComponents();
        this.cuenta = cuenta;
        this.boleta = boleta;
        jCheckBox2.setText(materiaName);
        jCheckBox2.setFont(myFont.deriveFont(14f));
        jCheckBox1.setEnabled(false);
        jCheckBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                AccionesTablaAlumnoCursaMateria.actualizaRecurse(boleta, materiaName, jCheckBox1.isSelected());
            }
        });
        jCheckBox2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                
                System.out.println("Cuenta: " + cuenta.obtenerCuenta());
                if (jCheckBox2.isSelected()) {
                    jCheckBox1.setEnabled(true);
                    AccionesTablaAlumnoCursaMateria.insertaAlumnoCursaUnidadDeAprendizaje(boleta, materiaName, jCheckBox1.isSelected());
                    System.out.println("selected");
                    if (cuenta.obtenerCuenta() > 11) {
                        String options[] = {"no c", "weno zi c pero no wa deisr"};
                        JOptionPane.showInputDialog(parent, "EWE K P2 apoco si vas a meter más de 11 materias el proximo semestre? NTPDV" +
                                " RELAJA LA RAJA", "Warning", JOptionPane.QUESTION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("seasmamon.jpg")), options, LEFT_ALIGNMENT);
                    }
                    cuenta.incrementar();
                } else {
                    jCheckBox1.setEnabled(false);
                    AccionesTablaAlumnoCursaMateria.eliminaAlumnoCursaUnidadDeAprendizaje(boleta, materiaName);
                    cuenta.decrementar();
                    jCheckBox1.setSelected(false);

                }
            }
            
        });
        boolean existe = false;
        boolean isRecurse = false;
        Parser row;
        for (String materiaMarcada : materiasMarcadas) {
            row = new Parser(materiaMarcada);
            if (materiaName.equals(row.getString("idUnidad_Aprendizaje"))) {
                existe = true;
                isRecurse = row.getBoolean("es_recurse");
                break;
            }
        }
        boolean cursaUA = existe;
        boolean esRecurse = isRecurse;
        jCheckBox2.setSelected(cursaUA);
        jCheckBox1.setEnabled(cursaUA);
        jCheckBox1.setSelected(esRecurse);
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
