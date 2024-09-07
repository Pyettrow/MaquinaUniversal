/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Registrador;
import View.frmPrincipal;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class MaiorMenor {
    ArrayList<String> fLinhasMonolitico = new ArrayList<>();
    ArrayList<Registrador> fListRegistradores = new ArrayList<>();

    public MaiorMenor(String byCondicao) {
        //Considerando que a entrada do MaiorMenor seja: menor_a_b
        String[] mSplitCond = byCondicao.split("_");
        Registrador reg1 = new Registrador(0, InterpretadorMonolitico.BuscaValorRegistrador(mSplitCond[1]));
        fListRegistradores.add(reg1);
        Registrador reg2 = new Registrador(1, InterpretadorMonolitico.BuscaValorRegistrador(mSplitCond[2]));
        fListRegistradores.add(reg2);
        PreenchendoNorma();
    }
    
    private void PreenchendoNorma(){
        fLinhasMonolitico.add("1: sub_a vá_para 2");
        fLinhasMonolitico.add("2: se zero_a então vá_para 9 senão vá_para 3");
        fLinhasMonolitico.add("3: sub_b vá_para 4");
        fLinhasMonolitico.add("4: se zero_b então vá_para 10 senão vá_para 4");
        fLinhasMonolitico.add("5: vá_para 1");
    }
    
    public boolean executa(){
        InterpretadorMonolitico mInterpretador = new InterpretadorMonolitico(fLinhasMonolitico, fListRegistradores, null);
        mInterpretador.executar();
        return true;
    }
}
