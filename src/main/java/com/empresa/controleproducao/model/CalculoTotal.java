/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.controleproducao.model;

/**
 *
 * @author lipec
 */
public class CalculoTotal {
    
    private double valorTotal;

    public CalculoTotal(){};
    
    public CalculoTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    //metodo responsável por calcular o valor total
    public double calcular(double pesoCru, double precoKg){
        
        return pesoCru * precoKg;
        
    }
    
}
