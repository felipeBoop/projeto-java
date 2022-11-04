
package com.empresa.controleproducao.model;

public class Producao {
    
    private int cod;
    private String data;
    private int idCliP;
    private int lote;
    private double pesoCru;
    private String tipoTorra;
    private double precoKg;
    private double rendimento;
    private double precoTotal;

    public Producao(int cod, String data, int idCliP, int lote, double pesoCru, String tipoTorra, double precoKg, double rendimento, double precoTotal) {
        this.cod = cod;
        this.data = data;
        this.idCliP = idCliP;
        this.lote = lote;
        this.pesoCru = pesoCru;
        this.tipoTorra = tipoTorra;
        this.precoKg = precoKg;
        this.rendimento = rendimento;
        this.precoTotal = precoTotal;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    
    
}
