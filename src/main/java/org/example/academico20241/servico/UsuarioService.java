package org.example.academico20241.servico;

import org.example.academico20241.model.DadosUsuarioInserirDTO;
import org.example.academico20241.model.Usuario;
import org.example.academico20241.model.UsuarioListagemDTO;
import org.example.academico20241.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio repositorio;
    
    public List<UsuarioListagemDTO> listar() {
        return repositorio.findAll().stream().map(UsuarioListagemDTO::new).toList();
    }
    
    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.repositorio.findById(idUsuario).orElse(null);
    }
    
    public List<UsuarioListagemDTO> getIdosos() {
        return this.repositorio.getIdosos().stream().map(UsuarioListagemDTO::new).toList();
    }

    @Transactional
    public Usuario inserir(DadosUsuarioInserirDTO usuarioAInserir) {
        Usuario usuarioInserido = new Usuario(usuarioAInserir);
        this.repositorio.save(usuarioInserido);
        usuarioInserido.setNome(usuarioInserido.getNome() + "-Alterado");
        if (usuarioAInserir.idade() < 18) {
            throw new RuntimeException("Menor de idade!");
        }
        return usuarioInserido;
    }
    
    public Usuario atualizar(Usuario usuario) {
        return this.repositorio.save(usuario);
    }
    
    public void remover(Long id) {
        this.repositorio.deleteById(id);
    }
    
}
