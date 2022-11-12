
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCliente {
    
    private static List<Cliente> lista;
    
    private ListaCliente(){}
    
    //cria a lista responsável por guardar os clientes
    public static List<Cliente> getInstance(){
        
        //caso exista a lista, irá somente retornar a mesma, caso não exista ele instância ela.
        if(lista == null){
            lista = new ArrayList<>();
        }
        return lista;
    }
    
}
