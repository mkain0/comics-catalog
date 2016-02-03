package javaProject.catalogComics.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.catalog.ComicCatalog;
import javaProject.catalogComics.catalog.GenreCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Comic;
import javaProject.catalogComics.model.Copy;
import javaProject.catalogComics.model.Genre;
import javaProject.catalogComics.util.CopyStatus;

public class ComicController implements CrudController {

    @Override
    public String getTitle() {
	return "-------------Collection of Comics---------------";
    }

    @Override
    public void register() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Create Comic------------------");
	System.out.println("Genre ID: ");
	int idGenre = scanner.nextInt();
	System.out.println("ISBN: ");
	int isbn = scanner.nextInt();
	System.out.println("Title: ");
	String title = scanner.nextLine();
	System.out.println("Description: ");
	String description = scanner.nextLine();
	System.out.println("Number of copies: ");
	int quantity = scanner.nextInt();

	Genre genre;
	try {
	    genre = GenreCatalog.getInstance().findBy(idGenre);
	    this.save(new Comic(isbn, title, description, genre), quantity);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    private void save(Comic comic, int quantity) {
	List<Copy> copies = new ArrayList<Copy>();
	for (int i = 1; i <= quantity; i++) {
	    copies.add(new Copy(i, CopyStatus.AVAILABLE, comic));
	}
	comic.setCopies(copies);
	ComicCatalog.getInstance().save(comic);
    }

    @Override
    public void modify() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify Comic------------------");
	System.out.println("ISBN: ");
	int isbn = scanner.nextInt();

	Comic comic;
	try {
	    comic = this.findBy(isbn);

	    System.out.println("Genre ID: ");
	    int idGenre = scanner.nextInt();
	    System.out.println("Title: ");
	    String title = scanner.nextLine();
	    System.out.println("Description: ");
	    String description = scanner.nextLine();

	    Genre genre = GenreCatalog.getInstance().findBy(idGenre);
	    this.update(comic);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void update(Comic comic) {
	ComicCatalog.getInstance().update(comic);
    }

    public Comic findBy(int isbn) throws NotFoundException {
	return ComicCatalog.getInstance().findBy(isbn);
    }

    @Override
    public void delete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Delete Comic------------------");
	System.out.println("ISBN: ");
	int isbn = scanner.nextInt();
	ComicCatalog.getInstance().delete(isbn);
    }

    @Override
    public void viewAll() {
	ComicCatalog.getInstance().findAll().forEach(comic -> System.out.println(comic.toString()));
    }

}
