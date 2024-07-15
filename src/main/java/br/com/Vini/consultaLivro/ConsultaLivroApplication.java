package br.com.Vini.consultaLivro;

import br.com.Vini.consultaLivro.main.Main;
import br.com.Vini.consultaLivro.repository.RepositorioLivros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaLivroApplication implements CommandLineRunner{

	@Autowired
	private RepositorioLivros repositorioLivros;

	public static void main(String[] args) {
		SpringApplication.run(ConsultaLivroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main principal = new Main(repositorioLivros);
		principal.exibeMenu();
	}
}
