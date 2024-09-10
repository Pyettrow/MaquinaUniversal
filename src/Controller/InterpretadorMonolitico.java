/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Registrador;
import View.frmPrincipal;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class InterpretadorMonolitico {
    private ArrayList<String> fListLinhas = new ArrayList<>();
    private static ArrayList<Registrador> fListRegistradores = new ArrayList();
    private int fLinhaAtual = 0;
    private int fSubLinha = 0;
    private frmPrincipal frmPrincipal;
    
    public InterpretadorMonolitico(ArrayList<String> byListString, ArrayList<Registrador> byListRegistradores, JFrame byForm, int bySubLinha) {
        this.fListLinhas = byListString;
        this.fListRegistradores = byListRegistradores;
        this.frmPrincipal = (frmPrincipal) byForm;
        if (bySubLinha > 0) {
            this.fSubLinha = bySubLinha;
        }
    }

    public boolean executar() {
        String mLinha = "";
        boolean mRetorno = false;
        
        while(true){
            
            ImprimeLinha(fLinhaAtual);
            if (fLinhaAtual > fListLinhas.size() - 1) { break; }
            
            mLinha = fListLinhas.get(fLinhaAtual).substring(3, fListLinhas.get(fLinhaAtual).length());
            if (mLinha.startsWith("se")) {
                mRetorno = processarCondicional(mLinha);
            } else if (mLinha.startsWith("vá_para")) {
                ProcessaOperacao(mLinha);
            } else if (mLinha.startsWith("faça")) {
                ProcessaFaca(mLinha);
            } else if (mLinha.startsWith("add")) {
                ProcessaOperacao(mLinha);
            } else if (mLinha.startsWith("sub")) {
                ProcessaOperacao(mLinha);
            } else {
                mRetorno = false;
                break;
            }    
        }
        return mRetorno;
    }
    
    private boolean processarCondicional(String byLinha) {        
        boolean mRetorno = false;
        String condicao = byLinha.substring(byLinha.indexOf("se") + 2, byLinha.indexOf("então")).trim();
        String condVerdadeiro = byLinha.substring(byLinha.indexOf("então") + 5, byLinha.indexOf("senão")).trim();
        String condFalso = byLinha.substring(byLinha.indexOf("senão") + 5, byLinha.length()).trim();

        if (condicao.startsWith("zero_")) {
            mRetorno = Macro.Zero(condicao);
        }else if (condicao.startsWith("maior_")) {
            mRetorno = Macro.MenorMaior(condicao, this.frmPrincipal, fLinhaAtual + 1, 2);
        }else if (condicao.startsWith("menor_")) {
            mRetorno = Macro.MenorMaior(condicao, this.frmPrincipal, fLinhaAtual + 1, 1);
        }else if (condicao.startsWith("igual_")) {
            mRetorno = Macro.Igual(condicao, this.frmPrincipal, fLinhaAtual + 1);                
        }
        
        if (mRetorno) {
            ProcessaOperacao(condVerdadeiro);
            return true;
        } else {
            ProcessaOperacao(condFalso);
            return false;
        }
    }
    
    private void ProcessaFaca(String byLinha){
        String mPartes[] = byLinha.split(" ");
        ProcessaOperacao(mPartes[1]);
        if (mPartes.length >= 2) {
            if (mPartes[2].equals("vá_para")) {
                processarSalto(mPartes[2] + " " + mPartes[3]);
            }
        }        
    }
    
    private void ProcessaOperacao(String byLinha){
        if(byLinha.contains("add_")){
            Macro.Add(byLinha);
        }else if(byLinha.contains("sub_")){
            Macro.Sub(byLinha);
        }if(byLinha.contains("vá_para")){
            processarSalto(byLinha);
        }
    }
   
    private void processarSalto(String linha) {
        String[] partes = linha.trim().split(" ");
        fLinhaAtual = Integer.parseInt(partes[1]) - 1;
    }
    
    //Método que irá buscar o valor do registrado passando como parâmentro somente seu nome
    public static int BuscaValorRegistrador(String byRegistradorNome){
        for (Registrador reg : fListRegistradores) {
            if (reg.getNome().toUpperCase().equals(byRegistradorNome.toUpperCase())) {
                return reg.getValor();
            }
        }
        return -1;
    }
    
    //Método para alterar o valor de um registrador passando somente o seu nome
    public static void AtualizarValorRegistrador(String byRegistradorNome, int byNovoValor) {
        for (Registrador reg : fListRegistradores) {
            if (reg.getNome().toUpperCase().equals(byRegistradorNome.toUpperCase())) {
                reg.setValor(byNovoValor);
                break;
            }
        }
    }
    
    //Método que a cada linha processada irá printar o txtResultado.
    public void ImprimeLinha(int byLinha){
        String mValorRegistradores = "";
        String mTextoImpressao = "";
        for (Registrador reg : fListRegistradores) {
            if (mValorRegistradores.equals("")){
                mValorRegistradores = String.valueOf(reg.getValor());
            }else{
                mValorRegistradores += ", " + reg.getValor();
            }
        }

        if (fSubLinha == 0) {
            mTextoImpressao = "(" + (byLinha + 1) + ", (" + mValorRegistradores + "))";
        }else{
            mTextoImpressao = "--(" + (byLinha + 1) + ", (" + mValorRegistradores + "))";
        }
        if (byLinha <= fListLinhas.size()) 
            mTextoImpressao += "    ->" + fListLinhas.get(byLinha);
        
        this.frmPrincipal.EscreveResultado(mTextoImpressao);
    }
}