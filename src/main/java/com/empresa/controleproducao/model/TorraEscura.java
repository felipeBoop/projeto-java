
package com.empresa.controleproducao.model;

public class TorraEscura extends TipoTorra{
    
    private double perca = 0.25;

    public double getPerca() {
        return perca;
    }

    public void setPerca(double perca) {
        this.perca = perca;
    }
   
    @Override
    public double Calcular(double pesoCru) {
        
        pesoCru = pesoCru-(pesoCru*perca);
        return pesoCru;
    }
}

