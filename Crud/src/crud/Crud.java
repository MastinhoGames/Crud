/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import DAOs.JogoDAO;
import modelo.Jogos;
import tela.Cadastro;
import tela.JfrmJogos;

/**
 *
 * @author joao
 */
public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jogos mod = new Jogos();
        JogoDAO modC = new JogoDAO();
        JfrmJogos frm = new JfrmJogos();
        Cadastro c = new Cadastro(frm, true);
        
        frm.setVisible(true);
        c.setVisible(false);

    }
    
    
    
}
