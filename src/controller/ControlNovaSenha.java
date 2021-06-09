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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.UsuarioDAO;
import model.bean.Usuario;

/**
 *
 * @author guilh
 */
public class ControlNovaSenha {
        public boolean Read(String email) {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ArrayList<Usuario> users = new ArrayList<>();

            try {
                stmt = con.prepareCall("SELECT * FROM usuario WHERE email = ?");
                stmt.setString(1, email);
                
                rs = stmt.executeQuery();

                while(rs.next()) {
                    Usuario user = new Usuario();
                    user.setEmail(rs.getString("email"));
                       
                    users.add(user);
                }

            } catch(SQLException error) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, error);
                JOptionPane.showMessageDialog(null, "Houve algum erro ao executar esse codigo: " + error);

            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);

            }

            return users.size() > 0;
    }
        
        public String gerarNovaSenha() {
             Random random = new Random();
             String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ".toLowerCase();
             String armazenaChaves = "";
             int index = 0;

             for(int i = 0; i<=6; i++) {
                 index = random.nextInt(letras.length()); // 26 Caracteres
                 armazenaChaves += letras.substring(index, index + 1);
             }
            
            return armazenaChaves;
        }
        
        public boolean UpdateNovaSenha(Usuario user) {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            boolean check = false;

            try {
                stmt = con.prepareStatement("UPDATE usuario SET senha = ? WHERE email = ?");
                stmt.setString(1, user.getSenha());
                stmt.setString(2, user.getEmail());
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
              
}
