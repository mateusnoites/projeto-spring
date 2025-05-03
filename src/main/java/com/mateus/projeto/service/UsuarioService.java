package com.mateus.projeto.service;

import com.mateus.projeto.dto.UsuarioDTO;
import com.mateus.projeto.entity.UsuarioEntity;
import com.mateus.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotação para mostrar para o spring que essa é a camada service
public class UsuarioService {

    @Autowired // Instanciação automática
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        // Antes de fazer uma operação de map, a lista deve ser transformada em um stream.
        // Depois, deve ser transformada de volta em uma lista, para ser retornada na função.
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTONovo) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTONovo);

        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuarioEntity);
    }

    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}
