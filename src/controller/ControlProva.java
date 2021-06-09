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
import model.bean.Prova;
import model.bean.Questao;
import model.bean.QuestaoProva;
import model.dao.ProvaDAO;
import model.dao.UsuarioDAO;


/**
 *
 * @author guilh
 */
public class ControlProva {
    
    public void cadastrarDadosQuestoes(int fk_questao, int fk_usuario, int fk_prova) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            String query = "INSERT INTO questao_prova(fk_questao, fk_usuario, fk_prova) VALUES(?, ?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, fk_questao);
            stmt.setInt(2, fk_usuario);
            stmt.setInt(3, fk_prova);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
            
            
            
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Houve algum erro. Log: " + error);
            
        } finally { 
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        
    }
    
    
    
    public void cadastrarProva(String enunciado, String resposta_a, String resposta_b, String resposta_c, String resposta_d, int fk_assunto, int fk_prova) {
        ProvaDAO pDAO = new ProvaDAO();
        Questao p = new Questao();
        p.setEnunciado(enunciado);
        p.setResposta_a(resposta_a);
        p.setResposta_b(resposta_b);
        p.setResposta_c(resposta_c);
        p.setResposta_d(resposta_d);
        p.setFkAssunto(fk_assunto);
        p.setFk_prova(fk_prova);
        pDAO.Create(p);
               
    }
    
    public ArrayList<QuestaoProva> listarQuestaoProvaByFkProva(int fk_prova) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<QuestaoProva> questoes_prova = new ArrayList<>();
        
        
        try {
            String query = "SELECT * FROM questao_prova WHERE fk_prova = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, fk_prova);
           
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                QuestaoProva questProva = new QuestaoProva();
                questProva.setId(rs.getInt("id"));
                questProva.setFk_questao(rs.getInt("fk_questao"));
                questProva.setFk_usuario(rs.getInt("fk_usuario"));
                questProva.setFk_prova(rs.getInt("fk_prova"));
                questoes_prova.add(questProva);
               
            }
           
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar. Log: " + error);
            
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return questoes_prova;
               
    }
    
    
    public ArrayList<Questao> listarQuestaoDaProvaById(int id) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Questao> questoes = new ArrayList<>();
        
        
        try {
            String query = "SELECT * FROM questoes WHERE fk_prova = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
           
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Questao quest = new Questao();
                quest.setId(rs.getInt("id"));
                quest.setEnunciado(rs.getString("enunciado"));
                quest.setResposta_a(rs.getString("resposta_a"));
                quest.setResposta_b(rs.getString("resposta_b"));
                quest.setResposta_c(rs.getString("resposta_c"));
                quest.setResposta_d(rs.getString("resposta_d"));
                quest.setFkAssunto(rs.getInt("fk_assunto"));
                quest.setFk_prova(rs.getInt("fk_prova"));
                questoes.add(quest);
                
            }
           
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar. Log: " + error);
            
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return questoes;
        
        
        
        
    }
    
     
    public void criarPacoteProva(String nome_prova, int fk_usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            String query = "INSERT INTO prova(nome_prova, fk_usuario) VALUES(?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, nome_prova);
            stmt.setInt(2, fk_usuario);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Prova Cadastrada com Sucesso!");
            
            
            
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Houve algum erro. Log: " + error);
            
        } finally { 
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
     
    }
            
    
    public ArrayList<Prova> listarProvas() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Prova> provas = new ArrayList<>();
        
        
        try {
            String query = "SELECT * FROM prova";
            stmt = con.prepareStatement(query);
           
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Prova prova = new Prova();
                prova.setId(rs.getInt("id"));
                prova.setNome_prova(rs.getString("nome_prova"));
                provas.add(prova);
                
                
            }
           
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar. Log: " + error);
            
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return provas;
        
        
      
    }
    
    public ArrayList<Prova> listarProvasPorUsuario(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Prova> provas = new ArrayList<>();
        
        
        try {
            String query = "SELECT * FROM prova WHERE fk_usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
           
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Prova prova = new Prova();
                prova.setId(rs.getInt("id"));
                prova.setNome_prova(rs.getString("nome_prova"));
                provas.add(prova);
                
                
            }
           
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao executar. Log: " + error);
            
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        
        return provas;
        
        
      
    }
            
             
    public ArrayList<Questao> consultarProvaPorId(int id) { 
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Questao> questoes = new ArrayList<>();
        
        try {
            stmt = con.prepareCall("SELECT * FROM questoes WHERE fk_assunto = ?");
            stmt.setInt(1, id);
            
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Questao quest = new Questao();
                quest.setId(rs.getInt("id"));
                quest.setEnunciado(rs.getString("enunciado"));
                quest.setResposta_a(rs.getString("resposta_a"));
                quest.setResposta_b(rs.getString("resposta_b"));
                quest.setResposta_c(rs.getString("resposta_c"));
                quest.setResposta_d(rs.getString("resposta_d"));
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
    
    
    public void apagarQuestao(int id) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM questoes WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve algum erro: " +ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            
        }
          
    }
    
    
    public void editarQuestao(int id, String enunciado, String resposta_a, String resposta_b, String resposta_c, String resposta_d) {
        ProvaDAO pDAO = new ProvaDAO();
        Questao questao = new Questao();
        questao.setEnunciado(enunciado);
        questao.setResposta_a(resposta_a);
        questao.setResposta_b(resposta_b);
        questao.setResposta_c(resposta_c);
        questao.setResposta_d(resposta_d);
        questao.setId(id);
        pDAO.Update(questao);
    }
    
    
    
    public void apagarProva(int id) {
        ProvaDAO pDAO = new ProvaDAO();
        pDAO.deleteProva(id);
        JOptionPane.showMessageDialog(null, "Prova apagada com sucesso");
    } 
    
    public void apagarQuestoes(int id) {
        ProvaDAO pDAO = new ProvaDAO();
        pDAO.deleteQuestoes(id);
        JOptionPane.showMessageDialog(null, "Questões apagadas com sucesso.");
    }
    

}

