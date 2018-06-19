/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Multigenero;
import modelo.Conection;

/**
 * Classe criada para
 * @author Bruno César A. Capelosa
 * @since 18/06/2018 as 19:55:35
 */
public class MultigeneroDAO extends Conection {
    
    
    
    
    
    public boolean salvar(Multigenero multi) {

        PreparedStatement ps;
        Connection con = getConection();

        String sql = "INSERT INTO multigenero(codgenero, codjogos)VALUES(?,?)";
        StringBuffer sb = new StringBuffer(sql);
        try {
            //ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, multi.getIdCategoria());
            ps.setInt(2, multi.getIdJogo());
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
    
    public boolean excluir(Multigenero multi) {
            
        PreparedStatement ps;
        Connection con = getConection();
        String sql = "DELETE FROM multigenero WHERE idmulti=?";
        StringBuffer sb = new StringBuffer(sql);
        
        try {
            ps = con.prepareStatement(sb.toString());
            //ps = con.prepareStatement(sql);
            ps.setInt(1, multi.getIdMulti());
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
    
    public boolean buscar(Multigenero multi) {

        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = getConection();
        
        String sql = "SELECT codgenero, codjogos FROM multigenero WHERE idmulti=?";
        StringBuffer sb = new StringBuffer(sql);

        try {
            ps = con.prepareStatement(sb.toString());
            //ps = con.prepareStatement(sql);
            ps.setInt(1, multi.getIdMulti());
            rs = ps.executeQuery();

            if (rs.next()) {
                multi.setIdCategoria(rs.getInt("codgenero"));
                multi.setIdJogo(rs.getInt("codjogos"));
                return true;
            }

            return false;
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
