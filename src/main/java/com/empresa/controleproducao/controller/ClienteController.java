
package com.empresa.controleproducao.controller;

import com.empresa.controleproducao.model.Cliente;
import com.empresa.controleproducao.model.ListaCliente;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteController {
    
    public boolean cadastrar(int idCli, String nomeCli, String celCli, String emailCli){
        Cliente cliente = new Cliente(idCli,nomeCli,celCli,emailCli);
        return ListaCliente.getInstance().add(cliente);
    }
    
    public void preencherTabela(JTable jTabela){
     
        try{
         
            //cria o modelo da tabela
            DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();

            //seta a quantidade de linhas
            dtm.setRowCount(ListaCliente.getInstance().size());
            jTabela.setModel(dtm);

            int posicaoLinha = 0;

            //para cada cliente, é atribuido os valores para as linhas.
            for(int i=0; i < ListaCliente.getInstance().size(); i++){

                jTabela.setValueAt(ListaCliente.getInstance().get(i).getId(), posicaoLinha, 0);
                jTabela.setValueAt(ListaCliente.getInstance().get(i).getNome(), posicaoLinha, 1);
                jTabela.setValueAt(ListaCliente.getInstance().get(i).getCelular(), posicaoLinha, 2);
                jTabela.setValueAt(ListaCliente.getInstance().get(i).getEmail(), posicaoLinha, 3);

                posicaoLinha += 1;
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao preencher tabela! - Erro:" + ex, "Erro!", 0);
        }     
    }
    
    public void excluir (JTable jTabela){
       
        try{
        
            //verifica se possui itens selecionados
            if(jTabela.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela", "Aviso", 0);
            }else{

                int resposta = JOptionPane.showConfirmDialog(
                        null,
                        "Tem certeza que deseja excluir o cliente?",
                        "Aviso",
                        JOptionPane.YES_NO_OPTION
                );

                //primeiro remoção, e então o preenchimento da tabela novamente para atualizar a tabela.
                if (resposta == JOptionPane.YES_OPTION){
                    ListaCliente.getInstance().remove(jTabela.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Excluido com suceesso!", "Aviso", 1);

                    preencherTabela(jTabela);
                }
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Falha ao Excluir! - Erro:" + ex, "Erro!", 0);
        } 
    }

    public List<Object> pesquisar(int id) {
        boolean achou  = false;
        int posicao = -1;
        
        //pesquisa o index do id na lista de clientes.
        for(int i = 0; i < ListaCliente.getInstance().size(); i++){
            if(ListaCliente.getInstance().get(i).getId() == id){
                achou = true;
                posicao = i;
            }
        }
        
        //caso tenha achado o id do cliente é dada preenche um array que passara as informações para a view afim de preencher as tabelas
        if(achou == true){
            String nome = ListaCliente.getInstance().get(posicao).getNome();
            String celular= ListaCliente.getInstance().get(posicao).getCelular();
            String email= ListaCliente.getInstance().get(posicao).getEmail();
            
            return Arrays.asList(id,nome,celular,email);
        }
        else{
            JOptionPane.showMessageDialog(null,"Contato não encontrado!","Aviso",0);
            return null;
        }
    }
    
    public void editar(int id, String nome, String celular, String email) {
        
        int resposta = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar os dados do cliente?","Aviso",JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            //criação de objeto com os elementos alterados
            Cliente cliente = new Cliente(id,nome,celular,email);
            int posicao = pesquisarCliente(id); //busca pela posicao do cliente
            //seta na posicao pesquisada o cliente editado
            ListaCliente.getInstance().set(posicao,cliente);
            
            JOptionPane.showMessageDialog(null,"Dados do cliente atualizados com sucesso","Aviso",1);
            
        }
    }
    
    //retorna o index do cliente dentro da lista
    public int pesquisarCliente(int id){
        
        int posicao = -1;
        
        // pesquisa pelo id do cliente
        for(int i = 0; i < ListaCliente.getInstance().size(); i++){
            if(ListaCliente.getInstance().get(i).getId() == id){
                posicao = i;
            }
        }
        return posicao;
    }

    
}