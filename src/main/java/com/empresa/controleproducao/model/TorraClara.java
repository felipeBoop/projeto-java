
package com.empresa.controleproducao.model;

public class TorraClara extends TipoTorra{
    
    private double perca = 0.15;

    public double getPerca() {
        return perca;
    }

    public void setPerca(double perca) {
        this.perca = perca;
    }
   
    @Override
    public void Calcular(double pesoCru) {
        
        pesoCru = pesoCru-(pesoCru*perca);
        
    }
   
}
