/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class Registrador {
    private String Nome;
    private int Valor;
    private String[] fAlfabeto;

    public Registrador(int byNumeroReg, int byValor) {
        this.fAlfabeto = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.Nome = fAlfabeto[byNumeroReg];
        this.Valor = byValor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public String[] getfAlfabeto() {
        return fAlfabeto;
    }

    public void setfAlfabeto(String[] fAlfabeto) {
        this.fAlfabeto = fAlfabeto;
    }
}
