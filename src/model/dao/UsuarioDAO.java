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
import model.bean.Usuario;

/**
 *
 * @author guilherme
 */
public class UsuarioDAO {
    
    public void Create(Usuario user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario(nome, email, senha) VALUES(?, ?, ?)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso");
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    
    public ArrayList<Usuario> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> users = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM usuario");
           
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Usuario user = new Usuario();
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setIsadmin(rs.getInt("isadmin"));    
                user.setId(rs.getInt("id"));
                users.add(user);
            }
        
        } catch(SQLException error) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return users;
        
    }

    public ArrayList<Usuario> Read(String email, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> users = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Usuario user = new Usuario();
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setIsadmin(rs.getInt("isadmin"));  
                user.setId(rs.getInt("id"));
                users.add(user);
            }
        
        } catch(SQLException error) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return users;
        
    }
    
    
    public boolean Update(Usuario user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("UPDATE usuario SET nome = ?, email = ? WHERE id = ?");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
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
    
    
    public Boolean delete(Usuario user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
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