/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Assunto;

/**
 *
 * @author guilhermesales
 */

public class AssuntoDAO {
   
    public void Create(Assunto as) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO assunto(nome, fk_disciplina) VALUES(?, ?)");
            stmt.setString(1, as.getNome());
            stmt.setInt(2, as.getFk_materia());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }

    public ArrayList<Assunto> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Assunto> assunto = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM assunto");
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Assunto as = new Assunto();
                
                as.setNome(rs.getString("nome"));
                as.setFk_materia(rs.getInt("fk_disciplina"));
                
                assunto.add(as);
                
            }
        
        } catch(SQLException error) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return assunto;
    }
    
    
    public boolean Update(Assunto as) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("UPDATE assunto SET nome = ? WHERE id = ?");
            stmt.setString(1, as.getNome());
            stmt.setInt(2, as.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
            check = true;
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        return check;
        
    }
    
    
    public Boolean delete(Assunto as) {
         Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("DELETE FROM assunto WHERE id = ?");
            stmt.setInt(1, as.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso!!");
            check = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        return check;
    }
    
    
    
}
