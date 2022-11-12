
package com.empresa.controleproducao.model;

public class Producao {
    
    private int codProd;
    private String data;
    private int idCliP;
    private int lote;
    private double pesoCru;
    private String tipoTorra;
    private double precoKg;
    private double precoTotal;
    private double rendimento;
    
    public Producao(int codProd, String data, int idCliP, int lote, double pesoCru, String tipoTorra, double precoKg, double precoTotal, double rendimento) {
        this.codProd = codProd;
        this.data = data;
        this.idCliP = idCliP;
        this.lote = lote;
        this.pesoCru = pesoCru;
        this.tipoTorra = tipoTorra;
        this.precoKg = precoKg;
        this.precoTotal = precoTotal;
        this.rendimento = rendimento;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int cod) {
        this.codProd = cod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdCliP() {
        return idCliP;
    }

    public void setIdCliP(int idCliente) {
        this.idCliP = idCliente;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public double getPesoCru() {
        return pesoCru;
    }

    public void setPesoCru(double pesoCru) {
        this.pesoCru = pesoCru;
    }

    public String getTipoTorra() {
        return tipoTorra;
    }

    public void setTipoTorra(String tipoTorra) {
        this.tipoTorra = tipoTorra;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void setPrecoKg(double precoKg) {
        this.precoKg = precoKg;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
