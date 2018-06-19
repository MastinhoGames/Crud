/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOs;

import modelo.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conection;


/**
 * Classe criada para
 * @author Bruno César A. Capelosa
 * @since 18/06/2018 as 18:18:40
 */
public class CategoriaDAO extends Conection {
    
    
    // Método Salvar
    public boolean salvar(Categorias ca) {

        PreparedStatement ps;
        Connection con = getConection();

        String sql = "INSERT INTO generos (genero, descricao)VALUES(?,?)";
        StringBuffer sb = new StringBuffer(sql);
        try {
            //ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sb.toString());
            ps.setString(1, ca.getNome());
            ps.setString(2, ca.getDescricao());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    // Método Excluir

    public boolean excluir(Categorias cs) {
            
        PreparedStatement ps;
        Connection con = getConection();
        String sql = "DELETE FROM generos WHERE idgenero=?";
        StringBuffer sb = new StringBuffer(sql);
        
        try {
            ps = con.prepareStatement(sb.toString());
            //ps = con.prepareStatement(sql);
            ps.setInt(1, cs.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
    }
    }

}
