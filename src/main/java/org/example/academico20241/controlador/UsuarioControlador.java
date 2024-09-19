package org.example.academico20241.controlador;

import jakarta.validation.Valid;
import org.example.academico20241.model.DadosUsuarioInserirDTO;
import org.example.academico20241.model.Usuario;
import org.example.academico20241.model.UsuarioListagemDTO;
import org.example.academico20241.servico.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public List<UsuarioListagemDTO> listar(@RequestParam(value = "idadeMinima", required = false) Integer idadeMinima) {
        if (Objects.nonNull(idadeMinima) && idadeMinima>=60) {
            return this.service.getIdosos();
        }
        return this.service.listar();
    }
    
    @GetMapping("/idosos")
    public List<UsuarioListagemDTO> getIdosos() {
        return this.service.getIdosos();
    }
    
    @GetMapping("/{id}")
    public Usuario getUsuarioPorId(@PathVariable("id") Long idUsuario) {
     return this.service.getUsuarioPorId(idUsuario);
    }
    
    @PostMapping
    public Usuario inserir(@RequestBody @Valid DadosUsuarioInserirDTO usuario){
        return this.service.inserir(usuario);
    }
    
    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario){
        return this.service.atualizar(usuario);
    }
    
    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") Long id) {
        this.service.remover(id);
    }
    
    
}
