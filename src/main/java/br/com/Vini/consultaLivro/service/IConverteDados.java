package br.com.Vini.consultaLivro.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
