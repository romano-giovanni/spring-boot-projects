public class Artist {
    private Integer id;
    private String name;
    private String[] genres;  // Array di stringhe per rappresentare i generi musicali
    private String country;

    // Costruttori
    public Artist() {}

    public Artist(Integer id, String name, String[] genres, String country) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.country = country;
    }

    // Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
