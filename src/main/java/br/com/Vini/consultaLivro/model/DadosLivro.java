package br.com.Vini.consultaLivro.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") String autor,
                         @JsonAlias("languages") String idiomas,
                         @JsonAlias("download_count") Integer numeroDownLoads) {
}
