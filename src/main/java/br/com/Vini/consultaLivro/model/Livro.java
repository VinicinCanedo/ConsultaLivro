package br.com.Vini.consultaLivro.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LIVRO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Livro {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer numeroDownloads;
    @Enumerated(EnumType.STRING)
    private Idiomas idiomas;

    @Embedded
    private Autor autor;

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.autor = new Autor(dadosLivro.autor());
        this.idiomas =Idiomas.fromString(dadosLivro.idiomas().split(",")[0].trim());
        this.numeroDownloads = dadosLivro.numeroDownLoads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "----- LIVRO -----\n" +
                "Título: " + titulo +
                "\nIdiomas: " + idiomas +
                "\nNumero de Downloads: " + numeroDownloads +
                "\nAutor:" + autor +
                "----------------------"
                ;
    }
}

