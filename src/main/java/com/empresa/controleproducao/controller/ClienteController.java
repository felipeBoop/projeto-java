
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
        
            DefaultTableModel dtm = (DefaultTableModel) jTabela.getModel();
        
            dtm.setRowCount(ListaCliente.getInstance().size());
            jTabela.setModel(dtm);

            int posicaoLinha = 0;

            for(int i=0; i < ListaCliente.getInstance().size(); i++){

                jTabela.setValueAt(ListaCliente.getInstance().get(i).getId(), posicaoLinha, 0);
                jTabela.setValueAt(ListaCliente.getInstance().get(i).getNome(), posicaoLinha, 1);
                jTabela.setValueAt(ListaCliente.getInstance().get(i).getCelular(), posicaoLinha, 2);
                jTabela.setValueAt(ListaCliente.getInstance().get(i).getEmail(), posicaoLinha, 3);

                posicaoLinha += 1;
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao preecher tabela! - Erro: " + ex, "Erro", 0);
        }
           
    }
    
    private void excluir (JTable jTabela){
        
        try{
         
            if(jTabela.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Selecione um contato na tabela", "Aviso", 0);
            }else{

                int resposta = JOptionPane.showConfirmDialog(
                        null,
                        "Tem certeza que deseja exlcuir o contato?",
                        "Aviso",
                        JOptionPane.YES_NO_OPTION
                );

                if (resposta == JOptionPane.YES_OPTION){
                    ListaCliente.getInstance().remove(jTabela.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Excluido com suceesso!", "Aviso", 1);

                    preencherTabela(jTabela);
                }
            }
            
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente! - Erro: " + ex, "Erro", 0);
        }
    }
    
    public List<Object> pesquisar (int id){
        
        try{
            
            boolean achou = false;
            int posicao = -1;

            for(int i = 0; i < ListaCliente.getInstance().size(); i++){

                if(ListaCliente.getInstance().get(i).getId() == id){
                    achou = true;
                    posicao = i;
                }
            }

            if(achou == true){
                String nome = ListaCliente.getInstance().get(posicao).getNome();
                String celular = ListaCliente.getInstance().get(posicao).getCelular();
                String email = ListaCliente.getInstance().get(posicao).getEmail();

                return Arrays.asList(id, nome, celular, email);
            }else{
                JOptionPane.showMessageDialog(null, "Contato não encontrado", "Aviso", 0);
                return null;
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Cliente! - Erro: " + ex, "Erro", 0);
            return null;
        }
    }
    
    private int pesquisarCliente(int id){
        
        int posicao = -1;
        
        for(int i = 0; i < ListaCliente.getInstance().size(); i++){
            if(ListaCliente.getInstance().get(i).getId() == id){
                posicao = i;
            }
        }
        
        return posicao;
    }
    
    public void editar(int id, String nome, String celular, String email){
        
        try{
            
            int resposta = JOptionPane.showConfirmDialog(
                        null,
                        "Tem certeza que deseja atualizar o Cliente?",
                        "Aviso",
                        JOptionPane.YES_NO_OPTION
            );

            if(resposta == JOptionPane.YES_OPTION){

                Cliente cliente = new Cliente(id, nome, celular, email);

                int posicao = pesquisarCliente(id); //retorna o indice do cliente
                ListaCliente.getInstance().set(posicao, cliente);

                JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!", "Aviso", 1);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao editar Cliente! - Erro: " + ex, "Erro", 0);
        }
    }
    
}
