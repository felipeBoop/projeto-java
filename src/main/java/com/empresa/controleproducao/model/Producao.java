
package com.empresa.controleproducao.model;

public class Producao {
    
    private int codProd;
    private String data;
    private int idCliP;
    private int lote;
    private double pesoCru;
    private String tipoTorra;
    private double precoKg;
    private double rendimento;
    private double precoTotal;

    public Producao(int codProd, String data, int idCliP, int lote, double pesoCru, String tipoTorra, double precoKg, double rendimento, double precoTotal) {
        this.codProd = codProd;
        this.data = data;
        this.idCliP = idCliP;
        this.lote = lote;
        this.pesoCru = pesoCru;
        this.tipoTorra = tipoTorra;
        this.precoKg = precoKg;
        this.rendimento = rendimento;
        this.precoTotal = precoTotal;
    }

    public Producao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public double calcularRendimento(String tipoTorra,double peso){
        if("Torra Clara".equals(tipoTorra)){
            peso = peso+(peso*0.15);
            return peso;
        }
        else if("Torra Media".equals(tipoTorra)){
            peso = peso+(peso*0.20);
            return peso;
        }
        else{
            peso = peso+(peso*0.25);
            return peso;
        }
    }
    
    public double calcularPrecoTotal(double pesoCru,double precoKg){
        double precoTotal;
        precoTotal = pesoCru*precoKg;
        return precoTotal;
    }
    
 
}
