
package com.empresa.controleproducao.controller;

import com.empresa.controleproducao.model.ListaProducao;
import com.empresa.controleproducao.model.Producao;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProducaoController {
    
    public boolean cadastrarP(int codProd,String data,int idCliP,int lote,double pesoCru,String tipoTorra,double precoKg){
        Producao producao = new Producao(codProd,data,idCliP,lote,pesoCru,tipoTorra,precoKg);
        return ListaProducao.getInstance().add(producao);
    }
    
    public boolean rendTotal(double pesoCru, String tipoTorra, double precoKg){
        
        RendTotal calculo = new RendTotal(pesoCru,tipoTorra,precoKg);
        return 
        
    }
    
    
    

    public void preencherTabela(JTable jTabela){
        
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

        dtm.setRowCount(ListaProducao.getInstance().size());
        jTabela.setModel(dtm);

        int posicaoLinha = 0;

        for(int i=0; i < ListaProducao.getInstance().size(); i++){

            jTabela.setValueAt(ListaProducao.getInstance().get(i).getCodProd(), posicaoLinha, 0);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getData(), posicaoLinha, 1);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getIdCliP(), posicaoLinha, 2);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getLote(), posicaoLinha, 3);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getPesoCru(), posicaoLinha, 4);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getTipoTorra(), posicaoLinha, 5);
            jTabela.setValueAt(ListaProducao.getInstance().get(i).getPrecoKg(), posicaoLinha, 6);

            posicaoLinha += 1;
        }
          
    }
    
    public void excluir (JTable jTabela){
        
        if(jTabela.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione uma produção na tabela", "Aviso", 0);
        }else{

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja exlcuir a produção?",
                    "Aviso",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION){
                ListaProducao.getInstance().remove(jTabela.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Excluido com suceesso!", "Aviso", 1);

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
            
            return Arrays.asList(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg);
        }
        else{
            JOptionPane.showMessageDialog(null,"Produção não encontrada!","Aviso",0);
            return null;
        }
    }

    public void editar(int codProd, String data, int idCliP, int lote, double pesoCru, String tipoTorra, double precoKg) {
        
        int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar os dados da produção?","Aviso",JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            Producao producao = new Producao(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg);
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
}