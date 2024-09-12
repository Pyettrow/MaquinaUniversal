/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Registrador;
import java.util.ArrayList;
import View.frmPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class MaiorMenor {
    private final ArrayList<String> fLinhasMonolitico = new ArrayList<>();
    private final ArrayList<Registrador> fListRegistradores = new ArrayList<>();
    private final frmPrincipal frmPrincipal;
    private final int fLinhaPai;
    private final int fMenorMaior;

    /**
     * byMenorMaior: 1 - Menor | 2 - Maior
     */
    public MaiorMenor(String byCondicao, JFrame byFrm, int byLinha, int byMenorMaior) {
        this.frmPrincipal = (frmPrincipal) byFrm;        
        this.fLinhaPai = byLinha;        
        this.fMenorMaior = byMenorMaior; 
        //Considerando que a entrada do MaiorMenor seja: menor_a_b
        String[] mSplitCond = byCondicao.split("_");
        Registrador reg1 = new Registrador(0, InterpretadorMonolitico.BuscaValorRegistrador(mSplitCond[1]));
        fListRegistradores.add(reg1);
        Registrador reg2 = new Registrador(1, InterpretadorMonolitico.BuscaValorRegistrador(mSplitCond[2]));
        fListRegistradores.add(reg2);
        PreenchendoNormaMenor();
    }
    
    private void PreenchendoNormaMenor(){
        fLinhasMonolitico.add("1: se zero_a então vá_para 5 senão vá_para 2");
        fLinhasMonolitico.add("2: se zero_b então vá_para 8 senão vá_para 3");
        fLinhasMonolitico.add("3: faça sub_a vá_para 4");
        fLinhasMonolitico.add("4: faça sub_b vá_para 1");
        /*Vai entrar aqui para verificar se o B é igual a ZERO
        • Se for Zero: Deve retornar FALSE. Add um no B só para retonar FALSE na linha 7
        • Se não for Zero: Deve retonar TRUE. Vai para linha 8 e valida se A é ZERO(Sempre é).*/
        fLinhasMonolitico.add("5: se zero_b então vá_para 6 senão vá_para 8");
        fLinhasMonolitico.add("6: faça add_b vá_para 7");
        fLinhasMonolitico.add("7: se zero_b então vá_para 9 senão vá_para 10");
        /*Só entrará aqui para Retornar TRUE*/
        fLinhasMonolitico.add("8: se zero_a então vá_para 9 senão vá_para 10");
    }
    
    private void PreenchendoNorma(){
        fLinhasMonolitico.add("1: se zero_a então vá_para 9 senão vá_para 2");
        fLinhasMonolitico.add("2: se zero_b então vá_para 5 senão vá_para 3");
        fLinhasMonolitico.add("3: faça sub_a vá_para 4");
        fLinhasMonolitico.add("4: faça sub_b vá_para 1");
        fLinhasMonolitico.add("5: se zero_b então vá_para 1 senão vá_para 10");
    }
    
    public boolean executa(){
        InterpretadorMonolitico mInterpretador = new InterpretadorMonolitico(fLinhasMonolitico, fListRegistradores, frmPrincipal, fLinhaPai);
        return mInterpretador.executar();
    }
}
