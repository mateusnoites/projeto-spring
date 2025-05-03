package com.mateus.projeto.dto;

import com.mateus.projeto.entity.UsuarioEntity;
import jakarta.persistence.Entity;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

    // ATRIBUTOS
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;

    // Construtor para copiar os atributos do usuário Entity para o usuário DTO
    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioDTO() {

    }

    // GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
