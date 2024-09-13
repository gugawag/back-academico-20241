package org.example.academico20241.repositorio;

import org.example.academico20241.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepositorio
        extends JpaRepository<Usuario, Long> {
     
    public Usuario findByIdadeAndNome(Integer idade, String nome);
}
