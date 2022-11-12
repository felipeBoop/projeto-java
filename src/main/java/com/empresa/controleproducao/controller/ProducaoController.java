
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
        //cria o objeto para cadastro
        Producao producao = new Producao(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg, precoTotal, rendimento);
        return ListaProducao.getInstance().add(producao);
    }
    
    //responsável por adicionar o rendimento na tabela aux de rendimento
    public boolean cadastrarRend(double pesoCru){
        Rendimento rendimento = new Rendimento(pesoCru);
        return AuxRend.getInstance().add(rendimento);
    }
    
    //responsável por adicionar o calculoTotal na tabela aux do calculo total
    public boolean cadastrarCalculoTotal(double valorTotal){
        CalculoTotal calculo = new CalculoTotal(valorTotal);
        return AuxCalculoTotal.getInstance().add(calculo);
    }
    
    public void preencherTabela(JTable jTabela){
        
        //cria o modelo da tabela
        DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

        //seta a quantidade de linhas
        dtm.setRowCount(ListaProducao.getInstance().size());
        jTabela.setModel(dtm);

        int posicaoLinha = 0;

        //para cada produção é atribuida uma nova linha com os valores da lista.
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
        try{
         
            //verifica se possui itens selecionados
            if(jTabela.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Selecione uma produção na tabela", "Aviso", 0);
            }else{

                int resposta = JOptionPane.showConfirmDialog(
                        null,
                        "Tem certeza que deseja excluir a produção?",
                        "Aviso",
                        JOptionPane.YES_NO_OPTION
                );

                //primeiro remoção e então o preenchimento da tabela para atualizar a tabela.
                if (resposta == JOptionPane.YES_OPTION){
                    ListaProducao.getInstance().remove(jTabela.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Produção excluida com sucesso!", "Aviso", 1);

                    preencherTabela(jTabela);
                }
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir! - Erro: " + ex,"Aviso",0);
        }
    }

    public List<Object> pesquisa(int id) {
        
        boolean achou  = false;
        int posicao = -1;
        
        //pesquisa o index do id na lista de produção.
        for(int i = 0; i < ListaProducao.getInstance().size(); i++){
            if(ListaProducao.getInstance().get(i).getCodProd() == id){
                achou = true;
                posicao = i;
            }
        }
        
        //caso tenha achado o id da produção é preenchuido um array que passara as informações para a view afim de preencher as tabelas
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
        
        try{
         
            int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar os dados da produção?","Aviso",JOptionPane.YES_NO_OPTION);
        
            if(resposta == JOptionPane.YES_OPTION){
                //criação de objeto com os elementos alterados
                Producao producao = new Producao(codProd, data, idCliP, lote, pesoCru, tipoTorra, precoKg, precoTotal, rendimento);
                //busca pela posicao da produção na lista
                int posicao = pesquisarProducao(codProd);
                //seta na posicao pesquisada a produção editada
                ListaProducao.getInstance().set(posicao,producao);

                JOptionPane.showMessageDialog(null,"Dados da produção atualizados com sucesso","Aviso",1);

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao editar ! - Erro: " + ex,"Aviso",0);
        }
    }

    //retorna o index do cliente dentro da lista
    private int pesquisarProducao(int codProd) {
        
        int posicao = -1;
        
        // pesquisa pelo id do cliente
        for(int i = 0; i < ListaProducao.getInstance().size(); i++){
            if(ListaProducao.getInstance().get(i).getCodProd() == codProd){
                posicao = i;
            }
        }
        return posicao;
    }
    
    //preenche a tabela que mostra o valor de rendimento na tela cadastro de produção
    public void tabelaRend(JTable jTabela){
        
        try{
         
            //carrega o modelo da tabela
            DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

            //define a quantidade de linhas
            dtm.setRowCount(AuxRend.getInstance().size());
            jTabela.setModel(dtm);

            int posicaoLinha = 0;

            for(int i=0; i < AuxRend.getInstance().size(); i++){

                //seta o valor na cédula da tabela
                jTabela.setValueAt(AuxRend.getInstance().get(i).getPesoCru(), posicaoLinha, 0);
                posicaoLinha += 1;

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao carregar valor de rendimento! - Erro: " + ex,"Aviso",0);
        }
    }
    
    //preenche a tabela que mostra o valor de rendimento na tela editar produção
    public void tabelaRend(JTable jTabela, List<Object> ListaProducao){
        
        try{
         
            //carrega o modelo da tabela
            DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

            //define a quantidade de linhas
            dtm.setRowCount(1);
            jTabela.setModel(dtm);

            int posicaoLinha = 0;

            for(int i=0; i < 1; i++){

                //seta o valor na cédula da tabela
                jTabela.setValueAt(Double.parseDouble(ListaProducao.get(7).toString()), posicaoLinha, 0);
                posicaoLinha += 1;

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao carregar valor de rendimento! - Erro: " + ex,"Aviso",0);
        }
    }
    
    public void tabelaCalculoTotal(JTable jTabela, List<Object> ListaProducao){
        
        try{
        
            //carrega o modelo da tabela
            DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

            //define a quantidade de linhas
            dtm.setRowCount(1);
            jTabela.setModel(dtm);

            int posicaoLinha = 0;

            for(int i=0; i < 1; i++){

                //seta o valor na cédula da tabela
                jTabela.setValueAt(Double.parseDouble(ListaProducao.get(8).toString()), posicaoLinha, 0);
                posicaoLinha += 1;

            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao carregar valor de total! - Erro: " + ex,"Aviso",0);
        }
    }
    
    //preenche a tabela que mostra o valor de calculo na tela editar produção
    public void tabelaCalculoTotal(JTable jTabela){
        
        try{
         
            //carrega o modelo da tabela
            DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

            //define a quantidade de linhas
            dtm.setRowCount(AuxCalculoTotal.getInstance().size());
            jTabela.setModel(dtm);

            int posicaoLinha = 0;

            for(int i=0; i < AuxCalculoTotal.getInstance().size(); i++){

                //seta o valor na cédula da tabela
                jTabela.setValueAt(AuxCalculoTotal.getInstance().get(i).getValorTotal(), posicaoLinha, 0);
                posicaoLinha += 1;

            }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao carregar valor de total! - Erro: " + ex,"Aviso",0);
        }
    }
}
