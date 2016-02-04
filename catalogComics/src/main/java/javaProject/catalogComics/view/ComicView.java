package javaProject.catalogComics.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Comic;
import javaProject.catalogComics.model.Genre;
import javaProject.catalogComics.service.ComicService;

public class ComicView implements CrudViewTemplate {

    private ComicService comicService = new ComicService();

    @Override
    public String getTitle() {
	return "-------------Collection of Comics---------------";
    }

    @Override
    public void register() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Create Comic------------------");
	System.out.print("Genre ID: ");
	int idGenre = scanner.nextInt();
	System.out.print("ISBN: ");
	int isbn = scanner.nextInt();
	System.out.print("Title: ");
	String title = scanner.next();
	System.out.print("Description: ");
	String description = scanner.next();
	System.out.print("Number of copies: ");
	int quantity = scanner.nextInt();
	Genre genre;
	try {
	    genre = comicService.findGenreBy(idGenre);
	    comicService.saveComic(new Comic(isbn, title, description, genre), quantity);
	    System.out.println("Registered Successfully.");
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void modify() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify Comic------------------");
	System.out.print("ISBN: ");
	int isbn = scanner.nextInt();
	Comic comic;
	try {
	    comic = comicService.findComicBy(isbn);
	    System.out.print("Genre ID: ");
	    int idGenre = scanner.nextInt();
	    System.out.print("Title: ");
	    String title = scanner.next();
	    System.out.print("Description: ");
	    String description = scanner.next();
	    Genre genre = comicService.findGenreBy(idGenre);
	    comicService.updateComic(comic);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void delete() throws InputMismatchException {
	System.out.println("------------------Delete Comic------------------");
	System.out.print("ISBN: ");
	int isbn = new Scanner(System.in).nextInt();
	comicService.deleteComic(isbn);
    }

    @Override
    public void viewAll() {
	comicService.findComics().forEach(comic -> System.out.println(comic.toString()));
    }

}
