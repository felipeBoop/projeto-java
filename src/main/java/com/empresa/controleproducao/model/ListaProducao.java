
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

public class ListaProducao {
    
        
    private static List<Producao> lista;
    
    private ListaProducao(){}
    
    //cria a lista responsável por guardar os produtos
    public static List<Producao> getInstance(){
        
        //caso exista a lista, irá somente retornar a mesma, caso não exista ele instância ela.
        if(lista == null){
            lista = new ArrayList<>();
        }
        return lista;
    }
    
}