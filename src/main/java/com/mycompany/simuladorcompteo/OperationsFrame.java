/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.simuladorcompteo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class OperationsFrame extends javax.swing.JFrame {

    // arraylist com os registradores de entrada
    ArrayList<String> entry = new ArrayList<>();
    // arraylist com os registradoresd de saida
    ArrayList<String> output = new ArrayList<>();
    //numero de registradores
    int numberRegs;

    //string com o nome de todos os registradores de entrada escolhidos
    String allEntryRegisters;
    //string com o nome de todos os registradores de saida escolhidos
    String allOutRegisters;

    //tamanho da lista
    int listSize = 1;

    //modelo para a manipulação de jlist
    DefaultListModel listModel = new DefaultListModel();

    public DefaultListModel getListModel() {
        return listModel;
    }

    public int getNumberRegs() {
        return numberRegs;
    }

    public void setNumberRegs(int numberRegs) {
        this.numberRegs = numberRegs;
    }

    public ArrayList<String> getEntry() {
        return entry;
    }

    public void setEntry(ArrayList<String> entry) {
        this.entry = entry;
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<String> output) {
        this.output = output;
    }

    public OperationsFrame() {

        initComponents();
        hideAdditionalBoxes();

    }

    public void hideBoxes() {
        jComboBoxOpertions1.setVisible(false);
        /*jComboBoxOpertions2.setVisible(false);
        jComboBoxOpertions3.setVisible(false);
        jComboBoxOpertions4.setVisible(false);
        jComboBoxOpertions5.setVisible(false);
        jComboBoxOpertions6.setVisible(false);
        jComboBoxOpertions7.setVisible(false);
        jComboBoxOpertions8.setVisible(false);
        jComboBoxOpertions9.setVisible(false);
        jComboBoxOpertions10.setVisible(false);
        jComboBoxOpertions11.setVisible(false);
        jComboBoxOpertions12.setVisible(false);
        jComboBoxOpertions13.setVisible(false);
        jComboBoxOpertions14.setVisible(false);
        jComboBoxOpertions15.setVisible(false);
        jComboBoxOpertions16.setVisible(false);*/

    }

    /*
    public void showBoxes() {
        if (!entry.isEmpty()) {
            jComboBoxOpertions1.setVisible(true);
        }
        if (entry.size() > 1) {
            jComboBoxOpertions2.setVisible(true);
        }
        if (entry.size() > 2) {
            jComboBoxOpertions3.setVisible(true);
        }
        if (entry.size() > 3) {
            jComboBoxOpertions4.setVisible(true);
        }
        if (entry.size() > 4) {
            jComboBoxOpertions5.setVisible(true);
        }
        if (entry.size() > 5) {
            jComboBoxOpertions6.setVisible(true);
        }
        if (entry.size() > 6) {
            jComboBoxOpertions7.setVisible(true);
        }
        if (entry.size() > 7) {
            jComboBoxOpertions8.setVisible(true);
        }
        if (entry.size() > 8) {
            jComboBoxOpertions9.setVisible(true);
        }
        if (entry.size() > 9) {
            jComboBoxOpertions10.setVisible(true);
        }
        if (entry.size() > 10) {
            jComboBoxOpertions11.setVisible(true);
        }
        if (entry.size() > 11) {
            jComboBoxOpertions12.setVisible(true);
        }
        if (entry.size() > 12) {
            jComboBoxOpertions13.setVisible(true);
        }
        if (entry.size() > 13) {
            jComboBoxOpertions14.setVisible(true);
        }
        if (entry.size() > 14) {
            jComboBoxOpertions15.setVisible(true);
        }
        if (entry.size() > 15) {
            jComboBoxOpertions16.setVisible(true);
        }

    }*/
    
    //esconde as jcombobox auxiliares
    public void hideAdditionalBoxes() {
        //operation 1
        //jComboBoxEntry1.setVisible(false);
        jComboBoxSecondEntry1.setVisible(false);
        jComboBoxOut1.setVisible(false);
    }

    //mostra as jcombobox auxiliares
    public void showAdditionalBoxes() {
        if (jComboBoxOpertions1.isVisible()) {
            jComboBoxEntry1.setVisible(true);
            if (jComboBoxOpertions1.getSelectedItem() == "Soma") {
                jComboBoxSecondEntry1.setVisible(true);
                jComboBoxOut1.setVisible(true);
            }
        }
        fillAditionalBoxes();
    }

    //coloca os valores de entrada na jcombobox 
    public void fillAditionalBoxes() {
       
        jComboBoxEntry1.setModel(new DefaultComboBoxModel(entry.toArray()));
    }

    //constroi a string com todos os valores de entrada
    public void buildStringEntries() {
        StringBuilder stb = new StringBuilder();
        allEntryRegisters = "";
        int i = 0;
        //for(int i = 0; i < entry.size(); i++){
        while (i < entry.size()) {
            allEntryRegisters = allEntryRegisters + entry.get(i);
            i++;
            if (i < entry.size()) {
                allEntryRegisters = allEntryRegisters + ",";
            }

        }
        System.out.println(allEntryRegisters);

    }

    //constroi a string com todos os valores de saida
    public void buildStringOutput() {
        StringBuilder stb = new StringBuilder();
        allOutRegisters = "";
        int i = 0;
        //for(int i = 0; i < entry.size(); i++){
        while (i < output.size()) {
            allOutRegisters = allOutRegisters + output.get(i);
            i++;
            if (i < output.size()) {
                allOutRegisters = allOutRegisters + ",";
            }

        }
        System.out.println(allOutRegisters);

    }

    //preenche um registrador utilizando os valores ecolhidos na jframe
    public Registrador saveRegisters() {
        Registrador reg = new Registrador();
        if (jComboBoxOpertions1.getSelectedItem() == "Soma") {
            reg.setNomeEntrada(jComboBoxEntry1.getSelectedItem().toString());
            reg.setNomeEntrada2(jComboBoxSecondEntry1.getSelectedItem().toString());
            reg.setOperation(Operations.addition);
            reg.setNomeSaida(jComboBoxOut1.getSelectedItem().toString());
        } else {

            reg.setNomeEntrada(jComboBoxEntry1.getSelectedItem().toString());
            reg.setRegistradorType(RegistradorType.Armazena);
            if (jComboBoxOpertions1.getSelectedItem() == "+1") {
                reg.setOperation(Operations.plus_one);
            } else if (jComboBoxOpertions1.getSelectedItem() == "-1") {
                reg.setOperation(Operations.minus_one);
            } else if (jComboBoxOpertions1.getSelectedItem() == "^2") {
                reg.setOperation(Operations.squared);
            }

        }
        return reg;
    }

    /* public String stringMaker(Registrador r) {

        String s = r.getRegistradorType() + ": N" + entry.size() + " -> N" + this.getNumberRegs()
                + " tal que, ∀ " + allEntryRegisters + "∈N " + r.getOperation() + "_" + r.nomeEntrada + "(" + allEntryRegisters
                + ")";
        return s;
    }

    public String stringMakerReturn(Registrador r) {
        String s = "Retorna" + ": N" + this.getNumberRegs() + " -> N" + output.size()
                + " tal que, ∀ " + allOutRegisters + "∈N Retorna_" + r.nomeEntrada + "(" + allEntryRegisters
                + ")";
        return s;
    }*/
    
    // cria e retorna a string da operação
    public String makeOperation() {
        String s = "";
        if (jComboBoxDoIf.getSelectedItem() == "Faça") {
            s = "R" + listSize + ": Faça " + jComboBoxOpertions1.getSelectedItem() + "_" + jComboBoxEntry1.getSelectedItem() + " vá_para " + jTextFieldGoTo.getText();
            listSize++;
        } else if (jComboBoxDoIf.getSelectedItem() == "Se") {
            s = "R" + listSize + ": Se " + jComboBoxOpertions1.getSelectedItem() + "_" + jComboBoxEntry1.getSelectedItem() + " vá_para "
                    + jTextFieldGoTo.getText() + " senão vá_para " + jTextFieldGoTo1.getText();

            listSize++;
        }

        return s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jComboBoxOpertions1 = new javax.swing.JComboBox<>();
        jComboBoxEntry1 = new javax.swing.JComboBox<>();
        jComboBoxSecondEntry1 = new javax.swing.JComboBox<>();
        jComboBoxOut1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxDoIf = new javax.swing.JComboBox<>();
        jButtonAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOperations = new javax.swing.JList<>();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldGoTo = new javax.swing.JTextField();
        jTextFieldGoTo1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBoxOpertions1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Soma", "-1", "+1", "^2" }));
        jComboBoxOpertions1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOpertions1ActionPerformed(evt);
            }
        });

        jComboBoxEntry1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEntry1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Saida:");

        jComboBoxDoIf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Faça", "Se" }));

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListOperations);

        jButtonDelete.setText("Deletar");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTextFieldGoTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGoToActionPerformed(evt);
            }
        });

        jTextFieldGoTo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGoTo1ActionPerformed(evt);
            }
        });

        jLabel2.setText("vá_para se");

        jLabel3.setText("vá_para");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxDoIf, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOpertions1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(jButtonAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxOut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSecondEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGoTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldGoTo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxDoIf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGoTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldGoTo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jComboBoxOpertions1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxSecondEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxOut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxOpertions1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOpertions1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOpertions1ActionPerformed

    private void jComboBoxEntry1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEntry1ActionPerformed
        this.showAdditionalBoxes();
    }//GEN-LAST:event_jComboBoxEntry1ActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        
        //Registrador r = this.saveRegisters();
        //String s = this.stringMaker(r);
        // String s2 = this.stringMakerReturn(r);
        //executa makeOperation para criar a string da operação, adiciona essa string no modelo e atualiza a lista
        String s = this.makeOperation();
        listModel.addElement(s);
        //listModel.addElement(s2);
        jListOperations.setModel(listModel);
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        //deleta a operação selecionada da lista
        String s = jListOperations.getSelectedValue();
        listModel.removeElement(s);
        jListOperations.setModel(listModel);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldGoTo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGoTo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGoTo1ActionPerformed

    private void jTextFieldGoToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGoToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGoToActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperationsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JComboBox<String> jComboBoxDoIf;
    private javax.swing.JComboBox<String> jComboBoxEntry1;
    private javax.swing.JComboBox<String> jComboBoxOpertions1;
    private javax.swing.JComboBox<String> jComboBoxOut1;
    private javax.swing.JComboBox<String> jComboBoxSecondEntry1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListOperations;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldGoTo;
    private javax.swing.JTextField jTextFieldGoTo1;
    // End of variables declaration//GEN-END:variables
}
