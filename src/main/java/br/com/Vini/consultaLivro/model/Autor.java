package br.com.Vini.consultaLivro.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String anoNascimento;
    private String anoMorte;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();


    public Autor(String nome){
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Livro> getLivros() {return livros;}

    public void setLivros(List<Livro> livros) {this.livros = livros;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(String anoMorte) {
        this.anoMorte = anoMorte;
    }


}
