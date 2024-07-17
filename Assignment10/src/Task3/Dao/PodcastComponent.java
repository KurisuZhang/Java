package Task3.Dao;

import Task3.Model.Podcast;
import Task3.Model.PlaylistInterface;

import java.util.Collections;
import java.util.List;

public class PodcastComponent implements PlaylistInterface {
    private Podcast podcast;

    public PodcastComponent(Podcast podcast) {
        this.podcast = podcast;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- Podcast: " + podcast.getTitle() + " - " + podcast.getCelebrity());
    }
}

