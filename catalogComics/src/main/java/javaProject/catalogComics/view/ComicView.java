package javaProject.catalogComics.view;

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
	    genre = comicService.findGenreBy(idGenre);
	    comicService.saveComic(new Comic(isbn, title, description, genre), quantity);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void modify() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify Comic------------------");
	System.out.println("ISBN: ");
	int isbn = scanner.nextInt();
	Comic comic;
	try {
	    comic = comicService.findComicBy(isbn);
	    System.out.println("Genre ID: ");
	    int idGenre = scanner.nextInt();
	    System.out.println("Title: ");
	    String title = scanner.nextLine();
	    System.out.println("Description: ");
	    String description = scanner.nextLine();
	    Genre genre = comicService.findGenreBy(idGenre);
	    comicService.updateComic(comic);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void delete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Delete Comic------------------");
	System.out.println("ISBN: ");
	int isbn = scanner.nextInt();
	comicService.deleteComic(isbn);
    }

    @Override
    public void viewAll() {
	comicService.findComics().forEach(comic -> System.out.println(comic.toString()));
    }

}
