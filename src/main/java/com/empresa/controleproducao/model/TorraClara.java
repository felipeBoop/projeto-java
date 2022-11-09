
package com.empresa.controleproducao.model;

public class TorraClara extends TipoTorra{
    
    private double perca = 0.15d;

    public double getPerca() {
        return perca;
    }

    public void setPerca(double perca) {
        this.perca = perca;
    }
   
    @Override
    public double Calcular(double pesoCru) {
        
        pesoCru = pesoCru - (pesoCru * this.perca);
        return pesoCru;
        
    }
   
}
