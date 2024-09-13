package org.example.academico20241.controlador;

import org.example.academico20241.model.UsuarioListagemDTO;
import org.example.academico20241.servico.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public List<UsuarioListagemDTO> listar() {
        return this.service.listar();
    }
    
}
