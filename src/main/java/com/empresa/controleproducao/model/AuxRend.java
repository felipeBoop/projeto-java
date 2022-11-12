/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.controleproducao.model;

import java.util.ArrayList;
import java.util.List;

public class AuxRend {
    
    private static List<Rendimento> lista;

    private AuxRend(){}
    
    //cria a lista responsável por atualizar os valores no cálculo do rendimento
    public static List<Rendimento> getInstance(){
       
        //caso exista a lista, irá somente retornar a mesma, caso não exista ele instância ela.
        if(lista == null){
            lista = new ArrayList<>();
        }
        
        return lista;
    }  
}
