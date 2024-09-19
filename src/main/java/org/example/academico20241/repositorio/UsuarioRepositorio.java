package org.example.academico20241.repositorio;

import org.example.academico20241.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepositorio
        extends JpaRepository<Usuario, Long> {
     
    public Usuario findByIdadeAndNome(Integer idade, String nome);
    
    @Query("FROM Usuario u where u.idade >= 18")
    public List<Usuario> getUsuariosMaioresIdade();
    
    @Query("FROM Usuario u where u.idade>=60")
    public List<Usuario> getIdosos();
}
