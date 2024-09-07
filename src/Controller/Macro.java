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
        Zero zero = new Zero(byCondicao);
        return zero.executa();
    }
    
    public static int Add(String byCondicao){
        Add add = new Add(byCondicao);
        //return add.executa();
        return 0;
    }
    
    public static int Sub(String byCondicao){
        Sub sub = new Sub(byCondicao);
        //return sub.executa();
        return 0;
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
