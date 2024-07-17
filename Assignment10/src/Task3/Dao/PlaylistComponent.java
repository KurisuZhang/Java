package Task3.Dao;

import Task3.Model.PlaylistInterface;

import java.util.ArrayList;
import java.util.List;

public class PlaylistComponent implements PlaylistInterface {
    private String name;
    private List<PlaylistInterface> components;

    public PlaylistComponent(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void add(PlaylistInterface component) {
        components.add(component);
    }

    public void remove(PlaylistInterface component) {
        components.remove(component);
    }

    public List<PlaylistInterface> getComponents() {
        return components;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name);
        for (PlaylistInterface component : components) {
            component.display(indent + "  ");
        }
    }
}

