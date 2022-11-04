
package com.empresa.controleproducao.controller;

import com.empresa.controleproducao.model.ListaProducao;
import com.empresa.controleproducao.model.Producao;

public class ProducaoController {
    
    public boolean cadastrarP(int codProd,String data,int idCliP,int lote,double pesoCru,String tipoTorra,double precoKg,double rendimento,double precoTotal){
        Producao producao = new Producao(codProd,data,idCliP,lote,pesoCru,tipoTorra,precoKg,rendimento,precoTotal);
        return ListaProducao.getInstance().add(producao);
    }
    
}
