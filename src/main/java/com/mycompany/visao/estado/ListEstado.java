/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.estado;

import com.mycompany.dao.DaoEstado;
import com.mycompany.dao.DaoPais;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEstado;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicentin.7910
 */
public class ListEstado extends javax.swing.JFrame {

    /**
     * Creates new form ListEstdado
     */
    public ListEstado() {
        initComponents();
        
          setLocationRelativeTo(null);
        
        listarTodos();
    }
      public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEstado.getModel();
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf =  resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, pais, nome, uf});
            }
        }catch(Exception e){
            
        }
    }
       public void listarPorId(int pId){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEstado.getModel();

            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
       public void listarPorNome(String pNome){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEstado.getModel();
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.ListarPorNome(pNome, true);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorPais(String pPais){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEstado.getModel();
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarPorPais(pPais);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorUf(String pUf){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEstado.getModel();
            
            tableEstado.setModel(defaultTableModel);

            DaoEstado daoEstado = new DaoEstado();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoEstado.listarPorUf(pUf);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pais = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String uf = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, pais, nome, uf});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstado = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "PAIS", "NOME", "UF"
            }
        ));
        tableEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEstadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEstado);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "PAIS", "NOME", "UF", " " }));

        tfFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFiltroActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("De dois cliques para alterar .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroActionPerformed

    private void tableEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEstadoMouseClicked
         try{
            if (evt.getClickCount() == 2){
                ModEstado modEstado = new ModEstado();

                modEstado.setId(Integer.parseInt(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 0))));
                modEstado.setNome(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 2)));
                modEstado.setUf(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 3)));
                
                DaoPais daoPais = new DaoPais();
                ResultSet resultSet = daoPais.listarPorNome(String.valueOf(tableEstado.getValueAt(tableEstado.getSelectedRow(), 1)));

                int idPais = -1;
                while(resultSet.next())
                    idPais = resultSet.getInt("ID");

                modEstado.setIdPais(idPais);
                
                DadosTemporarios.tempObject = (ModEstado) modEstado;

                CadEstado cadEstado = new CadEstado();
                cadEstado.setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tableEstadoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
            case 2:
                listarPorPais(tfFiltro.getText());
                break;
            case 3:
                listarPorNome(tfFiltro.getText());
                break;
            case 4:
                listarPorUf(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
        private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listEstado = null;
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
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableEstado;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
