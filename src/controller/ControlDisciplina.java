/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.bean.Disciplina;
import model.dao.DisciplinaDAO;

/**
 *
 * @author guilh
 */
public class ControlDisciplina {
    
    public void cadastrarMateria(String nomeDaMateria) {
        DisciplinaDAO discDAO = new DisciplinaDAO(); 
        Disciplina disc = new Disciplina();
        
        disc.setNome(nomeDaMateria);
        discDAO.Create(disc);
        
    }
    
    
    
    public void editarMaterias(String nomeDaMateria, int id) {
        DisciplinaDAO discDAO = new DisciplinaDAO();
        Disciplina disc = new Disciplina();
        
        disc.setNome(nomeDaMateria);
        disc.setCodigo(id);
        discDAO.Update(disc);        
    }
    
    
    public boolean apagarMaterias(int id) {
        DisciplinaDAO discDAO = new DisciplinaDAO();
        Disciplina disc = new Disciplina();
        
        disc.setCodigo(id);
        return discDAO.delete(disc);
    }
    
}
