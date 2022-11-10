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
    
    public static List<CalculoTotal> getInstance(){
       
        if(lista == null){
            lista = new ArrayList<>();
        }
        
        return lista;
    }
    
}
