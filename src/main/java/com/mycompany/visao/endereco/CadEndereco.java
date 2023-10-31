/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.endereco;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEndereco;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vicentin.7910
 */
public class CadEndereco extends javax.swing.JFrame {

    /**
     * Creates new form CadEndereco
     */
    public CadEndereco() {
        initComponents();
          carregarCidades();
        
        if(!existeDadosTemporarios()){
            DaoEndereco daoEndereco = new DaoEndereco();

            int id = daoEndereco.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
    }
     recuperaIdCidade();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfIdCidade.setVisible(false);
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModEndereco){
            int id = ((ModEndereco) DadosTemporarios.tempObject).getId();
            int idCidade = ((ModEndereco) DadosTemporarios.tempObject).getIdCidade();
            String nomeRua = ((ModEndereco) DadosTemporarios.tempObject).getNomeRua();
            String cep = ((ModEndereco) DadosTemporarios.tempObject).getCep();
            String numeroResidencia = ((ModEndereco) DadosTemporarios.tempObject).getNumeroResidencia();
            
            tfId.setText(String.valueOf(id));
            tfIdCidade.setText(String.valueOf(idCidade));
            tfRua.setText(nomeRua);
            tfCep.setText(cep);
            tfNumero.setText(numeroResidencia);
            
            //
            try{
                DaoCidade daoCidade = new DaoCidade();
                ResultSet resultSet = daoCidade.listarPorId(idCidade);
                resultSet.next();
                String cidade = resultSet.getString("CIDADE");
                int index = 0;
                for(int i = 0; i < jcbCidade.getItemCount(); i++){
                    if(jcbCidade.getItemAt(i).equals(cidade)){
                        index = i;
                        break;
                    }
                }
                jcbCidade.setSelectedIndex(index);
            }catch(Exception e){}
            //
        
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }

    private void inserir(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
            JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoEndereco.buscarProximoId()));
            tfRua.setText("");
            tfNumero.setText("");
            tfCep.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
        }
    }
    
    private void alterar(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCidade.getText()), tfRua.getText(), tfCep.getText(), tfNumero.getText())){
            JOptionPane.showMessageDialog(null, "Endereço alterada com sucesso!");
            
            tfRua.setText("");
            tfNumero.setText("");
            tfCep.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o endereço!");
        }
        
       // ((ListEstado) Formularios.listEstado).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        if (daoEndereco.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Endereço excluído com sucesso!");
            
            tfRua.setText("");
            tfNumero.setText("");
            tfCep.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereço!");
        }
        
        //((ListEndereco) Formularios.listEnderesco).listarTodos();
        
        dispose();
    }
    
    private void carregarCidades(){
        try{
            DaoCidade daoCidade = new DaoCidade();

            ResultSet resultSet = daoCidade.listarTodos();

            while(resultSet.next())
                jcbCidade.addItem(resultSet.getString("CIDADE"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdCidade(){
        try{
            DaoCidade daoCidade = new DaoCidade();
            ResultSet resultSet = daoCidade.listarPorNome(jcbCidade.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCidade.setText(resultSet.getString("ID"));
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

        jcbCidade = new javax.swing.JComboBox<>();
        tfRua = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        tfIdCidade = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        tfCep = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RUA = new javax.swing.JLabel();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCidadeActionPerformed(evt);
            }
        });

        jLabel1.setText("CIdade");

        jLabel2.setText("ID");

        jLabel5.setText("Numero");

        RUA.setText("Rua");

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel7.setText("CEP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 540, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addGap(200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RUA)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfId)
                                .addComponent(tfCep)
                                .addComponent(tfRua, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(tfNumero, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(RUA)
                        .addGap(29, 29, 29)
                        .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAcao)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
         if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT)
            inserir();
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCidadeActionPerformed
       recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
           int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o endereço?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed
   private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadEndereco = null;
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
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RUA;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables
}
