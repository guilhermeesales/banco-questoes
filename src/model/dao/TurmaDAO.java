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
import model.bean.Turma;

public class TurmaDAO {
     public void Create(Turma tur) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Turma(nome, numAlunos) VALUES(?, ?)");
            stmt.setString(1, tur.getNome());
            stmt.setInt(2, tur.getNumDeAlunos());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }

    public boolean Read(String email, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Turma tur = new Turma();
        ArrayList<Turma> turmas = new ArrayList<>();
        boolean check = false;
        
        try {
            stmt = con.prepareCall("SELECT * FROM turma");
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                check = true;
                
            }
        
        } catch(SQLException error) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return check;
    }
    
    
    public boolean Update(Turma tur) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("UPDATE turma SET nome = ?, numAlunos = ?");
            stmt.setString(1, tur.getNome());
            stmt.setInt(2, tur.getNumDeAlunos());
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
    
    
    public Boolean delete(Turma tur) {
         Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("DELETE FROM turma WHERE id = ?");
            stmt.setInt(1, tur.getCodigo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
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
