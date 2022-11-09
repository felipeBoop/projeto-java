
package com.empresa.controleproducao.model;

public class TorraMedia extends TipoTorra{
    
    private double perca = 0.20;

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
