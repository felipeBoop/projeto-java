
package com.empresa.controleproducao.model;

public class TorraEscura extends TipoTorra{
    
    private double perca = 0.25;

    public double getPerca() {
        return perca;
    }

    public void setPerca(double perca) {
        this.perca = perca;
    }
   
    //herda o método de tipo torra, e é responsável por calcular o rendimento
    @Override
    public double Calcular(double pesoCru) {
        
        pesoCru = pesoCru - (pesoCru * this.perca);
        return pesoCru;
    }
}

