/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author guilh
 */
public class ControlLogin {
    public boolean fazerLogin(String login, String senha) {
        UsuarioDAO userDAO = new UsuarioDAO();
        ArrayList<Usuario> user = userDAO.Read(login, senha);
        return user.size() > 0;   
    } 
}
