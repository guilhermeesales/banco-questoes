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
import model.bean.Assunto;
import model.dao.AssuntoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author guilhermesales
 */
public class ControlAssunto {
    public void adicionarAssunto(String nome, int fk_materia) {
        Assunto as = new Assunto();
        AssuntoDAO asDAO = new AssuntoDAO();
        
        as.setNome(nome);
        as.setFk_materia(fk_materia);
        asDAO.Create(as);
        
        
    }
    
    public ArrayList<Assunto> listarPorMateria(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Assunto> assunto = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM assunto WHERE fk_disciplina = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            
            while(rs.next()) {
                Assunto as = new Assunto();
                
                as.setId(rs.getInt("id"));
                as.setNome(rs.getString("nome"));
                
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
    
    
    public void deletarAssunto(int id) {
        Assunto as = new Assunto();
        AssuntoDAO asDAO = new AssuntoDAO();
        
        as.setId(id);
        asDAO.delete(as);
    
    }
    
    
    
    public void editarAssunto(int id, String nome) {
        Assunto as = new Assunto();
        AssuntoDAO asDAO = new AssuntoDAO();
        
        as.setNome(nome);
        as.setId(id);
        
        asDAO.Update(as);
        
    } 
}
