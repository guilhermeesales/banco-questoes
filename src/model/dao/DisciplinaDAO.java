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
import model.bean.Disciplina;
/**
 *
 * @author guilh
 */
public class DisciplinaDAO {
     public void Create(Disciplina disc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO disciplina(nome) VALUES(?)");
            stmt.setString(1, disc.getNome());
            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }

    public ArrayList<Disciplina> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Disciplina> users = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM disciplina");
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Disciplina disc = new Disciplina();
                disc.setCodigo(rs.getInt("id"));
                disc.setNome(rs.getString("nome"));
                
                users.add(disc);
                
            }
        
        } catch(SQLException error) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return users;
        
    }
    
    
    public boolean Update(Disciplina disc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("UPDATE disciplina SET nome = ? WHERE id = ?");
            stmt.setString(1, disc.getNome());
            stmt.setInt(2, disc.getCodigo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Matéria atualizada com sucesso!!");
            check = true;
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        return check;
        
    }
    
    
    public Boolean delete(Disciplina disc) {
         Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("DELETE FROM disciplina WHERE id = ?");
            stmt.setInt(1, disc.getCodigo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso!!");
            check = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        return check;
    }

    
}
