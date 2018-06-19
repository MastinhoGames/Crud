package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conection;
import modelo.Jogos;
import tela.Exclusao;

/**
 *
 * @author joao
 */
public class JogoDAO extends Conection {

    ////////////////////////////////////////
    //////////////////SALVAR////////////////
    ////////////////////////////////////////
    ////
    ////
    ////
    ///////////
    ////////
    //////
    ////
    //
    public boolean salvar(Jogos jo) {

        PreparedStatement ps;
        Connection con = getConection();

        String sql = "INSERT INTO jogoscadastro(nome, indicacao, preco, quantidade)VALUES(?,?,?,?)";
        StringBuffer sb = new StringBuffer(sql);
        try {
            //ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sb.toString());
            ps.setString(1, jo.getNome());
            ps.setString(2, jo.getIndicacao());
            ps.setFloat(3, jo.getPreco());
            ps.setInt(4, jo.getQuantidade());
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

    ////////////////////////////////////////
    //////////////////ALTERAR///////////////
    ////////////////////////////////////////
    ////
    ////
    ////
    ///////////
    ////////
    //////
    ////
    //
    public boolean alterar(Jogos jo) {

        PreparedStatement ps;
        Connection con = getConection();
        int linha = jo.getId();

        String sql = "UPDATE  jogoscadastro SET nome=?, indicacao=?, preco=?, quantidade=? WHERE id="+linha;
 StringBuffer sb = new StringBuffer(sql);
        try {
            ps = con.prepareStatement(sb.toString());
            //ps = con.prepareStatement(sql);
            ps.setString(1, jo.getNome());
            ps.setString(2, jo.getIndicacao());
            ps.setFloat(3, jo.getPreco());
            ps.setInt(4, jo.getQuantidade());
            //ps.setInt(5, jo.getId());
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

    ////////////////////////////////////////
    //////////////////EXCLUIR///////////////
    ////////////////////////////////////////
    ////
    ////
    ////
    ///////////
    ////////
    //////
    ////
    //
    public boolean excluir(Jogos jo) {
            
        PreparedStatement ps;
        Connection con = getConection();
        String sql = "DELETE FROM jogoscadastro WHERE id=?";
        StringBuffer sb = new StringBuffer(sql);
        
        try {
            ps = con.prepareStatement(sb.toString());
            //ps = con.prepareStatement(sql);
            ps.setInt(1, jo.getId());
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

    ////////////////////////////////////////
    //////////////////BUSCAR////////////////
    ////////////////////////////////////////
    ////
    ////
    ////
    ///////////
    ////////
    //////
    ////
    //
    public boolean buscar(Jogos jo) {

        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = getConection();

        String sql = "SELECT nome, indicacao, preco, quantidade FROM jogoscadastro WHERE id=?";
        StringBuffer sb = new StringBuffer(sql);

        try {
            ps = con.prepareStatement(sb.toString());
            //ps = con.prepareStatement(sql);
            ps.setInt(1, jo.getId());
            rs = ps.executeQuery();

            if (rs.next()) {

                jo.setNome(rs.getString("nome"));
                jo.setIndicacao(rs.getString("indicacao"));
                jo.setPreco(Float.parseFloat(rs.getString("preco")));
                jo.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
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
    
    public List<Jogos> Listar() throws SQLException {

        Connection con = getConection();
         PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Jogos> jogo2 = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM jogoscadastro");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Jogos jogo = new Jogos();
                
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setIndicacao(rs.getString("indicacao"));
                jogo.setPreco(rs.getInt("preco"));
                jogo.setQuantidade(rs.getInt("quantidade"));
                jogo2.add(jogo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return jogo2;

    }

}
