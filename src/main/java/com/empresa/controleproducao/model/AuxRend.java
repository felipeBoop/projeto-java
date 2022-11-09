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
    
    public static List<Rendimento> getInstance(){
       
        if(lista == null){
            lista = new ArrayList<>();
        }
        /*else{
            lista = new ArrayList<>();
        }*/
        return lista;
    }  
}
