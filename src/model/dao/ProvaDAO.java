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
import model.bean.Questao;

/**
 *
 * @author guilh
 */
public class ProvaDAO {
     public void Create(Questao quest) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO questoes(enunciado, resposta_a, resposta_b, resposta_c, resposta_d, fk_assunto, fk_prova) VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, quest.getEnunciado());
            stmt.setString(2, quest.getResposta_a());
            stmt.setString(3, quest.getResposta_b());
            stmt.setString(4, quest.getResposta_c());
            stmt.setString(5, quest.getResposta_d());
            stmt.setInt(6, quest.getFkAssunto());
            stmt.setInt(7, quest.getFk_prova());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
                    
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Houve algum erro"+ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }

    public ArrayList<Questao> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Questao> questoes = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM questoes");
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Questao quest = new Questao();
                quest.setEnunciado(rs.getString("enunciado"));
                quest.setResposta_a(rs.getString("item_A"));
                quest.setResposta_b(rs.getString("item_B"));
                quest.setResposta_c(rs.getString("item_C"));
                quest.setResposta_d(rs.getString("item_D"));
                quest.setFkAssunto(rs.getInt("fk_assunto"));
                questoes.add(quest);
                
            }
        
        } catch(SQLException error) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return questoes;
    }
    
    
    public boolean Update(Questao quest) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("UPDATE questoes SET enunciado = ?, resposta_a = ?, resposta_b = ?, resposta_c = ?, resposta_d = ? WHERE id = ?");
            stmt.setString(1, quest.getEnunciado());
            stmt.setString(2, quest.getResposta_a());
            stmt.setString(3, quest.getResposta_b());
            stmt.setString(4, quest.getResposta_c());
            stmt.setString(5, quest.getResposta_d());
            stmt.setInt(6, quest.getId());
            
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
    
    
    public void deleteProva(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM prova WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve algum erro: " +ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void deleteQuestoes(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM questoes WHERE fk_prova = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch(SQLException error) {
            // JOptionPane.showMessageDialog(null, "Houve algum erro. Log: " + error);
        
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }

    
}
