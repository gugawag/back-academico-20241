package org.example.academico20241.model;

public record UsuarioListagemDTO(Long id, String nome, Integer idade) {
    
    public UsuarioListagemDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getIdade());
    }
}
