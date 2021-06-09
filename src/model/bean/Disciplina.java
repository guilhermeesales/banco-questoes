/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author guilherme
 */
public class Disciplina {
    // Atributos da classe
    private int codigo;
    private String nome;

    
    // Métodos Get e Set 
    public int getCodigo() {
        return codigo;
    }
    
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
