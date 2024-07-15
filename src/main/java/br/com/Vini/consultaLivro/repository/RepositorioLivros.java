package br.com.Vini.consultaLivro.repository;

import br.com.Vini.consultaLivro.model.Autor;
import br.com.Vini.consultaLivro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioLivros extends JpaRepository<Livro,Long> {

List<Livro> findAll();


    @Query("SELECT a FROM Livro l JOIN l.autor a WHERE :anoEscolhido BETWEEN a.anoNascimento AND COALESCE(a.anoMorte, :anoEscolhido)")
    List<Autor> auotresVivosPorAno(int anoEscolhido);

    @Query("SELECT DISTINCT a FROM Livro l JOIN l.autor a WHERE l.idiomas = :idioma")
    List<Autor> auotresPorIdioma(String idioma);

    @Query("SELECT a FROM Livro l JOIN l.autor a")
    List<Autor> autoresRegistrados();




}
