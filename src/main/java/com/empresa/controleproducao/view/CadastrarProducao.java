package com.empresa.controleproducao.view;

import com.empresa.controleproducao.controller.ClienteController;
import com.empresa.controleproducao.controller.ProducaoController;
import com.empresa.controleproducao.model.AuxCalculoTotal;
import com.empresa.controleproducao.model.AuxRend;
import com.empresa.controleproducao.model.CalculoTotal;
import com.empresa.controleproducao.model.Producao;
import com.empresa.controleproducao.model.TorraClara;
import com.empresa.controleproducao.model.TorraEscura;
import com.empresa.controleproducao.model.TorraMedia;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CadastrarProducao extends javax.swing.JFrame {

    private static int codProd;
    
    
    public CadastrarProducao() {    
        //inicializa os componentes do swing
        initComponents();
        //serve para que o valor do id para cadastro seja sempre um a mais que o anterior.
        txtCodProd.setText(String.valueOf(codProd+1));
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
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdCliP = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPesoCru = new javax.swing.JTextField();
        txtTipoTorra = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrecoKg = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Calcular = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelPreco = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableRend = new javax.swing.JTable();
        Cancelar = new javax.swing.JButton();
        Cadastrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Cadastro de Produção");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Produção"));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("Data:");

        jLabel8.setText("Lote:");

        txtIdCliP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCliP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdCliPFocusLost(evt);
            }
        });
        txtIdCliP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCliPActionPerformed(evt);
            }
        });

        txtLote.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("ID Cliente:");

        txtPesoCru.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPesoCru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoCruActionPerformed(evt);
            }
        });

        txtTipoTorra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Torra Clara", "Torra Média", "Torra Escura", " ", " " }));

        jLabel3.setText("Tipo de Torra:");

        txtPrecoKg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2", "3", "4", " " }));
        txtPrecoKg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoKgActionPerformed(evt);
            }
        });

        jLabel4.setText("Peso Cru:");

        jLabel5.setText("Preço/Kg:");

        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        TabelPreco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Preço Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TabelPreco);
        if (TabelPreco.getColumnModel().getColumnCount() > 0) {
            TabelPreco.getColumnModel().getColumn(0).setResizable(false);
        }

        TableRend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rendimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRend.setToolTipText("");
        jScrollPane3.setViewportView(TableRend);
        if (TableRend.getColumnModel().getColumnCount() > 0) {
            TableRend.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Calcular)
                .addGap(119, 119, 119))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecoKg, 0, 105, Short.MAX_VALUE)
                            .addComponent(txtTipoTorra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(txtIdCliP, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(12, 12, 12)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(jLabel4)
                            .addGap(12, 12, 12)
                            .addComponent(txtPesoCru, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCliP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPesoCru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipoTorra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecoKg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Calcular)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Cadastrar.setText("Confirmar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        jLabel10.setText("Cod:");

        txtCodProd.setEditable(false);
        txtCodProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(12, 12, 12)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cancelar)
                            .addGap(12, 12, 12)
                            .addComponent(Cadastrar))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Cadastrar)
                    .addComponent(jLabel10)
                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdCliPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCliPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCliPActionPerformed

    private void txtPrecoKgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoKgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoKgActionPerformed

    private void txtPesoCruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoCruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoCruActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        
        try{
            //recebe os valores da tela
            String data = txtData.getText();
            int idCliP = Integer.parseInt(txtIdCliP.getText());
            int lote = Integer.parseInt(txtLote.getText());
            double pesoCru = Double.parseDouble(txtPesoCru.getText());
            String tipoTorra = txtTipoTorra.getSelectedItem().toString();
            double precoKg = Double.parseDouble(txtPrecoKg.getSelectedItem().toString());
            double rendimento = Double.parseDouble(TableRend.getModel().getValueAt(0, 0).toString());
            double precoTotal = Double.parseDouble(TabelPreco.getModel().getValueAt(0, 0).toString());
            this.codProd = this.codProd+1;

            ProducaoController producaoController = new ProducaoController();

            //lógica de cadastro
            if(producaoController.cadastrar(this.codProd,data,idCliP,lote,pesoCru,tipoTorra,precoKg, precoTotal, rendimento)){
                JOptionPane.showMessageDialog(null,"Produção cadastrada com sucesso!", "Sucesso!",1);
            }
            else{
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar produção!", "Erro!",0);
            }

            //lógica responsável para voltar ao menu
            this.dispose();
            MenuPrincipalView menu = new MenuPrincipalView();
            menu.setVisible(true);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao Cadastrar Produção! - Erro:" + ex, "Erro!", 0);
        }
    }//GEN-LAST:event_CadastrarActionPerformed

    private void txtCodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProdActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        
        //serve para que não fique adicionando valores extras na lista auxiliar.
        AuxRend.getInstance().remove(0);
        
        //lógica responsável para voltar ao menu
        this.dispose();
        MenuPrincipalView menu = new MenuPrincipalView();
        menu.setVisible(true);
        
    }//GEN-LAST:event_CancelarActionPerformed

    //lógica responsável pelo cálculo
    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        
        try{
         
            //lógica responsável para voltar ao menu
            String tipoTorra = txtTipoTorra.getSelectedItem().toString(); 
            double pesoCru = Double.parseDouble(txtPesoCru.getText());
            double precoKg = Double.parseDouble(txtPrecoKg.getSelectedItem().toString());

            //verifica se a tabela não está vazia, se estiver com algum valor então irá remover antes de inserir novamente
            if(!AuxRend.getInstance().isEmpty()){
                AuxRend.getInstance().remove(0);
            }

            //verifica se a tabela não está vazia, se estiver com algum valor então irá remover antes de inserir novamente
            if(!AuxCalculoTotal.getInstance().isEmpty()){
                AuxCalculoTotal.getInstance().remove(0);
            }

            //instanciação de objetos para calculo
            ProducaoController producaoController = new ProducaoController();
            CalculoTotal calculo = new CalculoTotal();
            TorraClara torraclara = new TorraClara();
            TorraMedia torramedia = new TorraMedia();
            TorraEscura torraescura = new TorraEscura();

            //lógica de calculo de rendimento
            if(tipoTorra != " " && precoKg != 0){

                if(tipoTorra == "Torra Clara"){
                    pesoCru = torraclara.Calcular(pesoCru);
                }
                if(tipoTorra == "Torra Média"){
                    pesoCru = torramedia.Calcular(pesoCru);
                }
                if(tipoTorra == "Torra Escura"){
                    pesoCru = torraescura.Calcular(pesoCru);
                }

                double precoTotal = calculo.calcular(pesoCru, precoKg);

                //cadastro nas listas temporárias de rendimento para que seja possível mostra o valor na tabela
                if(producaoController.cadastrarRend(pesoCru)){
                    ProducaoController rendimentoController = new ProducaoController();
                    rendimentoController.tabelaRend(TableRend);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro ao calcular rendimento", "Erro!",0);
                }

                //cadastro nas listas temporárias de valor totalpara que seja possível mostra o valor na tabela
                if(producaoController.cadastrarCalculoTotal(precoTotal)){
                    ProducaoController calculoController = new ProducaoController();
                    calculoController.tabelaCalculoTotal(TabelPreco);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro ao calcular preço Total", "Erro!",0);
                }

            }
            else{
                JOptionPane.showMessageDialog(null,"Escolha um tipo de torra e o preço do quilo", "Erro!",0);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao Efetuar Calculo! - Erro:" + ex, "Erro!", 0);
        }   
    }//GEN-LAST:event_CalcularActionPerformed

    //validação para ver se o cliente já está cadastrado
    private void txtIdCliPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdCliPFocusLost
        
        try{
         
            ClienteController buscarCliente = new ClienteController();
            int id = buscarCliente.pesquisarCliente(Integer.parseInt(txtIdCliP.getText()));

            if(id < 0){
                JOptionPane.showMessageDialog(null,"Cliente não encontrado!","Aviso",1);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao checar cliente! - Erro:" + ex, "Erro!", 0);
        }
    }//GEN-LAST:event_txtIdCliPFocusLost

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
            java.util.logging.Logger.getLogger(CadastrarProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarProducao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarProducao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton Calcular;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTable TabelPreco;
    private javax.swing.JTable TableRend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtIdCliP;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtPesoCru;
    private javax.swing.JComboBox<String> txtPrecoKg;
    private javax.swing.JComboBox<String> txtTipoTorra;
    // End of variables declaration//GEN-END:variables
}
