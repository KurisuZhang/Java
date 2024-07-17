package Task3.Model;

import java.time.LocalDate;

public class Podcast {
    private String title;
    private String celebrity;
    private LocalDate publishDate;

    public Podcast(String title, String celebrity, LocalDate publishDate) {
        this.title = title;
        this.celebrity = celebrity;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getCelebrity() {
        return celebrity;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "title='" + title + '\'' +
                ", celebrity='" + celebrity + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}

