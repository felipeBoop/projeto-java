
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

public class ListaProducao {
    
        
    private static List<Producao> lista;
    
    private ListaProducao(){}
    
    public static List<Producao> getInstance(){
        if(lista == null){
            lista = new ArrayList<>();
        }
        return lista;
    }
    
}