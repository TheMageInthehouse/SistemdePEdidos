/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.estado;

import com.mycompany.dao.DaoEstado;
import com.mycompany.dao.DaoPais;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEstado;
import com.mycompany.visao.cidade.CadCidade;
import com.mycompany.visao.pais.CadPais;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vicentin.7910
 */
public class CadEstado extends javax.swing.JFrame {

    /**
     * Creates new form CadEstado
     */
    public CadEstado() {
        initComponents();
        
        carregarPaises();
        
        if(!existeDadosTemporarios()){
            DaoEstado daoEstado = new DaoEstado();

            int id = daoEstado.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdPais();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
//        tfIdPais.setVisible(false);;
    
    }
 private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModEstado){
            int id = ((ModEstado) DadosTemporarios.tempObject).getId();
            int idPais = ((ModEstado) DadosTemporarios.tempObject).getIdPais();
            String nome = ((ModEstado) DadosTemporarios.tempObject).getNome();
            String uf = ((ModEstado) DadosTemporarios.tempObject).getUf();
            
            tfId.setText(String.valueOf(id));
            tfIdPais.setText(String.valueOf(idPais));
            tfNome.setText(nome);
            tfUf.setText(uf);
            
            //
            try{
                DaoPais daoPais = new DaoPais();
                ResultSet resultSet = daoPais.listarPorId(idPais);
                resultSet.next();
                String pais = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbPais.getItemCount(); i++){
                    if(jcbPais.getItemAt(i).equals(pais)){
                        index = i;
                        break;
                    }
                }
                jcbPais.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }

    private void inserir(){
        DaoEstado daoEstado = new DaoEstado();
        
        if (daoEstado.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdPais.getText()), tfNome.getText(), tfUf.getText())){
            JOptionPane.showMessageDialog(null, "Estado salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoEstado.buscarProximoId()));
            tfNome.setText("");
            tfUf.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o estado!");
        }
    }
    
    private void alterar(){
        DaoEstado daoEstado = new DaoEstado();
        
        if (daoEstado.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdPais.getText()), tfNome.getText(), tfUf.getText())){
            JOptionPane.showMessageDialog(null, "Estado alterada com sucesso!");
            
            tfId.setText("");
            tfIdPais.setText("");
            tfNome.setText("");
            tfUf.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o estado!");
        }
        
           // ((ListEstado) Formularios.listEstado).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoEstado daoEstado = new DaoEstado();
        
        if (daoEstado.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Estado " + tfNome.getText() + " excluída com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o estado!");
        }
        
      //  ((ListEstado) Formularios.listEstado).listarTodos();
        
        dispose();
    }
    
    public void carregarPaises(){
        try{
            DaoPais daoPais = new DaoPais();

            ResultSet resultSet = daoPais.listarTodos();

            while(resultSet.next())
                jcbPais.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdPais(){
        try{
            DaoPais daoPais = new DaoPais();
            ResultSet resultSet = daoPais.listarPorNome(jcbPais.getSelectedItem().toString());
            
            resultSet.next();
            tfIdPais.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbPais = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfUf = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfIdPais = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Pais");

        jcbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPaisItemStateChanged(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("UF");

        btnAcao.setText("SALVAR");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tfIdPais.setText("idPais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(tfIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o estado " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
           if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            if(Formularios.cadCidade != null){
                //((CadCidade) Formularios.cadCidade).carregarEstados();
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPaisItemStateChanged
        recuperaIdPais();
    }//GEN-LAST:event_jcbPaisItemStateChanged
 private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        Formularios.cadEstado = null;
        
        if(Formularios.cadCidade != null){
          // ((CadCidade) Formularios.cadCidade).carregarEstados();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jcbPais;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdPais;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfUf;
    // End of variables declaration//GEN-END:variables
}
