/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lipec
 */

public class AuxCalculoTotal {
    
    private static List<CalculoTotal> lista;

    private AuxCalculoTotal(){}
    
    //cria a lista responsável por atualizar os valores no cálculo do valor total
    public static List<CalculoTotal> getInstance(){
       
        //caso exista a lista, irá somente retornar a mesma, caso não exista ele instância ela.
        if(lista == null){
            lista = new ArrayList<>();
        }
        
        return lista;
    }
    
}
