
package com.empresa.controleproducao.controller;

import com.empresa.controleproducao.model.Cliente;
import com.empresa.controleproducao.model.ListaCliente;

public class ClienteController {
    
    public boolean cadastrar(int idCli, String nomeCli, String celCli, String emailCli){
        Cliente cliente = new Cliente(idCli,nomeCli,celCli,emailCli);
        return ListaCliente.getInstance().add(cliente);
    }
    
}
