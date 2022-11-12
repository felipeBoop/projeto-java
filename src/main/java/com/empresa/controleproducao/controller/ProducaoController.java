
package com.empresa.controleproducao.controller;

import com.empresa.controleproducao.model.AuxCalculoTotal;
import com.empresa.controleproducao.model.AuxRend;
import com.empresa.controleproducao.model.CalculoTotal;
import com.empresa.controleproducao.model.ListaProducao;
import com.empresa.controleproducao.model.Producao;
import com.empresa.controleproducao.model.Rendimento;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProducaoController {
    
    public boolean cadastrar(int codProd,String data,int idCliP,int lote,double pesoCru,String tipoTorra, double precoKg, double precoTotal,double rendimento){
        Producao producao = new Producao(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg, precoTotal, rendimento);
        return ListaProducao.getInstance().add(producao);
    }
    
    public boolean cadastrarRend(double pesoCru){
        Rendimento rendimento = new Rendimento(pesoCru);
        return AuxRend.getInstance().add(rendimento);
    }
    
    public boolean cadastrarCalculoTotal(double valorTotal){
        CalculoTotal calculo = new CalculoTotal(valorTotal);
        return AuxCalculoTotal.getInstance().add(calculo);
    }
    
    public void preencherTabela(JTable jTabela){
        
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

        dtm.setRowCount(ListaProducao.getInstance().size());
        jTabela.setModel(dtm);

        int posicaoLinha = 0;

        for(int i=0; i < ListaProducao.getInstance().size(); i++){

            jTabela.setValueAt(ListaProducao.getInstance().get(i).getCodProd(), posicaoLinha, 0);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getIdCliP(), posicaoLinha, 1);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getLote(), posicaoLinha, 2);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getPesoCru(), posicaoLinha, 3);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getTipoTorra(), posicaoLinha, 4);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getPrecoKg(), posicaoLinha, 5);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getRendimento(), posicaoLinha, 6);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getPrecoTotal(), posicaoLinha, 7);
            
            posicaoLinha += 1;
        }
          
    }
    
    public void excluir (JTable jTabela){
        
        if(jTabela.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione uma produção na tabela", "Aviso", 0);
        }else{

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja excluir a produção?",
                    "Aviso",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION){
                ListaProducao.getInstance().remove(jTabela.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Produção excluida com sucesso!", "Aviso", 1);

                preencherTabela(jTabela);
            }
        }
    }

    public List<Object> pesquisa(int id) {
        
        boolean achou  = false;
        int posicao = -1;
        
        for(int i = 0; i < ListaProducao.getInstance().size(); i++){
            if(ListaProducao.getInstance().get(i).getCodProd() == id){
                achou = true;
                posicao = i;
            }
        }
        
        if(achou == true){
            int codProd = ListaProducao.getInstance().get(posicao).getCodProd();
            String data = ListaProducao.getInstance().get(posicao).getData();
            int idCliP = ListaProducao.getInstance().get(posicao).getIdCliP();
            int lote = ListaProducao.getInstance().get(posicao).getLote();
            double pesoCru = ListaProducao.getInstance().get(posicao).getPesoCru();
            String tipoTorra = ListaProducao.getInstance().get(posicao).getTipoTorra();
            double precoKg = ListaProducao.getInstance().get(posicao).getPrecoKg();
            double precoRendimento = ListaProducao.getInstance().get(posicao).getRendimento();
            double precoTotal = ListaProducao.getInstance().get(posicao).getPrecoTotal();
            
            return Arrays.asList(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg, precoRendimento, precoTotal);
        }
        else{
            JOptionPane.showMessageDialog(null,"Produção não encontrada!","Aviso",0);
            return null;
        }
    }

    public void editar(int codProd, String data, int idCliP, int lote, double pesoCru, String tipoTorra, double precoKg, double precoTotal, double rendimento) {
        
        int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar os dados da produção?","Aviso",JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            Producao producao = new Producao(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg, precoTotal, rendimento);
            int posicao = pesquisarProducao(codProd);
            ListaProducao.getInstance().set(posicao,producao);
            
            JOptionPane.showMessageDialog(null,"Dados da produção atualizados com sucesso","Aviso",1);
            
        }
    }

    private int pesquisarProducao(int codProd) {
        
        int posicao = -1;
        for(int i = 0; i < ListaProducao.getInstance().size(); i++){
            if(ListaProducao.getInstance().get(i).getCodProd() == codProd){
                posicao = i;
            }
        }
        return posicao;
    }
    
    public void tabelaRend(JTable jTabela){
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();
       
        dtm.setRowCount(AuxRend.getInstance().size());
        jTabela.setModel(dtm);
        
        int posicaoLinha = 0;

        for(int i=0; i < AuxRend.getInstance().size(); i++){

            jTabela.setValueAt(AuxRend.getInstance().get(i).getPesoCru(), posicaoLinha, 0);
            posicaoLinha += 1;
            
        }
    }
    
    public void tabelaRend(JTable jTabela, List<Object> ListaProducao){
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();
       
        dtm.setRowCount(1);
        jTabela.setModel(dtm);
        
        int posicaoLinha = 0;

        for(int i=0; i < 1; i++){

            jTabela.setValueAt(Double.parseDouble(ListaProducao.get(7).toString()), posicaoLinha, 0);
            posicaoLinha += 1;
            
        }
    }
    
    public void tabelaCalculoTotal(JTable jTabela, List<Object> ListaProducao){
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();
       
        dtm.setRowCount(1);
        jTabela.setModel(dtm);
        
        int posicaoLinha = 0;

        for(int i=0; i < 1; i++){

            jTabela.setValueAt(Double.parseDouble(ListaProducao.get(8).toString()), posicaoLinha, 0);
            posicaoLinha += 1;
            
        }
    }
    
    public void tabelaCalculoTotal(JTable jTabela){
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();
       
        dtm.setRowCount(AuxCalculoTotal.getInstance().size());
        jTabela.setModel(dtm);
        
        int posicaoLinha = 0;

        for(int i=0; i < AuxCalculoTotal.getInstance().size(); i++){

            jTabela.setValueAt(AuxCalculoTotal.getInstance().get(i).getValorTotal(), posicaoLinha, 0);
            posicaoLinha += 1;
            
        }
    }
}
