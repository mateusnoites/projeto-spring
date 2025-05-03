package com.mateus.projeto.entity;

import com.mateus.projeto.dto.UsuarioDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    // ATRIBUTOS
    @Id // Annotation para definir o atributo identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia para o valor gerado automaticamente no ID
    private Long id;

    @Column(nullable = false) // Not nullable
    private String nome;

    @Column(nullable = false, unique = true) // Not nullable e Unique (retorna erro ao gerar row com o mesmo valor)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String email;

    // Construtor para copiar os atributos do usuário DTO para o usuário Entity
    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioEntity() {

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

    /* METODO EQUALS
       Compara um objeto passado como argumento com o objeto atual e retorna true ou false
    */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    /* METODO HASHCODE
       Usado mais para gestão interna, não é muito relevante
    */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
