/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
/**
 *
 * @author PC
 */
public class Zero {
    String fRegistradorNome;
    int fRegistradorValor;

    public Zero(String byCondicao) {
        String[] mSplitCond = byCondicao.split("_");
        this.fRegistradorNome = mSplitCond[1];
        this.fRegistradorValor = InterpretadorMonolitico.BuscaValorRegistrador(fRegistradorNome);
    }
    
    public boolean executa(){
        return fRegistradorValor == 0;
    }
}
