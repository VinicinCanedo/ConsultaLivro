package br.com.Vini.consultaLivro.model;

public enum Idiomas {
    ESPANHOL("es", "Espanhol"),
    INGLES("en", "Inglês"),
    FRANCES("fr", "Francês"),
    PORTUGUES("pt", "Português");

    private String idiomaApi;
    private String idiomaHere;

    Idiomas(String idiomaApi, String idiomaHere){
        this.idiomaApi = idiomaApi;
        this.idiomaHere = idiomaHere;
    }

    public static Idiomas fromString(String text) {
        for (Idiomas idiomas : Idiomas.values()) {
            if (idiomas.idiomaApi.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a string fornecida: " + text);
    }

    public static Idiomas fromPortugues(String text) {
        for (Idiomas idiomas : Idiomas.values()) {
            if (idiomas.idiomaHere.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a string fornecida: " + text);
    }

}
