/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.dao.UsuarioDAO;

/**
 *
 * @author guilh
 */
public class ControlProfessor {
    
    
    public void cadastrarProfessor(String nome, String email, String senha) {
        // Objetos
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = new Usuario();
        
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        
        userDAO.Create(user);
 
    }
    
    public ArrayList<Usuario> consultarProfessor(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> users = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM usuario WHERE nome LIKE ? AND isadmin <> 1");
            stmt.setString(1, "%" + nome + "%");
           
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
    
    public void editarProfessor(Integer id, String nome, String email) {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = new Usuario();
        
        user.setNome(nome);
        user.setEmail(email);
        user.setId(id);
        
        userDAO.Update(user);
       
    }
    
    
    public void excluirProfessor(Integer id) {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = new Usuario();
        user.setId(id);
        userDAO.delete(user);
    }
}
