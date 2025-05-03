package com.mateus.projeto.repository;

import com.mateus.projeto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Criação de repositório (para operações no banco de dados, geralmente CRUD

    - No Spring Boot, o repositório é uma interface;
    - O JPA Repository pede a entidade que irá tratar e o tipo de seu atributo identificador (nesse caso, Long).
*/
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
