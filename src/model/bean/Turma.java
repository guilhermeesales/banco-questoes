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
public class Turma {
    private int codigo;
    private String nome;
    private int numDeAlunos;

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

    public int getNumDeAlunos() {
        return numDeAlunos;
    }

    public void setNumDeAlunos(int numDeAlunos) {
        this.numDeAlunos = numDeAlunos;
    }
    
    
    
}
