package br.com.Vini.consultaLivro.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAutor(@JsonAlias("name") String nome,
                         @JsonAlias("birth_year") String anoNascimento,
                         @JsonAlias("death_year") String anoMorte) {
}
