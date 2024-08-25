/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class InterpretadorMonolitico {
    //private Map<String, Integer> variaveis = new HashMap<>();
    private ArrayList<String> fLinhas = new ArrayList<String>();
    private int fLinhaAtual = 0;
    
    public InterpretadorMonolitico(ArrayList<String> byListString) {
        this.fLinhas = byListString;
    }

    public String executar() {
        String mLinha = "";
        String mRetorno = "";
        
        while(true){
            if (fLinhaAtual > fLinhas.size() - 1) { break; }
            
            mLinha = fLinhas.get(fLinhaAtual).substring(3, fLinhas.get(fLinhaAtual).length());
            if (mLinha.startsWith("se")) {
                processarCondicional(mLinha);
            } else if (mLinha.startsWith("vá_para")) {
                ProcessaOperacao(mLinha);
            } else if (mLinha.startsWith("faça")) {
                ProcessaFaca(mLinha);
            } else if (mLinha.startsWith("add")) {
                ProcessaOperacao(mLinha);
            } else if (mLinha.startsWith("sub")) {
               ProcessaOperacao(mLinha);
            } else {
                mRetorno = "Instrução desconhecida";
                break;
            }
        }
        return mRetorno;
    }
    
    private void processarCondicional(String byLinha) {        
        String condicao = byLinha.substring(byLinha.indexOf("se") + 2, byLinha.indexOf("então")).trim();
        String condVerdadeiro = byLinha.substring(byLinha.indexOf("então") + 5, byLinha.indexOf("senão")).trim();
        String condFalso = byLinha.substring(byLinha.indexOf("senão") + 5, byLinha.length()).trim();

        if (Macro.Zero(condicao) == true) {
            ProcessaOperacao(condVerdadeiro);
        } else {
            ProcessaOperacao(condFalso);
        }
    }
    
    private void ProcessaFaca(String byLinha){
        String mPartes[] = byLinha.split(" ");
        ProcessaOperacao(mPartes[1]);
        if (mPartes.length >= 2 &&  mPartes.length <= 3) {
            processarSalto(mPartes[2] + " " + mPartes[3]);
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
}
