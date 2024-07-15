package br.com.Vini.consultaLivro.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    private Long id;
    private String nome;
    private String anoNascimento;
    private String anoMorte;

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
