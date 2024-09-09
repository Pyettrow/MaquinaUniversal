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
public class Igual {
    private final ArrayList<String> fLinhasMonolitico = new ArrayList<>();
    private final ArrayList<Registrador> fListRegistradores = new ArrayList<>();
    private final frmPrincipal frmPrincipal;
    private final int fLinhaPai;

    public Igual(String byCondicao, JFrame byFrm, int byLinha) {
        this.frmPrincipal = (frmPrincipal) byFrm;        
        this.fLinhaPai = byLinha;
        //Considerando que a entrada do MaiorMenor seja: igual_a_b
        String[] mSplitCond = byCondicao.split("_");
        Registrador reg1 = new Registrador(0, InterpretadorMonolitico.BuscaValorRegistrador(mSplitCond[1]));
        fListRegistradores.add(reg1);
        Registrador reg2 = new Registrador(1, InterpretadorMonolitico.BuscaValorRegistrador(mSplitCond[2]));
        fListRegistradores.add(reg2);
        PreenchendoNorma();
    }
    
    private void PreenchendoNorma(){
        /**Se termina com: 
         * vá_para 9 = true
         * vá_para 10 = false*/
        fLinhasMonolitico.add("1: faça sub_a vá_para 2");
        fLinhasMonolitico.add("2: se zero_a então vá_para 5 senão vá_para 3");
        fLinhasMonolitico.add("3: faça sub_b vá_para 4");
        fLinhasMonolitico.add("4: se zero_b então vá_para 10 senão vá_para 1");
        fLinhasMonolitico.add("5: faça sub_b vá_para 6");
        fLinhasMonolitico.add("6: se zero_b então vá_para 9 senão vá_para 10");
    }
    
    public boolean executa(){
        InterpretadorMonolitico mInterpretador = new InterpretadorMonolitico(fLinhasMonolitico, fListRegistradores, frmPrincipal, fLinhaPai);
        return mInterpretador.executar();
    }
}
