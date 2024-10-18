public class Album {
    private Integer id;
    private String title;
    private String releaseDate;
    private String[] trackTitles;  // Array di stringhe per rappresentare i titoli delle tracce
    private String artistName;

    // Costruttori
    public Album() {}

    public Album(Integer id, String title, String releaseDate, String[] trackTitles, String artistName) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trackTitles = trackTitles;
        this.artistName = artistName;
    }

    // Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getTrackTitles() {
        return trackTitles;
    }

    public void setTrackTitles(String[] trackTitles) {
        this.trackTitles = trackTitles;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
