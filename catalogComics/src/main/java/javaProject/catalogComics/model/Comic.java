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

    public Comic(int ISBN, String title, String description, Genre genre) {
	this.ISBN = ISBN;
	this.title = title;
	this.description = description;
	this.genre = genre;
    }

    public int getIsbn() {
	return ISBN;
    }

    public void setIsbn(int ISBN) {
	this.ISBN = ISBN;
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

    @Override
    public String toString() {
	return "ISBN: " + ISBN + ", Title: " + title + ", Description: " + description;
    }

}
