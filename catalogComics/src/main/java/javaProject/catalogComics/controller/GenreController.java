package javaProject.catalogComics.controller;

import java.util.Scanner;

import javaProject.catalogComics.catalog.GenreCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Genre;

public class GenreController implements CrudController {

    @Override
    public String getTitle() {
	return "--------------------Genres----------------------";
    }

    @Override
    public void register() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Create Genre------------------");
	System.out.println("Description: ");
	String description = scanner.nextLine();

	int id = this.save(new Genre(description));
	System.out.println("Registered Successfully. Genre ID: " + id);
    }

    public int save(Genre genre) {
	return GenreCatalog.getInstance().save(genre);
    }

    @Override
    public void modify() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify Genre-------------------");
	System.out.println("Genre ID: ");
	int id = scanner.nextInt();
	Genre genre;
	try {
	    genre = this.findBy(id);
	    System.out.println("Description: ");
	    genre.setDescription(scanner.nextLine());

	    this.update(genre);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void update(Genre genre) {
	GenreCatalog.getInstance().update(genre);
    }

    public Genre findBy(int id) throws NotFoundException {
	return GenreCatalog.getInstance().findBy(id);
    }

    @Override
    public void delete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Delete Genre-------------------");
	System.out.println("Genre ID: ");
	int id = scanner.nextInt();
	// TODO Validate if there are comics with that genre.
	GenreCatalog.getInstance().delete(id);
    }

    @Override
    public void viewAll() {
	GenreCatalog.getInstance().findAll().forEach(genre -> System.out.println(genre.toString()));
    }

}
