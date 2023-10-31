/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Produto;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoEstado;
import com.mycompany.dao.DaoMarca;
import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModProduto;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vicentin.7910
 */
public class CadProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadProduto
     */
    public CadProduto() {
        initComponents();
    carregarMarcas();
        carregarCategorias();
        
        if(!existeDadosTemporarios()){
            DaoProduto daoProduto = new DaoProduto();

            int id = daoProduto.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        recuperaIdCategoria();
        recuperaIdMarca();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        btnExcluir.setVisible(true);
//        tfIdPais.setVisible(false);;
    }
private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModProduto){
            int id = ((ModProduto) DadosTemporarios.tempObject).getId();
            int idCategoria = ((ModProduto) DadosTemporarios.tempObject).getIdCategoria();
            int idMarca = ((ModProduto) DadosTemporarios.tempObject).getIdMarca();
            String nome = ((ModProduto) DadosTemporarios.tempObject).getNome();
            String descricao = ((ModProduto) DadosTemporarios.tempObject).getDescricao();
            Double preco = ((ModProduto) DadosTemporarios.tempObject).getPreco();    
            
            tfId.setText(String.valueOf(id));
            tfIdCategoria.setText(String.valueOf(String.valueOf(idCategoria)));
            tfIdMarca.setText(String.valueOf(idMarca));
            tfNome.setText(nome);
            taDescricao.setText(descricao);
            tfPreco.setText(String.valueOf(preco));
            
            //
            try{
                DaoCategoria daoCategoria = new DaoCategoria();
                ResultSet resultSet = daoCategoria.listarPorId(idCategoria);
                resultSet.next();
                String categoria = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbCategoria.getItemCount(); i++){
                    if(jcbCategoria.getItemAt(i).equals(categoria)){
                        index = i;
                        break;
                    }
                }
                jcbCategoria.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            //
            try{
                DaoMarca daoMarca = new DaoMarca();
                ResultSet resultSet = daoMarca.listarPorId(idMarca);
                resultSet.next();
                String marca = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbMarca.getItemCount(); i++){
                    if(jcbMarca.getItemAt(i).equals(marca)){
                        index = i;
                        break;
                    }
                }
                jcbMarca.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }

    private void inserir(){
        DaoProduto daoProduto = new DaoProduto();
        
        if (daoProduto.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCategoria.getText()), Integer.parseInt(tfIdMarca.getText()), tfNome.getText(), taDescricao.getText(), Double.parseDouble(tfPreco.getText()))){
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoProduto.buscarProximoId()));
            tfNome.setText("");
            taDescricao.setText("");
            tfPreco.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o Produto!");
        }
    }
    
    private void alterar(){
        DaoProduto daoProduto = new DaoProduto();
        
        if (daoProduto.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCategoria.getText()), Integer.parseInt(tfIdMarca.getText()), tfNome.getText(), taDescricao.getText(), Double.parseDouble(tfPreco.getText()))){
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
            tfId.setText(String.valueOf(daoProduto.buscarProximoId()));
            tfNome.setText("");
            taDescricao.setText("");
            tfPreco.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto!");
        }
        
       // ((ListProduto) Formularios.listProduto).listarTodos();
        
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
        
       // ((ListProduto) Formularios.listProduto).listarTodos();
        
        dispose();
    }
    
    public void carregarCategorias(){
        try{
            DaoCategoria daoCategoria = new DaoCategoria();

            ResultSet resultSet = daoCategoria.listarTodos();

            while(resultSet.next())
                jcbCategoria.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdCategoria(){
        try{
            DaoCategoria daoCategoria = new DaoCategoria();
            ResultSet resultSet = daoCategoria.listarPorNome(jcbCategoria.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCategoria.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void carregarMarcas(){
        try{
            DaoMarca daoMarca = new DaoMarca();

            ResultSet resultSet = daoMarca.listarTodos();

            while(resultSet.next())
                jcbMarca.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdMarca(){
        try{
            DaoMarca daoMarca = new DaoMarca();
            ResultSet resultSet = daoMarca.listarPorNome(jcbMarca.getSelectedItem().toString());
            
            resultSet.next();
            tfIdMarca.setText(resultSet.getString("ID"));
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

        tfNome = new javax.swing.JTextField();
        jcbCategoria = new javax.swing.JComboBox<>();
        tfIdMarca = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        tfIdCategoria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jcbMarca = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });

        btnAcao.setText("SALVAR");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição");

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria");

        jLabel3.setText("Preço");

        jLabel5.setText("ID");

        jcbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        jcbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMarcaActionPerformed(evt);
            }
        });

        jLabel8.setText("Marca");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        jLabel9.setText("Nome produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(142, 142, 142))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addGap(177, 177, 177))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            if(Formularios.cadCategoria != null){
                ((CadProduto) Formularios.cadProduto).carregarCategorias();
                dispose();
            }else if(Formularios.cadMarca != null){
                ((CadProduto) Formularios.cadProduto).carregarMarcas();
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
          recuperaIdCategoria();
    }//GEN-LAST:event_jcbCategoriaActionPerformed

    private void jcbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMarcaActionPerformed
        recuperaIdMarca();
    }//GEN-LAST:event_jcbMarcaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o produto " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JComboBox<String> jcbMarca;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCategoria;
    private javax.swing.JTextField tfIdMarca;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
