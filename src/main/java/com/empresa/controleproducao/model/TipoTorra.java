
package com.empresa.controleproducao.model;

public abstract class TipoTorra {
    
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    //método responsável pelo calculo de rendimento
    public abstract double Calcular(double pesoCru);
    
}
