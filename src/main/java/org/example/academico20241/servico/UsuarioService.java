package org.example.academico20241.servico;

import org.example.academico20241.model.Usuario;
import org.example.academico20241.model.UsuarioListagemDTO;
import org.example.academico20241.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio repositorio;
    
    public List<UsuarioListagemDTO> listar() {
        return repositorio.findAll().stream().map(UsuarioListagemDTO::new).toList();
    }
}
