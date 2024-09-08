/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author PC
 */
public class Macro {
    
    public static boolean Zero(String byCondicao){        
        String[] mSplitCond = byCondicao.split("_");
        String mRegistradorNome = mSplitCond[1];
        int mRegistradorValor = InterpretadorMonolitico.BuscaValorRegistrador(mRegistradorNome); 
        return mRegistradorValor == 0;
    }
    
    public static void Add(String byCondicao){
        String[] mSplitCond = byCondicao.split("_");
        String mRegistradorNome = mSplitCond[1];
        int mRegistradorValor = InterpretadorMonolitico.BuscaValorRegistrador(mRegistradorNome);        
        InterpretadorMonolitico.AtualizarValorRegistrador(mRegistradorNome, mRegistradorValor + 1);
    }
    
    public static void Sub(String byCondicao){
        String[] mSplitCond = byCondicao.split("_");
        String mRegistradorNome = mSplitCond[1];
        int mRegistradorValor = InterpretadorMonolitico.BuscaValorRegistrador(mRegistradorNome);        
        InterpretadorMonolitico.AtualizarValorRegistrador(mRegistradorNome, mRegistradorValor - 1);
    }
       
    public static boolean Menor(String byCondicao){
        MaiorMenor mm = new MaiorMenor(byCondicao);
        return mm.executa();
    }
    
    public static boolean Igual(String byCondicao){
        Igual i = new Igual(byCondicao);
        return i.executa();
    }
}
