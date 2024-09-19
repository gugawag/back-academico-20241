package org.example.academico20241.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer idade;
    private String senha;
    
    public Usuario() {
    }
    
    public Usuario(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public Usuario(DadosUsuarioInserirDTO dto) {
        this.nome = dto.nome();
        this.idade = dto.idade();
        this.senha = dto.senha();
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
