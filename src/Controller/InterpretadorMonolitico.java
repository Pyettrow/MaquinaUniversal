/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Registrador;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class InterpretadorMonolitico {
    private ArrayList<String> fListLinhas = new ArrayList<String>();
    private ArrayList<Registrador> fListRegistradores = new ArrayList();
    private int fLinhaAtual = 0;
    
    public InterpretadorMonolitico(ArrayList<String> byListString, ArrayList<Registrador> byListRegistradores) {
        this.fListLinhas = byListString;
        this.fListRegistradores = byListRegistradores;
    }

    public String executar() {
        String mLinha = "";
        String mRetorno = "";
        
        while(true){
            if (fLinhaAtual > fListLinhas.size() - 1) { break; }
            
            mLinha = fListLinhas.get(fLinhaAtual).substring(3, fListLinhas.get(fLinhaAtual).length());
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
            String[] mLinhaSplit = byLinha.split("_");
            AtualizarValorRegistrador(mLinhaSplit[1], Macro.Add(byLinha));
        }else if(byLinha.contains("sub_")){
            AtualizarValorRegistrador("A", Macro.Sub(byLinha));
        }if(byLinha.contains("vá_para")){
            processarSalto(byLinha);
        }
    }

    private void processarSalto(String linha) {
        String[] partes = linha.trim().split(" ");
        fLinhaAtual = Integer.parseInt(partes[1]) - 1;
    }
    
    //Método para alterar o valor de um registrador passando somente o seu nome
    public void AtualizarValorRegistrador(String byNome, int byNovoValor) {
        for (Registrador reg : fListRegistradores) {
            if (reg.getNome().toUpperCase().equals(byNome.toUpperCase())) {
                reg.setValor(byNovoValor);
                break;
            }
        }
    }
}
