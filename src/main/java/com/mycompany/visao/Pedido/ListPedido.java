/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Pedido;

import com.mycompany.dao.DaoPedido;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicentin.7910
 */
public class ListPedido extends javax.swing.JFrame {

    /**
     * Creates new form ListPedido
     */
    public ListPedido() {
        initComponents();
         setLocationRelativeTo(null);
        
        listarTodos();
    }
  public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pId){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNomePessoa(String pNomePessoa){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorNomePessoa(pNomePessoa);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorSobrenomePessoa(String pSobrenomePessoa){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorSobrenomePessoa(pSobrenomePessoa);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNomeProduto(String pNomeProduto){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorNomeProduto(pNomeProduto);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorDataPedidoMeiorQue(String pDataPedido){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorDataPedidoMaiorQue(pDataPedido);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorDataPedidoMenorQue(String pDataPedido){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorDataPedidoMenorQue(pDataPedido);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorDataPedidoIgualA(String pDataPedido){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorDataPedidoIgualA(pDataPedido);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorTotalPedidoMaiorQue(Double pTotalPedido){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorTotalPedidoMaiorQue(pTotalPedido);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorTotalPedidoMenorQue(Double pTotalPedido){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorTotalPedidoMenorQue(pTotalPedido);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorTotalPedidoIgualA(Double pTotalPedido){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);

            DaoPedido daoPedido = new DaoPedido();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoPedido.listarPorTotalPedidoIgualA(pTotalPedido);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String pessoa = resultSet.getString(2);
                String produto = resultSet.getString(3);
                String dataPedido = resultSet.getString(4);
                String quantidade = resultSet.getString(5);
                String total = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, pessoa, produto, dataPedido, quantidade, total});
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
        tablePedido = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PESSOA", "PRODUTO", "DATA PEDIDO", "QUANTIDADE", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePedido);
        if (tablePedido.getColumnModel().getColumnCount() > 0) {
            tablePedido.getColumnModel().getColumn(0).setResizable(false);
            tablePedido.getColumnModel().getColumn(1).setResizable(false);
            tablePedido.getColumnModel().getColumn(2).setResizable(false);
            tablePedido.getColumnModel().getColumn(3).setResizable(false);
            tablePedido.getColumnModel().getColumn(4).setResizable(false);
            tablePedido.getColumnModel().getColumn(5).setResizable(false);
        }

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "NOME CLIENTE", "SOBRENOME CLIENTE", "PRODUTO", "DATA PEDIDO MAIOR QUE", "DATA PEDIDO MENOR QUE ", "DATA PEIDO IGUAL A", "TOTAL PEDIDO MAIOR QUE", "TOTAL PEDIDO MENOR QUE ", "TOTAL PEDIDO IGUAL A" }));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePedidoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorNomePessoa(tfFiltro.getText());
                break;
            case 2:
                listarPorSobrenomePessoa(tfFiltro.getText());
                break;
            case 3:
                listarPorNomeProduto(tfFiltro.getText());
                break;
            case 4:
                listarPorDataPedidoMeiorQue(tfFiltro.getText());
                break;
            case 5:
                listarPorDataPedidoMenorQue(tfFiltro.getText());
                break;
            case 6:
                listarPorDataPedidoIgualA(tfFiltro.getText());
                break;
            case 7:
                listarPorTotalPedidoMaiorQue(Double.parseDouble(tfFiltro.getText()));
                break;
            case 8:
                listarPorTotalPedidoMenorQue(Double.parseDouble(tfFiltro.getText()));
                break;
            case 9:
                listarPorTotalPedidoIgualA(Double.parseDouble(tfFiltro.getText()));
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tablePedido;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
