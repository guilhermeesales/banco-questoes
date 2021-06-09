/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author guilh
 */
public class QuestaoProva {
    private int id;
    private int fk_questao;
    private int fk_usuario;
    private int fk_prova;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_questao() {
        return fk_questao;
    }

    public void setFk_questao(int fk_questao) {
        this.fk_questao = fk_questao;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public int getFk_prova() {
        return fk_prova;
    }

    public void setFk_prova(int fk_prova) {
        this.fk_prova = fk_prova;
    }
}
