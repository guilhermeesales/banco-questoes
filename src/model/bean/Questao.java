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
public class Questao {
    private int id;
    private int id_materia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_assunto() {
        return fk_assunto;
    }

    public void setFk_assunto(int fk_assunto) {
        this.fk_assunto = fk_assunto;
    }
    private String enunciado;
    private String resposta_a;
    private String resposta_b;
    private String resposta_c;
    private String resposta_d;
    private int fk_assunto;
    private int fk_prova;

    public int getFk_prova() {
        return fk_prova;
    }

    public void setFk_prova(int fk_prova) {
        this.fk_prova = fk_prova;
    }
    
    public int getCodigo() {
        return id;
    }

    public void setCodigo(int codigo) {
        this.id = codigo;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta_a() {
        return resposta_a;
    }

    public void setResposta_a(String resposta_a) {
        this.resposta_a = resposta_a;
    }

    public String getResposta_b() {
        return resposta_b;
    }

    public void setResposta_b(String resposta_b) {
        this.resposta_b = resposta_b;
    }

    public String getResposta_c() {
        return resposta_c;
    }

    public void setResposta_c(String resposta_c) {
        this.resposta_c = resposta_c;
    }

    public String getResposta_d() {
        return resposta_d;
    }

    public void setResposta_d(String resposta_d) {
        this.resposta_d = resposta_d;
    }
    
    public int getFkAssunto() {
        return fk_assunto;
        
    }
    
    public void setFkAssunto(int fk_assunto) {
        this.fk_assunto = fk_assunto;
  
    }
 
}
