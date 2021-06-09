/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


/**
 *
 * @author guilhermesales
 */
public class Assunto {
    private int id ;
    private String nome;
    private int fk_materia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFk_materia() {
        return fk_materia;
    }

    public void setFk_materia(int fk_materia) {
        this.fk_materia = fk_materia;
    }
    
    
    
    
}
