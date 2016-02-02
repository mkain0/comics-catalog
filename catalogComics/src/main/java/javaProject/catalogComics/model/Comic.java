package javaProject.catalogComics.model;

import java.util.ArrayList;
import java.util.List;

public class Comic {

    private int ISBN;
    private String title;
    private String description;
    private Genre genre;
    private List<Copy> copies = new ArrayList<>();

    public Comic() {

    }

    public Comic(int ISBN, String title, String description, Genre genre, List<Copy> copies) {
	this.ISBN = ISBN;
	this.title = title;
	this.description = description;
	this.genre = genre;
	this.copies = copies;
    }

    public int getId() {
	return ISBN;
    }

    public void setId(int id) {
	this.ISBN = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Genre getGenre() {
	return genre;
    }

    public void setGenre(Genre genre) {
	this.genre = genre;
    }

    public List<Copy> getCopies() {
	return copies;
    }

    public void setCopies(List<Copy> copies) {
	this.copies = copies;
    }

}
