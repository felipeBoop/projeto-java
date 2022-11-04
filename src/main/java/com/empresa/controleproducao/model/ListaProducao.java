
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

public class ListaProducao {
    
        
    private static List<Producao> listaP;
    
    private ListaProducao(){}
    
    public static List<Producao> getInstance(){
        if(listaP == null){
            listaP = new ArrayList<>();
        }
        return listaP;
    }
    
}