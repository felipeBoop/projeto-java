
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCliente {
    
    private static List<Cliente> lista;
    
    private ListaCliente(){}
    
    public static List<Cliente> getInstance(){
        if(lista == null){
            lista = new ArrayList<>();
        }
        return lista;
    }
    
}
