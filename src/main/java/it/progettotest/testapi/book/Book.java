package it.progettotest.testapi.book;

public class Book {
    public  int id;
    private String autore;
    private String titolo;
    private String argomento;

    public Book(int id, String autore, String titolo, String argomento) {
        this.id = id;
        this.autore = autore;
        this.titolo = titolo;
        this.argomento = argomento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }
}
