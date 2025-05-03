package com.mateus.projeto.controller;

import com.mateus.projeto.dto.UsuarioDTO;
import com.mateus.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Anotação pessoal para revisão futura:

    Eu acredito que, devido ao fato de o DTO ser o objeto para transferência de dados
    com o frontend, todas as vezes que o modelo de usuário for mencionado nesse
    arquivo, a classe utilizada será UsuarioDTO.

    As coisas ficam mais confusas na camada service, onde uma análise deve ser feita
    para definir o tipo de classe adequada.
 */

// API REST para o frontend (anotação do spring)
@RestController
@RequestMapping(value = "/usuario") // Rota para usar os métodos da classe
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping // Anotação para o metodo GET
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos();
    }

    @PostMapping // Anotação para o metodo POST
    public void inserir(@RequestBody UsuarioDTO usuario) {
        /*
            @RequestBody diz que o metodo espera um corpo na requisição,
            e que esse corpo deve ser usado como argumento.
         */
        usuarioService.inserir(usuario);
    }

    @PutMapping // Anotação para o metodo PUT
    public UsuarioDTO atualizar(@RequestBody UsuarioDTO usuario) {
        return usuarioService.alterar(usuario);
    }

    @DeleteMapping("/{id}") // Anotação para o metodo DELETE
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        /*
            O ID vem pela URL, não por JSON.
            Nesse caso, o @RequestBody não é necessário

            /usuario/{id} [DELETE]

            O @RequestBody é substituído por @PathVariable, que recebe como
            argumento o nome da variável que será lida na URL.

            O @DeleteMapping recebe como argumento o "sublink" do link
            principal do controller, em que o ID é especificado.
         */
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
