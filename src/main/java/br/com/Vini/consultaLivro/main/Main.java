package br.com.Vini.consultaLivro.main;

import br.com.Vini.consultaLivro.model.Autor;
import br.com.Vini.consultaLivro.model.DadosLivro;
import br.com.Vini.consultaLivro.model.Livro;
import br.com.Vini.consultaLivro.repository.RepositorioLivros;
import br.com.Vini.consultaLivro.service.ConsumoApi;
import br.com.Vini.consultaLivro.service.ConverteDados;

import java.util.*;

public class Main {
Scanner sc = new Scanner(System.in);
private final String URL_BASE = "https://gutendex.com/books?search=";
private ConsumoApi consumo = new ConsumoApi();
private ConverteDados conversor = new ConverteDados();
private List<DadosLivro> dadosLivro = new ArrayList<>();

private RepositorioLivros repositorioLivros;
private List<Livro> livros = new ArrayList<>();
private Optional<Livro> buscaLivro;


    public Main(RepositorioLivros repositorioLivros) {this.repositorioLivros = repositorioLivros;}


    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 0){
            var menu = """
                    ----------------
                    Escolha o número de sua opção:
                    1 - Buscar livro pelo Título
                    2 - Listar livros Registrados 
                    3 - Listar autores Registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar autores em um determinado idioma
                    
                    0 - Sair 
                    """;
            String endereco;
            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    ListarLivrosRegistrados();
                    break;
                case 3:
                    ListarAutoresRegistrados();
                    break;
                case 4:
                    ListarAutoresVivosPorAno();
                    break;
                case 5:
                    ListarAutoresPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...\nAté a próxima consulta");
                    break;

            }




        }

    }


    private void buscarLivroPorTitulo() {  // Esse método registra livros no Banco de Dados
        DadosLivro dados = pesquisandoDadosDoLivro();
        Livro livro = new Livro(dados);
        dadosLivro.add(dados);  // Depois que se declara uma vez, não é mais necessário
        repositorioLivros.save(livro);
        System.out.println(dados);



    }

    private DadosLivro pesquisandoDadosDoLivro() { // Esse método pesquisa o livro na API
        System.out.println("Digite o nome do livro desejado: ");
        var endereco = sc.nextLine();
        var json = consumo.obterDados(URL_BASE + endereco.replace(" ", "+"));
        DadosLivro dados = conversor.obterDados(json, DadosLivro.class);
        return dados;
    }


    private void ListarLivrosRegistrados() {   // Esse método Lista todos os livros registrados no Banco de Dados
        livros = repositorioLivros.findAll();
        livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .forEach(System.out::println);
    }

    private void ListarAutoresRegistrados() {
    List<Autor> autores = repositorioLivros.autoresRegistrados();
    autores.stream()
            .sorted(Comparator.comparing(Autor::getNome))
            .forEach(System.out::println);

    }

    private void ListarAutoresVivosPorAno() {
        buscarLivroPorTitulo() ;
        if(buscaLivro.isPresent()){
            System.out.println("Digite o ano limite de lançamento");
            var anoEscolhido = sc.nextInt();
            sc.nextLine();

            List<Autor> anoAutor = repositorioLivros.auotresVivosPorAno(anoEscolhido);
            anoAutor.forEach(System.out::println);
        }
    }

    private void ListarAutoresPorIdioma() {
        buscarLivroPorTitulo();
        if (buscaLivro.isPresent()) {
            System.out.println("Digite o ano limite de lançamento");
            var idioma = sc.nextLine();
            sc.nextLine();

            List<Autor> anoAutor = repositorioLivros.auotresPorIdioma(idioma);
            anoAutor.forEach(System.out::println);
        }
    }


}
